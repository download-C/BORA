<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="false"%>

<%@ include file="../include/header.jsp"%>
<!-- ${pageContext.request.contextPath} -->

<script
	src="//t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
<script>
	function addr_execDaumPostcode() {
		new daum.Postcode(
				{
					oncomplete : function(data) {
						// 팝업에서 검색결과 항목을 클릭했을때 실행할 코드를 작성하는 부분.

						// 각 주소의 노출 규칙에 따라 주소를 조합한다.
						// 내려오는 변수가 값이 없는 경우엔 공백('')값을 가지므로, 이를 참고하여 분기 한다.
						var addr = ''; // 주소 변수
						var extraAddr = ''; // 참고항목 변수

						//사용자가 선택한 주소 타입에 따라 해당 주소 값을 가져온다.
						if (data.userSelectedType === 'R') { // 사용자가 도로명 주소를 선택했을 경우
							addr = data.roadAddress;
						} else { // 사용자가 지번 주소를 선택했을 경우(J)
							addr = data.jibunAddress;
						}

						// 사용자가 선택한 주소가 도로명 타입일때 참고항목을 조합한다.
						if (data.userSelectedType === 'R') {
							// 법정동명이 있을 경우 추가한다. (법정리는 제외)
							// 법정동의 경우 마지막 문자가 "동/로/가"로 끝난다.
							if (data.bname !== ''
									&& /[동|로|가]$/g.test(data.bname)) {
								extraAddr += data.bname;
							}
							// 건물명이 있고, 공동주택일 경우 추가한다.
							if (data.buildingName !== ''
									&& data.apartment === 'Y') {
								extraAddr += (extraAddr !== '' ? ', '
										+ data.buildingName : data.buildingName);
							}
							// 표시할 참고항목이 있을 경우, 괄호까지 추가한 최종 문자열을 만든다.
							if (extraAddr !== '') {
								extraAddr = ' (' + extraAddr + ')';
							}
							// 조합된 참고항목을 해당 필드에 넣는다.
							document.getElementById("addr_extraAddress").value = extraAddr;

						} else {
							document.getElementById("addr_extraAddress").value = '';
						}

						// 우편번호와 주소 정보를 해당 필드에 넣는다.
						document.getElementById('addr_postcode').value = data.zonecode;
						document.getElementById("addr_address").value = addr;
						// 커서를 상세주소 필드로 이동한다.
						document.getElementById("addr_detailAddress")
								.focus();
					}
				}).open();
	}
</script>

<h1>member/insert.jsp</h1>
<hr>
<div id="container" role="main">
	<div id="content">
		<form action="" method="post">
			<!-- tg-text=title -->
			<h2 class="">보라 회원가입</h2>
			<div class="join_content">
				<!-- 아이디  -->
				<div class="join_id">
					<h3>아이디</h3>
					<input type="text" id="id" name="id" class="" placeholder=""> <br>
					<span class="iddiv">&nbsp;</span>
				</div>
				<!-- 비밀번호 -->
				<div class="join_pw">
					<h3>비밀번호</h3>
					<input type="password" id="pw" name="pw" class="" placeholder=""> <br>
					<span class="pwdiv">&nbsp;</span>
				</div>
				<!-- 비밀번호 확인 -->
				<div class="join_pw2">
					<h3>비밀번호 확인</h3>
					<input type="password" id="pw2" name="pw2" class="" placeholder=""> <br>
					<span class="pw2div">&nbsp;</span>
				</div>
				<!-- 이름 -->
				<div class="join_name">
					<h3>이름</h3>
					<input type="text" id="name" name="name" class="" placeholder=""> <br>
					<span class="namediv"></span>
				</div>
				<!-- 생일 -->
				<div class="join_birth">
					<h3>생일</h3>
					<input type="date" id="date" name="birth" class="" placeholder=""> <br>
					<span class="birthdiv">&nbsp;</span>
				</div>
				<!-- 성별 -->
				<div class="join_gender">
					<h3>성별</h3>
					<input type="radio" id="gender_m" name="gender" class="" placeholder="">남
					<input type="radio" id="gender_f" name="gender" class="" placeholder="">여 <br>
					<span class="genderdiv">&nbsp;</span>
				</div>
				<!-- 연락처 -->
				<div class="join_phone">
					<h3>연락처</h3>
					<input type="tel" id="phone" name="phone" class="" placeholder="- 없이 숫자만"> <br>
					<span class="phonediv">&nbsp;</span>
				</div>
				<!-- 주소 -->
				<div class="join_ad">
					<h3>주소</h3>
					<input type="text" id="ad_postcode" placeholder="우편번호"> 
					<input type="button" onclick="addr_execDaumPostcode()" value="우편번호 찾기"><br>
					<input type="text" id="ad_address" placeholder="주소"><br>
					<input type="text" id="ad_detail" placeholder="상세주소">
					<input type="text" id="ad_extra" placeholder="참고항목">
					<span class="addiv">&nbsp;</span>
				</div>
				<!-- 이메일 -->
				<div class="join_email">
					<h3>이메일</h3>
					<input type="email" id="email" name="email" class="" placeholder=""> <br>
					<span class="emaildiv">&nbsp;</span>
				</div>
			</div>
			<input type="submit" value="가입하기">
		</form>
	</div>
</div>

<%@ include file="../include/footer.jsp"%>
