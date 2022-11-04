package com.bora.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bora.domain.CardPayVO;
import com.bora.persistence.CardPayDAO;

@Service
public class CardPayServiceImpl implements CardPayService {

	@Autowired
	private CardPayDAO dao;

	@Override
	public List<CardPayVO> bookCardList() throws Exception {
		List<CardPayVO> bookCardList = dao.GetBookCardList();

		return bookCardList;
	}

}
