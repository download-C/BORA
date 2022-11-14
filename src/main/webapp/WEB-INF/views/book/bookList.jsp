<%@page import="java.util.Calendar"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<%@ include file="../include/header.jsp"%>
<!-- ${pageContext.request.contextPath} -->
<script src="https://code.jquery.com/jquery-3.6.0.js"></script>


<style type="text/css">
@media(max-width: 576px) { 
	tbody {
		font-size: 0.7rem;
	}
	.m3 {
		font-size: 0.6rem;
	}
}

    @media (max-width: 756px) {
      .row {
        display: block;
      }
    }
    @media (min-width: 1400px) {
      .container {
        max-width: 1200px;
      }
    }

    table td,
    table th {
      text-overflow: ellipsis;
      white-space: nowrap;
      overflow: hidden;
    }

    thead th {
      color: #fff;
    }

    .card {
      border-radius: .5rem;
    }

    .table-scroll {
      border-radius: .5rem;
    }

    .table-scroll table thead th {
      font-size: 1rem;
    }

    thead {
      top: 0;
      position: sticky;
    }
</style>

<%
if(loginID==null) {%>
<!-- 세션값(로그인) 확인 -->
<script>
// 세션값 여부
$(document).ready(function(){
	info("로그인 필요!", "로그인 페이지로 이동합니다.");
	setTimeout('location.href="/main/login";', 1500);
	
});
<%} %>
</script>

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
	
$(document).ready(function() {
    let message = "${msg}";
    if (message != "") {
        alert(message);
    }
    
    let msg1 = "${msg1}";
    let msg2 = "${msg2}";
    if(msg1!="" && msg2!="") {
    	info(msg1, msg2);
    }
})
</script>

<!-- 컨트롤러에서 보낸 메시지 모달 띄우기 -->
<script>
$(document).ready(function(){	
	let msg = "${msg}";
	if(msg!="") {
		succsess(msg);
	}
 });
</script>

<script>
$(document).ready(function(){
	
	var percent =  "<c:out value='${percent}' />"; // 예산 중 지출이 차지하는 퍼센트
	alert('예산 대비 지출: '+percent+'%');
	var bk_budget = "<c:out value='${bk_budget}' />";  // 한 달 예산 (단위: 만원)
	var restedBudget1 = "<c:out value='${restedBudget1}' />";  // 남은 예산1 ( 만 자리까지)
	var restedBudget2 = "<c:out value='${restedBudget2}' />";  // 남은 예산2 (만 자리 이하 천백십일원)
	if (percent != "" &&& percent>=70.0	) {
		restedBudgetPercent = 100-percent;  // 남은 예산 퍼센트
		let msg = "설정하신 예산 '<b style='color: #81d742;'>"+bk_budget+"만원</b>'에서 <br>"
							+"'<b style='color:#f07160;'>"+restedBudget1+"만 "+restedBudget2+"원("
							+restedBudgetPercent+"%)</b>' 남았습니다!";
		warning(msg);
	}
});
</script>

<!-- alert 모달 -->
<script>

function warning(msg) {
    Swal.fire(
        '경고',
        msg,
        'warning' /*디자인 타입*/
    )
}//warning 버튼
</script>

<!-- 날짜 선택 시 해당 선택한 연 월의 가계부 출력 -->
<script>
function changeSelect(){
    var yearSelect = document.getElementById("year");
    var monthSelect = document.getElementById("month");
    var day = "<c:out value='${day}' />";
     
    // select element에서 선택된 option의 value가 저장된다.
    var yearValue = yearSelect.options[year.selectedIndex].value;
    var monthValue = monthSelect.options[month.selectedIndex].value;
 
    // select element에서 선택된 option의 text가 저장된다.
    var yearText = yearSelect.options[yearSelect.selectedIndex].text;
    var monthText = monthSelect.options[monthSelect.selectedIndex].text;
    
//     alert(yearValue+'년 '+monthValue+'월 선택');
	if(yearValue!="" && monthValue!=""){
    	location.href='/book/list?year='+yearValue+'&month='+monthValue+'&day='+day;
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
		var day = "<c:out value='${day}' />";
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
                year+'년 '+month+'월 예산이 '+data+'만원으로 설정되었습니다.',
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

<!-- 숫자 콤마 찍는 함수 -->
<script type="text/javascript">
function inputNumberFormat(obj) {
    obj.value = comma(uncomma(obj.value));
}

function comma(str) {
    str = String(str);
    return str.replace(/(\d)(?=(?:\d{3})+(?!\d))/g, '$1,');
}

function uncomma(str) {
    str = String(str);
    return str.replace(/[^\d]+/g, '');
}
</script>

<div class="container" >
<h3 style="text-align: center">${year }년 ${month }월 가계부</h3>
	<div class="left-box" style="float: left; border-color: red;">
		
	</div>

	
	<div class="right-box" >
		<div style="display: flex; justify-content: space-between; flex-flow: row nowrap; margin-bottom: 10px;">
			<div style="float: left;">
				이번 달 예산 : <input type="number" name="bk_budget" id="bk_budget" value="${bk_budget}"  onkeyup="javascript:inputNumberFormat(this)"
							 style="text-align: right; width:50px; ">만원	
				<button id="budgetBtn" class="btn m3" 
				style="background-color: #5107B0; width: 100px; margin:auto; padding: 0px; color:white" >
				<span class="btn-inner--text" style="color: white;">예산 입력</span>
				</button>
			</div>
		
		<!-- 가계부 연 월 선택 -->
		<div style="float: right; margin-bottom: 5px;"> 
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
			<input type="button" value="가계부 쓰기" class="btn m3" 
				onclick="location.href='/book/write?year=${year}&month=${month}&day=${day }';" 
				style="background-color: #5107B0; width: 100px; margin:auto; padding: 0px; color:white">
		</div>
	</div>
</div>
		<div class="listTable">
			<table border="1" style="width: 100%; text-align: center; ">
			<thead style="background-color: #5107B0; color: white; ">
				<tr>
					<td width="10%">일</td>
					<td width="10%">항목</td>
					<td width="10%">자산</td>
					<td width="20%">카테고리</td>
					<td width="15%">금액</td>
					<td width="20%">메모</td>
					<td width="10%">비고</td>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${detailList }" var="list">
				<tr style="border-bottom-color: gray;">
					<td>${list.bk_day }일</td>
					<td>${list.bk_iow }</td>
					<td>${list.bk_group }</td>
					<td >${list.bk_category }</td>
					<td><fmt:formatNumber value="${list.bk_money }" pattern="#,###" />원</td>
					<td>${list.bk_memo }</td>
					<td style="font-size: x-small">
						<button id="budgetBtn" class="btn m3"  onclick="location.href='/book/update?page=1&bk_num=${list.bk_num}&bk_detail_num=${list.bk_detail_num }';"
						style="background-color: #5107B0; width: 100px; margin:auto; padding: 0px; color:white; max-width:50px;" >
						<span class="btn-inner--text" style="color: white;">수정</span>
						</button>
						<button id="budgetBtn" class="btn m3"  onclick="location.href='/book/delete?page=1&bk_num=${list.bk_num}&bk_detail_num=${list.bk_detail_num }';"
						style="background-color: #5107B0; width: 100px; margin:auto; padding: 0px; color:white; max-width:50px;" >
						<span class="btn-inner--text" style="color: white;">삭제</span>
						</button>
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