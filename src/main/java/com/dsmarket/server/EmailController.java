package com.dsmarket.server;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/accounts")
public class EmailController 
{
	 @Autowired
	 MessageInterface mi = new SendEmail();
		@PostMapping("/validate")
		@ResponseBody
		public String emailConfirm(@RequestParam("to") String dest) throws Exception
		{
			String key = mi.sendMessage(dest);
			String ret = 
					"{\n" + 
					"   \"id\":\"sample_id\",\n" + 
					"   \"pw\":\"sample_pw\",\n" + 
					"   \"email\":\""+dest+"\",\n" + 
					"   \"key\":\""+key+"\"\n" + 
					"}";
			
			return ret;
		}
}
