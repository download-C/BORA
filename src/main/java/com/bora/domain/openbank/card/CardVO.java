package com.bora.domain.openbank.card;

import lombok.Data;

@Data
public class CardVO {				
	private String card_id;	
	private String card_num_masked;	
	private String card_name;	
	private String card_member_type;
	
	public CardVO(String card_id, String card_num_masked, String card_name, String card_member_type) {
		super();
		this.card_id = card_id;
		this.card_num_masked = card_num_masked;
		this.card_name = card_name;
		this.card_member_type = card_member_type;
	}
	
	
}
