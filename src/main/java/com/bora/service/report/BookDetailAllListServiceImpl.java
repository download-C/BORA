package com.bora.service.report;

import java.util.List;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.bora.domain.report.BookDetailAllListVO;
import com.bora.domain.report.BookLastMonListVO;
import com.bora.domain.report.BookThisMonListVO;
import com.bora.persistence.BookDetailDAO;

@Service
public class BookDetailAllListServiceImpl implements BookDetailAllListService{
	
	@Inject
	BookDetailDAO dao;
	
	private static final Logger log = LoggerFactory.getLogger(BookDetailAllListService.class);

	public List<BookLastMonListVO> getBookLastMonList(String loginID) throws Exception {
		log.info("♡♡♡♡♡♡♡♡♡♡getBookLastList(loginID) 호출");
		return dao.getBookLastMonList(loginID);
	}
	
	public List<BookThisMonListVO> getBookThisMonList(String loginID) throws Exception {
		log.info("♡♡♡♡♡♡♡♡♡♡getBookThisList(loginID) 호출");
		return dao.getBookThisMonList(loginID);
	}

	@Override
	public List<BookDetailAllListVO> getBookDetailAllList(String loginID) throws Exception {
		log.info("♡♡♡♡♡♡♡♡♡♡getBookDetailAllList(loginID) 호출");
		return dao.getBookDetailAllList(loginID);
	}

}
