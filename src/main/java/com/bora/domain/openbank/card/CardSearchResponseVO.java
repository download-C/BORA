package com.bora.domain.openbank.card;

import lombok.Data;

@Data
public class CardSearchResponseVO {
	private String api_tran_id; // 거래고유번호(API)
	private String api_tran_dtm; // 거래일시(밀리세컨드)
	private String rsp_code; //응답코드(API)
	private String rsp_message; //응답메시지(API)
	private String bank_tran_id; // 거래고유번호(참가기관)	
	private String bank_tran_date; // 거래일자(참가기관)
	private String bank_code_tran; // 응답코드를 부여한 참가기관 표준 코드
	private String bank_rsp_code; // 응답코드(참가기관)
	private String bank_rsp_message; // 응답메시지(참가기관)
	private String code_type; // 카드 구분
	private String settlement_bank_code; // 결제은행 대표코드
	private String settlement_account_num; // 결제 계좌번호
	private String settlement_account_num_masked; // 마스킹된 출력용 결제 계좌번호
	private String issue_date; // 카드 발급일자(YYYYMMDD)
	
	public CardSearchResponseVO() {}
	
	public CardSearchResponseVO(String api_tran_id, String api_tran_dtm, String rsp_code, String rsp_message,
			String bank_tran_id, String bank_tran_date, String bank_code_tran, String bank_rsp_code,
			String bank_rsp_message, String code_type, String settlement_bank_code, String settlement_account_num,
			String settlement_account_num_masked, String issue_date) {
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
		this.code_type = code_type;
		this.settlement_bank_code = settlement_bank_code;
		this.settlement_account_num = settlement_account_num;
		this.settlement_account_num_masked = settlement_account_num_masked;
		this.issue_date = issue_date;
	}

	@Override
	public String toString() {
		return "CardSearchResponseVO [api_tran_id=" + api_tran_id + ", api_tran_dtm=" + api_tran_dtm + ", rsp_code="
				+ rsp_code + ", rsp_message=" + rsp_message + ", bank_tran_id=" + bank_tran_id + ", bank_tran_date="
				+ bank_tran_date + ", bank_code_tran=" + bank_code_tran + ", bank_rsp_code=" + bank_rsp_code
				+ ", bank_rsp_message=" + bank_rsp_message + ", code_type=" + code_type + ", settlement_bank_code="
				+ settlement_bank_code + ", settlement_account_num=" + settlement_account_num
				+ ", settlement_account_num_masked=" + settlement_account_num_masked + ", issue_date=" + issue_date
				+ "]";
	}
	
	

}
