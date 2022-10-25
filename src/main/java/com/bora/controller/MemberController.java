package com.bora.controller;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.bora.domain.MemberVO;
import com.bora.persistence.MemberDAO;

@Controller
@RequestMapping("/member/*")
public class MemberController {
	
	@Inject
	MemberDAO dao;

	private static final Logger log = LoggerFactory.getLogger(MemberController.class);
	
	// http://localhost:8088/member/join
	@RequestMapping(value="/join", method = RequestMethod.GET)
	public void joinGET() {
		log.info("/join -> join.jsp");
	}
	
	@RequestMapping(value="/join", method=RequestMethod.POST)
	public String joinPOST(MemberVO vo) {
		log.info("joinPOST(vo) -> login.jsp" );
		
		return "redirect:/member/login";
	}
	
	@RequestMapping(value="/mypage", method=RequestMethod.GET)
	public void mypageGET(Integer mno) {
		
	}
	
	@RequestMapping(value="/mypage", method=RequestMethod.POST)
	public void mypagePOST(MemberVO vo) {
		
	}
	
//	@RequestMapping(value="", method=RequestMethod.GET)
//	public void GET() {
//		
//	}
	
//	@RequestMapping(value="", method=RequestMethod.POST)
//	public void POST() {
//		
//	}
}
