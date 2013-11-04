package com.lollykids.biz.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.lollykids.biz.model.Mail;
import com.lollykids.biz.service.MailService;

@Controller
@RequestMapping("/user")
public class PostController {

	//@Autowired private UserMappr userMappr;
	@Autowired private MailService mailService;
	@RequestMapping(value = "/postAll", method = RequestMethod.POST)
	public void postAll(@RequestBody Mail mail) {
		//List<User> users = userMappr.getAll();
		//mailService.sendMail(mail,users);
		
	}	
}
