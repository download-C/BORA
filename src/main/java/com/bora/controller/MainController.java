package com.bora.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@RequestMapping("/main/*")
@Controller
public class MainController {
	private static final Logger log = LoggerFactory.getLogger(MainController.class);
	
	@RequestMapping(value="/main", method = RequestMethod.GET)
	public void main() {
		log.info("/main -> main.jsp");	
	}
}
