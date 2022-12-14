package com.bora.service.report;

import java.util.List;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.bora.domain.board.PageVO;
import com.bora.domain.report.BookDetailVO;
import com.bora.domain.report.BookVO;
import com.bora.persistence.report.BookDAO;
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

	@Override
	public List<BookVO> getMonthBookList(int year, int month, String loginID) throws Exception {
		log.info("getMonthBookList(year, month, loginID) 호출");
		return dao.getMonthBookList(year, month, loginID);
	}

	@Override
	public BookVO getMonthBook(int year, int month, String loginID) throws Exception {
		log.info("getMonthBook(year, month, loginID) 호출");
		return dao.getMonthBook(year, month, loginID);
	}

	@Override
	public Integer writeBook(BookVO book) throws Exception {
		log.info("writeBook(book) 호출");
		return dao.writeBook(book);
	}

	@Override
	public Integer getBookMaxNum() throws Exception {
		log.info("getBookMaxNum() 호출");
		return dao.getBookMaxNum();
	}

	@Override
	public int getMonthBudget(String loginID, int year, int month) throws Exception {
		log.info("getMonthBudget(loginID, year, month) 호출");
		return dao.getMonthBudget(loginID, year, month);
	}

	@Override
	public int updateMonthBudget(String loginID, Integer year, Integer month, Integer bk_budget) throws Exception {
		log.info("updateMonthBudget(loginID, year, month, bk_budget) 호출");
		return dao.updateMonthBudget(loginID, year, month, bk_budget);
	}

	@Override
	public int getMonthBookMoney(String loginID, int year, int month) throws Exception {
		log.info("getMonthBookMoney(loginID, year, month) 호출");
		return dao.getMonthBookMoney(loginID, year, month);
	}
	
	
}


