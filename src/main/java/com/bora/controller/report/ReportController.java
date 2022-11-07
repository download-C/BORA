package com.bora.controller.report;

import java.util.List;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.bora.controller.MemberController;
import com.bora.domain.openbank.card.prePaid.PrePaidTranVO;
import com.bora.service.report.ReportService;

@Controller
@RequestMapping("/report/*") 
public class ReportController {
	
	 @Inject
	   private ReportService service;

	   private static final Logger log = LoggerFactory.getLogger(MemberController.class);
	   
	   //카테고리 내역 불러오기
	   @RequestMapping(value="/categoryList", method = RequestMethod.GET)
	   public void categorylist() throws Exception{
		   log.info(" @@@@ categorylist() 호출 ");
		   List<PrePaidTranVO> categorylist = service.getCategoryList();
	   }
	
			
		
	
}
