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
  Calendar cal = Calendar.getInstance();
	int year = cal.get(Calendar.YEAR);
	int month = cal.get(Calendar.MONTH)+1;
%>
<h3><a href='/book/dashboard?year=<%=year%>&month=<%=month%>'>가계부 대시보드로 이동</a></h3> <br>
<h3><a href='/report/report'>리포트로 이동</a></h3> <br>
<h3><a href='/book/top3?year=<%=year%>&month=<%=month%>'>top3 이동</a></h3> <br>

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
<h2>🎉🎉수료날까지~~~ </h2>
<h3 id="remain-time"></h3>

<script>
const remainTime = document.getElementById("#remain-time");



function diffDay() {
// 	alert('돌아갑니다잉');
	$('#remain-Time').html('라라라');
	
	const goalTime = new Date("2022-11-23");
	const todayTime = new Date();
	const diff = goalTime - todayTime;
	
	console.log(goalTime);
	console.log(diff);
	
	// 밀리 세컨드 단위,, 1초 = 1*1000
	//  math.floor()는 주어진 수의 같거나 작은 정수 중 큰 수를 반환 
	//    == 소수 부분 버리고 정수만 나타냄
	const diffDay = Math.floor(diff / (1000 * 60 * 60 * 24));
	//                                  1초   1분  1시간  1일
	const diffHour = Math.floor( (diff / (1000 * 60 * 60)) % 24 ); 
// 	const diffHour = Math.floor( (diff / (1000 * 60 * 60)) % 24 ).padStart(2, "0"); 
	//                                      ㄴ 1시간
	const diffMin = Math.floor( (diff / (1000 * 60)) % 60 );
// 	const diffMin = Math.floor( (diff / (1000 * 60)) % 60 ).padStart(2, "0");
	//                                      ㄴ 1분
	const diffSec = Math.floor(diff / 1000 % 60 );
// 	const diffSec = Math.floor(diff / 1000 % 60 ).padStart(2, "0");
		// padStart: 
		//  ~~~.padStart(2, "0")
		//  ~~얘를       ㄴ두 자릿수로 만들건데,  
		//                    ㄴ두 자릿수가 아니라면 0으로 채운다~ 
		//   ex. 7시간  --> 07시간!!
	
	// innerText로 추가
// 	remainTime.innerText = '${diffDay}일 ${diffHour}시간 ${diffMin}분 ${diffSec}초';
// 	remainTime.innerText = diffDay + '일 ' + diffHour + '시간 ' + diffMin + '분 ' + diffSec + '초';
	
	
} // diffDay()

// 위에 만든 diffDay() 호출,, 
//  왜 하나? 브라우저가 js 파일 호출했을 때, setInterval 실행 전의 딜레이 없애기 위해
diffDay();

// setInterval()을 사용해서 1초 간격으로 지속적으로 함수 호출하기
setInterval(diffDay, 1000);
</script>

<%-- <script src="${pageContext.request.contextPath}/resources/js/dDay.js"></script> --%>

<%@ include file="../include/footer.jsp"%>