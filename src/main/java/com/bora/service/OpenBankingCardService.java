package com.bora.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

@Service
public class OpenBankingCardService {
	// OpenBankingApiClient 객체생성
	@Autowired
	private OpenBankingCardApiClient openBankingApiClient;

	//토큰 발급 요청
	public ResponseTokenVO requestToken(RequestTokenVO requestTokenVO) {
		return openBankingApiClient.requestToken(requestTokenVO);
	}
	// 사용자 정보 조회
	public UserInfoResponseVO findUser(UserInfoRequestVO userInfoRequestVO) {
		return openBankingApiClient.findUser(userInfoRequestVO);
	}
	// 카드사용자 등록
	public RegistCardResponseVO registCard(RegistCardRequestVO registCardRequestVO) {
		return openBankingApiClient.registCard(registCardRequestVO);
	}
	// 카드목록 조회
	public CardListResponseVO listCard(CardListRequestVO cardListRequestVO) {
		return openBankingApiClient.listCard(cardListRequestVO);
	}
	// 카드기본정보 조회
	public CardSearchResponseVO findCard(CardSearchRequestVO cardSearchRequestVO) {
		return openBankingApiClient.findCard(cardSearchRequestVO);
	}
	// 카드청구기본정보 조회
	public CardBillsResponseVO billsCard(CardBillsRequestVO cardBillsRequestVO) {
		return openBankingApiClient.billsCard(cardBillsRequestVO);
	}
	// 카드청구상세정보 조회
	public CardDetailBillsResponseVO detailBillsCard(CardDetailBillsRequestVO cardDetailBillsRequestVO) {
		return openBankingApiClient.detailBillsCard(cardDetailBillsRequestVO);
	}
}
