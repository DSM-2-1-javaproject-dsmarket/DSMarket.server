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
	        message.setSubject("�븶�� �̸��� ���� �׽�Ʈ");
	        
	        String msg= 	
	        		"<h1> �븶�� �̸��� ���� �׽�Ʈ�Դϴ�.</h1><br>"
	       		+	"<p>���� �ڵ��<p><br>"
	       		+	"<strong>"+key+"</strong><br> "
				+	"<p>�Դϴ�.<p><br>";
	       	
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
