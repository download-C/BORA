<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ include file="../include/header.jsp"%>
<!-- ${pageContext.request.contextPath} -->
<script src="https://code.jquery.com/jquery-3.6.0.js"></script>
<h1>목돈 모으기 </h1>

<script>
//keyName 이름의 String 을 가져와 JSON 형태로 다시 Parse 진행
//JSON.parse(sessionStorage.getItem(keyName));

console.log(JSON.parse(sessionStorage.getItem('balObj'))); // 이러면 Object 형태로 잘 나옴
console.log("balObj: " + JSON.parse(sessionStorage.getItem('balObj'))); // 이러면 Object 형태로 잘 나옴

let balObj = JSON.parse(sessionStorage.getItem('balObj'));


console.log("1 bal: "+balObj[1].bal); // 못 읽네 ㄱ-
console.log("0 bal: "+balObj[0].bal); 

</script>

<script>
$(document).ready(function(){
// 	alert('잘~~ 실행됩니다');

}); // jquery ready
</script>



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
	
	<h1>목돈 모으기</h1>
	
	<h2>목표금액 설정</h2><br>
	<div class="form-floating mb-3" style="text-align: center">
<!-- 	<div class="form-floating mb-3"> -->
		<input type="radio" name="bk_iow" value="3000" required="required" checked="checked"> 3,000만원
		<input type="radio" name="bk_iow" value="5000" required="required" > 5,000만원
		<input type="radio" name="bk_iow" value="7000" required="required" > 7,000만원
		<input type="radio" name="bk_iow" value="10000" required="required" > 1억!!
	</div>
	
	<div class="form-floating mb-3"  id='datetimepicker1'  
		  style="height: 14%; flex; justify-content: space-between; flex-flow: row nowrap;">
		<select class="form-select" style="height: 100%; width: 33%; float: left;" name="bk_year" required="required">				
			<option value="">연도</option>
			<option value="2022">2022</option>
		</select>
		<select class="form-select" style="height: 100%; width: 33%; float: left;" name="bk_month" required="required">	
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
		<select class="form-select" style="height: 100%; width: 33%; float: left;" name="bk_day" required="required">
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
	
	
	</div>
	


</div>


<%@ include file="../include/footer.jsp"%>