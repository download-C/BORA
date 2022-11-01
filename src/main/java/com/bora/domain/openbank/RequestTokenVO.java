package com.bora.domain.openbank;

import lombok.Data;

//사용자 토큰발급 API(2.1.2. 토큰발급 API) 요청 데이터
@Data
public class RequestTokenVO {
	private String code; //사용자인증 성공 후 획득한 Authorization Code
	private String client_id; //오픈뱅킹에서 발급한 이용기관 앱의 Client ID
	private String client_secret; //오픈뱅킹에서 발급한 이용기관 앱의 Client Secret
	private String redirect_uri; //Access Token을 전달받을 Callback URL(Authorization Code 획득 시 요청했던 Callback URL)
	private String grant_type; //3-legged 인증을 위한 권한부여 방식 지정
	
	private String scope; //Access Token 권한 범위
	private String client_info;
	private String state;
	
	public RequestTokenVO () {}
	
	public void setRequestToken(String client_id, String client_secret, String redirect_uri,String grant_type) {
		this.client_id = client_id;
		this.client_secret = client_secret;
		this.redirect_uri = redirect_uri;
		this.grant_type = grant_type;
	}

	@Override
	public String toString() {
		return "RequestTokenVO [code=" + code + ", client_id=" + client_id + ", client_secret=" + client_secret
				+ ", redirect_uri=" + redirect_uri + ", grant_type=" + grant_type + ", scope=" + scope
				+ ", client_info=" + client_info + ", state=" + state + "]";
	}
	
	
}
