package com.lollykids.biz.service;

import java.util.List;

import javax.mail.Message.RecipientType;
import javax.mail.MessagingException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import com.lollykids.biz.model.Mail;
import com.lollykids.biz.model.User;

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

	public void sendMail(Mail mail, List<User> users) {
   	 MimeMessage message = mailSender.createMimeMessage();
		try {
			MimeMessageHelper helper = new MimeMessageHelper(message, true, "UTF-8");
			helper.setSubject(mail.getSubject());
			message.setContent(mail.getContent(), "text/html");

		InternetAddress[] addressTo = new InternetAddress[users.size()];
        for (int i = 0; i < users.size(); i++)
        {
        	String email = ((User)users.get(i)).getEmail();
            addressTo[i] = new InternetAddress(email);
        }
        message.setRecipients(RecipientType.TO, addressTo); 
		} catch (MessagingException e) {
			e.printStackTrace();
		}
	       mailSender.send(message);	
	}
}
