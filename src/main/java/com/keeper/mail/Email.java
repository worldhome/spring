package com.keeper.mail;

import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.MimeMailMessage;

public class Email {
	private MailSender sender;

	public void sendEmail() {
		SimpleMailMessage message = new SimpleMailMessage();
		message.setFrom("xyzmmtt@sina.com");
		message.setTo("1837890880@qq.com");
		message.setSubject("惺惺惜惺惺想");
		message.setText("Hello! 中文!");
		sender.send(message);
	}
	public void sendEmail1() {
		MimeMailMessage message = new MimeMailMessage();
		message.setFrom("xyzmmtt@sina.com");
		message.setTo("1837890880@qq.com");
		message.setSubject("惺惺惜惺惺想");
		message.setText("Hello! 中文!");
		sender.send(message);
	}
	public MailSender getSender() {
		return sender;
	}

	public void setSender(MailSender sender) {
		this.sender = sender;
	}

}
