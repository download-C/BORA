package com.bora.persistence;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.bora.domain.openbank.card.CardVO;

@Repository
public class CardDAOImpl implements CardDAO{
	
	@Inject
	SqlSession session;
	
	private static final String NAMESPACE = "com.bora.mapper.CardMapper";
	
	private static final Logger log = LoggerFactory.getLogger(CardDAOImpl.class);
	
	@Override
	public CardVO getCard(Integer card_num) throws Exception {
		log.info("getCard(card_num) 호출");
		CardVO vo = session.selectOne(NAMESPACE+".getCard", card_num);
		return vo;
	}



	@Override
	public List<CardVO> getCardList(String id) throws Exception {
		List<CardVO> cardList = new ArrayList<CardVO>();
		cardList = session.selectList(NAMESPACE+".getCardList", id);
		return cardList;
	}	
}
