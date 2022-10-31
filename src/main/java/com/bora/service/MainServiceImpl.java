package com.bora.service;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.bora.domain.MemberVO;
import com.bora.persistence.MainDAO;

@Service
public class MainServiceImpl implements MainService{
	
	@Inject
	MainDAO dao;
	
	private static final Logger log = LoggerFactory.getLogger(MainServiceImpl.class);
		
	public void joinMember(MemberVO vo) throws Exception{
		dao.joinMember(vo);
	}

	@Override
	public MemberVO loginMember(MemberVO vo) throws Exception {

		return dao.loginMember(vo);
	}
	
}
