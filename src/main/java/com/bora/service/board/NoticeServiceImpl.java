package com.bora.service.board;

import java.util.List;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.bora.domain.board.NoticeVO;
import com.bora.domain.board.PageMakerVO;
import com.bora.domain.board.PageVO;
import com.bora.persistence.board.NoticeDAO;

@Service
public class NoticeServiceImpl implements NoticeService{
	@Inject
	NoticeDAO dao;

	private static final Logger log = LoggerFactory.getLogger(NoticeServiceImpl.class);

	@Override
	public void writeNotice(NoticeVO vo) throws Exception {
		log.info("♡♡♡♡♡♡♡♡♡♡♡ writeNotice(vo) 호출 ♡♡♡♡♡♡♡♡♡♡");
		dao.writeNotice(vo);
	}

	@Override
	public Integer updateNotice(NoticeVO vo) throws Exception {
		log.info("♡♡♡♡♡♡♡♡♡♡♡ writeNotice(vo) 호출 ♡♡♡♡♡♡♡♡♡♡");
		return dao.updateNotice(vo);
	}
	
	@Override
	public List<NoticeVO> getNoticeListPage(PageMakerVO pm) throws Exception {
		log.info("♡♡♡♡♡♡♡♡♡♡♡ getNoticeList(pagevo) 호출 ♡♡♡♡♡♡♡♡♡♡");
		return dao.getNoticeListPage(pm);
	}

	@Override
	public List<NoticeVO> getNoticeList(PageMakerVO pm) throws Exception {
		log.info("♡♡♡♡♡♡♡♡♡♡♡ getNoticeList(pagevo) 호출 ♡♡♡♡♡♡♡♡♡♡");
		return dao.getNoticeList(pm);
	}

	@Override
	public NoticeVO getNotice(Integer nno) throws Exception {
		log.info("♡♡♡♡♡♡♡♡♡♡♡ getNotice(nno) 호출 ♡♡♡♡♡♡♡♡♡♡");
		return dao.getNotice(nno);
	}

	@Override
	public void updateNoticeReadcount(Integer nno) throws Exception {
		log.info("♡♡♡♡♡♡♡♡♡♡♡ updateNoticeReadcount(nno) 호출 ♡♡♡♡♡♡♡♡♡♡");
		dao.updateNoticeReadcount(nno);
	}

	@Override
	public Integer deleteNotice(Integer nno) throws Exception {
		log.info("♡♡♡♡♡♡♡♡♡♡♡ deleteNotice(nno) 호출 ♡♡♡♡♡♡♡♡♡♡");
		return dao.deleteNotice(nno);
	}
	
	@Override
	public Integer getTotalCnt() throws Exception {
		log.info("♡♡♡♡♡♡♡♡♡♡♡ getTotalCnt(nno) 호출 ♡♡♡♡♡♡♡♡♡♡");		
		return dao.getTotalCnt();
	}

	@Override
	public List<NoticeVO> getNoticeListMain() throws Exception {
		log.info("getNoticeListMain() 호출");
		return dao.getNoticeListMain();
	}
	
}
