package com.bora.domain;

import lombok.Data;

@Data
public class ReportVO {

	private String id;
	private String rp_date;
	private int rp_money;
	private String rp_detail;
	private String message;
	private String category;
	private int rp_num;
}
