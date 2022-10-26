package com.bora.service;

import com.bora.domain.MemberVO;

public interface MemberService {

	public void joinMember(MemberVO vo) throws Exception;

	public MemberVO loginMember(MemberVO vo) throws Exception;

	public MemberVO getMember(String id) throws Exception;

}
