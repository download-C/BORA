package com.bora.domain.openbank;

import lombok.Data;

// 2.5.1. 출금이체 API 요청 데이터
@Data
public class TranWithdrawRequestVO {
    private String access_token;
    private String bank_tran_id; //은행거래고유번호주1)
    private String cntr_account_type; //약정 계좌/계정 구분주2) N:계좌, C:계정
    private String cntr_account_num; //약정 계좌/계정 번호주2)
    private String dps_print_content; // "쇼핑몰환불" 입금계좌인자내역
    private String fintech_use_num; //출금계좌핀테크이용번호
    private String tran_amt; //거래금액
    private String tran_dtime; //요청일시
    private String req_client_name; //요청고객성명주4)
    private String req_client_num; //“HONGGILDONG1234”  요청고객회원번호주4)
    private String transfer_purpose; //이체용도주5) TR:송금, ST:결제, RC:충전
    
	@Override
	public String toString() {
		return "TranWithdrawRequestVO [access_token=" + access_token + ", bank_tran_id=" + bank_tran_id
				+ ", cntr_account_type=" + cntr_account_type + ", cntr_account_num=" + cntr_account_num
				+ ", dps_print_content=" + dps_print_content + ", fintech_use_num=" + fintech_use_num + ", tran_amt="
				+ tran_amt + ", tran_dtime=" + tran_dtime + ", req_client_name=" + req_client_name + ", req_client_num="
				+ req_client_num + ", transfer_purpose=" + transfer_purpose + "]";
	}
	
	public TranWithdrawRequestVO(String access_token, String bank_tran_id, String cntr_account_type,
			String cntr_account_num, String dps_print_content, String fintech_use_num, String tran_amt,
			String tran_dtime, String req_client_name, String req_client_num, String transfer_purpose) {
		super();
		this.access_token = access_token;
		this.bank_tran_id = bank_tran_id;
		this.cntr_account_type = cntr_account_type;
		this.cntr_account_num = cntr_account_num;
		this.dps_print_content = dps_print_content;
		this.fintech_use_num = fintech_use_num;
		this.tran_amt = tran_amt;
		this.tran_dtime = tran_dtime;
		this.req_client_name = req_client_name;
		this.req_client_num = req_client_num;
		this.transfer_purpose = transfer_purpose;
	}

}
