package com.bora.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@RequestMapping("/sample/*")
@Controller
public class SampleController {

	private static final Logger log = LoggerFactory.getLogger(MemberController.class);
	
	
	@RequestMapping(value="/alert", method = RequestMethod.GET)
	public String alertGET() throws Exception{
		return "/alert/alert";
	}

	
} // class SampleController