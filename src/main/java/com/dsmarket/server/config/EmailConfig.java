package com.dsmarket.server.config;

import java.util.Properties;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;

@Configuration
public class EmailConfig {
	
	private final String mailHost;
	private final String encoding;
	
	private final int port;
	private final int socketPort;
	private final boolean fallback;
	
	private final boolean auth;
	private final boolean starttls;
	private final boolean starttls_req;
	private final String socketClass;
	
	private final String id;
	private final String password;
	
	public EmailConfig(
		@Value("${mail.smtp.host}") String mailHost,
		@Value("${mail.smtp.encoding}") String encoding,
		@Value("${mail.smtp.port}") int port,
		@Value("${mail.smtp.socketFactory.port}") int socketPort,
		@Value("${mail.smtp.socketFactory.fallback}") boolean fallback,
		@Value("${mail.smtp.auth}") boolean auth,
		@Value("${mail.smtp.startTls.enable}") boolean starttls,
		@Value("${mail.smtp.startTls.required}") boolean starttls_req,
		@Value("${mail.smtp.socketFactory.class}") String socketClass,
		@Value("${AdminMail.id}") String id,
		@Value("${AdminMail.password}") String password
			) {
		this.mailHost = mailHost;
		this.encoding = encoding;
		
		this.port = port;
		this.socketPort = socketPort;
		this.fallback = fallback;
		
		this.auth = auth;
		this.starttls = starttls;
		this.starttls_req = starttls_req;
		this.socketClass = socketClass;
		
		this.id = id;
		this.password = password;
	}
    
    
	 @Bean
	 public JavaMailSender javaMailService() {
	       JavaMailSenderImpl javaMailSender = new JavaMailSenderImpl();
	       javaMailSender.setHost(mailHost);
	       javaMailSender.setUsername(id);
	       javaMailSender.setPassword(password);
	       javaMailSender.setPort(port);
	       javaMailSender.setJavaMailProperties(getMailProperties());       
	       javaMailSender.setDefaultEncoding(encoding);
	       return javaMailSender;
	 }
	 private Properties getMailProperties()
		{
			Properties pt = new Properties();
			pt.put("mail.smtp.socketFactory.port", socketPort); 
			pt.put("mail.smtp.auth", auth);
		    pt.put("mail.smtp.starttls.enable", starttls); 
		    pt.put("mail.smtp.starttls.required", starttls_req);
		    pt.put("mail.smtp.socketFactory.fallback",fallback);
		    pt.put("mail.smtp.socketFactory.class", socketClass);
			return pt;
		}
	    

}
