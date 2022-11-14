<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ include file="../include/header.jsp"%>
<!-- ${pageContext.request.contextPath} -->
<script src="https://code.jquery.com/jquery-3.6.0.js"></script>
<%
if(loginID==null) {%>
<!-- 세션값(로그인) 확인 -->
<script>
// 세션값 여부
	info("로그인 필요!", "로그인 페이지로 이동합니다.")
	
	$(document).ready(function() {
	    let message = "${msg}";
	    if (message != "") {
	        info(message);
	    }
	})

//info 버튼
function info(msg1, msg2) {
    Swal.fire(
     msg1,
     msg2,
     'info' /*디자인 타입*/
    )
    setTimeout('location.href="/main/login";', 1500);
}//info 버튼
</script>
<%} %>
<!-- 비밀번호 회원정보 수정 시 alert -->
<script>
$(document).ready(function() {
    let message = "${msg}";
    if (message != "") {
        alert(message);
    }
});
</script>
<form action="/notice/update" method="post">
	<div class="insertNotice">
		<div>
			글번호
			<div> 
				<input type="text" name="nno" value="${vo.nno }" readonly="readonly">
			</div>
		</div>
		<br>
		<div>
			제목
			<div>
				<input type="text" name="n_title" value="${vo.n_title}">
			</div>
		</div>
		<br>
		<div>
			내용
			<textarea name="n_content"> ${vo.n_content } </textarea>
		</div>
		<br>
		<div>
			첨부파일 ${vo.n_file }
			<div>
				<input type="file" name="uploadFile" >
			</div>
		</div>
		<br>
		<div>
			<input type="submit" value="수정하기">
		</div>
	</div>
</form>

<!-- 태그 적는 곳 -->


<%@ include file="../include/footer.jsp"%>