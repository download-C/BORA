package com.bora.domain.openbank.card;

import lombok.Data;

@Data
public class RegistCardRequestVO {
	private String access_token;
	private String bank_tran_id; // 거래고유번호(참가기관)
	private String bank_code_std; // 카드사 대표코드(금융기관 공동코드)
	private String member_bank_code; // 회원 금융회사 코드(금융기관 공동코드)
	private String user_name; // 사용자명
	private String user_ci; // CI
	private String user_email; // 사용자 이메일주소
	private String scope; // 서비스 구분
	private String info_prvd_agmt_yn; // 제3자정보제공동의여부
	
	public RegistCardRequestVO() {}
	
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

	@Override
	public String toString() {
		return "RegistCardRequestVO [access_token=" + access_token + ", bank_tran_id=" + bank_tran_id
				+ ", bank_code_std=" + bank_code_std + ", member_bank_code=" + member_bank_code + ", user_name="
				+ user_name + ", user_ci=" + user_ci + ", user_email=" + user_email + ", scope=" + scope
				+ ", info_prvd_agmt_yn=" + info_prvd_agmt_yn + "]";
	}
	
	

}
