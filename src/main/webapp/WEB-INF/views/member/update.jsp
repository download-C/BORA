<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ include file="../include/header.jsp"%>
<!-- ${pageContext.request.contextPath} -->
<script src="https://code.jquery.com/jquery-3.6.0.js"></script>
<%
if(loginID==null) {%>
<script>
// 세션값 여부
	alert("세션값이 만료되어 로그인 페이지로 이동합니다.");
	location.href="/member/login";
	
	$(document).ready(function() {
	    let message = "${msg}";
	    if (message != "") {
	        alert(message);
	    }
	})
</script>
<%} %>
<!-- 비밀번호 회원정보 수정 시 alert -->
<script>
$(document).ready(function() {
    let message = "${msg}";
    if (message != "") {
        alert(message);
    }
})
</script>
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
<script>
// 비밀번호 일치 검사
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
<h1>member/insert.jsp</h1>
<hr>
<div id="container" role="main">
	<div id="content">
		<form action="/member/update" method="post" id="update">
			<!-- tg-text=title -->
			<h2 class="">회원정보 수정</h2>
			<div class="join_content">
				<!-- 비밀번호 -->
				<div class="join_pw">
					<h6>비밀번호</h6>
					<input type="password" id="pw" name="pw" class="" maxlength="16" 
					placeholder="" required="required" onchange="pwUpdateCheck(), checkpw()"> <br>
					<span class="pwdiv">&nbsp;</span>
				</div>
				<!-- 비밀번호 확인 -->
				<div class="join_pw2">
					<h6>비밀번호 확인</h6>
					<input type="password" id="pw2" name="pw2" class="" maxlength="16"
					placeholder="" required="required" onchange="checkpw2()"> <br>
					<span class="pw2div">&nbsp;</span>
				</div>
				<!-- 이름 -->
				<div class="join_name">
					<h6>이름</h6>
					<input type="text" id="name" name="name" class="" value="${vo.name }"
					placeholder="" readonly="readonly"> <br>
				</div>
				<!-- 닉네임 -->
				<div class="join_nick">
					<h6>닉네임</h6>
					<input type="text" id="nick" name="nick" class="" value="${vo.nick }"
					placeholder="" required="required"> <br>
					<span class="nickdiv">&nbsp;</span>
				</div>
				<!-- 연락처 -->
				<div class="join_phone">
					<h6>연락처</h6>
					<input type="text" id="phone" name="phone" class="" value="${vo.phone }" 
					placeholder="- 없이 숫자만" required="required" maxlength="13"
					oninput="autoHyphen(this)" autofocus> 
				</div>
				<!-- 이메일 -->
				<div class="join_email">
					<h6>이메일</h6>
					<input type="text" id="email" name="email" class="" value="${vo.email }"
					placeholder="" required="required"> <br>
				</div>
			</div>
			<input type="submit" value="수정하기">
		</form>
	</div>
</div>

<%@ include file="../include/footer.jsp"%>