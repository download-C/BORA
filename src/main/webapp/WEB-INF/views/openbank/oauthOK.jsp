<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ include file="../include/header.jsp"%>
<!-- ${pageContext.request.contextPath} -->




<%-- <h2>세션 토큰 : ${sessionScope.token }</h2> --%>
<!-- <hr> -->
<%-- <h4>액세스 토큰 : ${responseToken.access_token }</h4> --%>
<%-- <h4>사용자 번호 : ${responseToken.user_seq_no }</h4> --%>
<%-- <h4>token_type : ${responseToken.token_type }</h4> --%>
<%-- <h4>expires_in : ${responseToken.expires_in }</h4> --%>
<%-- <h4>refresh_token : ${responseToken.refresh_token }</h4> --%>
<%-- <h4>scope : ${responseToken.scope }</h4> --%>


  <!-- title -->
  <div class="section-title">
    <h2><b>자산관리</b></h2><br><br>
    <img src="${pageContext.request.contextPath}/resources/img/openbank.png" class="img-fluid">

  </div><br>

<div class="container">

	<!-- 인증 요청 작업 수행 -->
<!-- 	<form action="https://testapi.openbanking.or.kr/oauth/2.0/authorize" method="get"> -->
<!-- 		<input type="hidden" name="response_type" value="code">  -->
<!-- 		<input type="hidden" name="client_id" value="2ce89526-eccf-45b0-a59f-1ca10bc64b30">  -->
<!-- 		<input type="hidden" name="redirect_uri" value="http://localhost:8088/openbank/callback">  -->
<!-- 		<input type="hidden" name="scope" value="login inquiry transfer cardinfo fintechinfo"> -->
<!-- 		<input type="hidden" name="state" value="12345678123456781234567812345678"> -->
<!-- 		<input type="hidden" name="auth_type" value="0">  -->
<!-- 		<input type="submit" value="오픈뱅킹 사용자 인증" id="btn"> -->
<!-- 	</form> -->
	
<!-- 	<h1>😉사용자정보조회😉</h1> -->
<!-- 	<!-- 사용자정보조회 --> 
<!-- 	고객번호, 고객이름, 고객등록계좌수 -->
<!-- 	<form method="get" action="/openbank/userInfo"> -->
<%-- 		<%-- 필요 파라미터는 입력데이터 없이 hidden 속성으로 전달 --%>
<%-- 		<input type="hidden" name="access_token" value="${sessionScope.token }"> --%>
<%-- 		<input type="hidden" name="user_seq_no" value="${responseToken.user_seq_no }"> --%>
<!-- 		<input type="submit" value="사용자 정보 조회"> -->
<!-- 	</form><hr> -->



<!-- 토큰발급 화면예시 -->
<div class="row row-cols-md-13 g-13 justify-content-center">
 <div class="col-md-13 col-12">
        <div class="card border-left-info shadow h-100 py-2">
          <div class="card-body">
              <div class="container">
              <h3>※ 오픈뱅킹 사용자 인증 예시</h3><br>
              <span style="font-size: 20px;">◼ 계좌 정보에는 현재 오픈뱅킹 인증이 완료된 보유 계좌 정보를 입력하여 주시기 바랍니다.</span><br>
          	  <span style="font-size: 20px; color: red" >◼ BORA에서 오픈뱅킹 테스트 입력 시 아래의 계좌 정보를 입력해주세요. <br>
              → 오픈뱅크 0518030909 BORA입출금 </span>
              </div>
              <i class="fas fa-clipboard-list fa-2x text-gray-300"></i>
              <div class="card-body">
                <div class="row no-gutters align-items-center">
                  <table class="table col-md-10"
                    style="width:100%; overflow:auto; border-radius: 12px; text-align: center;">
					<!-- 첫번째행 -->
                    <thead style="background-color: gray; font-size: 20px;">
                      <tr>
                        <th>① 본인 인증</th>
                        <th>② 이용 동의</th>
                        <th>③ 인증 절차</th>
                      </tr>
                    </thead>
                    <tbody>
                      <tr>
                      	<td><img src="${pageContext.request.contextPath}/resources/img/token/token1.png" width="100%"></td>
						<td><img src="${pageContext.request.contextPath}/resources/img/token/token2.png" width="100%"></td>
						<td><img src="${pageContext.request.contextPath}/resources/img/token/token3.png" width="100%"></td>
                      </tr>
                    </tbody>
					<!-- 두번째행 -->
                    <thead style="background-color: gray; font-size: 20px;">
                      <tr>
                        <th>④ 계좌 정보 입력 </th>
                        <th>⑤ ARS 동의</th>
                        <th>⑥ 이메일 등록</th>
                      </tr>
                    </thead>
                    <tbody>
                      <tr>
						<td><img src="${pageContext.request.contextPath}/resources/img/token/token4.png" width="300px;"></td>
						<td><img src="${pageContext.request.contextPath}/resources/img/token/token5.png" width="300px;"></td>
						<td><img src="${pageContext.request.contextPath}/resources/img/token/token6.png" width="300px;"></td>
                      </tr>
                    </tbody>
                    
                  </table>
                </div>
              </div>
          </div>
        </div>
      </div>


<div class="m-4">
    <div class="container" style="justify-content: center; align-items: center;">
      <div class="row">
        <div class="col-md-5">
          <div class="card border-left-info shadow h-100 py-2">
            <div class="card-body">
              <div class="container" style="justify-content: center; align-items:center;">
                <h3 style="text-align: center;">오픈뱅킹 사용자 인증</h3>
                <!-- 인증 요청 작업 수행 -->
                <form action="https://testapi.openbanking.or.kr/oauth/2.0/authorize" method="get"
                  style="text-align: center;">
                  <input type="hidden" name="response_type" value="code">
                  <input type="hidden" name="client_id" value="2ce89526-eccf-45b0-a59f-1ca10bc64b30">
                  <input type="hidden" name="redirect_uri" value="http://localhost:8088/openbank/callback">
                  <input type="hidden" name="scope" value="login inquiry transfer cardinfo fintechinfo">
                  <!-- <input type="hidden" name="scope" value="cardinfo"> -->
                  <input type="hidden" name="state" value="12345678123456781234567812345678">
                  <input type="hidden" name="auth_type" value="0">
                  <!-- <input type="hidden" value="register_info" value="C"> -->
                  <input type="submit" value="오픈뱅킹 사용자 인증" id="btn">
                </form>
              </div>
            </div>
          </div>
        </div>
        <!-- End News! -->

        <!-- community -->
        <div class="col-md-5">
          <div class="card border-left-info shadow h-100 py-2">
            <div class="card-body">
              <div class="container" style="justify-content: center; align-items:center;">
                <h3 style="text-align: center;">내 자산 조회</h3>
                <!-- 인증 요청 작업 수행 -->
                <form method="get" action="/openbank/userInfo" style="text-align: center;">
                  <input type="hidden" name="access_token" value="${sessionScope.token }">
                  <input type="hidden" name="user_seq_no" value="${sessionScope.user_seq_no }">
<%--                   <input type="hidden" name="user_seq_no" value="${responseToken.user_seq_no }"> --%>
                  <input type="submit" value="내 자산 조회">
                </form>
              </div>
            </div>
          </div>
        </div>
      </div>
    </div>
  </div>

  <br>



</div><br><br><br>
</div>	
<script>
// 목돈 모으기 페이지를 위한 빌드업,,, 
// 계좌 잔액 담을 배열 여기서 생성해놓기 + localStorage에 저장
let balArr = new Array();
balArr = [{name:'default', bal:0}];
localStorage.setItem('balArr', JSON.stringify(balArr));
console.log(balArr);

// localStorage.removeItem('balArr');
</script>
     
<%@ include file="../include/footer.jsp"%>