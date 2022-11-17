<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ include file="../include/header.jsp"%>
<!-- ${pageContext.request.contextPath} -->

<link href="${pageContext.request.contextPath}/resources/css/openbankguide.css" rel="stylesheet">

<style>
th, td {
	text-align: center;
}
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
      font-size: 30px;
    }
    
    .floatingInput {
    	color: red;
    }
    
</style>

<!-- title -->
  <div class="section-title">
    <h2><b>오픈뱅킹</b></h2><br><br>
    <picture>
	  <source media="(min-width: 1024px)" srcset="${pageContext.request.contextPath}/resources/img/openbank1.png" class="img-fluid">
  	  <source media="(min-width: 768px)" srcset="${pageContext.request.contextPath}/resources/img/openbank_small.png" class="img-fluid">
  	  <img src="${pageContext.request.contextPath}/resources/img/openbank_small.png" class="img-fluid">
	</picture>
  </div>

<div class="container">

<!-- 오픈뱅킹 사용자 인증 버튼 - 토큰 발급 -->
<!-- sessionToken 값이 있으면 오픈뱅킹 사용자 인증 버튼 숨김 -->
<div class="container" style="justify-content: center; align-items: center;">
      <div class="m-4">
       <div class="row justify-content-center">
        <div class="col-md-16 col-16">
          <c:if test="${empty sessionScope.token}">
                <div class="container" style="justify-content: center; align-items:center;">
<!--                   <h3 style="text-align: center;">오픈뱅킹 사용자 인증</h3> -->
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
				 <button type="submit" class="tbtn">오픈뱅킹&nbsp;<b style="color:#e3cffc;">사용자 인증</b>&nbsp;선택</button>
                </form>
          		</div>
            </c:if>
        </div>

<!-- 오픈뱅킹 자산 조회 버튼 - 토큰 발급 후 이동 -->
	<!-- sessionToken 값이 있어야 자산 조회 버튼 생성 -->	
	  <c:if test="${not empty sessionScope.token}">
        <div class="col-md-16 col-16">
              <div class="container" style="justify-content: center; align-items:center;">
<!--                 <h3 style="text-align: center;">내 자산 조회</h3> -->
                <!-- 인증 요청 작업 수행 -->
                <form method="get" action="/openbank/userInfo" style="text-align: center;">
                  <input type="hidden" name="access_token" value="${sessionScope.token }">
                  <input type="hidden" name="user_seq_no" value="${responseToken.user_seq_no }">
				 <button type="submit" class="tbtn">오픈뱅킹&nbsp;<b style="color:#e3cffc;">내 자산</b>&nbsp;조회</button>
                </form>
            </div>
          </div>
		</c:if>
        </div>
      </div>
    </div>
  </div><br>
  
<!-- 토큰발급 화면예시 -->
  <div class="container">
      <div class="row justify-content-center">
        <div class="col-md-12 col-12">
          <div class="card border-left-info shadow h-100 py-2">
            <div class="card-body">
              <div class="container">
              <h3>※ 오픈뱅킹 사용자 인증 예시</h3><br>
              <span style="font-size: 20px;">◼ 계좌 정보에는 현재 오픈뱅킹 인증이 완료된 보유 계좌 정보를 입력하여 주시기 바랍니다.</span><br>
          	  <span style="font-size: 20px; color: red" >◼ BORA에서 오픈뱅킹 테스트 입력 시 아래의 계좌 정보를 입력해주세요. <br>
              → 오픈뱅크 0518030909 BORA입출금 </span>
     		  </div>

              <div class="card-body ">
                <table class="table" >
                  <!-- 첫번째행 -->
                  <thead>
                  <tr>
                  <th></th>
                  <th></th>
                  <th></th>
                  </tr>
                  </thead>
                  <tbody>
                    <tr>
                      <td><img src="${pageContext.request.contextPath}/resources/img/token/token1.png" class="img-fluid"></td>
                      <td><img src="${pageContext.request.contextPath}/resources/img/token/token2.png" class="img-fluid"></td>
                      <td><img src="${pageContext.request.contextPath}/resources/img/token/token3.png" class="img-fluid"></td>
                      </tr>
                    </tbody>
					<!-- 두번째행 -->
                <thead>
                      <tr>
                  <th></th>
                  <th></th>
                  <th></th>
                      </tr>
                    </thead>
                    <tbody>
                      <tr>
                      <td><img src="${pageContext.request.contextPath}/resources/img/token/token4.png" class="img-fluid"></td>
                      <td><img src="${pageContext.request.contextPath}/resources/img/token/token5.png" class="img-fluid"></td>
                      <td><img src="${pageContext.request.contextPath}/resources/img/token/token6.png" class="img-fluid"></td>
                    </tr>
                  </tbody>
                </table>
              </div>
            </div>
          </div>
        </div>
      </div>

</div><br><br><br>

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