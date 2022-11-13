package com.bora.service.report;

import java.util.List;

import com.bora.domain.report.BookDetailVO;

public interface ConsumeAllListService {
	
	// 저번 달 소비 리스트
	public List<BookDetailVO> getConsumeLastMonList(String loginID) throws Exception;
	
	// 이번 달 소비 리스트
	public List<BookDetailVO> getConsumeThisMonList(String loginID) throws Exception;
	
	// 이번 소비 리스트 비교 메서드
	public List<BookDetailVO> getConsumeAllList(String loginID) throws Exception;

	
}
