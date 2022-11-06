package com.bora.service.report;

import java.util.List;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.bora.domain.board.PageVO;
import com.bora.domain.report.BookDetailVO;
import com.bora.domain.report.BookVO;
import com.bora.persistence.BookDAO;
import com.bora.domain.board.PageMakerVO;

@Service
public class BookServiceImpl implements BookService{
	
	@Inject
	BookDAO dao;
	
	private static final Logger log = LoggerFactory.getLogger(BookServiceImpl.class);
	
	public Integer writeBook(BookVO book, Integer bk_detail_num) throws Exception {
		log.info("writeBook(book, bk_detail_num) 호출");
		return dao.writeBook(book, bk_detail_num);
	}
	
	@Override
	public List<BookVO> getBookListAll(String loginID) throws Exception {
		log.info("getBookListPage(vo) 호출");
		return dao.getBookListAll(loginID);	
	}

	@Override
	public List<BookVO> getBookListPage(String loginID, PageMakerVO pm) throws Exception {
		log.info("getBookListPage(vo) 호출");
		return dao.getBookListPage(loginID, pm);
	}

	@Override
	public Integer getBookCnt(String loginID) throws Exception {
		log.info("getBookCnt(vo) 호출");
		return dao.getBookCnt(loginID);
	}

	@Override
	public BookVO getBook(int bk_num, String loginID) throws Exception {
		log.info("getBook(bk_num) 호출");
		return dao.getBook(bk_num, loginID);
	}

	@Override
	public Integer updateBook(BookVO book) throws Exception {
		log.info("updateBook(book) 호출");
		return dao.updateBook(book);
	}

	@Override
	public int deleteBook(Integer bk_num, String loginID) throws Exception {
		log.info("deleteBook(bk_num) 호출");
		return dao.deleteBook(bk_num, loginID);
	}
	
	
	

}


