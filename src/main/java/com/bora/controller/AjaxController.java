package com.bora.controller;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Random;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
import com.bora.domain.report.BookVO;
import com.bora.domain.MemberVO;
import com.bora.service.MemberService;
import com.bora.service.board.BoardService;
import com.bora.service.report.BookDetailService;
import com.bora.service.report.BookService;
import com.google.gson.JsonObject;

@Controller
@RestController
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
	HttpSession session;
	
	
	@RequestMapping(value = "/member/idcheck", method = RequestMethod.GET)
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

	@RequestMapping(value = "/member/nickcheck", method = RequestMethod.GET)
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

//	@RequestMapping(value="/member/phoneCheck", method=RequestMethod.POST)
//	public ResponseEntity<String> phoneCheck(HttpServletRequest request) throws Exception {
//		String result = "";
//		ResponseEntity<String> entity = new ResponseEntity<String>(result, HttpStatus.OK);
//		return entity;
//	}

	@RequestMapping(value = "/member/pwUpdateCheck", method = RequestMethod.POST)
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
    @RequestMapping(value="/member/deleteCheck", method=RequestMethod.POST)
    public ResponseEntity<String> deleteCheck(HttpServletRequest reqeust, HttpSession session,
	 	   RedirectAttributes rttr) throws Exception {
    	log.info("♡♡♡♡♡♡♡♡♡♡♡♡♡♡♡♡♡♡♡♡♡♡♡♡♡♡♡♡deleteCheck()호출");
    	// 회원이 입력한 비밀번호
    	String encryptPw= SHA256.encrypt(reqeust.getParameter("pw"));
	    // 로그인한 회원의 회원 정보
	    String id = (String)session.getAttribute("loginID");
	    MemberVO vo = service.getMember(id);
	    
	    // 결과를 담을 변수
	    String result = "";
	   
 	    // 회원이 입력한 비밀번호와 DB에 있는 비밀번호 일치 확인
 	    if(encryptPw.equals(vo.getPw())) {
 	    	log.info("♡♡♡♡♡♡♡♡♡♡♡♡♡♡♡ 비밀번호 일치");
 		    // 일치할 경우 메세지 ok 보내기
 	    	result = "ok";
 	    } 
 	    ResponseEntity<String> entity = new ResponseEntity<String>(result, HttpStatus.OK);
 	    return entity;
    }
    
    // 카테고리 ajax ========================================
    @RequestMapping(value = "/ajax/ctgr", method = RequestMethod.GET)
    public ResponseEntity<List<BoardVO>> ctgr(@RequestParam("ctgr") String ctgr,
    		String pageStart, HttpSession session, PageVO vo,
    		Model model) throws Exception {
    	int cnt = 0;
    	PageMakerVO pm = new PageMakerVO();
    	log.info("(ﾉ◕ヮ◕)ﾉ*:･ﾟ✧ ctgr() 호출됨");
    	log.info("(ﾉ◕ヮ◕)ﾉ*:･ﾟ✧ ctgr: " + ctgr);

    	List<BoardVO> boardList = null;
    	if(ctgr.equals("알려줘BORA")||ctgr.equals("친해져BORA")||ctgr.equals("골라줘BORA")) {
    		
    		cnt = boardService.getBoardCntCTGR(ctgr);
        	log.info("글 개수 :"+cnt);
        	vo = new PageVO();
        	log.info("vo: "+vo);
        	pm.setVo(vo);
        	pm.setTotalCnt(cnt);
    		boardList = boardService.getBoardListCtgr(pm, ctgr);
    		log.info("boardListCTGR 개수: "+boardList.size());
    	} else {
    		cnt = boardService.getBoardCnt();
        	log.info("글 개수 :"+cnt);
        	vo = new PageVO();
        	pm.setVo(vo);
        	pm.setTotalCnt(cnt);
    		boardList = boardService.getBoardListPage(vo);
    		log.info("boardListALL 개수: "+boardList.size());
    	}
    	session.setAttribute("isUpdate", false);
    	
    	log.info("pm: "+pm);
//    	model.addAttribute("pm", pm);
    	ResponseEntity<List<BoardVO>> entity = new ResponseEntity<List<BoardVO>>(boardList, HttpStatus.OK);
    	return entity;
    }
    
    @RequestMapping(value = "/ajax/paging", method = RequestMethod.GET)
    public ResponseEntity<PageMakerVO> paging(@RequestParam("ctgr") String ctgr,
    		String pageStart, HttpSession session, PageVO vo,
    		Model model) throws Exception {
    	int cnt = 0;
    	PageMakerVO pm = new PageMakerVO();
    	log.info("(ﾉ◕ヮ◕)ﾉ*:･ﾟ✧ ctgr() 호출됨");
    	log.info("(ﾉ◕ヮ◕)ﾉ*:･ﾟ✧ ctgr: " + ctgr);

    	List<BoardVO> boardList = null;
    	if(ctgr.equals("알려줘BORA")||ctgr.equals("친해져BORA")||ctgr.equals("골라줘BORA")) {
    		
    		cnt = boardService.getBoardCntCTGR(ctgr);
        	log.info("글 개수 :"+cnt);
        	vo = new PageVO();
        	log.info("vo: "+vo);
        	pm.setVo(vo);
        	pm.setTotalCnt(cnt);
    		boardList = boardService.getBoardListCtgr(pm, ctgr);
    		log.info("boardListCTGR 개수: "+boardList.size());
    	} else {
    		cnt = boardService.getBoardCnt();
        	log.info("글 개수 :"+cnt);
        	vo = new PageVO();
        	pm.setVo(vo);
        	pm.setTotalCnt(cnt);
    		boardList = boardService.getBoardListPage(vo);
    		log.info("boardListALL 개수: "+boardList.size());
    	}
    	session.setAttribute("isUpdate", false);
    	
    	log.info("pm: "+pm);
    	model.addAttribute("pm", pm);
    	ResponseEntity<PageMakerVO> entity = new ResponseEntity<PageMakerVO>(pm, HttpStatus.OK);
    	return entity;
    }
    // 카테고리 ajax 끝 ==================================
    

	@RequestMapping(value="/ajax/writeBudget", method=RequestMethod.POST)
	public Integer writeBudget(Integer bk_budget, Integer year,
			Integer month, RedirectAttributes rttr)throws Exception {
		log.info("writeBudget()	호출");
		log.info(year+"년 "+month+"월 예산 입력하기");
		String loginID = (String)session.getAttribute("loginID");
		int result = 0;
		int db_budget = bookService.getMonthBudget(loginID, year, month);
		
		if(db_budget>=0 ) {
			result = bookService.updateMonthBudget(loginID, year, month, bk_budget);
			if(result ==1 ) {
				log.info("예산 입력 성공");
				rttr.addFlashAttribute("msg", "ok");
			} else {
				log.info("예산 입력 실패");
				rttr.addFlashAttribute("msg", "no");
			}
		} else {
			// DB에 해당 연월에 대한 가계부가 없어서 새로 생성해야 할 때
			BookVO book = new BookVO();
			book.setBk_year(year);
			book.setBk_month(month);
			book.setId(loginID);
			book.setBk_budget(bk_budget);
			bookService.writeBook(book);
		}
		return bk_budget;
	}


    // 썸머노트 파일 업로드 
    @RequestMapping(value="resources/summerimages", method=RequestMethod.POST)
	public ResponseEntity<?> summerimage(@RequestParam("file") MultipartFile img, HttpServletRequest request) throws IOException {
		String path = request.getServletContext().getRealPath("resources/upload");
		Random random = new Random();
	
		long currentTime = System.currentTimeMillis();
		int	randomValue = random.nextInt(100);
		String fileName = Long.toString(currentTime) + "_"+randomValue+"_a_"+img.getOriginalFilename();
		
		File file = new File(path , fileName);
		img.transferTo(file);
		return ResponseEntity.ok().body("resources/summerimages/"+fileName);

	}
    
    
    
    
}// class AjaxController
