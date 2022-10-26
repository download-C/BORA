<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="false"%>

<%@ include file="../include/header.jsp"%>
<!-- ${pageContext.request.contextPath} -->
<script type="text/javascript" src="https://code.jquery.com/jquery-3.6.0.js"></script>
<script>
$(document).ready(function(){
	// 아이디 join을 가진 대상의 submit시 기능 구현하기
	$("#join").submit(function(){
// 		alert("전송");
		// 아이디 미입력 제어
		if($("#id").val()=="") {
// 			alert("아이디를 입력하세요");
			
			$("#id").focus();
			return false;
		}
		
		// 비밀번호 미입력 제어
		if($("#pw").val()=="") {
			alert("비밀번호를 입력하세요");
			$("#pw").focus();
			return false;
		}
		
		// 비밀번호2 미입력 제어
		if($("#pw2").val()=="") {
			alert("재확인용 비밀번호를 입력하세요");
			$("#pw2").focus();
			return false;
		}
		
		// 비밀번호 재입력 일치 여부 제어
		if($("#pw").val() != $("#pw2").val()) {
			alert("비밀번호가 일치하지 않습니다.");
			$("#pw2").focus();
			return false;
		}
		
		// 이름 미입력 제어
		if($("#name").val()=="") {
			alert("이름을 입력하세요");
			$("#name").focus();
			return false;
		}
		
		// 닉네임 미입력 제어
		if($("#nick").val()=="") {
			alert("닉네임을 입력하세요");
			$("#nick").focus();
			return false;
		}
		
		// 전화번호 미입력 제어
		if($("#phone").val()=="") {
			alert("휴대폰을 입력하세요");
			$("#phone").focus();
			return false;
		}
		
		// 이메일 미입력 제어
		if($("#email").val()=="") {
			alert("이메일을 입력하세요");
			$("#email").focus();
			return false;
		}
	});
	
	$("#idcheck").click(function(){
		var id = $("#id").val();
		
		$.ajax({
			async: true,
            type : 'POST',
            data : id,
            url : "/check/idcheck",
            dataType : "json",
            contentType: "application/json; charset=UTF-8",
            success : function(data) {
                if (data.cnt > 0) {
                    
                    alert("아이디가 존재합니다. 다른 아이디를 입력해주세요.");
                    //아이디가 존제할 경우 빨깡으로 , 아니면 파랑으로 처리하는 디자인
                    $("#id").addClass("has-error")
                    $("#divInputId").removeClass("has-success")
                    $("#userid").focus();
                    
                
                } else {
                    alert("사용가능한 아이디입니다.");
                    //아이디가 존제할 경우 빨깡으로 , 아니면 파랑으로 처리하는 디자인
                    $("#divInputId").addClass("has-success")
                    $("#divInputId").removeClass("has-error")
                    $("#userpwd").focus();
                    //아이디가 중복하지 않으면  idck = 1 
                    idck = 1;
                    
                }
            },
            error : function(error) {
                
                alert("error : " + error);
            }
		});
	});
});
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
					<input type="text" id="id" name="id" class="" placeholder=""> 
					<input type="button" value="중복체크" id="idcheck"><br>
					<span class="iddiv">&nbsp;</span>
				</div>
				<!-- 비밀번호 -->
				<div class="join_pw">
					<h6>비밀번호</h6>
					<input type="password" id="pw" name="pw" class="" placeholder=""> <br>
					<span class="pwdiv">&nbsp;</span>
				</div>
				<!-- 비밀번호 확인 -->
				<div class="join_pw2">
					<h6>비밀번호 확인</h6>
					<input type="password" id="pw2" name="pw2" class="" placeholder=""> <br>
					<span class="pw2div">&nbsp;</span>
				</div>
				<!-- 이름 -->
				<div class="join_name">
					<h6>이름</h6>
					<input type="text" id="name" name="name" class="" placeholder=""> <br>
					<span class="namediv"></span>
				</div>
				<!-- 닉네임 -->
				<div class="join_nick">
					<h6>닉네임</h6>
					<input type="tel" id="nick" name="nick" class="" placeholder=""> <br>
					<span class="nickdiv">&nbsp;</span>
				</div>
				<!-- 연락처 -->
				<div class="join_phone">
					<h6>연락처</h6>
					<input type="tel" id="phone" name="phone" class="" placeholder="- 없이 숫자만"> <br>
					<span class="phonediv">&nbsp;</span>
				</div>
				<!-- 이메일 -->
				<div class="join_email">
					<h6>이메일</h6>
					<input type="text" id="email" name="email" class="" placeholder=""> <br>
					<span class="emaildiv">&nbsp;</span>
				</div>
			</div>
			<input type="submit" value="가입하기">
		</form>
	</div>
</div>

<%@ include file="../include/footer.jsp"%>
