package com.bora.domain.openbank;

//2.3.2. 거래내역조회
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
    
    
	public String getBank_tran_id() {
		return bank_tran_id;
	}
	public void setBank_tran_id(String bank_tran_id) {
		this.bank_tran_id = bank_tran_id;
	}
	public String getFintech_use_num() {
		return fintech_use_num;
	}
	public void setFintech_use_num(String fintech_use_num) {
		this.fintech_use_num = fintech_use_num;
	}
	public String getInquiry_type() {
		return inquiry_type;
	}
	public void setInquiry_type(String inquiry_type) {
		this.inquiry_type = inquiry_type;
	}
	public String getInquiry_base() {
		return inquiry_base;
	}
	public void setInquiry_base(String inquiry_base) {
		this.inquiry_base = inquiry_base;
	}
	public String getFrom_date() {
		return from_date;
	}
	public void setFrom_date(String from_date) {
		this.from_date = from_date;
	}
	public String getTo_date() {
		return to_date;
	}
	public void setTo_date(String to_date) {
		this.to_date = to_date;
	}
	public String getSort_order() {
		return sort_order;
	}
	public void setSort_order(String sort_order) {
		this.sort_order = sort_order;
	}
	public String getTran_dtime() {
		return tran_dtime;
	}
	public void setTran_dtime(String tran_dtime) {
		this.tran_dtime = tran_dtime;
	}
	public String getModel() {
		return model;
	}
	public void setModel(String model) {
		this.model = model;
	}
	
}
