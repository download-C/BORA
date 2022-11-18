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
</style>
<style>
#moa_btn{
     background-color: #5107B0;
/*       float: center; */
/* 	  margin-left: 50px; */
	  margin: auto auto 0px 10px ;
      padding: 10px 15px 10px 15px;
      border: 1px solid #fff;
      border-radius: 8px;
      color: white; 
      border-radius: 13px;
      font-size: 20px;
    }
</style>

  <!-- title -->
  <div class="section-title">
    <h2><b>목돈모으기</b></h2>
    <div style="padding-top: 35px;">
    <h3>💜 BORA 오픈뱅킹으로 조회한 내 자산으로 목돈 모으기 도전 💜</h3>
    </div>
  </div>
  <!-- End title -->


<div class="container">
    <div class="container">
      <div class="row row-cols-md-4 g-4 justify-content-center">
      
      	<!-- 목표 설정 구역 1 -->
			<div class="col-md-6 col-12">
				<div class="card border-left-info shadow h-100 py-2">
					<div class="card-body" style="padding: 0px 10px;">
						<div>
							<h3>목표 금액 설정</h3>
						</div>
						<div class="checks" style="text-align: center; margin-top: 18px;">
							<input id="ex_rd" name="bk_iow" type="radio" value="3000" required="required" checked="checked" id="radio3"> 
							<label for="ex_rd">3천만원</label> 
							<input id="ex_rd2" name="bk_iow" type="radio" value="5000" required="required" id="radio5">
							<label for="ex_rd2">5천만원</label> 
							<input id="ex_rd3" name="bk_iow" type="radio" value="7000" required="required" id="radio7">
							<label for="ex_rd3">7천만원</label> 
							<input id="ex_rd4" name="bk_iow" type="radio" value="10000" required="required" id="radio10">
							<label for="ex_rd4">1억</label> 
							<input id="ex_rd5" name="bk_iow" type="radio" value="30000" required="required" id="radio30"> 
							<label for="ex_rd5">3억</label> 
							<input id="ex_rd6" name="bk_iow" type="radio" value="50000" required="required" id="radio50"> 
							<label for="ex_rd6">5억</label> 
							<input id="ex_rd7" name="bk_iow" type="radio" value="100000" required="required" id="radio100"> 
							<label for="ex_rd7">10억</label>
							<div class="form-floating mb-3" style="text-align: center">
							</div>
						</div>
					</div>
				</div>
			</div>
				<!-- 	<div class="form-floating mb-3"> -->
				<!--  지우지 마세요~~~ label for가 안 먹어가지고~~ 추후 해결해야 함!!!! 
			<input type="radio" name="bk_iow" value="3000" required="required" checked="checked" id="radio3"> <label for="radio3">3,000만원</label>
			<input type="radio" name="bk_iow" value="5000" required="required" id="radio5">  <label for="radio5">5,000만원 </label>
			<input type="radio" name="bk_iow" value="7000" required="required" id="radio7">  <label for="radio7">7,000만원 </label>
			<input type="radio" name="bk_iow" value="10000" required="required" id="radio10"> <label for="radio10">1억!! </label>
		 -->


				<!-- 		=============== 신 목표 기간 ==================== -->

				<div class="col-md-6 col-12">
					<div class="card border-left-info shadow h-100 py-2">
						<div class="card-body">
							<div>
								<h3>목표 기간 설정</h3>
							</div>
							<div class="input-group mb-3" id='datetimepicker1'>
								<label class="input-group-text" for="goal_year">기간 선택</label> 
								<select class="form-select" name="goal_year" id="goal_year" required>
									<option selected hidden>목표 기간을 설정해주세요.</option>
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
			</div>
    <br>
<!-- 		=============== 신 목표 기간 끝 ==================== -->



	<!-- bar 차트 구역 2 -->
    <div class="container">
      <div class="row row-cols-md-4 g-4 justify-content-center">
        <!-- chart -->
        <div class="col-md-6 col-11">
          <div class="card border-left-info shadow h-100 py-2">
            <div class="card-body">
              <!-- title -->
              <div>
                <h3>나의 <span style="background: linear-gradient(to top, #c8a7fa 50%, transparent 50%)";>자산 보기</span></h3>
              </div><br>
              <!-- title -->
              <div class="chart-pie pt-4 pb-2">
				<script src="https://cdn.jsdelivr.net/npm/chart.js@3.7.1/dist/chart.min.js"></script>
				<script src="${pageContext.request.contextPath}/resources/js/goalChart.js"></script>
				<div>
<%-- 					<canvas id="myChart" width=200%" style="max-height: 300px; max-width: 200px; margin: auto;"></canvas> --%>
					<canvas id="myChart" style="width=300px; height=300px; "></canvas>
              </div>
				</div>
				<div><br>
				<h3>내 목표 값 : </h3>
				<h3>현재 내 자산 : </h3>
				</div>
              <!-- chart -->
            </div>
          </div>
        </div>
        <!-- End chart -->


	<!-- 목표까지 안내 구역 3 -->
        <div class="col-md-6 col-11">
          <div class="card border-left-info shadow h-100 py-2">
            <div class="card-body">
              <div style="text-align: center;">
                <h4>목표 기간까지&nbsp;<span id="gapMoneySpan">____</span><b>만원</b> 모으기</h4>
                	<script src="${pageContext.request.contextPath}/resources/js/dDay.js"></script>
					<div id="remain-time" style="color: red; font-size: 120%;"></div>
              </div><hr>
              <div class="container" >
                <div style="width: 100%; margin: 20px auto; text-align: center;">
                  <h4 style="text-align: center;">목표 금액 달성을 위해</h4>
                   <button type="button" id="moa_btn" style="display: inline-block;">얼마나 모아야 하지? 클릭🤔 </button>
                </div>
                <div style="text-align: center; padding: 10px; margin: 0 auto;">
                  <h5>&nbsp;하루에 <b><span id="moa_1day">_____ </span></b>원을 모아야 해요.</h5>
                  <h5>&nbsp;한 달에 <b><span id="moa_1month">_____ </span></b>원을 모아야 해요.</h5>
                  <h5>&nbsp;1년에 <b><span id="moa_1year">_____ </span></b>원을 모아야 해요.</h5>
                  <div style="margin: 20px;">
                  <h6><b style="color:#5107B0;">BORA</b>와 함께 영차영차🏋️‍♂️</h6>
                  </div>
			</div>
			</div>
		</div>
	</div>
	</div>
</div>
<br><br>


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