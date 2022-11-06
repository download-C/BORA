<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ include file="../include/header.jsp"%>
<!-- ${pageContext.request.contextPath} -->
<script src="https://code.jquery.com/jquery-3.6.0.js"></script>


<!-- 모달창 script --> 
<script src="https://cdn.jsdelivr.net/npm/sweetalert2@9"></script>
<script src="https://cdn.jsdelivr.net/npm/promise-polyfill@7.1.0/dist/promise.min.js"></script>

<!-- 메세지 불러오고 모달창 띄우기 -->
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
<button class="btn btn-primary m-2" id="alertStart">Alert 커스텀</button> <br>

<button class="btn btn-primary m-2" onclick="location.href='/book/list?page=1';">가계부 목록</button> <br>

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
<!-- 체크 모달 -->
<script>
function login(message) {
  	Swal.fire({
	  title: message,
	  text: '',
	  imageUrl: '${pageContext.request.contextPath}/resources/img/logo.png',
	  imageWidth: 200,
	  imageHeight: 50,
	  imageAlt: 'Custom image',
   	})
}
</script>




   <input type="button" class="btn btn-primary m-2" value="뉴스" id="news">
   <hr>
     <div></div>
   <hr>
<!-- 뉴스끝 -->

<!--  카카오지도 API (나중에 about페이지에 아래 코드 이동)  -->
<%-- <%@ include file="../about/map.jsp"%> --%>

<a href='/main/NoticeListPage'>공지사항 목록</a>
<h3><a href='/board/listPage?page=1'>커뮤니티 목록</a></h3>

<script src="https://cdn.jsdelivr.net/npm/chart.js@3.7.1/dist/chart.min.js"></script>
<div>
<canvas id="myChart" width="400" height="400"></canvas>
</div>
<script>
const ctx = document.getElementById('myChart').getContext('2d');
const myChart = new Chart(ctx, {
    type: 'doughnut',
    data: {
        labels: ['9월', '10월', '11월', 'Green', 'Purple', 'Orange'],
        datasets: [{
            label: '합계',
            data: [12, 19, 3, 5, 2, 3],
            backgroundColor: [
                'rgb(255, 99, 132)',
                'rgb(54, 162, 235)',
                'rgb(255, 206, 86)',
                'rgb(75, 192, 192)',
                'rgb(153, 102, 255)',
                'rgb(255, 159, 64)'
            ]
        }]
    },
    options: {
  	  responsive: false
    }

});
</script>





  



<%@ include file="../include/footer.jsp"%>