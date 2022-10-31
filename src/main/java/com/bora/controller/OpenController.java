package com.bora.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@Controller
@RequestMapping("/openbank/*")
public class OpenController {
	private static final Logger log = LoggerFactory.getLogger(OpenController.class);
	
	// http://localhost:8088/openbank/oauth
	@RequestMapping(value = "/oauth", method = RequestMethod.GET)
	public String openbank() {
		log.info("%%%%%%%%%%%%%% /oauth -> oauth.jsp");
		return "/openbank/oauth";
	}
	
}
