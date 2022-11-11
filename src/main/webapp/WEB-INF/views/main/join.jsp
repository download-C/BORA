<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ include file="../include/header.jsp"%>
<!-- ${pageContext.request.contextPath} -->
<script type="text/javascript" src="https://code.jquery.com/jquery-3.6.0.js"></script>
<!-- iamport.payment.js -->
<script type="text/javascript" src="https://cdn.iamport.kr/js/iamport.payment-1.1.8.js"></script>
<!-- 이메일 인증 -->
<script type="text/javascript">
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

<!-- 비밀번호 일치 검사 -->
<script>
function checkpw2() {
	if($('#pw').val()!=$('#pw2').val()){
		$('.pw2div').html('비밀번호가 일치하지 않습니다.');
		$('.pw2div').css('color','red');
		$('#pw2').focus();
		document.getElementById("pw2").value="";
 	} else {
 		$('.pw2div').html('비밀번호가 일치합니다.');
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

<!-- 아이디 중복 체크 후 회원가입 -->
<script>
$(document).ready(function(){	     
	var idflag = document.getElementById("idflag");
// 	alert(idflag.value);

    $("#join").submit(function(){
		if(idflag.value=="false") {
	    	alert("아이디 중복 여부를 확인하세요");
	    	$("#id").focus();
			return false;
		}
    });
	
	$("#idcheck").click(function(){
// 		alert('중복체크');
		$.ajax({
            url : "/member/idcheck",
            data: {'id':$("#id").val()},
            success : function(result) {
            	if(result == "no"){
		            //아이디가 존재할 경우 빨강으로 , 아니면 파랑으로 처리하는 디자인
		            $('.iddiv').html("이미 존재하는 아이디입니다");
		            $('.iddiv').css('color','red');
		            document.getElementById("id").value=="";
		            $("#id").focus();
           		} else {
           		 	$(".iddiv").html("사용 가능한 아이디입니다");
		            $(".iddiv").css("color","blue");
		            idflag.value="true";
		            document.set
           		}
            },//success
            error : function(error) {
            	$('.iddiv').html("에러");
            	return false;
            }//error
 		});//ajax
	});//idcheck
	
	$("#nick").change(function(){
// 		alert('닉네임 중복체크');
		$.ajax({
            url : "/member/nickcheck",
            data: {'nick':$("#nick").val()},
            success : function(result) {
            	if(result == "no"){
		            //닉네임이 존재할 경우 빨강으로 , 아니면 파랑으로 처리하는 디자인
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


  <!-- login -->
  <div class="container">
    <div class="row">
      <div class="col-sm-9 col-md-7 col-lg-5 mx-auto" style="width: 50%;">
        <div class="card border-0 shadow rounded-3 my-5">
          <div class="card-body p-4 p-sm-5" style="background-color:#F5EFFE;">
            <h5 class="card-title text-center mb-5 fw-light fs-5"><b>회원가입</b></h5>
            <form action="/main/join" method="post" id="join">
              <div class="form-floating mb-3" >
                <input type="text" name="id" class="form-control" id="id" placeholder="아이디" required   
                style="width: 85%; float: left;">
                <label for="id">아이디</label>
                <div align="right">
                	<button id="idcheck" style="width: 13%; padding: 5px 0px; border: none; border-radius: 6px; background-color: #5107b0; color: #fff;  vertical-align: middle;">
                		중복<br>체크
               		</button></div>
                <span class="iddiv">&nbsp;</span>
              </div>
              <div class="form-floating mb-3">
                <input type="password" name="pw" class="form-control" id="pw" placeholder="비밀번호" required>
                <label for="floatingPassword">비밀번호</label>
                <span class="pwdiv">&nbsp;</span>
              </div>
              <div class="form-floating mb-3">
                <input type="password" name="pw2" class="form-control" id="pw2" placeholder="비밀번호 확인" required>
                <label for="floatingPassword">비밀번호 확인</label>
                <span class="pw2div">&nbsp;</span>
              </div>
              <div class="form-floating mb-3">
                <input type="text" name="name" class="form-control" id="name" placeholder="이름" required>
                <label for="floatingInput">이름</label>
                <span>&nbsp;</span>
              </div>
              <div class="form-floating mb-3">
                <input type="tel" name="nick" class="form-control" id="nick" placeholder="전화번호" min="2" required>
                <label for="floatingInput">닉네임</label>
                <span class="nickdiv">&nbsp;</span>
              </div>
              <div class="form-floating mb-3">
                <input type="tel" name="phone" class="form-control" id="phone" placeholder="전화번호" maxlength="13" oninput="autoHyphen(this)" required>
                <label for="floatingInput">전화번호</label>
                <span>&nbsp;</span>
              </div>
              <div class="form-floating mb-3">
                <input type="email" name="eamil" class="form-control" id="eamil" placeholder="전화번호" required>
                <label for="floatingInput">이메일</label>
                <span>&nbsp;</span>
              </div>
              <hr class="my-4">
              <div class="d-grid">
                <input type="hidden" value="false" id="idflag" placeholder="아이디 중복체크 했나요?"> <br>
                <button class="btn btn-primary btn-login text-uppercase fw-bold" style="border: none; background-color: #5107b0;" type="submit">가 입 하 기</button>
              </div>
            </form>
          </div>
        </div>
      </div>
    </div>
  </div>
  <!-- End login -->
<%@ include file="../include/footer.jsp"%>
