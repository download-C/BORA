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

<!-- Template Main CSS File -->
<link href="${pageContext.request.contextPath}/resources/css/style.css" rel="stylesheet">
<link href="${pageContext.request.contextPath}/resources/css/login.css" rel="stylesheet">
 
<!-- 로그인 실패 모달 -->
<script>
//warning 버튼
function warning(message) {

//     Swal.fire(
//         '경고',
//         message,
//         'warning' /*디자인 타입*/
//     )

  	Swal.fire({
	  title: message,
	  text: '',
	  padding: '3em',
	  confirmButtonColor: '#7A1CF6'
   	})


}//warning 버튼

function success(msg1, msg2) {
    Swal.fire(
        msg1,
        msg2,
        'success' /*디자인 타입*/
    )
}//success 버튼


$(document).ready(function(){
	let msg = "${msg}";
	if(msg!="") {
		warning(msg)
	}
	
	let msg1 = "${msg1}";
	let msg2 = "${msg2}";
	
	if(msg1!="" && msg2!="") {
		success(msg1, msg2)
	}
})
</script>


<div class="container">
	<div class="row">	
		<div class="col-sm-9 col-md-7 col-lg-5 mx-auto">
	        <div class="card border-0 shadow rounded-3 my-5">
	          <div class="card-body p-4 p-sm-5" style="background-color:#F5EFFE; border-color: #F5EFFE;">
	            <h5 class="card-title text-center mb-5 fw-light fs-5"><b>로그인</b></h5>
				<form action="/main/login" method="post">
				<div class="form-floating mb-3">
               		<input type="text" name="id" class="form-control" id="floatingInput" placeholder="name@example.com">
                	<label for="floatingInput">아이디</label>
             	 </div>
              	 <div class="form-floating mb-3">
	                <input type="password" name="pw" class="form-control" id="floatingPassword" placeholder="Password">
	                <label for="floatingPassword">비밀번호</label>
              	 </div>
				 <div class="d-grid">
                	<div class="d-grid">
                <input type="hidden" value="false" id="idflag" placeholder="아이디 중복체크 했나요?"> <br>
                <button class="btn btn-primary btn-login text-uppercase fw-bold" style="border: none; background-color: #5107b0;" type="submit">로 그 인</button>
              </div>
                 </div>
                 </form>
                 <div style="text-align: right;">
                 <br>
                 <a href="/main/join" style="color:#5107b0;">회원가입 >></a>
                 </div>
				 				 <hr class="my-4">
                 <div class="d-grid mb-2">
	                 <button class="btn btn-kakao btn-login text-uppercase fw-bold" onclick="location.href='${kakaoURL}';">
	                  카카오 아이디로 로그인하기	                  
	                 </button>
              	 </div>
				

             	 <div id="naver_id_login" class="d-grid mb-2">
	                 <button class="btn btn-facebook btn-login text-uppercase fw-bold" 
	                 	onclick="location.href='${naverURL}';">
	                  네이버 아이디로 로그인하기
	                 </button>
              	 </div>
				 
				 </div>
			</div>
		</div>
	</div>
</div>



<%@ include file="../include/footer.jsp"%>