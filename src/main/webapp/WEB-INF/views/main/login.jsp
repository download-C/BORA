<%@ page import="java.net.URLEncoder" %>
<%@ page import="java.security.SecureRandom" %>
<%@ page import="java.math.BigInteger" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ include file="../include/header.jsp"%>
<!-- ${pageContext.request.contextPath} -->
<script src="https://code.jquery.com/jquery-3.6.0.js"></script>
<script src="https://cdn.jsdelivr.net/npm/sweetalert2@9"></script>
<script src="https://cdn.jsdelivr.net/npm/promise-polyfill@7.1.0/dist/promise.min.js"></script>
<script type="text/javascript" src="https://static.nid.naver.com/js/naverLogin_implicit-1.0.3.js" charset="utf-8"></script>
<script src="https://static.nid.naver.com/js/naveridlogin_js_sdk_2.0.2.js"></script>

<!-- Template Main CSS File -->
<link href="${pageContext.request.contextPath}/resources/css/style.css" rel="stylesheet">
<link href="${pageContext.request.contextPath}/resources/css/login.css" rel="stylesheet">
 
<!-- 로그인 실패 모달 -->
<script>
//warning 버튼
function warning(message) {

    Swal.fire(
        '경고',
        message,
        'warning' /*디자인 타입*/
    )

}//warning 버튼
</script>

<!-- document.ready -->
<script>
$(document).ready(function(){
	let message = "${msg }";
	if(message!="") {
		warning(message);
	}
})
</script>

<div class="container">
	<div class="row">	
		<div class="col-sm-9 col-md-7 col-lg-5 mx-auto">
	        <div class="card border-0 shadow rounded-3 my-5">
	          <div class="card-body p-4 p-sm-5">
	            <h5 class="card-title text-center mb-5 fw-light fs-5"><b>로그인</b></h5>
				<form action="/main/login" method="post">
<%-- 					<sec:csrfInput/> --%>
				<div class="form-floating mb-3">
               		<input type="text" name="id" class="form-control" id="floatingInput" placeholder="name@example.com">
                	<label for="floatingInput">아이디</label>
             	 </div>
              	 <div class="form-floating mb-3">
	                <input type="password" name="pw" class="form-control" id="floatingPassword" placeholder="Password">
	                <label for="floatingPassword">비밀번호</label>
              	 </div>
				 <div class="d-grid">
                	<button class="btn btn-primary btn-login text-uppercase fw-bold" type="submit">로그인하기</button>
                 </div>
                 </form>
			<%-- 	<div><input type="hidden" value="${_csrf.token }" name=${_csrf.parameterName }></div> --%>
				 <hr class="my-4">
                 <div class="d-grid mb-2">
	                 <button class="btn btn-kakao btn-login text-uppercase fw-bold">
	                  카카오 아이디로 로그인하기	                  
	                 </button>
              	 </div>
              	 <div class="d-grid mb-2">
	                 <button class="btn btn-google btn-login text-uppercase fw-bold" >
	                 	구글 아이디로 로그인하기
	                 </button>
                 </div>
				<%
					// 네이버 아이디로 로그인
				   String clientId = "lHzDm6WPNUoeiSbI4Vaq";//애플리케이션 클라이언트 아이디값";
				   String redirectURI = URLEncoder.encode("http://localhost:8088/main/naverCallback", "UTF-8");
				   SecureRandom random = new SecureRandom();
				   String state = new BigInteger(130, random).toString();
				   String apiURL = "https://nid.naver.com/oauth2.0/authorize?response_type=code"
				        + "&client_id=" + clientId
				        + "&redirect_uri=" + redirectURI
				        + "&state=" + state;
				   session.setAttribute("state", state);
				 %>
				 <script>
				 	var naver_id_login = new naver_id_login("lHzDm6WPNUoeiSbI4Vaq", "http://localhost:8088/main/naverCallback");
				 	 naver_id_login.init_naver_id_login();
				 </script>
             	 <div id="naver_id_login" class="d-grid mb-2">
	                 <button class="btn btn-facebook btn-login text-uppercase fw-bold" 
	                 	onclick="location.href='<%=apiURL%>';">
	                  네이버 아이디로 로그인하기
	                 </button>
              	 </div>
				 
				 </div>
			</div>
		</div>
	</div>
</div>



<%@ include file="../include/footer.jsp"%>