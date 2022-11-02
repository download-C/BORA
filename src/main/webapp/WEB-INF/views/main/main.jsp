<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ include file="../include/header.jsp"%>
<!-- ${pageContext.request.contextPath} -->
<script src="https://code.jquery.com/jquery-3.6.0.js"></script>

<!-- ////////////alert 커스텀//////////// -->
<!--  -->
<script src="https://code.jquery.com/jquery-3.6.0.js"></script>

<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/sweetalert2@11.6.5/dist/sweetalert2.min.css">
<script src="https://cdn.jsdelivr.net/npm/sweetalert2@11.6.5/dist/sweetalert2.min.js"></script>


<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/limonte-sweetalert2/7.2.0/sweetalert2.min.css">
<script src="https://cdnjs.cloudflare.com/ajax/libs/limonte-sweetalert2/7.2.0/sweetalert2.all.min.js"></script>
<script>
$(document).on('click', '#success', function(e) {
    swal(
      'Success',
      '로그인 성공이용',
      'success'
    )
  });
</script>

<button id="success">Success</button>
<!-- ////////////alert 커스텀//////////// -->



<!-- ////////////alert 커스텀//////////// -->
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/limonte-sweetalert2/7.2.0/sweetalert2.min.css">
<script src="https://cdnjs.cloudflare.com/ajax/libs/limonte-sweetalert2/7.2.0/sweetalert2.all.min.js"></script>

<href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css"
         rel="stylesheet"
         integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC"
         crossorigin="anonymous"
      />

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





<!--  카카오지도 API (나중에 about페이지에 아래 코드 이동)  -->
<%@ include file="../about/map.jsp"%>




<%@ include file="../include/footer.jsp"%>