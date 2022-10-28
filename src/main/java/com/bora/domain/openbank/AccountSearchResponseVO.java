package com.bora.domain.openbank;

import java.util.List;

public class AccountSearchResponseVO {
	private String api_tran_id;
	private String rsp_code;
	private String rsp_message;
	private String api_tran_dtm;
	private String user_name;
	private String res_cnt;
	private List<AccountVO> res_list;
	
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
	
	
}
