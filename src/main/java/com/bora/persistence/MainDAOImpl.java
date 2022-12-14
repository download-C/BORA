package com.bora.persistence;

import java.util.HashMap;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.bora.domain.member.MemberVO;

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
	
	// 카카오 DB에 정보 저장
	@Override
	public void kakaoinsert(HashMap<String, Object> userInfo) throws Exception {
		session.insert(NAMESPACE+".joinMember",userInfo);
		
	}

	// 카카오 DB 정보 확인
	@Override
	public MemberVO findkakao(HashMap<String, Object> userInfo) throws Exception {
		log.info("DAOImpl : "+userInfo.get("user_name"));
		log.info("DAOImpl : "+userInfo.get("user_id"));
		
		return session.selectOne(NAMESPACE+".findKakao", userInfo);
	}
}
