package com.bora.domain.openbank.card.bill;

import lombok.Data;

@Data
public class CardBillsVO {
	private String charge_month; // 청구년월
	private String settlement_seq_no; // 결제순번
	private String card_id; // 카드 식별자
	private String charge_amt; // 청구금액
	private String settlement_day; // 결제일
	private String settlement_date; // 결제년월일
	private String credit_check_type; // 신용/체크 구분
	
	public CardBillsVO() {}
	
	public CardBillsVO(String charge_month, String settlement_seq_no, String card_id, String charge_amt,
			String settlement_day, String settlement_date, String credit_check_type) {
		super();
		this.charge_month = charge_month;
		this.settlement_seq_no = settlement_seq_no;
		this.card_id = card_id;
		this.charge_amt = charge_amt;
		this.settlement_day = settlement_day;
		this.settlement_date = settlement_date;
		this.credit_check_type = credit_check_type;
	}


	@Override
	public String toString() {
		return "CardBillsVO [charge_month=" + charge_month + ", settlement_seq_no=" + settlement_seq_no + ", card_id="
				+ card_id + ", charge_amt=" + charge_amt + ", settlement_day=" + settlement_day + ", settlement_date="
				+ settlement_date + ", credit_check_type=" + credit_check_type + "]";
	}
	
	

}
