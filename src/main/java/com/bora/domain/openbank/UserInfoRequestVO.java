package com.bora.domain.openbank;

import lombok.Data;

// 2.2.1 사용자정보조회 API 요청 데이터
@Data
public class UserInfoRequestVO {
	private String access_token; //오픈뱅킹으로부터 전송받은 Access Token을 HTTP Header에 추가
	private String user_seq_no="1101014738"; //사용자일련번호
	
	public UserInfoRequestVO() {}

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
