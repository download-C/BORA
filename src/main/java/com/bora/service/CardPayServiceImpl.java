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
		List<CardPayVO> bookCardList = dao.getBookCardList();

		return bookCardList;
	}

	@Override
	public List<BookDetailVO> Top3Store(Integer year, Integer month, String loginID) throws Exception {
		List<BookDetailVO> Top3Store = dao.getTop3Store(year, month, loginID);

		return Top3Store;
	}

	@Override
	public List<BookDetailVO> Top3Date(Integer year, Integer month, String loginID) throws Exception {
		List<BookDetailVO> Top3Date = dao.getTop3Date(year, month, loginID);
		
		return Top3Date;
	}

	@Override
	public List<BookDetailVO> ConsumeTag(Integer year, Integer month, String loginID) throws Exception {
		List<BookDetailVO> ConsumeTag = dao.getConsumeTag(year, month,loginID);
		
		return ConsumeTag;
	}
}
