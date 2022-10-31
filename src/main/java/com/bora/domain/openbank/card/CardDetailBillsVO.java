package com.bora.domain.openbank.card;

public class CardDetailBillsVO {
	private String card_value;
	private String paid_date;
	private String paid_time;
	private String paid_amt;
	private String merchant_name_masked;
	private String credit_fee_amt;
	private String product_type;
	public String getCard_value() {
		return card_value;
	}
	public void setCard_value(String card_value) {
		this.card_value = card_value;
	}
	public String getPaid_date() {
		return paid_date;
	}
	public void setPaid_date(String paid_date) {
		this.paid_date = paid_date;
	}
	public String getPaid_time() {
		return paid_time;
	}
	public void setPaid_time(String paid_time) {
		this.paid_time = paid_time;
	}
	public String getPaid_amt() {
		return paid_amt;
	}
	public void setPaid_amt(String paid_amt) {
		this.paid_amt = paid_amt;
	}
	public String getMerchant_name_masked() {
		return merchant_name_masked;
	}
	public void setMerchant_name_masked(String merchant_name_masked) {
		this.merchant_name_masked = merchant_name_masked;
	}
	public String getCredit_fee_amt() {
		return credit_fee_amt;
	}
	public void setCredit_fee_amt(String credit_fee_amt) {
		this.credit_fee_amt = credit_fee_amt;
	}
	public String getProduct_type() {
		return product_type;
	}
	public void setProduct_type(String product_type) {
		this.product_type = product_type;
	}
	
	

}
