package com.bora.controller.report;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import com.bora.domain.report.BookDetailVO;
import com.bora.domain.report.BookVO;
import com.bora.persistence.report.BookDetailDAO;
import com.bora.service.report.BookService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import com.bora.controller.MemberController;
import com.bora.domain.board.PageMakerVO;
import com.bora.domain.openbank.card.prePaid.PrePaidTranVO;
import com.bora.service.report.ReportService;

@Controller
@RequestMapping("/report/*") 
public class ReportController {
	
	   @Inject
	   private ReportService service;
     
	   @Inject
	   private BookService bookService;
	
	   @Inject
	   private HttpSession session;
	
	   String loginID;

	   private static final Logger log = LoggerFactory.getLogger(MemberController.class);
	   
	   //카테고리 내역 불러오기
	   @RequestMapping(value="/categoryList", method = RequestMethod.GET)
	   public void categorylist() throws Exception{
		   log.info(" @@@@ categorylist() 호출 ");
		   List<PrePaidTranVO> categorylist = service.getCategoryList();
	   }
	   
}
