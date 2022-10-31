package com.bora.domain.openbank.card;

public class CardBillsRequestVO {
	private String access_token;
	private String bank_tran_id;
	private String user_seq_no;
	private String bank_code_std;	
	private String member_bank_code;
    private String from_month;
    private String to_month;
    private String befor_inquiry_trace_info;
    
	public String getAccess_token() {
		return access_token;
	}
	public void setAccess_token(String access_token) {
		this.access_token = access_token;
	}
	public String getBank_tran_id() {
		return bank_tran_id;
	}
	public void setBank_tran_id(String bank_tran_id) {
		this.bank_tran_id = bank_tran_id;
	}
	public String getUser_seq_no() {
		return user_seq_no;
	}
	public void setUser_seq_no(String user_seq_no) {
		this.user_seq_no = user_seq_no;
	}
	public String getBank_code_std() {
		return bank_code_std;
	}
	public void setBank_code_std(String bank_code_std) {
		this.bank_code_std = bank_code_std;
	}
	public String getMember_bank_code() {
		return member_bank_code;
	}
	public void setMember_bank_code(String member_bank_code) {
		this.member_bank_code = member_bank_code;
	}
	public String getFrom_month() {
		return from_month;
	}
	public void setFrom_month(String from_month) {
		this.from_month = from_month;
	}
	public String getTo_month() {
		return to_month;
	}
	public void setTo_month(String to_month) {
		this.to_month = to_month;
	}
	public String getBefor_inquiry_trace_info() {
		return befor_inquiry_trace_info;
	}
	public void setBefor_inquiry_trace_info(String befor_inquiry_trace_info) {
		this.befor_inquiry_trace_info = befor_inquiry_trace_info;
	}
    
    


}