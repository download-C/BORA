package com.bora.domain.openbank;

import java.util.List;

//2.3.2. 거래내역조회
public class AccountTranResponseVO {
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
	private List<TranVO> tran_res_list; //사용자 등록계좌 목록
	////////추가
	
	private String tran_date; //거래일자
	private String tran_time; //거래시간
	private String inout_type; //입출금구분주4) (입금, 출금, 지급, 기타)_입출금구분이 ‘기타’인 경우에는 ‘거래금액’이 0원으로 세팅됨
	private String tran_type; //현금, 대체, 급여, 타행환, F/B출금 등 (참가은행에서 직접 세팅)
	private String print_content; //"통장인자내용"
	private String tran_amt; //거래금액
	private String after_balance_amt; //거래후잔액(-금액가능)
	private String branch_name;  //거래점명
	
	
	
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
	public List<TranVO> getTran_res_list() {
		return tran_res_list;
	}
	public void setTran_res_list(List<TranVO> tran_res_list) {
		this.tran_res_list = tran_res_list;
	}
	public String getTran_date() {
		return tran_date;
	}
	public void setTran_date(String tran_date) {
		this.tran_date = tran_date;
	}
	public String getTran_time() {
		return tran_time;
	}
	public void setTran_time(String tran_time) {
		this.tran_time = tran_time;
	}
	public String getInout_type() {
		return inout_type;
	}
	public void setInout_type(String inout_type) {
		this.inout_type = inout_type;
	}
	public String getTran_type() {
		return tran_type;
	}
	public void setTran_type(String tran_type) {
		this.tran_type = tran_type;
	}
	public String getPrint_content() {
		return print_content;
	}
	public void setPrint_content(String print_content) {
		this.print_content = print_content;
	}
	public String getTran_amt() {
		return tran_amt;
	}
	public void setTran_amt(String tran_amt) {
		this.tran_amt = tran_amt;
	}
	public String getAfter_balance_amt() {
		return after_balance_amt;
	}
	public void setAfter_balance_amt(String after_balance_amt) {
		this.after_balance_amt = after_balance_amt;
	}
	public String getBranch_name() {
		return branch_name;
	}
	public void setBranch_name(String branch_name) {
		this.branch_name = branch_name;
	}
	
	
}
