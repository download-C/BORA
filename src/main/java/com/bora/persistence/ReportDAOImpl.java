package com.bora.persistence;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.bora.domain.ReportVO;
import com.bora.domain.openbank.card.CardDetailBillsVO;
import com.bora.domain.openbank.card.CardPayVO;
import com.bora.domain.openbank.tran.TranVO;

@Repository
public class ReportDAOImpl implements ReportDAO{

	@Autowired
	private SqlSession sqlSession;
	
	
	private static final String Namespace = "com.bora.mapper.ReportMapper";
	
//	@Override
//	public void insertReport(TranVO vo) {
//		int result = sqlSession.insert(Namespace+".create",vo);
//		if(result>0);
//	}

	@Override
	public void insertReport2(ReportVO reportVO) {
		sqlSession.insert(Namespace+".create2",reportVO);

	}



  

}