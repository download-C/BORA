package com.bora.service;

import com.bora.domain.MemberVO;

public interface MainService {
	public void joinMember(MemberVO vo) throws Exception;

	public MemberVO loginMember(MemberVO vo) throws Exception;
}