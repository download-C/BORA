<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ include file="../include/header.jsp"%>
<!-- ${pageContext.request.contextPath} -->
<script src="https://code.jquery.com/jquery-3.6.0.js"></script>
<h1>board/insert.jsp</h1>
<%-- 
<%
	if (loginID == null) {
%>
<script>
	alert("세션값이 만료되어 로그인 페이지로 이동합니다.");
	location.href = "/main/login";
</script>
<%
	}
%>
 --%>

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


<form action="/board/update" method="post">
	<div class="insertBoard">
		<div>
			글번호
			<div> 
				<input type="text" name="bno" value="${vo.bno }" readonly="readonly">
			</div>
		</div>
		<div>
			아이디
			<div>  <!-- hidden으로 바꾸기!!! -->
				<input type="text" name="id" value="${vo.id }" readonly="readonly">
			</div>
		</div>
		<br>
		<div>
			닉네임
			<div>
				<input type="text" value="${vo.nick}" readonly="readonly">
			</div>
			<!-- 		닉네임,, 아이디 -> 닉네임 끌어오는 메서드를 만들어야 하남? DB에 넣을 필욘 없고 걍 보여주기만 -->
		</div>
		<br>
		<div>
			카테고리
			<div>
				<select name="b_ctgr"> <!-- 기존 값 보이게 수정하기 -->
					<option value="골라줘BORA">골라줘BORA</option>
					<option value="알려줘BORA">알려줘BORA</option>
					<option value="친해져BORA">친해져BORA</option>
				</select>
			</div>
		</div>
		<br>
		<div>
			제목
			<div>
				<input type="text" name="b_title" value="${vo.b_title}">
			</div>
		</div>
		<br>
		<div>
			내용
			<textarea id="summernote" name="b_content"> ${vo.b_content } </textarea>
		</div>
		<br>
		<div>
			파일
			<div>
				<input type="text" name="b_file">
			</div>
		</div>
		<br>
		<div>
			<input type="submit" value="수정하기">
		</div>
	</div>
</form>


<%@ include file="../include/footer.jsp"%>