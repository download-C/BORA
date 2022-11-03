package com.bora.controller;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.bora.domain.MemberVO;
import com.bora.service.MemberService;

@RequestMapping("/alert/*")
@Controller
public class AlertController {
	
	   @Inject
	   private MemberService service;
	   
	   String loginID;

	private static final Logger log = LoggerFactory.getLogger(MemberController.class);

	   // http://localhost:8088/alert/alert
	   @RequestMapping(value="/alert", method=RequestMethod.GET)
	   public void mypageGET(String loginID, HttpSession session, Model model) throws Exception{
		  log.info("🐧🐧🐧🐧🐧🐧🐧🐧🐧🐧🐧🐧  alert 페이지로 이동");

	   
	   }

}
