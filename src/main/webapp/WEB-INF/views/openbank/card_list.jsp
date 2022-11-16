<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ include file="../include/header.jsp"%>
<!-- ${pageContext.request.contextPath} -->
<script src="https://code.jquery.com/jquery-3.6.0.js"></script>
     
<!-- title -->
<div class="section-title">  
  <h2>보유 카드 목록</h2>
</div>
<!-- End title -->

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

<!-- card -->
  <div class="container">
    <h4 style="background: linear-gradient(to top, #c8a7fa 50%, transparent 50%); width: fit-content;">카드</h4><br>
    <div class="row justify-content-center">
      <div class="col-10" style="padding-right: 0;">
        <div class="table-responsive">
        <table class="table table-hover" style="border-right: none; border-radius: 0; box-shadow: none;">
		 <thead class="bg-gray-100">
		  <tr style="font-size: 16px; ">
			<th scope="col" style="color:black">카드식별자</th>
			<th scope="col" style="color:black">카드번호</th>
			<th scope="col" style="color:black">상품명</th>
			<th scope="col" style="color:black">카드회원구분</th>
		  </tr>
		 </thead>
		 <tbody>	
		 <%-- card 객체에 저장되어 있는 카드 목록(card_list) 가져와서 반복하여 복수개 계좌 접근 --%>
		 <c:forEach var="cardList" items="${cardList.card_list }" end="4">
			<tr>
			    <td>${cardList.card_id }</td>
			    <td>${cardList.card_num_masked }</td>
				<td>${cardList.card_name }</td>
				<td>${cardList.card_member_type }</td>
			</tr>
		</c:forEach>
		</tbody>
	  </table>
	</div> <!-- container -->
	</div>
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
                
                    <form action="/openbank/cardInfo" method="post">
		            <input type="hidden" name="access_token" value="${sessionScope.token }">
	                <input type="hidden" name="bank_tran_id" value="${sessionScope.bank_tran_id }">
			        <input type="hidden" name="user_seq_no" value="${sessionScope.user_seq_no }">
		            <input type="hidden" name="bank_code_std" value="399">
		            <input type="hidden" name="member_bank_code" value="399">
		            <input type="hidden" name="card_id" value="itwill01">
		            <input type="submit" value="정보조회" class="tdbtn" data-bs-toggle="modal" data-bs-target="#myModal">
		            </form>
     
                </td>
              </tr>
              <tr>
                <td style="padding-bottom: 6px; padding-top: 6px;">
                    
                    <form action="/openbank/cardInfo" method="post">
		            <input type="hidden" name="access_token" value="${sessionScope.token }">
	                <input type="hidden" name="bank_tran_id" value="${sessionScope.bank_tran_id }">
			        <input type="hidden" name="user_seq_no" value="${sessionScope.user_seq_no }">
		            <input type="hidden" name="bank_code_std" value="399">
		            <input type="hidden" name="member_bank_code" value="399">
		            <input type="hidden" name="card_id" value="itwill02">
		            <input type="submit" value="정보조회" class="tdbtn" data-bs-toggle="modal" data-bs-target="#myModal">
		            </form>
              </tr>
              <tr>
                <td style="padding-bottom: 6px; padding-top: 6px;">
                
                    <form action="/openbank/cardInfo" method="post">
		            <input type="hidden" name="access_token" value="${sessionScope.token }">
	                <input type="hidden" name="bank_tran_id" value="${sessionScope.bank_tran_id }">
			        <input type="hidden" name="user_seq_no" value="${sessionScope.user_seq_no }">
		            <input type="hidden" name="bank_code_std" value="399">
		            <input type="hidden" name="member_bank_code" value="399">
		            <input type="hidden" name="card_id" value="itwill03">
		            <input type="submit" value="정보조회" class="tdbtn" data-bs-toggle="modal" data-bs-target="#myModal">
		            </form>
		            
                </td>
              </tr>
              <tr>
                <td style="padding-bottom: 6px; padding-top: 6px;">
                    
                    <form action="/openbank/cardInfo" method="post">
		            <input type="hidden" name="access_token" value="${sessionScope.token }">
	                <input type="hidden" name="bank_tran_id" value="${sessionScope.bank_tran_id }">
			        <input type="hidden" name="user_seq_no" value="${sessionScope.user_seq_no }">
		            <input type="hidden" name="bank_code_std" value="399">
		            <input type="hidden" name="member_bank_code" value="399">
		            <input type="hidden" name="card_id" value="itwill04">
		            <input type="submit" value="정보조회" class="tdbtn" data-bs-toggle="modal" data-bs-target="#myModal">
		            </form>
              </tr>
              <tr>
                <td style="padding-bottom: 6px; padding-top: 6px;">
                
                    <form action="/openbank/cardInfo" method="post">
		            <input type="hidden" name="access_token" value="${sessionScope.token }">
	                <input type="hidden" name="bank_tran_id" value="${sessionScope.bank_tran_id }">
			        <input type="hidden" name="user_seq_no" value="${sessionScope.user_seq_no }">
		            <input type="hidden" name="bank_code_std" value="399">
		            <input type="hidden" name="member_bank_code" value="399">
		            <input type="hidden" name="card_id" value="itwill05">
		            <input type="submit" value="정보조회" class="tdbtn" data-bs-toggle="modal" data-bs-target="#myModal">
		            </form>
		            
                </td>
              </tr>
             
            </tbody>
          </table>
        </div>
      </div>

    </div>
  </div>

  <hr>
	  
<%@ include file="../include/footer.jsp"%>

