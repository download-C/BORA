package com.bora.controller.report;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.bora.domain.report.BookVO;
import com.bora.service.report.BookService;

@RequestMapping("/report/*")
@Controller
public class ReportController {
	
	@Inject
	BookService bookService;
	
	@Inject
	HttpSession session;
	
	String loginID;
	
	private static final Logger log = LoggerFactory.getLogger(ReportController.class);
	
	@RequestMapping(value="/dashboard", method = RequestMethod.GET)
	public void reportDashboardGET(Model model) throws Exception{
		log.info("reportDashboardGET() 호출");
		loginID = (String)session.getAttribute("loginID");
		// 이번 달의 가계부 목록 가져가기
		Calendar cal = Calendar.getInstance();
		int year = cal.get(Calendar.YEAR);
		int month = cal.get(Calendar.MONTH)+1;
		log.info("올해: "+year+"년");
		List<BookVO> bookList = new ArrayList<BookVO>();
	
		bookList = bookService.getMonthBookList(year, month, loginID);
		model.addAttribute("bookList", bookList);
		model.addAttribute("year",year);
		model.addAttribute("month",month);
		model.addAttribute("bk_num", bookService.getMonthBook(year, month, loginID).getBk_num());
		model.addAttribute("bk_budget", bookService.getMonthBook(year, month, loginID).getBk_budget());
		log.info(year+"년 "+month+"달 가계부 불러오기");
	}
	
	
	
}
