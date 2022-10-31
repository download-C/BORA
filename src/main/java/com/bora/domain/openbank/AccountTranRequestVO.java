package com.bora.domain.openbank;

import lombok.Data;

//2.3.2. 거래내역조회
@Data
public class AccountTranRequestVO {
	private String bank_tran_id; //은행거래고유번호
	private String fintech_use_num; //핀테크이용번호
	private String inquiry_type; //조회구분코드 A:All, I:입금, O:출금
	private String inquiry_base; //조회기준코드주 D:일자, T:시간
	private String from_date; //조회시작일자
	private String to_date; //조회종료일자
	private String sort_order; //정렬순서 D:Descending  A:Ascending
	private String tran_dtime; //요청일시
    private String model;
    
	public AccountTranRequestVO(String bank_tran_id, String fintech_use_num, String inquiry_type, String inquiry_base,
			String from_date, String to_date, String sort_order, String tran_dtime, String model) {
		super();
		this.bank_tran_id = bank_tran_id;
		this.fintech_use_num = fintech_use_num;
		this.inquiry_type = inquiry_type;
		this.inquiry_base = inquiry_base;
		this.from_date = from_date;
		this.to_date = to_date;
		this.sort_order = sort_order;
		this.tran_dtime = tran_dtime;
		this.model = model;
	}
	@Override
	public String toString() {
		return "AccountTranRequestVO [bank_tran_id=" + bank_tran_id + ", fintech_use_num=" + fintech_use_num
				+ ", inquiry_type=" + inquiry_type + ", inquiry_base=" + inquiry_base + ", from_date=" + from_date
				+ ", to_date=" + to_date + ", sort_order=" + sort_order + ", tran_dtime=" + tran_dtime + ", model="
				+ model + "]";
	}
	
}
