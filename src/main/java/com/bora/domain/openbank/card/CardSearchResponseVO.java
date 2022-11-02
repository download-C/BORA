package com.bora.domain.openbank.card;

import lombok.Data;

@Data
public class CardSearchResponseVO {
	private String api_tran_id;
	private String api_tran_dtm;
	private String rsp_code;
	private String rsp_message;
	private String bank_tran_id;	
	private String bank_tran_date;	
	private String bank_code_tran;
	private String bank_rsp_code;	
	private String bank_rsp_message;
	private String code_type;
	private String settlement_bank_code;
	private String settlement_account_num;
	private String settlement_account_num_masked;
	private String issue_date;
	
	public CardSearchResponseVO(String api_tran_id, String api_tran_dtm, String rsp_code, String rsp_message,
			String bank_tran_id, String bank_tran_date, String bank_code_tran, String bank_rsp_code,
			String bank_rsp_message, String code_type, String settlement_bank_code, String settlement_account_num,
			String settlement_account_num_masked, String issue_date) {
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
		this.code_type = code_type;
		this.settlement_bank_code = settlement_bank_code;
		this.settlement_account_num = settlement_account_num;
		this.settlement_account_num_masked = settlement_account_num_masked;
		this.issue_date = issue_date;
	}
	

}
