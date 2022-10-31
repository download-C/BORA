package com.bora.domain.openbank;

import lombok.Data;

// 2.2 사용자/계좌 관리에서 사용되는 계좌 정보(배열로 전달된 데이터)
@Data
public class AccountVO {
	private String fintech_use_num;
    private String account_alias;
    private String bank_code_std;
    private String bank_code_sub;
    private String bank_name;
    private String savings_bank_name;
    private String account_num;
    private String account_num_masked;
    private String account_seq;
    private String account_holder_name;
    private String account_holder_type;
    private String account_type;
    private String inquiry_agree_yn;
    private String inquiry_agree_dtime;
    private String transfer_agree_yn;
    private String transfer_agree_dtime;
    private String account_state;
    
    
	@Override
	public String toString() {
		return "AccountVO [fintech_use_num=" + fintech_use_num + ", account_alias=" + account_alias + ", bank_code_std="
				+ bank_code_std + ", bank_code_sub=" + bank_code_sub + ", bank_name=" + bank_name
				+ ", savings_bank_name=" + savings_bank_name + ", account_num=" + account_num + ", account_num_masked="
				+ account_num_masked + ", account_seq=" + account_seq + ", account_holder_name=" + account_holder_name
				+ ", account_holder_type=" + account_holder_type + ", account_type=" + account_type
				+ ", inquiry_agree_yn=" + inquiry_agree_yn + ", inquiry_agree_dtime=" + inquiry_agree_dtime
				+ ", transfer_agree_yn=" + transfer_agree_yn + ", transfer_agree_dtime=" + transfer_agree_dtime
				+ ", account_state=" + account_state + "]";
	}
	
	public AccountVO(String fintech_use_num, String account_alias, String bank_code_std, String bank_code_sub,
			String bank_name, String savings_bank_name, String account_num, String account_num_masked,
			String account_seq, String account_holder_name, String account_holder_type, String account_type,
			String inquiry_agree_yn, String inquiry_agree_dtime, String transfer_agree_yn, String transfer_agree_dtime,
			String account_state) {
		super();
		this.fintech_use_num = fintech_use_num;
		this.account_alias = account_alias;
		this.bank_code_std = bank_code_std;
		this.bank_code_sub = bank_code_sub;
		this.bank_name = bank_name;
		this.savings_bank_name = savings_bank_name;
		this.account_num = account_num;
		this.account_num_masked = account_num_masked;
		this.account_seq = account_seq;
		this.account_holder_name = account_holder_name;
		this.account_holder_type = account_holder_type;
		this.account_type = account_type;
		this.inquiry_agree_yn = inquiry_agree_yn;
		this.inquiry_agree_dtime = inquiry_agree_dtime;
		this.transfer_agree_yn = transfer_agree_yn;
		this.transfer_agree_dtime = transfer_agree_dtime;
		this.account_state = account_state;
	}
    
	
	
}
