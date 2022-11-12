<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ include file="../include/header.jsp"%>
<!-- ${pageContext.request.contextPath} -->
<script src="https://code.jquery.com/jquery-3.6.0.js"></script>
<h1>board/insert.jsp</h1>


<!-- title -->
<div class="section-title">
  <h2><b>계좌 잔액 조회</b></h2>
  
</div>
<!-- End title -->


<h3>계좌종류 1:수시입출금, 2:예적금 6:수익증권, T:종합계좌</h3>

<hr>
<%-- 	<h3>거래고유번호 : ${accountBalance.api_tran_id }</h3> --%>
	<h3>거래일시(밀리세컨드) : ${accountBalance.api_tran_dtm }</h3>
	<h3>거래일자(참가은행) : ${accountBalance.bank_tran_date }</h3>
	<h3>은행이름 : ${accountBalance.bank_name }</h3>
<%-- 	<h3>핀테크이용번호 : ${accountBalance.fintech_use_num }</h3> --%>
	<h3>계좌잔액(-금액가능) : ${accountBalance.balance_amt }</h3>
	<h3>출금가능금액 : ${accountBalance.available_amt }</h3>
<%-- 	<h3>계좌종류 : ${accountBalance.account_type }</h3> --%>
	<h3>상품명 : ${accountBalance.product_name }</h3>
	<h3>계좌개설일 : ${accountBalance.account_issue_date }</h3>
	<h3>만기일 : ${accountBalance.maturity_date }</h3>
	<h3>최종거래일 : ${accountBalance.last_tran_date }</h3>
	

<script>
// localStorage에 저장해놨던 balArr 끄집어내서
//  --> 은행 별로 name, bal로 balArr 배열에 저장
// let bal = "<c:out value='${accountBalance.balance_amt }' />";

balArr = JSON.parse(localStorage.getItem('balArr') || '[]'); // [] 이건 왜 하는거? ㄱ- 
console.log(balArr);

//임의로 값 넣어서 테스트 완,, 
// name에는 상품명, bal에는 계좌잔액 EL 표현식 저거 넣기
balArr.push({name:'bora', bal:4000});        
console.log('(test) bora통장 --> 4000 넣었음');
localStorage.setItem('balArr', JSON.stringify(balArr)); // 새 요소 추가했으니,, balArr 업뎃시키기 

balArr.push({name:'123', bal:2000});
console.log('123통장 --> 2000 넣었음');
localStorage.setItem('balArr', JSON.stringify(balArr)); 

console.log(balArr);
</script>

<%@ include file="../include/footer.jsp"%>