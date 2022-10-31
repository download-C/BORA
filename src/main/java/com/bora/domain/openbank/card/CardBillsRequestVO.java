package com.bora.domain.openbank.card;

import lombok.Data;

@Data
public class CardBillsRequestVO {
	private String access_token;
	private String bank_tran_id;
	private String user_seq_no;
	private String bank_code_std;	
	private String member_bank_code;
    private String from_month;
    private String to_month;
    private String befor_inquiry_trace_info;
    
	public CardBillsRequestVO(String access_token, String bank_tran_id, String user_seq_no, String bank_code_std,
			String member_bank_code, String from_month, String to_month, String befor_inquiry_trace_info) {
		super();
		this.access_token = access_token;
		this.bank_tran_id = bank_tran_id;
		this.user_seq_no = user_seq_no;
		this.bank_code_std = bank_code_std;
		this.member_bank_code = member_bank_code;
		this.from_month = from_month;
		this.to_month = to_month;
		this.befor_inquiry_trace_info = befor_inquiry_trace_info;
	}
    

}
