package com.bora.service.report;

import com.bora.domain.report.BookDetailVO;
import com.bora.domain.report.BookVO;

public interface BookService {
	
	public Integer writeBook(BookVO vo, BookDetailVO detail) throws Exception;

}
