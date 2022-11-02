package com.bora.domain.openbank.account;

import java.util.List;

import com.bora.domain.openbank.tran.TranVO;

import lombok.Data;

//2.3.2. 거래내역조회
@Data
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
	
	public AccountTranResponseVO() {}
	
	public AccountTranResponseVO(String api_tran_id, String api_tran_dtm, String rsp_code, String rsp_message,
			String bank_tran_id, String bank_tran_date, String bank_code_tran, String bank_rsp_code,
			String bank_rsp_message, String bank_name, String fintech_use_num, String balance_amt,
			List<TranVO> tran_res_list) {
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
		this.bank_name = bank_name;
		this.fintech_use_num = fintech_use_num;
		this.balance_amt = balance_amt;
		this.tran_res_list = tran_res_list;
	}
	@Override
	public String toString() {
		return "AccountTranResponseVO [api_tran_id=" + api_tran_id + ", api_tran_dtm=" + api_tran_dtm + ", rsp_code="
				+ rsp_code + ", rsp_message=" + rsp_message + ", bank_tran_id=" + bank_tran_id + ", bank_tran_date="
				+ bank_tran_date + ", bank_code_tran=" + bank_code_tran + ", bank_rsp_code=" + bank_rsp_code
				+ ", bank_rsp_message=" + bank_rsp_message + ", bank_name=" + bank_name + ", fintech_use_num="
				+ fintech_use_num + ", balance_amt=" + balance_amt + ", tran_res_list=" + tran_res_list + "]";
	}
	
	
}
