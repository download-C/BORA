package com.bora.service.report;

import java.util.List;

import com.bora.domain.board.PageMakerVO;
import com.bora.domain.report.BookDetailVO;
import com.bora.domain.report.BookVO;

public interface BookService {
	
	public Integer writeBook(BookVO book) throws Exception;
	
	public Integer writeBook(BookVO book, Integer bk_detail_num) throws Exception;
	
	public List<BookVO> getBookListAll(String loginID) throws Exception;

	public List<BookVO> getBookListPage(String loginID, PageMakerVO pm) throws Exception;

	public Integer getBookCnt(String loginID) throws Exception;

	public BookVO getBook(int bk_num, String loginID) throws Exception;

	public Integer updateBook(BookVO book) throws Exception;

	public int deleteBook(Integer bk_num, String loginID) throws Exception;

	public List<BookVO> getMonthBookList(int year, int month, String loginID) throws Exception;

	public BookVO getMonthBook(int year, int month, String loginID) throws Exception;

	public Integer getBookMaxNum() throws Exception;

	public int getMonthBudget(String loginID, int year, int month) throws Exception;

	public int updateMonthBudget(String loginID, Integer year, Integer month, Integer bk_budget) throws Exception;

	public int getMonthBookMoney(String loginID, int year, int month) throws Exception;

}
