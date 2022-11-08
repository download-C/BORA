<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ include file="../include/header.jsp"%>
<!-- ${pageContext.request.contextPath} -->
<script src="https://code.jquery.com/jquery-3.6.0.js"></script>
<script src="https://cdn.jsdelivr.net/npm/sweetalert2@9"></script>
<script src="https://cdn.jsdelivr.net/npm/promise-polyfill@7.1.0/dist/promise.min.js"></script>
<%
	if (loginID == null) {
%>

<!-- 세션값 만료 알림 -->
<script>
//warning 버튼
function warning() {
    Swal.fire(
        '세션값이 만료되었습니다.',
        '로그인 페이지로 이동합니다.',
        'warning' /*디자인 타입*/
    )
}//warning 버튼
	location.href = "/main/login";
</script>

<%
	}
%>

<!-- 항목이 수입일 경우 자산 바꾸기 -->
<script>
$(document).ready(function(){
	var radio = document.getElementsByName('bk_iow');
	var bk_group = document.getElementsByName('bk_group');
	
	$(radio).click(function(){
		if(this.value=="수입"){
			$("#bk_group").html(
				'<option value="">자산 선택</option>'+
				'<option value="현금">현금</option>'+
				'<option value="은행">은행</option>'+
				'<option value="기타">기타</option>'
			);
			$("#bk_category").html(
				'<option value="">카테고리</option>'+
				'<option value="월급">월급</option>'+
				'<option value="부수입">부수입</option>'+
				'<option value="용돈">용돈</option>'+
				'<option value="금융소득">금융소득</option>'+
				'<option value="기타">기타</option>'
			); 
		} // radio 수입 
		else if(this.value=="지출") {
			$("#bk_group").html(
			'<option value="">자산 선택</option>'+
			'<option value="체크카드">체크카드</option>'+
			'<option value="현금">현금</option>'+
			'<option value="은행">은행</option>'+
			'<option value="신용카드">신용카드</option>'+
			'<option value="기타">기타</option>'
			);
			$("#bk_category").html(
				'<option value="">카테고리</option>'+
				'<option value="식비">식비</option>'+
				'<option value="교통비">교통비</option>'+
				'<option value="편의점/마트">편의점/마트</option>'+
				'<option value="통신비">통신비</option>'+
				'<option value="여가비">여가비</option>'+
				'<option value="뷰티/쇼핑">뷰티/쇼핑</option>'+
				'<option value="저축">저축</option>'+
				'<option value="기타">기타</option>'
			);
		} // radio 지출
		else { 
			$("#bk_group").html(
				'<option value="">자산 선택</option>'+
				'<option value="">은행</option>'+
				'<option value="기타">기타</option>'+
				'<option value="추가">추가</option>'
			);
			$("#bk_category").html(
				'<option value="">카테고리</option>'
			);

		} // radio 이체
	}); // radio click
}); // document
</script>

<div class="container">
	<h1>🤑가계부 작성🤑</h1>
	<form action="/book/write" method="post"> 
	<input type="hidden" id="bk_budget" value="${bk_budget }">
	항목 :		수입<input type="radio" name="bk_iow" value="수입" required="required" > 
				지출<input type="radio" name="bk_iow" value="지출" required="required"> 
				이체<input type="radio" name="bk_iow" value="이체" required="required"> <br>
	자산 :      <select name="bk_group" id="bk_group" required="required">
					<option value="자산선택">자산 선택</option>
				</select> <br>
	일자 : 		<select name="bk_year" required="required">				
					<option value="">연도</option>
					<option value="2021">2021</option>
					<option value="2022">2022</option>
				</select> 년
				<select name="bk_month" required="required">	
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
				</select> 월
				<select name="bk_day" required="required">
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
				</select> 일 <br>
	카테고리 : 	<select name="bk_category" id="bk_category" required="required">
					<option value="">카테고리</option>
				</select> <br>
	금액 : <input type="number" name="bk_money" required="required"><br>
	메모 : <textarea rows="5" cols="20" name="bk_memo" required="required"></textarea> <br>
	<input type="submit" value="작성">
	
	</form>
</div>


<%@ include file="../include/footer.jsp"%>