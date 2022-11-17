<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ include file="../include/header.jsp"%>
<!-- ${pageContext.request.contextPath} -->
<script src="https://code.jquery.com/jquery-3.6.0.js"></script>

  <link href="${pageContext.request.contextPath}/resources/css/login.css" rel="stylesheet">

<!-- title -->
<div class="section-title">
  <h2><b>내 자산 보기</b></h2>
</div>
<!-- End title -->
<br>


<style type="text/css">
   .box{
       width : 100%;
       height : 100%;
       margin : 0;
       padding : 0;
       border : none;  
       overflow : auto;                    
   }    
</style> 

   <style>
    .tbtn {
      background-color: #5107B0;
      float: center;
/*       width: 330px; */
/*       height: 70px; */
      margin :30px;  
      padding: 20px 50px 20px 50px;
      border: 1px solid #fff;
      border-radius: 8px;
      color: white; 
/*       color: #e3cffc; */
      border-radius: 13px;
      font-size: 20px;
    }
    
    .floatingInput {
    	color: red;
    }
    	
  </style>
  

  <div class="container">
  	<div class="box" style="display: flex; justify-content: space-between; flex-flow: row nowrap;">
<!--   	<div class="box" style="display: flex; justify-content: space-between; flex-flow: row nowrap;"> -->
	
<!--     <div class="row"> -->
      <div class="col-sm-9 col-md-7 col-lg-70 mx-auto">
        <div class="card border-0 shadow rounded-3 my-5">
          <div class="card-body p-3 p-sm-5" style="background-color:#F5EFFE;">
            <h1 class="card-title text-center mb-5 fw-light fs-13"><b>사용자 인증 결과</b></h1>
            <form>
                <label for="floatingInput">사용자 번호</label>
              <div class="form-floating mb-3">
              	<span class="form-control" id="floatingInput">${userInfo.user_seq_no }</span>
              </div>
                <label for="floatingInput">사용자 이름</label>
              <div class="form-floating mb-3">
              	<span class="form-control" id="floatingInput">${userInfo.user_name }</span>
              </div>
                <label for="floatingInput">등록 계좌수</label>
              <div class="form-floating mb-3">
              	<span class="form-control" id="floatingInput">${userInfo.res_cnt }</span>
              </div>
            </form>
    </div>
    </div>
    <!-- 내 보유 계좌  -->
<!--     	<div class="box" style="display: flex; justify-content: space-between; flex-flow: row nowrap;"> -->
    	<div class="col-sm-19 col-md-17 col-lg-80 mx-auto" style="display: flex; justify-content: space-between;">
  		<form method="get" action="/openbank/accountList">
			<!-- 		필요 파라미터는 입력데이터 없이 hidden 속성으로 전달 -->
			<input type="hidden" name="access_token" value="${sessionScope.token }">
			<%-- 		<input type="hidden" name="user_seq_no" value="${responseToken.user_seq_no }"> --%>
			<input type="hidden" name="user_seq_no" value="${userInfo.user_seq_no }"> 
			<input type="hidden" name="include_cancel_yn" value="Y"> 
			<input type="hidden" name="sort_order" value="D"> 
			<button type="submit" class="tbtn"><b style="color:#e3cffc;">내 보유 계좌&nbsp;</b>보러 가기</button>
		</form>
	
    <!-- 내 보유 카드  -->
		<form method="get" action="/openbank/cardList">
			<%-- 필요 파라미터는 입력데이터 없이 hidden 속성으로 전달 --%>
		    <input type="hidden" name="access_token" value="${sessionScope.token }">
		    <input type="hidden" name="bank_tran_id" value="${cardList.bank_tran_id }">
			<input type="hidden" name="user_seq_no" value="${userInfo.user_seq_no }">
		    <input type="hidden" name="bank_code_std" value="399">
		    <input type="hidden" name="member_bank_code" value="399">
        <!-- <input type="hidden" name="befor_inquiry_trace_info" value="V"> -->
			<button type="submit" class="tbtn"><b style="color:#e3cffc;">내 보유 카드&nbsp;</b>보러 가기</button>
		</form>
		
	<!-- 목돈 모으기  -->	
<!-- 		<form method="get" action="/openbank/goal"> -->
<%-- 			<input type="hidden" name="access_token" value="${sessionScope.token }">  --%>
<%-- 			<input type="hidden" name="bank_tran_id" value="${accountBalance.bank_tran_id }"> --%>
<!-- 			<input type="hidden" name="fintech_use_num" value="120220217888941294172171">  -->
<!-- 			<input type="hidden" name="tran_dtime" value="20221104134521">  -->
<!-- 			<button type="submit" class="tbtn"><b style="color:#e3cffc;">목돈&nbsp;</b>모으기</button> -->
<!-- 		</form> -->
		
		
		
	</div>
  </div>
  </div>
  </div>
 
			
<br><br><br>			


	

<%@ include file="../include/footer.jsp"%>