package com.bora.domain.openbank;

import lombok.Data;

// 사용자 토큰발급 API(2.1.2. 토큰발급 API) 응답 데이터
@Data
public class ResponseTokenVO {
	private String access_token;
	private String token_type;
	private int expires_in;
	private String refresh_token;
	private String scope;
	private String user_seq_no;

	public ResponseTokenVO () {}

	public ResponseTokenVO(String access_token, String token_type, int expires_in, String refresh_token, String scope,
			String user_seq_no) {
		super();
		this.access_token = access_token;
		this.token_type = token_type;
		this.expires_in = expires_in;
		this.refresh_token = refresh_token;
		this.scope = scope;
		this.user_seq_no = user_seq_no;
	}
	
	@Override
	public String toString() {
		return "ResponseTokenVO [access_token=" + access_token + ", token_type=" + token_type + ", expires_in="
				+ expires_in + ", refresh_token=" + refresh_token + ", scope=" + scope + ", user_seq_no=" + user_seq_no
				+ "]";
	}
	

	
	
}
