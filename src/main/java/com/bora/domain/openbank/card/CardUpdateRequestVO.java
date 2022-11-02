package com.bora.domain.openbank.card;

import lombok.Data;

@Data
public class CardUpdateRequestVO {
	private String access_token;
	private String bank_tran_id;
	private String bank_code_std;	
	private String member_bank_code;
	private String user_seq_no;
	private String scope;
    private String update_user_email;
    
	public CardUpdateRequestVO(String access_token, String bank_tran_id, String bank_code_std, String member_bank_code,
			String user_seq_no, String scope, String update_user_email) {
		super();
		this.access_token = access_token;
		this.bank_tran_id = bank_tran_id;
		this.bank_code_std = bank_code_std;
		this.member_bank_code = member_bank_code;
		this.user_seq_no = user_seq_no;
		this.scope = scope;
		this.update_user_email = update_user_email;
	}
    
}
