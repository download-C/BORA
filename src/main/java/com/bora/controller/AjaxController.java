package com.bora.controller;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.bora.domain.MemberVO;
import com.bora.service.MemberService;

@Controller
public class AjaxController {
	
	private static final Logger log = LoggerFactory.getLogger(MemberController.class);
	
	@Inject
	private MemberService service;
	
	@RequestMapping(value="/member/idcheck", method = RequestMethod.GET)
	public ResponseEntity<String> idcheck(HttpServletRequest request, RedirectAttributes rttr) throws Exception{
		String id = request.getParameter("id");
		MemberVO vo = service.getMember(id);
		String result = "";
		
		if(vo != null) {
			result = "no";
			rttr.addFlashAttribute("idflag", true);
		}
		else result = "ok";
		
		ResponseEntity<String> entity = new ResponseEntity<String>(result, HttpStatus.OK);
		return entity;
	}
	
	@RequestMapping(value="/member/nickcheck", method = RequestMethod.GET)
	public ResponseEntity<String> nickcheck(HttpServletRequest request) throws Exception{
		String nick = request.getParameter("nick");
		log.info("nick: "+nick);
		MemberVO vo = service.getMemberNick(nick);
		log.info("vo : "+vo);
		String result = "";
		
		if(vo != null) result = "no";
		else if(vo == null) result = "ok";
		log.info("♡♡♡♡♡♡♡♡♡♡♡♡♡♡♡♡♡♡result: "+result);
		ResponseEntity<String> entity = new ResponseEntity<String>(result, HttpStatus.OK);
		return entity;
	}
	
//	@RequestMapping(value="/member/isJoin", method = RequestMethod.GET)
//	public ResponseEntity<String> isJoin(HttpServletRequest request) throws Exception {
//		String id = request.getParameter("id");
//		String pw = request.getParameter("pw");
//		String pw2 = request.getParameter("pw2");
//		String result = "";
//		
//		if(id == "") result = "idno";
//		if(pw == "" ) result = "pwno";
//		if(pw2 == "") result = "pw2no";
//		ResponseEntity<String> entity = new ResponseEntity<String>(result, HttpStatus.OK);
//		return
//				entity;
//	}
	
//	@RequestMapping(value="/member/pwcheck", method = RequestMethod.GET)
//	public ResponseEntity<String> isPw2(HttpServletRequest request) throws Exception {
//		String pw2 = request.getParameter("pw2");
//		String result = "";
//		if(pw2 == null ) result = "비밀번호를 입력하세요";
//		ResponseEntity<String> entity = new ResponseEntity<String>(result, HttpStatus.OK);
//		return entity;
//	}
//	
//	public ResponseEntity<String> pwcheck(HttpServletRequest request) throws Exception {
//		String pw = request.getParameter("pw");
//		String pw2 = request.getParameter("pw2");
//		String result = "";
//		
//		if(!pw.equals(pw2)) result = "비밀번호가 일치하지 않습니다."; 
//		ResponseEntity<String> entity = new ResponseEntity<String>(result, HttpStatus.OK);
//		return entity;
//	}
	
//	@RequestMapping(value="", method = RequestMethod.GET)
//	public ResponseEntity<String> (HttpServletRequest request) throws Exception {
//		String 
//		String result = "";
//		if() result = "";
//		ResponseEntity<String> entity = new ResponseEntity<String>(result, HttpStatus.OK);
//		return entity;
//	}

	

}
