package com.bora.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bora.domain.CardPayVO;
import com.bora.domain.report.BookDetailVO;
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

	@Override
	public List<BookDetailVO> Top3Store(String loginID) throws Exception {
		List<BookDetailVO> Top3Store = dao.GetTop3Store(loginID);

		return Top3Store;
	}

	@Override
	public List<BookDetailVO> Top3Date(String loginID) throws Exception {
		List<BookDetailVO> Top3Date = dao.GetTop3Date(loginID);
		
		return Top3Date;
	}

	@Override
	public List<BookDetailVO> ConsumeTag(String loginID) throws Exception {
		List<BookDetailVO> ConsumeTag = dao.GetConsumeTag(loginID);
		
		return ConsumeTag;
	}
}
