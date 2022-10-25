package com.bora.domain;

import java.sql.Date;
import java.sql.Timestamp;

import lombok.Data;

@Data
public class MemberVO {
	private int mno;
	private String id;
	private String pw;
	private String name;
	private Date birth;
	private String gender;
	private String phone;
	private String ad_postcode;
	private String ad_address;
	private String ad_detail;
	private String ad_extra;
	private String email;
	private Timestamp regdate;
}
