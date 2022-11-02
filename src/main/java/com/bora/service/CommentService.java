package com.bora.service;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.bora.domain.board.CommentVO;
import com.bora.domain.board.PageVO;

public interface CommentService {
	// 1. 댓글 쓰기
	public Integer insertCmt(CommentVO vo) throws Exception;
	
	// 2. 특정 댓글 읽기
	public CommentVO getCmtOne(Integer cno) throws Exception;
	
	// 3. 댓글 삭제
	public Integer deleteCmt(Integer cno) throws Exception;
	
	// 4. 댓글 수정
	public Integer updateCmt(CommentVO vo) throws Exception;
	
	// 5. 댓글 목록 +페이징 처리
	public List<CommentVO> getCmtList(PageVO pageVO, Integer bno) throws Exception;	
} 
