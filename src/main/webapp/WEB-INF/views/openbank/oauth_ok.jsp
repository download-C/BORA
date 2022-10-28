<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>openbank/oauth_ok.jsp</title>
</head>
<body>

<h1>인증완료</h1>

<h4>액세스 토큰 : 22${responseToken.access_token }</h4>
<h4>사용자 번호 : ${responseToken.user_seq_no }</h4>
<h4>token_type : ${responseToken.token_type }</h4>
<h4>expires_in : ${responseToken.expires_in }</h4>
<h4>refresh_token : ${responseToken.refresh_token }</h4>
<h4>scope : ${responseToken.scope }</h4>
   
	<hr>
	<form method="get" action="userInfo">
		<%-- 필요 파라미터는 입력데이터 없이 hidden 속성으로 전달 --%>
		<input type="hidden" name="access_token" value="${responseToken.access_token }">
		<input type="hidden" name="user_seq_no" value="${responseToken.user_seq_no }">
		<input type="submit" value="사용자정보조회">
	</form>
	
	<hr>
	<!-- 2.2.3 등록계좌조회 API -->
	<form method="get" action="accountList">
		<%-- 필요 파라미터는 입력데이터 없이 hidden 속성으로 전달 --%>
		<input type="hidden" name="access_token" value="${responseToken.access_token }">
		<input type="hidden" name="user_seq_no" value="${responseToken.user_seq_no }">
		<input type="hidden" name="include_cancel_yn" value="Y">
		<input type="hidden" name="sort_order" value="D">
		<input type="submit" value="등록계좌조회">
	</form>    
    
     
</body>
</html>


