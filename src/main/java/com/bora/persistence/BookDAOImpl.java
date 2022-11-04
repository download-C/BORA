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
	
	SqlSession session;
	
	final static String NAMESPACE = "com.bora.mapper.BookMapper";
	
	private static final Logger log = LoggerFactory.getLogger(BookDAOImpl.class);

	@Override
	public void writeBook(BookDetailVO detail, BookVO vo) throws Exception {
		log.info("writeBook(vo) 호출");
		int result = session.insert(NAMESPACE+".writeBookDetail");
		if(result == 1) session.insert(NAMESPACE+".writeBook", vo);
		log.info("가계부 DB 저장 완료");
	}
	
	
}
