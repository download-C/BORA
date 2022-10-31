package com.bora.domain.openbank;

import java.util.List;

import lombok.Data;

//2.5.2. 입금이체 API
@Data
public class TranDepositRequestVO {
	private String access_token;
	private String cntr_account_type; //"N" 약정 계좌/계정구분주1) N:계좌, C:계정
	private String cntr_account_num; //"1101230000678" 약정 계좌/계정 번호주1)
	private String wd_pass_phrase; //Y 입금이체용 암호문구주2)
	private String wd_print_content; //"환불금액" 출금계좌인자내역
	private String name_check_option; //"on" or "off" 수취인성명 검증 여부(on:검증함) (미지정 시 기본값: "on")주10)
	private String sub_frnc_name; //“하위가맹점” 하위가맹점명주3)
	private String tran_dtime; //"20190910101921" 요청일시
	private String req_cnt; //고정값 : 1 입금요청건수주4)
	private String req_list; //
	private List<TranDepositReqListVO> de_req_list; //입금요청목록
	
	
	public TranDepositRequestVO(String access_token, String cntr_account_type, String cntr_account_num,
			String wd_pass_phrase, String wd_print_content, String name_check_option, String sub_frnc_name,
			String tran_dtime, String req_cnt, String req_list, List<TranDepositReqListVO> de_req_list) {
		super();
		this.access_token = access_token;
		this.cntr_account_type = cntr_account_type;
		this.cntr_account_num = cntr_account_num;
		this.wd_pass_phrase = wd_pass_phrase;
		this.wd_print_content = wd_print_content;
		this.name_check_option = name_check_option;
		this.sub_frnc_name = sub_frnc_name;
		this.tran_dtime = tran_dtime;
		this.req_cnt = req_cnt;
		this.req_list = req_list;
		this.de_req_list = de_req_list;
	}

	
	
	
}
