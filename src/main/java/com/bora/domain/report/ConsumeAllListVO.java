package com.bora.domain.report;

import lombok.Data;

@Data
public class ConsumeAllListVO {
	private Integer bk_consume_num; // 총소비 순번
	private String bk_category; // 소비 카테고리
	private String id; // 회원아이디
	private Integer bk_total_consume; // 총소비
	private Integer bk_consume_compare; // 전월대비
}
