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
   <h1>card_search.jsp</h1>
   
     <table>
		<tr>
			<th>카드구분</th>
			<th>계좌번호</th>
			<th>카드발급일자</th>
			
		</tr>
			<tr>
				<td>${cardSearchResponse.card_type }</td>
				<td>${cardSearchResponse.settlement_account_num }</td>
				<td>${cardSearchResponse.issue_date }</td>
			</tr>
	</table>
	
</body>
</html>