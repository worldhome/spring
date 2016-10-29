package com.keeper.mail;

import java.io.File;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;

public class Email {
	private JavaMailSender sender;

	public void sendEmail() {
		SimpleMailMessage message = new SimpleMailMessage();
		message.setFrom("xyzmmtt@sina.com");
		message.setTo("1837890880@qq.com");
		message.setSubject("惺惺惜惺惺想");
		message.setText("Hello! 中文!");
		sender.send(message);
	}

	public void sendEmail1() throws MessagingException {
		MimeMessage message = sender.createMimeMessage();
		MimeMessageHelper helper = new MimeMessageHelper(message,true,"utf-8");
		helper.setFrom("xyzmmtt@sina.com");
		helper.setTo("1837890880@qq.com");
		helper.setSubject("123");
		helper.setText("<html><body><img src='cid:identifier1234.jpg'>收到了吗</body></html>",true);
		FileSystemResource res = new FileSystemResource(new File("C:/Users/CP/Desktop/FSC/QQ图片20160926102437.jpg"));
		helper.addInline("identifier1234.jpg", res);
		helper.addAttachment("identifier1234.jpg", res);
		sender.send(message);
	}

	public JavaMailSender getSender() {
		return sender;
	}

	public void setSender(JavaMailSender sender) {
		this.sender = sender;
	}

}
