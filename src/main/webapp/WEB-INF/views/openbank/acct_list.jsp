<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>openbankInsert title here</title>
</head>
<body>
<h1>계좌목록</h1>

	<table>
		<tr>
			<th>계좌번호</th><th>은행명</th><th>예금주명</th>
		</tr>
		<%-- accountList 객체에 저장되어 있는 계좌 목록(res_list) 가져와서 반복하여 복수개 계좌 접근 --%>
		<c:forEach var="account" items="${accountList.res_list }">
			<tr>
				<td>마스팅된 출력용 계좌번호 : ${account.account_num_masked }</td>
				<td>은행이름: ${account.bank_name }</td>
				<td>계좌예금주명 : ${account.account_holder_name }</td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>













