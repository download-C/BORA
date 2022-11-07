package com.bora.service.report;

import java.util.List;

import com.bora.domain.openbank.card.prePaid.PrePaidTranVO;

public interface ReportService {

	
	// 카테고리별 내역
	public List<PrePaidTranVO> getCategoryList() throws Exception;
}
