package com.bora.controller;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.bora.domain.SHA256;
import com.bora.domain.member.MemberVO;
import com.bora.service.MainService;

@RequestMapping("/android/*")
@Controller
public class SampleController {

	private static final Logger log = LoggerFactory.getLogger(MemberController.class);
	
	@Inject
	private MainService mainService;
	
	
	
	@RequestMapping(value="/alert", method = RequestMethod.GET)
	public String alertGET() throws Exception{
		return "/alert/alert";
	}
	
	
	// 안드 로그인 테서터 중
	@GetMapping(value="/loginTest")
	public String androidLoginTestGET() throws Exception {
		log.info("(✿◡‿◡) androidLoginTestGET  호출됨");
		return "/main/loginTest";
	}
	
	
	// http://localhost:8088/main/login
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String androidLoginTestPOST(MemberVO vo, HttpSession session, RedirectAttributes rttr, Model model) throws Exception {
		log.info("(✿◡‿◡) androidLoginTestPOST  호출됨");
		// 사용자가 입력한 비밀번호 암호화
		
		String encryptPw = SHA256.encrypt(vo.getPw());
		log.info("암호화된 비밀번호"+encryptPw);
		// 암호화된 비밀번호로 수정
		vo.setPw(encryptPw);
		MemberVO vo2 = mainService.loginMember(vo);
		if (vo2 != null) {
			log.info("로그인 성공");
			model.addAttribute("id", vo2.getId());
			model.addAttribute("pw", vo2.getPw());
			rttr.addFlashAttribute("msg", "'"+vo2.getNick() + "'님, 환영합니다♡");
//			return "redirect:/android/loginTest"; // 할 필요 X
			return vo2.getId(); // id 넘겨봄
		} else {
			log.info("로그인 실패");
			rttr.addFlashAttribute("msg", "아이디가 없거나 <br> 아이디 또는 비밀번호가 일치하지 않습니다.");
			return "redirect:/main/main";
		}

	}
	
	
	
	
	
}