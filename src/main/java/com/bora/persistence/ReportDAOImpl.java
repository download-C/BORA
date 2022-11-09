package com.bora.persistence;


import java.util.List;


import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.bora.domain.report.BookDetailVO;

@Repository
public class ReportDAOImpl implements ReportDAO{
	

	private static final Logger log = LoggerFactory.getLogger(ReportDAOImpl.class);
	
	String loginID;
	
	@Autowired
	private SqlSession session;
	
	private static final String NAMESPACE = "com.bora.mapper.ReportMapper";



	@Override
	public List<BookDetailVO> cateSum(String loginID) throws Exception {
		
		log.info(" φ(._.) cateSum(String loginID)호출");
		
log.info(session.selectList(NAMESPACE+".cateSum", loginID)+"");
		return session.selectList(NAMESPACE+".cateSum", loginID);
	}

	
}
