<%@page import="java.util.Calendar"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<%@ include file="../include/header.jsp"%>
<!-- ${pageContext.request.contextPath} -->
<script src="https://code.jquery.com/jquery-3.6.0.js"></script>

<!-- chart.js 라이브러리 CDN 로드 -->    
<!-- <script src="https://cdnjs.cloudflare.com/ajax/libs/Chart.js/3.5.0/chart.min.js"></script> -->
<style>
a {
  color: black;
  text-decoration: none;
}

a:hover {
  color: #5107B0;
  text-decoration: none;
}

.pagination {
    --bs-pagination-active-bg: #e3cffc  !important; 
    --bs-pagination-active-border-color: #e3cffc  !important;
}

</style>
<!-- title -->
<div class="section-title">
  <h2><b>가계부</b></h2>
</div>
<!-- End title -->

<style type="text/css">
   html, body{
       width : 100%;
       height : 100%;
       margin : 0;
       padding : 0;
       border : none;  
       /* 배경 색상 지정 */
       /*background-color: #171e38;*/            
       overflow : auto;                    
   }    
</style>    

<style type="text/css">
 #box1, #box2 {
  	max-width: 49%; 
  }
@media(max-width: 576px) { 
	tbody {
	}
	.m3 {
		font-size: 0.6rem;
	}
}

    @media (max-width: 756px) {
      .row {
        display: block;
      }
      #box1, #box2 {
  			max-width: 90%; 
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
    Swal.fire({
     title: msg1, 
     text: msg2,
     confirmButtonColor: '#7A1CF6',
     icon: 'info' /*디자인 타입*/
    }) 
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

function success(msg3, msg4) {
	Swal.fire({
	     title: msg1, 
	     text: msg2,
	     confirmButtonColor: '#7A1CF6',
	     icon: 'success' /*디자인 타입*/
	    }) 
}//success 버튼
	
$(document).ready(function() {
// 	alert
    
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
	let msg3 = "${msg3}";
	let msg4 = "${msg4}";
	if(msg3!="" && msg4!="") {
		success(msg3, msg4);
	}
 });
</script>

<script>
$(document).ready(function(){
	
	var percent =  "<c:out value='${percent}' />"; // 예산 중 지출이 차지하는 퍼센트
// 	alert('예산 대비 지출: '+percent+'%');
	var bk_budget = "<c:out value='${bk_budget}' />";  // 한 달 예산 (단위: 만원)
	var restedBudget1 = "<c:out value='${restedBudget1}' />";  // 남은 예산1 ( 만 자리까지)
	var restedBudget2 = "<c:out value='${restedBudget2}' />";  // 남은 예산2 (만 자리 이하 천백십일원)
	if (percent>=70.0	) {
		restedBudgetPercent = 100-percent;  // 남은 예산 퍼센트
		let msg = "<sapn style='font-size: 80%'>설정하신 예산 <b style='color: #81d742;'>"+bk_budget+"만원</b>에서 <br>"
		+"<b style='color:#f07160;'>"+restedBudget1+"만 "+restedBudget2+"원("
		+restedBudgetPercent+"%)</b> 남았습니다!</span>";
		warning(msg);
	}
});
</script>

<!-- alert 모달 -->
<script>	

function warning(msg) {
    Swal.fire({
        title: msg,
        text: '',
        icon: 'warning', /*디자인 타입*/
        confirmButtonColor: '#7A1CF6'
    });
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



function changeSelectCtgr(ctgr){
    var yearSelect = document.getElementById("year");
    var monthSelect = document.getElementById("month");
    var day = "<c:out value='${day}' />";
    
//     alert('function에 ctgr: ' + ctgr);
     
    // select element에서 선택된 option의 value가 저장된다.
    var yearValue = yearSelect.options[year.selectedIndex].value;
    var monthValue = monthSelect.options[month.selectedIndex].value;
//     var ctgrValue = ctgrSelect.options[ctgr.selectedIndex].value;
//     alert("ctgrValue: " + ctgrValue);
 
    // select element에서 선택된 option의 text가 저장된다.
    var yearText = yearSelect.options[yearSelect.selectedIndex].text;
    var monthText = monthSelect.options[monthSelect.selectedIndex].text;
    
//     alert(yearValue+'년 '+monthValue+'월 선택');
	if(yearValue!="" && monthValue!=""){
    	location.href='/book/list/ctgr?year='+yearValue+'&month='+monthValue+'&day='+day+'&ctgr='+ctgr;
	}
}


</script>

<!-- 예산 바꾸기 -->
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
				Swal.fire({
					title:'예산 설정 완료!',
          text: year+'년 '+month+'월 예산이 '+data+'만원으로 설정되었습니다.',
          confirmButtonColor: '#7A1CF6',
               icon: 'success' /*디자인 타입*/
         	   }).then(function(){
					   		setTimeout(location.reload(), 10);
         	   })
	   		},
	   		error: function(){
	   			console.log("실패");
	   		}
		}); //ajax
	});//budgetBtn click

    // DB에서 가져온 값으로 선택하기
 // 항목

	$("#year").val("${year }").attr("selected","selected");
	$("#month").val("${month}").attr("selected","selected");

});
</script>

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
<div class="form-floating" style="">
		<div style="margin: 15px 0px; text-align:center; ">
			<h3><select name="year" id="year" onchange="changeSelect()">
				<option value="2020">2020</option>
				<option value="2021">2021</option>
				<option value="2022">2022</option>
				<option value="2023">2023</option>
				<option value="2024">2024</option>
			</select>년 &nbsp;&nbsp;
			<select name="month" id="month" onchange="changeSelect()">
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
			</select>월 가계부</h3>
		
		</div>
</div>	

									
								
	<!-- 타이틀 부분 -->
	 <!-- Tasks Card Example -->
  <div class="container">
    <div class="row row-cols-1 row-cols-sm-1 row-cols-md-2 justify-content-center" >
  	<!-- 왼쪽 차트 박스 -->
       <div class="container mb-2 " id="box1"
          style="background-color: white; padding: 20px; border-radius: 15px; height: 250px; 
        			 box-shadow: 7px 14px 42px 3px rgba(163, 174, 184, 0.7);">
          <!-- 예산 추이 차트 자리 -->
					<!-- 타이틀 부분 -->
					<div style="width: 100%; height: 10%; margin: 0 auto; padding: 0; 
					        float: top; position: relative; top: 5%; left: 0;">
					        <h5 style="text-align: center;"><b>3개월 예산 추이</b></h5>
					        <div style="color: gray; font-size: 12px; text-align: center;">
					        	※지난 3개월 의 예산 또는 지출이 없으면 0으로 표시됩니다.
				        	</div>
					        <script src="https://cdn.jsdelivr.net/npm/chart.js@3.0.0/dist/chart.min.js"></script>
									<script src="https://cdn.jsdelivr.net/npm/chartjs-plugin-datalabels@2.0.0"></script>
									<script src="https://cdnjs.cloudflare.com/ajax/libs/Chart.js/2.9.3/Chart.min.js"></script>
							  	<canvas id="myChart" width="100%" style="max-height: 169px; max-width: 338px; margin: auto;"></canvas>
							  	<!-- 차트 속성 및 데이터 -->
									<script type="text/javascript">
									var ctx = document.getElementById("myChart");
									// 직전 3개월의 연/월/예산/지출 받아오기
									// 변수 뒤의 숫자가 1달전, 2달전, 3달전 의미함
									// 연
									var bfyear1 = "<c:out value='${bfyear1}' />";
									var bfyear2 = "<c:out value='${bfyear2}' />";
									var bfyear3 = "<c:out value='${bfyear3}' />";
									// 월
									var bfmonth1 = "<c:out value='${bfmonth1}' />";
									var bfmonth2 = "<c:out value='${bfmonth2}' />";
									var bfmonth3 = "<c:out value='${bfmonth3}' />";
									// 예산
									var bfbudget1 = "<c:out value='${bfbudget1}' />";
									var bfbudget2 = "<c:out value='${bfbudget2}' />";
									var bfbudget3 = "<c:out value='${bfbudget3}' />";
									
									// 지출
									var bfpercent1 = "<c:out value='${bfpercent1}' />";
									var bfpercent2 = "<c:out value='${bfpercent2}' />";
									var bfpercent3 = "<c:out value='${bfpercent3}' />";
									
// 									alert("(1달 전) "+bfyear1+"년 "+bfmonth1+"월 예산:"+bfbudget1+", 예산 대비 지출 퍼센트:"+bfpercent1);
									
									var chart = new Chart(ctx, {
									  type: "bar",
									  data: {
									    labels: [bfyear3+"."+bfmonth3, bfyear2+"."+bfmonth2, bfyear1+"."+bfmonth1],
									    datasets: 
									    	[{type: "line",
									        label: "예산 대비 지출(%)",
									        backgroundColor: "#e3cffc",
													borderColor: "#5107b0",									      
									        data: [bfpercent3, bfpercent2, bfpercent1],
									        lineTension: 0,
									        fill: false
									      },
									      {type: "bar",
									        backgroundColor: "#e3cffc",
									        borderColor: "#e3cffc",
									        borderWidth: 1,
									        label: "해당 월 예산(만원)",
									        data: [bfbudget3, bfbudget2, bfbudget1]
									      }],
									  }, // data
									  options: {
										  scales: {
								            yAxes: [{
							                display: true,
							                ticks: {
						                    min: 0, // 최소값 0
						                    stepSize: 20
							                },
							                scaleLabel: {
						                    display: true,
						                    labelString: '만원'
							                }
								            }]
										  },
// 										  maintainAspectRatio: false
										} // options
								  }); // Chart
									</script>
					</div>
          <!-- 예산 추이 차트 자리 끝 -->
      </div>
  	<!-- 왼쪽 차트 박스 끝 -->
  	<!-- 오른쪽 예산 박스 시작 -->
        <div class="container mb-2" id="box2"
          style="background-color: white; padding: 20px; border-radius: 15px; height: 250px; 
        			 box-shadow: 7px 14px 42px 3px rgba(163, 174, 184, 0.7);">
          <div style="margin-bottom: 10px; max-width: 400px; margin:auto;">
					
          	<div style="display: flex;" >
		          <h5 style="width: 70%"><b>한 달 예산</b> 
		          	<input type="number" name="bk_budget" id="bk_budget" value="${bk_budget}" style="text-align: right; width:70px; ">만원</h5>
		          <button id="budgetBtn" class="btn m3" style="background-color: #5107B0; width: 20%; margin:auto; padding: 0px; color:white" >
							<span class="btn-inner--text" style="color: white;">예산<br>입력</span>
							</button>
					 </div>
					 <br>
					 <h5>지출 <span style="color: red;"><fmt:formatNumber pattern="#,###" value="${sum }" />원</span></h5>
	         <h6 style="font-size: 95%">설장하신 예산에서 ${restedBudget1 }만 ${restedBudget2 }원 남았습니다.</h6> <br>
	         <div class="row no-gutters align-items-center">
	           <div class="col-auto">
	             <div class="h5 mb-0 mr-3 font-weight-bold text-gray-800"
	            		  style="text-align: right;">${percent }%</div>
	          	  </div>
			          <div class="col">
			            <div class="progress progress-lg mr-2">
			              <div class="progress-bar bg-info" role="progressbar" style="width: ${percent}%;" aria-valuenow="50"
			                aria-valuemin="0" aria-valuemax="100">
	                	</div>
	            		</div>
	          		</div>
	          <br>
	          <p>이번 달 예산의 ${percent }%만큼 지출했어요 ! </p>
	        </div>
        </div>
        </div>
      </div>
     
  </div>
	<div style="display: flex; justify-content: space-between; flex-flow: row nowrap; max-height: 50px; margin-top: 20px;">
	<div class="left-box">
		
	</div>
			<!-- 가계부 쓰기 버튼 -->
			<div style="float: right; margin: 0 10px 10px 0;">
				<input type="button" value="가계부 쓰기" class="btn m3" 
					onclick="location.href='/book/write?year=${year}&month=${month}&day=${day }';" 
					style="background-color: #5107B0; font-size:large; width: 100px; margin:auto; padding: 5px; color:white">
			</div>
		</div>
		

		<!-- 가계부 목록 -->
		<div class="listTable" style="width: 100%; text-align: center; background-color: white; padding: 10px; border-radius: 15px;
        			 box-shadow: 7px 14px 42px 3px rgba(163, 174, 184, 0.7);" >
        	<!-- 카테고리 -->
			
			<select name="ctgr" id="ctgr" class="selectcategory" 
					style="margin-left: 10px; border-style: none; font-size: 20px; padding-bottom: 10px; height: 62px; display: block; color: gray; border-radius: 23px;">
				<option value="" disabled selected style="color: black; text-align: center;">항목을 선택해주세요</option>
				<option value="수입" style="color: black; text-align: center;">수입</option>
				<option value="지출" style="color: black; text-align: center;">지출</option>
				<option value="이체" style="color: black; text-align: center;">이체</option>
			</select>
			
			<script>
				$('select[name="ctgr"]').change(function(){
					var ctgr = $('select[name="ctgr"] option:selected').val();
					changeSelectCtgr(ctgr);
				}); // change
			</script>
        			 
        			 
			<table style="width: 100%; margin: auto;">
			<thead style="background-color: #5107B0; color: white; ">
				<tr style="height: 40px;">
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
				<tr style="height: 40px; background-color:white;">
					<td>${list.bk_day }일</td>
					<td>${list.bk_iow }</td>
					<td>${list.bk_group }</td>
					<td >${list.bk_category }</td>
					<td><fmt:formatNumber value="${list.bk_money }" pattern="#,###" />원</td>
					<td>${list.bk_memo }</td>
					<td style="font-size: x-small">
						<button id="budgetBtn" class="btn m3"  onclick="location.href='/book/update?page=1&bk_num=${list.bk_num}&bk_detail_num=${list.bk_detail_num }';"
						style="background-color: #5107B0; width: 80px; margin:auto; padding: 0px; color:white; max-width:50px;" >
						<span class="btn-inner--text" style="color: white;">수정</span>
						</button>
						<button id="budgetBtn" class="btn m3"  onclick="location.href='/book/delete?page=1&bk_num=${list.bk_num}&bk_detail_num=${list.bk_detail_num }';"
						style="background-color: #5107B0; width: 80px; margin:auto; padding: 0px; color:white; max-width:50px;" >
						<span class="btn-inner--text" style="color: white;">삭제</span>
						</button>
					</td>
				</tr>
				</c:forEach>
				
			</tbody>
			</table>
		</div><br>
	<!-- ===================== 페이징 처리 구간 ========================== -->
<div id="pagingDiv">
		<nav aria-label="Page navigation example">
		<ul type="none" id="pageUl"  class="pagination justify-content-center">
			<c:if test="${pm.prev }"> 
				<li><a href="/book/list?page=${pm.pageStart - 1 }&year=${year}&month=${month}&day=${day}" class="page-item" aria-label="Previous" style="color:#621fb7;">
						<span aria-hidden="true">&laquo;</span></a>
				</li>
			</c:if>
			<c:forEach var="index" begin="${pm.pageStart }" end="${pm.endPage }"> 
				<li ${pm.vo.page == index? 'class=active' : '' }  style="float: left;"  class="page-item">
					<a href="/book/list?page=${index }&year=${year}&month=${month}&day=${day}" style="color:#621fb7;"  class="page-link" > ${index} </a>
				</li>
			</c:forEach>
			<c:if test="${pm.next }">
				<li class="page-item"><a href="book/list?page=${pm.endPage + 1 }&year=${year}&month=${month}&day=${day}" class="page-link"  aria-label="Next" style="color:#621fb7;">
					<span aria-hidden="true">&raquo;</span></a></li>
			</c:if>
		</ul>
		</nav>
	</div>
	<!-- ===================== 페이징 처리 구간 끝 ========================== -->
 </div>
 <br><br>
<!-- 태그 적는 곳 -->
<!-- Jquery CDN 로드 : 항상 최신 버전 사용 -->    



<%@ include file="../include/footer.jsp"%>