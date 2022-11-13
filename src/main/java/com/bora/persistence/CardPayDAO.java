package com.bora.persistence;

import java.util.List;

import com.bora.domain.CardPayVO;
import com.bora.domain.report.BookDetailVO;

public interface CardPayDAO {

	//카드 내역 가져오기
	List<CardPayVO> getBookCardList() throws Exception;


	
}
