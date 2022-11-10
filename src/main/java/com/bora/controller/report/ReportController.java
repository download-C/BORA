package com.bora.controller.report;

import java.util.ArrayList;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.bora.controller.MemberController;
import com.bora.domain.report.BookDetailVO;
import com.bora.service.report.ReportService;

@Controller
@RequestMapping("/report/*") 
public class ReportController {
	
	   @Inject
	   private ReportService service;
	  

	   
	   @Inject
	   HttpSession session;
	
	   String loginID;


	   private static final Logger log = LoggerFactory.getLogger(MemberController.class);
	   
	   // http://localhost:8088/report/report
	   //리포트 메인 페이지
	   @RequestMapping(value = "/report", method = RequestMethod.GET)
	   public String reportGET(RedirectAttributes rttr) throws Exception {
		   log.info(" φ(._.) reportGET()호출 ");
		   loginID = (String)session.getAttribute("loginID");
		  // 로그인 안 한 경우 로그인 페이지로 이동
		   if(loginID == null) {
		   rttr.addFlashAttribute("msg", "로그인 후 이용 가능한 페이지입니다.");
		   return "redirect:/main/login";
		   }
		return "/report/report";
	   }
	   
		// http://localhost:8088/book/categoryList
	   //카테고리 별 합계
	   @RequestMapping(value="/categoryList", method = RequestMethod.GET)
	   public void categorylist(Model model) throws Exception{
		   log.info(" φ(._.) categorylist() 호출 ");
		   
		   loginID=(String)session.getAttribute("loginID");
		   
		   log.info(service.cateSum(loginID)+"");
		   ArrayList sumArr = new ArrayList();
		   ArrayList<String> caArr = new ArrayList<String>();
		   
		   for(BookDetailVO bkVO:service.cateSum(loginID)) {
			   sumArr.add(bkVO.getBk_sum());
			   caArr.add("'"+bkVO.getBk_category()+"'");
			   
		   }
//		   model.addAttribute("cateSum", service.cateSum(loginID));
		   model.addAttribute("sumArr", sumArr);
		   model.addAttribute("caArr", caArr);
		   
	   }
	     

}
