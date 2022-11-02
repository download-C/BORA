<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ include file="../include/header.jsp"%>
<!-- ${pageContext.request.contextPath} -->
<script src="https://code.jquery.com/jquery-3.6.0.js"></script>


<!-- ////////////alert 커스텀//////////// -->
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/limonte-sweetalert2/7.2.0/sweetalert2.min.css">
<script src="https://cdnjs.cloudflare.com/ajax/libs/limonte-sweetalert2/7.2.0/sweetalert2.all.min.js"></script>
<script>
$(document).on('click', '#login', function(e) {
    swal(
      'message',
      '로그인 성공',
      'login'
    )
  });
</script>

<style>
.login {
  background-color: cadetblue;
  color: whitesmoke;
  border: 0;
  -webkit-box-shadow: none;
  box-shadow: none;
  font-size: 18px;
  font-weight: 500;
  border-radius: 7px;
  padding: 15px 35px;
  cursor: pointer;
  white-space: nowrap;
  margin: 10px;
}


</style>


<!-- ////////////alert 커스텀//////////// -->




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
<%@ include file="../include/footer.jsp"%>