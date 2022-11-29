<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
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

  <!-- Google Fonts -->
  <link href="https://fonts.googleapis.com/css?family=Open+Sans:300,300i,400,400i,600,600i,700,700i|Roboto:300,300i,400,400i,500,500i,600,600i,700,700i|Poppins:300,300i,400,400i,500,500i,600,600i,700,700i" rel="stylesheet">

  <!-- Vendor CSS Files -->
  <link href="${pageContext.request.contextPath}/resources/vendor/aos/aos.css" rel="stylesheet">
  <link href="${pageContext.request.contextPath}/resources/vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">
  <link href="${pageContext.request.contextPath}/resources/vendor/bootstrap-icons/bootstrap-icons.css" rel="stylesheet">
  <link href="${pageContext.request.contextPath}/resources/vendor/boxicons/css/boxicons.min.css" rel="stylesheet">
  <link href="${pageContext.request.contextPath}/resources/vendor/glightbox/css/glightbox.min.css" rel="stylesheet">

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
  text-align: center; 
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
	td:nth-of-type(1):before { content: "표준코드"; }
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
        <th style="text-align: center;">표준코드</th>
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
		<td>
			${accountBalance.bank_code_tran }
		</td>
		<td>${accountBalance.bank_name }</td>
		<td id="req2_balance_amt"> <fmt:formatNumber value="${accountBalance.balance_amt }" pattern="#,###"  /> </td>
		<td><fmt:formatNumber value="${accountBalance.available_amt }" pattern="#,###"  /></td>
		<td>${accountBalance.product_name }</td>
		<td>
			<fmt:parseDate value="${accountBalance.account_issue_date }"  var="date2" pattern="yyyyMMdd"/>
			<fmt:formatDate value="${date2 }" pattern="yyyy.MM.dd"/>
		</td>
		<td>
			<fmt:parseDate value="${accountBalance.maturity_date }"  var="date3" pattern="yyyyMMdd"/>
			<fmt:formatDate value="${date3 }" pattern="yyyy.MM.dd	"/>
			
		</td>
		<td>
		<fmt:parseDate value="${accountBalance.last_tran_date }"  var="date4" pattern="yyyyMMdd"/>
			<fmt:formatDate value="${date4 }" pattern="yyyy.MM.dd	"/>
			
		</td>
      </tr>
    </tbody>
  </table>	
