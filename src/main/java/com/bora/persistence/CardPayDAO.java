package com.bora.persistence;

import java.util.List;

import com.bora.domain.CardPayVO;
import com.bora.domain.report.BookDetailVO;

public interface CardPayDAO {

	//카드 내역 가져오기
	List<CardPayVO> getBookCardList() throws Exception;

	//TOP3 매장명 리포트
	List<BookDetailVO> getTop3Store(Integer year, Integer month, String loginID) throws Exception;

	//TOP3 날짜 리포트
	List<BookDetailVO> getTop3Date(Integer year, Integer month, String loginID) throws Exception;
	
	// 소비 카테고리 1위에 따라서 태그 표시
	List<BookDetailVO> getConsumeTag(Integer year, Integer month, String loginID) throws Exception;
	
}
