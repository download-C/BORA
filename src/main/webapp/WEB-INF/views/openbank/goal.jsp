<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ include file="../include/header.jsp"%>
<!-- ${pageContext.request.contextPath} -->
<script src="https://code.jquery.com/jquery-3.6.0.js"></script>
<h1>목돈 모으기 </h1>


<div class="container">
	<div style="border: 3px solid red; width: 100%;">






              
<br><br><br><br>


<div class="row row-cols-md-13 g-13 justify-content-center">
 <div class="col-md-6 col-11">
        <div class="card border-left-info shadow h-100 py-2">
          <div class="card-body">
              <div class="container">
              <h5>나의BORA</h5><br>
<!--               <i class="fas fa-clipboard-list fa-2x text-gray-300"></i> -->
<!--               <div class="card-body"> -->
<!--                 <div class="row no-gutters align-items-center"> -->
                
                
                                <!-- 목표설정 -->
<script src="https://cdn.jsdelivr.net/npm/chart.js@3.7.1/dist/chart.min.js"></script>
<div>
<canvas id="myChart" width="180" height="250"></canvas>
</div>
<script>
 const ctx = document.getElementById('myChart').getContext('2d');
 const myChart = new Chart(ctx, {
     type: 'bar',
     data: {
         labels: ['내 목표 값', '내 자산'],
         datasets: [{
             label: '자산관리',
             data: [200, 100],
             backgroundColor: [
                 'rgb(255, 99, 132)',
                 'rgb(54, 162, 235)'
             ]
         }]
     },
     options: {
   	  responsive: false
     }

 });
</script>
                
              </div>
          </div>
        </div>
      </div>
</div><br>
</div>


</div>


<%@ include file="../include/footer.jsp"%>