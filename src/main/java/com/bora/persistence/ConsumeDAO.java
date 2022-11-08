package com.bora.persistence;

import java.util.List;

import com.bora.domain.report.ConsumeAllListVO;
import com.bora.domain.report.ConsumeLastMonListVO;
import com.bora.domain.report.ConsumePageVO;
import com.bora.domain.report.ConsumeThisMonListVO;

public interface ConsumeDAO {
	
    public List<ConsumeLastMonListVO> getConsumeLastMonList(ConsumePageVO vo) throws Exception;
	
	public List<ConsumeThisMonListVO> getConsumeThisMonList(ConsumePageVO vo) throws Exception;
	
	public List<ConsumeAllListVO> getConsumeAllList(ConsumePageVO vo) throws Exception;
	
	public int getConsumeCount();

}
