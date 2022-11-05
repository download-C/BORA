package com.bora.controller.report;

import java.util.List;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.bora.domain.report.BookDetailVO;
import com.bora.domain.report.BookVO;
import com.bora.service.report.BookDetailService;
import com.bora.service.report.BookService;

@Controller
@RequestMapping("/book/*")
public class BookController {


	@Inject
	BookService service;
	
	@Inject
	BookDetailService dService;

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
		int bk_year = Integer.parseInt(request.getParameter("bk_year"));
		int bk_month = Integer.parseInt(request.getParameter("bk_month"));
		int bk_day = Integer.parseInt(request.getParameter("bk_day"));
		String bk_iow = request.getParameter("bk_iow");
		String bk_group = request.getParameter("bk_group");
		String bk_category = request.getParameter("bk_category");
		int bk_money = Integer.parseInt(request.getParameter("bk_money"));
		String bk_title = request.getParameter("bk_title");
		String bk_memo = request.getParameter("bk_memo");
		
		// 가계부 상세정보 받아서 BookDetailVO에 저장
		BookDetailVO detail = new BookDetailVO();
		detail.setId(id);
		detail.setBk_day(bk_day);
		detail.setBk_iow(bk_iow);
		detail.setBk_group(bk_group);
		detail.setBk_category(bk_category);
		detail.setBk_money(bk_money);
		detail.setBk_memo(bk_memo);
		
		// 디테일 정보 DB 저장 후 해당 내용의 가계부 고유번호 가져오기
		dService.writeBookDetail(detail);
		int bk_detail_num = dService.getBookDetailMaxNum();
		
		// 디테일 번호 가져왔을 경우 BookVO 생성 후 DB 저장 -> 리스트로 이동
		if(bk_detail_num != 0) {
			BookVO vo = new BookVO();
			vo.setId(id);
			vo.setBk_year(bk_year);
			vo.setBk_month(bk_month);
			vo.setBk_detail_num(bk_detail_num);			
			service.writeBook(vo);
			log.info("가계부 작성 성공! 리스트로 이동");
			rttr.addFlashAttribute("msg", "가계부 작성이 완료되었습니다.");
			return "/book/bookList";
		} else {
			log.info("가계부 작성 실패");
			rttr.addFlashAttribute("msg", "가계부 작성에 실패했습니다.");
			return "redirect:/book/write";
		}
		
	}
	
	@RequestMapping(value="/bookList", method=RequestMethod.GET)
	public void bookListGET() throws Exception {
		log.info("bookListGET()호출");
	}
}
