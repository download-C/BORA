package com.bora.service.report;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.bora.domain.report.BookDetailVO;

import com.bora.persistence.ReportDAO;

@Service
public class ReportServiceImpl implements ReportService{

	private static final Logger log 
	     = LoggerFactory.getLogger(ReportServiceImpl.class);
	
	@Autowired
	private ReportDAO dao;
	
	


	// 년월별 카테고리 내역
	


	@Override
	public List<BookDetailVO> cateSum(String loginID) throws Exception {
		 log.info(" φ(._.)  cateSum(String loginID)호출");
			return dao.cateSum(loginID);
	}
}
