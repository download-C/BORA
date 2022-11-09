package com.bora.service.report;

import java.util.List;


import com.bora.domain.report.BookDetailVO;
public interface ReportService {

	
	// 년월 카테고리별 내역
	public List<BookDetailVO> cateSum(String loginID) throws Exception;


}
