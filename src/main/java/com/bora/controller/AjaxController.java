package com.bora.controller;

import java.io.File;
import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.json.simple.JSONArray;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import com.bora.domain.SHA256;
import com.bora.domain.board.BoardVO;
import com.bora.domain.board.PageMakerVO;
import com.bora.domain.board.PageVO;
import com.bora.domain.member.MemberVO;
import com.bora.domain.openbank.account.AccountBalanceRequestVO;
import com.bora.domain.openbank.account.AccountBalanceResponseVO;
import com.bora.domain.openbank.card.bill.CardBillsVO;
import com.bora.domain.report.BookDetailVO;
import com.bora.domain.report.BookVO;
import com.bora.service.CardPayService;
import com.bora.service.MemberService;
import com.bora.service.board.BoardService;
import com.bora.service.openbank.OpenBankingService;
import com.bora.service.report.BookDetailService;
import com.bora.service.report.BookService;
import com.bora.service.report.ConsumeAllListService;
import com.bora.service.report.ReportService;

@Controller
@RestController
@RequestMapping("/ajax/*")
public class AjaxController {

	private static final Logger log = LoggerFactory.getLogger(MemberController.class);

	@Inject
	private MemberService service;

	@Inject
	private BoardService boardService;

	@Inject
	BookService bookService;

	@Inject
	BookDetailService detailService;

	@Inject
	ConsumeAllListService consumeService;

	@Inject
	HttpSession session;

	@Inject
	CardPayService cservice;

	@Inject
	ReportService rservice;
	
	@Autowired
	private OpenBankingService openBankingService;
	

	@RequestMapping(value = "/idcheck", method = RequestMethod.GET)
	public ResponseEntity<String> idcheck(HttpServletRequest request, RedirectAttributes rttr) throws Exception {

		String id = request.getParameter("id");
		MemberVO vo = service.getMember(id);
		log.info(vo + "");
		String result = "";

		if (vo != null) {
			result = "no";
			rttr.addFlashAttribute("idflag", true);
		} else
			result = "ok";

		ResponseEntity<String> entity = new ResponseEntity<String>(result, HttpStatus.OK);
		return entity;
	}

	@RequestMapping(value = "/nickcheck", method = RequestMethod.GET)
	public ResponseEntity<String> nickcheck(HttpServletRequest request) throws Exception {
		String nick = request.getParameter("nick");
		log.info("nick: " + nick);
		MemberVO vo = service.getMemberNick(nick);
		log.info("vo : " + vo);
		String result = "";

		if (vo != null)
			result = "no";
		else if (vo == null)
			result = "ok";
		log.info("♡♡♡♡♡♡♡♡♡♡♡♡♡♡♡♡♡♡result: " + result);
		ResponseEntity<String> entity = new ResponseEntity<String>(result, HttpStatus.OK);
		return entity;
	}

//   @RequestMapping(value="/member/phoneCheck", method=RequestMethod.POST)
//   public ResponseEntity<String> phoneCheck(HttpServletRequest request) throws Exception {
//      String result = "";
//      ResponseEntity<String> entity = new ResponseEntity<String>(result, HttpStatus.OK);
//      return entity;
//   }

	@RequestMapping(value = "/pwUpdateCheck", method = RequestMethod.POST)
	public ResponseEntity<String> pwUpdateCheck(HttpSession session, HttpServletRequest request) throws Exception {
		String pwUpdate = request.getParameter("pwUpdate");
		log.info("♡♡♡♡♡♡♡♡♡♡pwUpdate: " + pwUpdate);
		String id = (String) session.getAttribute("loginID");
		String result = "";
		MemberVO vo = service.getMember(id);
		if (pwUpdate.equals(vo.getPw())) {
			result = "no";
		} else {
			result = "ok";
		}
		ResponseEntity<String> entity = new ResponseEntity<String>(result, HttpStatus.OK);
		return entity;
	}

	// 회원이 탈퇴 시 비밀번호 입력하면 다시 한 번 탈퇴할건지 묻는 confirm 창 띄우기
	@RequestMapping(value = "/deleteCheck", method = RequestMethod.POST)
	public ResponseEntity<String> deleteCheck(HttpServletRequest reqeust, HttpSession session, RedirectAttributes rttr)
			throws Exception {
		log.info("♡♡♡♡♡♡♡♡♡♡♡♡♡♡♡♡♡♡♡♡♡♡♡♡♡♡♡♡deleteCheck()호출");
		// 회원이 입력한 비밀번호
		String encryptPw = SHA256.encrypt(reqeust.getParameter("pw"));
		// 로그인한 회원의 회원 정보
		String id = (String) session.getAttribute("loginID");
		MemberVO vo = service.getMember(id);

		// 결과를 담을 변수
		String result = "";

		// 회원이 입력한 비밀번호와 DB에 있는 비밀번호 일치 확인
		if (encryptPw.equals(vo.getPw())) {
			log.info("♡♡♡♡♡♡♡♡♡♡♡♡♡♡♡ 비밀번호 일치");
			// 일치할 경우 메세지 ok 보내기
			result = "ok";
		}
		ResponseEntity<String> entity = new ResponseEntity<String>(result, HttpStatus.OK);
		return entity;
	}

	
	// 카테고리 ajax ========================================
	@RequestMapping(value = "/ctgr", method = RequestMethod.GET)
	public ResponseEntity<List<BoardVO>> ctgr(@RequestParam("ctgr") String ctgr,  @RequestParam("startNum") Integer startNum) throws Exception {
		log.info("(ﾉ◕ヮ◕)ﾉ*:･ﾟ✧ ctgr() 호출됨");
		log.info("(ﾉ◕ヮ◕)ﾉ*:･ﾟ✧ ctgr: " + ctgr + " / startNum: " + startNum);
		
		List<BoardVO> boardListCtgr = null;
		if (ctgr.equals("알려줘BORA") || ctgr.equals("친해져BORA") || ctgr.equals("골라줘BORA")) {
//			boardService.getBoardCntCTGR(ctgr);
			boardListCtgr = boardService.getBoardListCtgr(ctgr, startNum);
			log.info("boardList.size", boardListCtgr.size());
		} else {
			log.info(" 실팹니다,,,");
		}
		
		// 조회수때메..
		session.setAttribute("isUpdate", false);
		
		ResponseEntity<List<BoardVO>> entity = new ResponseEntity<List<BoardVO>>(boardListCtgr, HttpStatus.OK);
		return entity;
	}
	
	
	// 카테고리별 총 글 개수만 리턴
	@RequestMapping(value = "/ctgr/count", method = RequestMethod.GET)
	public Integer ctgrCount(@RequestParam("ctgr") String ctgr) throws Exception {
		log.info("(ﾉ◕ヮ◕)ﾉ*:･ﾟ✧ ctgrCount()  호출됨");
		log.info("(ﾉ◕ヮ◕)ﾉ*:･ﾟ✧ ctgrCount()  ctgr: " + ctgr);
		return boardService.getBoardCntCTGR(ctgr);
	}
	
	
	// 카테고리 더보기 버턴 눌렀을 때
	@RequestMapping(value = "/ctgr/getMoreList", method = RequestMethod.GET)
	public ResponseEntity<List<BoardVO>> ctgrGetMoreList(@RequestParam("ctgr") String ctgr, @RequestParam("startNum") Integer startNum) throws Exception {
		log.info("(ﾉ◕ヮ◕)ﾉ*:･ﾟ✧ ctgrGetMoreList() 호출됨");
		log.info("(ﾉ◕ヮ◕)ﾉ*:･ﾟ✧ ctgrGetMoreList() ctgr: " + ctgr + " / startNum: " + startNum);
		
		List<BoardVO> boardListCtgr = null;
		if (ctgr.equals("알려줘BORA") || ctgr.equals("친해져BORA") || ctgr.equals("골라줘BORA")) {
//			boardService.getBoardCntCTGR(ctgr);
			boardListCtgr = boardService.getBoardListCtgr(ctgr, startNum);
			log.info("(ﾉ◕ヮ◕)ﾉ*:･ﾟ✧ ctgrGetMoreList() boardListCtgr.size: " + boardListCtgr.size());
		} else {
			log.info("(ﾉ◕ヮ◕)ﾉ*:･ﾟ✧ ctgrGetMoreList() 실팹니다,,");
			return null;
		}
		
		// for 조회수
		session.setAttribute("isUpdate", false);
		
		ResponseEntity<List<BoardVO>> entity = new ResponseEntity<List<BoardVO>>(boardListCtgr, HttpStatus.OK);
		return entity;
	}
	// 카테고리 ajax 끝 ==================================

	
	
	@RequestMapping(value = "/writeBudget", method = RequestMethod.POST)
	public String writeBudget(Integer bk_num, Integer bk_budget, Integer year, Integer month, RedirectAttributes rttr)
			throws Exception {
		log.info("writeBudget()	호출");

		String loginID = (String) session.getAttribute("loginID");

		// 해당 연 월의 가계부 뽑아오기
		BookVO book = bookService.getMonthBook(year, month, loginID);

		if (book != null) {
			book.setBk_budget(bk_budget);
			log.info("입력한 예산: " + bk_budget);
			int result = bookService.updateBook(book);
			if (result == 1) {
				log.info("예산 입력 성공");
				rttr.addFlashAttribute("msg", "ok");
				return Integer.toString(bk_budget);
			} else {
				log.info("예산 입력 실패");
				rttr.addFlashAttribute("msg", "no");
				return "redirect:/report/list";
			}
		} else {
			log.info("해당 연월의 가계부가 아직 입력되지 않아 새로 생성");
			book = new BookVO();
			book.setBk_year(year);
			book.setBk_month(month);
			book.setBk_budget(bk_budget);
			book.setId(loginID);
			bookService.writeBook(book);
			log.info("예산 입력 성공");
			return Integer.toString(bk_budget);
		}

	}

	// 썸머노트 파일 업로드
	@RequestMapping(value = "/resources/summerimages", method = RequestMethod.POST)
	public ResponseEntity<?> summerimage(@RequestParam("file") MultipartFile img, HttpServletRequest request)
			throws IOException {
		String path = request.getServletContext().getRealPath("resources/upload");
		Random random = new Random();

		long currentTime = System.currentTimeMillis();
		int randomValue = random.nextInt(100);
		String fileName = Long.toString(currentTime) + "_" + randomValue + "_a_" + img.getOriginalFilename();

		File file = new File(path, fileName);
		img.transferTo(file);
		return ResponseEntity.ok().body("resources/summerimages/" + fileName);

	}

	@RequestMapping(value = "/consume/listJson1", method = RequestMethod.GET)
	public ResponseEntity<List<BookDetailVO>> list1(HttpServletRequest request) throws Exception {

		List<BookDetailVO> list1 = consumeService.getConsumeLastMonList("admin");

		ResponseEntity<List<BookDetailVO>> entity = new ResponseEntity<List<BookDetailVO>>(list1, HttpStatus.OK);
		// List<ConsumeLastMonListVO> => 자동으로 json 변경하는 프로그램 설치
		// jackson-databind
		return entity;
	}

	@RequestMapping(value = "/consume/listJson2", method = RequestMethod.GET)
	public ResponseEntity<List<BookDetailVO>> list2(HttpServletRequest request) throws Exception {

		List<BookDetailVO> list2 = consumeService.getConsumeThisMonList("admin");

		ResponseEntity<List<BookDetailVO>> entity = new ResponseEntity<List<BookDetailVO>>(list2, HttpStatus.OK);
		// List<ConsumeThisMonListVO> => 자동으로 json 변경하는 프로그램 설치
		// jackson-databind
		return entity;
	}

	@RequestMapping(value = "/consume/listJson3", method = RequestMethod.GET)
	public ResponseEntity<List<BookDetailVO>> list3(HttpServletRequest request) throws Exception {

		List<BookDetailVO> list3 = consumeService.getConsumeAllList("admin");

		ResponseEntity<List<BookDetailVO>> entity = new ResponseEntity<List<BookDetailVO>>(list3, HttpStatus.OK);
		// List<ConsumeAllListVO> => 자동으로 json 변경하는 프로그램 설치
		// jackson-databind
		return entity;
	}

	@RequestMapping(value = "/bookTop3", method = RequestMethod.GET)
	public ResponseEntity<List<BookDetailVO>> top3(HttpServletRequest request, @RequestParam("year") Integer year,
			@RequestParam("month") Integer month, @RequestParam("loginID") String loginID) throws Exception {

		List<BookDetailVO> top3 = rservice.Top3Store(year, month, loginID);

		ResponseEntity<List<BookDetailVO>> entity = new ResponseEntity<List<BookDetailVO>>(top3, HttpStatus.OK);
		// List<ConsumeAllListVO> => 자동으로 json 변경하는 프로그램 설치
		// jackson-databind

		log.info(top3 + "");
		return entity;
	}

	@RequestMapping(value = "/bookTop3Date", method = RequestMethod.GET)
	public ResponseEntity<List<BookDetailVO>> top3Date(HttpServletRequest request, @RequestParam("year") Integer year,
			@RequestParam("month") Integer month, @RequestParam("loginID") String loginID) throws Exception {

		List<BookDetailVO> top3Date = rservice.Top3Date(year, month, loginID);

		ResponseEntity<List<BookDetailVO>> entity = new ResponseEntity<List<BookDetailVO>>(top3Date, HttpStatus.OK);
		// List<ConsumeAllListVO> => 자동으로 json 변경하는 프로그램 설치
		// jackson-databind

		log.info(top3Date + "");
		return entity;
	}

	@RequestMapping(value = "/category2", method = RequestMethod.GET)
	public ResponseEntity<Map<String, List>> categorylist(HttpServletRequest request,
			@RequestParam("year") Integer year, @RequestParam("month") Integer month,
			@RequestParam("loginID") String loginID) throws Exception {

		ArrayList sumArr = new ArrayList();
		ArrayList<String> caArr = new ArrayList<String>();

		for (BookDetailVO bkVO : rservice.cateSum(year, month, loginID)) {
			sumArr.add(bkVO.getBk_sum());
			caArr.add("'" + bkVO.getBk_category() + "'");
		}

		Map<String, List> map = new HashMap<String, List>();

		map.put("sumArr", sumArr);
		map.put("caArr", caArr);

//      ResponseEntity<List<BookDetailVO>> entity=
//            new ResponseEntity<List<BookDetailVO>>(categorylist,HttpStatus.OK);
		ResponseEntity<Map<String, List>> entity = new ResponseEntity<Map<String, List>>(map, HttpStatus.OK);
		// List<ConsumeAllListVO> => 자동으로 json 변경하는 프로그램 설치
		// jackson-databind

		log.info(map + "");
		return entity;
	}

	// 목돈 모으기 페이지에서 넘어온 데이터들 처리
//	@ResponseBody 
	@RequestMapping(value = "/moa", method = RequestMethod.GET)
	public Map<String, Object> moaCalc(@RequestParam("gapMoney") Double gapMoney,
			@RequestParam("gapDate") Double gapDate) throws Exception {
		log.info("(●'◡'●) moaCalc 호출됨");
		log.info("(●'◡'●) moaCalc  gapMoney: " + gapMoney + " / gapDate: " + gapDate);

		// gapMoney를 하루, 한 달, 일 년으로 나누기~~
		double moaOneDay = gapMoney / gapDate;
		log.info("(●'◡'●) moaCalc  하루에 모아야 할 돈: " + moaOneDay + "만원");
		double moaOneMonth = gapMoney / (gapDate / 30.0);
		log.info("(●'◡'●) moaCalc  한 달에 모아야 할 돈: " + moaOneMonth + "만원");
		double moaOneYear = gapMoney / (gapDate / 365.0);
		log.info("(●'◡'●) moaCalc  일 년에 모아야 할 돈: " + moaOneYear + "만원");

		Map<String, Object> map = new HashMap<String, Object>();
		map.put("moaOneDay", String.format("%.2f", moaOneDay));
		map.put("moaOneMonth", String.format("%.2f", moaOneMonth));
		map.put("moaOneYear", String.format("%.2f", moaOneYear));
		log.info("(●'◡'●) moaCalc  다 담고 나서 map: " + map);

		return map;
	}

	@RequestMapping(value = "/consumeTag", method = RequestMethod.GET)
	public ResponseEntity<List<BookDetailVO>> consumeTag(HttpServletRequest request, @RequestParam("year") Integer year,
			@RequestParam("month") Integer month, @RequestParam("loginID") String loginID) throws Exception {

		List<BookDetailVO> consumeTag = rservice.ConsumeTag(year, month, loginID);

		ResponseEntity<List<BookDetailVO>> entity = new ResponseEntity<List<BookDetailVO>>(consumeTag, HttpStatus.OK);

		log.info(consumeTag + "");
		return entity;
	}

	// 전월대비
	@RequestMapping(value = "/consumeList", method = RequestMethod.GET)
	public ResponseEntity<List<BookDetailVO>> consumeList(HttpServletRequest request,
			@RequestParam("year") Integer year, @RequestParam("month") Integer month,
			@RequestParam("loginID") String loginID) throws Exception {

		List<BookDetailVO> consumeList = rservice.getConsumeMinus(year, month, loginID);

		for (int i = 0; i < consumeList.size(); i++) {
			BookDetailVO detail = consumeList.get(i);
			if (detail.getBk_minus() == null) {
				detail.setBk_minus(0);
			} else continue;
		}
		
		log.info("바꾼 정보: " + consumeList);
		ResponseEntity<List<BookDetailVO>> entity = new ResponseEntity<List<BookDetailVO>>(consumeList, HttpStatus.OK);

		log.info(consumeList + "");
		return entity;
	}

	// 메인에서 커뮤니티 최신글 목록 5개 불러오기
	@RequestMapping(value = "/getList5", method = RequestMethod.GET)
	public ResponseEntity<List<BoardVO>> getBoardList5() throws Exception {
		log.info(" (ﾉ◕ヮ◕)ﾉ*:･ﾟ✧ getBoardList5() 호출됨");

		return new ResponseEntity<List<BoardVO>>(boardService.getList5(), HttpStatus.OK);
	}
	
		//오픈뱅킹 잔액값1 불러오기
		@RequestMapping(value = "/accountBalanceAjax1", method = RequestMethod.GET)
		public @ResponseBody AccountBalanceResponseVO getAccountBalanceAjax1( AccountBalanceRequestVO accountBalanceRequestVO, Model model) {
			log.info("🐧🐧🐧🐧🐧🐧🐧🐧🐧🐧🐧🐧🐧   계좌 잔액 조회" + accountBalanceRequestVO);
			log.info("/openbank/acct_balance 로 이동");
			log.info(accountBalanceRequestVO + "");

			AccountBalanceResponseVO accountBalance = openBankingService.findAccountBalance(accountBalanceRequestVO);

			// Model 객체에 AccountcancelResponseVO 객체와 엑세스토큰 저장
			model.addAttribute("accountBalance", accountBalance);
//			session.setAttribute("bank_tran_id", accountBalanceRequestVO.getBank_tran_id());
			session.setAttribute("fintech_use_num", accountBalanceRequestVO.getFintech_use_num());

			log.info("fintech_use_num : " + accountBalanceRequestVO.getFintech_use_num());
			log.info("tran_dtime : " + accountBalanceRequestVO.getTran_dtime());
			log.info("accountBalance : " + accountBalance);

			return accountBalance;
		}

		//오픈뱅킹 잔액값2 불러오기
		@RequestMapping(value = "/accountBalanceAjax2", method = RequestMethod.GET)
		public @ResponseBody AccountBalanceResponseVO getAccountBalanceAjax2( AccountBalanceRequestVO accountBalanceRequestVO, Model model) {
			log.info("🐧🐧🐧🐧🐧🐧🐧🐧🐧🐧🐧🐧🐧   계좌 잔액 조회" + accountBalanceRequestVO);
			log.info("/openbank/acct_balance 로 이동");
			log.info(accountBalanceRequestVO + "");
			
			AccountBalanceResponseVO accountBalance = openBankingService.findAccountBalance(accountBalanceRequestVO);
			
			// Model 객체에 AccountcancelResponseVO 객체와 엑세스토큰 저장
			model.addAttribute("accountBalance", accountBalance);
//			session.setAttribute("bank_tran_id", accountBalanceRequestVO.getBank_tran_id());
			session.setAttribute("fintech_use_num", accountBalanceRequestVO.getFintech_use_num());
			
			log.info("fintech_use_num : " + accountBalanceRequestVO.getFintech_use_num());
			log.info("tran_dtime : " + accountBalanceRequestVO.getTran_dtime());
			log.info("accountBalance : " + accountBalance);
			
			return accountBalance;
		}
	
	

}// class AjaxController
