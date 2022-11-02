<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ include file="../include/header.jsp"%>
<!-- ${pageContext.request.contextPath} -->
<script src="https://code.jquery.com/jquery-3.6.0.js"></script>

<!-- 특정 기능을 수행하고 돌아와서 띄울 메세지가 있을 경우 -->
<script>
$(document).ready(function() {
    let message = "${msg}";
    if (message != "") {
        alert(message);
    }
});
</script>

<script type="text/javascript">
// jQuery 구간 시작~ =================================================
  $(document).ready(function(){
// 	  alert('jQuery 실행🎊🎊');
	  // 버턴들 제어할 거!!!!!!!!!!!!
	  
	  // 글번호 정보를 포함하는 폼태그에 접근
	  var fr = $('form[role="nno_form"]'); // role이 form인 폼태그에 접근해서 그걸 fr 변수에 담기
	  
	  
	  $(".btn_update").click(function(){
// 		  alert('정상 동작 중');
		  // bno폼태그 속성 바꿀 거!!
		  fr.attr("action", "/notice/update?nno="+${vo.nno}+"&page="+${page});
		  fr.attr("method", "get"); // get방식으로 바꿔서 전달 
		  fr.submit(); // 클릭하면? 속성 바꾸고 -> submit 되게~~
	  });// 수정 버턴 click
	  
	  $(".btn_delete").click(function(){
		  // 삭제 버턴 클릭했을 때~~
		  var result = confirm("정말 삭제하시겠습니까?")
		  if(result) {
			  fr.attr("action", "/notice/delete?nno="+${vo.nno});
			  fr.attr("method","post")
			  fr.submit(); // 클릭하면? 속성 바꾸고 -> submit 되게~~
		  }
	  });// 삭제 버튼 click
	  
	  $(".btn_list").click(function(){
		 // 목록 버턴 클릭했을 때
		 history.back();
	  });// 목록 버턴 click
	  
  });// jQuery ready

</script>

<!-- 태그 적는 곳 -->



	<div class="container">
<h1>${vo.nno }번 글 🐱🐶 상세 보기 🐱🐶 </h1>
<form role="nno_form">
	<div>
		<input type="hidden" name="nno" value="${vo.nno }">
		<div>글번호</div><div>${vo.nno }</div>
		<div>조회수</div>
		<div>${vo.n_readcount }</div>	
	</div>
	<div>
		<div>작성일</div>
		<div><fmt:formatDate value="${vo.n_regdate }" pattern="yyyy.MM.dd HH:mm"/></div>
	</div>
	<div>제목<div>${vo.n_title }</div></div>
	<br>
	<div>
		내용<div>${vo.n_content }</div>
		<img style="width: 100%;" 
		src="${pageContext.request.contextPath}/resources/upload/${vo.n_file}">
	</div>
</form>
<div>
<%if(loginID!=null){if(loginID.equals("admin")) {%>
	<input type="button" value="수정" class="btn_update">
	<input type="button" value="삭제" class="btn_delete">
<%} }%>
	<input type="button" value="목록" class="btn_list">
</div>
</div>



<!-- 태그 적는 곳 -->


<%@ include file="../include/footer.jsp"%>