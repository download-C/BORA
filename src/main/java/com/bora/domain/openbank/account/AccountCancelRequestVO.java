package com.bora.domain.openbank.account;

import lombok.Data;

//2.2.7. 계좌해지 API 요청 데이터
@Data
public class AccountCancelRequestVO {
	private String access_token;
	private String bank_tran_id; //은행거래고유번호
	private String scope; //서비스구분 inquiry : 조회서비스, transfer : 출금서비스
	private String fintech_use_num; //핀테크이용번호
    private String model;

    
    public AccountCancelRequestVO () {}
    
    
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
