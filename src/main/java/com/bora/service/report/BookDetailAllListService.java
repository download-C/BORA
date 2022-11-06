package com.bora.service.report;

import java.util.List;

import com.bora.domain.report.BookDetailAllListVO;
import com.bora.domain.report.BookLastMonListVO;
import com.bora.domain.report.BookThisMonListVO;

public interface BookDetailAllListService {
	
	// 저번 달 소비 리스트
	public List<BookLastMonListVO> getBookLastMonList(String loginID) throws Exception;
	
	// 이번 달 소비 리스트
	public List<BookThisMonListVO> getBookThisMonList(String loginID) throws Exception;
	
	// 이번 소비 리스트 비교 메서드
	public List<BookDetailAllListVO> getBookDetailAllList(String loginID) throws Exception;
	
}
