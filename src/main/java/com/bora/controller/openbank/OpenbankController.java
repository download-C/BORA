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

import com.bora.domain.openbank.RequestTokenVO;
import com.bora.domain.openbank.ResponseTokenVO;
import com.bora.domain.openbank.UserInfoRequestVO;
import com.bora.domain.openbank.UserInfoResponseVO;
import com.bora.domain.openbank.account.AccountBalanceRequestVO;
import com.bora.domain.openbank.account.AccountBalanceResponseVO;
import com.bora.domain.openbank.account.AccountSearchRequestVO;
import com.bora.domain.openbank.account.AccountSearchResponseVO;
import com.bora.domain.openbank.account.AccountTranRequestVO;
import com.bora.domain.openbank.account.AccountTranResponseVO;
import com.bora.domain.openbank.card.CardInfoRequestVO;
import com.bora.domain.openbank.card.CardInfoResponseVO;
import com.bora.domain.openbank.card.CardListRequestVO;
import com.bora.domain.openbank.card.CardListResponseVO;
import com.bora.domain.openbank.card.bill.CardBillsRequestVO;
import com.bora.domain.openbank.card.bill.CardBillsResponseVO;
import com.bora.domain.openbank.card.bill.CardDetailBillsRequestVO;
import com.bora.domain.openbank.card.bill.CardDetailBillsResponseVO;
import com.bora.service.openbank.OpenBankingService;

@Controller
@RequestMapping("/openbank/*")
public class OpenbankController {

	// 객체생성
	@Autowired
	private OpenBankingService openBankingService;

	@Inject
	HttpSession session;

	private static final Logger log = LoggerFactory.getLogger(OpenbankController.class);

	// http://localhost:8088/openbank/goal
	@RequestMapping(value = "/goal", method = RequestMethod.GET)
	public String goal() {
		log.info("🐧🐧🐧🐧🐧🐧🐧🐧🐧🐧🐧🐧🐧  오픈뱅킹 - 목돈 모으기");
		log.info("/openbank/goal 로 이동");
		return "/openbank/goal";
	}

	// http://localhost:8088/openbank/oauthOK
	@RequestMapping(value = "/oauthOK", method = RequestMethod.GET)
	public String openbank() {
		log.info("🐧🐧🐧🐧🐧🐧🐧🐧🐧🐧🐧🐧🐧  오픈뱅킹 - 계좌");
		log.info("/openbank/oauthOK 로 이동");
		return "/openbank/oauthOK";
	}

	// http://localhost:8088/openbank/oauth
	@RequestMapping(value = "/callback", method = RequestMethod.GET)
	public String getToken(RequestTokenVO requestTokenVO, Model model) throws Exception {
		log.info("🐧🐧🐧🐧🐧🐧🐧🐧🐧🐧🐧🐧🐧  토큰발급 가기");
		log.info("/openbank/oauthOK 로 이동");

		// 토큰발급
		ResponseTokenVO responseToken = openBankingService.requestToken(requestTokenVO);

		// 정보들고 토큰발급으로 이동
		model.addAttribute("responseToken", responseToken);
		session.setAttribute("token", responseToken.getAccess_token());

		log.info("code : " + requestTokenVO.getCode());
		log.info("scope : " + requestTokenVO.getScope());
		log.info("clinet_info : " + requestTokenVO.getClient_info());
		log.info("state : " + requestTokenVO.getState());

		return "/openbank/oauthOK";
	}

	// 사용자 정보 조회
	@RequestMapping(value = "/userInfo", method = RequestMethod.GET)
	public String getUserInfo(UserInfoRequestVO userInfoRequestVO, Model model) {
		log.info("🐧🐧🐧🐧🐧🐧🐧🐧🐧🐧🐧🐧🐧   사용자정보 확인");
		log.info("/openbank/acct_user_info 로 이동");

		// Service 객체의 findUser() 메서드를 호출하여 사용자 정보 조회
		// => 파라미터 : UserInfoRequestVO, 리턴타입 UserInfoResponseVO
		UserInfoResponseVO userInfo = openBankingService.findUser(userInfoRequestVO);

		model.addAttribute("userInfo", userInfo);
		session.setAttribute("userInfo", userInfo.getUser_info());
		session.setAttribute("access_token", userInfoRequestVO.getAccess_token());

		log.info("Access_token : " + userInfoRequestVO.getAccess_token());
		log.info("userinfo : " + userInfoRequestVO.getUser_seq_no());

		return "/openbank/acct_user_info";
	}

	// 등록계좌 조회
	@RequestMapping(value = "/accountList", method = RequestMethod.GET)
	public String getAccountList(AccountSearchRequestVO accountSearchRequestVO, Model model) {
		log.info("🐧🐧🐧🐧🐧🐧🐧🐧🐧🐧🐧🐧🐧  등록계좌 확인");
		log.info("/openbank/acct_list 로 이동");

		AccountSearchResponseVO accountList = openBankingService.findAccount(accountSearchRequestVO);

		model.addAttribute("accountList", accountList);
		session.setAttribute("accountList", accountList.getRes_list());
		session.setAttribute("access_token", accountSearchRequestVO.getAccess_token());

		// Model 객체에 AccountSearchResponseVO 객체와 엑세스토큰 저장
		log.info("Access_token : " + accountSearchRequestVO.getAccess_token());
		log.info("userinfo : " + accountSearchRequestVO.getUser_seq_no());
		log.info("include_cancel_yn : " + accountSearchRequestVO.getInclude_cancel_yn());
		log.info("Sort_order : " + accountSearchRequestVO.getSort_order());

		return "/openbank/acct_list";
	}

	// 잔액조회
	@RequestMapping(value = "/accountBalance", method = RequestMethod.GET)
	public String getAccountBalance(AccountBalanceRequestVO accountBalanceRequestVO, Model model) {
		log.info("🐧🐧🐧🐧🐧🐧🐧🐧🐧🐧🐧🐧🐧   계좌 잔액 조회");
		log.info("/openbank/acct_balance 로 이동");
		log.info(accountBalanceRequestVO + "");

		AccountBalanceResponseVO accountBalance = openBankingService.findAccountBalance(accountBalanceRequestVO);

		// Model 객체에 AccountcancelResponseVO 객체와 엑세스토큰 저장
		model.addAttribute("accountBalance", accountBalance);
		session.setAttribute("bank_tran_id", accountBalanceRequestVO.getBank_tran_id());
		session.setAttribute("fintech_use_num", accountBalanceRequestVO.getFintech_use_num());

		log.info("fintech_use_num : " + accountBalanceRequestVO.getFintech_use_num());
		log.info("tran_dtime : " + accountBalanceRequestVO.getTran_dtime());

		return "/openbank/acct_balance";
	}

	// 거래내역조회
	@RequestMapping(value = "/accountTran", method = RequestMethod.GET)
	public String getAccountTran(AccountTranRequestVO accountTranRequestVO, Model model) {
		log.info("🐧🐧🐧🐧🐧🐧🐧🐧🐧🐧🐧🐧🐧   계좌 거래 내역 조회");
		log.info("/openbank/acct_tran 로 이동");

		log.info(accountTranRequestVO + "");
//			accountTranRequestVO.setInquiry_type("A");
//			accountTranRequestVO.setInquiry_base("D");
//			accountTranRequestVO.setSort_order("C");
		accountTranRequestVO.getBank_tran_id();

		AccountTranResponseVO accountTran = openBankingService.findAccountTran(accountTranRequestVO);

		// Model 객체에 AccountcancelResponseVO 객체와 엑세스토큰 저장
		model.addAttribute("accountTran", accountTran);
		session.setAttribute("accountTran", accountTran);
		session.setAttribute("bank_tran_id", accountTranRequestVO.getBank_tran_id());

		log.info("bank_tran_id : " + accountTranRequestVO.getBank_tran_id());
		log.info("fintech_use_num : " + accountTranRequestVO.getFintech_use_num());

		return "/openbank/acct_tran";
	}

	// 카드기본정보 조회
	@RequestMapping(value = "/cardInfo", method = RequestMethod.POST)
	public String getCardInfo(CardInfoRequestVO cardInfoRequestVO, Model model) throws Exception {

		log.info("cardInfoPOST() 호출");

		CardInfoResponseVO cardInfo = openBankingService.infoCard(cardInfoRequestVO);

		// Model 객체에 CardListResponseVO 객체와 엑세스 토큰 저장
		model.addAttribute("cardInfo", cardInfo);
		model.addAttribute("cardInfo", cardInfo);
		session.setAttribute("access_token", cardInfoRequestVO.getAccess_token());

		log.info("Access_token : " + cardInfoRequestVO.getAccess_token());
		log.info("cardInfo : " + cardInfoRequestVO.getUser_seq_no());

		return "/openbank/card_info";

	}

	// 카드목록 조회
	@RequestMapping(value = "/cardList", method = RequestMethod.GET)
	public String getCardList(CardListRequestVO cardListRequestVO, Model model) throws Exception {

		log.info("cardListGET() 호출");

		// Service 객체의 listCard() 메서드를 호출하여 사용자 정보 조회
		// => 파라미터 : CardListRequestVO, 리턴타입 CardListResponseVO
		CardListResponseVO cardList = openBankingService.listCard(cardListRequestVO);

		log.info("cardListRequestVO : " + cardListRequestVO.getAccess_token());
		log.info("cardListRequestVO : " + cardListRequestVO.getBank_tran_id());
		log.info("cardListRequestVO : " + cardListRequestVO.getUser_seq_no());
		log.info("cardListRequestVO : " + cardListRequestVO.getBank_code_std());
		log.info("cardListRequestVO : " + cardListRequestVO.getMember_bank_code());

		// Model 객체에 CardListResponseVO 객체와 엑세스토큰 저장
		model.addAttribute("cardList", cardList);
		model.addAttribute("access_token", cardListRequestVO.getAccess_token());

		return "/openbank/card_list";
	}

	// 카드청구기본정보 조회
	@RequestMapping(value = "/cardBills", method = RequestMethod.GET)
	public String getCardBills(CardBillsRequestVO cardBillsRequestVO, Model model) throws Exception {

		log.info("cardBillsGET() 호출");

		// Service 객체의 billsCard() 메서드를 호출하여 사용자 정보 조회
		// => 파라미터 : CardBillsRequestVO, 리턴타입 CardBillsResponseVO
		CardBillsResponseVO cardBills = openBankingService.billsCard(cardBillsRequestVO);

		log.info("cardBillsRequestVO : " + cardBillsRequestVO.getAccess_token());
		log.info("cardBillsRequestVO : " + cardBillsRequestVO.getBank_tran_id());
		log.info("cardBillsRequestVO : " + cardBillsRequestVO.getUser_seq_no());
		log.info("cardBillsRequestVO : " + cardBillsRequestVO.getBank_code_std());
		log.info("cardBillsRequestVO : " + cardBillsRequestVO.getMember_bank_code());
		log.info("cardBillsRequestVO : " + cardBillsRequestVO.getFrom_month());
		log.info("cardBillsRequestVO : " + cardBillsRequestVO.getTo_month());

		// Model 객체에 CardBillsResponseVO 객체와 엑세스토큰 저장
		model.addAttribute("cardBills", cardBills);
		model.addAttribute("access_token", cardBillsRequestVO.getAccess_token());

		return "/openbank/card_bills";
	}

	// 카드청구상세정보 조회
	@RequestMapping(value = "/cardDetailBills", method = RequestMethod.GET)
	public String getCardDetailBills(CardDetailBillsRequestVO cardDetailBillsRequestVO, Model model) throws Exception {

		log.info("cardDetailBillsGET() 호출");

		// Service 객체의 detailBillsCard() 메서드를 호출하여 사용자 정보 조회
		// => 파라미터 : CardDetailBillsRequestVO, 리턴타입 CardDetailBillsResponseVO
		CardDetailBillsResponseVO cardDetailBills = openBankingService.detailBillsCard(cardDetailBillsRequestVO);

		log.info("cardDetailBillsRequestVO : " + cardDetailBillsRequestVO.getAccess_token());
		log.info("cardDetailBillsRequestVO : " + cardDetailBillsRequestVO.getBank_tran_id());
		log.info("cardDetailBillsRequestVO : " + cardDetailBillsRequestVO.getUser_seq_no());
		log.info("cardDetailBillsRequestVO : " + cardDetailBillsRequestVO.getBank_code_std());
		log.info("cardDetailBillsRequestVO : " + cardDetailBillsRequestVO.getMember_bank_code());
		log.info("cardDetailBillsRequestVO : " + cardDetailBillsRequestVO.getCharge_month());
		log.info("cardDetailBillsRequestVO : " + cardDetailBillsRequestVO.getSettlement_seq_no());

		// Model 객체에 CardDetailBillsResponseVO 객체와 엑세스토큰 저장
		model.addAttribute("cardDetailBills", cardDetailBills);
		model.addAttribute("access_token", cardDetailBillsRequestVO.getAccess_token());

		return "/openbank/card_detail_bills";
	}

}
