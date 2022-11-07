<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ include file="../include/header.jsp"%>
<!-- ${pageContext.request.contextPath} -->
<script src="https://code.jquery.com/jquery-3.6.0.js"></script>
<h1>저번 달 소비 내역</h1>
<table>
  <tr>
    <th>카테고리</th>
    <th>소비합계</th>
  </tr>
  <c:forEach var="last" items="${consumeLastMon }">
  <tr>
    <td>${last.bk_lastmon_category }</td>
    <td>${last.bk_lastmon_total }</td>
  </tr>
  </c:forEach>
</table>

<h1>이번 달 소비 내역</h1>
<table>
  <tr>
    <th>카테고리</th>
    <th>소비합계</th>
  </tr>
  <c:forEach var="this" items="${consumeThisMon }">
  <tr>
    <td>${this.bk_thismon_category }</td>
    <td>${this.bk_thismon_total }</td>
  </tr>
  </c:forEach>
</table>

<h1>이번 소비 전월비교 내역</h1>
<table>
  <tr>
    <th>카테고리</th>
    <th>총소비</th>
    <th>전월대비</th>
  </tr>
  <c:forEach var="vo" items="${consumeList }">
  <tr>
    <td>${vo.bk_category }</td>
    <td>${vo.bk_total_consume }</td>
    <td>${vo.bk_consume_compare }</td>
  </tr>
  </c:forEach>
</table>


<%@ include file="../include/footer.jsp"%>