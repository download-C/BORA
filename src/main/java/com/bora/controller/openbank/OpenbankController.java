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
import com.bora.domain.openbank.account.AccountCancelRequestVO;
import com.bora.domain.openbank.account.AccountCancelResponseVO;
import com.bora.domain.openbank.account.AccountSearchRequestVO;
import com.bora.domain.openbank.account.AccountSearchResponseVO;
import com.bora.domain.openbank.account.AccountTranRequestVO;
import com.bora.domain.openbank.account.AccountTranResponseVO;
import com.bora.domain.openbank.tran.deposit.TranDepositRequestVO;
import com.bora.domain.openbank.tran.deposit.TranDepositResponseVO;
import com.bora.domain.openbank.tran.result.TranResultRequestVO;
import com.bora.domain.openbank.tran.result.TranResultResponseVO;
import com.bora.domain.openbank.tran.withdraw.TranWithdrawRequestVO;
import com.bora.domain.openbank.tran.withdraw.TranWithdrawResponseVO;
import com.bora.service.openbank.OpenBankingService;

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
		log.info("🐧🐧🐧🐧🐧🐧🐧🐧🐧🐧🐧🐧🐧  /oauth -> oauth.jsp");
		return "/openbank/oauth";
	}
	
	// http://localhost:8088/openbank/oauth
	@RequestMapping(value = "/callback", method = RequestMethod.GET)
	public String getToken(RequestTokenVO requestTokenVO, Model model) throws Exception{
		log.info("🐧🐧🐧🐧🐧🐧🐧🐧🐧🐧🐧🐧🐧  사용자인증 확인");
		log.info("/openbank/oauthOK 로 이동");
		
		//토큰발급
		ResponseTokenVO responseToken=
			openBankingService.requestToken(requestTokenVO);
		
		//정보들고 토큰발급으로 이동
//		model.addAttribute("responseToken", responseToken);
		model.addAttribute("responseToken", responseToken);
		session.setAttribute("token", responseToken.getAccess_token());
		
		log.info("code : "+requestTokenVO.getCode());
		log.info("scope : "+requestTokenVO.getScope());
		log.info("clinet_info : "+requestTokenVO.getClient_info());
		log.info("state : "+requestTokenVO.getState());

		//return "redirect:/openbank/oauth_ok";
	    return "/openbank/oauthOK";
	}
	
		// 사용자 정보 조회
		@RequestMapping(value = "/userInfo", method = RequestMethod.GET)
		public String getUserInfo( UserInfoRequestVO userInfoRequestVO, Model model) {
			log.info("🐧🐧🐧🐧🐧🐧🐧🐧🐧🐧🐧🐧🐧   사용자정보 확인");
			log.info("/openbank/acct_user_info 로 이동");
			
			// Service 객체의 findUser() 메서드를 호출하여 사용자 정보 조회
			// => 파라미터 : UserInfoRequestVO, 리턴타입 UserInfoResponseVO
			UserInfoResponseVO userInfo = openBankingService.findUser(userInfoRequestVO);
			
			// Model 객체에 UserInfoResponseVO 객체와 엑세스토큰 저장
			model.addAttribute("userInfo", userInfo);
			session.setAttribute("access_token", userInfoRequestVO.getAccess_token());
			
			log.info("Access_token : "+userInfoRequestVO.getAccess_token());
			log.info("userinfo : "+userInfoRequestVO.getUser_seq_no());
			
			return "/openbank/acct_user_info";
		}
		
		// 등록계좌 조회
		@RequestMapping(value = "/accountList", method = RequestMethod.GET)
		public String getAccountList( AccountSearchRequestVO accountSearchRequestVO, Model model) {
			log.info("🐧🐧🐧🐧🐧🐧🐧🐧🐧🐧🐧🐧🐧  등록계좌 확인");
			log.info("/openbank/acct_list 로 이동");
			
			// Service 객체의 findAccount() 메서드를 호출하여 사용자 정보 조회
			// => 파라미터 : AccountSearchRequestVO, 리턴타입 AccountSearchResponseVO
			AccountSearchResponseVO accountList = openBankingService.findAccount(accountSearchRequestVO);
			
			model.addAttribute("accountList", accountList);
			session.setAttribute("access_token", accountSearchRequestVO.getAccess_token());
			
			// Model 객체에 AccountSearchResponseVO 객체와 엑세스토큰 저장
			log.info("Access_token : "+accountSearchRequestVO.getAccess_token());
			log.info("userinfo : "+accountSearchRequestVO.getUser_seq_no());
			log.info("include_cancel_yn : "+accountSearchRequestVO.getInclude_cancel_yn());
			log.info("Sort_order : "+accountSearchRequestVO.getSort_order());

			return "/openbank/acct_list";
		}
		
		// 등록계좌 해지
		@RequestMapping(value = "/accountCancel", method = RequestMethod.POST)
		public String cancelAccount( AccountCancelRequestVO accountCancelRequestVO, Model model) {
			log.info("🐧🐧🐧🐧🐧🐧🐧🐧🐧🐧🐧🐧🐧   등록계좌 해지!");
			log.info("/openbank/acct_cancel 로 이동");
			
			// Service 객체의 cancelAccount() 메서드를 호출하여 사용자 정보 조회
			// => 파라미터 : AccountcancelRequestVO, 리턴타입 AccountcancelResponseVO
			AccountCancelResponseVO accountCancel = openBankingService.cancelAccount(accountCancelRequestVO);
			
			// Model 객체에 AccountcancelResponseVO 객체와 엑세스토큰 저장
			model.addAttribute("accountCancel", accountCancel);
			session.setAttribute("access_token", accountCancelRequestVO.getAccess_token());
			
			log.info("Access_token : "+accountCancelRequestVO.getAccess_token());
			log.info("bank_tran_id : "+accountCancelRequestVO.getBank_tran_id());
			log.info("scope : "+accountCancelRequestVO.getScope());
			log.info("fintech_use_num : "+accountCancelRequestVO.getFintech_use_num());
			
			return "/openbank/acct_cancel";
		}
		
		// 잔액조회 
		@RequestMapping(value = "/accountBalance", method = RequestMethod.GET)
		public String getAccountBalance( AccountBalanceRequestVO accountBalanceRequestVO, Model model) {
			log.info("🐧🐧🐧🐧🐧🐧🐧🐧🐧🐧🐧🐧🐧   계좌 잔액 조회");
			log.info("/openbank/acct_balance 로 이동");
			log.info(accountBalanceRequestVO+"");
			
			// Service 객체의 balanceAccount() 메서드를 호출하여 사용자 정보 조회
			// => 파라미터 : AccountbalanceRequestVO, 리턴타입 AccountbalanceResponseVO
			AccountBalanceResponseVO accountBalance = openBankingService.findAccountBalance(accountBalanceRequestVO);
			
			// Model 객체에 AccountcancelResponseVO 객체와 엑세스토큰 저장
			model.addAttribute("accountBalance", accountBalance);
			session.setAttribute("bank_tran_id", accountBalanceRequestVO.getBank_tran_id());
			session.setAttribute("fintech_use_num", accountBalanceRequestVO.getFintech_use_num());
			log.info("%%%%%%%%%%%은행이름: "+accountBalance.getBank_name());
			log.info("");
			log.info("");
			log.info("");
			log.info("");
			log.info("");
			log.info("");
			log.info("");
			
			
//			log.info("Access_token : "+accountBalanceRequestVO.getAccess_token());
			log.info("bank_tran_id : "+accountBalanceRequestVO.getBank_tran_id());
			log.info("fintech_use_num : "+accountBalanceRequestVO.getFintech_use_num());
			log.info("tran_dtime : "+accountBalanceRequestVO.getTran_dtime());
			
			return "/openbank/acct_balance";
		}
		
		
		// 거래내역조회 
		@RequestMapping(value = "/accountTran", method = RequestMethod.GET)
		public String getAccountTran( AccountTranRequestVO accountTranRequestVO, Model model) {
			log.info("🐧🐧🐧🐧🐧🐧🐧🐧🐧🐧🐧🐧🐧   계좌 거래 내역 조회");
			log.info("/openbank/acct_tran 로 이동");
			
			// Service 객체의 accountTran() 메서드를 호출하여 사용자 정보 조회
			// => 파라미터 : AccounttranRequestVO, 리턴타입 AccounttranResponseVO
			AccountTranResponseVO accountTran = openBankingService.findAccountTran(accountTranRequestVO);
			
			// Model 객체에 AccountcancelResponseVO 객체와 엑세스토큰 저장
			model.addAttribute("accountTran", accountTran);
//			model.addAttribute("access_token", accountTranRequestVO.getAccess_token());
			session.setAttribute("bank_tran_id", accountTranRequestVO.getBank_tran_id());
			
			return "/openbank/acct_tran";
		}
		

		// 출금이체
		@RequestMapping(value = "/tranWithdraw", method = RequestMethod.POST)
		public String getTranWithdraw( TranWithdrawRequestVO tranWithdrawRequestVO, Model model) {
			log.info("🐧🐧🐧🐧🐧🐧🐧🐧🐧🐧🐧🐧🐧  출금이체");
			log.info("/openbank/tran_withdraw 로 이동");
			
			// Service 객체의 tranWithdraw() 메서드를 호출하여 사용자 정보 조회
			// => 파라미터 : TransWithdrawRequestVO, 리턴타입 TransWithdrawResponseVO
			TranWithdrawResponseVO tranWithdraw = openBankingService.findTranWithdraw(tranWithdrawRequestVO);
			
			// Model 객체에 AccountcancelResponseVO 객체와 엑세스토큰 저장
			model.addAttribute("tranWithdraw", tranWithdraw);
			session.setAttribute("access_token", tranWithdrawRequestVO.getAccess_token());
			
			return "/openbank/tran_withdraw";
		}
		
		// 입금이체
		@RequestMapping(value = "/tranDeposit", method = RequestMethod.POST)
		public String getTranDeposit( TranDepositRequestVO tranDepositRequestVO, Model model) {
			log.info("🐧🐧🐧🐧🐧🐧🐧🐧🐧🐧🐧🐧🐧   입금이체");
			log.info("/openbank/tran_deposit 로 이동");
					
			// Service 객체의 tranDeposit() 메서드를 호출하여 사용자 정보 조회
			// => 파라미터 : TransDepositRequestVO, 리턴타입 TransDepositResponseVO
			TranDepositResponseVO tranDeposit = openBankingService.findTranDeposit(tranDepositRequestVO);
					
			// Model 객체에 tranDepositResponseVO 객체와 엑세스토큰 저장
			model.addAttribute("tranDeposit", tranDeposit);
			session.setAttribute("access_token", tranDepositRequestVO.getAccess_token());
					
			return "/openbank/tran_deposit";
		}
		
		// 이체결과조회
		@RequestMapping(value = "/tranResult", method = RequestMethod.POST)
		public String getTranResult( TranResultRequestVO tranResultRequestVO, Model model) {
			log.info("🐧🐧🐧🐧🐧🐧🐧🐧🐧🐧🐧🐧🐧  이체결과조회");
			log.info("/openbank/tran_result 로 이동");
					
			// Service 객체의 tranResult() 메서드를 호출하여 사용자 정보 조회
			// => 파라미터 : TransResultRequestVO, 리턴타입 TransResultResponseVO
			TranResultResponseVO tranResult = openBankingService.findTranResult(tranResultRequestVO);
					
			// Model 객체에 tranResultResponseVO 객체와 엑세스토큰 저장
			model.addAttribute("tranResult", tranResult);
			session.setAttribute("access_token", tranResultRequestVO.getAccess_token());
					
			return "/openbank/tran_result";
		}
		
		
}
