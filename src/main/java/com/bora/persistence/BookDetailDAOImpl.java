package com.bora.persistence;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.bora.domain.report.BookDetailAllListVO;
import com.bora.domain.report.BookDetailVO;
import com.bora.domain.report.BookLastMonListVO;
import com.bora.domain.report.BookThisMonListVO;

@Repository
public class BookDetailDAOImpl implements BookDetailDAO{
	@Inject
	SqlSession session;
	
	private final static String NAMESPACE = "com.bora.mapper.BookDetailMapper";
	
	private static final Logger log = LoggerFactory.getLogger(BookDetailDAOImpl.class);
	
	@Override
	public Integer writeBookDetail(BookDetailVO detail) throws Exception {
		log.info("♡♡♡♡♡♡♡♡♡♡writeBookDetail(detail) 호출");
		return session.insert(NAMESPACE+".writeBookDetail", detail);
		
	}

	@Override
	public List<BookDetailVO> getBookDetailList(String loginID) throws Exception {
		log.info("♡♡♡♡♡♡♡♡♡♡getBookDetailList(loginID) 호출");
		return session.selectList(NAMESPACE+".getBookDetailList", loginID);
	}
	
	@Override
	public BookDetailVO getBookDetailContent(Integer bk_detail_num, String loginID) throws Exception {
		log.info("♡♡♡♡♡♡♡♡♡♡getBookDetailContent(bk_detail_num, loginID) 호출");
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("loginID",loginID);
		map.put("bk_detail_num",bk_detail_num);
		
		return session.selectOne(NAMESPACE+".getBookDetailContent", map);
	}
	
	public List<BookDetailVO> getBookDetailAll() {
		log.info("♡♡♡♡♡♡♡♡♡♡ getBookDetailAll() 호출");
		List<BookDetailVO> detailList = new ArrayList<BookDetailVO>();
		detailList = session.selectList(NAMESPACE+".getBookDetailAll");
		log.info("글 개수: "+detailList.size());
		return detailList;
	}

	@Override
	public Integer updateBookDetail(BookDetailVO detail) throws Exception {
		log.info("♡♡♡♡♡♡♡♡♡♡ updateBookDetail(detail) 호출");
		return session.update(NAMESPACE+".updateBookDetail", detail);
	}

	@Override
	public Integer deleteBookDetail(Integer bk_detail_num) throws Exception {
		log.info("♡♡♡♡♡♡♡♡♡♡ deleteBookDetail(bk_detail_num) 호출");
		return session.delete(NAMESPACE+".deleteBookDetail", bk_detail_num);
	}
	
	@Override
	public List<BookLastMonListVO> getBookLastMonList(String loginID) throws Exception {
		log.info("♡♡♡♡♡♡♡♡♡♡getBookLastMonList(loginID) 호출");
		return session.selectList(NAMESPACE+".getBookLastMonList", loginID);
	}
	
	@Override
	public List<BookThisMonListVO> getBookThisMonList(String loginID) throws Exception {
		log.info("♡♡♡♡♡♡♡♡♡♡getBookThisMonList(loginID) 호출");
		return session.selectList(NAMESPACE+".getBookThisMonList", loginID);
	}
	
	@Override
	public List<BookDetailAllListVO> getBookDetailAllList(String loginID) throws Exception {
		log.info("♡♡♡♡♡♡♡♡♡♡getBookAllList(loginID) 호출");
		return session.selectList(NAMESPACE+".getBookAllList", loginID);
	}
	
	

}
