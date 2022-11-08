package com.bora.service.report;

import java.util.List;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.bora.domain.report.ConsumeAllListVO;
import com.bora.domain.report.ConsumeLastMonListVO;
import com.bora.domain.report.ConsumePageVO;
import com.bora.domain.report.ConsumeThisMonListVO;
import com.bora.persistence.ConsumeDAO;

@Service
public class ConsumeAllListServiceImpl implements ConsumeAllListService{
	
	@Inject
	ConsumeDAO dao;
	
	private static final Logger log = LoggerFactory.getLogger(ConsumeAllListService.class);

	public List<ConsumeLastMonListVO> getConsumeLastMonList(ConsumePageVO vo) throws Exception {
		log.info("♡♡♡♡♡♡♡♡♡♡getConsumeLastList(loginID) 호출");
		// startRow, endRow 구하기
		int startRow = (vo.getConsumeCurrentPage()-1)*vo.getConsumePageSize()+1;
		int endRow = vo.getConsumeCurrentPage() * vo.getConsumePageSize();
		vo.setConsumeStartRow(startRow);
		vo.setConsumeEndRow(endRow);
		
		return dao.getConsumeLastMonList(vo);
	}
	
	public List<ConsumeThisMonListVO> getConsumeThisMonList(ConsumePageVO vo) throws Exception {
		log.info("♡♡♡♡♡♡♡♡♡♡getConsumeThisList(loginID) 호출");
		// startRow, endRow 구하기
		int startRow = (vo.getConsumeCurrentPage()-1)*vo.getConsumePageSize()+1;
		int endRow = vo.getConsumeCurrentPage() * vo.getConsumePageSize();
		vo.setConsumeStartRow(startRow);
		vo.setConsumeEndRow(endRow);
		
		return dao.getConsumeThisMonList(vo);
	}

	@Override
	public List<ConsumeAllListVO> getConsumeAllList(ConsumePageVO vo) throws Exception {
		log.info("♡♡♡♡♡♡♡♡♡♡getConsumeAllList(loginID) 호출");
		// startRow, endRow 구하기
		int startRow = (vo.getConsumeCurrentPage()-1)*vo.getConsumePageSize()+1;
		int endRow = vo.getConsumeCurrentPage() * vo.getConsumePageSize();
		vo.setConsumeStartRow(startRow);
		vo.setConsumeEndRow(endRow);
		
		return dao.getConsumeAllList(vo);
	}
	
	@Override
	public int getConsumeCount(){

		return dao.getConsumeCount();
	}

	
}
