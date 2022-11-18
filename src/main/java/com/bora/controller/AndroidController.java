package com.bora.controller;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import org.json.simple.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.MediaType;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.bora.domain.SHA256;
import com.bora.domain.member.MemberVO;
import com.bora.domain.report.BookDetailVO;
import com.bora.service.MainService;

@RestController
@RequestMapping("/android/*")
public class AndroidController {
	// 멤버변수 =======================================
	private static final Logger log = LoggerFactory.getLogger(AndroidController.class);
	
	@Inject
	private MainService mainService;
	
		
	// 멤버변수 끝 =======================================
	
	
	
	@RequestMapping(value = "/login", method = RequestMethod.POST, produces = {MediaType.APPLICATION_JSON_UTF8_VALUE})
	@ResponseBody
	public JSONObject androidLoginTestPOST(MemberVO vo, HttpSession session, RedirectAttributes rttr, Model model) throws Exception {
		log.info("(✿◡‿◡) androidLoginTestPOST  호출됨");
		// 사용자가 입력한 비밀번호 암호화
		String encryptPw = SHA256.encrypt(vo.getPw());
		log.info("암호화된 비밀번호"+encryptPw);
		// 암호화된 비밀번호로 수정
		vo.setPw(encryptPw);
		MemberVO vo2 = mainService.loginMember(vo);
		JSONObject obj = new JSONObject();

		if (vo2 != null) {
			log.info("로그인 성공");
//			model.addAttribute("id", vo2.getId());
//			model.addAttribute("pw", vo2.getPw());
//			rttr.addFlashAttribute("msg", "'"+vo2.getNick() + "'님, 환영합니다♡");
//			return "redirect:/android/loginTest"; // 할 필요 X
			
			obj.put("name", vo2.getName());
			
			log.info("(✿◡‿◡) androidLoginTestPOST  put한 obj: " + obj);
			
			return obj; // id 넘겨봄
			
		} else {
			log.info("로그인 실패");
//			rttr.addFlashAttribute("msg", "아이디가 없거나 <br> 아이디 또는 비밀번호가 일치하지 않습니다.");
			
			obj.put("result", "fail");
			return obj;
		}
	}
	
	
	
	
	// 안드 로그인 테서터 중
//	@GetMapping(value="/loginTest")
//	public String androidLoginTestGET() throws Exception {
//		log.info("(✿◡‿◡) androidLoginTestGET  호출됨");
//		return "/main/loginTest";
//	}
	
	
	// 유튜브 ㄸ따라서
//	@RequestMapping("login_check_json.do")
//	@ResponseBody // 바로 결과 되돌려주고 싶을 때는 이것만 붙이면 된다
//	public JSONObject login_check_json(MemberVO vo, ModelAndView mav) throws Exception {
//		log.info("(✿◡‿◡) login_check_json  호출됨");
//		// 사용자가 입력한 비밀번호 암호화
//		String encryptPw = SHA256.encrypt(vo.getPw());
//		log.info("암호화된 비밀번호"+encryptPw);
//		// 암호화된 비밀번호로 수정
//		vo.setPw(encryptPw);
//		
//		MemberVO vo2 = mainService.loginMember(vo);
//		
//		if (vo2 != null) {
//			log.info("(✿◡‿◡) login_check_json  로그인 성공");
//
//			// 결괏값을 json으로 보내보자
//			String name = vo2.getName();
//			JSONObject obj = new JSONObject();
//			obj.put("name", name); // string -> json으로 변환
//			// {"name":"보람이"}
//			// {"name": null }
//			
//			return obj; // view가 아닌 json 객체 리턴
//			
//		} else {
//			log.info("(✿◡‿◡) login_check_json  로그인 실패");
//			return null;
//		}
//	}
	
	
	// select 
	// 연, 월, 일,  
	@RequestMapping("/select")
	public List<BookDetailVO> selectList() throws Exception {
		log.info("（＾∀＾●）ﾉｼ selectList() 호출됨");
		
		// 연, 월, 일, id, 
		
		List<BookDetailVO> bookDetailList = new ArrayList<BookDetailVO>();
		
		
		
		
//		for (int i = 0; i < 5; i++) {
//			MemberVO vo = new MemberVO();
//			vo.setId("admin"+i);
//			vo.setPw("1234"+i);
//			vo.setEmail("admin@n.com"+i);
//			vo.setName("King Admin"+i);
//			
//			memberList.add(vo);
//		}
		
//		log.info("（＾∀＾●）ﾉｼ Test2()  memberList.size(): " + memberList.size());
		
		return null;
	}
	
	
	
	// insert
	@RequestMapping("/insert")
	public List<BookDetailVO> insertList() throws Exception {
		log.info("（＾∀＾●）ﾉｼ insertList() 호출됨");
		
		
		
		
		return null;
	}
	
	
	
	
	
	
} // class AndroidController
