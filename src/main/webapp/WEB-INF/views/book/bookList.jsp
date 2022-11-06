<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ include file="../include/header.jsp"%>
<!-- ${pageContext.request.contextPath} -->
<script src="https://code.jquery.com/jquery-3.6.0.js"></script>
<%
if(loginID==null) {%>
<!-- 세션값(로그인) 확인 -->
<script>
// 세션값 여부
	alert("세션값이 만료되어 로그인 페이지로 이동합니다.");
	location.href="/main/login";
	
	$(document).ready(function() {
	    let message = "${msg}";
	    if (message != "") {
	        alert(message);
	    }
	})
</script>
<%} %>
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

<div class="container">
<h1>book/bookList.jsp</h1>
	<input type="button" value="가계부 쓰기" onclick="location.href='/book/write';" >
	<div class="listTable">
	작성자 : <%=loginID %>님	
		<table border="1" style="width: 100%">
		<thead>
			<tr>
				<td width="10%">연</td>
				<td width="10%">월</td>
				<td width="5%">일</td>
				<td width="10%">항목</td>
				<td width="15%">자산</td>
				<td width="15%">카테고리</td>
				<td width="10%">금액</td>
				<td width="25%">메모</td>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${bookList }" var="list" >
			<tr>
				<td>${list.bk_year }년</td>
				<td>${list.bk_month }월</td>
				<td>${list.detail.bk_day }일</td>
				<td>${list.detail.bk_iow }</td>
				<td>${list.detail.bk_group }</td>
				<td>${list.detail.bk_category }</td>
				<td>${list.detail.bk_money }</td>
				<td>${list.detail.bk_memo }</td>
			</tr>
			</c:forEach>
		</tbody>
		</table>
	</div>
</div>



<!-- 태그 적는 곳 -->


<%@ include file="../include/footer.jsp"%>