package com.bora.persistence;

import com.bora.domain.MemberVO;

public interface MemberDAO {

	void joinMember(MemberVO vo) throws Exception;

}
