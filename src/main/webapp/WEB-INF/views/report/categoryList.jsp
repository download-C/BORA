<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ include file="../include/header.jsp"%>
<!-- ${pageContext.request.contextPath} -->
<script src="https://code.jquery.com/jquery-3.6.0.js"></script>

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

<script type="text/javascript">
$(document).ready(function() {
	
	function month(){
	 var date = new Date();
	 var month = date.getMonth()+1;//월
	 
	 return month;
	};
 

$('#month').append(function(){
	 return  month();
 });
 
 
 
});
</script>


<h3><b><%=loginID %>님</b>의 <b><spand id="month"></spand>월</b> 소비 카테고리🎠</h3>

<!-- 차트 이용해서 카테고리별 합산 나타내기 -->
 <script src="https://cdn.jsdelivr.net/npm/chart.js@3.7.1/dist/chart.min.js"></script>
<div>
<canvas id="myChart" width="400" height="400"></canvas>
</div>



<script>
				
				const ctx = document.getElementById('myChart').getContext('2d'); 
				 const myChart = new Chart(ctx, { 
				     type: 'doughnut', 
				     data: 
				     { 
				     	labels: ${caArr}, 
				        datasets: [{ 
				            label: '합계', 
				           data: ${sumArr}, 
				           backgroundColor: [ 
				            	  'rgb(100, 92, 170)', 
				                  'rgb(160, 132, 202)', 
				                'rgb(191, 172, 224)', 
				                'rgb(235, 199, 232)', 
				                 'rgb(253, 235, 247)', 
				                 'rgb(251, 202, 255)', 
				                 'rgb(255, 173, 240)' 
				                
				             ] 
				       }] 
				    }, 
				    options: { 
				  	  responsive: false 
				    } 

				 });  





 
</script> 

<%@ include file="../include/footer.jsp"%>