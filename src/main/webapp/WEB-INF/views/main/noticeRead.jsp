<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ include file="../include/header.jsp"%>
<!-- ${pageContext.request.contextPath} -->
<script src="https://code.jquery.com/jquery-3.6.0.js"></script>

<!-- 비밀번호 회원정보 수정 시 alert -->
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
		  fr.attr("action", "/notice/update");
		  fr.attr("method", "get"); // get방식으로 바꿔서 전달 
		  fr.submit(); // 클릭하면? 속성 바꾸고 -> submit 되게~~
	  });// 수정 버턴 click
	  
	  $(".btn_delete").click(function(){
		  // 삭제 버턴 클릭했을 때~~
		  alert(${vo.nno}+'번 공지사항이 삭제되었습니다.');
		  fr.attr("action", "/notice/delete");
		  fr.submit(); // 클릭하면? 속성 바꾸고 -> submit 되게~~
	  });// 삭제 버튼 click
	  
	  $(".btn_list").click(function(){
		 // 목록 버턴 클릭했을 때
		 history.back();
	  });// 목록 버턴 click
	  
  });// jQuery ready

</script>

<!-- 태그 적는 곳 -->


<div class="container mt-5 ">
  <div class="row" style="justify-content: center; align-items: center;">
    <div class="col-lg-8">
			<!-- 수정, 삭제 시 필요한 글 번호(nno) 저장하는 폼태그 껏 =====================-->
		  <form role="nno_form" method="post">
				<input type="hidden" name="nno" value="${vo.nno }">
			</form>
      <!-- Post content-->
      <article>
        <!-- Post header-->
        <header class="mb-4">
          <!-- Post title-->
          <h1 class="fw-bolder mb-1">${vo.n_title }</h1>
           <!-- Post meta content-->
          <div class="text-muted fst-italic mb-2"><b>작성일시:</b> <fmt:formatDate value="${vo.n_regdate }" pattern="yyyy.MM.dd HH:mm"/>
         			&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<b>작성자:</b> 관리자</div>
				</header>
				<hr>
		  <figure class="mb-4" style="text-align: center">
			  <img src="${pageContext.request.contextPath}/resources/upload/${vo.n_file}" alt="${vo.n_file }"/>
		  </figure>
		  <section class="mb-5"><p class="fs-5 mb-4">${vo.n_content }</p></section>
	  </article>
	  </div>
  </div>
	<%if(loginID!=null){if(loginID.equals("admin")) {%>
		<button class="btn_update" style="border: none; margin: 2px; background-color: #5107B0; color: white; border-radius: 5px;">수정</button>
    <button class="btn_delete" style="border: none;margin: 2px; background-color: #5107B0; color: white; border-radius: 5px;">삭제</button>
  <%} }%>
	<button style="border: none;margin: 2px; background-color: #5107B0; color: white; border-radius: 5px;" class="btn_list">목록</button></div>



<!-- 태그 적는 곳 -->


<%@ include file="../include/footer.jsp"%>