package com.bora.persistence;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.bora.domain.report.BookDetailVO;

public class BookDetailDAOImpl implements BookDetailDAO{
	@Inject
	SqlSession session;
	
	private final static String NAMESPACE = "com.bora.mapper.BookDetailMapper";
	
	private static final Logger log = LoggerFactory.getLogger(BookDetailDAOImpl.class);
	
	@Override
	public void writeBookDetail(BookDetailVO detail) throws Exception {
		session.insert(NAMESPACE+".writeBookDetail", detail);		
	}

	@Override
	public BookDetailVO getBookDetail(BookDetailVO detail) throws Exception {
		BookDetailVO detail2 =  session.selectOne(NAMESPACE+".getBookDetail");
		return detail2;
	}

	@Override
	public Integer updateBookDetail(BookDetailVO detail) throws Exception {
		return session.update(NAMESPACE+".updateBookDetail", detail);
	}
	
	
	
	

}
