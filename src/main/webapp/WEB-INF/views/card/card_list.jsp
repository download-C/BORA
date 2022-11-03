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
     <table>
		<tr>
			<th>카드번호</th><th>카드명</th><th>카드회원번호</th>
		</tr>
		<%-- card 객체에 저장되어 있는 카드 목록(card_list) 가져와서 반복하여 복수개 계좌 접근 --%>
		<c:forEach var="card" items="${card.card_list }">
			<tr>
			    <td>${card.card_id }</td>
				<td>${card.card_name }</td>
				<td>${card.card_member_type }</td>
			</tr>
		</c:forEach>
	  </table>
	<form action="/fintech/cardSearch" method="get">
	    <input type="hidden" name="access_token" value="${responseToken.access_token }">
	    <input type="hidden" name="bank_tran_id" value="D">
		<input type="hidden" name="user_seq_no" value="${responseToken.user_seq_no }">
		<input type="hidden" name="bank_code_std" value="D">
		<input type="hidden" name="member_bank_code" value="D">
		<input type="hidden" name="card_id" value="D">
		<input type="submit" value="카드정보조회">
	</form>
	
	<form method="get" action="/fintech/cardBills">
        <%-- 필요 파라미터는 입력데이터 없이 hidden 속성으로 전달 --%>
		<input type="hidden" name="access_token" value="${responseToken.access_token }">
		<input type="hidden" name="bank_tran_id" value="D">
		<input type="hidden" name="user_seq_no" value="${responseToken.user_seq_no }">
		<input type="hidden" name="bank_code_std" value="D">
		<input type="hidden" name="member_bank_code" value="D">
		<input type="hidden" name="from_month" value="Y">
		<input type="hidden" name="to_month" value="Y">
		<input type="submit" value="카드청구조회">
     </form>
     
     <form method="get" action="/fintech/cardDetailBills">
        <%-- 필요 파라미터는 입력데이터 없이 hidden 속성으로 전달 --%>
		<input type="hidden" name="access_token" value="${responseToken.access_token }">
		<input type="hidden" name="bank_tran_id" value="D">
		<input type="hidden" name="user_seq_no" value="${responseToken.user_seq_no }">
		<input type="hidden" name="bank_code_std" value="D">
		<input type="hidden" name="member_bank_code" value="D">
		<input type="hidden" name="charge_month" value="Y">
		<input type="hidden" name="settlement_seq_no" value="Y">
		<input type="submit" value="카드상세청구조회">
     </form>
     
     <form method="get" action="/fintech/PrePadTran">
        <%-- 필요 파라미터는 입력데이터 없이 hidden 속성으로 전달 --%>
		<input type="hidden" name="access_token" value="${responseToken.access_token }">
		<input type="hidden" name="bank_tran_id" value="D">
		<input type="hidden" name="user_seq_no" value="${responseToken.user_seq_no }">
		<input type="hidden" name="bank_code_std" value="D">
		<input type="hidden" name="faceofbill_id" value="Y">
		<input type="hidden" name="to_date" value="Y">
		<input type="submit" value="선불거래내역조회">
     </form>
</body>
</html>