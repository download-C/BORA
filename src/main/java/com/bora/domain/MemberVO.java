package com.bora.domain;

import java.sql.Timestamp;

import lombok.Data;

@Data
public class MemberVO {
	private int mno;
	private String id;
	private String pw;
	private String name;
	private String nick;
	private String phone;
	private String email;
	private String authority;
	private boolean enabled;
	private Timestamp regdate;
}
