package com.bora.service;

import com.bora.domain.member.MemberVO;

public interface MemberService {

	public MemberVO getMember(String id) throws Exception;

	public MemberVO getMemberNick(String nick) throws Exception;

	public int updateMember(MemberVO vo) throws Exception;

	public int deleteMember(String id) throws Exception;

	
}
