package com.bora.persistence;

import com.bora.domain.report.BookDetailVO;
import com.bora.domain.report.BookVO;

public interface BookDAO {
	
	public void writeBook(BookDetailVO detail, BookVO vo) throws Exception;
}
