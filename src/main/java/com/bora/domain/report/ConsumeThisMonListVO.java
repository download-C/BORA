package com.bora.domain.report;

public class ConsumeThisMonListVO {
	
	private String bk_thismon_category; // 이번 달 카테고리
	private String id;
	private Integer bk_thismon_total; // 이번 달 소비합계
	
	public String getBk_thismon_category() {
		return bk_thismon_category;
	}
	public void setBk_thismon_category(String bk_thismon_category) {
		this.bk_thismon_category = bk_thismon_category;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public Integer getBk_thismon_total() {
		return bk_thismon_total;
	}
	public void setBk_thismon_total(Integer bk_thismon_total) {
		this.bk_thismon_total = bk_thismon_total;
	}
	
	

}
