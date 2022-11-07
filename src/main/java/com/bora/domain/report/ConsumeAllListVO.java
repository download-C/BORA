package com.bora.domain.report;

public class ConsumeAllListVO {
	private Integer bk_consume_num; //소비내역 비교번호
	private String id;
	private String bk_category; // 소비 카테고리
	private Integer bk_total_consume; // 총소비
	private Integer bk_consume_compare; // 전월대비
	
	public Integer getBk_consume_num() {
		return bk_consume_num;
	}
	public void setBk_consume_num(Integer bk_consume_num) {
		this.bk_consume_num = bk_consume_num;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getBk_category() {
		return bk_category;
	}
	public void setBk_category(String bk_category) {
		this.bk_category = bk_category;
	}
	public Integer getBk_total_consume() {
		return bk_total_consume;
	}
	public void setBk_total_consume(Integer bk_total_consume) {
		this.bk_total_consume = bk_total_consume;
	}
	public Integer getBk_consume_compare() {
		return bk_consume_compare;
	}
	public void setBk_consume_compare(Integer bk_consume_compare) {
		this.bk_consume_compare = bk_consume_compare;
	}
}
