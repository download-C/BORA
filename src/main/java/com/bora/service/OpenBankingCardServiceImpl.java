package com.bora.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bora.domain.openbank.card.CardBillsRequestVO;
import com.bora.domain.openbank.card.CardBillsResponseVO;
import com.bora.domain.openbank.card.CardDeleteRequestVO;
import com.bora.domain.openbank.card.CardDeleteResponseVO;
import com.bora.domain.openbank.card.CardDetailBillsRequestVO;
import com.bora.domain.openbank.card.CardDetailBillsResponseVO;
import com.bora.domain.openbank.card.CardListRequestVO;
import com.bora.domain.openbank.card.CardListResponseVO;
import com.bora.domain.openbank.card.CardSearchRequestVO;
import com.bora.domain.openbank.card.CardSearchResponseVO;
import com.bora.domain.openbank.card.CardUpdateRequestVO;
import com.bora.domain.openbank.card.CardUpdateResponseVO;
import com.bora.domain.openbank.card.PrePaidTranRequestVO;
import com.bora.domain.openbank.card.PrePaidTranResponseVO;
import com.bora.domain.openbank.card.RegistCardRequestVO;
import com.bora.domain.openbank.card.RegistCardResponseVO;
import com.bora.domain.openbank.RequestTokenVO;
import com.bora.domain.openbank.ResponseTokenVO;
import com.bora.domain.openbank.UserInfoRequestVO;
import com.bora.domain.openbank.UserInfoResponseVO;

@Service
public class OpenBankingCardServiceImpl implements OpenBankingCardService {
	// OpenBankingApiClient 객체생성
	@Autowired
	private OpenBankingCardApiClient openBankingApiClient;

	//토큰 발급 요청
	public ResponseTokenVO requestToken(RequestTokenVO requestTokenVO) throws Exception {
		return openBankingApiClient.requestToken(requestTokenVO);
	}
	// 사용자 정보 조회
	public UserInfoResponseVO findUser(UserInfoRequestVO userInfoRequestVO) throws Exception {
		return openBankingApiClient.findUser(userInfoRequestVO);
	}
	// 카드사용자 등록
	public RegistCardResponseVO registCard(RegistCardRequestVO registCardRequestVO) throws Exception {
		return openBankingApiClient.registCard(registCardRequestVO);
	}
	// 카드목록 조회
	public CardListResponseVO listCard(CardListRequestVO cardListRequestVO) throws Exception {
		return openBankingApiClient.listCard(cardListRequestVO);
	}
	// 카드기본정보 조회
	public CardSearchResponseVO findCard(CardSearchRequestVO cardSearchRequestVO) throws Exception {
		return openBankingApiClient.findCard(cardSearchRequestVO);
	}
	// 카드청구기본정보 조회
	public CardBillsResponseVO billsCard(CardBillsRequestVO cardBillsRequestVO) throws Exception {
		return openBankingApiClient.billsCard(cardBillsRequestVO);
	}
	// 카드청구상세정보 조회
	public CardDetailBillsResponseVO detailBillsCard(CardDetailBillsRequestVO cardDetailBillsRequestVO) throws Exception {
		return openBankingApiClient.detailBillsCard(cardDetailBillsRequestVO);
	}
	// 카드정보변경
	public CardUpdateResponseVO updateCard(CardUpdateRequestVO cardUpdateRequestVO) throws Exception {
		return openBankingApiClient.updateCard(cardUpdateRequestVO);
	}
	// 카드조회해지
	public CardDeleteResponseVO deleteCard(CardDeleteRequestVO cardDeleteRequestVO) throws Exception {
		return openBankingApiClient.deleteCard(cardDeleteRequestVO);
	}
	// 선불거래내역조회
	public PrePaidTranResponseVO prePaidTran(PrePaidTranRequestVO prePaidTranRequestVO) throws Exception {
		return openBankingApiClient.prePaidTran(prePaidTranRequestVO);
	}
}
