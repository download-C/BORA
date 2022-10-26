package com.bora.persistence;

import com.bora.domain.MemberVO;

public interface MemberDAO {

	public void joinMember(MemberVO vo) throws Exception;

	public MemberVO loginMember(MemberVO vo) throws Exception;

	public MemberVO getMember(String id) throws Exception;

}
