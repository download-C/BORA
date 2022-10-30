package com.bora.persistence;

import com.bora.domain.CommentVO;

public interface CommentDAO {
	// 1. 댓글 쓰기
	public void insertCmt(CommentVO vo) throws Exception;
	
	// 1-1. cno 구하기
	public Integer countCno() throws Exception;

} // interface CommentDAO
