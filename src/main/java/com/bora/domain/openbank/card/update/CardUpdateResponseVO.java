package com.bora.domain.openbank.card.update;

import lombok.Data;

@Data
public class CardUpdateResponseVO {
	private String api_tran_id; // 거래고유번호(API)
	private String api_tran_dtm; // 거래일시(밀리세컨드)
	private String rsp_code; //응답코드(API)
	private String rsp_message; //응답메시지(API)
	private String bank_tran_id; // 거래고유번호(참가기관)	
	private String bank_tran_date; // 거래일자(참가기관)
	private String bank_code_tran; // 응답코드를 부여한 참가기관 표준 코드
	private String bank_rsp_code; // 응답코드(참가기관)
	private String bank_rsp_message; // 응답메시지(참가기관)
	private String bank_name; // 카드 개설기관명
	private String user_seq_no; // 사용자일련번호
	private String update_user_email; // 변경된 이메일주소

	public CardUpdateResponseVO() {}
	
	public CardUpdateResponseVO(String api_tran_id, String api_tran_dtm, String rsp_code, String rsp_message,
			String bank_tran_id, String bank_tran_date, String bank_code_tran, String bank_rsp_code,
			String bank_rsp_message, String bank_name, String user_seq_no, String update_user_email) {
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
		this.user_seq_no = user_seq_no;
		this.update_user_email = update_user_email;
	}

	@Override
	public String toString() {
		return "CardUpdateResponseVO [api_tran_id=" + api_tran_id + ", api_tran_dtm=" + api_tran_dtm + ", rsp_code="
				+ rsp_code + ", rsp_message=" + rsp_message + ", bank_tran_id=" + bank_tran_id + ", bank_tran_date="
				+ bank_tran_date + ", bank_code_tran=" + bank_code_tran + ", bank_rsp_code=" + bank_rsp_code
				+ ", bank_rsp_message=" + bank_rsp_message + ", bank_name=" + bank_name + ", user_seq_no=" + user_seq_no
				+ ", update_user_email=" + update_user_email + "]";
	}
	
    
}
