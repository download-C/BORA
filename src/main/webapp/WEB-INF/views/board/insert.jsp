<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ include file="../include/header.jsp"%>
<!-- ${pageContext.request.contextPath} -->
<script src="https://code.jquery.com/jquery-3.6.0.js"></script>
<h1>board/insert.jsp</h1>
<%
	if (loginID == null) {
%>
<script>
	alert("로그인 후 사용 가능한 페이지입니다.");
	location.href = "/main/login";
</script>
<%
	}
%>

<!-- ======== for 썸머노트 ============== -->
<script src="https://cdn.jsdelivr.net/npm/jquery@3.6.1/dist/jquery.min.js"></script>
<script type="text/javascript">
	$(document).ready(function() {
		$('#summernote').summernote({
			height : 300, // 에디터 높이
// 			width : 1000,
			minHeight : null, // 최소 높이
			maxHeight : null, // 최대 높이
			focus : true, // 에디터 로딩후 포커스를 맞출지 여부
			lang : "ko-KR", // 한글 설정
			placeholder : '최대 2048자까지 쓸 수 있습니다,, 아마도? ㅎ', //placeholder 설정
			/* callbacks : {
				onImageUpload : function(files, editor, welEditable) {     
					for (var i = 0; i < files.length; i++) {
						sendFile(files[i], this);
					}
				}
			} */
			
		});
	});

// file첨부
/* function sendFile(file, editor) {
	var form_data = new FormData();
	form_data.append('file', file);
	$.ajax({
		data : form_data,
		type : "POST",
		url : '/resources/summerimages',
		cache : false,
		contentType : false,
		enctype : 'multipart/form-data',
		processData : false,
		success : function(url) {
			alert('summernote file 첨부 url로 갔다 오기 성공');
			$(editor).summernote('insertImage', url, function($image) {
				$image.css('width', "25%");
			});
		} // success
	});// ajax
} */

</script>

<script src="${pageContext.request.contextPath}/resources/js/summernote/summernote-lite.js"></script>
<script src="${pageContext.request.contextPath}/resources/js/summernote/lang/summernote-ko-KR.js"></script>
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/summernote/summernote-lite.css">
<!-- ======== for 썸머노트 끝 ============== -->


<div class="container-contact100">
<div class="wrap-contact100">
<form action="/board/insert" method="post" class="contact100-form validate-form">
			<span class="contact100-form-title">
              <b>글쓰기</b>
            </span>
	<div class="insertBoard">
		<div>
			<!-- 아이디 -->
			<div>   <!-- hidden으로 바꾸기!!! -->
				<input type="text" name="id" value="${loginID }" readonly="readonly">
			</div>
		</div>
		<br>
		<div>
			<!-- 닉네임 -->
			<div>
				<input type="text" name="nick" value="${sessionScope.nick }" readonly="readonly">
			</div>
			<!-- 		닉네임,, 아이디 -> 닉네임 끌어오는 메서드를 만들어야 하남? DB에 넣을 필욘 없고 걍 보여주기만 -->
		</div>
		<br>
		<div class="wrap-input100 validate-input" style="height: 62px;" >
			<!-- 카테고리 -->
				<select name="b_ctgr"  class="selectcategory"  style="border-style: none; width: 100%; font-size: 16px; padding: 0 20px 0 23px; height: 62px; display: block; margin: auto; color: gray; border-radius:23px;">
					<option value="골라줘BORA"  style="color: black;">골라줘BORA</option>
					<option value="알려줘BORA"  style="color: black;">알려줘BORA</option>
					<option value="친해져BORA"  style="color: black;">친해져BORA</option>
				</select>
		</div>
		<br>
		<div class="wrap-input100 validate-input" >
			<!-- 제목 -->
			<div>
				<input type="text" name="b_title"  class="input100"  placeholder="제목을 입력해주세요." required>
			</div>
		</div>
		<br>
		<div class="wrap-input100 validate-input" >
			<!-- 내용 -->
			<textarea id="summernote" name="b_content"  class="input100"></textarea>
		</div>
		<br>
			<div class="wrap-input100 validate-input" >
			파일
				<input type="text" name="b_file" class="input100" >
			</div>
		<br>
		<div class="container-contact100-form-btn">
			<input type="submit" value="글쓰기"  class="contact100-form-btn">
		</div>
	</div>
</form>
</div>
</div>



<%@ include file="../include/footer.jsp"%>