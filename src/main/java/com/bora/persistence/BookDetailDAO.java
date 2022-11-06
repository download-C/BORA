package com.bora.persistence;

import java.util.List;

import com.bora.domain.report.BookAllListVO;
import com.bora.domain.report.BookDetailVO;
import com.bora.domain.report.BookLastMonListVO;
import com.bora.domain.report.BookThisMonListVO;

public interface BookDetailDAO {
	
	public Integer writeBookDetail(BookDetailVO detail) throws Exception;
	
	public List<BookDetailVO> getBookDetailList(String loginID) throws Exception;
	
	public BookDetailVO getBookDetailContent(Integer bk_detail_num, String loginID) throws Exception;
	
	public List<BookDetailVO> getBookDetailAll() throws Exception;
	
	public Integer updateBookDetail(BookDetailVO detail) throws Exception;
	
	public Integer deleteBookDetail(Integer bk_detail_num) throws Exception;
	
	public List<BookLastMonListVO> getBookLastMonList(String loginID) throws Exception;
	
	public List<BookThisMonListVO> getBookThisMonList(String loginID) throws Exception;
	
	public List<BookAllListVO> getBookAllList(String loginID) throws Exception;

	
}
