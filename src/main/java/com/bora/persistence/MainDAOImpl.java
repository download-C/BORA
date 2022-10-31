package com.bora.persistence;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.bora.domain.MemberVO;

@Repository
public class MainDAOImpl implements MainDAO{
	
	@Inject
	private SqlSession session;
	
	private static String NAMESPACE = "com.bora.mapper.MainMapper";
	
	private static final Logger log = LoggerFactory.getLogger(MainDAOImpl.class);
	
	@Override
	public void joinMember(MemberVO vo) throws Exception {
		session.insert(NAMESPACE+".joinMember", vo);
	}
	
	@Override
	public MemberVO loginMember(MemberVO vo) throws Exception {
		return session.selectOne(NAMESPACE+".loginMember", vo);
	}
}
