package com.bora.service.openbank;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

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


@Service
public class OpenBankingApiClient {
	// 변수 정의 
	private String client_id="2ce89526-eccf-45b0-a59f-1ca10bc64b30";
	private String client_secret="d4f6ae0c-2f45-497a-8833-bc4058ada4d1";
	private String redirect_uri="http://localhost:8088/openbank/callback";
	private String grant_type="authorization_code";
	
	// 기본 주소
	private String baseUrl = "https://testapi.openbanking.or.kr/v2.0";
	
	// REST 방식 API 요청
	private RestTemplate restTemplate;
	
	// 헤더 정보 관리 클래스 
	private HttpHeaders httpHeaders;


	private static final Logger log = LoggerFactory.getLogger(OpenBankingApiClient.class);
	
	// 헤더에 엑세스 토큰을 추가하는 setHeaderAccessToken() 메서드 정의
	// => 파라미터 : 엑세스토큰, 리턴타입 : HttpHeaders
	public HttpHeaders setHeaderAccessToken(String access_token) {
		// HttpHeaders 객체의 add() 메서드를 호출하여 "항목", "값" 형태로 파라미터 전달
		httpHeaders.add("Authorization", "Bearer " + access_token);
		return httpHeaders;
	}
	
	//토큰발급
	public ResponseTokenVO requestToken(RequestTokenVO requestTokenVO) {
		//		요청 메시지 URL
		//HTTP URL 	https://testapi.openbanking.or.kr/oauth/2.0/token
		//HTTP Method POST
		//Content-Type application/x-www-form-urlencoded; charset=UTF-8
		//요청값code client_id client_secret redirect_uri grant_type
		restTemplate=new RestTemplate();
		httpHeaders=new HttpHeaders();
		// Content-Type 지정 http header
		httpHeaders.add("Content-Type", "application/x-www-form-urlencoded; charset=UTF-8");
		
		requestTokenVO.setRequestToken(client_id, client_secret, redirect_uri, grant_type);
		// application/x-www-form-urlencoded; charset=UTF-8" 객체저장 불가능
		MultiValueMap<String, String> parameters
		=new LinkedMultiValueMap<String, String>();
		parameters.add("code", requestTokenVO.getCode());
		parameters.add("client_id", requestTokenVO.getClient_id());
		parameters.add("client_secret", requestTokenVO.getClient_secret());
		parameters.add("redirect_uri", requestTokenVO.getRedirect_uri());
		parameters.add("grant_type", requestTokenVO.getGrant_type());
		
		// HttpHeader,HttpBody  parameters 담아서 감 => HttpEntity
		HttpEntity<MultiValueMap<String, String>> param=
				new HttpEntity<MultiValueMap<String,String>>(parameters,httpHeaders);
		
		String requestUrl="https://testapi.openbanking.or.kr/oauth/2.0/token";
		return restTemplate.exchange(requestUrl, HttpMethod.POST, param, ResponseTokenVO.class).getBody();
	}
	
	// 사용자 정보 조회
	public UserInfoResponseVO findUser(UserInfoRequestVO userInfoRequestVO) {
		/// REST 방식 요청에 필요한 객체 생성
		restTemplate = new RestTemplate();
		httpHeaders = new HttpHeaders();
		
		// 2.2.1 사용자정보조회 API URL 주소 생성
		String url = baseUrl + "/user/me";
		
		// HttpHeaders 와 HttpBody 오브젝트를 하나의 객체로 관리하기 위한 HttpEntity 객체 생성
		// => 파라미터로 HttpHeaders 객체 전달을 위해 
		//    헤더 생성 작업을 수행하는 사용자 정의 메서드 setHeaderAccessToken() 호출
		//    (파라미터로 엑세스 토큰 전달 => UserInfoRequestVO 객체에 저장되어 있음)
		HttpEntity<String> openBankingUserInfoRequest = 
				new HttpEntity<String>(setHeaderAccessToken(userInfoRequestVO.getAccess_token()));
		
		// UriComponentsBuilder 클래스의 fromHttpUrl() 메서드를 호출하여 URL 파라미터 정보 생성
		// 1단계. UriComponentsBuilder.fromHttpUrl() 메서드를 호출하여 요청 URL 주소 전달
		// 2단계. 1단계에서 생성된 객체의 queryParam() 메서드를 호출하여 전달할 파라미터를
		//        키, 값 형식으로 전달
		// 3단계. 2단계에서 생성된 객체의 build() 메서드를 호출하여 UriComponents 객체 리턴(생성)
		// 위의 세 과정을 빌더 패턴(Builder Pattern)을 활용하여 하나의 문장으로 압축 가능
		// (자기 자신을 리턴하는 메서드 호출 후 연쇄적으로 메서드를 이어나가는 것)
		UriComponents uriBuilder = UriComponentsBuilder.fromHttpUrl(url)
				.queryParam("user_seq_no", userInfoRequestVO.getUser_seq_no())
				.build();
		
		// exchange() 메서드 파라미터 : UriBuilder 문자열로 변환, 요청방식, HttpEntity 객체,
		//                              응답데이터를 파싱하기 위한 클래스(.class 필수)
		// => 메서드 뒤에 .getBody() 메서드를 호출하여 body 데이터에 대한 파싱된 결과를 리턴받기
		return restTemplate.exchange(uriBuilder.toString(), HttpMethod.GET, openBankingUserInfoRequest, UserInfoResponseVO.class).getBody();
	}

	//계좌 조회
	public AccountSearchResponseVO findAccount(AccountSearchRequestVO accountSearchRequestVO) {
		/// REST 방식 요청에 필요한 객체 생성
		restTemplate = new RestTemplate();
		httpHeaders = new HttpHeaders();
		
		// 2.2.1 사용자정보조회 API URL 주소 생성
		String url = baseUrl + "/account/list";
		httpHeaders.add("Authorization", "Bearer " + accountSearchRequestVO.getAccess_token());
		
		HttpEntity<String> openBankingAccountListRequest = new HttpEntity<String>(httpHeaders);
		
		UriComponents uriBuilder = UriComponentsBuilder.fromHttpUrl(url)
				.queryParam("user_seq_no", accountSearchRequestVO.getUser_seq_no())
				.queryParam("include_cancel_yn", accountSearchRequestVO.getInclude_cancel_yn())
				.queryParam("sort_order", accountSearchRequestVO.getSort_order())
				.build();

		return restTemplate.exchange(uriBuilder.toString(), HttpMethod.GET, openBankingAccountListRequest, AccountSearchResponseVO.class).getBody();
	}

	
	//잔액조회
	public AccountBalanceResponseVO findAccountBalance(AccountBalanceRequestVO accountBalanceRequestVO) {
		/// REST 방식 요청에 필요한 객체 생성
		restTemplate = new RestTemplate();
		httpHeaders = new HttpHeaders();
		
		// 2.2.1 사용자정보조회 API URL 주소 생성
		String url = baseUrl + "/account/balance/fin_num";
		httpHeaders.add("Authorization", "Bearer " + accountBalanceRequestVO.getAccess_token());
		log.info("🐧🐧🐧🐧🐧🐧🐧🐧  url: "+url);
		HttpEntity<String> openBankingAccountBalanceRequest = new HttpEntity<String>(httpHeaders);
		log.info("🐧🐧🐧🐧🐧🐧🐧🐧  "+openBankingAccountBalanceRequest);
		UriComponents uriBuilder = UriComponentsBuilder.fromHttpUrl(url)
				.queryParam("bank_tran_id", accountBalanceRequestVO.getBank_tran_id())
				.queryParam("fintech_use_num", accountBalanceRequestVO.getFintech_use_num())
				.queryParam("tran_dtime", accountBalanceRequestVO.getTran_dtime())
				.build();
		log.info("🐧🐧🐧🐧🐧🐧🐧🐧  "+uriBuilder);
		return restTemplate.exchange(uriBuilder.toString(), HttpMethod.GET, openBankingAccountBalanceRequest, AccountBalanceResponseVO.class).getBody();
	}
	
	//거래내역조회
	public AccountTranResponseVO findAccountTran(AccountTranRequestVO accountTranRequestVO) {
		/// REST 방식 요청에 필요한 객체 생성
		restTemplate = new RestTemplate();
		httpHeaders = new HttpHeaders();
		
		httpHeaders.add("Content-Type", "application/x-www-form-urlencoded; charset=UTF-8");

		String url = baseUrl + "/account/transaction_list/fin_num";
		httpHeaders.add("Authorization", "Bearer " + accountTranRequestVO.getAccess_token());
		httpHeaders.add("Authorization", "Bearer " + accountTranRequestVO.getBank_tran_id());
	
		HttpEntity<String> openBankingAccountTranRequest = new HttpEntity<String>(httpHeaders);
		log.info("🐧🐧🐧🐧🐧🐧🐧  accountTran "+openBankingAccountTranRequest);
	
		UriComponents uriBuilder = UriComponentsBuilder.fromHttpUrl(url)
				.queryParam("bank_tran_id", accountTranRequestVO.getBank_tran_id())
				.queryParam("fintech_use_num", accountTranRequestVO.getFintech_use_num())
				.queryParam("inquiry_type", accountTranRequestVO.getInquiry_type())
				.queryParam("inquiry_base", accountTranRequestVO.getInquiry_base())
				.queryParam("from_date", accountTranRequestVO.getFrom_date())
				.queryParam("to_date", accountTranRequestVO.getTo_date())
				.queryParam("sort_order", accountTranRequestVO.getSort_order())
				.queryParam("tran_dtime", accountTranRequestVO.getTran_dtime())
				.build();

		log.info("🐧🐧🐧🐧🐧🐧🐧  accountTranRequestVO "+accountTranRequestVO);
		return restTemplate.exchange(uriBuilder.toString(), HttpMethod.GET, openBankingAccountTranRequest, AccountTranResponseVO.class).getBody();
	
	}


	public CardInfoResponseVO infoCard(CardInfoRequestVO cardInfoRequestVO) {
		/// REST 방식 요청에 필요한 객체 생성
		restTemplate = new RestTemplate();
		httpHeaders = new HttpHeaders();
				
		// 2.2.1 사용자정보조회 API URL 주소 생성
		String url = baseUrl + "/cards/issue_info";
		
		System.out.println(cardInfoRequestVO.getAccess_token());
		
        httpHeaders.add("Authorization", "Bearer"+cardInfoRequestVO.getAccess_token());
		
		HttpEntity<String> openBankingInfoCardRequest = new HttpEntity<String>(httpHeaders);
		
		UriComponents uriBuilder = UriComponentsBuilder.fromHttpUrl(url)
				.queryParam("access_token", cardInfoRequestVO.getAccess_token())
				.queryParam("bank_tran_id", cardInfoRequestVO.getBank_tran_id())
				.queryParam("user_seq_no", cardInfoRequestVO.getUser_seq_no())
				.queryParam("bank_code_std", cardInfoRequestVO.getBank_code_std())
				.queryParam("member_bank_code", cardInfoRequestVO.getMember_bank_code())
				.queryParam("card_id", cardInfoRequestVO.getCard_id())
				.build();
		
		return restTemplate.exchange(uriBuilder.toString(), 
				HttpMethod.GET, openBankingInfoCardRequest, CardInfoResponseVO.class).getBody();
	}
	public CardListResponseVO listCard(CardListRequestVO cardListRequestVO) {
		/// REST 방식 요청에 필요한 객체 생성
		restTemplate = new RestTemplate();
		httpHeaders = new HttpHeaders();
		
		// 2.2.1 사용자정보조회 API URL 주소 생성
		String url = baseUrl + "/cards";
		
		System.out.println(cardListRequestVO.getAccess_token());
		
		httpHeaders.add("Authorization", "Bearer"+cardListRequestVO.getAccess_token());
		
		HttpEntity<String> openBankingCardListRequest = new HttpEntity<String>(httpHeaders);
		
		UriComponents uriBuilder = UriComponentsBuilder.fromHttpUrl(url)
				.queryParam("access_token", cardListRequestVO.getAccess_token())
				.queryParam("bank_tran_id", cardListRequestVO.getBank_tran_id())
				.queryParam("user_seq_no", cardListRequestVO.getUser_seq_no())
				.queryParam("bank_code_std", cardListRequestVO.getBank_code_std())
				.queryParam("member_bank_code", cardListRequestVO.getMember_bank_code())
				.build();
		
		return restTemplate.exchange(uriBuilder.toString(), 
				HttpMethod.GET, openBankingCardListRequest, CardListResponseVO.class).getBody();
	}
	public CardBillsResponseVO billsCard(CardBillsRequestVO cardBillsRequestVO) {
		/// REST 방식 요청에 필요한 객체 생성
		restTemplate = new RestTemplate();
		httpHeaders = new HttpHeaders();
		
		// 2.2.1 사용자정보조회 API URL 주소 생성
		String url = baseUrl + "/cards/bills";
		
		System.out.println(cardBillsRequestVO.getAccess_token());
		
		httpHeaders.add("Authorization", "Bearer"+cardBillsRequestVO.getAccess_token());
		
		HttpEntity<String> openBankingCardBillsRequest = new HttpEntity<String>(httpHeaders);
		
		UriComponents uriBuilder = UriComponentsBuilder.fromHttpUrl(url)
				.queryParam("access_token", cardBillsRequestVO.getAccess_token())
				.queryParam("bank_tran_id", cardBillsRequestVO.getBank_tran_id())
				.queryParam("user_seq_no", cardBillsRequestVO.getUser_seq_no())
				.queryParam("bank_code_std", cardBillsRequestVO.getBank_code_std())
				.queryParam("member_bank_code", cardBillsRequestVO.getMember_bank_code())
				.queryParam("from_month", cardBillsRequestVO.getFrom_month())
				.queryParam("to_month", cardBillsRequestVO.getTo_month())
				.build();
		
		return restTemplate.exchange(uriBuilder.toString(), 
				HttpMethod.GET, openBankingCardBillsRequest, CardBillsResponseVO.class).getBody();
	}
	public CardDetailBillsResponseVO detailBillsCard(CardDetailBillsRequestVO cardDetailBillsRequestVO) {
		/// REST 방식 요청에 필요한 객체 생성
		restTemplate = new RestTemplate();
		httpHeaders = new HttpHeaders();
		
		// 2.2.1 사용자정보조회 API URL 주소 생성
		String url = baseUrl + "/cards/bills/detail";
		
		System.out.println(cardDetailBillsRequestVO.getAccess_token());
		
		httpHeaders.add("Authorization", "Bearer"+cardDetailBillsRequestVO.getAccess_token());
		
		HttpEntity<String> openBankingCardDetailBillsRequest = new HttpEntity<String>(httpHeaders);
		
		UriComponents uriBuilder = UriComponentsBuilder.fromHttpUrl(url)
				.queryParam("access_token", cardDetailBillsRequestVO.getAccess_token())
				.queryParam("bank_tran_id", cardDetailBillsRequestVO.getBank_tran_id())
				.queryParam("user_seq_no", cardDetailBillsRequestVO.getUser_seq_no())
				.queryParam("bank_code_std", cardDetailBillsRequestVO.getBank_code_std())
				.queryParam("member_bank_code", cardDetailBillsRequestVO.getMember_bank_code())
				.queryParam("charge_month", cardDetailBillsRequestVO.getCharge_month())
				.queryParam("settlement_seq_no", cardDetailBillsRequestVO.getSettlement_seq_no())
				.build();
		
		return restTemplate.exchange(uriBuilder.toString(), 
				HttpMethod.GET, openBankingCardDetailBillsRequest, CardDetailBillsResponseVO.class).getBody();
	}
	
}
