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
     <table border="1">
		<tr>
			<th>카드식별자</th><th>카드번호</th><th>상품명</th><th>카드회원구분</th>
		</tr>
		<%-- card 객체에 저장되어 있는 카드 목록(card_list) 가져와서 반복하여 복수개 계좌 접근 --%>
		<c:forEach var="cardList" items="${cardList.card_list }">
			<tr>
			    <td>${cardList.card_id }</td>
			    <td>${cardList.card_num_masked }</td>
				<td>${cardList.card_name }</td>
				<td>${cardList.card_member_type }</td>
			</tr>
		</c:forEach>
	  </table>
	  
	
	
</body>
</html>
