package com.bora.domain.openbank.card;

import java.util.List;

import lombok.Data;

@Data
public class CardListResponseVO {
	private String api_tran_id;
	private String api_tran_dtm;
	private String rsp_code;
	private String rsp_message;
	private String bank_tran_id;	
	private String bank_tran_date;	
	private String bank_code_tran;
	private String bank_rsp_code;	
	private String bank_rsp_message;
	private String user_seq_no;
	private String next_page_yn;
	private String befor_inquiry_trace_info;
	private String card_cnt;
	private List<CardVO> card_list;
	
	public CardListResponseVO(String api_tran_id, String api_tran_dtm, String rsp_code, String rsp_message,
			String bank_tran_id, String bank_tran_date, String bank_code_tran, String bank_rsp_code,
			String bank_rsp_message, String user_seq_no, String next_page_yn, String befor_inquiry_trace_info,
			String card_cnt, List<CardVO> card_list) {
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
		this.card_cnt = card_cnt;
		this.card_list = card_list;
	}
	

}
