package com.bora.domain.openbank.card;

public class RegistCardRequestVO {
	private String access_token;
	private String bank_tran_id;
	private String bank_code_std;
	private String member_bank_code;
	private String user_name;
	private String user_ci;
	private String user_email;
	private String scope;
	private String info_prvd_agmt_yn;
	
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
	public String getUser_name() {
		return user_name;
	}
	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}
	public String getUser_ci() {
		return user_ci;
	}
	public void setUser_ci(String user_ci) {
		this.user_ci = user_ci;
	}
	public String getUser_email() {
		return user_email;
	}
	public void setUser_email(String user_email) {
		this.user_email = user_email;
	}
	public String getScope() {
		return scope;
	}
	public void setScope(String scope) {
		this.scope = scope;
	}
	public String getInfo_prvd_agmt_yn() {
		return info_prvd_agmt_yn;
	}
	public void setInfo_prvd_agmt_yn(String info_prvd_agmt_yn) {
		this.info_prvd_agmt_yn = info_prvd_agmt_yn;
	}

}
