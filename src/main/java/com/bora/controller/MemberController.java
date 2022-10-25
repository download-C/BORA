package com.bora.controller;

import java.sql.Date;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.bora.domain.MemberVO;
import com.bora.service.MemberService;

@Controller
@RequestMapping("/member/*")
public class MemberController {
	
	@Inject
	private MemberService service;

	private static final Logger log = LoggerFactory.getLogger(MemberController.class);
	
	// http://localhost:8088/member/join
	@RequestMapping(value="/join", method = RequestMethod.GET)
	public void joinGET() {
		log.info("/join -> join.jsp");
		
	}
	
	@RequestMapping(value="/join", method=RequestMethod.POST)
	public String joinPOST(MemberVO vo, HttpServletRequest request) 
			throws Exception{
		log.info("joinPOST(vo) -> login.jsp" );
		String id = request.getParameter("id");
		String pw = request.getParameter("pw");
		String name = request.getParameter("name");
//		Date birth = Date.valueOf(request.getParameter("birth"));
//		String gender = request.getParameter("gender");
		String phone = request.getParameter("phone");
//		String ad_postcode = request.getParameter("ad_postcode");
//		String ad_address= request.getParameter("ad_address");
//		String ad_detail = request.getParameter("ad_detail");
//		String ad_extra = request.getParameter("ad_extra");
//		String email = request.getParameter("email");
		
		vo.setId(id);
		vo.setPw(pw);
		vo.setName(name);
//		vo.setBirth(birth);
	//		vo.setGender(gender);
			vo.setPhone(phone);
	//		vo.setAd_postcode(ad_postcode);
	//		vo.setAd_address(ad_address);
	//		vo.setAd_detail(ad_detail);
	//		vo.setAd_extra(ad_extra);
	//		vo.setEmail(email);
			
			log.info(vo+"");
		
		service.joinMember(vo);
		log.info("회원가입 성공");
				
		return "redirect:/member/login";
	}
	
	// http://localhost:8088/member/login
	@RequestMapping(value="/login", method=RequestMethod.GET)
	public void loginGET() throws Exception {
		
	}
	@RequestMapping(value="/login", method=RequestMethod.POST)
	public String loginPOST() throws Exception {
		
		return "redirect:/main/main";
	}
	
	@RequestMapping(value="/mypage", method=RequestMethod.GET)
	public void mypageGET(String loginID) throws Exception{
		
	}
	
	@RequestMapping(value="/mypage", method=RequestMethod.POST)
	public void mypagePOST(MemberVO vo) throws Exception{
		
	}
	
	@RequestMapping(value="/logout", method=RequestMethod.GET)
	public void logoutGET() throws Exception{
		
	}
	
	@RequestMapping(value="/logout", method=RequestMethod.POST)
	public void POST(String loginID) throws Exception{
		
	}
}
