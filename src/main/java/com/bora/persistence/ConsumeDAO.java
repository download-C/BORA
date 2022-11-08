package com.bora.persistence;

import java.util.List;

import com.bora.domain.report.ConsumeAllListVO;
import com.bora.domain.report.ConsumeLastThisListVO;
import com.bora.domain.report.ConsumePageVO;

public interface ConsumeDAO {
	
    public List<ConsumeLastThisListVO> getConsumeLastThisList(ConsumePageVO vo) throws Exception;
	
	public List<ConsumeAllListVO> getConsumeAllList(ConsumePageVO vo) throws Exception;
	
	public int getConsumeCount();

}
