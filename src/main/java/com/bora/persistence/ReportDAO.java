package com.bora.persistence;

import java.util.List;

import com.bora.domain.openbank.card.prePaid.PrePaidTranVO;

public interface ReportDAO {

	//카테고리 전체 내역
	public List<PrePaidTranVO> categoryListAll() throws Exception;


}
