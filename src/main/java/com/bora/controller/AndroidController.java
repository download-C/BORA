package com.bora.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
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
import com.bora.domain.member.MemberVO;
import com.bora.domain.report.BookDetailVO;
import com.bora.domain.report.BookVO;
import com.bora.service.MainService;
import com.bora.service.report.BookDetailService;
import com.bora.service.report.BookService;


@RestController
@RequestMapping("/android/*")
public class AndroidController {
	// 멤버변수 =======================================
	private static final Logger log = LoggerFactory.getLogger(AndroidController.class);
	
	@Inject
	private MainService mainService;
	
	@Inject
	private BookDetailService bookDetailService;
		
	@Inject
	private BookService bookService;
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
			
//			obj.put("name", vo2.getName());
			obj.put("nick", vo2.getNick());
//			obj.put("name", vo2.getName());
			
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
	@PostMapping(value="/get/{loginID}/{year}/{month}/{day}",
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
//	@PostMapping(value="/write", consumes = "application/json", produces = {MediaType.TEXT_PLAIN_VALUE})
//	public ResponseEntity<String> insertList(@RequestBody BookDetailVO vo) throws Exception {
	@PostMapping(value="/write", produces = {MediaType.TEXT_PLAIN_VALUE})
	public void insertList(@RequestBody String voString) throws Exception {
		log.info("（＾∀＾●）ﾉｼ insertList() 호출됨");
		log.info("（＾∀＾●）ﾉｼ insertList()  전달받은 voString: " + voString);
		
		// 원본 DetailDTO{book:BookDTO{bk_num:0, bk_year:2022, bk_month:11, bk_budget:0}, bk_day:21, bk_iow:'지출', bk_group:'신용카드', bk_category:'편의점/마트', bk_money:8888, bk_memo:'ㅕㅕ'}
		
		// DetailDTO{"book":BookDTO{"bk_num":0, "bk_year":2022, "bk_month":11, "bk_budget":0}, "bk_day":21, "bk_iow":"지출", "bk_group":"신용카드", "bk_category":"편의점/마트", "bk_money":8888, "bk_memo":"닭강정"}
		// "{\"book\":{\"bk_num\":0, \"bk_year\":2022, \"bk_month\":11, \"bk_budget\":0}, \"bk_day\":21, \"bk_iow\":\"지출\", \"bk_group\":\"신용카드\", \"bk_category\":\"편의점/마트\", \"bk_money\":8888, \"bk_memo\":\"닭강정\"}
		
//		voString = "{\"book\":{\"bk_num\":0, \"bk_year\":2022, \"bk_month\":11, \"bk_budget\":0}, \"bk_day\":21, \"bk_iow\":\"지출\", \"bk_group\":\"신용카드\", \"bk_category\":\"편의점/마트\", \"bk_money\":8888, \"bk_memo\":\"닭강정\"}";
		
		// JSONParser 생성
		JSONParser jsonParser = new JSONParser();
		
		// String 짤라가지고 Object로
		Object obj = jsonParser.parse(voString);
		
		// Object --> JsonObject로 완성!!
		JSONObject jsonObj = (JSONObject) obj;
		// bookDTO 안에 애들 보기 위해 한번 더 해체 작업
		JSONObject jsonObjBook = (JSONObject) jsonObj.get("book");
		
		// BookVO, BookDetailVO 생성, json에서 키값으로 빼내서 해당 변수에 채우기
		BookDetailVO bookDetailVO = new BookDetailVO();
		
		int bk_num = 0;
		int bk_budget = Long.valueOf(jsonObjBook.get("bk_budget").toString()).intValue();
		int bk_month = Long.valueOf(jsonObjBook.get("bk_month").toString()).intValue();
		int bk_year = Long.valueOf(jsonObjBook.get("bk_year").toString()).intValue();
		String loginID = (String) jsonObjBook.get("id");
		
		int bk_day = Long.valueOf(jsonObj.get("bk_day").toString()).intValue();
		String bk_iow = (String) jsonObj.get("bk_iow");
		String bk_category = (String) jsonObj.get("bk_category");
		String bk_group = (String) jsonObj.get("bk_group");
		int bk_money = Long.valueOf(jsonObj.get("bk_money").toString()).intValue();
		String bk_memo = (String) jsonObj.get("bk_memo");
		
		// 이 회원의 기존 bookVO 있나? 서비스에서 호출
		BookVO bookVO = bookService.getMonthBook(bk_year, bk_month, loginID);
		log.info("（＾∀＾●）ﾉｼ insertList()  가져온 bookVO: " + bookVO);
		
		// bookVO 채우고 -> detailVO에 setBook까지
		if (bookVO != null) {
			// 이미 만들어진 bookVO 있을 때
			
			// 이미 작성된 연월이므로 기존의 bk_num을 get으로 가져와서 그대로 작성
			bk_num = bookVO.getBk_num();
			log.info("（＾∀＾●）ﾉｼ insertList()  기존 bk_num: " + bk_num);
			
			//  가져온 bookVO 그대로 set하기
			bookDetailVO.setBook(bookVO);
			
		} else if (bookVO == null) {
			// 작성된 bookVO 없다면,, 
			//  getBookMaxNum 불러와서 bk_num 채우기
			bk_num = bookService.getBookMaxNum();
			log.info("（＾∀＾●）ﾉｼ insertList()  새로 채운 bk_num: " + bk_num);
			
			bookVO.setBk_num(bk_num);
			bookVO.setBk_budget(bk_budget);
			bookVO.setBk_month(bk_month);
			bookVO.setBk_year(bk_year);
			bookVO.setId(loginID);
			
			// bookVO 다 채웠으니 detailVO에 set하기
			bookDetailVO.setBook(bookVO);
		}

		// 위에서 가계부 번호(bk_num) 가져왔을 경우, BookDetailVO에 다 set한 후, 서비스 호출해서 DB 저장
		if (bk_num != 0) {
			bookDetailVO.setBk_num(bk_num);
			
			// bk_num에 상관 없이 이거는 공통으로 들어갈 new 정보
			bookDetailVO.setId(loginID);
			bookDetailVO.setBk_day(bk_day);
			bookDetailVO.setBk_iow(bk_iow);
			bookDetailVO.setBk_category(bk_category);
			bookDetailVO.setBk_group(bk_group);
			bookDetailVO.setBk_money(bk_money);
			bookDetailVO.setBk_memo(bk_memo);
			log.info("（＾∀＾●）ﾉｼ insertList()  set 다 한 bookDetailVO: " + bookDetailVO);
			
			int result = bookDetailService.writeBookDetail(bookDetailVO);
			
			// 이거 삼항연산자 왜 안 됨? ㄱ-
			if (result == 1) { 
				log.info("（＾∀＾●）ﾉｼ insertList()  가계부 작성 성공 result: " + result);
			} else {
				log.info("（＾∀＾●）ﾉｼ insertList()  가계부 작성 실패 result: " + result);
			}
			
		} else {
			log.info("（＾∀＾●）ﾉｼ insertList()  bk_num 없음,,,,? ");
		}
		
	}
	
	
	
} // class AndroidController
