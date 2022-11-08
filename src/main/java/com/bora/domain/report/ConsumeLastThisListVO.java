package com.bora.domain.report;

import lombok.Data;

@Data
public class ConsumeLastThisListVO {
	private Integer bk_lastmon_num; // 저번 달 소비순번
	private Integer bk_thismon_num; // 이번 달 소비순번
	private String bk_lastmon_category; // 저번 달 카테고리
	private String bk_thismon_category; // 이번 달 카테고리
	private Integer bk_lastmon_total; // 저번 달 소비합계
	private Integer bk_thismon_total; // 이번 달 소비합계
	private String id; // 회원 아이디

}
