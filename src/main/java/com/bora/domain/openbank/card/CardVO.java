package com.bora.domain.openbank.card;

import lombok.Data;

@Data
public class CardVO {				
	private String card_id;	 			// 카드 식별자 -> 
	private String card_num_masked;		// 마스킹된 카드번호(0000-0000-0000-0000)
	private String card_name; 			// 회사에서 지정한 카드상품명
	private String card_member_type;	// 카드회원 구분 
	
	public CardVO(String card_id, String card_num_masked, String card_name, String card_member_type) {
		super();
		
		this.card_id = card_id;
		this.card_num_masked = card_num_masked;
		this.card_name = card_name;
		this.card_member_type = card_member_type;
	}
	
	
}
