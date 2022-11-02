package com.bora.domain.openbank.tran.result;

import lombok.Data;

//2.5.3. 이체결과조회 API
//private List<TranResultReqListVO> tranResult_res_list; //이체결과 이체목록
@Data
public class TranResultResListVO {
	private String tran_no; //"1" 거래순번
	private String bank_tran_id; //"12345678901234567890" 거래고유번호(참가은행)
	private String bank_tran_date; //"20190910" 거래일자(참가은행)
	private String bank_code_tran; //"097" 응답코드를 부여한 참가은행.표준코드
	private String bank_rsp_code; //"000" 응답코드(참가은행)
	private String bank_rsp_message; //"" 응답메시지(참가은행)
	private String wd_bank_code_std; //"097" 출금기관.표준코드
	private String wd_bank_code_sub; //"1230001" 출금기관.점별코드
	private String wd_bank_name; //"오픈은행" 출금기관명
	private String wd_savings_bank_name; //“오픈저축은행” 개별(출금)저축은행명주1)
	private String wd_fintech_use_num; //"123456789012345678901234" 출금계좌 핀테크이용번호주3)
	private String wd_account_num_masked; //"000-1230000-***" 출금계좌번호(출력용)
	private String wd_print_content; //"환불금액" 출금계좌인자내역
	private String wd_account_holder_name;// 송금인성명
	private String dps_bank_code_std; //"097" 입금(개설)기관.표준코드
	private String dps_bank_code_sub; //"1230001" 입금(개설)기관.점별코드
	private String dps_bank_name; //"오픈은행" 입금(개설)기관명
	private String dps_savings_bank_name; //“오픈저축은행” 개별(입금)저축은행명주2)
	private String dps_fintech_use_num; //"123456789012345678901234" 입금계좌 핀테크이용번호주3)
	private String dps_account_num_masked; //"000-1230000-***" 입금계좌번호(출력용)
	private String dps_print_content; //"쇼핑몰환불" 입금계좌인자내역
	private String dps_account_holder_name; //수취인성명
	private String tran_amt; //"10000" 거래금액
	
	public TranResultResListVO() {}
	
	public TranResultResListVO(String tran_no, String bank_tran_id, String bank_tran_date, String bank_code_tran,
			String bank_rsp_code, String bank_rsp_message, String wd_bank_code_std, String wd_bank_code_sub,
			String wd_bank_name, String wd_savings_bank_name, String wd_fintech_use_num, String wd_account_num_masked,
			String wd_print_content, String wd_account_holder_name, String dps_bank_code_std, String dps_bank_code_sub,
			String dps_bank_name, String dps_savings_bank_name, String dps_fintech_use_num,
			String dps_account_num_masked, String dps_print_content, String dps_account_holder_name, String tran_amt) {
		super();
		this.tran_no = tran_no;
		this.bank_tran_id = bank_tran_id;
		this.bank_tran_date = bank_tran_date;
		this.bank_code_tran = bank_code_tran;
		this.bank_rsp_code = bank_rsp_code;
		this.bank_rsp_message = bank_rsp_message;
		this.wd_bank_code_std = wd_bank_code_std;
		this.wd_bank_code_sub = wd_bank_code_sub;
		this.wd_bank_name = wd_bank_name;
		this.wd_savings_bank_name = wd_savings_bank_name;
		this.wd_fintech_use_num = wd_fintech_use_num;
		this.wd_account_num_masked = wd_account_num_masked;
		this.wd_print_content = wd_print_content;
		this.wd_account_holder_name = wd_account_holder_name;
		this.dps_bank_code_std = dps_bank_code_std;
		this.dps_bank_code_sub = dps_bank_code_sub;
		this.dps_bank_name = dps_bank_name;
		this.dps_savings_bank_name = dps_savings_bank_name;
		this.dps_fintech_use_num = dps_fintech_use_num;
		this.dps_account_num_masked = dps_account_num_masked;
		this.dps_print_content = dps_print_content;
		this.dps_account_holder_name = dps_account_holder_name;
		this.tran_amt = tran_amt;
	}
	
	

}
