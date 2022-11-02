package com.bora.controller.openbank;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.bora.domain.openbank.card.CardListRequestVO;
import com.bora.domain.openbank.card.CardListResponseVO;
import com.bora.domain.openbank.card.CardSearchRequestVO;
import com.bora.domain.openbank.card.CardSearchResponseVO;
import com.bora.domain.openbank.card.bill.CardBillsRequestVO;
import com.bora.domain.openbank.card.bill.CardBillsResponseVO;
import com.bora.domain.openbank.card.bill.CardDetailBillsRequestVO;
import com.bora.domain.openbank.card.bill.CardDetailBillsResponseVO;
import com.bora.domain.openbank.card.delete.CardDeleteRequestVO;
import com.bora.domain.openbank.card.delete.CardDeleteResponseVO;
import com.bora.domain.openbank.card.prePaid.PrePaidTranRequestVO;
import com.bora.domain.openbank.card.prePaid.PrePaidTranResponseVO;
import com.bora.domain.openbank.card.regist.RegistCardRequestVO;
import com.bora.domain.openbank.card.regist.RegistCardResponseVO;
import com.bora.domain.openbank.card.update.CardUpdateRequestVO;
import com.bora.domain.openbank.card.update.CardUpdateResponseVO;
import com.bora.service.openbank.OpenBankingCardService;
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
	
	private static final Logger log = LoggerFactory.getLogger(CardController.class);
	
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
	@RequestMapping(value = "/registCard", method = RequestMethod.GET)
	public String getRegistCard() {
		log.info("registCardGET() 호출");
			
		return "card/regist_card";
	}
	// 카드사용자 등록
	@RequestMapping(value = "/registCardPro", method = RequestMethod.POST)
	public String getRegistCardPro(RegistCardRequestVO registCardRequestVO, Model model) throws Exception {
				
		log.info("registCardPOST() 호출");
				
		// Service 객체의 registCard() 메서드를 호출하여 사용자 정보 조회
		// => 파라미터 : RegistCardRequestVO, 리턴타입 RegistCardResponseVO
		RegistCardResponseVO registCard = openBankingService.registCard(registCardRequestVO);

		log.info("registCardRequestVO : "+registCardRequestVO.getAccess_token());
		log.info("registCardRequestVO : "+registCardRequestVO.getBank_tran_id());
		log.info("registCardRequestVO : "+registCardRequestVO.getBank_code_std());
		log.info("registCardRequestVO : "+registCardRequestVO.getMember_bank_code());
		log.info("registCardRequestVO : "+registCardRequestVO.getUser_name());
		log.info("registCardRequestVO : "+registCardRequestVO.getUser_ci());
		log.info("registCardRequestVO : "+registCardRequestVO.getUser_email());
		log.info("registCardRequestVO : "+registCardRequestVO.getScope());
		log.info("registCardRequestVO : "+registCardRequestVO.getInfo_prvd_agmt_yn());
				
		// Model 객체에 RegistCardResponseVO 객체와 엑세스토큰 저장
		model.addAttribute("registCard", registCard);
		model.addAttribute("access_token", registCardRequestVO.getAccess_token());

		return "redirect:/card/bank_main";
	}

	// 카드목록 조회
	@RequestMapping(value = "/cardList", method = RequestMethod.GET)
	public String getCardList( CardListRequestVO cardListRequestVO, Model model) throws Exception {
			
		log.info("cardListGET() 호출");
			
		// Service 객체의 listCard() 메서드를 호출하여 사용자 정보 조회
		// => 파라미터 : CardListRequestVO, 리턴타입 CardListResponseVO
		CardListResponseVO cardList = openBankingService.listCard(cardListRequestVO);

		log.info("cardListRequestVO : "+cardListRequestVO.getAccess_token());
		log.info("cardListRequestVO : "+cardListRequestVO.getUser_seq_no());
		log.info("cardListRequestVO : "+cardListRequestVO.getMember_bank_code());
		log.info("cardListRequestVO : "+cardListRequestVO.getBefor_inquiry_trace_info());
			
		// Model 객체에 CardListResponseVO 객체와 엑세스토큰 저장
		model.addAttribute("cardList", cardList);
		model.addAttribute("access_token", cardListRequestVO.getAccess_token());

		return "card/card_list";
	}
		
	// 카드기본정보 조회
	@RequestMapping(value = "/cardSearch", method = RequestMethod.GET)
	public String getCardSearch( CardSearchRequestVO cardSearchRequestVO, Model model) throws Exception {
				
		log.info("cardSearchGET() 호출");
				
		// Service 객체의 findCard() 메서드를 호출하여 사용자 정보 조회
		// => 파라미터 : CardSearchRequestVO, 리턴타입 CardSearchResponseVO
		CardSearchResponseVO cardSearch = openBankingService.findCard(cardSearchRequestVO);

		log.info("cardSearchRequestVO : "+cardSearchRequestVO.getAccess_token());
		log.info("cardSearchRequestVO : "+cardSearchRequestVO.getUser_seq_no());
		log.info("cardSearchRequestVO : "+cardSearchRequestVO.getMember_bank_code());
		log.info("cardSearchRequestVO : "+cardSearchRequestVO.getCard_id());
			
		// Model 객체에 CardSearchResponseVO 객체와 엑세스토큰 저장
		model.addAttribute("cardSearch", cardSearch);
		model.addAttribute("access_token", cardSearchRequestVO.getAccess_token());

		return "card/card_search";
	}
	    
	// 카드청구기본정보 조회
	@RequestMapping(value = "/cardBills", method = RequestMethod.GET)
	public String getCardBills( CardBillsRequestVO cardBillsRequestVO, Model model) throws Exception {
					
		log.info("cardBillsGET() 호출");
					
		// Service 객체의 billsCard() 메서드를 호출하여 사용자 정보 조회
		// => 파라미터 : CardBillsRequestVO, 리턴타입 CardBillsResponseVO
		CardBillsResponseVO cardBills = openBankingService.billsCard(cardBillsRequestVO);

		log.info("cardBillsRequestVO : "+cardBillsRequestVO.getAccess_token());
		log.info("cardBillsRequestVO : "+cardBillsRequestVO.getUser_seq_no());
		log.info("cardBillsRequestVO : "+cardBillsRequestVO.getMember_bank_code());
		log.info("cardBillsRequestVO : "+cardBillsRequestVO.getBefor_inquiry_trace_info());
				
		// Model 객체에 CardBillsResponseVO 객체와 엑세스토큰 저장
		model.addAttribute("cardBills", cardBills);
		model.addAttribute("access_token", cardBillsRequestVO.getAccess_token());

		return "card/card_bills";
	}
			
	// 카드청구상세정보 조회
	@RequestMapping(value = "/cardDetailBills", method = RequestMethod.GET)
	public String getCardDetailBills( CardDetailBillsRequestVO cardDetailBillsRequestVO, Model model) throws Exception {
							
		log.info("cardDetailBillsGET() 호출");
							
		// Service 객체의 detailBillsCard() 메서드를 호출하여 사용자 정보 조회
		// => 파라미터 : CardDetailBillsRequestVO, 리턴타입 CardDetailBillsResponseVO
		CardDetailBillsResponseVO  cardDetailBills = openBankingService.detailBillsCard(cardDetailBillsRequestVO);

		log.info("cardDetailBillsRequestVO : "+cardDetailBillsRequestVO.getAccess_token());
		log.info("cardDetailBillsRequestVO : "+cardDetailBillsRequestVO.getUser_seq_no());
		log.info("cardDetailBillsRequestVO : "+cardDetailBillsRequestVO.getMember_bank_code());
		log.info("cardDetailBillsRequestVO : "+cardDetailBillsRequestVO.getBefor_inquiry_trace_info());
						
		// Model 객체에 CardDetailBillsResponseVO 객체와 엑세스토큰 저장
		model.addAttribute("cardDetailBills", cardDetailBills);
		model.addAttribute("access_token", cardDetailBillsRequestVO.getAccess_token());

		return "card/card_detail_bills";
	}
	// 카드정보변경
	@RequestMapping(value = "/cardUpdate", method = RequestMethod.GET)
	public String getCardUpdate( CardUpdateRequestVO cardUpdateRequestVO, Model model) throws Exception {
									
		log.info("cardUpdateGET() 호출");
									
		// Service 객체의 updateCard() 메서드를 호출하여 사용자 정보 조회
		// => 파라미터 : cardUpdateRequestVO, 리턴타입 CardUpdateResponseVO
		CardUpdateResponseVO cardUpdate = openBankingService.updateCard(cardUpdateRequestVO);

		log.info("cardUpdateRequestVO : "+cardUpdateRequestVO.getAccess_token());
		log.info("cardUpdateRequestVO : "+cardUpdateRequestVO.getUser_seq_no());
		log.info("cardUpdateRequestVO : "+cardUpdateRequestVO.getMember_bank_code());
				log.info("cardUpdateRequestVO : "+cardUpdateRequestVO.getUpdate_user_email());
								
		// Model 객체에 CardUpdateResponseVO 객체와 엑세스토큰 저장
		model.addAttribute("cardUpdate", cardUpdate);
		model.addAttribute("access_token", cardUpdateRequestVO.getAccess_token());

		return "card/card_update";
	}
    // 카드조회해지
	@RequestMapping(value = "/cardDelete", method = RequestMethod.GET)
	public String getCardDelete( CardDeleteRequestVO cardDeleteRequestVO, Model model) throws Exception {
												
		log.info("cardDeleteGET() 호출");
											
		// Service 객체의 deleteCard() 메서드를 호출하여 사용자 정보 조회
		// => 파라미터 : cardDeleteRequestVO, 리턴타입 CardDeleteResponseVO
		CardDeleteResponseVO cardDelete = openBankingService.deleteCard(cardDeleteRequestVO);

		log.info("cardDeleteRequestVO : "+cardDeleteRequestVO.getAccess_token());
		log.info("cardDeleteRequestVO : "+cardDeleteRequestVO.getUser_seq_no());
		log.info("cardDeleteRequestVO : "+cardDeleteRequestVO.getMember_bank_code());
										
		// Model 객체에 CardUpdateResponseVO 객체와 엑세스토큰 저장
		model.addAttribute("cardDelete", cardDelete);
		model.addAttribute("access_token", cardDeleteRequestVO.getAccess_token());
							
		return "card/card_delete";
	}
	// 선불거래내역조회
	@RequestMapping(value = "/prePaidTran", method = RequestMethod.GET)
	public String getPrePaidTran( PrePaidTranRequestVO prePaidTranRequestVO, Model model) throws Exception {
																
		log.info("prePaidTranGET() 호출");
																
		// Service 객체의 prePaidTran() 메서드를 호출하여 사용자 정보 조회
		// => 파라미터 : PrePaidTranRequestVO, 리턴타입 PrePaidTranResponseVO
		PrePaidTranResponseVO prePaidTran = openBankingService.prePaidTran(prePaidTranRequestVO);

		log.info("prePaidTranRequestVO : "+prePaidTranRequestVO.getAccess_token());
		log.info("prePaidTranRequestVO : "+prePaidTranRequestVO.getUser_seq_no());
		log.info("prePaidTranRequestVO : "+prePaidTranRequestVO.getBank_code_std());
															
		// Model 객체에 PrePaidTranResponseVO 객체와 엑세스토큰 저장
		model.addAttribute("prePaidTran", prePaidTran);
		model.addAttribute("access_token", prePaidTranRequestVO.getAccess_token());
											
		return "card/prepaid_tran";
	}
	
}
