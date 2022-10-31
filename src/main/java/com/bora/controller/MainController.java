package com.bora.controller;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.bora.domain.MemberSHA256;
import com.bora.domain.MemberVO;
import com.bora.service.MemberService;

@RequestMapping("/main/*")
@Controller
public class MainController {
	private static final Logger log = LoggerFactory.getLogger(MainController.class);

	@Inject
	MemberService mService;
	
	@RequestMapping(value = "/main", method = RequestMethod.GET)
	public void main() {
		log.info("/main -> main.jsp");
	}

	// http://localhost:8088/main/join
	@RequestMapping(value = "/join", method = RequestMethod.GET)
	public void joinGET() {
		log.info("/main/join -> join.jsp");
	}

	@RequestMapping(value = "/join", method = RequestMethod.POST)
	public String joinPOST(MemberVO vo, HttpServletRequest request) throws Exception {
		log.info("♡♡♡♡♡♡♡♡♡♡♡♡♡♡♡♡♡♡♡♡♡♡♡joinPOST(vo) -> login.jsp");
		String id = request.getParameter("id");
		String pw = request.getParameter("pw");
		log.info("비밀번호: " + pw);
		// 비밀번호 암호화
		String encryptPw = MemberSHA256.encrypt(pw);
		log.info("암호화된 비밀번호: " + encryptPw);
		String name = request.getParameter("name");
		String nick = request.getParameter("nick");

		String phone = request.getParameter("phone");

		String email = request.getParameter("email");

		vo.setId(id);
		vo.setPw(encryptPw);
		vo.setName(name);
		vo.setNick(nick);
		vo.setPhone(phone);
		vo.setEmail(email);

		log.info("♡♡♡♡♡♡♡♡♡♡♡♡♡♡♡♡♡♡♡♡♡♡♡회원가입 정보: " + vo);

		mService.joinMember(vo);
		log.info("♡♡♡♡♡♡♡♡♡♡♡♡♡♡♡♡♡♡♡♡♡♡♡회원가입 성공");

		return "redirect:/main/login";
	}

	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public void loginGET() throws Exception {
		log.info("♡♡♡♡♡♡♡♡♡♡♡♡♡♡♡♡♡♡♡♡♡♡♡loginGET() 호출");
	}

	// http://localhost:8088/main/login
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String loginPOST(MemberVO vo, HttpSession session, RedirectAttributes rttr) throws Exception {
		log.info("♡♡♡♡♡♡♡♡♡♡♡♡♡♡♡♡♡♡♡♡♡♡♡loginPOST() 호출");
		// 사용자가 입력한 비밀번호 암호화
		String encryptPw = MemberSHA256.encrypt(vo.getPw());
		log.info(encryptPw);
		// 암호화된 비밀번호로 수정
		vo.setPw(encryptPw);
		MemberVO vo2 = mService.loginMember(vo);
		if (vo2 != null) {
			session.setAttribute("loginID", vo2.getId());
			rttr.addFlashAttribute("msg", vo2.getNick() + "님, 환영합니다♡");
			return "redirect:/main/main";
		} else {
			rttr.addFlashAttribute("msg", "아이디가 없거나 아이디 또는 비밀번호가 일치하지 않습니다.");
			return "redirect:/main/login";
		}

	}
}
