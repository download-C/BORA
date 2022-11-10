package com.bora.domain.report;

import lombok.Data;

@Data
public class BookDetailVO {
	private Integer bk_detail_num;  // 가계부 상세정보 번호
	private Integer bk_num;		// 해당 달의 가계부 번호
	private BookVO book;        // 연 월 
	private String id;			// 회원 아이디
	private Integer bk_day;			// 일별
	private String bk_iow;		// 입금/출금/이체
	private String bk_group;	// 자산분류
	private String bk_category; // 식비,교통비, 통신비, 편의점/마트,문화생활, 쇼핑/뷰티, 기타
	private Integer bk_money;	// 금액
	private String bk_memo;		// 직접 입력할 수 있는 메모
}
