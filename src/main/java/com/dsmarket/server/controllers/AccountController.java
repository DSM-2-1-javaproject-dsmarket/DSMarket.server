package com.dsmarket.server.controllers;

import com.dsmarket.server.dto.request.RegisterRequest;
import com.dsmarket.server.dto.response.RegisterResponse;
import com.dsmarket.server.dto.request.ValidateRequest;
import com.dsmarket.server.dto.response.ValidateResponse;
import com.dsmarket.server.entities.account.Account;
import com.dsmarket.server.entities.account.repository.AccountRepository;
import com.dsmarket.server.services.mail.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/accounts")
public class AccountController 
{
	
	@Autowired
	private MessageService ms = new MessageServiceImpl();
	
	@Autowired
	private AccountRepository ar;
	
	@Autowired
	private RedisTemplate<String, Object> rt;
	
	@PostMapping("/validate")
	@ResponseBody
	public ValidateResponse validateEmail(@RequestBody ValidateRequest val) throws Exception
	{
		// TODO: check from in memory db 
		String match = (String) rt.opsForValue().get(val.getEmail());
		System.out.println(match);
		
		if (match == null || !match.equals(val.getKey())) 
		{
			return ValidateResponse.builder().status("404").reason("Key does not match").build();
		}
		else
		{
			RegisterRequest reg = (RegisterRequest) rt.opsForValue().get(match);
			ar.save(Account
					.builder()
					.id(reg.getId())
					.password(reg.getPassword())
					.nickname(reg.getNickname())
					.email(reg.getEmail())
					.build());
			return ValidateResponse.builder().status("201").reason("").build();
		}
		// if right then put in db
		// else return error
	}
	
	@PostMapping("/register")
	@ResponseBody
	public RegisterResponse register(@RequestBody RegisterRequest reg) throws Exception
	{
		String[] result = ms.sendMessage(reg.getEmail());
		if (result[1].equals("201")) 
		{
			rt.opsForValue().set(reg.getEmail(), result[0]);
			rt.opsForValue().set(result[0], reg);
		}
		
		return RegisterResponse
				.builder()
				.status(result[1])
				.reason(result[2])
				.build();
	}
}
