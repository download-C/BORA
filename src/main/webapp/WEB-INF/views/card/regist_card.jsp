<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://code.jquery.com/jquery-3.6.0.js"></script>
<script>

</script>
</head>
<body>
<h1>regist_card.jsp</h1>
<div class="registCard">
	<form action="/fintech/registCard" method="post">
	<div><input type="text" name="id" id="id" class="" placeholder="아이디"></div>
	<div><input type="password" name="pw" id="pw" class="" placeholder="비밀번호"></div>
	<div><input type="submit" value="등록"></div>
	<div><input type="reset" value="취소"></div>
	</form>
</div>
</body>
</html>

