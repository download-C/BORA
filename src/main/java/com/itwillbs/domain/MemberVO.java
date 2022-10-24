package com.itwillbs.domain;

import java.sql.Date;
import java.sql.Timestamp;

import lombok.Data;

@Data
public class MemberVO {
	private int mno;
	private String id;
	private String pw;
	private String phone;
	private String email;
	private String addr;
	private Date birth;
	private Timestamp regdate;
}
