<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ include file="../include/header.jsp"%>
<!-- ${pageContext.request.contextPath} -->
<script src="https://code.jquery.com/jquery-3.6.0.js"></script>
<h1> </h1>

    	



<!-- 차트 이용해서 카테고리별 합산 나타내기 -->
<%-- <script src="https://cdn.jsdelivr.net/npm/chart.js@3.7.1/dist/chart.min.js"></script>
<div>
<canvas id="myChart" width="400" height="400"></canvas>
</div>


let data = [];
let label = [];
 <c:forEach items="${sum}" var="sum" varStatus="loop">
	data.push(Number(${sum['SUM'] }));
</c:forEach>

<c:forEach items="${sum}" var="sum" varStatus="loop">
	label.push('${sum['CATEGORY'] }');
</c:forEach>
console.log(label);


<script>
/* const ctx = document.getElementById('myChart').getContext('2d');
const myChart = new Chart(ctx, {
    type: 'doughnut',
    data: {
    	labels: ['식비', '교통비', '통신비', '편의점/마트', '문화생활', '쇼핑/뷰티', '기타'],
        datasets: [{
            label: '합계',
            data: data,
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

}); */
</script> --%>

<%@ include file="../include/footer.jsp"%>