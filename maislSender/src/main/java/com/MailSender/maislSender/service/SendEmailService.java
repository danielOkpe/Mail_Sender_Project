package com.MailSender.maislSender.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class SendEmailService {
	
	@Autowired
	private JavaMailSender sender;
	
	public void sendMail(String toEmailAdd, String subject, String message) {
		SimpleMailMessage smm = new SimpleMailMessage();
		smm.setFrom("daniel.okpe234@gmail.com");
		smm.setTo(toEmailAdd);
		smm.setSubject(subject);
		smm.setText(message);
		sender.send(smm);
		
		System.out.println("Email sendMail successfully !!");
	}

}
