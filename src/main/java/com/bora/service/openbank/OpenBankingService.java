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
import com.bora.domain.openbank.card.CardInfoRequestVO;
import com.bora.domain.openbank.card.CardInfoResponseVO;
import com.bora.domain.openbank.card.CardListRequestVO;
import com.bora.domain.openbank.card.CardListResponseVO;
import com.bora.domain.openbank.card.bill.CardBillsRequestVO;
import com.bora.domain.openbank.card.bill.CardBillsResponseVO;
import com.bora.domain.openbank.card.bill.CardDetailBillsRequestVO;
import com.bora.domain.openbank.card.bill.CardDetailBillsResponseVO;
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
	
	//잔액조회
	public AccountBalanceResponseVO findAccountBalance(AccountBalanceRequestVO accountBalanceRequestVO) {
		return openBankingApiClient.findAccountBalance(accountBalanceRequestVO);
	}
	
	//거래내역조회
	public AccountTranResponseVO findAccountTran(AccountTranRequestVO accountTranRequestVO) {
		return openBankingApiClient.findAccountTran(accountTranRequestVO);
	}

	// 카드기본정보 조회
	public CardInfoResponseVO infoCard(CardInfoRequestVO cardInfoRequestVO) throws Exception {
		return openBankingApiClient.infoCard(cardInfoRequestVO);
	}
	
	// 카드목록 조회
	public CardListResponseVO listCard(CardListRequestVO cardListRequestVO) throws Exception {
		return openBankingApiClient.listCard(cardListRequestVO);
	}
	
	// 카드청구기본정보 조회
	public CardBillsResponseVO billsCard(CardBillsRequestVO cardBillsRequestVO) throws Exception {
		return openBankingApiClient.billsCard(cardBillsRequestVO);
	}
	
	// 카드청구상세정보 조회
	public CardDetailBillsResponseVO detailBillsCard(CardDetailBillsRequestVO cardDetailBillsRequestVO) throws Exception {
		return openBankingApiClient.detailBillsCard(cardDetailBillsRequestVO);
	}
	
	
	
}
