<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>openbank/oauth.jsp</title>
</head>
<body>

<h1>인증 요청 작업</h1>

	<!-- 인증 요청 작업 수행 -->
	<form action="https://testapi.openbanking.or.kr/oauth/2.0/authorize" method="get">
		<input type="hidden" name="response_type" value="code"> 
		<input type="hidden" name="client_id" value="d30735e2-bd2d-4a1d-84c7-414bd28660c1"> 
		<input type="hidden" name="redirect_uri" value="http://localhost:8088/openbank/callback"> 
		<input type="hidden" name="scope" value="login inquiry transfer"> 
		<input type="hidden" name="state" value="12345678123456781234567812345678">
		<input type="hidden" name="auth_type" value="0"> 
		<input type="submit" value="토큰 발급">
	</form>
	
	
	
	
	

</body>
</html>
