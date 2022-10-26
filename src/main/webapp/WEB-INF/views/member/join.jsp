<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="false"%>

<%@ include file="../include/header.jsp"%>
<!-- ${pageContext.request.contextPath} -->

<h1>member/insert.jsp</h1>
<hr>
<div id="container" role="main">
	<div id="content">
		<form action="${pageContext.request.contextPath}/member/join" method="post">
			<!-- tg-text=title -->
			<h2 class="">보라 회원가입</h2>
			<div class="join_content">
				<!-- 아이디  -->
				<div class="join_id">
					<h6>아이디</h6>
					<input type="text" id="id" name="id" class="" placeholder=""> <br>
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
				<!-- 생일 -->
<!-- 				<div class="join_birth"> -->
<!-- 					<h6>생일</h6> -->
<!-- 					<input type="date" id="date" name="birth" class="" placeholder=""> <br> -->
<!-- 					<span class="birthdiv">&nbsp;</span> -->
<!-- 				</div> -->
				<!-- 성별 -->
<!-- 				<div class="join_gender"> -->
<!-- 					<h6>성별</h6> -->
<!-- 					<input type="radio" id="gender_m" name="gender" value="남" class="" placeholder="">남 -->
<!-- 					<input type="radio" id="gender_f" name="gender" value="여" class="" placeholder="">여 <br> -->
<!-- 					<span class="genderdiv">&nbsp;</span> -->
<!-- 				</div> -->
				<!-- 연락처 -->
				<div class="join_phone">
					<h6>연락처</h6>
					<input type="tel" id="phone" name="phone" class="" placeholder="- 없이 숫자만"> <br>
					<span class="phonediv">&nbsp;</span>
				</div>
				<!-- 주소 -->
<!-- 				<div class="join_ad"> -->
<!-- 					<h6>주소</h6> -->
<!-- 					<input type="text" id="ad_postcode" placeholder="우편번호">  -->
<!-- 					<input type="button" onclick="addr_execDaumPostcode()" value="우편번호 찾기"><br> -->
<!-- 					<input type="text" id="ad_address" placeholder="주소"><br> -->
<!-- 					<input type="text" id="ad_detail" placeholder="상세주소"> -->
<!-- 					<input type="text" id="ad_extra" placeholder="참고항목"> -->
<!-- 					<span class="addiv">&nbsp;</span> -->
<!-- 				</div> -->
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
