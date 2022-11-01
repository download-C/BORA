<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>사용자 정보조회 결과</h1>
	<h3>고객번호 : ${userInfo.user_seq_no }</h3>
	<h3>고객CI값 : ${userInfo.user_ci }</h3>
	<h3>고객이름 : ${userInfo.user_name }</h3>
<%-- 	<h3>고객생년월일 : ${userInfo.user_info }</h3> 필요없음 --%>
<%-- 	<h3>고객성별 : ${userInfo.user_gender }</h3> 필요없음 --%>
<%-- 	<h3>고객휴대폰번호 : ${userInfo.user_cell_no }</h3> 필요없음 --%>
<%-- 	<h3>고객이메일주소 : ${userInfo.user_email }</h3> 필요없음 --%>
	<h3>고객등록계좌수 : ${userInfo.res_cnt }</h3> 

	<hr>
	
	<h3>고객등록계좌목록 : ${userInfo.res_list }</h3>


<!-- 	등록계좌목록 값 -->
<!-- 	private String fintech_use_num; //핀테크이용번호 -->
<!--     private String account_alias; //계좌별명 -->
<!--     private String bank_code_std; //출금(개설)기관.표준코드 -->
<!--     private String bank_code_sub; //출금(개설)기관.점별코드 -->
<!--     private String bank_name; //출금(개설)기관명 -->
<!--     private String savings_bank_name; //개별저축은행명주1) -->
<!--     private String account_num; //계좌번호주4) -->
<!--     private String account_num_masked; //마스킹된 출력용 계좌번호 -->
<!--     private String account_seq; //회차번호주2) 주4) -->
<!--     private String account_holder_name; //계좌예금주명 -->
<!--     private String account_holder_type; //계좌구분(P:개인) -->
<!--     private String account_type; //계좌종류주3) 1:수시입출금, 2:예적금 6:수익증권, T:종합계좌 -->
<!--     private String inquiry_agree_yn; //조회서비스 동의여부 -->
<!--     private String inquiry_agree_dtime; //조회서비스 동의일시 -->
<!--     private String transfer_agree_yn; //출금서비스 동의여부 -->
<!--     private String transfer_agree_dtime; //출금서비스 동의일시 -->
<!--     private String account_state; //납부번호 -->
	
	
	
</body>
</html>





