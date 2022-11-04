package com.bora.service;

import java.util.List;

import com.bora.domain.CardPayVO;
import com.bora.domain.board.PageVO;

public interface CardPayService {

	// 카드 내역 불러오기
	public List<CardPayVO> bookCardList() throws Exception;


}
