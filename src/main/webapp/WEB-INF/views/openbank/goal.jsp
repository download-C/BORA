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
			<input type="radio" name="bk_iow" value="10000" required="required" id="radio10"> 1억!! 
		</div>
		
		<hr> 
		
		<h4>목표 기간 설정</h4>
		<div class="form-floating mb-3"  id='datetimepicker1'  
			  style="height: 14%; flex; justify-content: space-between; flex-flow: row nowrap;">
			<select class="form-select" style="height: 100%; width: 33%; float: left;" name="goal_year" required="required" id="goal_year">				
				<option value="">연도</option>
				<option value="2022">2022</option>
				<option value="2023">2023</option>
				<option value="2024">2024</option>
				<option value="2025">2025</option>
				<option value="2026">2026</option>
				<option value="2027">2027</option>
				<option value="2028">2028</option>
				<option value="2029">2029</option>
				<option value="2030">2030</option>
				<option value="2031">2031</option>
				<option value="2032">2032</option>
			</select>
			<select class="form-select" style="height: 100%; width: 33%; float: left;" name="goal_month" required="required" id="goal_month">	
				<option value="">월</option>
				<option value="1">1</option>
				<option value="2">2</option>
				<option value="3">3</option>
				<option value="4">4</option>
				<option value="5">5</option>
				<option value="6">6</option>
				<option value="7">7</option>
				<option value="8">8</option>
				<option value="9">9</option>
				<option value="10">10</option>
				<option value="11">11</option>
				<option value="12">12</option>
			</select> 
			<select class="form-select" style="height: 100%; width: 33%; float: left;" name="goal_day" required="required" id="goal_day">
				<option value="">일</option>
				<option value="1">1</option>
				<option value="2">2</option>
				<option value="3">3</option>
				<option value="4">4</option>
				<option value="5">5</option>
				<option value="6">6</option>
				<option value="7">7</option>
				<option value="8">8</option>
				<option value="9">9</option>
				<option value="10">10</option>
				<option value="11">11</option>
				<option value="12">12</option>
				<option value="13">13</option>
				<option value="14">14</option>
				<option value="15">15</option>
				<option value="16">16</option>
				<option value="17">17</option>
				<option value="18">18</option>
				<option value="19">19</option>
				<option value="20">20</option>
				<option value="21">21</option>
				<option value="22">22</option>
				<option value="23">23</option>
				<option value="24">24</option>
				<option value="25">25</option>
				<option value="26">26</option>
				<option value="27">27</option>
				<option value="28">28</option>
				<option value="29">29</option>
				<option value="30">30</option>
				<option value="31">31</option>
			</select>
		</div>

		<hr>
		
		<h4>✨ 목표 기간까지.. <b><span id="gapMoneySpan">___</span>만원</b>을 모아보아요 ✨</h4>
		<script src="${pageContext.request.contextPath}/resources/js/dDay.js"></script>
		<div id="remain-time"></div>
		
		<hr>
		
		<h4>목표 금액을 달성하기 위해서는?  <button type="button" id="moa_btn"> 🤔클릭 </button></h4>
		<b>하루</b>에 <span id="moa_1day">_____</span> 만원을 모아야 해요 <br>
		<b>한 달</b>에 <span id="moa_1month">_____</span> 만원을 모아야 해요 <br>
		<b>1년</b>에 <span id="moa_1year">_____</span> 만원을 모아야 해요 <br>
		
		할 수 있다!!!!  영차 영차🐱‍🏍💦 
		
		
		
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
			alert('갔다 옴');
			console.log(rData);
			console.log(rData.moaOneDay);
			console.log(rData.moaOneMonth);
			console.log(rData.moaOneYear);
			
// 			let moaOneDay = rData.moaOneDay;
// 			let moaOneMonth = rData.moaOneMonth;
// 			let moaOneYear = rData.moaOneYear;
			
			$('#moa_1day').html(rData.moaOneDay);
			$('#moa_1month').html(rData.moaOneMonth);
			$('#moa_1year').html(rData.moaOneYear);
		}
		
	});// ajax
	
});// click
	
	
</script>




<%@ include file="../include/footer.jsp"%>