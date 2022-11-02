package com.bora.domain.openbank.card;

import lombok.Data;

@Data
public class CardDetailBillsVO {
	private String card_value;
	private String paid_date;
	private String paid_time;
	private String paid_amt;
	private String merchant_name_masked;
	private String credit_fee_amt;
	private String product_type;
	
	public CardDetailBillsVO(String card_value, String paid_date, String paid_time, String paid_amt,
			String merchant_name_masked, String credit_fee_amt, String product_type) {
		super();
		this.card_value = card_value;
		this.paid_date = paid_date;
		this.paid_time = paid_time;
		this.paid_amt = paid_amt;
		this.merchant_name_masked = merchant_name_masked;
		this.credit_fee_amt = credit_fee_amt;
		this.product_type = product_type;
	}
	

}
