package com.bora.persistence;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.bora.domain.CardPayVO;
import com.bora.domain.report.BookDetailVO;

@Repository
public class CardPayDAOImpl implements CardPayDAO {

	@Autowired
	private SqlSession sqlSession;

	private static final String NAMESPACE = "com.bora.mapper.CardPayMapper";

	@Override
	public List<CardPayVO> getBookCardList() throws Exception {
		System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@");
		System.out.println(sqlSession.selectList(NAMESPACE + ".bookList"));
		return sqlSession.selectList(NAMESPACE + ".bookList");
	}

	
}
