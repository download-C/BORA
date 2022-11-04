package com.bora.persistence;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.bora.domain.report.BookDetailVO;
import com.bora.domain.report.BookVO;

@Repository
public class BookDAOImpl implements BookDAO{
	
	@Inject
	SqlSession session;
	
	final static String NAMESPACE = "com.bora.mapper.BookMapper";
	
	private static final Logger log = LoggerFactory.getLogger(BookDAOImpl.class);

	@Override
	public Integer writeBook(BookVO vo, BookDetailVO detail) throws Exception {
		log.info("writeBook(vo) 호출");
		log.info("가계부 DB 저장 완료");
		return session.insert(NAMESPACE+".writeBook", vo);
	}
	
	
}
