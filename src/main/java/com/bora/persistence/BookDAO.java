package com.bora.persistence;

import com.bora.domain.report.BookDetailVO;
import com.bora.domain.report.BookVO;

public interface BookDAO {
	
	public Integer writeBook(BookVO vo) throws Exception;

}
