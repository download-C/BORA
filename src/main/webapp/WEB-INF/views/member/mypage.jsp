<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ include file="../include/header.jsp"%>
<!-- ${pageContext.request.contextPath} -->
<h1> member/mypage.jsp</h1>
<%
if(loginID==null) {%>
<script>
	alert("세션값이 만료되어 로그인 페이지로 이동합니다.");
	location.href="/member/login";
</script>
<%} %>

<!-- 모달창 script --> 
<script src="https://cdn.jsdelivr.net/npm/sweetalert2@9"></script>
<script src="https://cdn.jsdelivr.net/npm/promise-polyfill@7.1.0/dist/promise.min.js"></script>


<script>
$(document).ready(function() {
    let message = "${msg}";
    if (message != "") {
        alert(message);
    }
})
</script>


<script>
// $(document).ready(function() {
//     let message = "${msg}";
//     if (message != "") {
//         modify(message);
//     }
})
</script>
<script>
// function modify() {
//     	let message = "${msg}";
//         Swal.fire(
//            message,
//            '회원정보 수정 완료',
//            'success' /*디자인 타입*/
//          )
}//success 버튼
</script>        
        	

<div class="mypage">
	<div>아이디 
		<div><input type="text" value="${vo.id }" readonly="readonly"></div>
	</div> 
	<div>비밀번호 
		<div><input type="password" value="" readonly="readonly"></div>
	</div> 
	<div>이름
		<div> <input type="text" value="${vo.name }" readonly="readonly"></div>
	</div>
	<div>닉네임
		<div> <input type="text" value="${vo.nick }" readonly="readonly"></div>
	</div>
	<div>연락처
		<div> <input type="text" value="${vo.phone }" readonly="readonly"></div>
	</div>
	<div>이메일
		<div> <input type="text" value="${vo.email}" readonly="readonly"></div>
	</div>
	<div>
	<input type="button" value="수정하기" onclick="location.href='/member/password';">
	</div>
	<div><a href="/member/delete">탈퇴하기</a></div>
</div>
<%@ include file="../include/footer.jsp"%>
