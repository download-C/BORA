<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ include file="../include/header.jsp"%>
<!-- ${pageContext.request.contextPath} -->
<script src="https://code.jquery.com/jquery-3.6.0.js"></script>
<%
	if (loginID == null) {
%>
<!-- 세션값(로그인) 확인 -->
<script>
	// 세션값 여부
	alert("로그인 후 이용 가능합니다. 로그인 페이지로 이동합니다.");
	location.href = "/main/login";

	$(document).ready(function() {
		let message = "${msg}";
		if (message != "") {
			alert(message);
		}
	})
	
	
	
</script>
<%
	}
%>

<script>
	$(document).ready(function(){
	 $('#month').change(function(){
		 alert($('#year').val());
		 alert($('#month').val());
	 });
	});

</script>

<h1>top3.jsp</h1>

	<c:set var="year" value="<%=year%>" />
	<c:set var="month" value="<%=month %>" />


<main class="hana__main-wrap" style="margin: 140px 140px">
		<div class="form-floating" style="position: relative" align="center">
			<div style="margin-bottom: 50px">
				<form id="form1" method="get" action="" style="display:inline-block; width: 7%; height: 10%;">
					 <select name="year" id="year" onchange="changeSelect()" >
				        <option value="2022" <c:if test="${year eq '2022'}">selected</c:if>>2022</option>
				        <option value="2021" <c:if test="${year eq '2021'}">selected</c:if>>2021</option>
				     </select>
				 </form>
			     <a style="font-size: 25px; font-weight: bold;">년 &nbsp</a>
			     <form id="form2" method="get" action="" style="display:inline-block; width: 6%">
			    	<select name="month" id="month" onchange="changeSelect()">
				        <option name="1" value="1" <c:if test="${month eq '1'}">selected</c:if>>1</option>
				        <option name="2" value="2" <c:if test="${month eq '2'}">selected</c:if>>2</option>
				        <option name="3" value="3" <c:if test="${month eq '3'}">selected</c:if>>3</option>
				        <option name="4" value="4" <c:if test="${month eq '4'}">selected</c:if>>4</option>
				        <option name="5" value="5" <c:if test="${month eq '5'}">selected</c:if>>5</option>
				        <option name="6" value="6" <c:if test="${month eq '6'}">selected</c:if>>6</option>
				        <option name="7" value="7" <c:if test="${month eq '7'}">selected</c:if>>7</option>
				        <option name="8" value="8" <c:if test="${month eq '8'}">selected</c:if>>8</option>
				        <option name="9" value="9" <c:if test="${month eq '9'}">selected</c:if>>9</option>
				        <option name="10" value="10" <c:if test="${month eq '10'}">selected</c:if>>10</option>
				        <option name="11" value="11" <c:if test="${month eq '11'}">selected</c:if>>11</option>
				        <option name="12" value="12" <c:if test="${month eq '12'}">selected</c:if>>12</option> 
			    	</select>
				</form>
			     <a style="font-size: 25px; font-weight: bold;">월 &nbsp소비리포트</a>
			</div>
		</div>
		


<div class="panel panel-default">
	<div class="panel-heading"><%=loginID%>님의 이번 달 소비 TOP3
	</div>
	<div class="panel-body">
		<table class="table table-hover table-bordered">
			<tr>
				<td>내역명</td>
				<td>금액</td>
			</tr>

			<c:forEach var="vo" items="${top3}">
				<tr>
					<td>${vo.bk_memo}</td>
					<td>${vo.bk_money}</td>
				</tr>
			</c:forEach>

		</table>
	</div>
	

	<div class="panel panel-default">
		<div class="panel-heading"><%=loginID%>님의 이번 달 소비 TOP3 날짜
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
						<td>${vo.bk_sum}</td>
					</tr>
				</c:forEach>

			</table>
		</div>

		<hr>


		<div class="col-lg-44" style="margin-top: 100px; margin-bottom: 100px"
			align="center">
			<a style="font-size: 23px; font-weight: bold;">이번 달 나의 소비 ROLE</a><br>
			<c:choose>
				<c:when test="${bk_category eq '식비'}">
					<img src="${pageContext.request.contextPath}/resources/img/food.png"
						style="width: 500px; height: 300px; margin-top: 30px;">
				</c:when>
				<c:when test="${bk_category eq '교통비'}">
					<img src="${pageContext.request.contextPath}/resources/img/food.png"
						style="width: 500px; height: 300px; margin-top: 30px;">
				</c:when>
				<c:when test="${bk_category eq '편의점/마트'}">
					<img src="${pageContext.request.contextPath}/resources/img/food.png"
						style="width: 500px; height: 300px; margin-top: 30px;">
				</c:when>
				<c:when test="${bk_category eq '통신비'}">
					<img src="${pageContext.request.contextPath}/resources/img/phone.png"
						style="width: 500px; height: 300px; margin-top: 30px;">
				</c:when>
				<c:when test="${bk_category eq '여가비'}">
					<img src="${pageContext.request.contextPath}/resources/img/travel.png"
						style="width: 500px; height: 300px; margin-top: 30px;">
				</c:when>
				<c:when test="${bk_category eq '뷰티/쇼핑'}">
					<img src="${pageContext.request.contextPath}/resources/img/shopping.png"
						style="width: 500px; height: 300px; margin-top: 30px;">
				</c:when>
				<c:when test="${bk_category eq '저축'}">
					<img src="${pageContext.request.contextPath}/resources/img/saving.png"
						style="width: 500px; height: 300px; margin-top: 30px;">
				</c:when>
				<c:otherwise>
					<img src="${pageContext.request.contextPath}/resources/img/pig.png"
						style="width: 500px; height: 300px; margin-top: 30px;">
				</c:otherwise>
			</c:choose>
		</div>

</main>



		<%@ include file="../include/footer.jsp"%>