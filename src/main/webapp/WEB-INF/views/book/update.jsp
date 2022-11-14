<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ include file="../include/header.jsp"%>
<!-- ${pageContext.request.contextPath} -->
<script src="https://code.jquery.com/jquery-3.6.0.js"></script>
<script src="https://cdn.jsdelivr.net/npm/sweetalert2@9"></script>
<script src="https://cdn.jsdelivr.net/npm/promise-polyfill@7.1.0/dist/promise.min.js"></script>

<!-- Template Main CSS File -->
<link href="${pageContext.request.contextPath}/resources/css/writeForm.css" rel="stylesheet">
<link href="${pageContext.request.contextPath}/resources/css/style.css" rel="stylesheet">

<%
if(loginID==null) {%>
<!-- 세션값(로그인) 확인 -->
<script>
// 세션값 여부
	alert("세션값이 만료되어 로그인 페이지로 이동합니다.");
	location.href="/main/login";
	
	$(document).ready(function() {
	    let message = "${msg}";
	    if (message != "") {
	        alert(message);
	    }
	})
</script>
<%} %>
<!-- 비밀번호 회원정보 수정 시 alert -->
<script>
$(document).ready(function() {
    let message = "${msg}";
    if (message != "") {
        alert(message);
    }
});
</script>
			
<!-- DB값으로 미리 선택해놓기 -->
<script>
$(document).ready(function(){
	// 항목
	$('input:radio[name=bk_iow]:input[value="${detail.bk_iow}"]').attr("checked", true);
	// 자산
	$("#group").val("${detail.bk_group}").attr("selected","selected");
	// 날짜
	$("#year").val("${detail.book.bk_year}").attr("selected","selected");
	$("#month").val("${detail.book.bk_month}").attr("selected","selected");
	$("#day").val("${detail.bk_day}").attr("selected","selected");
});//document
</script>

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
<div class="container-contact100">
  <div class="wrap-contact100">
		<form action="/book/update?page=${page }" method="post" class="contact100-form validate-form">
	 		<span class="contact100-form-title">
	    	<b>가계부 수정</b>
	    </span>
			<input type="hidden" name="bk_num" value="${detail.bk_num }">
			<input type="hidden" name="bk_detail_num" value="${detail.bk_detail_num }">
			<input type="hidden" name="id" value=${sessionScope.loginID }>
			
	    <div class="radioCustom" style="display: flex; align-items: center; justify-content: center;">
				<input type="radio" id="radio1" name="bk_iow" class="iow" required="required"> <label for="radio1">수입</label>
				<input type="radio" id="radio2" name="bk_iow" class="iow" required="required"> <label for="radio2">지출</label>
				<input type="radio" id="radio3" name="bk_iow" class="iow" required="required"><label for="radio3">이체</label>
			</div>
			<div class="form-floating mb-3" style="text-align: center">
				<select id="group" name="bk_group" class="form-select" style="text-align: center" required>
					<option value="">자산 선택</option>
					<option value="체크카드">체크카드</option>
					<option value="현금">현금</option>
					<option value="은행">은행</option>
					<option value="신용카드">신용카드</option>
					<option value="기타">기타</option>
				</select>
			</div>
		<div class="form-floating mb-3"  id='datetimepicker1'  
		  style="display: flex; justify-content: space-between; flex-flow: row nowrap;">
			<select class="form-select" id="year" style="width: 33%; float: left;" name="bk_year" required>				
				<option value="">연도</option>
				<option value="2020">2020년</option>
				<option value="2021">2021년</option>
				<option value="2022">2022년</option>
				<option value="2023">2023년</option>
			</select> 
			<select class="form-select" name="bk_month" id="month" style="width: 33%; float: left;" required>	
				<option value="">월</option>
				<option value="1">1월</option>
				<option value="2">2월</option>
				<option value="3">3월</option>
				<option value="4">4월</option>
				<option value="5">5월</option>
				<option value="6">6월</option>
				<option value="7">7월</option>
				<option value="8">8월</option>
				<option value="9">9월</option>
				<option value="10">10월</option>
				<option value="11">11월</option>
				<option value="12">12월</option>
			</select> 
			<select class="form-select" name="bk_day" id="day" style="width: 33%; float: left;" required="required">
				<option value="">일</option>
				<option value="1">1일</option>
				<option value="2">2일</option>
				<option value="3">3일</option>
				<option value="4">4일</option>
				<option value="5">5일</option>
				<option value="6">6일</option>
				<option value="7">7일</option>
				<option value="8">8일</option>
				<option value="9">9일</option>
				<option value="10">10일</option>
				<option value="11">11일</option>
				<option value="12">12일</option>
				<option value="13">13일</option>
				<option value="14">14일</option>
				<option value="15">15일</option>
				<option value="16">16일</option>
				<option value="17">17일</option>
				<option value="18">18일</option>
				<option value="19">19일</option>
				<option value="20">20일</option>
				<option value="21">21일</option>
				<option value="22">22일</option>
				<option value="23">23일</option>
				<option value="24">24일</option>
				<option value="25">25일</option>
				<option value="26">26일</option>
				<option value="27">27일</option>
				<option value="28">28일</option>
				<option value="29">29일</option>
				<option value="30">30일</option>
				<option value="31">31일</option>
			</select> 
		</div>
		<div class="form-floating mb-3">
			<select name="bk_category" id="bk_category" class="form-select" required>
				<option value="">카테고리</option>
			</select> 
		</div>
		<div class="form-floating mb-3">
			<input type="number" id="money" value="${detail.bk_money }" class="form-control" name="bk_money" required>
			<label for="money">금액</label>
		</div>
		<div class="form-floating mb-3">
      <input type="text" id="memo" name="bk_memo" value="${detail.bk_memo }" class="form-control" required>
      <label for="memo">메모</label>
    </div>
    <div style="text-align: center">
			<input type="submit" value="수정"  class="btn m-1" style="background-color: #5107B0; width: 100px; margin:auto; padding: 0px; color:white">
		</div>
			</form>
	</div>



</div>




<!-- 태그 적는 곳 -->


<%@ include file="../include/footer.jsp"%>