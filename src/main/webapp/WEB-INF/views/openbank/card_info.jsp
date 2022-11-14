<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
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
	td:nth-of-type(2):before { content: "입출금구분"; }
	td:nth-of-type(3):before { content: "거래타입"; }
	td:nth-of-type(4):before { content: "통장인자내용"; }
	td:nth-of-type(5):before { content: "거래금액"; }
	td:nth-of-type(6):before { content: "거래후잔액"; }
	td:nth-of-type(7):before { content: "거래점명"; }
}
  </style>

<!-- title -->
<div class="section-title">
   <h1>카드 기본 정보 조회</h1>

</div>
<!-- End title -->

     <table>
		<thead>
		 <tr>
			<th class="text-secondary text-xs font-weight-semibold opacity-7 ps-2">카드구분</th>
		    <th class="text-secondary text-xs font-weight-semibold opacity-7 ps-2">은행코드</th>
			<th class="text-secondary text-xs font-weight-semibold opacity-7 ps-2">계좌번호</th>
			<th class="text-secondary text-xs font-weight-semibold opacity-7 ps-2">카드발급일자</th>
		 </tr>
		</thead>
		<tbody>
			<tr>
				<td><span class="text-sm font-weight-normal">${cardInfo.card_type }</span></td>
				<td><span class="text-sm font-weight-normal">${cardInfo.settlement_bank_code }</span></td>
				<td><span class="text-sm font-weight-normal">${cardInfo.settlement_account_num_masked }</span></td>
				<td><span class="text-sm font-weight-normal">${cardInfo.issue_date }</span></td>
			</tr>	
		</tbody>
	</table>
