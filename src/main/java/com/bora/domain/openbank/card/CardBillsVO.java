package com.bora.domain.openbank.card;

import lombok.Data;

@Data
public class CardBillsVO {
	private String charge_month;
	private String settlement_seq_no;
	private String card_id;
	private String charge_amt;
	private String settlement_day;
	private String settlement_date;
	private String credit_check_type;
	
	
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
	

}
