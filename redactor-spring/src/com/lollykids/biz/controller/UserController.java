package com.lollykids.biz.controller;

import java.io.IOException;
import java.io.InputStream;

import org.beanio.BeanReader;
import org.beanio.BeanReaderIOException;
import org.beanio.StreamFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.lollykids.biz.model.Mail;
import com.lollykids.biz.model.User;
import com.lollykids.biz.service.MailService;
import com.lollykids.biz.service.ResourceService;

@Controller
public class UserController {

	 @Autowired private MailService mailService;
	 @Autowired private ResourceService resourceService;

	@RequestMapping(value = "/test", method = RequestMethod.POST, produces = "application/json", headers = { "Content-type=application/json" })
	public @ResponseBody
	Mail postAll(@RequestBody final Mail mail) {
		System.out.println(mail);
		mailService.sendMail("future.fringe@gmail.com", "Test 한글 1231233ㄴSubject", mail.getContent());
		StreamFactory factory = StreamFactory.newInstance();
		try {
			Resource resource = resourceService.getResource("classpath:users.xml");
			InputStream is = resource.getInputStream();
			factory.load(is);
			Resource resource2 = resourceService.getResource("classpath:input.csv");
			BeanReader in = factory.createReader("users", resource2.getFile());
			Object record = null;
			while ((record = in.read()) != null) {
				if ("user".equals(in.getRecordName())) {
					User user = (User) record;
				//	System.out.println(user);
				}
			}
			in.close();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (BeanReaderIOException e1) {
			e1.printStackTrace();
		} catch (IllegalArgumentException e1) {
			e1.printStackTrace();
		}
		return mail;
	}
}
