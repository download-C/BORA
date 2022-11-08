package com.bora.service.report;

import java.util.List;

import com.bora.domain.report.ConsumeAllListVO;
import com.bora.domain.report.ConsumeLastMonListVO;
import com.bora.domain.report.ConsumePageVO;
import com.bora.domain.report.ConsumeThisMonListVO;

public interface ConsumeAllListService {
	
	// 저번 달 소비 리스트
	public List<ConsumeLastMonListVO> getConsumeLastMonList(ConsumePageVO vo) throws Exception;
	
	// 이번 달 소비 리스트
	public List<ConsumeThisMonListVO> getConsumeThisMonList(ConsumePageVO vo) throws Exception;
	
	// 이번 소비 리스트 비교 메서드
	public List<ConsumeAllListVO> getConsumeAllList(ConsumePageVO vo) throws Exception;
	
	// 소비 리스트 카운트
	public int getConsumeCount();
	
}
