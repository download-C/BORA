package com.bora.persistence;

import java.util.List;

import com.bora.domain.report.BookDetailVO;

public interface ReportDAO {

	// 카테고리 내역

	public List<BookDetailVO> cateSum(Integer year, Integer month,String loginID) throws Exception;

	 //전월 대비
	public List<BookDetailVO> getConsumeMinus(Integer year, Integer month, String loginID) throws Exception;

	
	//TOP3 매장명 리포트
	public List<BookDetailVO> getTop3Store(Integer year, Integer month, String loginID) throws Exception;

	//TOP3 날짜 리포트
	public List<BookDetailVO> getTop3Date(Integer year, Integer month, String loginID) throws Exception;
	
	// 소비 카테고리 1위에 따라서 태그 표시
	public List<BookDetailVO> getConsumeTag(Integer year, Integer month, String loginID) throws Exception;
}
