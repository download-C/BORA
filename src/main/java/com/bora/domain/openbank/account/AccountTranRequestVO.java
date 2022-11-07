package com.bora.domain.openbank.account;

import java.io.IOException;
import java.util.Random;

import javax.imageio.IIOException;

import lombok.Data;

//2.3.2. 거래내역조회
@Data
public class AccountTranRequestVO {
	
	//////////// bank_tran_id U 뒤에 9자리 세션값마다 자동으로 난수값 들어가도록 설정 필요
    private String access_token;
//	private String bank_tran_id = "M202202092U121444111"; //은행거래고유번호
	private String bank_tran_id; //은행거래고유번호
    private String fintech_use_num = "120220209288941286327192"; //핀테크이용번호
	private String inquiry_type; //조회구분코드 A:All, I:입금, O:출금
	private String inquiry_base; //조회기준코드주 D:일자, T:시간
	private String from_date; //조회시작일자
	private String to_date; //조회종료일자
	private String sort_order; //정렬순서 D:Descending  A:Ascending
	private String tran_dtime; //요청일시
	
//	public void bank_tran_id() {
//		Random random = new Random();
//		random.setSeed(System.currentTimeMillis());
//		long val = random.nextInt(1000000000);
//		String bank_tran_id = "M202202092U"+String.valueOf(val);
//		
//	}
	

	public AccountTranRequestVO() {}

	public AccountTranRequestVO(String access_token, String bank_tran_id, String fintech_use_num, String inquiry_type,
			String inquiry_base, String from_date, String to_date, String sort_order, String tran_dtime) {
		super();
		this.access_token = access_token;
		this.bank_tran_id = bank_tran_id;
		this.fintech_use_num = fintech_use_num;
		this.inquiry_type = inquiry_type;
		this.inquiry_base = inquiry_base;
		this.from_date = from_date;
		this.to_date = to_date;
		this.sort_order = sort_order;
		this.tran_dtime = tran_dtime;
	}
	
}
