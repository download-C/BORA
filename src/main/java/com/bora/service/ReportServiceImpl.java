package com.bora.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bora.domain.CardPayVO;
import com.bora.domain.openbank.card.bill.CardDetailBillsVO;
import com.bora.domain.openbank.tran.TranVO;
import com.bora.domain.report.ReportVO;
import com.bora.persistence.ReportDAO;

@Service
public class ReportServiceImpl implements ReportService{
	
	@Autowired
	private ReportDAO dao;

//	@Override
//	public void reportWrite(TranVO vo) throws Exception {
//		dao.insertReport(vo);
//	}

	@Override
	public void reportWrite2(ReportVO revo) throws Exception {
		dao.insertReport2(revo);
		
	}




}