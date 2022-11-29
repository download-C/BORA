<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ include file="../include/header.jsp"%>
<!-- ${pageContext.request.contextPath} -->
<script src="https://code.jquery.com/jquery-3.6.0.js"></script>

<link href="${pageContext.request.contextPath}/resources/css/goal.css" rel="stylesheet">
  
<style>
    @media (min-width: 1400px) {
      .container {
        max-width: 1200px;
      }
    }

	#moa_btn {
		background-color: #5107B0;
		margin: auto auto 0px 10px ;
		padding: 10px 15px 10px 15px;
	    border: 1px solid #fff;
 	    border-radius: 8px;
   	    color: white; 
   	    border-radius: 13px;
   	    font-size: 20px;
    }
    
    .backbtn {
      background-color: #5107B0;
      font-size: 17px;
      color: #fff;
      padding: 8px 15px 8px 15px;
      border: 1px solid #fff;
      border-radius: 8px;
    }
</style>

<!-- title -->
<div class="section-title">
	<h2><b>목돈모으기</b></h2>
	<div style="padding-top: 35px;"></div>
</div>
<!-- End title -->

<div class="container">
	<div class="row row-cols-md-14 g-4 justify-content-center">
		<!-- 1번 목표 금액 설정  -->
		<div class="col-md-6 col-12">
			<div class="card border-left-info shadow h-100 py-2">
				<div class="card-body">
					<div>
						<h3>목표 금액 설정</h3>
					</div> 
				<div class="checks" style="text-align: center; margin-top: 18px;">
					<input id="ex_rd" name="bk_iow" type="radio" value="3000" required="required" checked="checked" >
					<label for="ex_rd">3천만</label> 
					<input id="ex_rd2" name="bk_iow" type="radio" value="5000" required="required"   >
					<label for="ex_rd2">5천만</label> 
					<input id="ex_rd3" name="bk_iow" type="radio" value="7000" required="required"   >
					<label for="ex_rd3">7천만</label> 
					<input id="ex_rd4" name="bk_iow" type="radio" value="10000" required="required"  >
					<label for="ex_rd4">1억</label> 
					<input id="ex_rd5" name="bk_iow" type="radio" value="30000" required="required"  >
					<label for="ex_rd5">3억</label> 
					<input id="ex_rd6" name="bk_iow" type="radio" value="50000" required="required"  >
					<label for="ex_rd6">5억</label> 
					<input id="ex_rd7" name="bk_iow" type="radio" value="100000" required="required" >
					<label for="ex_rd7">10억</label>
				</div>
				</div>
			</div>
		</div>
   		<!-- 2번 목표 기간 설정 -->
		<div class="col-md-6 col-12">
			<div class="card border-left-info shadow h-100 py-2">
				<div class="card-body">
					<div>
						<h3>목표 기간 설정</h3>
					</div>
					<div class="input-group mb-3" id='datetimepicker1'>
						<label class="input-group-text" for="goal_year">기간 선택</label> 
						<select class="form-select" name="goal_year" id="goal_year" required>
							<option selected hidden>목표 기간을 설정해주세요</option>
							<option value="1">1년</option>
							<option value="2">2년</option>
							<option value="3">3년</option>
							<option value="4">4년</option>
							<option value="5">5년</option>
							<option value="6">6년</option>
							<option value="7">7년</option>
							<option value="8">8년</option>
							<option value="9">9년</option>
							<option value="10">10년</option>
						</select>
					</div>
				</div>
			</div>
		</div>
	</div>
</div>
<br>

<div class="container">
	<div class="row row-cols-md-4 g-4 justify-content-center">
		<div class="col-md-6 col-11">
			<!-- 3번 차트 그래프 -->
          	<div class="card border-left-info shadow h-100 py-2">
           		 <div class="card-body">
            	 <!-- title -->
              	 <div>
                	<h3>나의 <span style="background: linear-gradient(to top, #c8a7fa 50%, transparent 50%);">자산 보기</span></h3>
              	 </div>
              	 <!-- End title -->
              	 <div class="chart-pie pt-4 pb-2">
				 	<!-- 차트 생성 -->
					<script src="https://cdn.jsdelivr.net/npm/chart.js@3.7.1/dist/chart.min.js"></script>
					<script src="${pageContext.request.contextPath}/resources/js/goalChart.js"></script>
					<div class="container" style="margin-left: 10px;">
						<canvas id="myChart" style="width: 340px; height: 200px; max-width: 400px; margin: auto;"></canvas>
             		</div>
			 	</div>
				<div style="margin-top: 10px;">
					<h5>내 목표 : <span id="goalSpan"></span>만 원</h5>
					<h5>내 자산 : <span id="total2"></span>만 원</h5>
				</div>
            	</div>
          	</div>
        </div>

		<!-- 4번 목돈 모으기 안내 -->
   		<div class="col-md-6 col-11">
      		<div class="card border-left-info shadow h-100 py-2">
	    	    <div class="card-body">
	    	       	<div style="text-align: center;">
	   	        		<!-- 목표 기간 달성 안내 -->
	            		<h4>목표 금액까지&nbsp;<span id="gapMoneySpan">____</span><b>만 원</b> 남았습니다</h4>
         			       	<script src="${pageContext.request.contextPath}/resources/js/dDay.js"></script>
							<div id="remain-time" style="color: red; font-size: 120%;"></div>
           	  		</div>
           			<hr>
           				<!-- 목표 금액 달성 안내 -->
   	  	              <div style="width: 100%; margin: 20px auto; text-align: center;">
  			                <h4 style="text-align: center;">목표 금액 달성을 위해</h4>
 	        	            <button type="button" id="moa_btn" style="display: inline-block;">얼마나 모아야 하지? 클릭🤔 </button>
         		    	    </div>
           		   	 <div style="text-align: center; padding: 10px; margin: 0 auto;">
      	  	        	  <h5>&nbsp;하루에 <b><span id="moa_1day">_____ </span></b>만 원 이상을 모아야 해요.</h5>
 	 	      	          <h5>&nbsp;한 달에 <b><span id="moa_1month">_____ </span></b>만 원 이상을 모아야 해요.</h5>
 		      	          <h5>&nbsp;1년에 <b><span id="moa_1year">_____ </span></b>만 원 이상을 모아야 해요.</h5>
 	                    <div style="margin: 20px;">
      		     	       <h6><b style="color:#5107B0;">BORA</b>와 함께 영차영차🏋️‍♂️</h6>
        		        </div>
					</div>
				</div>
			</div>
		</div>
	</div>
</div>
<br>

<script>
$('#moa_btn').click(function(){
	var goal = $(':radio[name="bk_iow"]:checked').val();
	var curr = Number(total);
	var gap = goal - (curr/10000);
	var n = parseInt($('#goal_year option:selected').val());
	
	$.ajax({
		url: '/ajax/moa',
		data: {'gapMoney': gap, 'gapDate': diffDate},
		dataType: 'JSON',
		success: function(rData){
// 			alert('갔다 옴');
			console.log(rData);
			
			let moaOneDay = parseInt(rData.moaOneDay);
			const moaOneDayC = moaOneDay.toString().replace(/\B(?<!\.\d*)(?=(\d{3})+(?!\d))/g, ",");
			let moaOneMonth = parseInt(rData.moaOneMonth);
			const moaOneMonthC = moaOneMonth.toString().replace(/\B(?<!\.\d*)(?=(\d{3})+(?!\d))/g, ",");
			let moaOneYear = parseInt(rData.moaOneYear);
			const moaOneYearC = moaOneYear.toString().replace(/\B(?<!\.\d*)(?=(\d{3})+(?!\d))/g, ",");
			
// 			console.log(Math.round(moaOneDay * 1000) / 1000);
// 			console.log(Math.round(moaOneMonth * 1000) / 1000);
// 			console.log(Math.round(moaOneYear * 1000) / 1000);

			// 소수점 한자리까지만 나오게 하고 싶은데,,,,,
			$('#moa_1day').html(moaOneDayC);
			$('#moa_1month').html(moaOneMonthC);
			$('#moa_1year').html(parseInt(gap/n).toString().replace(/\B(?<!\.\d*)(?=(\d{3})+(?!\d))/g, ","));
		}
	});// ajax
});// click
</script>

<!-- 내 목표 radio 값 출력 -->


<!-- 내 자산 금액에 콤마 -->
<script>
var total = sessionStorage.getItem("total");
const total2 = (total/10000).toString().replace(/\B(?<!\.\d*)(?=(\d{3})+(?!\d))/g, ",");
$('#total2').html(total2);
</script>

<!-- 내 자산으로 돌아가기  --> 
<div class="container">
   	<div class="col-md-16 col-16">
	        <!-- 자산 조회를 위한 인증 요청 작업 수행 -->
 	        <form method="get" action="/openbank/userInfo">
               <input type="hidden" name="access_token" value="${sessionScope.token }">
               <input type="hidden" name="user_seq_no" value="1101014738">
			   <button type="submit" class="backbtn acct_user">내 자산 조회로 돌아가기</button>
            </form>
    </div>
</div> 
<br>

<%@ include file="../include/footer.jsp"%>