package com.bora.service;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.bora.domain.MemberVO;
import com.bora.persistence.MemberDAO;

@Service
public class MemberServiceImpl implements MemberService{
	
	@Inject
	MemberDAO dao;

	private static final Logger log = LoggerFactory.getLogger(MemberServiceImpl.class);
	
	@Override
	public void joinMember(MemberVO vo) throws Exception {
		dao.joinMember(vo);
	}

	@Override
	public MemberVO loginMember(MemberVO vo) throws Exception {
		return dao.loginMember(vo);
	}

	@Override
	public MemberVO getMember(String id) throws Exception {
		log.info("getMember(id) 호출");
		return dao.getMember(id);
	}

	@Override
	public MemberVO getMemberNick(String nick) throws Exception {
		
		return dao.getMemberNick(nick);
	}

}
