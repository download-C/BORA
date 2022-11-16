<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
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
    .tdbtn {
      background-color: #5107B0;
      font-size: 12 px;
      color: #fff;
      padding: 2;
      margin: 0;
      border: 1px solid #fff;
      border-radius: 8px;
    }

    .modal {
      --bs-modal-width: 1300px;
      --bs-modal-height: 850px;
    }
    
</style>


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
	td:nth-of-type(1):before { content: "카드구분"; }
	td:nth-of-type(2):before { content: "은행코드"; }
	td:nth-of-type(3):before { content: "계좌번호"; }
	td:nth-of-type(4):before { content: "카드발급일자"; }
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
			<th style="text-align: center;">카드구분</th>
		    <th style="text-align: center;">은행코드</th>
			<th style="text-align: center;">계좌번호</th>
			<th style="text-align: center;">카드발급일자</th>
		 </tr>
		</thead>
		<tbody>
			<tr>
				<td>${cardInfo.card_type }</td>
				<td>${cardInfo.settlement_bank_code }</td>
				<td>${cardInfo.settlement_account_num_masked }</td>
				<td>${cardInfo.issue_date }</td>
			</tr>	
		</tbody>
	</table>
	<div class="col-2" style="padding-left: 0;">
        <div class="table-responsive">
          <table class="table table-hover" style="border-right: none;  border-radius: 0; box-shadow: none;">
            <thead>
              <tr>
                <th scope="col" style="color:black">업무</th>
              </tr>
            </thead>
            <tbody>

             <tr>
               <td style="padding-bottom: 6px; padding-top: 6px;">
                <!-- 카드청구기본정보조회 -->
	            <form method="get" action="/openbank/cardBills">
                <%-- 필요 파라미터는 입력데이터 없이 hidden 속성으로 전달 --%>
		        <input type="hidden" name="access_token" value="${sessionScope.token }">
		        <input type="hidden" name="bank_tran_id" value="${sessionScope.bank_tran_id }">
			    <input type="hidden" name="user_seq_no" value="${sessionScope.user_seq_no }">
		        <input type="hidden" name="bank_code_std" value="399">
		        <input type="hidden" name="member_bank_code" value="399">
		        <input type="hidden" name="from_month" value="202210">
		        <input type="hidden" name="to_month" value="202211">
		        <input type="submit" class="tdbtn" value="카드청구조회">
                </form>
               </td>
              </tr>
            </tbody>
          </table>
        </div>
      </div>
      
      <!-- 모달창 -->
   <!--   	거래내역조회 -->
  <!-- The Modal -->
  <div class="modal" id="myModal">
    <div class="modal-dialog modal-dialog-scrollable">
      <div class="modal-content">

        <!-- Modal Header -->
        <div class="modal-header">
          <h4 class="modal-title">카드기본정보조회</h4>
          <button type="button" class="btn-close" data-bs-dismiss="modal"></button>
        </div>

        <!-- Modal body -->
        <div class="modal-body">
          <div class="container">
<!--             <iframe src="modaltable.html" style="width: 100%;"></iframe> -->
            <iframe src="./acct_tran.jsp" style="width: 100%;" name="frm1"></iframe>

            <!-- End table -->

          </div>
        </div>

        <!-- Modal footer -->
        <div class="modal-footer">
          <button type="button" class="btn btn-danger" data-bs-dismiss="modal">닫기</button>
        </div>
      </div>
    </div>
  </div>
