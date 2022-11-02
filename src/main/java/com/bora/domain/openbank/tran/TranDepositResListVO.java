package com.bora.domain.openbank.tran;

import lombok.Data;

//2.5.2. 입금이체 API (TranWithdrawResponseVO)에 private List<TranDepositResListVO> de_req_list; //입금요청목록
@Data
public class TranDepositResListVO {
	private String tran_no; //"1" 거래순번
	private String bank_tran_id; //"F123456789U4BC34239Z" 거래고유번호(참가은행)
	private String bank_tran_date; //"20190910" 거래일자(참가은행)
	private String bank_code_tran; //"097" 응답코드를 부여한 참가은행.표준코드
	private String bank_rsp_code; //"000" 응답코드(참가은행)
	private String bank_rsp_message; //응답메시지(참가은행)
	private String fintech_use_num; //"123456789012345678901234" 핀테크이용번호
	private String account_alias; //"급여계좌" 계좌별명(Alias)
	private String bank_code_std; //"097"	 입금(개설)기관.표준코드
	private String bank_code_sub; //"1230001" 입금(개설)기관.점별코드
	private String bank_name; //"오픈은행" 입금(개설)기관명
	private String savings_bank_name; //“오픈저축은행” 개별저축은행명주1)
	private String account_num_masked; //"000-1230000-***" 입금계좌번호(출력용)
	private String print_content; //"쇼핑몰환불 입금계좌인자내역
	private String account_holder_name; //"홍길동" 수취인성명
	private String tran_amt; //"10000" 거래금액
	private String cms_num; //“93848103221” CMS 번호
	
	public TranDepositResListVO() {}
	
	public TranDepositResListVO(String tran_no, String bank_tran_id, String bank_tran_date, String bank_code_tran,
			String bank_rsp_code, String bank_rsp_message, String fintech_use_num, String account_alias,
			String bank_code_std, String bank_code_sub, String bank_name, String savings_bank_name,
			String account_num_masked, String print_content, String account_holder_name, String tran_amt,
			String cms_num) {
		super();
		this.tran_no = tran_no;
		this.bank_tran_id = bank_tran_id;
		this.bank_tran_date = bank_tran_date;
		this.bank_code_tran = bank_code_tran;
		this.bank_rsp_code = bank_rsp_code;
		this.bank_rsp_message = bank_rsp_message;
		this.fintech_use_num = fintech_use_num;
		this.account_alias = account_alias;
		this.bank_code_std = bank_code_std;
		this.bank_code_sub = bank_code_sub;
		this.bank_name = bank_name;
		this.savings_bank_name = savings_bank_name;
		this.account_num_masked = account_num_masked;
		this.print_content = print_content;
		this.account_holder_name = account_holder_name;
		this.tran_amt = tran_amt;
		this.cms_num = cms_num;
	}
	
	
	
	
}