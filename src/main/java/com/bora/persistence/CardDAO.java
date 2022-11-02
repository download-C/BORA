package com.bora.persistence;

import java.util.List;

import com.bora.domain.openbank.card.CardVO;

public interface CardDAO {
	
	public CardVO getCard(Integer card_num) throws Exception;
	
	public List<CardVO> getCardList(String id) throws Exception;

}
