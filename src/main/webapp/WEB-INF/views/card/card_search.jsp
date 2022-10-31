<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
   <h1>card_search.jsp</h1>
   
	 <form method="get" action="/fintech/cardBills">
        <%-- 필요 파라미터는 입력데이터 없이 hidden 속성으로 전달 --%>
		<input type="hidden" name="access_token" value="${responseToken.access_token }">
		<input type="hidden" name="user_seq_no" value="${responseToken.user_seq_no }">
		<input type="hidden" name="member_bank_code" value="D">
		<input type="hidden" name="card_id" value="V">
		<input type="submit" value="카드청구 조회">
     </form>
</body>
</html>