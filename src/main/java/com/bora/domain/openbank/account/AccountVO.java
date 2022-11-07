package com.bora.domain.openbank.account;

import lombok.Data;

// 2.2 사용자/계좌 관리에서 사용되는 계좌 정보(배열로 전달된 데이터)
@Data
public class AccountVO {
	private String fintech_use_num; //핀테크이용번호
    private String account_alias; //계좌별명
    private String bank_code_std; //출금(개설)기관.표준코드
    private String bank_code_sub; //출금(개설)기관.점별코드
    private String bank_name; //출금(개설)기관명
    private String savings_bank_name; //개별저축은행명주1)
    private String account_num; //계좌번호주4)
    private String account_num_masked; //마스킹된 출력용 계좌번호
    private String account_seq; //회차번호주2) 주4)
    private String account_holder_name; //계좌예금주명
    private String account_holder_type; //계좌구분(P:개인)
    private String account_type; //계좌종류주3) 1:수시입출금, 2:예적금 6:수익증권, T:종합계좌
    private String inquiry_agree_yn; //조회서비스 동의여부
    private String inquiry_agree_dtime; //조회서비스 동의일시
    private String transfer_agree_yn; //출금서비스 동의여부
    private String transfer_agree_dtime; //출금서비스 동의일시
    private String account_state; //납부번호
    
    public AccountVO () {}
    
	
	public AccountVO(String fintech_use_num, String account_alias, String bank_code_std, String bank_code_sub,
			String bank_name, String savings_bank_name, String account_num, String account_num_masked,
			String account_seq, String account_holder_name, String account_holder_type, String account_type,
			String inquiry_agree_yn, String inquiry_agree_dtime, String transfer_agree_yn, String transfer_agree_dtime,
			String account_state) {
		super();
		this.fintech_use_num = fintech_use_num;
		this.account_alias = account_alias;
		this.bank_code_std = bank_code_std;
		this.bank_code_sub = bank_code_sub;
		this.bank_name = bank_name;
		this.savings_bank_name = savings_bank_name;
		this.account_num = account_num;
		this.account_num_masked = account_num_masked;
		this.account_seq = account_seq;
		this.account_holder_name = account_holder_name;
		this.account_holder_type = account_holder_type;
		this.account_type = account_type;
		this.inquiry_agree_yn = inquiry_agree_yn;
		this.inquiry_agree_dtime = inquiry_agree_dtime;
		this.transfer_agree_yn = transfer_agree_yn;
		this.transfer_agree_dtime = transfer_agree_dtime;
		this.account_state = account_state;
	}
    
	
	
}
