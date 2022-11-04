package com.bora.service.report;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.bora.domain.report.BookDetailVO;
import com.bora.domain.report.BookVO;
import com.bora.persistence.BookDAO;

@Service
public class BookServiceImpl implements BookService{
	
	@Inject
	BookDAO dao;
	
	private static final Logger log = LoggerFactory.getLogger(BookServiceImpl.class);
	
	public Integer writeBook(BookVO vo, BookDetailVO detail) throws Exception {
		return dao.writeBook(vo, detail);
	}

}


