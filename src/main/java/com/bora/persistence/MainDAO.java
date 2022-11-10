package com.bora.persistence;

import java.util.HashMap;

import com.bora.domain.member.MemberVO;

public interface MainDAO {

	public void joinMember(MemberVO vo) throws Exception;

	public MemberVO loginMember(MemberVO vo) throws Exception;
	
	// 카카오 로그인
	public void kakaoinsert(HashMap<String, Object> userInfo) throws Exception;
			
	public MemberVO findkakao(HashMap<String, Object> userInfo) throws Exception;
}
