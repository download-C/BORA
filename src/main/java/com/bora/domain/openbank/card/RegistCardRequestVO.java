package com.bora.domain.openbank.card;

import lombok.Data;

@Data
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
	
	public RegistCardRequestVO(String access_token, String bank_tran_id, String bank_code_std, String member_bank_code,
			String user_name, String user_ci, String user_email, String scope, String info_prvd_agmt_yn) {
		super();
		this.access_token = access_token;
		this.bank_tran_id = bank_tran_id;
		this.bank_code_std = bank_code_std;
		this.member_bank_code = member_bank_code;
		this.user_name = user_name;
		this.user_ci = user_ci;
		this.user_email = user_email;
		this.scope = scope;
		this.info_prvd_agmt_yn = info_prvd_agmt_yn;
	}
	

}
