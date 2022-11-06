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
				<td width="20%">메모</td>
				<td width="5%">비고</td>
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
				<td>
					<button onclick="location.href='/book/update?page=1&bk_num=${list.bk_num}';">수정</button>
					<button onclick="location.href='/book/delete?page=1&bk_num=${list.bk_num}&bk_detail_num=${list.detail.bk_detail_num }';">삭제</button></td>
			</tr>
			</c:forEach>
		</tbody>
		</table>
	</div>
	<div>
		<ul type="none" id="pageUl">
			<c:if test="${pm.prev }"> 
				<li><a href="/book/list?page=${pm.pageStart - 1 }">&laquo;</a></li>
			</c:if>
			<c:forEach var="index" begin="${pm.pageStart }" end="${pm.endPage }"> 
				<li ${pm.vo.page == index? 'class=active' : '' }  style="float: left;">
					<a href="/book/list?page=${index }"> &nbsp;&nbsp; ${index} &nbsp;&nbsp; </a>
				</li>
			</c:forEach>
			<c:if test="${pm.next }">
				<li><a href="/book/list?page=${pm.endPage + 1 }">&raquo;</a></li>
			</c:if>
		</ul>
	</div>
</div>



<!-- 태그 적는 곳 -->


<%@ include file="../include/footer.jsp"%>