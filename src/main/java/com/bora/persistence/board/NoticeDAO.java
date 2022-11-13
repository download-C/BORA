package com.bora.persistence.board;

import java.util.List;

import com.bora.domain.board.NoticeVO;
import com.bora.domain.board.PageMakerVO;
import com.bora.domain.board.PageVO;

public interface NoticeDAO {
	public void writeNotice(NoticeVO vo) throws Exception;
	
	public Integer updateNotice(NoticeVO vo) throws Exception;
	
	public List<NoticeVO> getNoticeList(PageMakerVO pm) throws Exception;
	
	public List<NoticeVO> getNoticeListPage(PageMakerVO pm) throws Exception;
	
	public NoticeVO getNotice(Integer nno) throws Exception;
	
	public void updateNoticeReadcount(Integer nno) throws Exception;
	
	public Integer deleteNotice(Integer nno) throws Exception;

	public Integer getTotalCnt() throws Exception;

	public List<NoticeVO> getNoticeListMain() throws Exception;
	
}
