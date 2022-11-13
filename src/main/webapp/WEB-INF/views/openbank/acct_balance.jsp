<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!-- ${pageContext.request.contextPath} -->
<script src="https://code.jquery.com/jquery-3.6.0.js"></script>


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
/* 
Max width before this PARTICULAR table gets nasty
This query will take effect for any screen smaller than 760px
and also iPads specifically.
*/
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
  
  
</head>
<body>
  <table>
    <thead>
      <tr>
<!--         <th style="text-align: center;">거래일시</th> -->
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
<%--         <td>${accountBalance.api_tran_dtm }</td> --%>
		<td>${accountBalance.bank_tran_date }</td>
		<td>${accountBalance.bank_name }</td>
		<td>${accountBalance.balance_amt }</td>
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
// let bal = "<c:out value='${accountBalance.balance_amt }' />";

balArr = JSON.parse(localStorage.getItem('balArr') || '[]'); // [] 이건 왜 하는거? ㄱ- 
console.log(balArr);

//임의로 값 넣어서 테스트 완,, 
// name에는 상품명, bal에는 계좌잔액 EL 표현식 저거 넣기
balArr.push({name:'bora', bal:'${accountBalance.balance_amt }'});        
console.log('(test) bora통장 --> 4000 넣었음');
localStorage.setItem('balArr', JSON.stringify(balArr)); // 새 요소 추가했으니,, balArr 업뎃시키기 

// balArr.push({name:'123', bal:2000});
// console.log('123통장 --> 2000 넣었음');
// localStorage.setItem('balArr', JSON.stringify(balArr)); 

console.log(balArr);
</script>
  
  <h3><a href='/openbank/goal'>자산관리 목표 설정 이동</a></h3> <br>
