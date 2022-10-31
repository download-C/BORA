package com.bora.domain.openbank;

//2.2.7. 계좌해지 API 요청 데이터
public class AccountCancelRequestVO {
	private String access_token;
	private String bank_tran_id; //은행거래고유번호
	private String scope; //서비스구분 inquiry : 조회서비스, transfer : 출금서비스
	private String fintech_use_num; //핀테크이용번호
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
	public String getScope() {
		return scope;
	}
	public void setScope(String scope) {
		this.scope = scope;
	}
	public String getFintech_use_num() {
		return fintech_use_num;
	}
	public void setFintech_use_num(String fintech_use_num) {
		this.fintech_use_num = fintech_use_num;
	}
	public String getModel() {
		return model;
	}
	public void setModel(String model) {
		this.model = model;
	}
	@Override
	public String toString() {
		return "AccountCancelRequestVO [access_token=" + access_token + ", bank_tran_id=" + bank_tran_id + ", scope="
				+ scope + ", fintech_use_num=" + fintech_use_num + ", model=" + model + "]";
	}
	public AccountCancelRequestVO(String access_token, String bank_tran_id, String scope, String fintech_use_num,
			String model) {
		super();
		this.access_token = access_token;
		this.bank_tran_id = bank_tran_id;
		this.scope = scope;
		this.fintech_use_num = fintech_use_num;
		this.model = model;
	}

}
