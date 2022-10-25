package com.bora.persistence;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.bora.domain.MemberVO;

@Repository
public class MemberDAOImpl implements MemberDAO{

	@Inject
	private SqlSession session;
	private final static String NAMESPACE = "com.bora.mapper.MemberMapper";

	private static final Logger log = LoggerFactory.getLogger(MemberDAOImpl.class);
	
	
	@Override
	public void joinMember(MemberVO vo) throws Exception {
		session.insert(NAMESPACE+".joinMember2", vo);
	}

}
