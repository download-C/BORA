<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!-- ${pageContext.request.contextPath} -->
<html>
<head>
<title>BORA</title>
<script src="https://code.jquery.com/jquery-3.6.0.js"></script>
<%
String loginID = (String)session.getAttribute("loginID");
if(loginID==null) {%>
<!-- 세션값(로그인) 확인 -->
<script>
// 세션값 여부
	alert("세션값이 만료되어 로그인 페이지로 이동합니다.");
	location.href="/main/login";
	
	$(document).ready(function() {
	  
	});
</script>
<%} %>
<script>
function linkToOpener(URL){
	if (window.opener && !window.opener.closed){
		window.opener.location = "/main/main";
		window.close();
	}
}
$(document).ready(function(){
	$("#delete").click(function(){
// 		alert("탈퇴 버튼 클릭");
		$.ajax({
			method:"post",
			url:"/member/delete",
			data: "<%=loginID%>",
			success: function(data) {
		    	if (window.opener && !window.opener.closed){
		    		alert("탈퇴되었습니다");
					window.opener.location.href = "/main/main";
					window.close();
				}
				
			}// success
		});//ajax
	});//#delete
});
</script>

<!-- 태그 적는 곳 -->
</head>
<body>
<form role="form" method="post">
	정말로 탈퇴하시겠습니까? <br>
</form>
	<input type="button" id="delete" value="탈퇴하기">
	<input type="button" id="cancle" value="취소하기" 
	onclick='javascript:linkToOpener()'>
	






<!-- 태그 적는 곳 -->

</body>
</html>