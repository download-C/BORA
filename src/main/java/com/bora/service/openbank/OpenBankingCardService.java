package com.bora.service.openbank;

import org.springframework.stereotype.Service;

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
import com.bora.domain.openbank.RequestTokenVO;
import com.bora.domain.openbank.ResponseTokenVO;
import com.bora.domain.openbank.UserInfoRequestVO;
import com.bora.domain.openbank.UserInfoResponseVO;

@Service
public interface OpenBankingCardService {
	
	//토큰 발급 요청
	public ResponseTokenVO requestToken(RequestTokenVO requestTokenVO) throws Exception;
	
	// 사용자 정보 조회
	public UserInfoResponseVO findUser(UserInfoRequestVO userInfoRequestVO) throws Exception;
	
	// 카드사용자 등록
	public RegistCardResponseVO registCard(RegistCardRequestVO registCardRequestVO) throws Exception;
	
	// 카드목록 조회
	public CardListResponseVO listCard(CardListRequestVO cardListRequestVO) throws Exception;
	
	// 카드기본정보 조회
	public CardSearchResponseVO findCard(CardSearchRequestVO cardSearchRequestVO) throws Exception;
		
	// 카드청구기본정보 조회
	public CardBillsResponseVO billsCard(CardBillsRequestVO cardBillsRequestVO) throws Exception;
		
	// 카드청구상세정보 조회
	public CardDetailBillsResponseVO detailBillsCard(CardDetailBillsRequestVO cardDetailBillsRequestVO) throws Exception;
	
	// 카드정보변경
	public CardUpdateResponseVO updateCard(CardUpdateRequestVO cardUpdateRequestVO) throws Exception;
	
	// 카드조회해지
	public CardDeleteResponseVO deleteCard(CardDeleteRequestVO cardDeleteRequestVO) throws Exception;
	
	// 선불거래내역조회
	public PrePaidTranResponseVO prePaidTran(PrePaidTranRequestVO prePaidTranRequestVO) throws Exception;
}
