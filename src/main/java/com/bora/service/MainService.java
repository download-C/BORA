package com.bora.service;

import com.bora.domain.member.MemberVO;

public interface MainService {
	public void joinMember(MemberVO vo) throws Exception;

	public MemberVO loginMember(MemberVO vo) throws Exception;
	
	//카카오 로그인
	public String getAccessToken(String autorize_code) throws Exception;
				
	//카카오 사용자 정보 요청
	public MemberVO getUserInfo(String access_Token) throws Exception;
}
