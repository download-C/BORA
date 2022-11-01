<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ include file="../include/header.jsp"%>
<!-- ${pageContext.request.contextPath} -->
<script src="https://code.jquery.com/jquery-3.6.0.js"></script>

<!-- 비밀번호 회원정보 수정 시 alert -->
<script>
$(document).ready(function() {
    let message = "${msg}";
    if (message != "") {
        alert(message);
    }
});
</script>
<!-- 태그 적는 곳 -->





<form action="/notice/upload" method="post" enctype="multipart/form-data">
	<input type="file" name="n_file" multiple> <br>
	<input type="submit" value="전송">
</form>


<!-- 태그 적는 곳 -->


<%@ include file="../include/footer.jsp"%>