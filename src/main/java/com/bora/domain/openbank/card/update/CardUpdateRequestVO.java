package com.bora.domain.openbank.card;

import lombok.Data;

@Data
public class CardUpdateRequestVO {
	private String access_token;
	private String bank_tran_id; // 거래고유번호(참가기관)
	private String bank_code_std; // 카드사 대표코드(금융기관 공동코드)
	private String member_bank_code; // 회원 금융회사 코드(금융기관 공동코드)
	private String user_seq_no; // 사용자일련번호
	private String scope; // 서비스구분
    private String update_user_email; // 변경할 이메일주소
    
    public CardUpdateRequestVO() {}
    
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

	@Override
	public String toString() {
		return "CardUpdateRequestVO [access_token=" + access_token + ", bank_tran_id=" + bank_tran_id
				+ ", bank_code_std=" + bank_code_std + ", member_bank_code=" + member_bank_code + ", user_seq_no="
				+ user_seq_no + ", scope=" + scope + ", update_user_email=" + update_user_email + "]";
	}
    
	
}
