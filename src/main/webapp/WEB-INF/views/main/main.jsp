<%@page import="java.util.Calendar"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ include file="../include/header.jsp"%>
<!-- ${pageContext.request.contextPath} -->
<script src="https://code.jquery.com/jquery-3.6.0.js"></script>


<!-- alert 모달 필수  --> 
<script src="https://cdn.jsdelivr.net/npm/sweetalert2@9"></script>
<script src="https://cdn.jsdelivr.net/npm/promise-polyfill@7.1.0/dist/promise.min.js"></script>

<!-- login 성공 메세지 불러오기 -->
<script>
$(document).ready(function(){	
	let message = "${msg}";
	if(message!="") {
		login(message);
	}
 });
</script>

<!-- login 성공 alert 모달 -->
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


<!-- 뉴스 시작 -->
<script type="text/javascript">
$(document).ready(function(){
		$.ajax({
			url:"https://fs.jtbc.co.kr//RSS/economy.xml",
			success:function(rData){
				$(rData).find("item").each(function(index){
					if (index < 3) {
						// 기사 3개만 나타나도록
						var title = $(this).find("title").text();
						var link = $(this).find("link").text();
						var desc = $(this).find("description").text();
						$('#newsDiv').append(title+"<br>"+desc+"<br><a href='"+link+"' target='_blank'>기사 보러 ㄱㄱ</a><hr>");
					} else return false;
				});
			},
			error:function(){
				alert("페이지 다녀오기 실패");
			}
		}); // ajax
});//jquery
</script>
<!-- 뉴스끝 -->

<h3><a href='/main/NoticeListPage'>공지사항 목록</a></h3> <br>
<h3><a href='/board/list?page=1'>커뮤니티 목록</a></h3> <br>
<a href='/calendar/sample'>달력 샘플</a> <br>
<%	
  cal = Calendar.getInstance();
  year = cal.get(Calendar.YEAR);
  month = cal.get(Calendar.MONTH)+1;
%>

<h3><a href='/book/dashboard?year=<%=year%>&month=<%=month%>'>가계부 대시보드로 이동</a></h3> <br>
<h3><a href='/report/categoryList'>리포트로 이동</a></h3> <br>
<h3><a href='/book/top3?year=<%=year%>&month=<%=month%>'>top3 이동</a></h3> <br>
<h3><a href='/openbank/goal'>자산관리 목표 설정 이동</a></h3> <br>

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

<hr>

<!-- 뉴스 뜨는 공간 -->
<div id="newsDiv"></div>

<!-- 디데이 테서터 중 -->
<h2>🎉🎉크리스마스~~~ </h2>
<h3><div id="remain-time"></div></h3>
<script src="${pageContext.request.contextPath}/resources/js/dDay.js"></script>

<%@ include file="../include/footer.jsp"%>