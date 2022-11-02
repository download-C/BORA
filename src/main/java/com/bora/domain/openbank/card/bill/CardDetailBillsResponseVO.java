package com.bora.domain.openbank.card.bill;

import java.util.List;

import com.bora.domain.openbank.card.bill.CardDetailBillsVO;

import lombok.Data;

@Data
public class CardDetailBillsResponseVO {
	private String api_tran_id; // 거래고유번호(API)
	private String api_tran_dtm; // 거래일시(밀리세컨드)
	private String rsp_code; //응답코드(API)
	private String rsp_message; //응답메시지(API)
	private String bank_tran_id; // 거래고유번호(참가기관)	
	private String bank_tran_date; // 거래일자(참가기관)
	private String bank_code_tran; // 응답코드를 부여한 참가기관 표준 코드
	private String bank_rsp_code; // 응답코드(참가기관)
	private String bank_rsp_message; // 응답메시지(참가기관)
	private String user_seq_no; // 사용자일련번호
	private String next_page_yn; // 다음페이지 존재여부
	private String befor_inquiry_trace_info; // 직전조회추척정보
	private String bill_detail_cnt; // 현재 페이지 조회 건수
	private List<CardDetailBillsVO> bill_detail_list; // 청구상세목록
	
	public CardDetailBillsResponseVO() {}
	
	public CardDetailBillsResponseVO(String api_tran_id, String api_tran_dtm, String rsp_code, String rsp_message,
			String bank_tran_id, String bank_tran_date, String bank_code_tran, String bank_rsp_code,
			String bank_rsp_message, String user_seq_no, String next_page_yn, String befor_inquiry_trace_info,
			String bill_detail_cnt, List<CardDetailBillsVO> bill_detail_list) {
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
		this.user_seq_no = user_seq_no;
		this.next_page_yn = next_page_yn;
		this.befor_inquiry_trace_info = befor_inquiry_trace_info;
		this.bill_detail_cnt = bill_detail_cnt;
		this.bill_detail_list = bill_detail_list;
	}

	@Override
	public String toString() {
		return "CardDetailBillsResponseVO [api_tran_id=" + api_tran_id + ", api_tran_dtm=" + api_tran_dtm
				+ ", rsp_code=" + rsp_code + ", rsp_message=" + rsp_message + ", bank_tran_id=" + bank_tran_id
				+ ", bank_tran_date=" + bank_tran_date + ", bank_code_tran=" + bank_code_tran + ", bank_rsp_code="
				+ bank_rsp_code + ", bank_rsp_message=" + bank_rsp_message + ", user_seq_no=" + user_seq_no
				+ ", next_page_yn=" + next_page_yn + ", befor_inquiry_trace_info=" + befor_inquiry_trace_info
				+ ", bill_detail_cnt=" + bill_detail_cnt + ", bill_detail_list=" + bill_detail_list + "]";
	}
    
	

}
