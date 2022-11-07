package com.bora.domain.openbank.account;

import lombok.Data;

//2.2.7. 계좌해지 API 응답 데이터
@Data
public class AccountCancelResponseVO {
	private String api_tran_id; //거래고유번호(API)
	private String api_tran_dtm; //거래일시(밀리세컨드)
	private String rsp_code; //응답코드(API)
	private String rsp_message; //응답메시지(API)
	private String bank_tran_id; //거래고유번호(참가은행)
	private String bank_tran_date; //거래일자(참가은행)
	private String bank_code_tran; //응답코드를 부여한 참가은행.표준코드
	private String bank_rsp_code; //응답코드(참가은행)
	private String bank_rsp_message; //응답메시지(참가은행)
	//해지 API 응답 시 응답코드(참가은행)가 
	//“기 해지 사용자(551)”, “해당 사용자 없음(555)”인 경우, 해지 완료된 것으로 처리
	
	
	public AccountCancelResponseVO () {}
	
	
	public AccountCancelResponseVO(String api_tran_id, String api_tran_dtm, String rsp_code, String rsp_message,
			String bank_tran_id, String bank_tran_date, String bank_code_tran, String bank_rsp_code,
			String bank_rsp_message) {
		super();
		this.api_tran_id = api_tran_id;
		this.api_tran_dtm = api_tran_dtm;
		this.rsp_code = rsp_code;
		this.rsp_message = rsp_message;
		this.bank_tran_id = bank_tran_id;
		this.bank_tran_date = bank_tran_date;
		this.bank_code_tran = bank_code_tran;
		this.bank_rsp_code = bank_rsp_code;
		this.bank_rsp_message = bank_rsp_message;
	}

}
