<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ include file="../include/header.jsp"%>
<!-- ${pageContext.request.contextPath} -->
<script src="https://code.jquery.com/jquery-3.6.0.js"></script>
<%
if(session!=null){
	String loginid = (String)session.getAttribute("loginID");
}

%>


<h1>한 달 예산⏰ </h1>
<%=loginID %>님의 한달 예산💷💶💵💴<br>

💰원 남음<br>
이번달 예산의 만큼 지출했어요 💸<br>

전체 내역🔻




<%@ include file="../include/footer.jsp"%>