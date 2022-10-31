package com.bora.controller;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.bora.domain.openbank.AccountBalanceRequestVO;
import com.bora.domain.openbank.AccountBalanceResponseVO;
import com.bora.domain.openbank.AccountCancelRequestVO;
import com.bora.domain.openbank.AccountCancelResponseVO;
import com.bora.domain.openbank.AccountSearchRequestVO;
import com.bora.domain.openbank.AccountSearchResponseVO;
import com.bora.domain.openbank.AccountTranRequestVO;
import com.bora.domain.openbank.AccountTranResponseVO;
import com.bora.domain.openbank.RequestTokenVO;
import com.bora.domain.openbank.ResponseTokenVO;
import com.bora.domain.openbank.TranWithdrawRequestVO;
import com.bora.domain.openbank.TranWithdrawResponseVO;
import com.bora.domain.openbank.UserInfoRequestVO;
import com.bora.domain.openbank.UserInfoResponseVO;
import com.bora.service.OpenBankingService;

@Controller
@RequestMapping("/openbank/*")
public class OpenbankController {
	//객체생성
	@Autowired
	private OpenBankingService openBankingService;
	
	@Inject
	HttpSession session;

	private static final Logger log = LoggerFactory.getLogger(OpenbankController.class);
	
	// http://localhost:8088/openbank/oauth
	@RequestMapping(value = "/oauth", method = RequestMethod.GET)
	public String openbank() {
		log.info("%%%%%%%%%%%%%% /oauth -> oauth.jsp");
		return "/openbank/oauth";
	}
	
	// http://localhost:8088/openbank/oauth
	@RequestMapping(value = "/callback", method = RequestMethod.GET)
	public String getToken(RequestTokenVO requestTokenVO, Model model) throws Exception{
		log.info("%%%%%%%%%%%%%%%%%% 사용자인증 확인");
		log.info("/openbank/oauthOK 로 이동");

		log.info("code : "+requestTokenVO.getCode());
		log.info("scope : "+requestTokenVO.getScope());
		log.info("clinet_info : "+requestTokenVO.getClient_info());
		log.info("state : "+requestTokenVO.getState());
		
		//토큰발급
		ResponseTokenVO responseToken=
			openBankingService.requestToken(requestTokenVO);
		
		//정보들고 토큰발급으로 이동
//		model.addAttribute("responseToken", responseToken);
		model.addAttribute("responseToken", responseToken);
		session.setAttribute("token", responseToken.getAccess_token());
	    //return "redirect:/openbank/oauth_ok";
	    return "/openbank/oauthOK";
	}
	
		// 사용자 정보 조회
		@RequestMapping(value = "/userInfo", method = RequestMethod.GET)
		public String getUserInfo( UserInfoRequestVO userInfoRequestVO, Model model) {
			log.info("%%%%%%%%%%%%%%%%%% 사용자정보 확인");
			log.info("/openbank/acct_user_info 로 이동");
			
			log.info("Access_token : "+userInfoRequestVO.getAccess_token());
			log.info("userinfo : "+userInfoRequestVO.getUser_seq_no());
			
			// Service 객체의 findUser() 메서드를 호출하여 사용자 정보 조회
			// => 파라미터 : UserInfoRequestVO, 리턴타입 UserInfoResponseVO
			UserInfoResponseVO userInfo = openBankingService.findUser(userInfoRequestVO);
			
			// Model 객체에 UserInfoResponseVO 객체와 엑세스토큰 저장
			model.addAttribute("userInfo", userInfo);
			model.addAttribute("access_token", userInfoRequestVO.getAccess_token());
			
			return "/openbank/acct_user_info";
		}
		
		// 등록계좌 조회
		@RequestMapping(value = "/accountList", method = RequestMethod.GET)
		public String getAccountList( AccountSearchRequestVO accountSearchRequestVO, Model model) {
			log.info("%%%%%%%%%%%%%%%%%% 등록계좌 확인");
			log.info("/openbank/acct_list 로 이동");
			
			// Service 객체의 findAccount() 메서드를 호출하여 사용자 정보 조회
			// => 파라미터 : AccountSearchRequestVO, 리턴타입 AccountSearchResponseVO
			AccountSearchResponseVO accountList = openBankingService.findAccount(accountSearchRequestVO);
			
			// Model 객체에 AccountSearchResponseVO 객체와 엑세스토큰 저장
			model.addAttribute("accountList", accountList);
			model.addAttribute("access_token", accountSearchRequestVO.getAccess_token());
			
			return "/openbank/acct_list";
		}
		
		// 등록계좌 해지
		@RequestMapping(value = "/accountCancel", method = RequestMethod.POST)
		public String cancelAccount( AccountCancelRequestVO accountCancelRequestVO, Model model) {
			log.info("%%%%%%%%%%%%%%%%%% 등록계좌 해지!");
			log.info("/openbank/acct_cancel 로 이동");
			
			// Service 객체의 cancelAccount() 메서드를 호출하여 사용자 정보 조회
			// => 파라미터 : AccountcancelRequestVO, 리턴타입 AccountcancelResponseVO
			AccountCancelResponseVO accountCancel = openBankingService.cancelAccount(accountCancelRequestVO);
			
			// Model 객체에 AccountcancelResponseVO 객체와 엑세스토큰 저장
			model.addAttribute("accountCancel", accountCancel);
			model.addAttribute("access_token", accountCancelRequestVO.getAccess_token());
			
			return "/openbank/acct_cancel";
		}
		
		// 잔액조회 
		@RequestMapping(value = "/accountBalance", method = RequestMethod.GET)
		public String getAccountBalance( AccountBalanceRequestVO accountBalanceRequestVO, Model model) {
			log.info("%%%%%%%%%%%%%%%%%% 계좌 잔액 조회");
			log.info("/openbank/acct_balance 로 이동");
			
			// Service 객체의 balanceAccount() 메서드를 호출하여 사용자 정보 조회
			// => 파라미터 : AccountbalanceRequestVO, 리턴타입 AccountbalanceResponseVO
			AccountBalanceResponseVO accountBalance = openBankingService.findAccountBalance(accountBalanceRequestVO);
			
			// Model 객체에 AccountcancelResponseVO 객체와 엑세스토큰 저장
			model.addAttribute("accountBalance", accountBalance);
			model.addAttribute("access_token", accountBalanceRequestVO.getAccess_token());
			
			return "/openbank/acct_balance";
		}
		
		
		// 거래내역조회 
		@RequestMapping(value = "/accountTran", method = RequestMethod.GET)
		public String getAccountTran( AccountTranRequestVO accountTranRequestVO, Model model) {
			log.info("%%%%%%%%%%%%%%%%%% 계좌 거래 내역 조회");
			log.info("/openbank/acct_tran 로 이동");
			
			// Service 객체의 accountTran() 메서드를 호출하여 사용자 정보 조회
			// => 파라미터 : AccounttranRequestVO, 리턴타입 AccounttranResponseVO
			AccountTranResponseVO accountTran = openBankingService.findAccountTran(accountTranRequestVO);
			
			// Model 객체에 AccountcancelResponseVO 객체와 엑세스토큰 저장
			model.addAttribute("accountTran", accountTran);
//			model.addAttribute("access_token", accountTranRequestVO.getAccess_token());
			model.addAttribute("bank_tran_id", accountTranRequestVO.getBank_tran_id());
			
			return "/openbank/acct_tran";
		}
		

		// 출금이체
		@RequestMapping(value = "/tranWithdraw", method = RequestMethod.POST)
		public String getTranWithdraw( TranWithdrawRequestVO tranWithdrawRequestVO, Model model) {
			log.info("%%%%%%%%%%%%%%%%%% 출금이체??");
			log.info("/openbank/tran_withdraw 로 이동");
			
			// Service 객체의 tranWithdraw() 메서드를 호출하여 사용자 정보 조회
			// => 파라미터 : TransWithdrawRequestVO, 리턴타입 TransWithdrawResponseVO
			TranWithdrawResponseVO tranWithdraw = openBankingService.findTranWithdraw(tranWithdrawRequestVO);
			
			// Model 객체에 AccountcancelResponseVO 객체와 엑세스토큰 저장
			model.addAttribute("tranWithdraw", tranWithdraw);
			model.addAttribute("access_token", tranWithdrawRequestVO.getAccess_token());
			
			return "/openbank/tran_withdraw";
		}
		
		
		
		
		
}
