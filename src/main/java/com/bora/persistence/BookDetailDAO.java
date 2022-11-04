package com.bora.persistence;

import com.bora.domain.report.BookDetailVO;

public interface BookDetailDAO {
	
	public void writeBookDetail(BookDetailVO detail) throws Exception;
	
	public BookDetailVO getBookDetail(BookDetailVO detail) throws Exception;
	
	public Integer updateBookDetail(BookDetailVO detail) throws Exception;
}
