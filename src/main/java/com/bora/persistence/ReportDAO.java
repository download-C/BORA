package com.bora.persistence;

import java.util.List;

import com.bora.domain.report.BookDetailVO;

public interface ReportDAO {

	//년월별 카테고리 내역

	public List<BookDetailVO> cateSum(String loginID) throws Exception;


}
