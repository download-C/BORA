package com.bora.controller.report;

import java.util.ArrayList;
import java.util.Calendar;
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
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.bora.controller.MemberController;
import com.bora.domain.report.BookDetailVO;
import com.bora.domain.report.BookVO;
import com.bora.service.CardPayService;
import com.bora.service.report.ConsumeAllListService;
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
	   
	   
		// http://localhost:8088/report/categoryList
	   //카테고리 별 합계
	   @RequestMapping(value="/categoryList", method = RequestMethod.GET)
	   public void categorylist(Model model) throws Exception{
		   log.info(" φ(._.) categorylist() 호출 ");
		   
		   loginID=(String)session.getAttribute("loginID");
		   
		   // 현재 연과 월을 기본으로 보여줌
			Calendar cal = Calendar.getInstance();
			int year = cal.get(Calendar.YEAR);
			int month = cal.get(Calendar.MONTH)+1;
			int day = cal.get(Calendar.DATE);
			model.addAttribute("year", year);
			model.addAttribute("month", month);
			model.addAttribute("day", day);
		   
		   log.info(service.cateSum(year, month, loginID)+"");
		   List<Integer> sumArr = new ArrayList<>();
		   List<String> caArr = new ArrayList<String>();
		   
		   for(BookDetailVO bkVO:service.cateSum(year, month, loginID)) {
			   sumArr.add(bkVO.getBk_sum());
			   caArr.add("'"+bkVO.getBk_category()+"'");
			   
		   } //배열로 합계, 카테고리 불러오기
//			model.addAttribute("cateSum", service.cateSum(year, month, loginID));
		   log.info("합계 사이즈: "+sumArr.size()+"");
		   log.info("카테고리 리스트 사이즈: "+caArr.size()+"");
			model.addAttribute("sumArr", sumArr);
			model.addAttribute("caArr", caArr); 
	   
			

			//top3
			
			log.info(year +""+ month+"");
			model.addAttribute("top3", service.Top3Store(year, month, loginID));
			model.addAttribute("top3date", service.Top3Date(year, month, loginID));     //top3 날짜 버전 호출
			if(service.ConsumeTag(year, month, loginID).size()!=0) {
				model.addAttribute("bk_category", 
						service.ConsumeTag(year, month, loginID).get(0).getBk_category());
			}
			
			
			
			//전월대비
				
			List<BookDetailVO> dtlvo = service.getConsumeMinus(year, month, loginID);
			for(int i=0; i<dtlvo.size(); i++) {	
				BookDetailVO detail = dtlvo.get(i) ;
				if(detail.getBk_minus()== null) {
					detail.setBk_minus(0);
				} else continue;

			}
				log.info("바꾼 정보: "+dtlvo);
				model.addAttribute("consumeList", dtlvo);
			}
}
	   
	   
	 
	   
	   
	     


