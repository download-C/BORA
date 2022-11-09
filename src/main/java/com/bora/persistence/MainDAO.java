package com.bora.persistence;

import com.bora.domain.member.MemberVO;

public interface MainDAO {

	public void joinMember(MemberVO vo) throws Exception;

	public MemberVO loginMember(MemberVO vo) throws Exception;
}
