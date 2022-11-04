package com.bora.controller.report;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.bora.controller.MainController;
import com.bora.controller.board.BoardController;
import com.bora.domain.board.PageMakerVO;
import com.bora.domain.board.PageVO;
import com.bora.service.CardPayService;

@Controller
@RequestMapping("/book/*")
public class CardPayController {

	private static final Logger log =
	LoggerFactory.getLogger(CardPayController.class);
	

		@Autowired
		private CardPayService service;

		// 1.카드 내역 불러오기 GEt // http://localhost:8080/book/cardPay
		@RequestMapping(value = "/cardPay", method = RequestMethod.GET)
		public void bookCardList(Model model) throws Exception {
			// 전달된 정보 저장
			 log.info("bookCardList 호출됨");

			// 컨트롤러 -> 서비스 호출 (동작 메서드,,)
			 log.info("CardPay -----> Service 호출됨");

			model.addAttribute("list", service.bookCardList());

		

	}

}
