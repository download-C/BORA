<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>     
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>거래내역</h1>

${accountTran.bank_tran_date }
${accountTran.api_tran_dtm }
${accountTran.fintech_use_num }



<!-- 	private String api_tran_id; //거래고유번호(API) -->
<!-- 	private String api_tran_dtm; //거래일시(밀리세컨드) -->
<!-- 	private String rsp_code; //응답코드(API) -->
<!-- 	private String rsp_message; //응답메세지 -->
<!-- 	private String bank_tran_id; //거래고유번호(참가은행) -->
<!-- 	private String bank_tran_date; //거래일자(참가은행) -->
<!-- 	private String bank_code_tran; //응답코드를 부여한 참가은행.표준코드 -->
<!-- 	private String bank_rsp_code; //응답코드(참가은행) -->
<!-- 	private String bank_rsp_message; //응답메시지(참가은행)	 -->
<!-- 	private String bank_name; //출금(개설)기관명 -->
<!-- 	private String fintech_use_num; //핀테크이용번호 -->
<!-- 	private String balance_amt; //계좌잔액(-금액가능) -->
<!-- 	private List<TranVO> tran_res_list; //사용자 등록계좌 목록 -->
	
<!-- 	private String tran_date; //거래일자 -->
<!-- 	private String tran_time; //거래시간 -->
<!-- 	private String inout_type; //입출금구분주4) (입금, 출금, 지급, 기타)_입출금구분이 ‘기타’인 경우에는 ‘거래금액’이 0원으로 세팅됨 -->
<!-- 	private String tran_type; //현금, 대체, 급여, 타행환, F/B출금 등 (참가은행에서 직접 세팅) -->
<!-- 	private String print_content; //"통장인자내용" -->
<!-- 	private String tran_amt; //거래금액 -->
<!-- 	private String after_balance_amt; //거래후잔액(-금액가능) -->
<!-- 	private String branch_name;  //거래점명 -->


<h3>입출금구분 입출금구분주4) (입금, 출금, 지급, 기타)_입출금구분이 ‘기타’인 경우에는 ‘거래금액’이 0원으로 세팅됨</h3>
<h3>거래유형 현금, 대체, 급여, 타행환, F/B출금 등 (참가은행에서 직접 세팅)</h3>


	<table>
		<tr>
			<th>거래일자</th>
			<th>입출금구분</th>
			<th>거래유형</th>
			<th>거래금액</th>
			<th>거래후잔액</th>
		</tr>
		<%-- accountList 객체에 저장되어 있는 계좌 목록(res_list) 가져와서 반복하여 복수개 계좌 접근 --%>
		<c:forEach var="accountTran" items="${accountTran.tran_res_list }">
			<tr>
				<td>${accountTran.tran_date }</td>
				<td>${accountTran.inout_type }</td>
				<td>${accountTran.tran_type }</td>
				<td>${accountTran.tran_amt }</td>
				<td>${accountTran.after_balance_amt }</td>
			</tr>
		</c:forEach>
	</table>

</body>
</html>