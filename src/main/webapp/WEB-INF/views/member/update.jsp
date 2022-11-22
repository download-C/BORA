<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ include file="../include/header.jsp"%>
<!-- ${pageContext.request.contextPath} -->
<script src="https://code.jquery.com/jquery-3.6.0.js"></script>
<!-- alert 모달 필수  --> 
<script src="https://cdn.jsdelivr.net/npm/sweetalert2@9"></script>
<script src="https://cdn.jsdelivr.net/npm/promise-polyfill@7.1.0/dist/promise.min.js"></script>

  <!-- Template Main CSS File -->
  <link href="${pageContext.request.contextPath}/resources/css/style.css" rel="stylesheet">

<%
if(loginID==null) {%>
<!-- 세션값(로그인) 확인 -->
<script>
// 세션값 여부
$(document).ready(function() {
	Swal.fire(
		"세션값 만료!",
		"로그인 페이지로 이동합니다."
	);
	location.href="/main/login";
})
</script>
<%} %>


<!-- login 성공 메세지 불러오기 -->
<script>
$(document).ready(function(){	
	let msg1 = "${msg1}";
	let msg2 = "${msg2}";
// 	alert()
	if(msg1!=""&&msg2!="") {
		warning(msg1, msg2);
	}
 });
</script>

<!-- login 성공 alert 모달 -->
<script>
function warning(message, message2) {
	Swal.fire({
       title: message,
       text: message2,
     	 confirmButtonColor: '#7A1CF6',
     	 icon: 'warning'
      })
}
</script>

<!-- 비밀번호 유효성 검사 -->
<script type="text/javascript">
// 비밀번호 유효성 검사
function checkpw() {
	var pw = document.getElementById("pw").value;
	 if(pw.length>7) {
		 if(pw.match(/([a-zA-Z0-9].*[!,@,#,$,%,^,&,*,?,_,~,-])/)||
			pw.match(/([!,@,#,$,%,^,&,*,?,_,~,-].*[a-zA-Z0-9])/)) {
			 $(".pwdiv").html("사용 가능한 비밀번호입니다.");
			 $(".pwdiv").css('color','blue');
			 
		 }else {
			$(".pwdiv").html("비밀번호는 영어대소문자, 숫자, 특수문자가 하나씩 포함되어야 합니다.");
			$(".pwdiv").css('color','red');
			document.getElementById("pw").value="";
		 } 
	 }else {
			$(".pwdiv").html("비밀번호는 8글자 이상, 16글자 이하만 사용 가능합니다.");
			$(".pwdiv").css('color','red');
			document.getElementById("pw").value="";
	} 
}
</script>

<!-- 비밀번호 변경 시 이전 비밀번호와 일치 여부 -->
<script>
// 비밀번호 유효성 검사 후 이전 비밀번호와 일치 여부 확인
// alert("비밀번호 중복 여부");
function pwUpdateCheck() {
// 	alert("비밀번호 중복");
	$(document).ready(function(){
		$.ajax({
			type: "post",
			url: "/member/pwUpdateCheck",
			data: {'pwUpdate':$("#pw").val()},
			success: function(result){
				if(result=="no") {
					$(".pwdiv").html("같은 비밀번호로 변경할 수 없습니다.");
					$("#pw").focus();
				} 
			}
		});
	});
}
</script>

<!-- 비밀번호 일치 여부 -->
<script>
function checkpw2() {
	if($('#pw').val()!=$('#pw2').val()){
		$('.pw2div').html('비밀번호가 일치하지 않습니다.');
		$('.pw2div').css('color','red');
		$('#pw2').focus();
		document.getElementById("pw2").value="";
 	} else {
 		$(".pw2div").html('비밀번호가 일치합니다.');
		$('.pw2div').css('color','blue');
		$('#pw2').focus();
 	}
}

const autoHyphen = (target) => {
 target.value = target.value
 .replace(/[^0-9]/g, '')
 .replace(/^(\d{0,3})(\d{0,4})(\d{0,4})$/g, "$1-$2-$3")
 .replace(/(\-{1,2})$/g, "");
}
</script>

<!--  아이디 중복체크 후 회원가입 -->
<script>
$(document).ready(function(){	     
// 아이디 중복 체크 했는지 확인하는 플래그
	var idflag = document.getElementById("idflag");
// 	alert(idflag.value);
	
	$("#nick").change(function(){
// 		alert('닉네임 중복체크');
		$.ajax({
            url : "/member/nickcheck",
            data: {'nick':$("#nick").val()},
            success : function(result) {
            	if(result == "no"){
		            // 닉네임이 존재할 경우 빨강으로 , 아니면 파랑으로 처리하는 디자인
		            $(".nickdiv").html("이미 존재하는 닉네임입니다.");
		            $(".nickdiv").css("color","red");
		            document.getElementById("nick").value=="";
		            $("#nick").focus();
           		} else if(result == "ok"){
           		 	$(".nickdiv").html("사용 가능한 닉네임입니다.");
		            $(".nickdiv").css("color","blue");
           		} else {
           			$(".nickdiv").html("");
           		}
            },//success
            error : function(error) {
            	$('.iddiv').html("에러");
            	return false;
            }//error
 		});//ajax
	});//nickcheck
}); //document
</script>

<div class="container">
    <div class="row">
      <div class="col-sm-9 col-md-7 col-lg-5 mx-auto" style="width: 50%;">
        <div class="card border-0 shadow rounded-3 my-5">
          <div class="card-body p-4 p-sm-5" style="background-color:#F5EFFE;">
						<h3 class="card-title text-center mb-5 fw-light fs-5"><b>회원정보 수정</b></h3>
					 <form action="/member/update" method="post" id="update">
						<!-- tg-text=title -->
							<!-- 비밀번호 -->
							<div class="join_pw form-floating mb-3">
								<input type="password" id="pw" name="pw" maxlength="16" class="form-control"
									required onchange="pwUpdateCheck(), checkpw()"> 
								<label for="floatingPassword">비밀번호</label>
								<span class="pwdiv" style="font-size: small;">&nbsp;</span>
							</div>
							<!-- 비밀번호 확인 -->
							<div class="join_pw2 form-floating mb-3" >
								<input type="password" id="pw2" name="pw2" maxlength="16" class="form-control"
									required onchange="checkpw2()"> 
								<label for="floatingPassword">비밀번호 확인</label>
								<span class="pw2div" style="font-size: small;">&nbsp;</span>
							</div>
							<!-- 이름 -->
							<div class="join_name form-floating mb-3" >
								<input type="text" id="name" name="name" value="${vo.name }" class="form-control"
									required readonly="readonly"> 
								<label for="floatingInput">이름</label>
								<span class="namediv" style="font-size: small;">&nbsp;</span>
							</div>
							<!-- 닉네임 -->
							<div class="join_nick form-floating mb-3" >
								<input type="text" id="nick" name="nick"  value="${vo.nick }" class="form-control"
									required> 
								<label for="floatingInput">닉네임</label>
								<span class="nickdiv" style="font-size: small;">&nbsp;</span>
							</div>
							<!-- 연락처 -->
							<div class="join_phone form-floating mb-3" >
								<input type="text" id="phone" name="phone" value="${vo.phone }"  class="form-control"
									required maxlength="13"
								oninput="autoHyphen(this)" autofocus> 
								<label for="floatingInput">연락처</label>
								<span class="phonedeiv" style="font-size: small;">&nbsp;</span>
							</div>
							<!-- 이메일 -->
							<div class="join_email form-floating mb-3">
									<input type="text" id="email" name="email" value="${vo.email }" class="form-control"
									 required>
								<label for="floatingInput">이메일</label>
								<span class="emaildiv" style="font-size: small;">&nbsp;</span>
							</div>
						<hr class="my-4">
              <div class="d-grid">
                <button class="btn btn-primary btn-login text-uppercase fw-bold" type="submit"
                  style="background-color: #5107b0; border-color: #5107b0;">회원정보수정</button>
              </div>
					</form>
				</div>
			</div>
		</div>
	</div>
</div>

<%@ include file="../include/footer.jsp"%>