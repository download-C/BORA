package com.bora.domain.report;



import java.util.List;

import lombok.Data;

@Data
public class BookVO {	
	private Integer bk_num;  		// 가계부 번호
	private String id;   		//회원 아이디
	private Integer bk_year;		// 연도별
	private Integer bk_month;		// 월별
	private Integer bk_budget;


}
