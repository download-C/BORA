package com.bora.domain.openbank.tran;

import java.util.List;

import lombok.Data;

//2.5.3. 이체결과조회 API
@Data
public class TranResultResponseVO {
	private String api_tran_id; //"2ffd133a-d17a-431d-a6a5" 거래고유번호(API)
	private String api_tran_dtm; //"20190910101921567" 거래일시(밀리세컨드)
	private String rsp_code; //"A0000" 응답코드(API)
	private String rsp_message; //"" 응답메시지(API)
	private String res_cnt; //"25" 이체건수
	private List<TranResultResListVO> tranResult_res_list; //이체결과 이체목록
	
	public TranResultResponseVO () {}
	
	public TranResultResponseVO(String api_tran_id, String api_tran_dtm, String rsp_code, String rsp_message,
			String res_cnt, List<TranResultResListVO> tranResult_res_list) {
		super();
		this.api_tran_id = api_tran_id;
		this.api_tran_dtm = api_tran_dtm;
		this.rsp_code = rsp_code;
		this.rsp_message = rsp_message;
		this.res_cnt = res_cnt;
		this.tranResult_res_list = tranResult_res_list;
	}
	
	
}
