package com.bora.domain.openbank;

import lombok.Data;

// 2.2 사용자/계좌 관리에서 사용되는 계좌 정보(배열로 전달된 데이터)
@Data
public class TranVO {
	
	private String tran_date; //거래일자
	private String tran_time; //거래시간
	private String inout_type; //입출금구분주4) (입금, 출금, 지급, 기타)_입출금구분이 ‘기타’인 경우에는 ‘거래금액’이 0원으로 세팅됨
	private String tran_type; //현금, 대체, 급여, 타행환, F/B출금 등 (참가은행에서 직접 세팅)
	private String print_content; //"통장인자내용"
	private String tran_amt; //거래금액
	private String after_balance_amt; //거래후잔액(-금액가능)
	private String branch_name;  //거래점명
	
	
	public TranVO(String tran_date, String tran_time, String inout_type, String tran_type, String print_content,
			String tran_amt, String after_balance_amt, String branch_name) {
		super();
		this.tran_date = tran_date;
		this.tran_time = tran_time;
		this.inout_type = inout_type;
		this.tran_type = tran_type;
		this.print_content = print_content;
		this.tran_amt = tran_amt;
		this.after_balance_amt = after_balance_amt;
		this.branch_name = branch_name;
	}
	
	@Override
	public String toString() {
		return "TranVO [tran_date=" + tran_date + ", tran_time=" + tran_time + ", inout_type=" + inout_type
				+ ", tran_type=" + tran_type + ", print_content=" + print_content + ", tran_amt=" + tran_amt
				+ ", after_balance_amt=" + after_balance_amt + ", branch_name=" + branch_name + "]";
	}
	
	
}
