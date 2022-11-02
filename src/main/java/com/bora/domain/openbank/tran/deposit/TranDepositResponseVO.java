package com.bora.domain.openbank;

import java.util.List;

import lombok.Data;

//2.5.2. 입금이체 API
@Data
public class TranDepositResponseVO {
	private String api_tran_id; //"2ffd133a-d17a-431d-a6a5" 거래고유번호(API)
	private String api_tran_dtm; //"20190910101921567" 거래일시(밀리세컨드)
	private String rsp_code; //"A0000" 응답코드(API)
	private String rsp_message; //응답메시지(API)
	private String wd_bank_code_std; //"097" 출금기관.표준코드
	private String wd_bank_code_sub; //"1230001" 출금기관.점별코드
	private String wd_bank_name; //"오픈은행" 출금기관명
	private String wd_account_num_masked; //"000-1230000-***" 출금계좌번호(출력용)
	private String wd_print_content; //"환불금액" 출금계좌인자내역
	private String wd_account_holder_name; //"허균" 송금인성명
	private String res_cnt; //"1" 입금건수
	private List<TranDepositResListVO> de_res_list; //입금목록
	
	public TranDepositResponseVO() {}
	
	public TranDepositResponseVO(String api_tran_id, String api_tran_dtm, String rsp_code, String rsp_message,
			String wd_bank_code_std, String wd_bank_code_sub, String wd_bank_name, String wd_account_num_masked,
			String wd_print_content, String wd_account_holder_name, String res_cnt,
			List<TranDepositResListVO> de_res_list) {
		super();
		this.api_tran_id = api_tran_id;
		this.api_tran_dtm = api_tran_dtm;
		this.rsp_code = rsp_code;
		this.rsp_message = rsp_message;
		this.wd_bank_code_std = wd_bank_code_std;
		this.wd_bank_code_sub = wd_bank_code_sub;
		this.wd_bank_name = wd_bank_name;
		this.wd_account_num_masked = wd_account_num_masked;
		this.wd_print_content = wd_print_content;
		this.wd_account_holder_name = wd_account_holder_name;
		this.res_cnt = res_cnt;
		this.de_res_list = de_res_list;
	}

	
	
}