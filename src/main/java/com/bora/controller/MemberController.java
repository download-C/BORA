package com.bora.controller;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.bora.domain.MemberVO;
import com.bora.service.MemberService;

@Controller
@RequestMapping("/member/*")
public class MemberController {
   
   @Inject
   private MemberService service;
   
   String loginID;

   private static final Logger log = LoggerFactory.getLogger(MemberController.class);
   
   @RequestMapping(value="/join", method=RequestMethod.GET)
   public void joinGET() {
      
   }
   
   @RequestMapping(value="/join", method=RequestMethod.POST)
   public String joinPOST(MemberVO vo, HttpServletRequest request) 
         throws Exception{
      log.info("joinPOST(vo) -> login.jsp" );
      String id = request.getParameter("id");
      String pw = request.getParameter("pw");
      String name = request.getParameter("name");
      String nick = request.getParameter("nick");

      String phone = request.getParameter("phone");

      String email = request.getParameter("email");
      
      vo.setId(id);
      vo.setPw(pw);
      vo.setName(name);
      vo.setNick(nick);
      vo.setPhone(phone);
      vo.setEmail(email);

      log.info("회원가입 정보: "+vo);
      
      service.joinMember(vo);
      log.info("회원가입 성공");
            
      return "redirect:/member/login";
   }
   
   @RequestMapping(value="/login", method=RequestMethod.GET)
   public void loginGET() throws Exception {
      log.info("loginGET() 호출");
   }
   
   // http://localhost:8088/member/login
   @RequestMapping(value="/login", method=RequestMethod.POST)
   public String loginPOST(MemberVO vo, HttpSession session, RedirectAttributes rttr) throws Exception {
      log.info("loginPOST() 호출");
      
      MemberVO vo2 = service.loginMember(vo);
      if(vo2 != null ) {
         session.setAttribute("loginID", vo2.getId());
         rttr.addFlashAttribute("msg", vo2.getNick()+"님, 환영합니다♡");
         return "redirect:/main/main";
      } else {
    	 rttr.addFlashAttribute("msg", "아이디가 없거나 아이디 또는 비밀번호가 일치하지 않습니다.");
         return "redirect:/member/login";
      }
      
   }
   
   // http://localhost:8088/member/mypage
   @RequestMapping(value="/mypage", method=RequestMethod.GET)
   public void mypageGET(String loginID, HttpSession session, Model model) throws Exception{
	  log.info("mypageGET(loginID) 호출");
      loginID = (String)session.getAttribute("loginID");
      MemberVO vo = service.getMember(loginID);
      model.addAttribute("vo", vo);
   }
   
   @RequestMapping(value="/password", method=RequestMethod.GET)
   public void mypagePasswordGET() throws Exception{
	  log.info("mypagePasswordGET() 호출");  
   }
   
   @RequestMapping(value="/password", method=RequestMethod.POST)
   public String mypagePasswordPOST(HttpServletRequest request, HttpSession session, RedirectAttributes rttr) throws Exception{
	   log.info("mypagePasswordPOST() 호출");
	   String pw = request.getParameter("pw");
	   loginID = (String)session.getAttribute("loginID");
	   MemberVO vo = service.getMember(loginID);
	   if(vo.getPw().equals(pw)) {
		   return "redirect:/member/update";
	   } else {
		   rttr.addFlashAttribute("msg", "비밀번호가 일치하지 않습니다.");
		   return "redirect:/member/password";
	   }
	   
   }
   
   @RequestMapping(value="/update", method = RequestMethod.GET)
   public String updateGET(HttpSession session, Model model) throws Exception{
      log.info("updateGET() 호출");
      String id = (String)session.getAttribute("loginID");
      MemberVO vo = service.getMember(id);
      model.addAttribute("vo", vo);
      return "/member/update";
   }

   // http://localhost:8088/member/logout  완료
   @RequestMapping(value="/logout", method=RequestMethod.GET)
   public String logoutGET(HttpSession session) throws Exception{
      log.info("logoutGET() 호출");
//      session.setAttribute("loginID", "admin");
      session.invalidate();
      
      log.info("로그아웃 성공");
      return "redirect:/main/main";
   }
   
   
}