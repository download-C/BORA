<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ include file="../include/header.jsp"%>
<!-- ${pageContext.request.contextPath} -->
<script src="https://code.jquery.com/jquery-3.6.0.js"></script>

<h1>
	board/ <span
		style="color: white; background-color: orange; font-size: 1.5em">
		💐💐list😎😎 </span>.jsp
</h1>
<div>
	<div>
		<h6>EL{msg} : ${msg }</h6>
		<h6>EL{pm} : ${pm }</h6>
		<h6>EL{pm.pageStart}: ${pm.pageStart }</h6>
		<h3><a href="/board/insert">여기를 눌러서 편하게 글쓰기 하십시오 ^^💘💘 </a></h3>
	</div>
	
	
	<!-- // 카테고리 ajax,.,... 일단 보류 -->
	<script type="text/javascript">
		$(document).ready(function(){
			// 모두다
			var page = $("#page").val();
			var pageStart = "<c:out value='${pm.pageStart }' />";
// 			alert("pageStart: "+pageStart);
// 			alert("page: "+page);
// 			alert("페이지 번호: "+page);
			$('.ctgr_btn').click(function(){
				var ctgr = $(this).val();
				alert(ctgr);
				$.ajax({
					url: "/ajax/ctgr",
					data: {"ctgr": $(this).val(), "pageStart":pageStart, "page":page},
					dataType: "JSON",
					type: "get",
					success: function(data){
// 						alert('성공');
						
						$('tbody').html("");
						$('tbody').html(function(){
						$.each(data, function(index, item){
							var bno = item.bno;
							var b_title = item.b_title;
							var b_ctgr = item.b_ctgr;
							var id = item.id;
							var b_regdate = item.b_regdate;
							var date = new Date(b_regdate);
							var regdate = date.getFullYear() +"년 " +(date.getMonth()+1)+"월 "+date.getDate()+"일 🌈"+date.getHours()+":"+date.getMinutes();
							var b_readcount = item.b_readcount;
							$('tbody').append(
							'<tr>'
								+'<td>'+bno+'</td>'
								+'<td>'+b_ctgr+'</td>'
								+'<td><a href=/board/read?bno='+bno+'&page='+page+'>'+b_title+'</a></td>'
								+'<td>'+id+'</td>'
								+'<td>'+regdate+'</td>'
								+'<td>'+b_readcount+'</td>'
							+'</tr>'		
							); // append
						}); //each
						}); // html
					}, //success
					error: function(){
						alert('실패');
// 						location.href="/board/list?page="+page;
					}
				});// ajax
				
				
				
				
			}); // btn click
		});// jquery ready
	</script>
<!-- ajax로 카테고리 호출 시 페이징 처리 대신 하는 메서드 -->

	<input type="button" value="모두다BORA" class="ctgr_btn" id="btn_all">
	<input type="button" value="골라줘BORA" class="ctgr_btn" id="btn_pick">
	<input type="button" value="알려줘BORA" class="ctgr_btn" id="btn_tip">
	<input type="button" value="친해져BORA" class="ctgr_btn" id="btn_meet">

	<input type="hidden" id="page" value="${pm.vo.page }"> 
	<div>
		<table class="table table-bordered">
			<thead>
				<tr>
					<th>번호</th>
					<th>카테고리</th>
					<th>제목</th>
					<th>id -> 닉으로</th>
					<th>작성일</th>
					<th>조회수</th>
				</tr>
			</thead>
			<tbody>	
				<c:forEach var="vo" items="${boardList }">
				
					<tr>
						<td>${vo.bno}</td>
						<td>${vo.b_ctgr}</td>
						<td> <a href="/board/read?bno=${vo.bno }&page=${pm.vo.page}">${vo.b_title }</a> </td>
						<td>${vo.id }</td>
						<td> <fmt:formatDate value="${vo.b_regdate }" pattern="YYYY년 MM월 dd일 🌈  HH:mm" /> </td>
						<td>${vo.b_readcount }</td>
					</tr>
				
				</c:forEach>
			</tbody>
		</table>
	</div>

	<!-- ===================== 페이징 처리 구간 ========================== -->
	<div>
		<ul type="none" id="pageUl">
			
			<!-- 이전 버턴================ -->
			
			<c:if test="${pm.prev }"> 
					<!--      ㄴboolean 타입이니까 false면 걍 패스되는거~ 음 편하군  -->
				<li><a href="listPage?page=${pm.pageStart - 1 }">&laquo;</a></li>
			</c:if>
			
			<!-- 1 2 3 4 .... ================ -->
			<c:forEach var="index" begin="${pm.pageStart }" end="${pm.endPage }"> 
						<!-- 페이지 블럭에서 내가 선택한 현재 페이지만! active되도록 -->
				<%-- 
				<li <c:out value="${pm.vo.page == index? 'class=active' : '' }" />>   2.3버전 이하는 c:out 써야 함~ --%>
				<li ${pm.vo.page == index? 'class=active' : '' }  style="float: left;">
					<a href="listPage?page=${index }"> &nbsp;&nbsp; ${index} &nbsp;&nbsp; </a>
				</li>
			</c:forEach>
			
			<!-- 다음 버턴================ -->
			<c:if test="${pm.next }">
				<li><a href="listPage?page=${pm.endPage + 1 }">&raquo;</a></li>
			</c:if>
		</ul>
	</div>
	<!-- ===================== 페이징 처리 구간 끝 ========================== -->
</div>


<script type="text/javascript">
	// alert(${msg});
	var result = "${msg}";
	
	if(result == "OK") {
		alert("글쓰기 완 🥰");
	}
	
	if(result == "MOD_OK"){
		alert("글 수정 완 🥰");
	}
	
	if(result == "DEL_OK"){
		alert("글 삭제 완 🥰");
	}
</script>


<%@ include file="../include/footer.jsp"%>