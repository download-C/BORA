package com.bora.persistence.report;

import java.util.List;

import com.bora.domain.board.PageMakerVO;
import com.bora.domain.report.BookDetailVO;
import com.bora.domain.report.BookVO;

public interface BookDetailDAO {
	
	public Integer writeBookDetail(BookDetailVO detail) throws Exception;
	
	public Integer getBookDetailMaxNum() throws Exception;
	
	public List<BookDetailVO> getBookDetailList(String loginID, PageMakerVO pm) throws Exception;
	
	public BookDetailVO getBookDetail(Integer bk_detail_num, String loginID) throws Exception;
	
	public List<BookDetailVO> getBookDetailAll(String loginID) throws Exception;
	
	public Integer updateBookDetail(BookDetailVO detail) throws Exception;
	
	public Integer deleteBookDetail(Integer bk_detail_num, String loginID) throws Exception;

	public Integer getMonthBookDetailCnt(String loginID, int year, int month) throws Exception;

	public List<BookDetailVO> getMonthBookDetailList(int year, int month, String loginID, PageMakerVO pm) throws Exception;
}
