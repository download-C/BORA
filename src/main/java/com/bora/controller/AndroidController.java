package com.bora.controller;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import org.json.simple.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.bora.domain.SHA256;
import com.bora.domain.board.CommentVO;
import com.bora.domain.member.MemberVO;
import com.bora.domain.report.BookDetailVO;
import com.bora.domain.report.BookVO;
import com.bora.service.MainService;
import com.bora.service.report.BookDetailService;

@RestController
@RequestMapping("/android/*")
public class AndroidController {
	// 멤버변수 =======================================
	private static final Logger log = LoggerFactory.getLogger(AndroidController.class);
	
	@Inject
	private MainService mainService;
	
	@Inject
	private BookDetailService bookDetailService;
		
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
	@GetMapping(value="/get/{loginID}/{year}/{month}/{day}",
				produces= {MediaType.APPLICATION_JSON_UTF8_VALUE}) // 반환 타입은 json
	public ResponseEntity<List<BookDetailVO>> getList(@PathVariable("year") int year, 
												@PathVariable("month") int month, 
												@PathVariable("day") int day, 
												@PathVariable("loginID") String loginID) throws Exception {
		log.info("（＾∀＾●）ﾉｼ getList() 호출됨   loginID: " + loginID);
		log.info("（＾∀＾●）ﾉｼ getList() 호출됨   year/month/day: " + year+"/"+month+"/"+day);
		
		return new ResponseEntity<>(bookDetailService.getAndroidBookDetailList(year, month, day, loginID), HttpStatus.OK);
	}
	
	
	
	// insert
	@PostMapping(value="/write", consumes = "application/json", produces = {MediaType.TEXT_PLAIN_VALUE})
	public ResponseEntity<String> insertList(@RequestBody BookDetailVO vo) throws Exception {
		log.info("（＾∀＾●）ﾉｼ insertList() 호출됨");
		
		int insertCount = bookDetailService.writeBookDetail(vo);
		
		log.info("（＾∀＾●）ﾉｼ insertList()  전달받은 vo: " + vo);
		log.info("（＾∀＾●）ﾉｼ insertList()  insertCount: " + insertCount);
		
		return insertCount == 1 ? 
				new ResponseEntity<>("success", HttpStatus.OK) : 
				new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	
	// insert
	@PostMapping(value="/write", consumes = "application/json", produces = {MediaType.TEXT_PLAIN_VALUE})
	public ResponseEntity<String> insertList2(@RequestBody BookDetailVO vo) throws Exception {
		log.info("（＾∀＾●）ﾉｼ insertList() 호출됨");
		
		int insertCount = bookDetailService.writeBookDetail(vo);
		
		log.info("（＾∀＾●）ﾉｼ insertList()  전달받은 vo: " + vo);
		log.info("（＾∀＾●）ﾉｼ insertList()  insertCount: " + insertCount);
		
		return insertCount == 1 ? 
				new ResponseEntity<>("success", HttpStatus.OK) : 
					new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	
	
	// 1. 댓글 쓰기
		//  http://localhost:8088/comments/new
//		@PostMapping(value = "/new", consumes = "application/json", produces = { MediaType.TEXT_PLAIN_VALUE })
//		//   post 방식으로만 동작하도록    ㄴjson 방식의 데이터만 처리하도록        ㄴ문자열 반환하도록
//		//       produces??  Ajax의 success: function(result..) << 이 result로 전달할 데이터 타입!!!이 뭐냐~ 문자열이다~
//		public ResponseEntity<String> insertCmt(@RequestBody CommentVO vo) throws Exception {
//									// @RequestBody:  json 데이터를 --> CommentVO타입으로 변환하도록 지정
//			log.info("(ﾉ◕ヮ◕)ﾉ*:･ﾟ✧1.insertCmt(vo)  호출됨");
//			log.info("(ﾉ◕ヮ◕)ﾉ*:･ﾟ✧1.insertCmt(vo)  서비스 호출할게요");
//			int inCount = service.insertCmt(vo);
//			
//			log.info("(ﾉ◕ヮ◕)ﾉ*:･ﾟ✧1.insertCmt(vo)  리턴받은 결과 "
//					+ "insertCount: " + inCount + " / CommentVO: " + vo);
//			
//			// 삼항 연산자 처리
//			//   insertCount가 1이면~ OK (댓글쓰기 성공) / 아니면~ 에러 (댓글쓰기 실패)
//			return inCount == 1 ? new ResponseEntity<>("success", HttpStatus.OK) : 
//								 new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
//		}
		// 1. 댓글 쓰기 끝
	
	
	
	
	
} // class AndroidController
