package com.bora.domain.openbank.card;

import java.util.Random;

import lombok.Data;

@Data
public class CardListRequestVO {
	private String access_token;
	private String bank_tran_id; // 거래고유번호(참가기관)
	private String user_seq_no; // 사용자일련번호
	private String bank_code_std; // 카드사 대표코드(금융기관 공동코드)
	private String member_bank_code; // 회원 금융회사 코드(금융기관 공동코드)
    private String befor_inquiry_trace_info; // 직전조회추적정보
    
    public CardListRequestVO() {}
    
    public String getBank_tran_id() {
    	Random random = new Random();
    	random.setSeed(System.currentTimeMillis());
    	long val = random.nextInt(1000000000)+1;
    	return "M202202316U"+String.valueOf(val);
	}
    
	public CardListRequestVO(String access_token, String bank_tran_id, String user_seq_no, String bank_code_std,
			String member_bank_code, String befor_inquiry_trace_info) {
		super();
		this.access_token = access_token;
		this.bank_tran_id = getBank_tran_id();
		this.user_seq_no = user_seq_no;
		this.bank_code_std = bank_code_std;
		this.member_bank_code = member_bank_code;
		this.befor_inquiry_trace_info = befor_inquiry_trace_info;
	}

	@Override
	public String toString() {
		return "CardListRequestVO [access_token=" + access_token + ", bank_tran_id=" + bank_tran_id + ", user_seq_no="
				+ user_seq_no + ", bank_code_std=" + bank_code_std + ", member_bank_code=" + member_bank_code
				+ ", befor_inquiry_trace_info=" + befor_inquiry_trace_info + "]";
	}
    
	
    
}
