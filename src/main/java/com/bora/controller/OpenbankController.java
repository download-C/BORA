package com.bora.controller;

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
import com.bora.domain.openbank.UserInfoRequestVO;
import com.bora.domain.openbank.UserInfoResponseVO;
import com.bora.service.OpenBankingService;

@Controller
@RequestMapping("/openbank/*")
public class OpenbankController {
	//객체생성
	@Autowired
	private OpenBankingService openBankingService;
	
	@RequestMapping(value = "/callback", method = RequestMethod.GET)
	public String getToken(RequestTokenVO requestTokenVO, Model model) throws Exception{
		//인증
		System.out.println("code : "+requestTokenVO.getCode());
		System.out.println(requestTokenVO.getScope());
		System.out.println(requestTokenVO.getClient_info());
		System.out.println(requestTokenVO.getState());
		
		//토큰발급
		ResponseTokenVO responseToken=
			openBankingService.requestToken(requestTokenVO);
		
		//정보들고 토큰발급으로 이동
		model.addAttribute("responseToken", responseToken);
		return "/oauth_ok";
	}
	
		// 사용자 정보 조회
		@RequestMapping(value = "/userInfo", method = RequestMethod.GET)
		public String getUserInfo( UserInfoRequestVO userInfoRequestVO, Model model) {
			// Service 객체의 findUser() 메서드를 호출하여 사용자 정보 조회
			// => 파라미터 : UserInfoRequestVO, 리턴타입 UserInfoResponseVO
			UserInfoResponseVO userInfo = openBankingService.findUser(userInfoRequestVO);
			
			// Model 객체에 UserInfoResponseVO 객체와 엑세스토큰 저장
			model.addAttribute("userInfo", userInfo);
			model.addAttribute("access_token", userInfoRequestVO.getAccess_token());
			
			return "/acct_user_info";
		}
		
		// 등록계좌 조회
		@RequestMapping(value = "/accountList", method = RequestMethod.GET)
		public String getAccountList( AccountSearchRequestVO accountSearchRequestVO, Model model) {
			// Service 객체의 findAccount() 메서드를 호출하여 사용자 정보 조회
			// => 파라미터 : AccountSearchRequestVO, 리턴타입 AccountSearchResponseVO
			AccountSearchResponseVO accountList = openBankingService.findAccount(accountSearchRequestVO);
			
			// Model 객체에 AccountSearchResponseVO 객체와 엑세스토큰 저장
			model.addAttribute("accountList", accountList);
			model.addAttribute("access_token", accountSearchRequestVO.getAccess_token());
			
			return "/acct_list";
		}
		
		// 등록계좌 해지
		@RequestMapping(value = "/accountCancel", method = RequestMethod.POST)
		public String cancelAccount( AccountCancelRequestVO accountCancelRequestVO, Model model) {
			// Service 객체의 cancelAccount() 메서드를 호출하여 사용자 정보 조회
			// => 파라미터 : AccountcancelRequestVO, 리턴타입 AccountcancelResponseVO
			AccountCancelResponseVO accountCancel = openBankingService.cancelAccount(accountCancelRequestVO);
			
			// Model 객체에 AccountcancelResponseVO 객체와 엑세스토큰 저장
			model.addAttribute("accountCancel", accountCancel);
			model.addAttribute("access_token", accountCancelRequestVO.getAccess_token());
			
			return "/acct_cancel";
		}
		
		// 잔액조회 
		@RequestMapping(value = "/accountBalance", method = RequestMethod.GET)
		public String getAccountBalance( AccountBalanceRequestVO accountBalanceRequestVO, Model model) {
			// Service 객체의 balanceAccount() 메서드를 호출하여 사용자 정보 조회
			// => 파라미터 : AccountbalanceRequestVO, 리턴타입 AccountbalanceResponseVO
			AccountBalanceResponseVO accountBalance = openBankingService.findAccountBalance(accountBalanceRequestVO);
			
			// Model 객체에 AccountcancelResponseVO 객체와 엑세스토큰 저장
			model.addAttribute("accountBalance", accountBalance);
			model.addAttribute("access_token", accountBalanceRequestVO.getAccess_token());
			
			return "/acct_balance";
		}
		
		
		// 거래내역조회 
		@RequestMapping(value = "/accountTran", method = RequestMethod.GET)
		public String getAccountTran( AccountTranRequestVO accountTranRequestVO, Model model) {
			// Service 객체의 accountTran() 메서드를 호출하여 사용자 정보 조회
			// => 파라미터 : AccounttranRequestVO, 리턴타입 AccounttranResponseVO
			AccountTranResponseVO accountTran = openBankingService.findAccountTran(accountTranRequestVO);
			
			// Model 객체에 AccountcancelResponseVO 객체와 엑세스토큰 저장
			model.addAttribute("accountTran", accountTran);
//			model.addAttribute("access_token", accountTranRequestVO.getAccess_token());
			model.addAttribute("bank_tran_id", accountTranRequestVO.getBank_tran_id());
			
			return "/acct_tran";
		}
		
		
}
