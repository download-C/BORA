package com.bora.domain.openbank.account;

import java.util.Random;

import lombok.Data;

//2.3.2. 거래내역조회
@Data
public class AccountTranRequestVO {
	
    // bank_tran_id U 뒤에 9자리 세션값마다 자동으로 난수값 들어가도록 설정 필요
    private String access_token;
	private String bank_tran_id; //은행거래고유번호
//    private String bank_tran_id= "M202202178U"+ (int)((Math.random()+1)*100000000);
//    private String fintech_use_num = "120220217888941294172171"; //핀테크이용번호
    private String fintech_use_num; //핀테크이용번호
	private String inquiry_type; //조회구분코드 A:All, I:입금, O:출금
	private String inquiry_base; //조회기준코드주 D:일자, T:시간
	private String from_date; //조회시작일자
	private String to_date; //조회종료일자
	private String sort_order; //정렬순서 D:Descending  A:Ascending
	private String tran_dtime; //요청일시
    private String model;
	
//    public String getBank_tran_id() {
//    	Random random = new Random();
////    	random.setSeed(System.currentTimeMillis());
//    	long val = random.nextInt(1000000000)+1;
//    	return "M202202178U"+String.valueOf(val);
//	}
    
    public String getBank_tran_id() {
    	return "M202202178U"+ (int)((Math.random()+1)*100000000);
	}

    public AccountTranRequestVO() {}

	@Override
	public String toString() {
		return "AccountTranRequestVO [access_token=" + access_token + ", bank_tran_id=" + bank_tran_id
				+ ", fintech_use_num=" + fintech_use_num + ", inquiry_type=" + inquiry_type + ", inquiry_base="
				+ inquiry_base + ", from_date=" + from_date + ", to_date=" + to_date + ", sort_order=" + sort_order
				+ ", tran_dtime=" + tran_dtime + ", model=" + model + "]";
	}

    
    
}
