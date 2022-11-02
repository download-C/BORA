<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>계좌해지</h1>

	<h3>거래고유번호 : ${accountCancel.api_tran_id }</h3>
	<h3>거래일시(밀리세컨드) : ${accountCancel.api_tran_dtm }</h3>
	<h3>거래일자(참가은행) : ${accountCancel.bank_tran_date }</h3>
	<h3>참가은행.표준코드 : ${accountCancel.bank_code_tran }</h3>
	<h3>거래고유번호 : ${accountCancel.api_tran_id }</h3>

</body>
</html>