<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ include file="../include/header.jsp"%>
<!-- ${pageContext.request.contextPath} -->
<script src="https://code.jquery.com/jquery-3.6.0.js"></script>
<script src="https://cdn.jsdelivr.net/npm/sweetalert2@9"></script>
<script src="https://cdn.jsdelivr.net/npm/promise-polyfill@7.1.0/dist/promise.min.js"></script>

<!-- 로그인 실패 모달 -->
<script>
//warning 버튼
function warning(message) {

    Swal.fire(
        '경고',
        message,
        'warning' /*디자인 타입*/
    )

}//warning 버튼
</script>

<!-- document.ready -->
<script>
$(document).ready(function(){
	let message = "${msg}";
	if(message!="") {
		warning(message);
	}
})
</script>

<div class="container">
<h1>member/login.jsp </h1>
	<div class="login">
	
		<form action="/main/login" method="post">
		<sec:csrfInput/>
		<div><input type="text" name="id" id="id" class="" placeholder="아이디" required="required"></div>
		<div><input type="password" name="pw" id="pw" class="" placeholder="비밀번호" required="required"></div>
		<div><input type="submit" value="로그인" id="login"></div>
	<%-- 	<div><input type="hidden" value="${_csrf.token }" name=${_csrf.parameterName }></div> --%>
		</form>
	</div>
</div>
<%@ include file="../include/footer.jsp"%>