package com.bora.domain.openbank;

import java.util.List;

//2.2.3. 등록계좌조회 API 응답 데이터
public class AccountSearchResponseVO {
	private String api_tran_id; //거래고유번호(API)
	private String rsp_code; //응답코드(API)
	private String rsp_message; //응답메세지
	private String api_tran_dtm; //거래일시(밀리세컨드)
	private String user_name; //사용자명
	private String res_cnt; //사용자등록계좌 개수
	private List<AccountVO> res_list; //사용자 등록계좌 목록
	
	
	public String getApi_tran_id() {
		return api_tran_id;
	}
	public void setApi_tran_id(String api_tran_id) {
		this.api_tran_id = api_tran_id;
	}
	public String getRsp_code() {
		return rsp_code;
	}
	public void setRsp_code(String rsp_code) {
		this.rsp_code = rsp_code;
	}
	public String getRsp_message() {
		return rsp_message;
	}
	public void setRsp_message(String rsp_message) {
		this.rsp_message = rsp_message;
	}
	public String getApi_tran_dtm() {
		return api_tran_dtm;
	}
	public void setApi_tran_dtm(String api_tran_dtm) {
		this.api_tran_dtm = api_tran_dtm;
	}
	public String getUser_name() {
		return user_name;
	}
	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}
	public String getRes_cnt() {
		return res_cnt;
	}
	public void setRes_cnt(String res_cnt) {
		this.res_cnt = res_cnt;
	}
	public List<AccountVO> getRes_list() {
		return res_list;
	}
	public void setRes_list(List<AccountVO> res_list) {
		this.res_list = res_list;
	}
	@Override
	public String toString() {
		return "AccountSearchResponseVO [api_tran_id=" + api_tran_id + ", rsp_code=" + rsp_code + ", rsp_message="
				+ rsp_message + ", api_tran_dtm=" + api_tran_dtm + ", user_name=" + user_name + ", res_cnt=" + res_cnt
				+ ", res_list=" + res_list + "]";
	}
	public AccountSearchResponseVO(String api_tran_id, String rsp_code, String rsp_message, String api_tran_dtm,
			String user_name, String res_cnt, List<AccountVO> res_list) {
		super();
		this.api_tran_id = api_tran_id;
		this.rsp_code = rsp_code;
		this.rsp_message = rsp_message;
		this.api_tran_dtm = api_tran_dtm;
		this.user_name = user_name;
		this.res_cnt = res_cnt;
		this.res_list = res_list;
	}

	
	
}
