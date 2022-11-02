package com.bora.domain.openbank.tran.result;

import java.util.List;

import lombok.Data;

//2.5.3. 이체결과조회 API
@Data
public class TranResultRequestVO {
	private String access_token;
	private String check_type; //1:출금이체, 2:입금이체
	private String tran_dtime; //요청일시
	private String req_cnt; //요청건수주1)
	private List<TranResultReqListVO> tranResult_req_list; //이체결과 요청목록
	
	public TranResultRequestVO() {}
	
	public TranResultRequestVO(String access_token, String check_type, String tran_dtime, String req_cnt,
			List<TranResultReqListVO> tranResult_res_list) {
		super();
		this.access_token = access_token;
		this.check_type = check_type;
		this.tran_dtime = tran_dtime;
		this.req_cnt = req_cnt;
		this.tranResult_req_list = tranResult_res_list;
	}
	
	
}
