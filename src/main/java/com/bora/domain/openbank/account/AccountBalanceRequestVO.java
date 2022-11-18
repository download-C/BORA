package com.bora.domain.openbank.account;

import java.io.IOException;
import java.util.Random;

import lombok.Data;

// 2.3.1. 잔액조회 API 요청 데이터
@Data
public class AccountBalanceRequestVO {
    private String access_token;
    // bank_tran_id U 뒤에 9자리 세션값마다 자동으로 난수값 들어가도록 설정 필요
//    private String bank_tran_id; //은행거래고유번호
    private String bank_tran_id= "M202202178U"+ (int)((Math.random()+1)*100000000);
//    private String fintech_use_num = "120220217888941294172171"; //핀테크이용번호
    private String fintech_use_num; //핀테크이용번호
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

	public AccountBalanceRequestVO() {}


	@Override
	public String toString() {
		return "AccountBalanceRequestVO [access_token=" + access_token + ", bank_tran_id=" + bank_tran_id
				+ ", fintech_use_num=" + fintech_use_num + ", tran_dtime=" + tran_dtime + ", model=" + model + "]";
	}

//	public AccountBalanceRequestVO(String access_token, String bank_tran_id, String fintech_use_num, String tran_dtime,
//			String model) {
//		super();
//		this.access_token = access_token;
//		this.bank_tran_id = getBank_tran_id();
//		this.fintech_use_num = fintech_use_num;
//		this.tran_dtime = tran_dtime;
//		this.model = model;
//	}



}
