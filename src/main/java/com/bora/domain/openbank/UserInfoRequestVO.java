package com.bora.domain.openbank;

// 2.2.1 사용자정보조회 API 요청 데이터
public class UserInfoRequestVO {
	private String access_token;
	private String user_seq_no;
	
	public String getAccess_token() {
		return access_token;
	}
	public void setAccess_token(String access_token) {
		this.access_token = access_token;
	}
	public String getUser_seq_no() {
		return user_seq_no;
	}
	public void setUser_seq_no(String user_seq_no) {
		this.user_seq_no = user_seq_no;
	}
	
}
