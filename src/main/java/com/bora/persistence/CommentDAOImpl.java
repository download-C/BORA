package com.bora.persistence;

import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.bora.domain.CommentVO;

@Repository
public class CommentDAOImpl implements CommentDAO {
	// 멤버변수 ====================================
	private static final Logger log = LoggerFactory.getLogger(CommentDAOImpl.class);
	
	@Autowired
	private SqlSession sqlSession;
	
	private static final String NAMESPACE = "com.bora.mapper.CommentMapper";
	// 멤버변수 끝 ====================================
	
	
	
	
	
	// 1. 댓글쓰기
	@Override
	public void insertCmt(CommentVO vo) throws Exception {
		log.info("(♥♥♥♥♥ 1.insertCmt) 호출됨");
		
		int result = sqlSession.insert(NAMESPACE+".insertCmt", vo);
		
		if (result > 0) {
			log.info("(♥♥♥♥♥ 1.insertCmt)(●'◡'●) 댓글쓰기 DB 작업 완 -> 서비스로 ㄱㄱ");
		}
	}
	// 1. 댓글쓰기 끝




	// 1-1. cno 구하기
	@Override
	public Integer countCno() throws Exception {
		log.info("(♥♥♥♥♥ 1.countCno) 호출됨");
		
		// cno 채우기
		int cno = 0;
		
		cno = sqlSession.selectOne(NAMESPACE+".countCno");
		
		if( cno <= 0  ) {
			cno = 1;
		} else {
			cno = cno + 1;
		}
		
		log.info("(♥♥♥♥♥ 1.countCno) cno: " + cno);
		return cno;
	}
	// 1-1. cno 구하기 끝
	
	
	
} // class CommentDAOImpl