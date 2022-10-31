package com.bora.domain.openbank;

// 2.2.3. 등록계좌조회 API 요청 데이터
public class AccountSearchRequestVO {
    private String access_token;
    private String user_seq_no;
    private String include_cancel_yn; //해지계좌포함여부 Y:해지계좌포함, N:해지계좌불포함
    private String sort_order; //정렬순서주 D:Descending, A:Ascending
    private String model;
    
	public String getAccess_token() {
		return access_token;
	}
	public void setAccess_token(String access_token) {
		this.access_token = access_token;
	}
	public String getUser_seq_no() {
		return user_seq_no;
	}
	public void setUser_seq_no(String user_seq_no) {
		this.user_seq_no = user_seq_no;
	}
	public String getInclude_cancel_yn() {
		return include_cancel_yn;
	}
	public void setInclude_cancel_yn(String include_cancel_yn) {
		this.include_cancel_yn = include_cancel_yn;
	}
	public String getSort_order() {
		return sort_order;
	}
	public void setSort_order(String sort_order) {
		this.sort_order = sort_order;
	}
	public String getModel() {
		return model;
	}
	public void setModel(String model) {
		this.model = model;
	}
	@Override
	public String toString() {
		return "AccountSearchRequestVO [access_token=" + access_token + ", user_seq_no=" + user_seq_no
				+ ", include_cancel_yn=" + include_cancel_yn + ", sort_order=" + sort_order + ", model=" + model + "]";
	}
	public AccountSearchRequestVO(String access_token, String user_seq_no, String include_cancel_yn, String sort_order,
			String model) {
		super();
		this.access_token = access_token;
		this.user_seq_no = user_seq_no;
		this.include_cancel_yn = include_cancel_yn;
		this.sort_order = sort_order;
		this.model = model;
	}
    
    
}
