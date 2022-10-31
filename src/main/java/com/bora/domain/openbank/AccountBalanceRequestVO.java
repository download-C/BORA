package com.bora.domain.openbank;

// 2.3.1. 잔액조회 API 요청 데이터
public class AccountBalanceRequestVO {
    private String access_token;
    private String bank_tran_id; //은행거래고유번호
    private String fintech_use_num; //핀테크이용번호
    private String tran_dtime; //요청일시
    private String model;
    
	public String getAccess_token() {
		return access_token;
	}
	public void setAccess_token(String access_token) {
		this.access_token = access_token;
	}
	public String getBank_tran_id() {
		return bank_tran_id;
	}
	public void setBank_tran_id(String bank_tran_id) {
		this.bank_tran_id = bank_tran_id;
	}
	public String getFintech_use_num() {
		return fintech_use_num;
	}
	public void setFintech_use_num(String fintech_use_num) {
		this.fintech_use_num = fintech_use_num;
	}
	public String getTran_dtime() {
		return tran_dtime;
	}
	public void setTran_dtime(String tran_dtime) {
		this.tran_dtime = tran_dtime;
	}
	public String getModel() {
		return model;
	}
	public void setModel(String model) {
		this.model = model;
	}
	
	public AccountBalanceRequestVO(String access_token, String bank_tran_id, String fintech_use_num, String tran_dtime,
			String model) {
		super();
		this.access_token = access_token;
		this.bank_tran_id = bank_tran_id;
		this.fintech_use_num = fintech_use_num;
		this.tran_dtime = tran_dtime;
		this.model = model;
	}
	
	@Override
	public String toString() {
		return "AccountBalanceRequestVO [access_token=" + access_token + ", bank_tran_id=" + bank_tran_id
				+ ", fintech_use_num=" + fintech_use_num + ", tran_dtime=" + tran_dtime + ", model=" + model + "]";
	}
	
}


