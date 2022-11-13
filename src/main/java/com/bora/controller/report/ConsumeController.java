package com.bora.controller.report;

import java.util.List;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.bora.domain.report.BookDetailVO;
import com.bora.domain.report.BookVO;
import com.bora.service.report.ConsumeAllListService;

@Controller
@RequestMapping("/consume/*")
public class ConsumeController {
	
	@Inject
	HttpSession session;

	@Inject
	ConsumeAllListService cService;

	private static final Logger log = LoggerFactory.getLogger(BookController.class);
		
	// 소비 리스트 메서드
	@RequestMapping(value = "/consumeAllList", method = RequestMethod.GET)
	public String getConsumeAllList(Model model, BookDetailVO bookdetail, BookVO book,
			HttpServletRequest request) throws Exception {
		// 1. 저번 달 소비 리스트
		String loginID;
		// 전달된 정보 저장
		log.info("consumeLastMonList 호출됨");

		// 컨트롤러 -> 서비스 호출 (동작 메서드,,)
		log.info("consumeLastMonList -----> Service 호출됨");
		loginID = (String)session.getAttribute("loginID");	
		List<BookDetailVO> consumeLast = cService.getConsumeLastMonList(loginID);

		
		// 2. 이번 달 소비 리스트
		// 전달된 정보 저장
		log.info("consumeThisMonList 호출됨");

		// 컨트롤러 -> 서비스 호출 (동작 메서드,,)
		log.info("consumeThisMonList -----> Service 호출됨");

		List<BookDetailVO> consumeThis = cService.getConsumeThisMonList(loginID);

		
		// 3. 이번 소비 비교 리스트
		// 전달된 정보 저장
		log.info("consumeAllList 호출됨");

		// 컨트롤러 -> 서비스 호출 (동작 메서드,,)
		log.info("consumeAllList -----> Service 호출됨");
	        
		// 서비스 - 
		List<BookDetailVO> consumeList = cService.getConsumeAllList(loginID);
		log.info(" comsumeLast : "+consumeLast);
		log.info(" comsumeThis : "+consumeThis);
		log.info(" comsumeList : "+consumeList);
		
		model.addAttribute("consumeLast", consumeLast);
		model.addAttribute("consumeThis", consumeThis);
		model.addAttribute("consumeList", consumeList);
		
		return "report/consumeAllList";
	}

	
}
