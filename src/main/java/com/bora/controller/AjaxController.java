package com.bora.controller;

import java.util.List;

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
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.bora.domain.SHA256;
import com.bora.domain.board.BoardVO;
import com.bora.domain.board.PageMakerVO;
import com.bora.domain.board.PageVO;
import com.bora.domain.MemberVO;
import com.bora.service.MemberService;
import com.bora.service.board.BoardService;
import com.google.gson.JsonObject;

@Controller
public class AjaxController {

	private static final Logger log = LoggerFactory.getLogger(MemberController.class);

	@Inject
	private MemberService service;

	@Inject
	private BoardService boardService;
	
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
    	log.info("(ﾉ◕ヮ◕)ﾉ*:･ﾟ✧ ctgr() 호출됨");
    	log.info("(ﾉ◕ヮ◕)ﾉ*:･ﾟ✧ ctgr: " + ctgr);
    	
    	List<BoardVO> boardList = null;
    	if(ctgr.equals("알려줘BORA")||ctgr.equals("친해져BORA")||ctgr.equals("골라줘BORA")) {
    		boardList = boardService.getBoardListCtgr(vo, ctgr);
    		log.info("boardListCTGR 개수: "+boardList.size());
    	} else {
    		boardList = boardService.getBoardListPage(vo);
    		log.info("boardListALL 개수: "+boardList.size());
    	}
    	
    	log.info("vo: "+vo);
    	int cnt = boardService.getBoardCntCTGR(ctgr);
    	log.info("글 개수 :"+cnt);
    	PageMakerVO pm = new PageMakerVO();
    	vo = new PageVO();
    	pm.setVo(vo);
    	pm.setTotalCnt(cnt);
    	
    	session.setAttribute("isUpdate", false);
    	
    	log.info("pm: "+pm);
    	model.addAttribute("pm, pm");
    	ResponseEntity<List<BoardVO>> entity = new ResponseEntity<List<BoardVO>>(boardList, HttpStatus.OK);
    	return entity;
    }
    // 카테고리 ajax 끝 ==================================
}
