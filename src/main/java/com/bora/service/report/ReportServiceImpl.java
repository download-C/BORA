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
	
	


	// 카테고리 내역
	@Override
	public List<BookDetailVO> cateSum(Integer year, Integer month, String loginID) throws Exception {
		 log.info(" φ(._.)  cateSum(String loginID)호출");
			return dao.cateSum(year, month, loginID);
	}
	
	
	//전월대비
	   @Override
	   public List<BookDetailVO> getConsumeMinus(Integer year, Integer month, String loginID) throws Exception {
	      List<BookDetailVO> getConsumeMinus = dao.getConsumeMinus(year, month, loginID);

	      return getConsumeMinus;
	   }

	   
	   //top3
	   @Override
		public List<BookDetailVO> Top3Store(Integer year, Integer month, String loginID) throws Exception {
			List<BookDetailVO> Top3Store = dao.getTop3Store(year, month, loginID);

			return Top3Store;
		}

		@Override
		public List<BookDetailVO> Top3Date(Integer year, Integer month, String loginID) throws Exception {
			List<BookDetailVO> Top3Date = dao.getTop3Date(year, month, loginID);
			
			return Top3Date;
		}

		
		//돼지
		@Override
		public List<BookDetailVO> ConsumeTag(Integer year, Integer month, String loginID) throws Exception {
			List<BookDetailVO> ConsumeTag = dao.getConsumeTag(year, month,loginID);
			
			return ConsumeTag;
		}
}
