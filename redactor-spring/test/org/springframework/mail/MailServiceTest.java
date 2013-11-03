package org.springframework.mail;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.lollykids.biz.model.Mail;
import com.lollykids.biz.model.User;
import com.lollykids.biz.service.MailService;

/**
 * @author hdlee
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:web/WEB-INF/redactor-servlet.xml")
public class MailServiceTest {
	
	@Autowired MailService mailService;
	/**
	 * @param args
	 */
	//@Test
	public void sendMail(){
		mailService.sendMail("future.fringe@gmail.com", "Test Subject", "<b>sdsds</b>");
	}
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Test
	public void sendMailUsers(){
		List users = new ArrayList();
		users.add(new User("future.fringe@gmail.com"));
		users.add(new User("dev.fringe@gmail.com"));
		Mail mail = new Mail("Test", "<a>content</a>");
		mailService.sendMail(mail, users);
	}
}
