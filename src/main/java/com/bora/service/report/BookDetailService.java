package com.bora.service.report;

import java.util.List;

import com.bora.domain.board.PageMakerVO;
import com.bora.domain.report.BookDetailVO;
import com.bora.domain.report.BookVO;

public interface BookDetailService {
	
	public Integer writeBookDetail(BookDetailVO detail) throws Exception;
	
	public Integer getBookDetailMaxNum() throws Exception;

	public List<BookDetailVO> getBookDetailList(String loginID, PageMakerVO pm) throws Exception;
	
	public BookDetailVO getBookDetailContent(Integer bk_detail_num, String loginID) throws Exception;
	
	public List<BookDetailVO> getBookDetailAll() throws Exception;
	
	public Integer updateBookDetail(BookDetailVO detail) throws Exception;
	
	public Integer deleteBookDetail(Integer bk_detail_num, String loginID) throws Exception;

	public Integer getBookDetailCnt(String loginID) throws Exception;

		

}
