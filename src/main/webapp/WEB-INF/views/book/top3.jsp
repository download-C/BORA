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
	alert("로그인 후 이용 가능합니다. 로그인 페이지로 이동합니다.");
	location.href="/main/login";
	
	$(document).ready(function() {
	    let message = "${msg}";
	    if (message != "") {
	        alert(message);
	    }
	})
</script>
<%} %>
<h1>top3.jsp</h1>

<div class="panel panel-default">
	<div class="panel-heading"><%=loginID%>님의 이번 달 소비 TOP3
	</div>
	<div class="panel-body">
		<table class="table table-hover table-bordered">
			<tr>
				<td>날짜</td>
				<td>매장명</td>
				<td>금액</td>
			</tr>

			<c:forEach var="vo" items="${top3}">
				<tr>
					<td>${vo.bk_day}</td>
					<td>${vo.bk_memo}</td>
					<td>${vo.bk_money}</td>
				</tr>
			</c:forEach>

		</table>
	</div>

	<div class="panel panel-default">
		<div class="panel-heading"><%=loginID%>님의 이번 달 소비 TOP3
		</div>
		<div class="panel-body">
			<table class="table table-hover table-bordered">
				<tr>
					<td>날짜</td>
					<td>금액</td>
				</tr>

				<c:forEach var="vo" items="${top3date}">
					<tr>
						<td>${vo.bk_day}</td>
						<td>${vo.bk_money}</td>
					</tr>
				</c:forEach>

			</table>
		</div>

		<hr>
		

	       <div class="col-lg-44" style="margin-top: 100px; margin-bottom: 100px" align="center">
	       		<a style="font-size: 23px; font-weight: bold;">이번 달 나의 소비 ROLE</a><br>
	       			<c:choose>
	       				<c:when test="${bk_category eq '통신비'}">
	       					<img src = "${pageContext.request.contextPath}/resources/img/pig.png" style="width: 300px; height: 339px; margin-top: 30px;">
	       				</c:when>
	       				<c:otherwise>
	       				</c:otherwise>
	       			</c:choose>
	       </div>

		<%@ include file="../include/footer.jsp"%>