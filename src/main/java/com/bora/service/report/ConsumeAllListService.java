package com.bora.service.report;

import java.util.List;

import com.bora.domain.report.ConsumeAllListVO;
import com.bora.domain.report.ConsumeLastMonListVO;
import com.bora.domain.report.ConsumeThisMonListVO;

public interface ConsumeAllListService {
	
	// 저번 달 소비 리스트
	public List<ConsumeLastMonListVO> getConsumeLastMonList(String loginID) throws Exception;
	
	// 이번 달 소비 리스트
	public List<ConsumeThisMonListVO> getConsumeThisMonList(String loginID) throws Exception;
	
	// 이번 소비 리스트 비교 메서드
	public List<ConsumeAllListVO> getConsumeAllList(String loginID) throws Exception;
	
	
}
