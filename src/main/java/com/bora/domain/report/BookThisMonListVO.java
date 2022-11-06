package com.bora.domain.report;

public class BookThisMonListVO {
	private Integer bk_thismon_num; // 이번 달 소비 번호
	private String id;
	private String bk_thismon_category; // 이번 달 카테고리
	private Integer bk_thismon_total; // 이번 달 소비합계
	
	public Integer getBk_thismon_num() {
		return bk_thismon_num;
	}
	public void setBk_thismon_num(Integer bk_thismon_num) {
		this.bk_thismon_num = bk_thismon_num;
	}
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getBk_thismon_category() {
		return bk_thismon_category;
	}
	public void setBk_thismon_category(String bk_thismon_category) {
		this.bk_thismon_category = bk_thismon_category;
	}
	public Integer getBk_thismon_total() {
		return bk_thismon_total;
	}
	public void setBk_thismon_total(Integer bk_thismon_total) {
		this.bk_thismon_total = bk_thismon_total;
	}
	
	

}
