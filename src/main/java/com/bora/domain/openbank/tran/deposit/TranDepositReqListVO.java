package com.bora.domain.openbank;

import lombok.Data;

//2.5.2. 입금이체 API (TranWithdrawRequestVO)에 private List<TranDepositReqListVO> de_req_list; //입금요청목록
@Data
public class TranDepositReqListVO {
	private String tran_no; //"1" 거래순번
	private String bank_tran_id; //"F123456789U4BC34239Z" 은행거래고유번호주5)
	private String fintech_use_num; //"123456789012345678901234" 핀테크이용번호
	private String print_content; //"쇼핑몰환불" 입금계좌인자내역
	private String tran_amt; //"10000" 거래금액
	private String req_client_name; //“홍길동” 요청고객성명주6)
	private String req_client_num; //“HONGGILDONG1234” 요청고객회원번호주6)
	private String transfer_purpose; //“TR” 이체용도주7) TR:송금, ST:결제, AU:인증
	
	public TranDepositReqListVO () {}
	
	public TranDepositReqListVO(String tran_no, String bank_tran_id, String fintech_use_num, String print_content,
			String tran_amt, String req_client_name, String req_client_num, String transfer_purpose) {
		super();
		this.tran_no = tran_no;
		this.bank_tran_id = bank_tran_id;
		this.fintech_use_num = fintech_use_num;
		this.print_content = print_content;
		this.tran_amt = tran_amt;
		this.req_client_name = req_client_name;
		this.req_client_num = req_client_num;
		this.transfer_purpose = transfer_purpose;
	}
	
	
}
