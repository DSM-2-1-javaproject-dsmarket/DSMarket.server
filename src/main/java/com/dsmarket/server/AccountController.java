package com.dsmarket.server;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/accounts")
public class AccountController 
{
	
	@Autowired
	MessageInterface mi = new SendEmail();
	@PostMapping("/validate")
	@ResponseBody
	public String validateEmail(@RequestBody ValidateParam dest) throws Exception
	{
		String key = mi.sendMessage(dest.getDest());
		String ret = 
				"{\n" + 
				"   \"id\":\"sample_id\",\n" + 
				"   \"pw\":\"sample_pw\",\n" + 
				"   \"email\":\""+dest.getDest()+"\",\n" + 
				"   \"key\":\""+key+"\"\n" + 
				"}";
		
		return ret;
	}
	
	@PostMapping("/register")
	@ResponseBody
	public String register(@RequestBody RegisterParam reg) throws Exception
	{
		String ret = 
				"{\n" + 
				"   \"id\":\""+reg.getId()+"\",\n" + 
				"   \"pw\":\""+reg.getPw()+"\",\n" + 
				"   \"nickname\":\""+reg.getNickname()+"\",\n" + 
				"   \"email\":\""+reg.getEmail()+"\"\n" + 
				"}";
		
		return ret;
	}
}
