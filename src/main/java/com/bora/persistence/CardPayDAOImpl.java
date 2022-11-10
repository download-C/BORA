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

	/* ---------- 소비 TOP3 매장명 ver ---------------- */

	@Override
	public List<BookDetailVO> getTop3Store(Integer year, Integer month, String loginID) throws Exception {
		System.out.println("(ᐡ-ܫ•ᐡ)=͟͟͞♡=͟͟͞♡=͟͟͞♡=͟͟͞♡       getTop3Store() 호출 : DAO");
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("loginID", loginID);
		map.put("year", year);
		map.put("month", month);
	
		return sqlSession.selectList(NAMESPACE + ".top3Store", map);

	}
	
	/* ---------- 소비 TOP3 날짜 ver ---------------- */
	
	@Override
	public List<BookDetailVO> getTop3Date(Integer year, Integer month, String loginID) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("loginID", loginID);
		map.put("year", year);
		map.put("month", month);
	
		return sqlSession.selectList(NAMESPACE + ".top3date", map);
	}

	/* ---------- 소비 카테고리 1위에 따라 태그 표시 ---------------- */
	@Override
	public List<BookDetailVO> getConsumeTag(Integer year, Integer month, String loginID) throws Exception {
		System.out.println("(ᐡ-ܫ•ᐡ)=͟͟͞♡=͟͟͞♡=͟͟͞♡=͟͟͞♡       getConsumeTag() 호출 : DAO");
		return sqlSession.selectList(NAMESPACE + ".consumeTag", loginID);
	}

}
