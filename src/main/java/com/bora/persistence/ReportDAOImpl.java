package com.bora.persistence;

import java.util.List;

import javax.xml.stream.events.Namespace;

import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.bora.domain.openbank.card.prePaid.PrePaidTranVO;

@Repository
public class ReportDAOImpl implements ReportDAO{
	

	private static final Logger log = LoggerFactory.getLogger(ReportDAOImpl.class);
	
	
	
	@Autowired
	private SqlSession sqlSession;
	
	private static final String Namespace = "com.bora.mapper.ReportMapper";

	@Override
	public List<PrePaidTranVO> categoryListAll() throws Exception {
		
		List<PrePaidTranVO> categoryList = sqlSession.selectList(Namespace+".listAll");
		
		log.info(categoryList.size()+"");
		
		return categoryList;
	}

	
}
