package com.bora.domain.report;

import lombok.Data;

@Data
public class BookVO {
	private int bk_num;  	// 가계부 번호
	private String id;   	//회원 아이디
	private int bk_year;	// 연도별
	private int bk_month;	// 월별
	private int bk_budget;	// 월별 예산
}
