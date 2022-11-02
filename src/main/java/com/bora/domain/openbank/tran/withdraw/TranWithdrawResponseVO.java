package com.bora.domain.openbank;

import java.util.List;

import lombok.Data;

//2.5.1. 출금이체 API 응답 데이터
@Data
public class TranWithdrawResponseVO {
	private String api_tran_id; //거래고유번호(API)
	private String api_tran_dtm; //거래일시(밀리세컨드)
	private String rsp_code; //응답코드(API)
	private String rsp_message; //응답메시지(API)
	private String dps_bank_code_std; //입금기관.표준코드
	private String dps_bank_code_sub; //입금기관.점별코드
	private String dps_bank_name; //"오픈은행" 입금기관명
	private String dps_account_num_masked; //"000-1230000-***" 입금계좌번호(출력용)
	private String dps_print_content; //입금계좌인자내역
	private String dps_account_holder_name; //수취인성명
	private String bank_tran_id; //"F123456789U4BC34239Z" 거래고유번호(참가은행)
	private String bank_tran_date; //"20190910" 거래일자(참가은행)
	private String bank_code_tran; //"097" 응답코드를 부여한 참가은행.표준코드
	private String bank_rsp_code; //"000" 응답코드(참가은행)
	private String bank_rsp_message; //""응답메시지(참가은행)
	private String account_num; //"1101230000678" 출금계좌번호
	private String account_alias; //"급여계좌" 출금계좌별명(Alias)
	private String bank_code_std; //"097" 출금(개설)기관.표준코드
	private String bank_code_sub; //"1230001" 출금(개설)기관.점별코드
	private String bank_name; //"오픈은행" 출금(개설)기관명
	private String savings_bank_name; //“오픈저축은행” 개별저축은행명주1)
	private String account_num_masked; //"000-1230000-***" 출금계좌번호(출력용)
	private String print_content; //출금계좌인자내역
	private String account_holder_name; //송금인성명
	private String tran_amt; //"10000" 거래금액
	private String wd_limit_remain_amt; //"9990000" 출금한도잔여금액주2)
	
	public TranWithdrawResponseVO () {}
	
	public TranWithdrawResponseVO(String api_tran_id, String api_tran_dtm, String rsp_code, String rsp_message,
			String dps_bank_code_std, String dps_bank_code_sub, String dps_bank_name, String dps_account_num_masked,
			String dps_print_content, String dps_account_holder_name, String bank_tran_id, String bank_tran_date,
			String bank_code_tran, String bank_rsp_code, String bank_rsp_message, String account_num,
			String account_alias, String bank_code_std, String bank_code_sub, String bank_name,
			String savings_bank_name, String account_num_masked, String print_content, String account_holder_name,
			String tran_amt, String wd_limit_remain_amt) {
		super();
		this.api_tran_id = api_tran_id;
		this.api_tran_dtm = api_tran_dtm;
		this.rsp_code = rsp_code;
		this.rsp_message = rsp_message;
		this.dps_bank_code_std = dps_bank_code_std;
		this.dps_bank_code_sub = dps_bank_code_sub;
		this.dps_bank_name = dps_bank_name;
		this.dps_account_num_masked = dps_account_num_masked;
		this.dps_print_content = dps_print_content;
		this.dps_account_holder_name = dps_account_holder_name;
		this.bank_tran_id = bank_tran_id;
		this.bank_tran_date = bank_tran_date;
		this.bank_code_tran = bank_code_tran;
		this.bank_rsp_code = bank_rsp_code;
		this.bank_rsp_message = bank_rsp_message;
		this.account_num = account_num;
		this.account_alias = account_alias;
		this.bank_code_std = bank_code_std;
		this.bank_code_sub = bank_code_sub;
		this.bank_name = bank_name;
		this.savings_bank_name = savings_bank_name;
		this.account_num_masked = account_num_masked;
		this.print_content = print_content;
		this.account_holder_name = account_holder_name;
		this.tran_amt = tran_amt;
		this.wd_limit_remain_amt = wd_limit_remain_amt;
	}
	
	@Override
	public String toString() {
		return "TranWithdrawResponseVO [api_tran_id=" + api_tran_id + ", api_tran_dtm=" + api_tran_dtm + ", rsp_code="
				+ rsp_code + ", rsp_message=" + rsp_message + ", dps_bank_code_std=" + dps_bank_code_std
				+ ", dps_bank_code_sub=" + dps_bank_code_sub + ", dps_bank_name=" + dps_bank_name
				+ ", dps_account_num_masked=" + dps_account_num_masked + ", dps_print_content=" + dps_print_content
				+ ", dps_account_holder_name=" + dps_account_holder_name + ", bank_tran_id=" + bank_tran_id
				+ ", bank_tran_date=" + bank_tran_date + ", bank_code_tran=" + bank_code_tran + ", bank_rsp_code="
				+ bank_rsp_code + ", bank_rsp_message=" + bank_rsp_message + ", account_num=" + account_num
				+ ", account_alias=" + account_alias + ", bank_code_std=" + bank_code_std + ", bank_code_sub="
				+ bank_code_sub + ", bank_name=" + bank_name + ", savings_bank_name=" + savings_bank_name
				+ ", account_num_masked=" + account_num_masked + ", print_content=" + print_content
				+ ", account_holder_name=" + account_holder_name + ", tran_amt=" + tran_amt + ", wd_limit_remain_amt="
				+ wd_limit_remain_amt + "]";
	}
	
	
}
