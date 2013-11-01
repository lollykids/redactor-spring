package org.springframework.mail;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

import com.lollykids.biz.service.MailService;

/**
 * @author hdlee
 */
public class MailServiceTest {
	/**
	 * @param args
	 */
	@SuppressWarnings("resource")
	public static void main(String[] args) {
		ApplicationContext context = new FileSystemXmlApplicationContext("/web/WEB-INF/redactor-servlet.xml");
		MailService mail = (MailService) context.getBean("mailService");
		mail.sendMail("lokeshgupta1981@gmail.com", "Test Subject", "Testing body");
	}
}
