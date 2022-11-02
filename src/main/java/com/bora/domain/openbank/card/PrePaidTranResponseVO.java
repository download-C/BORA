package com.bora.domain.openbank.card;

import java.util.List;

import lombok.Data;

@Data
public class PrePaidTranResponseVO {
	private String api_tran_id; // 거래고유번호(API)
	private String api_tran_dtm; // 거래일시(밀리세컨드)
	private String rsp_code; //응답코드(API)
	private String rsp_message; //응답메시지(API)
	private String bank_tran_id; // 거래고유번호(참가기관)	
	private String bank_tran_date; // 거래일자(참가기관)
	private String bank_code_tran; // 응답코드를 부여한 참가기관 표준 코드
	private String bank_rsp_code; // 응답코드(참가기관)
	private String bank_rsp_message; // 응답메시지(참가기관)
	private String next_page_yn; // 다음페이지 존재여부
	private String befor_inquiry_trace_info; // 직전조회추척정보
	private String tran_cnt; // 거래내역 현재 페이지 조회 건수
	private List<PrePaidTranVO> tran_list; // 거래내역 목록
	
	public PrePaidTranResponseVO() {}

	public PrePaidTranResponseVO(String api_tran_id, String api_tran_dtm, String rsp_code, String rsp_message,
			String bank_tran_id, String bank_tran_date, String bank_code_tran, String bank_rsp_code,
			String bank_rsp_message, String next_page_yn, String befor_inquiry_trace_info, String tran_cnt,
			List<PrePaidTranVO> tran_list) {
		super();
		this.api_tran_id = api_tran_id;
		this.api_tran_dtm = api_tran_dtm;
		this.rsp_code = rsp_code;
		this.rsp_message = rsp_message;
		this.bank_tran_id = bank_tran_id;
		this.bank_tran_date = bank_tran_date;
		this.bank_code_tran = bank_code_tran;
		this.bank_rsp_code = bank_rsp_code;
		this.bank_rsp_message = bank_rsp_message;
		this.next_page_yn = next_page_yn;
		this.befor_inquiry_trace_info = befor_inquiry_trace_info;
		this.tran_cnt = tran_cnt;
		this.tran_list = tran_list;
	}

	@Override
	public String toString() {
		return "PrePaidTranResponseVO [api_tran_id=" + api_tran_id + ", api_tran_dtm=" + api_tran_dtm + ", rsp_code="
				+ rsp_code + ", rsp_message=" + rsp_message + ", bank_tran_id=" + bank_tran_id + ", bank_tran_date="
				+ bank_tran_date + ", bank_code_tran=" + bank_code_tran + ", bank_rsp_code=" + bank_rsp_code
				+ ", bank_rsp_message=" + bank_rsp_message + ", next_page_yn=" + next_page_yn
				+ ", befor_inquiry_trace_info=" + befor_inquiry_trace_info + ", tran_cnt=" + tran_cnt + ", tran_list="
				+ tran_list + "]";
	}
	

}
