package com.bora.domain.openbank.card.prePaid;

import lombok.Data;

@Data
public class PrePaidTranVO {
	private String trans_type; // 거래유형코드
	private String trans_dtime; // 거래일시
	private String trans_no; // 거래번호
	private String trans_amt; // 거래금액
	private String after_balance_amt; // 거래후잔액
	private String trans_org_code; // 거래대상 금융기관 공용코드
	private String trans_key; // 거래 상대 식별값
	private String additional_info; // 거래 부가 정보
	private String merchant_name; // 결제 또는 결제취소 가맹점명
	private String trans_title; // 원장에 저장된 구매내역의 제목
	private String trans_category; // 해당 결제를 통해 구매한 상품 또는 서비스 구분
	private String pay_method; // 온라인, 오프라인 결제 구분
	
	public PrePaidTranVO( ) {}

	public PrePaidTranVO(String trans_type, String trans_dtime, String trans_no, String trans_amt,
			String after_balance_amt, String trans_org_code, String trans_key, String additional_info,
			String merchant_name, String trans_title, String trans_category, String pay_method) {
		super();
		this.trans_type = trans_type;
		this.trans_dtime = trans_dtime;
		this.trans_no = trans_no;
		this.trans_amt = trans_amt;
		this.after_balance_amt = after_balance_amt;
		this.trans_org_code = trans_org_code;
		this.trans_key = trans_key;
		this.additional_info = additional_info;
		this.merchant_name = merchant_name;
		this.trans_title = trans_title;
		this.trans_category = trans_category;
		this.pay_method = pay_method;
	}

	@Override
	public String toString() {
		return "PrePaidTranVO [trans_type=" + trans_type + ", trans_dtime=" + trans_dtime + ", trans_no=" + trans_no
				+ ", trans_amt=" + trans_amt + ", after_balance_amt=" + after_balance_amt + ", trans_org_code="
				+ trans_org_code + ", trans_key=" + trans_key + ", additional_info=" + additional_info
				+ ", merchant_name=" + merchant_name + ", trans_title=" + trans_title + ", trans_category="
				+ trans_category + ", pay_method=" + pay_method + "]";
	}
	

}
