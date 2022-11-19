<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!-- ${pageContext.request.contextPath} -->
<script src="https://code.jquery.com/jquery-3.6.0.js"></script>

<style type="text/css">
input::-webkit-outer-spin-button,
input::-webkit-inner-spin-button {
  -webkit-appearance: none;
  margin: 0;
}
</style>

  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">

  <title>BizLand Bootstrap Template - Index</title>
  <meta content="" name="description">
  <meta content="" name="keywords">

  <!-- Favicons -->
  <link href="${pageContext.request.contextPath}/resources/img/favicon.png" rel="icon">
  <link href="${pageContext.request.contextPath}/resources/img/apple-touch-icon.png" rel="apple-touch-icon">

  <!-- Google Fonts -->
  <link href="https://fonts.googleapis.com/css?family=Open+Sans:300,300i,400,400i,600,600i,700,700i|Roboto:300,300i,400,400i,500,500i,600,600i,700,700i|Poppins:300,300i,400,400i,500,500i,600,600i,700,700i" rel="stylesheet">

  <!-- Vendor CSS Files -->
  <link href="${pageContext.request.contextPath}/resources/vendor/aos/aos.css" rel="stylesheet">
  <link href="${pageContext.request.contextPath}/resources/vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">
  <link href="${pageContext.request.contextPath}/resources/vendor/bootstrap-icons/bootstrap-icons.css" rel="stylesheet">
  <link href="${pageContext.request.contextPath}/resources/vendor/boxicons/css/boxicons.min.css" rel="stylesheet">
  <link href="${pageContext.request.contextPath}/resources/vendor/glightbox/css/glightbox.min.css" rel="stylesheet">
<%--   <link href="${pageContext.request.contextPath}/resources/vendor/swiper/swiper-bundle.min.css" rel="stylesheet"> --%>


  <!-- Template Main CSS File -->
  <link href="${pageContext.request.contextPath}/resources/css/style.css" rel="stylesheet">
  <link href="${pageContext.request.contextPath}/resources/css/moneyMN.css" rel="stylesheet">


<style>
    /* 
Generic Styling, for Desktops/Laptops 
*/
table { 
  width: 100%; 
  border-collapse: collapse; 
  border-radius: 12px; box-shadow: 7px 14px 90px 3px rgba(163, 174, 184, 0.7);
}

/* Zebra striping */
tr:nth-of-type() { 
  background: #eee; 
}

th { 
  background: #7a1cf6; 
  color: #fff; 
  font-weight: bold; 
  text-align: center;
}

td, th { 
  padding: 6px; 
  border-top: 1px solid #ddd; 
  border-left: 1px solid #ddd; 
  text-align: left; 
}

@media 
only screen and (max-width: 760px),
(min-device-width: 768px) and (max-device-width: 1024px)  {

	/* Force table to not be like tables anymore */
	table, thead, tbody, th, td, tr { 
		display: block; 
	}

	/* Hide table headers (but not display: none;, for accessibility) */
	thead tr { 
		position: absolute;
		top: -9999px;
		left: -9999px;
	}
	
	tr { border: 1px solid black; }
	
	td { 
		/* Behave  like a "row" */
		border: none;
		border-bottom: 1px solid #ddd; 
		position: relative;
		padding-left: 30%; 
	}
	
	td:before { 
		/* Now like a table header */
		position: absolute;
		/* Top/left values mimic padding */
		top: 6px;
		left: 6px;
		width: fit-content; 
		white-space: nowrap;
		background: linear-gradient(to top, #ecdffd 70%, transparent 30%);
		font-weight: bold; 
	}
	/*
	Label the data
	*/
	td:nth-of-type(1):before { content: "거래일자"; }
	td:nth-of-type(2):before { content: "은행"; }
	td:nth-of-type(3):before { content: "계좌잔액"; }
	td:nth-of-type(4):before { content: "출금가능금액"; }
	td:nth-of-type(5):before { content: "상품명"; }
	td:nth-of-type(6):before { content: "계좌개설일"; }
	td:nth-of-type(7):before { content: "만기일"; }
	td:nth-of-type(8):before { content: "최종거래일"; }
}
</style>
  
<body>
  <table>
    <thead>
      <tr>
        <th style="text-align: center;">거래일자</th>
        <th style="text-align: center;">은행</th>
        <th style="text-align: center;">계좌잔액</th>
        <th style="text-align: center;">출금가능금액</th>
        <th style="text-align: center;">상품명</th>
        <th style="text-align: center;">계좌개설일</th>
        <th style="text-align: center;">만기일</th>
        <th style="text-align: center;">최종거래일</th>
      </tr>
    </thead>
    <tbody>
      <tr>
		<td>${accountBalance.bank_tran_date }</td>
		<td>${accountBalance.bank_name }</td>
		<td id="req2_balance_amt">${accountBalance.balance_amt }</td>
		<td>${accountBalance.available_amt }</td>
		<td>${accountBalance.product_name }</td>
		<td>${accountBalance.account_issue_date }</td>
		<td>${accountBalance.maturity_date }</td>
		<td>${accountBalance.last_tran_date }</td>
      </tr>
    </tbody>
  </table>	
  
  
<script>
// localStorage에 저장해놨던 balArr 끄집어내서
//  --> 은행 별로 name, bal로 balArr 배열에 저장
// let bal = "<c:out value='${accountBalance.balance_amt }' />"; // 왜 얘는 c out  안 해도 그냥 뜨지??
// let name = "<c:out value='${accountBalance.product_name }' />";
let bal = parseInt('${accountBalance.balance_amt }');
let name = '${accountBalance.product_name }';

balArr = JSON.parse(localStorage.getItem('balArr') || '[]'); // [] 이건 왜 하는거? ㄱ- 
console.log(balArr);

//임의로 값 넣어서 테스트 완,, 
// name에는 상품명, bal에는 t계좌잔액 EL 표현식 저거 넣기
balArr.push({name: name, bal: bal });        
localStorage.setItem('balArr', JSON.stringify(balArr)); // 새 요소 추가했으니,, balArr 업뎃시키기 

// balArr.push({name:'${accountBalance.product_name }', bal:'${accountBalance.balance_amt }''});
// console.log('123통장 --> 2000 넣었음');
// localStorage.setItem('balArr', JSON.stringify(balArr)); 

console.log(balArr);
</script>