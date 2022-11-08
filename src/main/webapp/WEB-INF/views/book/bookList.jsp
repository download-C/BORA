<%@page import="java.util.Calendar"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ include file="../include/header.jsp"%>
<!-- ${pageContext.request.contextPath} -->
<script src="https://code.jquery.com/jquery-3.6.0.js"></script>


<!-- alert 모달 필수  --> 
<script src="https://cdn.jsdelivr.net/npm/sweetalert2@9"></script>
<script src="https://cdn.jsdelivr.net/npm/promise-polyfill@7.1.0/dist/promise.min.js"></script>


<%
if(loginID==null) {%>
<!-- 세션값(로그인) 확인 -->
<script>
// 세션값 여부
	alert("로그인 후 이용 가능합니다. 로그인 페이지로 이동합니다.");
	location.href="/main/login";
	
	$(document).ready(function() {
	    let message = "${msg}";
	    if (message != "") {
	        alert(message);
	    }
	})
</script>
<%} %>





<!-- login 성공 메세지 불러오기 -->
<script>
$(document).ready(function(){	
	let message = "${msg}";
	if(message!="") {
		login(message);
	}
 });
</script>

<!-- login 성공 alert 모달 -->
<script>
function login(message) {
  	Swal.fire({
	  title: message,
	  text: '',
	  imageUrl: '${pageContext.request.contextPath}/resources/img/logo.png',
	  imageWidth: 200,
	  imageHeight: 50,
	  imageAlt: 'Custom image',
   	})
}
</script>

<!-- 날짜 선택 시 해당 선택한 연 월의 가계부 출력 -->
<script>
function changeSelect(){
    var yearSelect = document.getElementById("year");
    var monthSelect = document.getElementById("month");
     
    // select element에서 선택된 option의 value가 저장된다.
    var yearValue = yearSelect.options[year.selectedIndex].value;
    var monthValue = monthSelect.options[month.selectedIndex].value;
 
    // select element에서 선택된 option의 text가 저장된다.
    var yearText = yearSelect.options[yearSelect.selectedIndex].text;
    var monthText = monthSelect.options[monthSelect.selectedIndex].text;
    
//     alert(yearValue+'년 '+monthValue+'월 선택');
	if(yearValue!="" && monthValue!=""){
    	location.href='/book/list?year='+yearValue+'&month='+monthValue;
	}
}

</script>

<script>
$(document).ready(function() {
	// 예산 바꾸기
	$("#budgetBtn").click(function(){
		let msg = "${msg}";
		var budget = document.getElementById("bk_budget").value;		
		var year = "<c:out value='${year}' />";
		var month = "<c:out value='${month}' />";
		$.ajax({
			method: "post",
			url: "/ajax/writeBudget",
			dataType: "text",
			data: {"bk_budget":budget, 
				   "year": year,
				   "month": month,
				   "loginID":"<c:out value='<%=loginID%>' />"
		    },
	   		success: function(data){
// 	   			alert("성공");
				budget = data;
				Swal.fire(
					'예산 설정 완료!',
                year+'년 '+month+'월 예산이 '+data+'원으로 설정되었습니다.',
                'success' /*디자인 타입*/
         	   )
	   			
	   		},
	   		error: function(){
	   			alert("실패");
	   		}
		}); //ajax
	});//budgetBtn click

    // DB에서 가져온 값으로 선택하기
 // 항목

	$("#year").val("${year }").attr("selected","selected");
	$("#month").val("${month}").attr("selected","selected");
});
</script>
<!-- 태그 적는 곳 -->

<div class="container">
<br>
<h3 style="text-align: center">${year }년 ${month }월 가계부</h3>
	<div>
		이번 달 예산 <input type="number" name="bk_budget" id="bk_budget" value="${bk_budget}" >원
				<button id="budgetBtn">예산 입력</button>
	</div>
	<div style="float: right;">
		<select name="year" id="year" onchange="changeSelect()">
			<option value="">연도</option>
			<option value="2021">2021년</option>
			<option value="2022">2022년</option>
			<option value="2023">2023년</option>
		</select>
		<select name="month" id="month" onchange="changeSelect()">
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
		<input type="button" value="가계부 쓰기" class="btn btn-primary m-1" onclick="location.href='/book/write';" >
	</div>
	<div class="listTable">
		<table border="1" style="width: 100%; text-align: center">
		<thead style="background-color: #5107B0; color: white;">
			<tr>
				<td width="7%">연</td>
				<td width="5%">월</td>
				<td width="5%">일</td>
				<td width="10%">항목</td>
				<td width="10%">자산</td>
				<td width="10%">카테고리</td>
				<td width="15%">금액</td>
				<td width="28%">메모</td>
				<td width="10%">비고</td>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${detailList }" var="list">
			<tr>
				<td>${list.book.bk_year }년</td> 
				<td>${list.book.bk_month }월</td>
				<td>${list.bk_day }일</td>
				<td>${list.bk_iow }</td>
				<td>${list.bk_group }</td>
				<td>${list.bk_category }</td>
				<td>${list.bk_money }원</td>
				<td>${list.bk_memo }</td>
				<td style="font-size: x-small">
					<button onclick="location.href='/book/update?page=1&bk_num=${list.bk_num}&bk_detail_num=${list.bk_detail_num }';">수정</button>
					<button onclick="location.href='/book/delete?page=1&bk_num=${list.bk_num}&bk_detail_num=${list.bk_detail_num }';">삭제</button>
				</td>
			</tr>
			</c:forEach>
			
		</tbody>
		</table>
	</div>
	<div style="margin: auto; text-align: center;">
		<ul type="none" id="pageUl">
			<c:if test="${pm.prev }"> 
				<li><a href="/book/list?page=${pm.pageStart}&year=${year}&month=${month}">&laquo;</a></li>
			</c:if>
			<c:forEach var="index" begin="${pm.pageStart+1 }" end="${pm.endPage }"> 
				<li ${pm.vo.page == index? 'class=active' : '' }  style="float: left;">
					<a href="/book/list?page=${index+1 }&year=${year}&month=${month}"> &nbsp;&nbsp; ${index} &nbsp;&nbsp; </a>
				</li>
			</c:forEach>
			<c:if test="${pm.next }">
				<li><a href="/book/list?page=${pm.endPage + 1 }&year=${year}&month=${month}">&raquo;</a></li>
			</c:if>
		</ul>
	</div>
</div>



<!-- 태그 적는 곳 -->


<%@ include file="../include/footer.jsp"%>