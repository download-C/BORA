package com.bora.service.report;

import java.util.List;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.bora.domain.report.ConsumeAllListVO;
import com.bora.domain.report.ConsumeLastThisListVO;
import com.bora.persistence.ConsumeDAO;

@Service
public class ConsumeAllListServiceImpl implements ConsumeAllListService{
	
	@Inject
	ConsumeDAO dao;
	
	private static final Logger log = LoggerFactory.getLogger(ConsumeAllListService.class);

	public List<ConsumeLastThisListVO> getConsumeLastMonList(String loginID) throws Exception {
		log.info("♡♡♡♡♡♡♡♡♡♡getConsumeLastList(loginID) 호출");
		
		return dao.getConsumeLastMonList("admin");
	}
	
	public List<ConsumeLastThisListVO> getConsumeThisMonList(String loginID) throws Exception {
		log.info("♡♡♡♡♡♡♡♡♡♡getConsumeThisList(loginID) 호출");
		
		return dao.getConsumeThisMonList("admin");
	}

	@Override
	public List<ConsumeAllListVO> getConsumeAllList(String loginID) throws Exception {
		log.info("♡♡♡♡♡♡♡♡♡♡getConsumeAllList(loginID) 호출");
		
		return dao.getConsumeAllList("admin");
	}
	


	
}
