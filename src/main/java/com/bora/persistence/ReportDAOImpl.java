package com.bora.persistence;


import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.bora.domain.report.BookDetailVO;

@Repository
public class ReportDAOImpl implements ReportDAO{
	

	private static final Logger log = LoggerFactory.getLogger(ReportDAOImpl.class);
	
	String loginID;
	
	@Autowired
	private SqlSession session;
	
	private static final String NAMESPACE = "com.bora.mapper.ReportMapper";


	/* 카테고리 내역 */
	@Override
	public List<BookDetailVO> cateSum(Integer year, Integer month, String loginID) throws Exception {
		Map<String, Object> map = new HashMap<String, Object>();
		log.info(" φ(._.) cateSum(String loginID)호출");
		
		map.put("loginID", loginID);
		map.put("year", year);
		map.put("month", month);
	
		
		return session.selectList(NAMESPACE+".cateSum", map);
	}
	
	   /*  전월 대비 차액, % 표시  */
	   @Override
	   public List<BookDetailVO> getConsumeMinus(Integer year, Integer month, String loginID) throws Exception{
	      System.out.println("(ᐡ-ܫ•ᐡ)=͟͟͞♡=͟͟͞♡=͟͟͞♡=͟͟͞♡       getConsumeMinus() 호출 : DAO");
	      Map<String, Object> map = new HashMap<String, Object>();
	      map.put("loginID", loginID);
	      map.put("year", year);
	      map.put("month", month);
	      return session.selectList(NAMESPACE + ".getConsumeMinus", map);
	   }
	
	   /* ---------- 소비 TOP3 매장명 ver ---------------- */

		@Override
		public List<BookDetailVO> getTop3Store(Integer year, Integer month, String loginID) throws Exception {
			System.out.println("(ᐡ-ܫ•ᐡ)=͟͟͞♡=͟͟͞♡=͟͟͞♡=͟͟͞♡       getTop3Store() 호출 : DAO");
			Map<String, Object> map = new HashMap<String, Object>();
			map.put("loginID", loginID);
			map.put("year", year);
			map.put("month", month);
		
			return session.selectList(NAMESPACE + ".top3Store", map);

		}
		
		/* ---------- 소비 TOP3 날짜 ver ---------------- */
		
		@Override
		public List<BookDetailVO> getTop3Date(Integer year, Integer month, String loginID) {
			Map<String, Object> map = new HashMap<String, Object>();
			map.put("loginID", loginID);
			map.put("year", year);
			map.put("month", month);
		
			return session.selectList(NAMESPACE + ".top3date", map);
		}

		   /* ---------- 소비 카테고리 1위에 따라 태그 표시 ---------------- */
		   @Override
		   public List<BookDetailVO> getConsumeTag(Integer year, Integer month, String loginID) throws Exception {
		      System.out.println("(ᐡ-ܫ•ᐡ)=͟͟͞♡=͟͟͞♡=͟͟͞♡=͟͟͞♡       getConsumeTag() 호출 : DAO");
		      Map<String, Object> map = new HashMap<String, Object>();
		      map.put("loginID", loginID);
		      map.put("year", year);
		      map.put("month", month);
		      return session.selectList(NAMESPACE + ".consumeTag", map);
		   }

	
	
	
}
