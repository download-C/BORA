package com.bora.persistence;

import java.util.List;

import com.bora.domain.report.BookDetailVO;
public interface ConsumeDAO {
	
    public List<BookDetailVO> getConsumeLastMonList(String loginID) throws Exception;
	
	public List<BookDetailVO> getConsumeThisMonList(String loginID) throws Exception;
	
	public List<BookDetailVO> getConsumeAllList(String loginID) throws Exception;

}
