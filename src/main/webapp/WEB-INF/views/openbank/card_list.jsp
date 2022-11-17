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
                    <div class="box" style="display: flex; justify-content: space-between-center; flex-flow: row nowrap;">
                    	
                    <form action="/openbank/cardInfo" method="post" target="frm1">
                    <%-- 필요 파라미터는 입력데이터 없이 hidden 속성으로 전달 --%>
		            <input type="hidden" name="access_token" value="${sessionScope.token }">
	                <input type="hidden" name="bank_tran_id" value="${sessionScope.bank_tran_id }">
			        <input type="hidden" name="user_seq_no" value="${sessionScope.user_seq_no }">
		            <input type="hidden" name="bank_code_std" value="399">
		            <input type="hidden" name="member_bank_code" value="399">
		            <input type="hidden" name="card_id" value="itwill01">
		            <button type="submit" class="tdbtn" data-bs-toggle="modal" data-bs-target="#myModal">정보조회</button>
		            </form>
		            
		            </div>
     
                </td>
              </tr>
              <tr>
                <td style="padding-bottom: 6px; padding-top: 6px;">
                    <div class="box" style="display: flex; justify-content: space-between-center; flex-flow: row nowrap;">
                    
                    <form action="/openbank/cardInfo" method="post" target="frm1">
		            <input type="hidden" name="access_token" value="${sessionScope.token }">
	                <input type="hidden" name="bank_tran_id" value="${sessionScope.bank_tran_id }">
			        <input type="hidden" name="user_seq_no" value="${sessionScope.user_seq_no }">
		            <input type="hidden" name="bank_code_std" value="399">
		            <input type="hidden" name="member_bank_code" value="399">
		            <input type="hidden" name="card_id" value="itwill02">
<!-- 		            <input type="submit" value="정보조회" class="tdbtn" data-bs-toggle="modal" data-bs-target="#myModal"> -->
		            <button type="submit" class="tdbtn" data-bs-toggle="modal" data-bs-target="#myModal">정보조회</button>
		            </form>
		            
		            </div>
              </tr>
              <tr>
                <td style="padding-bottom: 6px; padding-top: 6px;">
                    <div class="box" style="display: flex; justify-content: space-between-center; flex-flow: row nowrap;">
                    
                    <form action="/openbank/cardInfo" method="post" target="frm1">
		            <input type="hidden" name="access_token" value="${sessionScope.token }">
	                <input type="hidden" name="bank_tran_id" value="${sessionScope.bank_tran_id }">
			        <input type="hidden" name="user_seq_no" value="${sessionScope.user_seq_no }">
		            <input type="hidden" name="bank_code_std" value="399">
		            <input type="hidden" name="member_bank_code" value="399">
		            <input type="hidden" name="card_id" value="itwill03">
<!-- 		            <input type="submit" value="정보조회" class="tdbtn" data-bs-toggle="modal" data-bs-target="#myModal"> -->
		            <button type="submit" class="tdbtn" data-bs-toggle="modal" data-bs-target="#myModal">정보조회</button>
		            </form>
		            
		            </div>
                </td>
              </tr>
              <tr>
                <td style="padding-bottom: 6px; padding-top: 6px;">
                    <div class="box" style="display: flex; justify-content: space-between-center; flex-flow: row nowrap;">
                    
                    <form action="/openbank/cardInfo" method="post" target="frm1">
		            <input type="hidden" name="access_token" value="${sessionScope.token }">
	                <input type="hidden" name="bank_tran_id" value="${sessionScope.bank_tran_id }">
			        <input type="hidden" name="user_seq_no" value="${sessionScope.user_seq_no }">
		            <input type="hidden" name="bank_code_std" value="399">
		            <input type="hidden" name="member_bank_code" value="399">
		            <input type="hidden" name="card_id" value="itwill04">
<!-- 		            <input type="submit" value="정보조회" class="tdbtn" data-bs-toggle="modal" data-bs-target="#myModal"> -->
		            <button type="submit" class="tdbtn" data-bs-toggle="modal" data-bs-target="#myModal">정보조회</button>
		            </form>
		            
		            </div>
              </tr>
              <tr>
                <td style="padding-bottom: 6px; padding-top: 6px;">
                    <div class="box" style="display: flex; justify-content: space-between-center; flex-flow: row nowrap;">
                    
                    <form action="/openbank/cardInfo" method="post" target="frm1">
		            <input type="hidden" name="access_token" value="${sessionScope.token }">
	                <input type="hidden" name="bank_tran_id" value="${sessionScope.bank_tran_id }">
			        <input type="hidden" name="user_seq_no" value="${sessionScope.user_seq_no }">
		            <input type="hidden" name="bank_code_std" value="399">
		            <input type="hidden" name="member_bank_code" value="399">
		            <input type="hidden" name="card_id" value="itwill05">
<!-- 		            <input type="submit" value="정보조회" class="tdbtn" data-bs-toggle="modal" data-bs-target="#myModal"> -->
		            <button type="submit" class="tdbtn" data-bs-toggle="modal" data-bs-target="#myModal">정보조회</button>
		            </form>
		            
		            </div>
                </td>
              </tr>
             
            </tbody>
          </table>
        </div>
      </div>

    </div>
  </div>

  <hr>
  
   <!-- 모달창 -->
   <!--   	카드정보조회 -->
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
            <iframe src="./card_info.jsp" style="width: 100%;" name="frm1"></iframe>

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
   <!-- 모달창 끝 -->
  <br>
  
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
	  
<%@ include file="../include/footer.jsp"%>

