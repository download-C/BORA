<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ include file="../include/header.jsp"%>
<!-- ${pageContext.request.contextPath} -->
<script src="https://code.jquery.com/jquery-3.6.0.js"></script>


<%
	if (loginID == null) {
%>
<script>
	alert("로그인 후 사용 가능한 페이지입니다.");
	location.href = "/main/login";
</script>
<%
	}
%>

<h1>저번 달 소비 내역</h1>
<table border="1">
  <tr>
    <th>카테고리</th>
    <th>소비합계</th>
  </tr>
  <c:forEach var="last" items="${consumeLast }">
  <tr>
    <td>${last.bk_category }</td>
    <td>${last.bk_sum}</td>
  </tr>
  </c:forEach>
</table>


<h1>이번 달 소비 내역</h1>
<table border="1">
  <tr>
    <th>카테고리</th>
    <th>소비합계</th>
  </tr>
  <c:forEach var="now" items="${consumeThis }">
  <tr>
    <td>${now.bk_category }</td>
    <td>${now.bk_sum }</td>
  </tr>
  </c:forEach>
</table>


<h1>이번 소비 전월비교 내역</h1>
<table border="1">
  <tr>
    <th>카테고리</th>
    <th>총소비(이번달)</th>
    <th>차액</th>
    <th>전월대비</th>
  </tr>
  <c:forEach var="vo" items="${consumeList }">
  <tr>
    <td>${vo.bk_category}</td>
    <td>${vo.bk_sum }</td>
    <td>${vo.bk_minus }</td>
    <td>${vo.bk_compare}</td>
  </tr>
  </c:forEach>
</table>


<%@ include file="../include/footer.jsp"%>