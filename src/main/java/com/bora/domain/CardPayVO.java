package com.bora.domain;

import lombok.Data;

@Data
public class CardPayVO {
	private String cpay_date;
	private int card_num;
	private int cpay_money;
	private String cpay_type;
	private int cpay_code;
	private String cpay_store;
	private String id;

}
