package com.bora.domain.openbank.card;

public class CardUpdateRequestVO {
	private String access_token;
	private String bank_tran_id;
	private String bank_code_std;	
	private String member_bank_code;
	private String user_seq_no;
	private String scope;
    private String update_user_email;
    
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
	public String getUser_seq_no() {
		return user_seq_no;
	}
	public void setUser_seq_no(String user_seq_no) {
		this.user_seq_no = user_seq_no;
	}
	public String getScope() {
		return scope;
	}
	public void setScope(String scope) {
		this.scope = scope;
	}
	public String getUpdate_user_email() {
		return update_user_email;
	}
	public void setUpdate_user_email(String update_user_email) {
		this.update_user_email = update_user_email;
	}

}
