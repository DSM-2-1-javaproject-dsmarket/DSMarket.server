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
		String ret = 
				"{" + 
				"\"id\":\"sample_id\"," + 
				"\"pw\":\"sample_pw\"," + 
				"\"email\":\""+dest.getDest()+"\"," + 
				"\"key\":\""+1+"\"" + 
				"}";
		
		return ret;
	}
	
	@PostMapping("/register")
	@ResponseBody
	public String register(@RequestBody RegisterParam reg) throws Exception
	{
		// TODO: connect to db
		int key = mi.sendMessage(reg.getEmail());
		String ret = 
				"{" + 
				"\"status\":\""+key+"\"" + 
				"}";
		
		return ret;
	}
}
