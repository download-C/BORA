package com.bora.persistence;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.bora.domain.report.ConsumeAllListVO;
import com.bora.domain.report.ConsumeLastThisListVO;

@Repository
public class ConsumeDAOImpl implements ConsumeDAO{
	
	@Inject
	SqlSession session;
	
	private final static String NAMESPACE = "com.bora.mapper.ConsumeMapper";
	
	private static final Logger log = LoggerFactory.getLogger(ConsumeDAOImpl.class);
	
	@Override
	public List<ConsumeLastThisListVO> getConsumeLastMonList(String loginID) throws Exception {
		log.info("♡♡♡♡♡♡♡♡♡♡getConsumeLastMonList(loginID) 호출");
		return session.selectList(NAMESPACE+".getConsumeLastMonList", loginID);
	}
	
	@Override
	public List<ConsumeLastThisListVO> getConsumeThisMonList(String loginID) throws Exception {
		log.info("♡♡♡♡♡♡♡♡♡♡getConsumeThisMonList(loginID) 호출");
		return session.selectList(NAMESPACE+".getConsumeThisMonList", loginID);
	}
	
	@Override
	public List<ConsumeAllListVO> getConsumeAllList(String loginID) throws Exception {
		log.info("♡♡♡♡♡♡♡♡♡♡getConsumeAllList(loginID) 호출");
		return session.selectList(NAMESPACE+".getConsumeAllList", loginID);
	}
	


	
}
