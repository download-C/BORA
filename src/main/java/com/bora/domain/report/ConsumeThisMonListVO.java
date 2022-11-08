package com.bora.domain.report;

import lombok.Data;

@Data
public class ConsumeThisMonListVO {
	private Integer bk_thismon_num; // 이번 달 소비순번
	private String bk_thismon_category; // 이번 달 카테고리
	private String id;
	private Integer bk_thismon_total; // 이번 달 소비합계
}
