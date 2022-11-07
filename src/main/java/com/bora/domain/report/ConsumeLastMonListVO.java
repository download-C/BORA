package com.bora.domain.report;

public class ConsumeLastMonListVO {
	private Integer bk_lastmon_num; // 저번 달 소비 번호
	private String id; // 회원 아이디
	private String bk_lastmon_category; // 저번 달 카테고리
	private Integer bk_lastmon_total; // 저번 달 소비합계
	
	public Integer getBk_lastmon_num() {
		return bk_lastmon_num;
	}
	public void setBk_lastmon_num(Integer bk_lastmon_num) {
		this.bk_lastmon_num = bk_lastmon_num;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getBk_lastmon_category() {
		return bk_lastmon_category;
	}
	public void setBk_lastmon_category(String bk_lastmon_category) {
		this.bk_lastmon_category = bk_lastmon_category;
	}
	public Integer getBk_lastmon_total() {
		return bk_lastmon_total;
	}
	public void setBk_lastmon_total(Integer bk_lastmon_total) {
		this.bk_lastmon_total = bk_lastmon_total;
	}
	
	

}
