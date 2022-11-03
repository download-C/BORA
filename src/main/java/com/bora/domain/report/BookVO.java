package com.bora.domain.report;

import lombok.Data;

@Data
public class BookVO {	
	private Integer bk_num;  		// 가계부 번호
	private Integer bk_detail_num;	// 가계부 디테일 번호
	private String id;   		//회원 아이디
	private Integer bk_year;		// 연도별
	private Integer bk_month;		// 월별
	private Integer bk_budget;		// 월별 예산 
}
