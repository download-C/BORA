package com.bora.persistence;

import java.util.HashMap;
import java.util.Map;

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
		session.insert(NAMESPACE+".joinMember", vo);
	}
	
	@Override
	public MemberVO loginMember(MemberVO vo) throws Exception {
		return session.selectOne(NAMESPACE+".loginMember", vo);
	}

	@Override
	public MemberVO getMember(String id) throws Exception {
		return session.selectOne(NAMESPACE+".getMember", id);
	}

}
