package com.bora.domain.openbank.card;

public class CardVO {				
	private String card_id;	
	private String card_num_masked;	
	private String card_name;	
	private String card_member_type;
	
	public String getCard_id() {
		return card_id;
	}
	public void setCard_id(String card_id) {
		this.card_id = card_id;
	}
	public String getCard_num_masked() {
		return card_num_masked;
	}
	public void setCard_num_masked(String card_num_masked) {
		this.card_num_masked = card_num_masked;
	}
	public String getCard_name() {
		return card_name;
	}
	public void setCard_name(String card_name) {
		this.card_name = card_name;
	}
	public String getCard_member_type() {
		return card_member_type;
	}
	public void setCard_member_type(String card_member_type) {
		this.card_member_type = card_member_type;
	}
	
}
