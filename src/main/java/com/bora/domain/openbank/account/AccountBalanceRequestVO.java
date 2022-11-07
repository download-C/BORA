package com.bora.domain.openbank.account;

import java.io.IOException;
import java.util.Random;

import lombok.Data;

// 2.3.1. 잔액조회 API 요청 데이터
@Data
public class AccountBalanceRequestVO {
    private String access_token;
    //////////////////// bank_tran_id U 뒤에 9자리 세션값마다 자동으로 난수값 들어가도록 설정 필요
//    private String bank_tran_id = "M202202092U823456781"; //은행거래고유번호
    private String bank_tran_id; //은행거래고유번호
//    private String fintech_use_num; //핀테크이용번호
    private String fintech_use_num = "120220209288941286327192"; //핀테크이용번호
    private String tran_dtime; //요청일시
    private String model;
    
	public void main(String[] args) throws IOException  {	
		Random random = new Random();
		random.setSeed(System.currentTimeMillis()); //시드값 설정을 따로 할수도 있음
		long val = random.nextInt(1000000000);
		bank_tran_id = "M202202092U"+String.valueOf(val);
		System.out.println("난수발생 bank_tran_id : "+bank_tran_id);
	}
    
	private String bank_bran_id() {
		Random random = new Random();
		random.setSeed(System.currentTimeMillis());
		long val = random.nextInt(1000000000);
		return bank_tran_id = "M202202092U"+String.valueOf(val);
	}
    
    public AccountBalanceRequestVO() {}

	public AccountBalanceRequestVO(String access_token, String bank_tran_id, String fintech_use_num, String tran_dtime,
			String model) {
		super();
		this.access_token = access_token;
		this.bank_tran_id = bank_tran_id;
		this.fintech_use_num = fintech_use_num;
		this.tran_dtime = tran_dtime;
		this.model = model;
	}
	
}


