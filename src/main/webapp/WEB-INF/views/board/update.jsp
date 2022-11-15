<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ include file="../include/header.jsp"%>
<!-- ${pageContext.request.contextPath} -->
<script src="https://code.jquery.com/jquery-3.6.0.js"></script>
<link href=" ${pageContext.request.contextPath}/resources/css/writeForm.css" rel="stylesheet">
<link href="${pageContext.request.contextPath}/resources/css/style.css" rel="stylesheet">
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



<div class="container-contact100">
	<div class="wrap-contact100">
		<form action="/board/update" method="post"
			class="contact100-form validate-form">
			<span class="contact100-form-title" style="text-align: center;"> <b>📝 수정하기 📝 </b>
			</span>
			<div class="updateBoard">
				<!-- 글번호, 아이디, 닉네임 히든 구간 -->
				<input type="hidden" name="bno" value="${vo.bno }" readonly="readonly">
				<input type="hidden" name="id" value="${vo.id }" readonly="readonly">
				<input type="hidden" value="${vo.nick}" readonly="readonly">
				
				<div class="wrap-input100 validate-input" style="height: 62px;">
					<!-- 카테고리 -->  <!-- 기존 값 보이게 수정하기 -->
					<select name="b_ctgr" class="selectcategory"
							style="border-style: none; width: 100%; font-size: 16px; padding: 0 20px 0 23px; height: 62px; display: block; margin: auto; color: gray; border-radius: 23px;">
						<option value="" disabled selected style="color: black;">카테고리를 선택해주세요</option>
						<option value="골라줘BORA" style="color: black;">골라줘BORA</option>
						<option value="알려줘BORA" style="color: black;">알려줘BORA</option>
						<option value="친해져BORA" style="color: black;">친해져BORA</option>
					</select>
				</div>
				<div class="wrap-input100 validate-input">
					<!-- 제목 -->
					<div>
						<input type="text" name="b_title" class="input100" required value="${vo.b_title}">
					</div>
				</div>
				<div class="wrap-input100 validate-input">
					<!-- 내용 -->
					<textarea id="summernote" name="b_content" class="input100"> ${vo.b_content } </textarea>
				</div>
				<div class="wrap-input100 validate-input">
					파일 <input type="text" name="b_file" class="input100">
				</div>
				<div class="container-contact100-form-btn">
					<input type="submit" value="수정하기" class="contact100-form-btn">
				</div>
			</div>
		</form>
	</div>
</div>



<%@ include file="../include/footer.jsp"%>