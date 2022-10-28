package com.bora.openbank.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bora.openbank.vo.AccountSearchRequestVO;
import com.bora.openbank.vo.AccountSearchResponseVO;
import com.bora.openbank.vo.RequestTokenVO;
import com.bora.openbank.vo.ResponseTokenVO;
import com.bora.openbank.vo.UserInfoRequestVO;
import com.bora.openbank.vo.UserInfoResponseVO;


@Service
public class OpenBankingService {
	// OpenBankingApiClient 객체생성
	@Autowired
	private OpenBankingApiClient openBankingApiClient;

	//토큰 발급 요청
	public ResponseTokenVO requestToken(RequestTokenVO requestTokenVO) {
		return openBankingApiClient.requestToken(requestTokenVO);
	}
	
	// 사용자 정보 조회
	public UserInfoResponseVO findUser(UserInfoRequestVO userInfoRequestVO) {
		return openBankingApiClient.findUser(userInfoRequestVO);
	}

	public AccountSearchResponseVO findAccount(AccountSearchRequestVO accountSearchRequestVO) {
		return openBankingApiClient.findAccount(accountSearchRequestVO);
	}
	
}
