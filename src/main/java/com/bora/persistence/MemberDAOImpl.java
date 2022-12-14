package com.bora.persistence;

import java.util.HashMap;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.bora.domain.member.MemberVO;

@Repository
public class MemberDAOImpl implements MemberDAO{

	@Inject
	private SqlSession session;
	private final static String NAMESPACE = "com.bora.mapper.MemberMapper";

	private static final Logger log = LoggerFactory.getLogger(MemberDAOImpl.class);
	
	


	@Override
	public MemberVO getMember(String id) throws Exception {
		return session.selectOne(NAMESPACE+".getMember", id);
	}

	@Override
	public MemberVO getMemberNick(String nick) throws Exception {
		
		return session.selectOne(NAMESPACE+".getMemberNick", nick);
	}

	@Override
	public int updateMember(MemberVO vo) throws Exception {

		return session.update(NAMESPACE+".updateMember", vo);
	}

	@Override
	public int deleteMember(String id) throws Exception {
		
		return session.delete(NAMESPACE+".deleteMember", id);
	}
	
}
