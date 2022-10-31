package com.bora.domain.openbank.card;

public class CardDetailBillsRequestVO {
	private String access_token;
	private String bank_tran_id;
	private String user_seq_no;
	private String bank_code_std;	
	private String member_bank_code;
    private String charge_month;
    private String settlement_seq_no;
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
	public String getCharge_month() {
		return charge_month;
	}
	public void setCharge_month(String charge_month) {
		this.charge_month = charge_month;
	}
	public String getSettlement_seq_no() {
		return settlement_seq_no;
	}
	public void setSettlement_seq_no(String settlement_seq_no) {
		this.settlement_seq_no = settlement_seq_no;
	}
	public String getBefor_inquiry_trace_info() {
		return befor_inquiry_trace_info;
	}
	public void setBefor_inquiry_trace_info(String befor_inquiry_trace_info) {
		this.befor_inquiry_trace_info = befor_inquiry_trace_info;
	}

    
}
