<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ include file="../include/header.jsp"%>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<!-- ${pageContext.request.contextPath} -->
<script src="https://code.jquery.com/jquery-3.6.0.js"></script>
<script	src="https://cdn.jsdelivr.net/npm/chart.js@3.7.1/dist/chart.min.js"></script>
<!-- IONICONS -->
<script src="https://unpkg.com/ionicons@5.2.3/dist/ionicons.js"></script>

<link href="${pageContext.request.contextPath}/resources/css/style.css" rel="stylesheet">
<link href="${pageContext.request.contextPath}/resources/css/report_side.css" rel="stylesheet">
<!-- 사이드바 js -->
<script>
  function openNav() {
    document.getElementById("mySidenav").style.width = "250px";
  }

  function closeNav() {
    document.getElementById("mySidenav").style.width = "0";
  }
</script>
<!-- 사이드바 js -->

<style type="text/css">
	 
		@media (max-width: 576px) {
			.container {
				display: inline-block;
				
			}
		}
		
		#csList{
text-align: center
}
</style>
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
<script>
$(document).ready(function() {
    let msg = "${msg}";
    if (msg != "") {
        info(msg);
    }
})

//info 버튼
function info(msg1, msg2) {
    Swal.fire(
     msg1,
     msg2,
     'info' /*디자인 타입*/
    )
}//info 버튼

//버튼 배경색 입히는 버튼
function bora() {
	Swal.fire({
		  title: '로그인 후 이용 가능합니다.',
    	  width: 600,
    	  padding: '3em',
		  background: '#fff',
		  backdrop: '#fff' //#7A1CF6에 투명도
	 });
}//버튼 배경색 입히는 버튼	

function success(msg3, msg4) {
    Swal.fire(
        msg3,
        msg4,
        'success' /*디자인 타입*/
    )
}//success 버튼
	
$(document).ready(function() {
    
    let msg1 = "${msg1}";
    let msg2 = "${msg2}";
    if(msg1!="" && msg2!="") {
    	info(msg1, msg2);
    }
})
</script>




<script type="text/javascript">
function inputNumberFormat(obj){
	obj.value = comma(uncomma(obj.value));
}

function comma(str){
	str = String(str);
	return str.replace(/(\d)(?=(?:\d{3})+(?!\d))/g, '$1,');
}

function uncomma(str){
	str = String(str);
	return str.replace(/[^\d]+/g, '');
}

</script>


<script>

$(document).ready(function(){



/* ----------------------	차트 시작 -------------------------------- */


	var myChart;
	var ctx = document.getElementById('myChart').getContext('2d'); 
	function showchart(data){
		
		if(data == null){
		 myChart = new Chart(ctx, { 
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
		}else{
			//console.log(data.caArr);
			myChart = new Chart(ctx, { 
			     type: 'doughnut', 
			     data: 
			     { 
			    labels: data.caArr, 
			    datasets: [{ 
			    label: '합계', 
			    data: data.sumArr, 
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
		}
		 
		return myChart;
	};			
				

	tmpChart = showchart();


	
   $('#month').change(function(){
	
	     if(myChart != null){   // 기존 차트가 존재할 때 그 차트 파기하고 새로 시작
	    	 myChart.destroy();
	     }
	     

	     <!---------------------- 차트 끝 ------------------------------>
	     
	     
	     
	     
	     <!---------------------- ajax ------------------------------>
	     
         var month  = $(this).val();
         var year  = $('#year').val();
         var loginID = "<c:out value='${sessionScope.loginID}' /> ";
         
         
         
      $.ajax({
    	  url:"/ajax/category2",
    	  dataType : "JSON",
    	  data: {"month": month, "year":year, "loginID":loginID},
    	  success:function(data){
 
    		  console.log(data);
    		  
    		  tmpChart = showchart(data);
    		
    		  
    	  },
    	  error:function(data){
    		  console.log(data);
    	  } 
    	  
      });   
         
         
      $.ajax({
         url: "/ajax/bookTop3",
         data: {"month": month, "year":year, "loginID":loginID},
         dataType: "JSON",
         type: "get",
         success: function(data){
              $('#tbody').html("");
             $('#tbody').html(function(){
                $.each(data, function(index, item){
                   var bk_memo = item.bk_memo;
                   var bk_money = item.bk_money;
                   $('#tbody').append(
                   '<tr>'
                     +'<td>'+bk_memo+'</td>'
                     +'<td>'+bk_money+'원</td>'
                   +'</tr>'   
                   ); // append
                }); //each
             }); // html 
             
         }, //success
         error: function(){
            alert('실패');
         }
      });// ajax
      
      $.ajax({
         url: "/ajax/bookTop3Date",
         data: {"month": month, "year":year, "loginID":loginID},
         dataType: "JSON",
         type: "get",
         success: function(data){
              $('#tbody2').html("");
             $('#tbody2').html(function(){
                $.each(data, function(index, item){
                   var bk_day = item.bk_day;
                   var bk_sum = item.bk_sum;
                   $('#tbody2').append(
                   '<tr>'
                     +'<td>'+bk_day+'일</td>'
                      +'<td>'+bk_sum+'원</td>'
                   +'</tr>'   
                   ); // append
                }); //each
             }); // html 
          
         
             $.ajax({
                 url: "/ajax/consumeList",
                 data: {"month": month, "year":year, "loginID":loginID},
                 dataType: "JSON",
                 type: "get",
                 success: function(data){
                      $('#tbody3').html("");
                     $('#tbody3').html(function(){
                        $.each(data, function(index, item){
                           var bk_category = item.bk_category;
                           var bk_sum = item.bk_sum;
                           var bk_minus = item.bk_minus;
                           var bk_compare = item.bk_compare;
                           $('#tbody3').append(
                           '<tr>'
                             +'<td>'+bk_category+'</td>'
                              +'<td>'+bk_sum+'</td>'
                              +'<td>'+bk_minus+'</td>'
                              +'<td>'+bk_compare+'%</td>'
                           +'</tr>'   
                           ); // append
                        }); //each
                     }); // html 
                     
                 }, //success
                 error: function(){
                    alert('실패');
                 }
              });// ajax
           
           
           ////////////////////////////////////////////////////////////////////////////////////////
         }, //success
         error: function(){
            alert('실패');
         }
      });// ajax
      
      
      
      $.ajax({
    	  url:"/ajax/consumeTag",
    	  data: {"month": month, "year":year, "loginID":loginID},
    	  success:function(data){
    		  console.log(data);
    		  console.log($(data).find("item").find("bk_category").text());
    		  var cg = $(data).find("item").find("bk_category").text();
    		  
    		  if(cg == "저축"){  
    			  $("#pigImg").attr("src","${pageContext.request.contextPath}/resources/img/saving.png");
    		  }else if(cg == "식비"){
    			  $("#pigImg").attr("src","${pageContext.request.contextPath}/resources/img/food.png");
    		  }else if(cg == "교통비"){
    			  $("#pigImg").attr("src","${pageContext.request.contextPath}/resources/img/transfer.png");
    		  }else if(cg == "편의점/마트"){
    			  $("#pigImg").attr("src","${pageContext.request.contextPath}/resources/img/market.png");
    		  }else if(cg == "여가비"){
    			  $("#pigImg").attr("src","${pageContext.request.contextPath}/resources/img/travel.png");
    		  }else if(cg == "뷰티/쇼핑"){
    			  $("#pigImg").attr("src","${pageContext.request.contextPath}/resources/img/shopping.png");
    		  }else if(cg == "통신비"){
    			  $("#pigImg").attr("src","${pageContext.request.contextPath}/resources/img/phone.png");
    		  }else{
    			  $("#pigImg").attr("src","${pageContext.request.contextPath}/resources/img/noexist.png");
    		  }
    		  
    		  
    	  }   	  
    	  
    	  
      });
      
      
      
      
   }); // change
   
});// jquery ready
</script>

<!---------------------- 특정 연/월 선택 ------------------------------>

<!-- sideBar -->
<div id="mySidenav" class="sidenav">
  <a href="javascript:void(0)" class="closebtn" onclick="closeNav()">&times;</a>
  <a href="#">
    <ion-icon name="home-outline" class="nav__icon" style="vertical-align: middle;"></ion-icon>
    <span class="nav_name">소비리포트</span>
  </a>
  <a href="/book/list?year=${year}&month=${month}&day=${day}">
    <ion-icon name="book-outline" class="nav__icon" style="vertical-align: middle;"></ion-icon>
    <span class="nav_name">가계부</span>
  </a>
</div>
<a href="javascript:void(0)" style="cursor: pointer; " onclick="openNav()">
  <ion-icon name="grid-outline" style="margin: 12px; font-size: 30px; color: #5107B0;"></ion-icon>
</a>
<!-- End sideBar -->
<!-- title -->
<div class="section-title">
	<c:set var="year" value="<%=year%>" />
	<c:set var="month" value="<%=month%>" />

	<h2>
		<b>리포트</b>
	</h2>
	<br>
	<br>
	<div class="form-floating" style="position: relative" align="center">
		<div style="margin-bottom: 50px">
			<form id="form1" method="get" action="">
				<h3>
					<select name="year" id="year">
						<option value="2022"
							<c:if test="${year eq '2022'}">selected</c:if>>2022</option>
						<option value="2021"
							<c:if test="${year eq '2021'}">selected</c:if>>2021</option>
					</select>
			</form>
			년 &nbsp;
			<form id="form2" method="get" action=""
				style="display: inline-block; width: 6%">
				<select name="month" id="month">
					<option value="1" <c:if test="${month eq '1'}">selected</c:if>>1</option>
					<option value="2" <c:if test="${month eq '2'}">selected</c:if>>2</option>
					<option value="3" <c:if test="${month eq '3'}">selected</c:if>>3</option>
					<option value="4" <c:if test="${month eq '4'}">selected</c:if>>4</option>
					<option value="5" <c:if test="${month eq '5'}">selected</c:if>>5</option>
					<option value="6" <c:if test="${month eq '6'}">selected</c:if>>6</option>
					<option value="7" <c:if test="${month eq '7'}">selected</c:if>>7</option>
					<option value="8" <c:if test="${month eq '8'}">selected</c:if>>8</option>
					<option value="9" <c:if test="${month eq '9'}">selected</c:if>>9</option>
					<option value="10" <c:if test="${month eq '10'}">selected</c:if>>10</option>
					<option value="11" <c:if test="${month eq '11'}">selected</c:if>>11</option>
					<option value="12" <c:if test="${month eq '12'}">selected</c:if>>12</option>
				</select>
			</form>
			월 &nbsp;소비리포트
			</h3>
			</a>

		</div>
	</div>
</div>

<!---------------------- 특정 연/월 선택 ------------------------------>







<%-- 	<canvas id="myChart" width="400" height="400"></canvas> --%>

<div class="container">
	<div class="container">
	<!---------------------- 차트 부분 시작 ------------------------------>
	<div class="row row-cols-md-4 g-4">
		<div class="col-md-6 col-12" >
			<div class="card border-left-info shadow h-100 py-2">
				<div class="card-body">
					<div class="chart-pie pt-4 pb-2 justify-content-center  align-items-center">
						<canvas id="myChart" style="margin:0 auto;"></canvas>
					</div>
				</div>
			</div>
		</div>
	
	<!---------------------- 차트 부분 끝 ------------------------------>
	
  <!---------------------- 이번 달 상세 내역: 전월 대비 차액, 비교 ------------------------------>
<div class="col-md-6 col-12">
        <div class="card border-left-info shadow h-100 py-2">
          <div class="card-body">
            <table class="table table-striped mb-0">
              <thead style="background-color: gray; text-align: center;">
※ 저번달 혹은 이번달 내역이 없으면 0으로 표기 됩니다
            <tr>
              <th scope="col">카테고리</th>
             <th scope="col">총소비</th>
               <th scope="col">차액</th>
              <th scope="col">전월대비</th>
            </tr>
             </thead>
  
   
         
            <tbody id="tbody3" style="text-align: center;">
               <c:forEach var="vo" items="${consumeList }">
                  <tr>
                   <td >${vo.bk_category}</td>
                     <td > <fmt:formatNumber value="${vo.bk_sum}" pattern="#,###" />원</td>
                    <td >${vo.bk_minus }</td>
                    <td >${vo.bk_compare}%</td>
                     </tr>
                     
               </c:forEach>
              
               </tbody>
     		  </table>
     		
       	</div>
    	</div>
   </div>
   </div>
   
	<!---------------------- 이번 달 상세 내역: 전월 대비 차액, 비교 ------------------------------>
</div>

<!---------------------- 나의 소비 ROLE : 돼지 꿀꿀 ------------------------------>

<br>
<br>
<div class="container" style="text-align: center;">
	<h4>
		<b
			style="background: linear-gradient(to top, #c8a7fa 50%, transparent 50%);">나의
			소비 ROLE</b>
	</h4>
	<div class="col-lg-44" align="center">

		<img id="pigImg"
			src="${pageContext.request.contextPath}/resources/img/travel.png"
			style="width: 50%; min-width: 250px; margin-top: 30px;">
	</div>
</div>

<br>
<br>

<!---------------------- 나의 소비 ROLE : 돼지 꿀꿀 ------------------------------>


<!---------------------- 내역/날짜 TOP3 ------------------------------>
<div class="row row-cols-md-3 g-3 justify-content-center">
      <!-- 카테고리별 -->
      <div class="container"
        style=" background-color: white; padding: 20px; margin:15px; border-radius: 15px; box-shadow: 7px 14px 42px 3px rgba(163, 174, 184, 0.7);">
		<h4 style="text-align: center;">${nick}님의 <%=month %>월 소비내역 TOP3
		<i class="fa-solid fa-ranking-star"></i></h4>
		<div class="table-responsive">
			<table class="table">
				<tbody style="text-align: center;" id="tbody">

					<c:forEach var="vo" items="${top3}">
						<tr>
							<td>${vo.bk_memo}</td>
							<td> <fmt:formatNumber value="${vo.bk_money}" pattern="#,###"/>원</td>
						</tr>
					</c:forEach>
				</tbody>

			</table>
		</div>
	</div>
<div class="container"
	style=" background-color: white; padding: 20px; margin:15px; border-radius: 15px; box-shadow: 7px 14px 42px 3px rgba(163, 174, 184, 0.7);">
		<h4 style="text-align: center;">${nick }님의 <%=month %>월 소비날짜 TOP3
		<i class="fa-solid fa-ranking-star"></i></h4>
		<div class="table-responsive">
			<table class="table">
				<tbody style="text-align: center;" id="tbody2">

					<c:forEach var="vo" items="${top3date}">
						<tr>
							<td>${vo.bk_day}일</td>
							<td> <fmt:formatNumber value="${vo.bk_sum}" pattern="#,###"/>원</td>
						</tr>
					</c:forEach>
				</tbody>

			</table>
		</div>

</div>
</div>
</div>

<br><br>
<!---------------------- 내역/날짜 TOP3 끝 ------------------------------>







</main>






<%@ include file="../include/footer.jsp"%>