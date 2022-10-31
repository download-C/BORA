<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>bank_main.jsp</h1>
<h3>인증완료</h3>
<h2>액세스 토큰 : ${responseToken.access_token }</h2>
<h2>사용자 번호 : ${responseToken.user_seq_no }</h2>
<h2>token_type : ${responseToken.token_type }</h2>
<h2>expires_in : ${responseToken.expires_in }</h2>
<h2>refresh_token : ${responseToken.refresh_token }</h2>
<h2>scope : ${responseToken.scope }</h2>
     
    <hr>
	<form method="get" action="/fintech/userInfo">
		<%-- 필요 파라미터는 입력데이터 없이 hidden 속성으로 전달 --%>
		<input type="hidden" name="access_token" value="${responseToken.access_token }">
		<input type="hidden" name="user_seq_no" value="${responseToken.user_seq_no }">
		<input type="submit" value="사용자정보조회">
	</form>
	
	<hr>
     <form method="post" action="/fintech/registCard">
        <%-- 필요 파라미터는 입력데이터 없이 hidden 속성으로 전달 --%>
		<input type="hidden" name="access_token" value="${responseToken.access_token }">
		<input type="hidden" name="member_bank_code" value="D">
		<input type="hidden" name="Info_prvd_agmt_yn" value="V">
		<input type="submit" value="카드등록">
     </form>
     
     <hr>
     <form method="get" action="/fintech/cardList">
        <%-- 필요 파라미터는 입력데이터 없이 hidden 속성으로 전달 --%>
		<input type="hidden" name="access_token" value="${responseToken.access_token }">
		<input type="hidden" name="user_seq_no" value="${responseToken.user_seq_no }">
		<input type="hidden" name="member_bank_code" value="D">
		<input type="hidden" name="befor_inquiry_trace_info" value="V">
		<input type="submit" value="카드목록">
     </form>
     
     <hr>
  
</body>
</html>


