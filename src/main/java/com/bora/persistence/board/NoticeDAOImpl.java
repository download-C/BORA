package com.bora.persistence.board;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.bora.domain.board.NoticeVO;
import com.bora.domain.board.PageMakerVO;
import com.bora.domain.board.PageVO;

@Repository
public class NoticeDAOImpl implements NoticeDAO{

	@Inject
	private SqlSession session;
	private final static String NAMESPACE = "com.bora.mapper.NoticeMapper";
	
	private static final Logger log = LoggerFactory.getLogger(NoticeDAOImpl.class);
	
	@Override
	public void writeNotice(NoticeVO vo) throws Exception {
		log.info("♡♡♡♡♡♡♡♡♡♡♡♡writeNotice(vo) 호출");
		session.insert(NAMESPACE+".writeNotice", vo);
	}
	@Override
	public Integer updateNotice(NoticeVO vo) throws Exception {
		log.info("♡♡♡♡♡♡♡♡♡♡♡♡updateNotice(nno) 호출");
		return session.update(NAMESPACE+".updateNotice", vo);
	}
	@Override
	public List<NoticeVO> getNoticeListAll(PageMakerVO pm) throws Exception {
		log.info("♡♡♡♡♡♡♡♡♡♡♡♡getNoticeList(vo) 호출");
		return session.selectList(NAMESPACE+".getNoticeListAll");
	}
	@Override
	public List<NoticeVO> getNoticeListPage(PageVO vo) throws Exception {
		log.info("♡♡♡♡♡♡♡♡♡♡♡♡getNoticeList(vo) 호출");
		log.info("Vo: "+vo);
		return session.selectList(NAMESPACE+".getNoticeListPage", vo);
	}
	@Override
	public NoticeVO getNotice(Integer nno) throws Exception {
		log.info("♡♡♡♡♡♡♡♡♡♡♡♡getNoticeContent(nno) 호출");
		return session.selectOne(NAMESPACE+".getNotice", nno);
	}
	@Override
	public void updateNoticeReadcount(Integer nno) throws Exception {
		log.info("♡♡♡♡♡♡♡♡♡♡♡♡updateNoticeReadcount(nno) 호출");
		session.update(NAMESPACE+".updateNoticeReadcount", nno);
	}
	@Override
	public Integer deleteNotice(Integer nno) throws Exception {
		log.info("♡♡♡♡♡♡♡♡♡♡♡♡deleteNotice(nno) 호출");
		return session.delete(NAMESPACE+".deleteNotice", nno);
	}
	@Override
	public Integer getTotalCnt() throws Exception {
		log.info("♡♡♡♡♡♡♡♡♡♡♡♡deleteNotice(nno) 호출");
		return session.selectOne(NAMESPACE+".getTotalCnt");
	}
	
}
