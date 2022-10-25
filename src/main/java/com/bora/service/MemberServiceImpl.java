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

}
