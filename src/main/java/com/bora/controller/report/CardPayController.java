package com.bora.controller.report;

import java.util.Calendar;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import com.bora.service.CardPayService;

@Controller
@RequestMapping("/book/*")
public class CardPayController {

	private static final Logger log = LoggerFactory.getLogger(CardPayController.class);

	@Autowired
	private CardPayService service;
	
	@Inject
	private HttpSession session;
	
	String loginID;

	// 1.카드 내역 불러오기 GEt // http://localhost:8080/book/cardPay
	@RequestMapping(value = "/cardPay", method = RequestMethod.GET)
	public void bookCardList(Model model) throws Exception {
		// 전달된 정보 저장
		log.info("bookCardList 호출됨");

		// 컨트롤러 -> 서비스 호출 (동작 메서드,,)
		log.info("CardPay -----> Service 호출됨");

		model.addAttribute("list", service.bookCardList());

	}

	// http://localhost:8080/book/top3
	// TOP3 매장명 버전 불러오기 => 임시로 CardPayController에 만들고 이후에 병합
	@RequestMapping(value = "/top3", method = RequestMethod.GET)
	public void Top3Store(Integer year, Integer month, Model model) throws Exception {
		// 전달된 정보 저장
		log.info("(ᐡ-ܫ•ᐡ)=͟͟͞♡=͟͟͞♡=͟͟͞♡=͟͟͞♡       Top3Store() 호출");

		// 컨트롤러 -> 서비스 호출
		log.info("(ᐡ-ܫ•ᐡ)=͟͟͞♡=͟͟͞♡=͟͟͞♡=͟͟͞♡       Top3Store()  -----> Service 호출");
		
		
		
		 // 현재 연과 월을 기본으로 보여줌
		Calendar cal = Calendar.getInstance();
		year = cal.get(Calendar.YEAR);
		month = cal.get(Calendar.MONTH)+1;
		model.addAttribute("year", year);
		model.addAttribute("month", month);
		
		loginID = (String)session.getAttribute("loginID");

		log.info(year +""+ month+"");
		model.addAttribute("top3", service.Top3Store(year, month, loginID));
		model.addAttribute("top3date", service.Top3Date(year, month, loginID));     //top3 날짜 버전 호출
		model.addAttribute("bk_category", service.ConsumeTag(year, month, loginID).get(0).getBk_category());
		
		
	}
	


}
