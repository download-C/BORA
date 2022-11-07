<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ include file="../include/header.jsp"%>
<!-- ${pageContext.request.contextPath} -->
<script src="https://code.jquery.com/jquery-3.6.0.js"></script>
<script src="https://cdn.jsdelivr.net/npm/sweetalert2@9"></script>
<script src="https://cdn.jsdelivr.net/npm/promise-polyfill@7.1.0/dist/promise.min.js"></script>

<!-- 예산 설정 후 결과 출력 -->
<script type="text/javascript">
$(document).ready(function(){
	let msg = ${msg};
	i(msg!="") {
		if(msg=="ok"){
			Swal.fire(
	                message,
	                '예산 설정 완료!',
	                'success' /*디자인 타입*/
	            )
		}else {
			Swal.fire(
	                '경고',
	                '예산 수정 실패',
	                'warning' /*디자인 타입*/
	            )
		}
	}
})
</script>

<!-- 텍스트 입력 모달 -->
<script>
   //텍스트를 입력하고 확인하는 버튼2 -> 여러 텍스트 입력, JSON으로 출력
   function textbtn2() {
   	(async () => {
   		const { value: formValues } = await Swal.fire({
   		  title: '가계부 작성하기',
   		  html:
   		    '자산: 수입<input type="radio" name="bk_iow" id="swal-radio1" class="swal2-radio"> &emsp;' +
   		    '지출<input type="radio" name="bk_iow" id="swal-radio2" class="swal2-radio"> &emsp;' +
   		    '이체<input type="radio" name="bk_iow" id="swal-radio3" class="swal2-radio"> <br>' +
   			'<select name="bk_group"  required="required" class="swal2-select">'+
				'<option value="">자산 선택</option>'+
				'<option value="체크카드">체크카드</option>'+
				'<option value="현금">현금</option>'+
				'<option value="은행">은행</option>'+
				'<option value="신용카드">신용카드</option>'+
				'<option value="기타">기타</option>'+
			'</select><br>'+
			'<select name="bk_year" required="required" class="">'+		
				'<option value="">연도</option>'+
				'<option value="2021">2021</option>'+
				'<option value="2022" selected="selected">2022</option>'+
				'<option value="2023">2023</option>'+
			'</select> 년'+
			'<select name="bk_month" required="required" class="">'+	
				'<option value="">월</option>'+
				'<option value="1">1</option>'+
				'<option value="2">2</option>'+
				'<option value="3">3</option>'+
				'<option value="4">4</option>'+
				'<option value="5">5</option>'+
				'<option value="6">6</option>'+
				'<option value="7">7</option>'+
				'<option value="8">8</option>'+
				'<option value="9">9</option>'+
				'<option value="10">10</option>'+
				'<option value="11">11</option>'+
				'<option value="12">12</option>'+
			'</select> 월'+
			'<select name="bk_day" required="required" class="">'+
				'<option value="">일</option>'+
				'<option value="1">1</option>'+
				'<option value="2">2</option>'+
				'<option value="3">3</option>'+
				'<option value="4">4</option>'+
				'<option value="5">5</option>'+
				'<option value="6">6</option>'+
				'<option value="7">7</option>'+
				'<option value="8">8</option>'+
				'<option value="9">9</option>'+
				'<option value="10">10</option>'+
				'<option value="11">11</option>'+
				'<option value="12">12</option>'+
				'<option value="13">13</option>'+
				'<option value="14">14</option>'+
				'<option value="15">15</option>'+
				'<option value="16">16</option>'+
				'<option value="17">17</option>'+
				'<option value="18">18</option>'+
				'<option value="19">19</option>'+
				'<option value="20">20</option>'+
				'<option value="21">21</option>'+
				'<option value="22">22</option>'+
				'<option value="23">23</option>'+
				'<option value="24">24</option>'+
				'<option value="25">25</option>'+
				'<option value="26">26</option>'+
				'<option value="27">27</option>'+
				'<option value="28">28</option>'+
				'<option value="29">29</option>'+
				'<option value="30">30</option>'+
				'<option value="31">31</option>'+
			'</select> 일 <br>'+
			'<select name="bk_category" id="category" required="required" class="swal2-select">'+
				'<option value="">카테고리</option>'+
				'<option value="식비">식비</option>'+
				'<option value="교통비">교통비</option>'+
				'<option value="편의점/마트">편의점/마트</option>'+
				'<option value="통신비">통신비</option>'+
				'<option value="여가비">여가비</option>'+
				'<option value="뷰티/쇼핑">뷰티/쇼핑</option>'+
				'<option value="저축">저축</option>'+
				'<option value="기타">기타</option>'+
			'</select> <br>'+
			'<input type="number" id="swal-input3" name="bk_money" required="required" class="swal2-input" placeholder="금액">'+
			'<textarea rows="5" cols="20" name="bk_memo" required="required" class="swal2-textarea" placeholder="메모"></textarea>',
   		  focusConfirm: false,
   		  preConfirm: () => {
   		    return [
   		      document.getElementByName('bk_iow').value,
   		      document.getElementByName('bk_group').value,
   		      document.getElementByName('bk_year').value,
   		      document.getElementByName('bk_month').value,
   		      document.getElementByName('bk_day').value,
   		      document.getElementByName('bk_category').value,
   		      document.getElementByName('bk_money').value,
   		      document.getElementByName('bk_memo').value
   		    ]
   		  }
   		})

   		if (formValues) {
   		  Swal.fire(JSON.stringify(formValues))
   		  location.href="/book/write";
   		}

   		})()
   		
   }//텍스트를 입력하고 확인하는 버튼
</script>

<!-- document.ready -->
<script>
$(document).ready(function(){
	$("#bookBtn").click(function(){
		textbtn2();
	});
})
</script>

<!-- 예산 입력 -->
<script>
// $(document).ready(function(){
// 	var bk_budget = document.getElementsByName('bk_budget').value;
// 	$("#budgetBtn").onclick(function(){
// 		$.ajax({
// 			url:"/book/writeBudget?bk_num=<c:out value='${bk_num}'/>",
// 			data: {"bk_year":"<c:out value=${year}/>",
// 				  {"bk_month":"<c:out value=${month}/>",
// 				   "bk_budget":bk_budget},
// 			success: {
// 				alert("성공");
// 			},
// 			error: {
// 				alert("실패");
// 			}
// 		});//ajax
// 	});// #budgetBtn
// });//document
</script>

<div class="container">
	<div class="box" style="display: flex; justify-content: space-between; flex-flow: row nowrap;">
	<div style="border: 3px solid red; width: 35%;">
	<h1>그래프 자리???</h1> 
	 <br><br><br><br><br><br><br><br><br><br><br><br>
	</div> 
			
	<div class="bookList" style="border: 3px solid yellow; width: 60%;"> <br>
	<input type="button" id="bookBtn" value="모달 가계부 쓰기(아직 잘 안 됨)"  class="btn btn-primary m-2">
	<input type="button" id="bookBtn" value="가계부 쓰기 페이지로 이동" 
	class="btn btn-primary m-2"
	onclick="location.href='/book/write';" >
		<div class="bookListTitle" >
			<h3>${year }월 ${month }월 가계부</h3>
			
		</div>
		<div style="display: flex; justify-content: space-between;  flex-flow: row nowrap;">
			<div class="budget_div">
			<form id="budget">
				<input type="number" value="${bk_budget}" placeholder="${year }년 ${month }월 소비 예산">
				<button id="budgetBtn">예산 입력</button>
			</form>
			</div>
			<button class="btn btn-primary m-2"
			onclick="location.href='/book/list?page=1';">더보기</button>
		</div>
		<table border="1" style="width: 100%; text-align: center; font-size: small;">
		<thead style="background-color: yellow; ">
			<tr>
				<td width="25%">날짜</td>
				<td width="15%">항목</td>
				<td width="15%">자산</td>
				<td width="15%">카테고리</td>
				<td width="10%">금액</td>
				<td width="20%">메모</td>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${bookList }" var="list" end="5">
			<tr>
				<td>${list.bk_year }년 ${list.bk_month }월 ${list.detail.bk_day }일</td>
				<td>${list.detail.bk_iow }</td>
				<td>${list.detail.bk_group }</td>
				<td>${list.detail.bk_category }</td>
				<td>${list.detail.bk_money }원</td>
				<td>${list.detail.bk_memo }</td>
			</tr>
			</c:forEach>
		</tbody>
		</table>
		</div>
	</div> <!-- box -->
</div> <!-- container -->

<%@ include file="../include/footer.jsp"%>