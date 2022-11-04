<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ include file="../include/header.jsp"%>
<!-- ${pageContext.request.contextPath} -->
<script src="https://code.jquery.com/jquery-3.6.0.js"></script>

<!-- ////////////alert 커스텀//////////// -->
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/limonte-sweetalert2/7.2.0/sweetalert2.min.css">
<script src="https://cdnjs.cloudflare.com/ajax/libs/limonte-sweetalert2/7.2.0/sweetalert2.all.min.js"></script>

<script>
$(document).on('click', '#login', function(e) {
    swal(
      'message',
      '로그인 성공',
      'login'
    )
  });
  
$().ready(function () {
	  
	  $("#alertStart").click(function () {
	    Swal.fire({
	      icon: 'success',
	      title: 'Alert가 실행되었습니다.',
	      text: '이곳은 내용이 나타나는 곳입니다.',
	    });
	  }); 
});
  
// Swal.fire(
// 		  'Good job!',
// 		  'You clicked the button!',
// 		  'success'
// 		)
</script>
<button class="btn btn-primary m-2" id="alertStart">Alert 커스텀</button>



<!-- ////////////alert 커스텀//////////// -->
<!-- 뉴스 시작 -->
<script type="text/javascript">
$(document).ready(function(){
	$('#news').click(function(){
		   // ajax 사용 - jtbc 뉴스정보 불러오기
		   alert('클릭');
		   
		   $.ajax({
			   url:"https://fs.jtbc.co.kr//RSS/sports.xml",
			   success:function(data){
				   alert("페이지 다녀오기 성공");
				   
				   $(data).find("item").each(function(){
					   var title = $(this).find("title").text();
					   var link = $(this).find("link").text();
					   
					   $('div').append("<a href='"+link+"'>"+title+"</a><br>");
				   });
				   
			   },
			   error:function(){
				   alert("페이지 다녀오기 실패");
			   }
		   });
		   
	   });//click
  
});//jquery
</script>

   <input type="button" value="뉴스" id="news">
   <hr>
     <div></div>
   <hr>
<!-- 뉴스끝 -->

<!--  카카오지도 API (나중에 about페이지에 아래 코드 이동)  -->
<%-- <%@ include file="../about/map.jsp"%> --%>

<a href='/main/NoticeListPage'>공지사항 목록</a>


<%@ include file="../include/footer.jsp"%>