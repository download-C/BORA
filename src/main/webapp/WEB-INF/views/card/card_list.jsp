<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
   <form action="/fintech/cardSearch" method="get">
     <table>
		<tr>
			<th>카드번호</th><th>카드명</th><th>카드회원번호</th>
		</tr>
		<%-- cardList 객체에 저장되어 있는 카드 목록(card_list) 가져와서 반복하여 복수개 계좌 접근 --%>
		<c:forEach var="card" items="${cardList.card_list }">
			<tr>
			    <td>${card.card_id }</td>
				<td>${card.card_name }</td>
				<td>${card.card_member_type }</td>
				<td><input type="submit" value="조회"></td>
			</tr>
		</c:forEach>
	  </table>
	</form>
	
</body>
</html>