package com.dsmarket.server.controllers;

import com.dsmarket.server.dto.request.RegisterRequest;
import com.dsmarket.server.dto.response.RegisterResponse;
import com.dsmarket.server.dto.request.ValidateRequest;
import com.dsmarket.server.dto.response.ValidateResponse;
import com.dsmarket.server.services.mail.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/accounts")
public class AccountController 
{
	
	@Autowired
	MessageService ms = new MessageServiceImpl();
	@PostMapping("/validate")
	@ResponseBody
	public ValidateResponse validateEmail(@RequestBody ValidateRequest val) throws Exception
	{
		// TODO: check from in memory db 
		
		if ( String.valueOf(val.getEmail().hashCode()).equals(val.getKey())) 
		{
			return ValidateResponse.builder().status("201").reason("").build();
		}
		return ValidateResponse.builder().status("404").reason("Key does not match").build();
		
		// if right then put in db
		// else return error
	}
	
	@PostMapping("/register")
	@ResponseBody
	public RegisterResponse register(@RequestBody RegisterRequest reg) throws Exception
	{
		// in memory db
		String[] result = ms.sendMessage(reg.getEmail());
		//
		
		return RegisterResponse
				.builder()
				.status(result[1])
				.reason(result[2])
				.build();
	}
}
