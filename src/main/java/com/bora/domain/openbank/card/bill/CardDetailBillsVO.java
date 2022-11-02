package com.bora.domain.openbank.card;

import lombok.Data;

@Data
public class CardDetailBillsVO {
	private String card_value; // 카드 식별값
	private String paid_date; // 사용일자(YYYYMMDD)
	private String paid_time; // 사용시간(hhmmss)
	private String paid_amt; // 이용금액(원/KRW)
	private String merchant_name_masked; // 마스킹된 가맹점명
	private String credit_fee_amt; // 신용판매 수수료
	private String product_type; // 상품 구분
	
	public CardDetailBillsVO() {}
	
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

	@Override
	public String toString() {
		return "CardDetailBillsVO [card_value=" + card_value + ", paid_date=" + paid_date + ", paid_time=" + paid_time
				+ ", paid_amt=" + paid_amt + ", merchant_name_masked=" + merchant_name_masked + ", credit_fee_amt="
				+ credit_fee_amt + ", product_type=" + product_type + "]";
	}
	
	

}
