package com.lollykids.biz.service;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

/**
 * @author hdlee
 */
@Service
public class MailService {
    @Autowired private  JavaMailSender mailSender;
 
    /**
     * @param to
     * @param subject
     * @param body
     */
    public void sendMail(final String to, String subject, String body) {
    	 MimeMessage message = mailSender.createMimeMessage();
		try {
			MimeMessageHelper helper = new MimeMessageHelper(message, true, "UTF-8");
			helper.setTo(to);
			helper.setSubject(subject);
			message.setContent(body, "text/html");
			mailSender.send(message);
		} catch (MessagingException e) {
			e.printStackTrace();
		}
        mailSender.send(message);
    }
}
