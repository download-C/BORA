package com.bora.controller;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@RequestMapping("/alert/*")
@Controller
public class AlertController {
	
	private static final Logger log = LoggerFactory.getLogger(MemberController.class);

	   // http://localhost:8088/alert/alert
	   @RequestMapping(value="/alert", method=RequestMethod.GET)
	   public void alert() throws Exception{
		  log.info("🐧🐧🐧🐧🐧🐧🐧🐧🐧🐧🐧🐧  alert 페이지로 이동");

	   
	   }

}
