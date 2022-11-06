package com.bora.domain.report;

public class BookDetailAllListVO {
	private Integer bk_book_num; //소비내역 비교번호
	private String id;
	private String bk_category; // 소비 카테고리
	private Integer bk_total_consum; // 총소비
	private Integer bk_consum_compare; // 전월대비
	
	public Integer getBk_book_num() {
		return bk_book_num;
	}
	public void setBk_book_num(Integer bk_book_num) {
		this.bk_book_num = bk_book_num;
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
	public Integer getBk_total_consum() {
		return bk_total_consum;
	}
	public void setBk_total_consum(Integer bk_total_consum) {
		this.bk_total_consum = bk_total_consum;
	}
	public Integer getBk_consum_compare() {
		return bk_consum_compare;
	}
	public void setBk_consum_compare(Integer bk_consum_compare) {
		this.bk_consum_compare = bk_consum_compare;
	}
}
