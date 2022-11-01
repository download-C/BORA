<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ include file="../include/header.jsp"%>
<!-- ${pageContext.request.contextPath} -->
<script src="https://code.jquery.com/jquery-3.6.0.js"></script>
<% if (loginID == null) { %>

<!-- 세션값(로그인) 확인 -->
	<script>
	// 세션값 여부
	alert("세션값이 만료되어 로그인 페이지로 이동합니다.");
	location.href = "/main/login";

	$(document).ready(function() {
		let message = "${msg}";
		if (message != "") {
			alert(message);
		}
	});
	</script>
<%} else {%>
	<% if(!loginID.equals("admin")) { %>
	<script>
	// 로그인한 아이디가 관리자가 아닐 때
	alert("관리자만 사용 가능한 페이지입니다.");
	location.href = "/main/main";
	</script>
	<%}%>
<%} %>


<!-- 태그 적는 곳 -->


<!-- ======== for 썸머노트 ============== -->
<script src="https://cdn.jsdelivr.net/npm/jquery@3.6.1/dist/jquery.min.js"></script>
<script type="text/javascript">
	$(document).ready(function() {
		$('#summernote').summernote({
			height : 300, // 에디터 높이
			width : 1000,
			minHeight : null, // 최소 높이
			maxHeight : null, // 최대 높이
			focus : true, // 에디터 로딩후 포커스를 맞출지 여부
			lang : "ko-KR", // 한글 설정
			placeholder : '최대 2048자까지 쓸 수 있습니다' //placeholder 설정
		});
	});
</script>
<script src="${pageContext.request.contextPath}/resources/js/summernote/summernote-lite.js"></script>
<script src="${pageContext.request.contextPath}/resources/js/summernote/lang/summernote-ko-KR.js"></script>
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/summernote/summernote-lite.css">
<!-- ======== for 썸머노트 끝 ============== -->


<form action="/notice/write" method="post" enctype="multipart/form-data">
	<div class="insertNotice">
		<div>
			<div>
				<input type="text" name="n_title" placeholder="공지사항 제목">
			</div>
		</div>
		<br>
		<div>
			내용
			<textarea id="summernote" name="n_content" ></textarea>
		</div>
		<div>
			<input type="submit" value="글쓰기">
		</div>
	</div>
</form>




<!-- 태그 적는 곳 -->


<%@ include file="../include/footer.jsp"%>