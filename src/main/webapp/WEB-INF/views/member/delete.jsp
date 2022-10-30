<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ include file="../include/header.jsp"%>
<!-- ${pageContext.request.contextPath} -->
<script src="https://code.jquery.com/jquery-3.6.0.js"></script>
<%
if(loginID==null) {%>
<!-- 세션값 만료 확인 -->
<script>
	alert("세션값이 만료되어 로그인 페이지로 이동합니다.");
	location.href="/member/login";
</script>
<%} %>

<!-- 작업 처리 후 돌아왔을 때 띄울 알림창 -->
<script>
$(document).ready(function() {
    let message = "${msg}";
    if (message != "") {
        alert(message);
    }
})
</script>

<!-- 회원 탈퇴를 위한 비밀번호 입력 시 비밀번호 일치 여부 확인 후
 한 번 더 탈퇴 여부를 묻는 알림창 -->
<script>

var form = $('form[role="form"]');

$(document).ready(function(){
	$("#delete").click(function(){
// 		alert("탈퇴 버튼 클릭");
// 		OpenWin_variety("/member/deleteCheck", "탈퇴 확인", 200px, 200px, 900px, 500px);
// 		parent.location.href="/member/deleteCheck";
		var popup;
		$.ajax({
			type:"post",
			url:"/member/deleteCheck",
			data:{"pw":$("#pw").val()},
			success: function(result) {
				if(result=="ok") {
// 					answer = "ok";	
					// 탈퇴 버튼 클릭 시 정말로 탈퇴할건지 묻는 팝업창 띄우기
					popup = window.open("/member/deletePop","탈퇴 재확인", 'width=800px, height=300px, left=900px, top=300px');
// 					popup.addEventListner('beforeunload', function(){
// 						window.opener.location.href="/main/main";
// 					});
				}else {
					alert("비밀번호가 틀립니다.");
					return false;
				} // result == ok
			} //success
		}); //ajax
		
		if(answer == "ok") {
			
		}
	});//#delete
}); //document
</script>

<h1>/member/delete.jsp</h1>

<form role="form" method="post">
	<div>
		<input type="password" placeholder="비밀번호를 입력하세요" name="pw" id="pw">
	</div>
	<div> 
	</div>
</form>
<input type="button" value="탈퇴하기" id="delete">
<%@ include file="../include/footer.jsp"%>