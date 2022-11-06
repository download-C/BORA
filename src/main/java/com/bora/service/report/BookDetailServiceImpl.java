package com.bora.service.report;

import java.util.List;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.bora.domain.report.BookDetailVO;
import com.bora.persistence.BookDetailDAO;

@Service
public class BookDetailServiceImpl implements BookDetailService{
	
	@Inject
	BookDetailDAO dao;
	
	private static final Logger log = LoggerFactory.getLogger(BookDetailServiceImpl.class);

	@Override
	public Integer writeBookDetail(BookDetailVO detail) throws Exception {
		log.info("♡♡♡♡♡♡♡♡♡♡writeBookDetail(detail) 호출");
		return dao.writeBookDetail(detail);
	}
	
	public Integer getBookDetailMaxNum() throws Exception {
		log.info("getBookDetailMaxNum() 호출 -> 방금 쓴 가계부 글 번호 가져오기");
		return dao.getBookDetailMaxNum();
	}

	@Override
	public List<BookDetailVO> getBookDetailList(String loginID) throws Exception {
		log.info("♡♡♡♡♡♡♡♡♡♡getBookDetailList(loginID) 호출");
		return dao.getBookDetailList(loginID);
	}

	@Override
	public BookDetailVO getBookDetailContent(Integer bk_detail_num, String loginID) throws Exception {
		log.info("♡♡♡♡♡♡♡♡♡♡getBookDetailContent(bk_detail_num, loginID) 호출");
		return dao.getBookDetailContent(bk_detail_num, loginID);
	}

	@Override
	public List<BookDetailVO> getBookDetailAll() throws Exception {
		log.info("♡♡♡♡♡♡♡♡♡♡getBookDetailAll() 호출");
		return dao.getBookDetailAll();
	}

	@Override
	public Integer updateBookDetail(BookDetailVO detail) throws Exception {
		log.info("updateBookDetail(detail) 호출");
		return dao.updateBookDetail(detail);
	}

	@Override
	public Integer deleteBookDetail(Integer bk_detail_num, String loginID) throws Exception {
		log.info("deleteBookDetail(bk_detail_numk, loginID) 호출");
		return dao.deleteBookDetail(bk_detail_num, loginID);
	}
	

}
