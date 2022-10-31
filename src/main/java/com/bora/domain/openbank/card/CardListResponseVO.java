package com.bora.domain.openbank.card;

import java.util.List;

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
	
	public String getApi_tran_id() {
		return api_tran_id;
	}
	public void setApi_tran_id(String api_tran_id) {
		this.api_tran_id = api_tran_id;
	}
	public String getApi_tran_dtm() {
		return api_tran_dtm;
	}
	public void setApi_tran_dtm(String api_tran_dtm) {
		this.api_tran_dtm = api_tran_dtm;
	}
	public String getRsp_code() {
		return rsp_code;
	}
	public void setRsp_code(String rsp_code) {
		this.rsp_code = rsp_code;
	}
	public String getRsp_message() {
		return rsp_message;
	}
	public void setRsp_message(String rsp_message) {
		this.rsp_message = rsp_message;
	}
	public String getBank_tran_id() {
		return bank_tran_id;
	}
	public void setBank_tran_id(String bank_tran_id) {
		this.bank_tran_id = bank_tran_id;
	}
	public String getBank_tran_date() {
		return bank_tran_date;
	}
	public void setBank_tran_date(String bank_tran_date) {
		this.bank_tran_date = bank_tran_date;
	}
	public String getBank_code_tran() {
		return bank_code_tran;
	}
	public void setBank_code_tran(String bank_code_tran) {
		this.bank_code_tran = bank_code_tran;
	}
	public String getBank_rsp_code() {
		return bank_rsp_code;
	}
	public void setBank_rsp_code(String bank_rsp_code) {
		this.bank_rsp_code = bank_rsp_code;
	}
	public String getBank_rsp_message() {
		return bank_rsp_message;
	}
	public void setBank_rsp_message(String bank_rsp_message) {
		this.bank_rsp_message = bank_rsp_message;
	}
	public String getUser_seq_no() {
		return user_seq_no;
	}
	public void setUser_seq_no(String user_seq_no) {
		this.user_seq_no = user_seq_no;
	}
	public String getNext_page_yn() {
		return next_page_yn;
	}
	public void setNext_page_yn(String next_page_yn) {
		this.next_page_yn = next_page_yn;
	}
	public String getBefor_inquiry_trace_info() {
		return befor_inquiry_trace_info;
	}
	public void setBefor_inquiry_trace_info(String befor_inquiry_trace_info) {
		this.befor_inquiry_trace_info = befor_inquiry_trace_info;
	}
	public String getCard_cnt() {
		return card_cnt;
	}
	public void setCard_cnt(String card_cnt) {
		this.card_cnt = card_cnt;
	}
	public List<CardVO> getCard_list() {
		return card_list;
	}
	public void setCard_list(List<CardVO> card_list) {
		this.card_list = card_list;
	}
	
	
	

}
