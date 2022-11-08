package com.bora.service.report;

import java.util.List;

import com.bora.domain.report.ConsumeAllListVO;
import com.bora.domain.report.ConsumeLastThisListVO;
import com.bora.domain.report.ConsumePageVO;

public interface ConsumeAllListService {
	
	// 저번 달 소비 리스트
	public List<ConsumeLastThisListVO> getConsumeLastThisList(ConsumePageVO vo) throws Exception;
	
	// 이번 소비 리스트 비교 메서드
	public List<ConsumeAllListVO> getConsumeAllList(ConsumePageVO vo) throws Exception;
	
	// 소비 리스트 카운트
	public int getConsumeCount();
	
}
