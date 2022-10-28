package com.bora.controller;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

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
	
//	@RequestMapping(value="/member/phoneCheck", method=RequestMethod.POST)
//	public ResponseEntity<String> phoneCheck(HttpServletRequest request) throws Exception {
//		String result = "";
//		ResponseEntity<String> entity = new ResponseEntity<String>(result, HttpStatus.OK);
//		return entity;
//	}
	
	@RequestMapping(value="/member/pwUpdateCheck", method = RequestMethod.POST)
	public ResponseEntity<String> pwUpdateCheck(HttpSession session, 
			HttpServletRequest request) throws Exception{
		String pwUpdate = request.getParameter("pwUpdate");
		log.info("♡♡♡♡♡♡♡♡♡♡pwUpdate: "+pwUpdate);
		String id = (String)session.getAttribute("loginID");
		String result = "";
		MemberVO vo = service.getMember(id);
		if(pwUpdate.equals(vo.getPw())) {
			result= "no";
		} else {
			result = "ok";
		}
		ResponseEntity<String> entity = new ResponseEntity<String>(result, HttpStatus.OK);
		return entity;
	}

	

}
