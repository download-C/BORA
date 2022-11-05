package com.bora.persistence;

import java.util.List;

import com.bora.domain.report.BookDetailVO;

public interface BookDetailDAO {
	
	public Integer writeBookDetail(BookDetailVO detail) throws Exception;
	
	public Integer getBookDetailMaxNum() throws Exception;
	
	public List<BookDetailVO> getBookDetailList(String loginID) throws Exception;
	
	public BookDetailVO getBookDetailContent(Integer bk_detail_num, String loginID) throws Exception;
	
	public List<BookDetailVO> getBookDetailAll() throws Exception;
	
	public Integer updateBookDetail(BookDetailVO detail) throws Exception;
	
	public Integer deleteBookDetail(Integer bk_detail_num) throws Exception;
}
