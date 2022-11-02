package com.bora.service.openbank;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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


@Service
public class OpenBankingService {
	// OpenBankingApiClient 객체생성
	@Autowired
	private OpenBankingApiClient openBankingApiClient;

	//토큰 발급 요청
	public ResponseTokenVO requestToken(RequestTokenVO requestTokenVO) {
		return openBankingApiClient.requestToken(requestTokenVO);
	}
	
	//사용자 정보 조회
	public UserInfoResponseVO findUser(UserInfoRequestVO userInfoRequestVO) {
		return openBankingApiClient.findUser(userInfoRequestVO);
	}

	//등록계좌 조회
	public AccountSearchResponseVO findAccount(AccountSearchRequestVO accountSearchRequestVO) {
		return openBankingApiClient.findAccount(accountSearchRequestVO);
	}
	
	//등록계좌 해지
	public AccountCancelResponseVO cancelAccount(AccountCancelRequestVO accountCancelRequestVO) {
		return openBankingApiClient.cancelAccount(accountCancelRequestVO);
	}
	
	//잔액조회
	public AccountBalanceResponseVO findAccountBalance(AccountBalanceRequestVO accountBalanceRequestVO) {
		return openBankingApiClient.findAccountBalance(accountBalanceRequestVO);
	}
	
	//거래내역조회
	public AccountTranResponseVO findAccountTran(AccountTranRequestVO accountTranRequestVO) {
		return openBankingApiClient.findAccountTran(accountTranRequestVO);
	}

	//출금이체
	public TranWithdrawResponseVO findTranWithdraw(TranWithdrawRequestVO tranWithdrawRequestVO) {
		return openBankingApiClient.findTranWithdraw(tranWithdrawRequestVO);
	}
	
	//입금이체
	public TranDepositResponseVO findTranDeposit(TranDepositRequestVO tranDepositRequestVO) {
		return openBankingApiClient.findTranDeposit(tranDepositRequestVO);
	}

	//이체결과조회
	public TranResultResponseVO findTranResult(TranResultRequestVO tranResultRequestVO) {
		return openBankingApiClient.findTranResult(tranResultRequestVO);
	}

	
}
