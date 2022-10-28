package com.bora.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class OpenController {
	private static final Logger log = LoggerFactory.getLogger(OpenController.class);
	
	// http://localhost:8088/openbank/oauth
	@RequestMapping(value = "/openbank/oauth", method = RequestMethod.GET)
	public void openbank() {
		log.info("/oepnbank/oauth -> oauth.jsp");
	}
	
}
