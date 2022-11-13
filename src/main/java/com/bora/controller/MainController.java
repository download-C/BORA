package com.bora.controller;

import java.io.IOException;
import java.util.Calendar;
import java.util.List;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import com.bora.domain.SHA256;
import com.bora.domain.board.NoticeVO;
import com.bora.domain.board.PageMakerVO;
import com.bora.domain.board.PageVO;
import com.bora.domain.member.KakaoLoginBO;
import com.bora.domain.member.MemberVO;
import com.bora.domain.member.NaverLoginBO;


import com.bora.domain.report.BookVO;
import com.bora.service.MainService;
import com.bora.service.MemberService;
import com.bora.service.board.NoticeService;
import com.bora.service.report.BookService;
import com.github.scribejava.core.model.OAuth2AccessToken;


@RequestMapping("/main/*")
@Controller
public class MainController {
	private static final Logger log = LoggerFactory.getLogger(MainController.class);

	@Inject
	private MainService mainService;
	@Inject
	private MemberService memberService;
	@Inject
	private NoticeService noticeService;
	@Inject
	private BookService bookService;

	
	@Inject
	private NaverLoginBO naverLoginBO;
	@Inject
	private KakaoLoginBO kakaoLoginBO;
	
	private String apiResult = null;
	
	@Inject
	private void setNaverLoginBO(NaverLoginBO naverLoginBO) {
		this.naverLoginBO = naverLoginBO;
	}

	
	@RequestMapping(value = "/main", method = RequestMethod.GET)
	public void main() throws Exception{
		log.info("/main -> main.jsp");
	}

	// http://localhost:8088/main/join
	@RequestMapping(value = "/join", method = RequestMethod.GET)
	public void joinGET() throws Exception{
		log.info("/main/join -> join.jsp");
	}

	@RequestMapping(value = "/join", method = RequestMethod.POST)
    public String joinPOST(MemberVO vo, HttpServletRequest request) throws Exception {
	      log.info("♡♡♡♡♡♡♡♡♡♡♡♡♡♡♡♡♡♡♡♡♡♡♡joinPOST(vo) -> login.jsp");
	      String id = request.getParameter("id");
	      String pw = request.getParameter("pw");
	      log.info("비밀번호: " + pw);
	      // 비밀번호 암호화
	      String encryptPw = SHA256.encrypt(pw);
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
	      
	      // 회원가입 하자마자 가계부 기본 데이터베이스 만들어버리기!
	      Calendar cal = Calendar.getInstance();
	      int year = cal.get(Calendar.YEAR);
	      int month = cal.get(Calendar.MONTH)+1;
	      
	      BookVO book = new BookVO();
	      book.setBk_year(year);
	      book.setBk_month(month);
	      book.setId(id);
	      book.setBk_budget(0);
	      bookService.writeBook(book);

	      log.info("♡♡♡♡♡♡♡♡♡♡♡♡♡♡♡♡♡♡♡♡♡♡♡회원가입 정보: " + vo);
        
	      mainService.joinMember(vo);
	      log.info("♡♡♡♡♡♡♡♡♡♡♡♡♡♡♡♡♡♡♡♡♡♡♡회원가입 성공");

	      return "redirect:/main/login";
	   }

	
	
	// 홈페이지 자체 로그인
	@RequestMapping(value = "/login", method = {RequestMethod.GET,})
	public String loginGET(HttpServletRequest request, Model model, HttpSession session) throws Exception {
		log.info("♡♡♡♡♡♡♡♡♡♡♡♡♡♡♡♡♡♡♡♡♡♡♡loginGET() 호출");
		String serverUrl = request.getScheme()+"://"+request.getServerName();
		if(request.getServerPort() != 80) {
			serverUrl = serverUrl + ":" + request.getServerPort();
		}
		
		// 네이버 URL
		String naverAuthUrl = naverLoginBO.getAuthorizationUrl(session);
		log.info("네이버: "+naverAuthUrl);
		model.addAttribute("naverURL", naverAuthUrl);
		
		// 카카오 URL
		String kakaoAuthUrl = kakaoLoginBO.getAuthorizationUrl(session);
		System.out.println("카카오:" + kakaoAuthUrl);		
		model.addAttribute("kakaoURL", kakaoAuthUrl);	
		
		return "/main/login";
	}
	
	// 카카오 로그인
	@RequestMapping(value = "/kakaoCallback", method = { RequestMethod.GET, RequestMethod.POST })
	public String callbackKakao(Model model, @RequestParam String code, @RequestParam String state, 
			HttpSession session, RedirectAttributes rttr) 
			throws Exception {
		System.out.println("로그인 성공 callbackKako");
		OAuth2AccessToken oauthToken;
		oauthToken = kakaoLoginBO.getAccessToken(session, code, state);	
		// 로그인 사용자 정보를 읽어온다
		apiResult = kakaoLoginBO.getUserProfile(oauthToken);
		
		JSONParser jsonParser = new JSONParser();
		JSONObject jsonObj;
		
		jsonObj = (JSONObject) jsonParser.parse(apiResult);
		log.info("제이슨으로 가져온 카카오톡 정보: ");
		log.info(jsonObj+"");
		JSONObject response_obj1 = (JSONObject) jsonObj.get("kakao_account");	
		JSONObject response_obj2 = (JSONObject) response_obj1.get("profile");
		log.info("오브젝트1: "+response_obj1);
		log.info("오브젝트2: "+response_obj2);
		
		// 프로필 조회
		String id = jsonObj.get("id").toString();
		log.info("카카오 아이디: "+id);
		String pw = id;
		String email = (String) response_obj1.get("email");
		log.info("카카오 이메일: "+email);
		String nick = (String) response_obj2.get("nickname");
		log.info("카카오 닉네임: "+nick);
		String name = "미등록";
		String phone = "미등록";
		
		MemberVO member = new MemberVO();
		member.setId(id);
		member.setPw(pw);
		member.setName(name);
		member.setNick(nick);
		member.setEmail(email);
		member.setPhone(phone);
		
		if(memberService.getMember(id)!=null) {
			log.info("카카오 아이디로 이미 가입한 회원");
			// 네이버 아이디로 이미 회원가입 한 경우
			// 바로 로그인 하러 가기~
			session.setAttribute("loginID", id);
			rttr.addFlashAttribute("msg", "'"+nick+"'님, 환영합니다💜");
			return "redirect:/main/main";
		} 
		// 네이버에서 사용하는 닉네임이 이미 DB에 존재할 경우
		if(memberService.getMemberNick(nick)!=null) {
			log.info("닉네임 :"+nick);
			model.addAttribute("msg1", "'"+nick+"'"+"은 이미 존재하는 닉네임입니다.");
			model.addAttribute("msg2", "새로운 닉네임 입력 페이지로 이동합니다.");
			session.setAttribute("member", member);
			return "redirect:/main/nickCheck";
		} else {
		
		// 카카오 정보로 회원가입한 적 없는 회원인 경우 자동 회원가입
		log.info("회원가입 한 적 없는 사용자입니다.");
		
			mainService.joinMember(member);
			
			// 해당 회원의 해당 연 월 가계부 자동 생성
			Calendar cal = Calendar.getInstance();
			int year = cal.get(Calendar.YEAR);
			int month = cal.get(Calendar.MONTH)+1;
			
			BookVO book = new BookVO();
			book.setBk_year(year);
			book.setBk_month(month);
			book.setId(id);
			book.setBk_budget(0);
			bookService.writeBook(book);
			
			//4.파싱 아이디 세션으로 저장
			session.setAttribute("loginID",id); //세션 생성
			
			rttr.addFlashAttribute("msg1", "'"+nick+"'님의 회원가입 완료!");
			rttr.addFlashAttribute("msg2", "현재 임시 비밀번호 상태이니 마이페이지에서 반드시 비밀번호를 변경해주세요.");
			log.info("어트리뷰트 생성 성공");
			
			return "redirect:/member/update";
		}
	}
	
	
	// 네이버 로그인 성공 시 해당 정보로 DB 저장
	@RequestMapping(value = "/naverCallback", method = { RequestMethod.GET, RequestMethod.POST })
	public String callback(Model model, @RequestParam String code, RedirectAttributes rttr,
			@RequestParam String state, HttpSession session,
			HttpServletRequest request) throws Exception {
		log.info("여기는 callback");
		log.info("세션: "+session);
		log.info("코드: "+code);
		log.info("스테이트: "+state);
		
		OAuth2AccessToken oauthToken;
		oauthToken = naverLoginBO.getAccessToken(session, code, state);
		log.info("토큰: "+oauthToken);
		//1. 로그인 사용자 정보를 읽어온다.
		apiResult = naverLoginBO.getUserProfile(oauthToken); //String형식의 json데이터
		/** apiResult json 구조
		{"resultcode":"00",
		"message":"success",
		"response":{"id":"33666449","nickname":"shinn****","age":"20-29","gender":"M","email":"sh@naver.com","name":"\uc2e0\ubc94\ud638"}}
		**/
		//2. String형식인 apiResult를 json형태로 바꿈
		JSONParser parser = new JSONParser();
		Object obj = parser.parse(apiResult);
		JSONObject jsonObj = (JSONObject) obj;
		//3. 데이터 파싱
		//Top레벨 단계 _response 파싱
		JSONObject response_obj = (JSONObject)jsonObj.get("response");
		//response의 nickname값 파싱
		String id = ((String)response_obj.get("id")).substring(0,20);
		log.info("암호화된 네이버 아이디 앞에서 20자리: "+id);
		String pw = (String)response_obj.get("id");
		log.info("기존의 암호화된 네이버 아이디를 비밀번호로 사용:" +pw);
		String name = (String)response_obj.get("name");
		String nick = (String)response_obj.get("nickname");
		log.info("네이버 닉네임: "+nick);
		String email = (String)response_obj.get("eamil");
		String phone = "0"+((String)response_obj.get("mobile_e164")).substring(3);

		MemberVO member = new MemberVO();
			member.setId(id);
			member.setPw(pw);
			member.setName(name);
			member.setNick(nick);
			member.setEmail(email);
			member.setPhone(phone);
		if(memberService.getMember(id)!=null) {
			log.info("네이버 아이디로 이미 가입한 회원");
			// 네이버 아이디로 이미 회원가입 한 경우
			// 바로 로그인 하러 가기~
			session.setAttribute("loginID", id);
			rttr.addFlashAttribute("msg", "'"+nick+"'님, 환영합니다♡");
			return "redirect:/main/main";
		} 
		// 네이버에서 사용하는 닉네임이 이미 DB에 존재할 경우
		if(memberService.getMemberNick(nick)!=null) {
			log.info("닉네임 :"+nick);
			rttr.addFlashAttribute("msg1", "'"+nick+"'"+"은 이미 존재하는 닉네임입니다.");
			rttr.addFlashAttribute("msg2", "새로운 닉네임 입력 페이지로 이동합니다.");
			session.setAttribute("member", member);
			return "/main/nickCheck";
		} else {
		
		
			// 네이버 정보로 회원가입한 적 없는 회원이 경우 자동 회원가입
			log.info("회원가입 한 적 없는 사용자입니다.");
			mainService.joinMember(member);
			
			// 해당 회원의 해당 연 월 가계부 자동 생성
			Calendar cal = Calendar.getInstance();
			int year = cal.get(Calendar.YEAR);
			int month = cal.get(Calendar.MONTH)+1;
			
			BookVO book = new BookVO();
			book.setBk_year(year);
			book.setBk_month(month);
			book.setId(id);
			book.setBk_budget(0);
			bookService.writeBook(book);
			
			//4.파싱 아이디 세션으로 저장
			session.setAttribute("loginID",id); //세션 생성
			
			rttr.addFlashAttribute("msg1", "'"+nick+"'님 회원가입 완료!");
			rttr.addFlashAttribute("msg2", "현재 임시 비밀번호 상태이니 마이페이지에서 	반드시 비밀번호를 변경해주세요.");
			
			log.info("어트리뷰트 생성 완료");
			return "/member/update";
		}
		
	}
	
	@RequestMapping(value="/nickCheck", method=RequestMethod.POST)
	public void nickCheckGET() throws Exception {
		log.info("닉네임 체크하러 이동");
	}
	
	@RequestMapping(value="/nickJoin", method=RequestMethod.POST)
	public String nickJoinPOST(String nick, HttpSession session, RedirectAttributes rttr) throws Exception {
		MemberVO member = (MemberVO)session.getAttribute("member");
		log.info("닉네임 확인 후 정보 불러오기: "+member);
		member.setNick(nick);
		mainService.joinMember(member);
		
		// 멤버의 정보를 담고 있던 세션 초기화 
		
		session.invalidate();
		// 해당 회원의 해당 연 월 가계부 자동 생성
		Calendar cal = Calendar.getInstance();
		int year = cal.get(Calendar.YEAR);
		int month = cal.get(Calendar.MONTH)+1;
		
		BookVO book = new BookVO();
		book.setBk_year(year);
		book.setBk_month(month);
		book.setId(member.getId());
		book.setBk_budget(0);
		bookService.writeBook(book);
		
		session.setAttribute("loginID",member.getId()); //세션 생성
		rttr.addFlashAttribute("msg", "'"+nick+"'님, 환영합니다♡");
					
		return"redirect:/main/main";
	}
	
	
	// http://localhost:8088/main/login
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String loginPOST(MemberVO vo, HttpSession session, RedirectAttributes rttr) throws Exception {
		log.info("♡♡♡♡♡♡♡♡♡♡♡♡♡♡♡♡♡♡♡♡♡♡♡loginPOST() 호출");
		// 사용자가 입력한 비밀번호 암호화
		String encryptPw = SHA256.encrypt(vo.getPw());
		log.info("암호화된 비밀번호"+encryptPw);
		// 암호화된 비밀번호로 수정
		vo.setPw(encryptPw);
		MemberVO vo2 = mainService.loginMember(vo);
		if (vo2 != null) {
			log.info("로그인 성공");
			session.setAttribute("loginID", vo2.getId());
			rttr.addFlashAttribute("msg", "'"+vo2.getNick()+"'님, 환영합니다♡");
			return "redirect:/main/main";
		} else {
			log.info("로그인 실패");
			rttr.addFlashAttribute("msg", "아이디가 없거나 아이디 또는 비밀번호가 일치하지 않습니다.");
			return "redirect:/main/login";
		}

	}
	
	
	// 2-1. 페이징 처리하기 
	// http://localhost:8088/main/NoticeListPage
	@RequestMapping (value = "/NoticeListPage", method = RequestMethod.GET)
	public String getNoticeListPage(PageVO vo, Model model) throws Exception {
		log.info("(♥♥♥♥♥ 2-1.getNoticeListPage) 호출됨");
		
		model.addAttribute("noticeList", noticeService.getNoticeListPage(vo));
		
		// 페이징 처리 하단부 정보 저장 + 모델 객체(pm)에 저장
		PageMakerVO pm = new PageMakerVO();
		pm.setVo(vo);
		int totalCnt = noticeService.getTotalCnt();
		pm.setTotalCnt(totalCnt); 
		model.addAttribute("pm", pm);
		log.info("(♥♥♥♥♥ 2-1.getNoticeListGET) PageMakerVO도 모델 객체에 저장 완 + pm: " + pm);
		
		// 세션에 객체 isUpdate 하나  만들어놓기~~~ 
		//    3()으로 정보 전달을 위해..
		log.info("(♥♥♥♥♥ 2-1.getNoticeListGET) 리턴타입 void라서 들어온 주소 /notice/list.jsp로 이동할 거");
		
		return "redirect:/main/noticeList?page="+vo.getPage();
	}
	
	// 2-2. 게시판 리스트 조회 GET                  
//	 http://localhost:8088/main/noticeList
	@RequestMapping (value = "/noticeList", method = RequestMethod.GET)
	public String getNoticeListAll(@ModelAttribute("pm") PageMakerVO pm, 
			@ModelAttribute("page") String page, 
			HttpSession session, Model model) throws Exception {
		log.info("(♥♥♥♥♥ 2.NoticeListAllGET) 호출됨");
		
		
		// 2. 걍 바로 리스트로 이동하는 경우
		
		List<NoticeVO> noticeList = noticeService.getNoticeListAll(pm);
		
		model.addAttribute("noticeList", noticeList);
		session.setAttribute("isUpdate", false);
		
		return "/main/noticeList";
	}
	// 2. 게시판 리스트 조회 GET 끝
	
	
	// 3. 글 본문 보기 GET                  
	// http://localhost:8088/main/noticeRead
	@RequestMapping (value = "/noticeRead", method = RequestMethod.GET)
	public String readGET(HttpSession session, Model model, 
			@RequestParam("nno") int nno, @RequestParam("page") int page) throws Exception{ 
		log.info("(♥♥♥♥♥ 3.readGET) 호출됨");
		
		log.info("(♥♥♥♥♥ 3.readGET) 넘어온 nno: " + nno);

		log.info("(♥♥♥♥♥ 3.readGET) isUpdate: " + session.getAttribute("isUpdate"));
		boolean isUpdate = (boolean)session.getAttribute("isUpdate");
		
		if(!isUpdate) { 
			noticeService.updateNoticeReadcount(nno);
			log.info("(♥♥♥♥♥ 3.readGET) " + nno + "번 글 조회수 1 증가 완");
			session.setAttribute("isUpdate", true);
		}
		
		log.info("(♥♥♥♥♥ 3.readGET) Service 호출 -> NoticeVO타입 리턴받고 -> 바로 model에 저장");
		model.addAttribute("vo", noticeService.getNotice(nno));
		
		log.info("(♥♥♥♥♥ 3.readGET) 리턴타입 void니까 들어온 주소  /notice/read.jsp로 이동할 거");
		return "/main/noticeRead";
	}
	
	
	
}
