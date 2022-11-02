package com.bora.domain;

import java.sql.Timestamp;
import lombok.Data;

@Data
public class NoticeVO {
	private Integer nno;
	private String n_title;
	private String n_content;
	private String n_file;
	private String n_uploadfoler;
	private Integer n_readcount;
	private Timestamp n_regdate;
}
