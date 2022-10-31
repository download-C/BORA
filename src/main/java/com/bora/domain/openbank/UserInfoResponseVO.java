package com.bora.domain.openbank;

import java.util.List;

import lombok.Data;

// 2.2.1 사용자정보조회 API 응답 데이터
@Data
public class UserInfoResponseVO {
	private String api_tran_id; //거래고유번호(API)
	private String api_tran_dtm; //거래일시(밀리세컨드)
	private String rsp_code; //응답코드(API)
	private String rsp_message; //응답메시지(API)
	private String user_seq_no; //고객마다 다른 고정값
	private String user_ci; //고객마다 다른 고정값
	private String user_name; //고객명
	private String user_info; //생년월일
	private String user_gender; //성별
	private String user_cell_no; //휴대폰번호
	private String user_email; //이메일주소
	private String res_cnt; //등록된 계좌 수
	private List<AccountVO> res_list; //등록된 계좌 목록
	//추가
	private String acct_alias; //계좌별명
	private String bank_name; //출금(개설)기관명
	private String acct_num; //계좌번호
//	private String acct_type; //계좌종류 1:수시입출금, 2:예적금, 6:수익증권, T:종합계좌
	//계좌종류는 2020.12월(실시예정)부터 등록하는 계좌에 대해 추가로 제공하는 정보로, 그 이전에 등록된 계좌에 대해서는 해당 정보가 제공되지 않을 수 있음.
	
	
	public UserInfoResponseVO(String api_tran_id, String api_tran_dtm, String rsp_code, String rsp_message,
			String user_seq_no, String user_ci, String user_name, String user_info, String user_gender,
			String user_cell_no, String user_email, String res_cnt, List<AccountVO> res_list, String acct_alias,
			String bank_name, String acct_num) {
		super();
		this.api_tran_id = api_tran_id;
		this.api_tran_dtm = api_tran_dtm;
		this.rsp_code = rsp_code;
		this.rsp_message = rsp_message;
		this.user_seq_no = user_seq_no;
		this.user_ci = user_ci;
		this.user_name = user_name;
		this.user_info = user_info;
		this.user_gender = user_gender;
		this.user_cell_no = user_cell_no;
		this.user_email = user_email;
		this.res_cnt = res_cnt;
		this.res_list = res_list;
		this.acct_alias = acct_alias;
		this.bank_name = bank_name;
		this.acct_num = acct_num;
	}
	
	@Override
	public String toString() {
		return "UserInfoResponseVO [api_tran_id=" + api_tran_id + ", api_tran_dtm=" + api_tran_dtm + ", rsp_code="
				+ rsp_code + ", rsp_message=" + rsp_message + ", user_seq_no=" + user_seq_no + ", user_ci=" + user_ci
				+ ", user_name=" + user_name + ", user_info=" + user_info + ", user_gender=" + user_gender
				+ ", user_cell_no=" + user_cell_no + ", user_email=" + user_email + ", res_cnt=" + res_cnt
				+ ", res_list=" + res_list + ", acct_alias=" + acct_alias + ", bank_name=" + bank_name + ", acct_num="
				+ acct_num + "]";
	}
	
	
}
