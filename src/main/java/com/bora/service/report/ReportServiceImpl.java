package com.bora.service.report;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bora.domain.openbank.card.prePaid.PrePaidTranVO;
import com.bora.persistence.ReportDAO;

@Service
public class ReportServiceImpl implements ReportService{

	private static final Logger log 
	     = LoggerFactory.getLogger(ReportServiceImpl.class);
	
	@Autowired
	private ReportDAO dao;
	
	
	//카테고리 내역 불러오기
	@Override
	public List<PrePaidTranVO> getCategoryList() throws Exception {
		 log.info("@@@ Service - getCategoryList()호출");
		
		
		List<PrePaidTranVO> getCategoryListALL = dao.categoryListAll();
		return getCategoryListALL;
	}
}
