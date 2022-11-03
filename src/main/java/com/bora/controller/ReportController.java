package com.bora.controller;


import java.util.List;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.bora.controller.board.BoardController;
import com.bora.domain.CardPayVO;
import com.bora.domain.openbank.tran.TranVO;
import com.bora.domain.report.ReportVO;
import com.bora.service.ReportService;




@Controller
@RequestMapping("/report/*")
public class ReportController {

	private static final Logger log = LoggerFactory.getLogger(BoardController.class);
	
	
	  @Inject
	  private ReportService service;


	  //http://localhost:8080/report/sumAdd
	  //db컬럼에 계좌 입출금 자료 넣기
//	   @RequestMapping(value="/sumAdd", method = RequestMethod.GET)
//	   public void sumAddGET() throws Exception{
//	   
//		   log.info("@@@ sumAddGET()");
//	   }
//	   
//	   @RequestMapping(value="/sumAdd", method = RequestMethod.POST)
//	   public String sumAddPOST(TranVO tranvo) throws Exception{
//	 
//		   log.info("@@@ sumAddPOST()");
//		service.reportWrite(tranvo);
//		
//		return "redirect:/report/report1";
//	   }
	   
	   //http://localhost:8080/report/reportWrite
	   //db컬럼에 report 자료 넣기
	   @RequestMapping(value="/reportWrite", method = RequestMethod.GET)
	   public void reportWriteGET() throws Exception{
		   log.info("@@@ reportWriteGET()");
	   }
	   
	   @RequestMapping(value="/reportWrite", method = RequestMethod.POST)
	   public String reportWritePOST(ReportVO revo) throws Exception{
	 
		   log.info("@@@ reportWritePOST()");
		service.reportWrite2(revo);
		
		return "/report/report2";
	   }
	   
	   //전월 소비 지출 비교
	   @RequestMapping (value="/")
	   public void cpMonth() throws Exception{
		   
	   }
	   
	   //http://localhost:8080/report/addSum
	   //누적합 전달 비교

	   
	   //http://localhost:8080/report/book
	   // 이번달 예산 확인하기
	   @RequestMapping(value = "/book", method = RequestMethod.GET)
	   public void book() throws Exception{
		   log.info("@@@@ book()호출");
	   }
	   
	 
	   
	   }