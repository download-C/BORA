package com.bora.persistence;

import java.util.List;

import com.bora.domain.report.ConsumeAllListVO;
import com.bora.domain.report.ConsumeLastMonListVO;
import com.bora.domain.report.ConsumeThisMonListVO;

public interface ConsumeDAO {
	
    public List<ConsumeLastMonListVO> getConsumeLastMonList(String loginID) throws Exception;
	
	public List<ConsumeThisMonListVO> getConsumeThisMonList(String loginID) throws Exception;
	
	public List<ConsumeAllListVO> getConsumeAllList(String loginID) throws Exception;

	
}
