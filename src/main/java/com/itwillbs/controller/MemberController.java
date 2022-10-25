package com.itwillbs.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/member/*")
public class MemberController {

	private static final Logger log = LoggerFactory.getLogger(MemberController.class);
	
	// http://localhost:8088/member/join
	@RequestMapping("/join")
	public void insertGET() {
		log.info("/join -> join.jsp");
	}
}
