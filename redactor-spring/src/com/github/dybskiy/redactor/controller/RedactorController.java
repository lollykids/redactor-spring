package com.github.dybskiy.redactor.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import com.github.dybskiy.redactor.service.RedactorService;

/**
 * @author hdlee 
 * redactor-js
 */
@Controller
public class RedactorController {

	@Autowired private RedactorService redactorService; 
	
	@RequestMapping(value = "/data", method = RequestMethod.GET)
	public @ResponseBody Object data() {
		return redactorService.data();
	}
}
