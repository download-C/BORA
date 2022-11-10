package com.bora.service.report;

import java.util.List;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.bora.domain.report.BookDetailVO;
import com.bora.persistence.ConsumeDAO;

@Service
public class ConsumeAllListServiceImpl implements ConsumeAllListService{
	
	@Inject
	ConsumeDAO dao;
	
	private static final Logger log = LoggerFactory.getLogger(ConsumeAllListService.class);

	public List<BookDetailVO> getConsumeLastMonList(String loginID) throws Exception {
		log.info("♡♡♡♡♡♡♡♡♡♡getConsumeLastList(loginID) 호출");
		
		return dao.getConsumeLastMonList(loginID);
	}
	
	public List<BookDetailVO> getConsumeThisMonList(String loginID) throws Exception {
		log.info("♡♡♡♡♡♡♡♡♡♡getConsumeThisList(loginID) 호출");
		
		return dao.getConsumeThisMonList(loginID);
	}

	@Override
	public List<BookDetailVO> getConsumeAllList(String loginID) throws Exception {
		log.info("♡♡♡♡♡♡♡♡♡♡getConsumeAllList(loginID) 호출");
		
		return dao.getConsumeAllList(loginID);
	}
	


	
}
