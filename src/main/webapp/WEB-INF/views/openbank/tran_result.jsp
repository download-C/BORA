<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>이체내역조회</h1>

출력 : ${tranResult.res_cnt }

<!-- 	<table> -->
<!-- 		<tr> -->
<!-- 			<th>11</th> -->
<!-- 			<th>22</th> -->
<!-- 		</tr> -->
<%-- 		<%-- tran_res_list 객체에 저장되어 있는 계좌 목록(tran_res_list) 가져와서 반복하여 복수개 계좌 접근 --%> 
<%-- 		<c:forEach var="tranResult" items="${tranResult.tran_res_list }"> --%>
<!-- 			<tr> -->
<%-- 				<td>${tranResult.tran_no }</td> --%>
<%-- 				<td>${tranResult.tran_amt }</td> --%>
<!-- 			</tr> -->
<%-- 		</c:forEach> --%>
<!-- 	</table> -->

</body>
</html>