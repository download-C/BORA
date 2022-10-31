package com.bora.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bora.domain.CommentVO;
import com.bora.domain.PageVO;
import com.bora.persistence.CommentDAO;

@Service
public class CommentServiceImpl implements CommentService {
	// 멤벼변수 ================================
	private static final Logger log = LoggerFactory.getLogger(CommentServiceImpl.class);
	
	@Autowired
	private CommentDAO dao;
	// 멤벼변수 끝 ================================

	
	
	// 1. 댓글 쓰기
	@Override
	public Integer insertCmt(CommentVO vo) throws Exception {
		log.info("(●ˇ∀ˇ●)1.insertCmt(vo)  호출됨");
		// cno max값 구하는 메서드 불러와서 setCno 해주고 -> VO 완성시켜서 dao 호출
		vo.setCno(dao.countCno());
		log.info("(●ˇ∀ˇ●)1.insertCmt(vo)  dao 호출합니다  vo: " + vo);
		return dao.insertCmt(vo);
	}
	// 1. 댓글 쓰기 끝
	
	

	// 2. 특정 댓글 읽기
	@Override
	public CommentVO getCmtOne(Integer cno) throws Exception {
		log.info("(●ˇ∀ˇ●)2.getCmtOne(cno)  호출됨");
		log.info("(●ˇ∀ˇ●)2.getCmtOne(cno)  dao 호출합니다  cno: " + cno);
		return dao.getCmtOne(cno);
	}
	// 2. 특정 댓글 읽기 끝

	
	
	// 3. 댓글 삭제
	@Override
	public Integer deleteCmt(Integer cno) throws Exception {
		log.info("(●ˇ∀ˇ●)3.deleteCmt(cno)  호출됨");
		log.info("(●ˇ∀ˇ●)3.deleteCmt(cno)  dao 호출합니다  cno: " + cno);
		return dao.deleteCmt(cno);
	}
	// 3. 댓글 삭제 끝
	
	
	
	// 4. 댓글 수정
	@Override
	public Integer updateCmt(CommentVO vo) throws Exception {
		log.info("(●ˇ∀ˇ●)4.updateCmt(vo)  호출됨");
		log.info("(●ˇ∀ˇ●)4.updateCmt(vo)  dao 호출합니다  vo: " + vo);
		return dao.updateCmt(vo);
	}
	// 4. 댓글 수정 끝
	
	
	
	// 5. 댓글 목록 +페이징 처리
	@Override
	public List<CommentVO> getCmtList(PageVO pageVO, Integer bno) throws Exception {
		log.info("(●ˇ∀ˇ●)5.getCmtList(pageVO,bno)  호출됨");
		log.info("(●ˇ∀ˇ●)5.getCmtList(pageVO,bno)  pageVO: " + pageVO);
		log.info("(●ˇ∀ˇ●)5.getCmtList(pageVO,bno)  bno: " + bno);
		log.info("(●ˇ∀ˇ●)5.getCmtList(pageVO,bno)  dao 호출합니다");
		return dao.getCmtList(pageVO, bno);
	}
	// 5. 댓글 목록 +페이징 처리 끝
	
	
	
	
} // class CommentServiceImpl
