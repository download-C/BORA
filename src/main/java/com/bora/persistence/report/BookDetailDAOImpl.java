package com.bora.persistence.report;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.inject.Inject;
import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.bora.domain.board.PageMakerVO;
import com.bora.domain.report.BookDetailVO;
import com.bora.domain.report.BookVO;


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
	
	public Integer getBookDetailMaxNum() throws Exception {
		log.info("getBookDetailMaxNum() 호출 -> 방금 쓴 가계부 글 번호 가져오기");
		return session.selectOne(NAMESPACE+".getBookDetailMaxNum");
	}

	@Override
	public List<BookDetailVO> getBookDetailList(String loginID, PageMakerVO pm) throws Exception {
		log.info("♡♡♡♡♡♡♡♡♡♡getBookDetailList(loginID, pm) 호출");
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("loginID",loginID);
		map.put("pm", pm);
		log.info("pm: "+pm);
		return session.selectList(NAMESPACE+".getBookDetailList", map);
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
	public Integer deleteBookDetail(Integer bk_detail_num, String loginID) throws Exception {
		log.info("♡♡♡♡♡♡♡♡♡♡ deleteBookDetail(bk_detail_num) 호출");
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("bk_detail_num",bk_detail_num);
		map.put("id", loginID);
		return session.delete(NAMESPACE+".deleteBookDetail", map);
	}

	@Override
	public Integer getBookDetailCnt(String loginID) throws Exception {
		log.info("getBookDetailCnt(loginID) 호출");
		return session.selectOne(NAMESPACE+".getBookDetailCnt", loginID);
	}

}
