<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ include file="../include/header.jsp"%>

 <!-- Template Main CSS File -->
  <link href="${pageContext.request.contextPath}/resources/css/style.css" rel="stylesheet">
  <link id="pagestyle" href="${pageContext.request.contextPath}/resources/css/soft-ui-dashboard.css?v=1.0.6" rel="stylesheet" />
  
  
<!-- ${pageContext.request.contextPath} -->

<%
if(loginID==null) {%>
<script>
	alert("세션값이 만료되어 로그인 페이지로 이동합니다.");
	location.href="/main/login";
</script>
<%} %>


<script>
$(document).ready(function() {
    let msg = "${msg}";
    if (msg != "") {
        success(msg);
    }
})

function success(msg) {
   Swal.fire(
       "수정 성공!",
       msg,
       'success' /*디자인 타입*/
   )
}//success 버튼
</script>


<div class="container">
   <div class="row">
     <div class="col-sm-9 col-md-7 col-lg-5 mx-auto">
       <div class="card border-0 shadow rounded-3 my-5">
         <div class="card-body p-4 p-sm-5" style="background-color:#F5EFFE;">
					<h3 class="card-title text-center mb-5 fw-light fs-5"><b>마이 페이지</b></h3>
					<div class="mypage">
						<div class="form-floating mb-3">
							<input type="text" class="form-control" value="${vo.name }" readonly="readonly">
							<label>이름</label>  
						</div>
						<div class="form-floating mb-3">
							<input type="text" class="form-control" value="${vo.nick }" readonly="readonly">
							<label>닉네임</label>  
						</div>
						<div class="form-floating mb-3">
							<input type="text" class="form-control" value="${vo.phone }" readonly="readonly">
							<label>연락처</label>  
						</div>	
						<div class="form-floating mb-3">
							<input type="text" class="form-control" value="${vo.email}" readonly="readonly">
							<label>이메일</label>  
						</div>
						<hr class="my-4">
						<div class="d-grid">
							<button class="btn btn-primary btn-login text-uppercase fw-bold" type="submit"
                  style="background-color: #5107b0; border-color: #5107b0" onclick="location.href='/member/update';">수정하기</button>
						</div>
				</div>
					<br>
						<div class="container" align="right" style="color: #d1b9f6; margin: 5px; font-size: 15px;"
						 	onclick="location.href='/member/delete';"> 
                <span>회원탈퇴 >></span>
            </div>
					</div>	
			</div>
		</div>
	</div>
</div>
<%@ include file="../include/footer.jsp"%>
