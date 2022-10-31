package com.bora.service;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

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
public class OpenBankingCardApiClient {
	// 변수 정의 
	private String client_id="04999bd7-be60-4fdd-bd38-3db1d4d15f9a";
	private String client_secret="881f480a-8196-4464-ac76-377c730a615d";
	private String redirect_uri="http://localhost:8088/fintech/callback";
	private String grant_type="authorization_code";
	// 기본 주소
	private String baseUrl = "https://testapi.openbanking.or.kr/v2.0";
	
	// REST 방식 API 요청
	private RestTemplate restTemplate;
	// 헤더 정보 관리 클래스 
	private HttpHeaders httpHeaders;
	
	// 헤더에 엑세스 토큰을 추가하는 setHeaderAccessToken() 메서드 정의
	// => 파라미터 : 엑세스토큰, 리턴타입 : HttpHeaders
	public HttpHeaders setHeaderAccessToken(String access_token) {
		// HttpHeaders 객체의 add() 메서드를 호출하여 "항목", "값" 형태로 파라미터 전달
		httpHeaders.add("Authorization", "Bearer " + access_token);
		return httpHeaders;
	}
	
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
		= new LinkedMultiValueMap<String, String>();
		parameters.add("code", requestTokenVO.getCode());
		parameters.add("client_id", requestTokenVO.getClient_id());
		parameters.add("client_secret", requestTokenVO.getClient_secret());
		parameters.add("redirect_uri", requestTokenVO.getRedirect_uri());
		parameters.add("grant_type", requestTokenVO.getGrant_type());
		
		// HttpHeader parameters 담아서 감 => HttpEntity
		HttpEntity<MultiValueMap<String, String>> param=
				new HttpEntity<MultiValueMap<String,String>>(parameters,httpHeaders);
		
		String requestUrl = "https://testapi.openbanking.or.kr/oauth/2.0/token";
		return restTemplate.exchange(requestUrl, 
				HttpMethod.POST , param, ResponseTokenVO.class).getBody();
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
	public RegistCardResponseVO registCard(RegistCardRequestVO registCardRequestVO) {
		/// REST 방식 요청에 필요한 객체 생성
		restTemplate = new RestTemplate();
		httpHeaders = new HttpHeaders();
		
		// 2.2.1 사용자정보조회 API URL 주소 생성
		String url = baseUrl + "/user/register_card";
		
		System.out.println(registCardRequestVO.getAccess_token());
		
		httpHeaders.add("Authorization", "Bearer"+registCardRequestVO.getAccess_token());
		
		HttpEntity<String> openBankingRegistCardRequest = new HttpEntity<String>(httpHeaders);
		
		UriComponents uriBuilder = UriComponentsBuilder.fromHttpUrl(url)
				.queryParam("member_bank_code", registCardRequestVO.getMember_bank_code())
				.queryParam("info_prvd_agmt_yn", registCardRequestVO.getInfo_prvd_agmt_yn())
				.build();
		
		return restTemplate.exchange(uriBuilder.toString(), 
				HttpMethod.POST, openBankingRegistCardRequest, RegistCardResponseVO.class).getBody();
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
				.queryParam("user_seq_no", cardListRequestVO.getUser_seq_no())
				.queryParam("member_bank_code", cardListRequestVO.getMember_bank_code())
				.queryParam("befor_inquiry_trace_info", cardListRequestVO.getBefor_inquiry_trace_info())
				.build();
		
		return restTemplate.exchange(uriBuilder.toString(), 
				HttpMethod.GET, openBankingCardListRequest, CardListResponseVO.class).getBody();
	}
	public CardSearchResponseVO findCard(CardSearchRequestVO cardSearchRequestVO) {
		/// REST 방식 요청에 필요한 객체 생성
		restTemplate = new RestTemplate();
		httpHeaders = new HttpHeaders();
		
		// 2.2.1 사용자정보조회 API URL 주소 생성
		String url = baseUrl + "/cards/issue_info";
		
		System.out.println(cardSearchRequestVO.getAccess_token());
		
		httpHeaders.add("Authorization", "Bearer"+cardSearchRequestVO.getAccess_token());
		
		HttpEntity<String> openBankingCardSearchRequest = new HttpEntity<String>(httpHeaders);
		
		UriComponents uriBuilder = UriComponentsBuilder.fromHttpUrl(url)
				.queryParam("user_seq_no", cardSearchRequestVO.getUser_seq_no())
				.queryParam("member_bank_code", cardSearchRequestVO.getMember_bank_code())
				.queryParam("befor_inquiry_trace_info", cardSearchRequestVO.getCard_id())
				.build();
		
		return restTemplate.exchange(uriBuilder.toString(), 
				HttpMethod.GET, openBankingCardSearchRequest, CardSearchResponseVO.class).getBody();
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
				.queryParam("user_seq_no", cardBillsRequestVO.getUser_seq_no())
				.queryParam("member_bank_code", cardBillsRequestVO.getMember_bank_code())
				.queryParam("befor_inquiry_trace_info", cardBillsRequestVO.getBefor_inquiry_trace_info())
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
				.queryParam("user_seq_no", cardDetailBillsRequestVO.getUser_seq_no())
				.queryParam("member_bank_code", cardDetailBillsRequestVO.getMember_bank_code())
				.queryParam("befor_inquiry_trace_info", cardDetailBillsRequestVO.getBefor_inquiry_trace_info())
				.build();
		
		return restTemplate.exchange(uriBuilder.toString(), 
				HttpMethod.GET, openBankingCardDetailBillsRequest, CardDetailBillsResponseVO.class).getBody();
	}
}
