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
import com.bora.domain.member.MemberVO;
import com.bora.domain.member.NaverLoginVO;
import com.bora.domain.report.BookVO;
import com.bora.service.MainService;
import com.bora.service.MemberService;
import com.bora.service.board.NoticeService;
import com.bora.service.report.BookService;
import com.github.scribejava.core.model.OAuth2AccessToken;
import com.google.gson.JsonObject;
import com.google.protobuf.TextFormat.ParseException;

@RequestMapping("/main/*")
@Controller
public class MainController {
	private static final Logger log = LoggerFactory.getLogger(MainController.class);

	@Inject
	MainService mainService;
	@Inject
	MemberService memberService;
	@Inject
	NoticeService noticeService;
	@Inject
	BookService bookService;
	
	@Inject
	private void setNaverLoginVO(NaverLoginVO naverVO) {
		this.naverVO = naverVO;
	}
	
	private NaverLoginVO naverVO;
	private String apiResult = null;
	
	
	
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

	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public void loginGET(Model model, HttpSession session) throws Exception {
		log.info("♡♡♡♡♡♡♡♡♡♡♡♡♡♡♡♡♡♡♡♡♡♡♡loginGET() 호출");
		
		
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
			rttr.addFlashAttribute("msg", vo2.getNick() + "님, 환영합니다♡");
			return "redirect:/main/main";
		} else {
			log.info("로그인 실패");
			rttr.addFlashAttribute("msg", "아이디가 없거나 아이디 또는 비밀번호가 일치하지 않습니다.");
			return "redirect:/main/login";
		}

	}
	// 네이버 아이디 로그인 시
	@RequestMapping(value = "/naver", method = {RequestMethod.GET, RequestMethod.POST})
	public String naverCoginGET(Model model, HttpSession session) throws Exception {
		log.info("♡♡♡♡♡♡♡♡♡♡♡♡♡♡♡♡♡♡♡♡♡♡♡loginGET() 호출");
			String naverAuthUrl = naverVO.getAuthorizationUrl(session);
			//http://localhost:8088/main/naver?code=Xaq08ynLPqVervmn2p&state=451623011891285564847791402461046066880
			log.info("네이버: "+naverAuthUrl);
			
			model.addAttribute("url", naverAuthUrl);
			return "redirect:/main/callback";
	}
	
	//네이버 로그인 성공시 callback호출 메소드
		@RequestMapping(value = "/callback", method = { RequestMethod.GET, RequestMethod.POST })
		public String callback(Model model, String code, String state, HttpSession session) throws Exception {
			
			System.out.println("여기는 callback");
			OAuth2AccessToken oauthToken;
	        oauthToken = naverVO.getAccessToken(session, code, state);
	 
	        //1. 로그인 사용자 정보를 읽어온다.
			apiResult = naverVO.getUserProfile(oauthToken);  //String형식의 json데이터
			
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
			String nickname = (String)response_obj.get("nickname");
	 
			System.out.println(nickname);
			
			//4.파싱 닉네임 세션으로 저장
			session.setAttribute("sessionId",nickname); //세션 생성
			
			model.addAttribute("result", apiResult);
		     
			return "/main/main";
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
		
		// 리스트로 가는 경우의 수
		// 1. 글쓰고 나서 -> 리스트로 이동하는 경우
//			log.info("(♥♥♥♥♥ 2.listAllGET) msg: " + msg);
			// 연결된 view 페이지로 저기서(1-2.registerPOST) 넘어온 정보 전달해보기
			// 이거 안 해도 넘어가는딩?
//			model.addAttribute("msg", msg);
		
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
