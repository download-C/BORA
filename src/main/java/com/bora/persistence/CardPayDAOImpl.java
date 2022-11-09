package com.bora.persistence;

import java.util.List;

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
	public List<CardPayVO> GetBookCardList() throws Exception {
		System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@");
		System.out.println(sqlSession.selectList(NAMESPACE + ".bookList"));
		return sqlSession.selectList(NAMESPACE + ".bookList");
	}

	/* ---------- 소비 TOP3 매장명 ver ---------------- */

	@Override
	public List<BookDetailVO> GetTop3Store(String loginID) throws Exception {
		System.out.println("(ᐡ-ܫ•ᐡ)=͟͟͞♡=͟͟͞♡=͟͟͞♡=͟͟͞♡       GetTop3Store() 호출 : DAO");
		return sqlSession.selectList(NAMESPACE + ".top3Store", loginID);

	}
	
	/* ---------- 소비 TOP3 날짜 ver ---------------- */
	
	@Override
	public List<BookDetailVO> GetTop3Date(String loginID) {
		System.out.println("(ᐡ-ܫ•ᐡ)=͟͟͞♡=͟͟͞♡=͟͟͞♡=͟͟͞♡       GetTop3Date() 호출 : DAO");
		return sqlSession.selectList(NAMESPACE + ".top3date", loginID);
	}

	/* ---------- 소비 카테고리 1위에 따라 태그 표시 ---------------- */
	@Override
	public List<BookDetailVO> GetConsumeTag(String loginID) throws Exception {
		System.out.println("(ᐡ-ܫ•ᐡ)=͟͟͞♡=͟͟͞♡=͟͟͞♡=͟͟͞♡       GetConsumeTag() 호출 : DAO");
		return sqlSession.selectList(NAMESPACE + ".consumeTag", loginID);
	}

}
