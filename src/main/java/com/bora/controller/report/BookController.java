package com.bora.controller.report;

import java.util.List;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.bora.domain.report.BookAllListVO;
import com.bora.domain.report.BookDetailVO;
import com.bora.domain.report.BookLastMonListVO;
import com.bora.domain.report.BookThisMonListVO;
import com.bora.domain.report.BookVO;
import com.bora.service.report.BookAllListService;
import com.bora.service.report.BookDetailService;
import com.bora.service.report.BookService;

@Controller
@RequestMapping("/book/*")
public class BookController {


	@Inject
	BookService service;
	
	@Inject
	BookDetailService dService;
	
	@Inject
	BookAllListService aService;

	private static final Logger log = LoggerFactory.getLogger(BookController.class);
	

	// http://localhost:8088/book/write
	@RequestMapping(value="/write", method = RequestMethod.GET)
	public void writeBookGET() {
		log.info("writeBookGET() 호출");
	}
	
	// 1. 가계부 상세 내역 작성 메서드
	@RequestMapping(value="/write", method = RequestMethod.POST)
	public String wirteBookPOST(HttpServletRequest request,
			HttpSession session, RedirectAttributes rttr) throws Exception {
		String id = (String)session.getAttribute("loginID");
		int bk_day = Integer.parseInt(request.getParameter("bk_day"));
		String bk_iow = request.getParameter("bk_iow");
		String bk_group = request.getParameter("bk_group");
		String bk_category = request.getParameter("bk_category");
		int bk_money = Integer.parseInt(request.getParameter("bk_money"));
		String bk_memo = request.getParameter("bk_memo");
		
		BookDetailVO detail = new BookDetailVO();
		detail.setId(id);
		detail.setBk_day(bk_day);
		detail.setBk_iow(bk_iow);
		detail.setBk_group(bk_group);
		detail.setBk_category(bk_category);
		detail.setBk_money(bk_money);
		detail.setBk_memo(bk_memo);
		
		int bk_detail_num = dService.writeBookDetail(detail);
		BookVO vo = new BookVO();
		vo.setId(id);
		vo.setBk_detail_num(bk_detail_num);
		// detail 매퍼, 서비스, dao에 글 번호 가져오는 거 만들어야됨~~ 
		service.writeBook(vo, detail);
		
		
		return "/book/listPage";
	}
	
	// 2. 저번달 가계부 소비내역 리스트
	@RequestMapping(value = "/bookLastMonList", method = RequestMethod.GET)
		public void getBookLastMonList(Model model) throws Exception {
		// 전달된 정보 저장
		log.info("bookLastMonList 호출됨");

		// 컨트롤러 -> 서비스 호출 (동작 메서드,,)
		log.info("bookLastMonList -----> Service 호출됨");
		
		List<BookLastMonListVO> bookLastMonList = aService.getBookLastMonList("admin");

		model.addAttribute("bookLastMonlist", bookLastMonList);
	}
	
	// 3. 이번달 가계부 소비 리스트
	@RequestMapping(value = "/bookThisMonList", method = RequestMethod.GET)
	     public void getBookThisMonList(Model model) throws Exception {
		 // 전달된 정보 저장
		 log.info("bookThisMonList 호출됨");

		 // 컨트롤러 -> 서비스 호출 (동작 메서드,,)
		 log.info("bookThisMonList -----> Service 호출됨");

		 List<BookThisMonListVO> bookThisMonList = aService.getBookThisMonList("admin");

		 model.addAttribute("bookThisMonlist", bookThisMonList);
	}
	
	// 4. 가계부 리스트 메서드
	@RequestMapping(value = "/bookAllList", method = RequestMethod.GET)
	public void getBookAllList(Model model) throws Exception {
		// 전달된 정보 저장
		log.info("bookAllList 호출됨");

		// 컨트롤러 -> 서비스 호출 (동작 메서드,,)
		log.info("bookAllList -----> Service 호출됨");
        
		// 서비스 - 
		List<BookAllListVO> bookAllList = aService.getBookAllList("admin");

		model.addAttribute("bookLastMonlist", bookAllList);

    }
	
}
