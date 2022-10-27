<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="false"%>

<%@ include file="../include/header.jsp"%>
<!-- ${pageContext.request.contextPath} -->
<script type="text/javascript" src="https://code.jquery.com/jquery-3.6.0.js"></script>
<script>

function checkpw(obj) {
	var pw = document.getElementById("pw").value;
// 	alert(pw);
    var SC = ["!","@","#","$","%"];
    var check_SC1 = 0;
    
    if(pw.length<8||pw.length>20) { 
	 $(".pwdiv").html("비밀번호는 8글자 이상, 16글자 이	하만 사용 가능합니다.");
	 $(".pwdiv").css('color','red');
	 document.getElementById("pw").value=="";
	}
    
//     for(var i=0;i<SC.length;i++){
// 	    if(pw.indexOf(SC[i]) != -1){
// 	        check_SC1 = 1;
// 	    }
// 	}
    
//     if(check_SC1 == 0){
// 		 $('.pwdiv').html('비밀번호는 영문(대소문자구분),숫자,특수문자(~!@#$%^&*()-_? 만 허용)를 혼용하여 8~16자를 입력해주세요.');
// 		 $('.pwdiv').css('color','red');
// 		 document.getElementById("pw").value=="";
//     }
    if(pw.match(/([a-zA-Z0-9].*[!,@,#,$,%,^,&,*,?,_,~,-])|([!,@,#,$,%,^,&,*,?,_,~,-].*[a-zA-Z0-9])/)){
		 $('.pwdiv').html('비밀번호는 영문(대소문자구분),숫자,특수문자(~!@#$%^&*()-_? 만 허용)를 혼용하여 8~16자를 입력해주세요.');
		 $('.pwdiv').css('color','red');
		 document.getElementById("pw").value=="";
    }
}

function checkpw2(obj) {
	var pw = document.getElementById("pw2").value;
// 	alert(pw);

    var SC = ["!","@","#","$","%"];
    var check_SC2 = 0;
    
    if(pw.length<8||pw.length>20) { 
	 $(".pw2div").html("비밀번호는 8글자 이상, 20글자 이하만 사용 가능합니다.");
	 $(".pw2div").css('color','red');
	 document.getElementById("pw2").value=="";
	}
}
</script>
<script>

$(document).ready(function(){
	
// 		 alert('변화 감지');


	     
	     // 비밀번호 길이 체크

	     
// 	     // 비밀번호 특수문자 사용 여부 확인

// 	     for(var i=0;i<SC.length;i++){
// 	         if(pw2.indexOf(SC[i]) != -1){
// 	             check_SC1 = 1;
// 	         }
// 	     }
	     
// 	     // 비밀번호 특수문자 없을 경우 
// 	     
// 	     if(check_SC2 == 0){
// 	    	 $('.pw2div').html('!,@,#,$,% 의 특수문자가 들어가 있지 않습니다.');
// 	    	 $('.pw2div').css('color','red');
// 	    	 #('#pw2').val()="";
// 	     }
	     
// 	     if($('#pw').val()!=$('#pw2').val()){
// 				$('.pw2div').html('비밀번호가 일치하지 않습니다.');
// 				$('.pw2div').css('color','red');
// 				$('#pw2').focus();
// 				return false;
// 	     }
	 } // check_pw()
     
    // 아이디 join을 가진 대상의 submit시 기능 구현하기 
	
	$("#idcheck").click(function(){
// 		alert('중복체크');
		$.ajax({
            url : "/member/idcheck",
            success : function(result) {
            	if(result == "no"){
		            //아이디가 존재할 경우 빨강으로 , 아니면 파랑으로 처리하는 디자인
		            $('.iddiv').html("이미 존재하는 아이디입니다");
		            $('.iddiv').css('color','red');
// 		            $(".iddiv").removeClass("has-success");
		            $("#id").focus();
           		} else {
           		 	$(".iddiv").html("사용 가능한 아이디입니다");
		            $(".iddiv").css("color","green");
// 		            $(".iddiv").removeClass("has-success");
           		}
            },//success
            error : function(error) {
            	$('.iddiv').html("에러");
            	return false;
            }//error
 		});//ajax
	});//idcheck
}); //document
</script>
<h1>member/insert.jsp</h1>
<hr>
<div id="container" role="main">
	<div id="content">
		<form action="${pageContext.request.contextPath}/member/join" method="post" id="join">
			<!-- tg-text=title -->
			<h2 class="">보라 회원가입</h2>
			<div class="join_content">
				<!-- 아이디  -->
				<div class="join_id">
					<h6>아이디</h6>
					<input type="text" id="id" name="id" class="" 
					placeholder="" required="required"> 
					<input type="button" value="중복체크" id="idcheck"><br>
					<span class="iddiv">&nbsp;</span>
				</div>
				<!-- 비밀번호 -->
				<div class="join_pw">
					<h6>비밀번호</h6>
					<input type="password" id="pw" name="pw" class="" maxlength="16" 
					placeholder="" required="required" onchange="checkpw(this)"> <br>
					<span class="pwdiv">&nbsp;</span>
				</div>
				<!-- 비밀번호 확인 -->
				<div class="join_pw2">
					<h6>비밀번호 확인</h6>
					<input type="password" id="pw2" name="pw2" class="" maxlength="16"
					placeholder="" required="required" onchange="check_pw2(this)"> <br>
					<span class="pw2div">&nbsp;</span>
				</div>
				<!-- 이름 -->
				<div class="join_name">
					<h6>이름</h6>
					<input type="text" id="name" name="name" class="" 
					placeholder="" required="required"> <br>
				</div>
				<!-- 닉네임 -->
				<div class="join_nick">
					<h6>닉네임</h6>
					<input type="tel" id="nick" name="nick" class="" 
					placeholder="" required="required"> <br>
				</div>
				<!-- 연락처 -->
				<div class="join_phone">
					<h6>연락처</h6>
					<input type="tel" id="phone" name="phone" class="" 
					placeholder="- 없이 숫자만" required="required"> <br>
				</div>
				<!-- 이메일 -->
				<div class="join_email">
					<h6>이메일</h6>
					<input type="text" id="email" name="email" class="" 
					placeholder="" required="required"> <br>
				</div>
			</div>
			<input type="submit" value="가입하기">
		</form>
	</div>
</div>

<%@ include file="../include/footer.jsp"%>
