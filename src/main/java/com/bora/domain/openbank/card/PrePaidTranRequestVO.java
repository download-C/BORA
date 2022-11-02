package com.bora.domain.openbank.card;

import lombok.Data;

@Data
public class PrePaidTranRequestVO {
	private String access_token;
	private String bank_tran_id; // 거래고유번호(참가기관)
	private String user_seq_no; // 사용자일련번호
	private String bank_code_std; // 카드사 대표코드(금융기관 공동코드)
	private String faceofbill_id; // 데이터 보유자가 부여한 권면의 고유 식별자
	private String from_date; // 조회시작일자
	private String to_date; // 조회종료일자
	private String befor_inquiry_trace_info; // 직전조회추적정보
	
	public PrePaidTranRequestVO() {}
	
	public PrePaidTranRequestVO(String access_token, String bank_tran_id, String user_seq_no, String bank_code_std,
			String faceofbill_id, String from_date, String to_date, String befor_inquiry_trace_info) {
		super();
		this.access_token = access_token;
		this.bank_tran_id = bank_tran_id;
		this.user_seq_no = user_seq_no; 
		this.bank_code_std = bank_code_std;
		this.faceofbill_id = faceofbill_id;
		this.from_date = from_date;
		this.to_date = to_date;
		this.befor_inquiry_trace_info = befor_inquiry_trace_info;
	}

	@Override
	public String toString() {
		return "PrePaidTranRequestVO [access_token=" + access_token + ", bank_tran_id=" + bank_tran_id
				+ ", user_seq_no=" + user_seq_no + ", bank_code_std=" + bank_code_std + ", faceofbill_id="
				+ faceofbill_id + ", from_date=" + from_date + ", to_date=" + to_date + ", befor_inquiry_trace_info="
				+ befor_inquiry_trace_info + "]";
	}

}
