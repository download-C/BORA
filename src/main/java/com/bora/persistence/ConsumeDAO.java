package com.bora.persistence;

import java.util.List;

import com.bora.domain.report.ConsumeAllListVO;
import com.bora.domain.report.ConsumeLastThisListVO;
public interface ConsumeDAO {
	
    public List<ConsumeLastThisListVO> getConsumeLastMonList(String loginID) throws Exception;
	
	public List<ConsumeLastThisListVO> getConsumeThisMonList(String loginID) throws Exception;
	
	public List<ConsumeAllListVO> getConsumeAllList(String loginID) throws Exception;

}
