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
   <h1>card_info.jsp</h1>
   
     <table border="1">
		<tr>
			<th>카드구분</th>
		    <th>은행코드</th>
			<th>계좌번호</th>
			<th>카드발급일자</th>
			
		</tr>
			<tr>
				<td>${cardInfo.card_type }</td>
				<td>${cardInfo.settlement_bank_code }</td>
				<td>${cardInfo.settlement_account_num_masked }</td>
				<td>${cardInfo.issue_date }</td>
			</tr>	
	</table>
	
</body>
</html>