package com.bora.persistence;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.bora.domain.board.CommentVO;
import com.bora.domain.board.PageVO;

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
	public Integer insertCmt(CommentVO vo) throws Exception {
		log.info("(♥♥♥♥♥ 1.insertCmt) 호출됨");
		
		int inCount = sqlSession.insert(NAMESPACE+".insertCmt", vo);
		
		if (inCount > 0) {
			log.info("(♥♥♥♥♥ 1.insertCmt)(●'◡'●) 댓글쓰기 DB 작업 완 -> 서비스로 ㄱㄱ");
			return inCount;
			
		} else return null;
	}
	// 1. 댓글쓰기 끝


	// 1-1. cno 구하기
	@Override
	public Integer countCno() throws Exception {
		log.info("(♥♥♥♥♥ 1-1.countCno) 호출됨");
		
		// cno 채우기
		int cno = 0;
		
		cno = sqlSession.selectOne(NAMESPACE+".countCno");
		
		if( cno <= 0  ) {
			cno = 1;
		} else {
			cno = cno + 1;
		}
		
		log.info("(♥♥♥♥♥ 1-1.countCno) cno: " + cno);
		return cno;
	}
	// 1-1. cno 구하기 끝
	
	
	
	// 2. 특정 댓글 읽기
	@Override
	public CommentVO getCmtOne(Integer cno) throws Exception {
		log.info("(♥♥♥♥♥ 2.getCmtOne) 호출됨");
		return sqlSession.selectOne(NAMESPACE+".getCmtOne", cno);
	}
	// 2. 특정 댓글 읽기 끝
	
	
	
	// 3. 댓글 삭제
	@Override
	public Integer deleteCmt(Integer cno) throws Exception {
		log.info("(♥♥♥♥♥ 3.deleteCmt) 호출됨");
		
		int delCount = sqlSession.delete(NAMESPACE+".deleteCmt", cno);
		
		if(delCount > 0) {
			log.info("(♥♥♥♥♥ 3.deleteCmt)(●'◡'●) 댓글 삭제 DB 작업 완 -> 서비스로 ㄱㄱ");
			return delCount;
			
		} else return null;
	}
	// 3. 댓글 삭제 끝
	
	
	
	// 4. 댓글 수정
	@Override
	public Integer updateCmt(CommentVO vo) throws Exception {
		log.info("(♥♥♥♥♥ 4.updateCmt) 호출됨");
		
		int upCount = sqlSession.delete(NAMESPACE+".updateCmt", vo);
		
		if(upCount > 0) {
			log.info("(♥♥♥♥♥ 4.updateCmt)(●'◡'●) 댓글 수정 DB 작업 완 -> 서비스로 ㄱㄱ");
			return upCount;
			
		} else return null;
	}
	// 4. 댓글 수정 끝
	
	
	
	// 5. 댓글 목록 +페이징 처리
	@Override
	public List<CommentVO> getCmtList(PageVO pageVO, Integer bno) throws Exception {
		log.info("(♥♥♥♥♥ 5.getCmtList) 호출됨");
		
		List<CommentVO> cmtList = sqlSession.selectList(NAMESPACE+".getCmtList", bno);
		log.info("(♥♥♥♥♥ 5.getCmtList) " + bno +"번 글의~~ 댓글 수: " + cmtList.size());
		
		log.info("(♥♥♥♥♥ 5.getCmtList)(●'◡'●) 리턴값 cmtList 들고 서비스로 ㄱㄱ");
		return cmtList;
	}
	// 5. 댓글 목록 +페이징 처리 끝
	
	
	
	// 6. bno번 글의 총 댓글 개수 구하기
	@Override
	public Integer getTotalCount(Integer bno) throws Exception {
		log.info("(♥♥♥♥♥ 5.getTotalCount) 호출됨  / 전달받은 bno: " + bno);
		
		return sqlSession.selectOne(NAMESPACE+".getTotalCount", bno);
	}
	// 6. bno번 글의 총 댓글 개수 구하기 끝
	
	
	
} // class CommentDAOImpl