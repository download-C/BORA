package com.bora.controller;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.bora.service.OpenBankingCardService;
import com.bora.domain.openbank.card.CardBillsRequestVO;
import com.bora.domain.openbank.card.CardBillsResponseVO;
import com.bora.domain.openbank.card.CardDetailBillsRequestVO;
import com.bora.domain.openbank.card.CardDetailBillsResponseVO;
import com.bora.domain.openbank.card.CardListRequestVO;
import com.bora.domain.openbank.card.CardListResponseVO;
import com.bora.domain.openbank.card.CardSearchRequestVO;
import com.bora.domain.openbank.card.CardSearchResponseVO;
import com.bora.domain.openbank.card.RegistCardRequestVO;
import com.bora.domain.openbank.card.RegistCardResponseVO;
import com.bora.domain.openbank.RequestTokenVO;
import com.bora.domain.openbank.ResponseTokenVO;
import com.bora.domain.openbank.UserInfoRequestVO;
import com.bora.domain.openbank.UserInfoResponseVO;

@Controller
@RequestMapping(value="/openbank/card/*")
public class CardController {
	//객체생성
	@Autowired
	private OpenBankingCardService openBankingService;
	
	@Inject
	HttpSession session;
	
//	@RequestMapping(value = "/callback",method = RequestMethod.GET)
//	public String getToken(RequestTokenVO requestTokenVO, Model model) throws Exception{
//		//인증
//		System.out.println("code : "+requestTokenVO.getCode());
////		System.out.println(requestTokenVO.getScope());
////		System.out.println(requestTokenVO.getClient_info());
////		System.out.println(requestTokenVO.getState());
//		
//		//토큰발급
//		ResponseTokenVO responseToken=
//			openBankingService.requestToken(requestTokenVO);
//		
//		//정보들고
//		model.addAttribute("responseToken", responseToken);
//		return "bank_main";
//	}
//	// 사용자 정보 조회
//	@RequestMapping(value = "/userInfo", method = RequestMethod.GET)
//	public String getUserInfo(UserInfoRequestVO userInfoRequestVO, Model model) {
//		System.out.println("userInfo");
//		// Service 객체의 findUser() 메서드를 호출하여 사용자 정보 조회
//		// => 파라미터 : UserInfoRequestVO, 리턴타입 UserInfoResponseVO
//		UserInfoResponseVO userInfo = openBankingService.findUser(userInfoRequestVO);
//
//		// Model 객체에 UserInfoResponseVO 객체와 엑세스토큰 저장
//	    model.addAttribute("userInfo", userInfo);
//		model.addAttribute("access_token", userInfoRequestVO.getAccess_token());
//
//		return "card/card_user_info";
//	}
	
	// 카드사용자 등록
	// http://localhost:8088//openbank/card/registCard
	@RequestMapping(value = "/registCard", method = RequestMethod.GET)
	public String getRegistCard(RegistCardRequestVO registCardRequestVO, Model model) {
		String access_token = (String)session.getAttribute("토큰 변수명");
		System.out.println("registCard");
			
		// Service 객체의 registCard() 메서드를 호출하여 사용자 정보 조회
		// => 파라미터 : RegistCardRequestVO, 리턴타입 RegistCardResponseVO
		RegistCardResponseVO registCard = openBankingService.registCard(registCardRequestVO);
		registCardRequestVO.setAccess_token(access_token);
		System.out.println("registCardRequestVO : "+registCardRequestVO.getAccess_token());
		System.out.println("registCardRequestVO : "+registCardRequestVO.getMember_bank_code());
		System.out.println("registCardRequestVO : "+registCardRequestVO.getInfo_prvd_agmt_yn());
			
		// Model 객체에 RegistCardResponseVO 객체와 엑세스토큰 저장
		model.addAttribute("registCard", registCard);
		model.addAttribute("access_token", registCardRequestVO.getAccess_token());

		return "redirect:/bank_main";
	}

	// 카드목록 조회
	@RequestMapping(value = "/cardList", method = RequestMethod.GET)
	public String getCardList( CardListRequestVO cardListRequestVO, Model model) {
		
		System.out.println("cardList");
		
		// Service 객체의 listCard() 메서드를 호출하여 사용자 정보 조회
		// => 파라미터 : cardListRequestVO, 리턴타입 CardListResponseVO
		CardListResponseVO cardList = openBankingService.listCard(cardListRequestVO);

		System.out.println("cardListRequestVO : "+cardListRequestVO.getAccess_token());
		System.out.println("cardListRequestVO : "+cardListRequestVO.getUser_seq_no());
		System.out.println("cardListRequestVO : "+cardListRequestVO.getMember_bank_code());
		System.out.println("cardListRequestVO : "+cardListRequestVO.getBefor_inquiry_trace_info());
		
		// Model 객체에 CardListResponseVO 객체와 엑세스토큰 저장
		model.addAttribute("cardList", cardList);
		model.addAttribute("access_token", cardListRequestVO.getAccess_token());

		return "card/card_list";
	}
	
	// 카드기본정보 조회
	@RequestMapping(value = "/cardSearch", method = RequestMethod.GET)
	public String getCardSearch( CardSearchRequestVO cardSearchRequestVO, Model model) {
			
		System.out.println("cardSearch");
			
		// Service 객체의 findCard() 메서드를 호출하여 사용자 정보 조회
		// => 파라미터 : cardSearchRequestVO, 리턴타입 CardSearchResponseVO
		CardSearchResponseVO cardSearch = openBankingService.findCard(cardSearchRequestVO);

		System.out.println("cardSearchRequestVO : "+cardSearchRequestVO.getAccess_token());
		System.out.println("cardSearchRequestVO : "+cardSearchRequestVO.getUser_seq_no());
		System.out.println("cardSearchRequestVO : "+cardSearchRequestVO.getMember_bank_code());
		System.out.println("cardSearchRequestVO : "+cardSearchRequestVO.getCard_id());
		
		// Model 객체에 CardSearchResponseVO 객체와 엑세스토큰 저장
		model.addAttribute("cardSearch", cardSearch);
		model.addAttribute("access_token", cardSearchRequestVO.getAccess_token());

		return "card/card_search";
	}
    
	// 카드청구기본정보 조회
		@RequestMapping(value = "/cardBills", method = RequestMethod.GET)
		public String getCardBills( CardBillsRequestVO cardBillsRequestVO, Model model) {
				
			System.out.println("cardBills");
				
			// Service 객체의 billsCard() 메서드를 호출하여 사용자 정보 조회
			// => 파라미터 : cardBillsRequestVO, 리턴타입 CardBillsResponseVO
			CardBillsResponseVO cardBills = openBankingService.billsCard(cardBillsRequestVO);

			System.out.println("cardBillsRequestVO : "+cardBillsRequestVO.getAccess_token());
			System.out.println("cardBillsRequestVO : "+cardBillsRequestVO.getUser_seq_no());
			System.out.println("cardBillsRequestVO : "+cardBillsRequestVO.getMember_bank_code());
			System.out.println("cardBillsRequestVO : "+cardBillsRequestVO.getBefor_inquiry_trace_info());
			
			// Model 객체에 CardBillsResponseVO 객체와 엑세스토큰 저장
			model.addAttribute("cardBills", cardBills);
			model.addAttribute("access_token", cardBillsRequestVO.getAccess_token());

			return "card/card_Bills";
		}
		
		// 카드청구상세정보 조회
		@RequestMapping(value = "/cardDetailBills", method = RequestMethod.GET)
		public String getCardDetailBills( CardDetailBillsRequestVO cardDetailBillsRequestVO, Model model) {
						
			System.out.println("cardDetailBills");
						
			// Service 객체의 detailBillsCard() 메서드를 호출하여 사용자 정보 조회
			// => 파라미터 : cardDetailBillsRequestVO, 리턴타입 CardDetailBillsResponseVO
			CardDetailBillsResponseVO  cardDetailBills = openBankingService.detailBillsCard(cardDetailBillsRequestVO);

			System.out.println("cardDetailBillsRequestVO : "+cardDetailBillsRequestVO.getAccess_token());
			System.out.println("cardDetailBillsRequestVO : "+cardDetailBillsRequestVO.getUser_seq_no());
			System.out.println("cardDetailBillsRequestVO : "+cardDetailBillsRequestVO.getMember_bank_code());
			System.out.println("cardDetailBillsRequestVO : "+cardDetailBillsRequestVO.getBefor_inquiry_trace_info());
					
			// Model 객체에 CardDetailBillsResponseVO 객체와 엑세스토큰 저장
			model.addAttribute("cardDetailBills", cardDetailBills);
			model.addAttribute("access_token", cardDetailBillsRequestVO.getAccess_token());

			return "card/card_Detail_Bills";
		}
	
}
