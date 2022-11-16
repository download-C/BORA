<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ include file="../include/header.jsp"%>
<!-- ${pageContext.request.contextPath} -->
<script src="https://code.jquery.com/jquery-3.6.0.js"></script>
<h1>목돈 모으기 </h1>


<div class="container">
	<div class="box" style="display: flex; justify-content: space-between; flex-flow: row nowrap;">
	<!-- bar 차트 구역 -->
	<div style="border: 3px solid red; width: 50%;"><br>
		<div class="row row-cols-md-13 g-13 justify-content-center">
			<div class="col-md-10 col-11">
				<div class="card border-left-info shadow h-100 py-2">
					<div class="card-body">
						<div class="container">
							<h5>나의BORA</h5>
							<br>
							<!-- 목표설정 -->
							<script src="https://cdn.jsdelivr.net/npm/chart.js@3.7.1/dist/chart.min.js"></script>
							<script src="${pageContext.request.contextPath}/resources/js/goalChart.js"></script>
							<div>
								<canvas id="myChart" width="300" height="300"></canvas>
							</div>

						</div>
					</div>
				</div>
			</div>
		</div>
		
		<br>
	</div>

	<!-- 입력 구역 -->
	<div style="border: 3px solid yellow; width: 50%;">
	
		<h2>🐷🐷 목돈을 모아보아요💰💰</h2>
		잔액 : ${accountBalance.balance_amt }
		<h4>목표 금액 설정</h4>
		<div class="form-floating mb-3" style="text-align: center">
	<!-- 	<div class="form-floating mb-3"> -->
	<!--  지우지 마세요~~~ label for가 안 먹어가지고~~ 추후 해결해야 함!!!! 
			<input type="radio" name="bk_iow" value="3000" required="required" checked="checked" id="radio3"> <label for="radio3">3,000만원</label>
			<input type="radio" name="bk_iow" value="5000" required="required" id="radio5">  <label for="radio5">5,000만원 </label>
			<input type="radio" name="bk_iow" value="7000" required="required" id="radio7">  <label for="radio7">7,000만원 </label>
			<input type="radio" name="bk_iow" value="10000" required="required" id="radio10"> <label for="radio10">1억!! </label>
		 -->	
			<input type="radio" name="bk_iow" value="3000" required="required" checked="checked" id="radio3"> 3,000만원 
			<input type="radio" name="bk_iow" value="5000" required="required" id="radio5"> 5,000만원 
			<input type="radio" name="bk_iow" value="7000" required="required" id="radio7"> 7,000만원 
			<input type="radio" name="bk_iow" value="10000" required="required" id="radio10"> 1억
			<input type="radio" name="bk_iow" value="30000" required="required" id="radio10"> 3억!
			<input type="radio" name="bk_iow" value="50000" required="required" id="radio10"> 5억!!
			<input type="radio" name="bk_iow" value="100000" required="required" id="radio10"> 10억!!!
		</div>
		
		<hr> 
		
<!-- 		=============== 신 목표 기간 ==================== -->
		<h4>목표 기간 설정</h4>
		<div class="form-floating mb-3"  id='datetimepicker1'  
			  style="height: 14%; flex; justify-content: space-between; flex-flow: row nowrap;">
			<select class="form-select" style="height: 100%; width: 33%; float: left;" name="goal_year" required="required" id="goal_year">				
				<option value="">목표 기간</option>
<!-- 				<option value="0">2022</option> -->
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
<!-- 		=============== 신 목표 기간 끝 ==================== -->
		
		<h4>✨ 목표 기간까지.. <br> <b><span id="gapMoneySpan">___</span>만원</b>을 모아보아요 ✨</h4>
		<script src="${pageContext.request.contextPath}/resources/js/dDay.js"></script>
		<div id="remain-time"></div>
		
		<hr>
		
		<h4>목표 금액을 달성하기 위해서는?  <button type="button" id="moa_btn"> 🤔클릭 </button></h4>
		<b>하루</b>에 <b><span id="moa_1day">_____</span>만원</b>을 모아야 해요 <br>
		<b>한 달</b>에 <b><span id="moa_1month">_____</span>만원</b>을 모아야 해요 <br>
		<b>1년</b>에 <b><span id="moa_1year">_____</span>만원</b>을 모아야 해요 <br>
		할 수 있다!!!!  영차 영차🐱‍🏍💦 
		
		
		
	</div>
	</div>

</div> <!-- box -->
</div> <!-- container -->


<script>
$('#moa_btn').click(function(){
	alert('버턴 클릭됨');
 	alert('gap: ' + gap);
	alert('diffDate: ' + diffDate);
	$.ajax({
		url: '/ajax/moa',
		data: {'gapMoney': gap, 'gapDate': diffDate},
		dataType: 'JSON',
		success: function(rData){
// 			alert('갔다 옴');
			console.log(rData);
			
			let moaOneDay = parseInt(rData.moaOneDay);
			let moaOneMonth = parseInt(rData.moaOneMonth);
			let moaOneYear = parseInt(rData.moaOneYear);
			
			console.log(moaOneDay);
			console.log(moaOneMonth);
			console.log(moaOneYear);
			
			console.log(Math.round(moaOneDay * 1000) / 1000);
			console.log(Math.round(moaOneMonth * 1000) / 1000);
			console.log(Math.round(moaOneYear * 1000) / 1000);

			// 소수점 한자리까지만 나오게 하고 싶은데,,,,,
			$('#moa_1day').html(moaOneDay);
			$('#moa_1month').html(moaOneMonth);
			$('#moa_1year').html(moaOneYear);
		}
	});// ajax
});// click
	
</script>




<%@ include file="../include/footer.jsp"%>