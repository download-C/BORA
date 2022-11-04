<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>openbankInsert title here</title>
</head>
<body>
<h1>계좌목록</h1>
 	
<h3>계좌구분(P:개인)</h3>
<h3>계좌종류주3) 1:수시입출금, 2:예적금 6:수익증권, T:종합계좌</h3>
<hr>
	<table>
		<tr>
			<th>마스킹된 출력용 계좌번호</th>
			<th>은행명</th>
			<th>계좌구분</th>
			<th>계좌종류</th>
			<th>예금주명</th>
			<th>계좌별명</th>
		</tr>
		<%-- accountList 객체에 저장되어 있는 계좌 목록(res_list) 가져와서 반복하여 복수개 계좌 접근 --%>
		<c:forEach var="accountList" items="${accountList.res_list }">
			<tr>
				<td>${accountList.account_num_masked }</td>
				<td>${accountList.bank_name }</td>
				<td>${accountList.account_holder_type }</td>
				<td>${accountList.account_type }</td>
				<td>${accountList.account_holder_name }</td>
				<td>${accountList.account_alias }</td>
			</tr>
		</c:forEach>
	</table>
	
	
	
</body>
</html>













