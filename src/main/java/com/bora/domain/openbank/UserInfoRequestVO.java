package com.bora.domain.openbank;

// 2.2.1 사용자정보조회 API 요청 데이터
public class UserInfoRequestVO {
	private String access_token; //오픈뱅킹으로부터 전송받은 Access Token을 HTTP Header에 추가
	private String user_seq_no; //사용자일련번호
	
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
	
	public UserInfoRequestVO(String access_token, String user_seq_no) {
		super();
		this.access_token = access_token;
		this.user_seq_no = user_seq_no;
	}
	@Override
	public String toString() {
		return "UserInfoRequestVO [access_token=" + access_token + ", user_seq_no=" + user_seq_no + "]";
	}
	
	
}
