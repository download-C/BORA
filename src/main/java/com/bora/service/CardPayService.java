package com.bora.service;

import java.util.List;

import com.bora.domain.CardPayVO;
import com.bora.domain.board.PageVO;
import com.bora.domain.report.BookDetailVO;

public interface CardPayService {

	// 카드 내역 불러오기
	public List<CardPayVO> bookCardList() throws Exception;

	// TOP3 매장명 리포트
	public List<BookDetailVO> Top3Store(Integer year, Integer month, String loginID) throws Exception;
	
	// TOP3 날짜 리포트
	public List<BookDetailVO> Top3Date(Integer year, Integer month, String loginID) throws Exception;

	// 소비 카테고리 1위에 따라서 태그 표시
	public List<BookDetailVO> ConsumeTag(Integer year, Integer month, String loginID) throws Exception;

}
