package com.bora.domain.openbank;

import java.util.List;

//2.3.1. 잔액조회 API 요청 데이터
public class AccountBalanceResponseVO {
	private String api_tran_id; //거래고유번호(API)
	private String api_tran_dtm; //거래일시(밀리세컨드)
	private String rsp_code; //응답코드(API)
	private String rsp_message; //응답메세지
	private String bank_tran_id; //거래고유번호(참가은행)
	private String bank_tran_date; //거래일자(참가은행)
	private String bank_code_tran; //응답코드를 부여한 참가은행.표준코드
	private String bank_rsp_code; //응답코드(참가은행)
	private String bank_rsp_message; //응답메시지(참가은행)	
	private String bank_name; //출금(개설)기관명
	private String fintech_use_num; //핀테크이용번호
	
	private String balance_amt; //계좌잔액(-금액가능)
	private String available_amt; //출금가능금액
//	private String acct_type; //계좌종류 1:수시입출금, 2:예적금, 6:수익증권, T:종합계좌
	//계좌종류는 2020.12월(실시예정)부터 등록하는 계좌에 대해 추가로 제공하는 정보로, 그 이전에 등록된 계좌에 대해서는 해당 정보가 제공되지 않을 수 있음.
	private String product_name; //상품명 "내맘대로통장"	
	private String account_issue_date; //계좌개설일
	private String maturity_date; //만기일 만기일이 있는 상품에 대하여 제공됨
	private String last_tran_date; //최종거래일
	
	
	public String getApi_tran_id() {
		return api_tran_id;
	}
	public void setApi_tran_id(String api_tran_id) {
		this.api_tran_id = api_tran_id;
	}
	public String getApi_tran_dtm() {
		return api_tran_dtm;
	}
	public void setApi_tran_dtm(String api_tran_dtm) {
		this.api_tran_dtm = api_tran_dtm;
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
	public String getBank_tran_id() {
		return bank_tran_id;
	}
	public void setBank_tran_id(String bank_tran_id) {
		this.bank_tran_id = bank_tran_id;
	}
	public String getBank_tran_date() {
		return bank_tran_date;
	}
	public void setBank_tran_date(String bank_tran_date) {
		this.bank_tran_date = bank_tran_date;
	}
	public String getBank_code_tran() {
		return bank_code_tran;
	}
	public void setBank_code_tran(String bank_code_tran) {
		this.bank_code_tran = bank_code_tran;
	}
	public String getBank_rsp_code() {
		return bank_rsp_code;
	}
	public void setBank_rsp_code(String bank_rsp_code) {
		this.bank_rsp_code = bank_rsp_code;
	}
	public String getBank_rsp_message() {
		return bank_rsp_message;
	}
	public void setBank_rsp_message(String bank_rsp_message) {
		this.bank_rsp_message = bank_rsp_message;
	}
	public String getBank_name() {
		return bank_name;
	}
	public void setBank_name(String bank_name) {
		this.bank_name = bank_name;
	}
	public String getFintech_use_num() {
		return fintech_use_num;
	}
	public void setFintech_use_num(String fintech_use_num) {
		this.fintech_use_num = fintech_use_num;
	}
	public String getBalance_amt() {
		return balance_amt;
	}
	public void setBalance_amt(String balance_amt) {
		this.balance_amt = balance_amt;
	}
	public String getAvailable_amt() {
		return available_amt;
	}
	public void setAvailable_amt(String available_amt) {
		this.available_amt = available_amt;
	}
	public String getProduct_name() {
		return product_name;
	}
	public void setProduct_name(String product_name) {
		this.product_name = product_name;
	}
	public String getAccount_issue_date() {
		return account_issue_date;
	}
	public void setAccount_issue_date(String account_issue_date) {
		this.account_issue_date = account_issue_date;
	}
	public String getMaturity_date() {
		return maturity_date;
	}
	public void setMaturity_date(String maturity_date) {
		this.maturity_date = maturity_date;
	}
	public String getLast_tran_date() {
		return last_tran_date;
	}
	public void setLast_tran_date(String last_tran_date) {
		this.last_tran_date = last_tran_date;
	}
	
	
	
	
	
}
