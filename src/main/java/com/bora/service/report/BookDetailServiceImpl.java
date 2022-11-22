package com.bora.service.report;

import java.util.List;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.bora.domain.board.PageMakerVO;
import com.bora.domain.report.BookDetailVO;
import com.bora.domain.report.BookVO;
import com.bora.persistence.report.BookDetailDAO;

@Service
public class BookDetailServiceImpl implements BookDetailService{
	
	@Inject
	BookDetailDAO dao;
	
	private static final Logger log = LoggerFactory.getLogger(BookDetailServiceImpl.class);

	@Override
	public Integer writeBookDetail(BookDetailVO detail) throws Exception {
		log.info("♡♡♡♡♡♡♡♡♡♡writeBookDetail(detail) 호출");
		return dao.writeBookDetail(detail);
	}
	
	public Integer getBookDetailMaxNum() throws Exception {
		log.info("getBookDetailMaxNum() 호출 -> 방금 쓴 가계부 글 번호 가져오기");
		return dao.getBookDetailMaxNum();
	}

	@Override
	public List<BookDetailVO> getBookDetailList(String loginID, PageMakerVO pm) throws Exception {
		log.info("♡♡♡♡♡♡♡♡♡♡getBookDetailList(loginID, pm) 호출");
		return dao.getBookDetailList(loginID, pm);
	}

	@Override
	public BookDetailVO getBookDetail(Integer bk_detail_num, String loginID) throws Exception {
		log.info("♡♡♡♡♡♡♡♡♡♡getBookDetail(bk_detail_num, loginID) 호출");
		return dao.getBookDetail(bk_detail_num, loginID);
	}

	@Override
	public List<BookDetailVO> getBookDetailAll(String loginID) throws Exception {
		log.info("♡♡♡♡♡♡♡♡♡♡getBookDetailAll(loginID) 호출");
		return dao.getBookDetailAll(loginID);
	}

	@Override
	public Integer updateBookDetail(BookDetailVO detail) throws Exception {
		log.info("updateBookDetail(detail) 호출");
		return dao.updateBookDetail(detail);
	}

	@Override
	public Integer deleteBookDetail(Integer bk_detail_num, String loginID) throws Exception {
		log.info("deleteBookDetail(bk_detail_numk, loginID) 호출");
		return dao.deleteBookDetail(bk_detail_num, loginID);
	}

	@Override
	public Integer getMonthBookDetailCnt(String loginID, int year, int month) throws Exception {
		log.info("getMonthBookDetailCnt(loginID, year, month) 호출");
		return dao.getMonthBookDetailCnt(loginID, year, month);
	}

	@Override
	public List<BookDetailVO> getMonthBookDetailList(int year, int month, String loginID, PageMakerVO pm) throws Exception {
		log.info("getMonthBookDetailList(year, month, loginID, pm) 호출");
		return dao.getMonthBookDetailList(year, month, loginID, pm);
	}
	
	@Override
	public List<BookDetailVO> getDashboardBookDetail(String loginID, int year, int month) throws Exception {
		log.info("getDashboardBookDetail(loginID, year, month) 호출");
		return dao.getDashboardBookDetail(loginID, year, month);
	}
	
	@Override
	public List<BookDetailVO> getAndroidBookDetailList(int year, int month, int day, String loginID) throws Exception {
		log.info("ヽ(✿ﾟ▽ﾟ)ノ getAndroidBookDetailList  호출됨");
		return dao.getAndroidBookDetailList(year, month, day, loginID);
	}
	
	@Override
	public List<BookDetailVO> getMonthBookDetailListCtgr
						(int year, int month, String loginID, PageMakerVO pm, String ctgr) throws Exception {
		log.info("getMonthBookDetailListCtgr 호출");
		return dao.getMonthBookDetailListCtgr(year, month, loginID, pm, ctgr);
	}
	

}
