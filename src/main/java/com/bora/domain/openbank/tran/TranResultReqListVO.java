package com.bora.domain.openbank.tran;

import java.util.List;

import lombok.Data;

//2.5.3. 이체결과조회 API
//private List<TranResultReqListVO> tranResult_res_list; //이체결과 요청목록
@Data
public class TranResultReqListVO {
	private String tran_no; //"1" 거래순번
	private String org_bank_tran_id; //"F123456789U123A4239C" 원거래 거래고유번호(참가은행)주2)
	private String org_bank_tran_date; //"20190910" 원거래 거래일자(참가은행)주3)
	private String org_tran_amt; //"10000" 원거래 거래금액
	
	public TranResultReqListVO() {}
	
	public TranResultReqListVO(String tran_no, String org_bank_tran_id, String org_bank_tran_date,
			String org_tran_amt) {
		super();
		this.tran_no = tran_no;
		this.org_bank_tran_id = org_bank_tran_id;
		this.org_bank_tran_date = org_bank_tran_date;
		this.org_tran_amt = org_tran_amt;
	}
	
	
}
