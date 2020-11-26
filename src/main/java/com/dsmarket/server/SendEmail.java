package com.dsmarket.server;

import java.util.Random;

import javax.mail.Message.RecipientType;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailException;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class SendEmail implements MessageInterface{
	
	@Autowired
	JavaMailSender emailSender;
	
	private String key = createKey();
	
	 private MimeMessage createMessage(String dest) throws Exception
	 {

		 MimeMessage message = emailSender.createMimeMessage();
		 	
		 	message.addRecipients(RecipientType.TO, dest);
	        message.setSubject("대마켓 이메일 인증 테스트");
	        
	        String msg= 	
	        		"<h1> 대마켓 이메일 인증 테스트입니다.</h1><br>"
	       		+	"<p>인증 코드는<p><br>"
	       		+	"<strong>"+key+"</strong><br> "
				+	"<p>입니다.<p><br>";
	       	
	        message.setText(msg, "utf-8", "html");
	        message.setFrom(new InternetAddress("kku3472@gmail.com","DaeMarket"));
	        
	        return message;
	    }

		public static String createKey() 
		{
			Random rnd = new Random();
			int code = rnd.nextInt(89999999) + 10000000;
			return Integer.toString(code);
		}

	
	@Override
	public int sendMessage(String dest) throws Exception 
	{
		MimeMessage message = createMessage(dest);
		        try 
		        {
		        	emailSender.send(message);
		        	System.out.println("Email sent!");
		        }
		        catch(MailException ex) 
		        {
		        	return 404;
		        }
		        return 201;
	}
}
