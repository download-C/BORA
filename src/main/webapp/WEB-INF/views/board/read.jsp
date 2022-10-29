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
	alert("세션값이 만료되어 로그인 페이지로 이동합니다.");
	location.href = "/member/login";
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


<h1>${vo.bno }번 글 🐱🐶 상세 보기 🐱🐶 </h1>

		<!-- 수정, 삭제 시 필요한 글 번호(bno) 저장하는 폼태그 =====================-->
		<form role="bno_form" method="post">
			<input type="hidden" name="bno" value="${vo.bno }">
		</form>
		<!-- 수정, 삭제 시 필요한 글 번호(bno) 저장하는 폼태그 껏 =====================-->

	<div>
		<div>
			아이디
			<div>
				<input type="text" name="id" value="${loginID }" readonly>
			</div>
		</div>
		<br>
		<div>
			닉네임
			<div>
				<input type="text" value="${nick }" readonly>
			</div>
			<!-- 		닉네임,, 아이디 -> 닉네임 끌어오는 메서드를 만들어야 하남? DB에 넣을 필욘 없고 걍 보여주기만 -->
		</div>
		<br>
		<div>
			카테고리
			<div>
				<input type="text" value="${vo.b_ctgr }" readonly></span>
			</div>
		</div>
		<br>
		<div>
			제목
			<div>
				<input type="text" name="b_title" value="${vo.b_title }" readonly>
			</div>
		</div>
		<br>
		<div>
			내용
			<textarea id="summernote" name="b_content" readonly> ${vo.b_content }</textarea>
		</div>
		<br>
		<div>
			파일
			<div>
				<input type="text" name="b_file" value="${vo.b_file }" readonly>
			</div>
		</div>
		<br>
		<div>
			<input type="button" value="수정" class="btn_mod">
			<input type="button" value="삭제" class="btn_del">
			<input type="button" value="목록" class="btn_list">
		</div>
	</div>


<script type="text/javascript">
// jQuery 구간 시작~ =================================================
	// jQuery 라이브러리는,, 추가 안 해도 되나용? 
	// 넵^^ include된 header 안에 라이브러리 이미 포함되어 있음!!
  $(document).ready(function(){
// 	  alert('jQuery 실행🎊🎊');
	  // 버턴들 제어할 거!!!!!!!!!!!!
	  
	  // 글번호 정보를 포함하는 폼태그에 접근
	  var fr = $('form[role="bno_form"]'); // role이 form인 폼태그에 접근해서 그걸 fr 변수에 담기
	  console.log(fr);                 // 이러니까 폼태그 정보 나오네~
	  
	  
	  
	  
	  $(".btn_mod").click(function(){
		  alert('정상 동작 중');
		  // bno폼태그 속성 바꿀 거!!
		  fr.attr("action", "/board/modify");
		  fr.attr("method", "get"); // get방식으로 바꿔서 전달 
		  fr.submit(); // 클릭하면? 속성 바꾸고 -> submit 되게~~
	  });// 수정 버턴 click
	  
	  
	  $(".btn_list").click(function(){
		  // 목록 버턴 클릭했을 때
		  location.href = "/board/list?page=1";
	  });// 목록 버턴 click
	  
	  
	  $(".btn_del").click(function(){
		  // 삭제 버턴 클릭했을 때~~
		  alert('삭제 버턴 클릭됨');
		  fr.attr("action", "/board/delete");
		  fr.submit(); // 클릭하면? 속성 바꾸고 -> submit 되게~~
	  });// 삭제 버튼 click
	  
	  
  });// jQuery ready

</script>





<%@ include file="../include/footer.jsp"%>