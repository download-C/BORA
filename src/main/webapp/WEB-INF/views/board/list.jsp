<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ include file="../include/header.jsp"%>
<!-- ${pageContext.request.contextPath} -->
<script src="https://cdn.jsdelivr.net/npm/sweetalert2@9"></script>
<script src="https://cdn.jsdelivr.net/npm/promise-polyfill@7.1.0/dist/promise.min.js"></script>
<script src="https://code.jquery.com/jquery-3.6.0.js"></script>

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
  <h2><b>커뮤니티</b></h2>
  
</div>
<!-- End title -->

<!-- 	<div> -->
<%-- 		<p>EL{msg} : ${msg }</p> --%>
<%-- 		<p>EL{pm} : ${pm }</p> --%>
<%-- 		<p>EL{pm.vo.page}: ${pm.vo.page }</p> --%>
<!-- 	</div> -->
	
<!-- ajax로 카테고리 호출 시 페이징 처리 대신 하는 메서드 -->
<script type="text/javascript">

	$(document).ready(function(){
		// 모두다
		var page = $("#page").val();
		var pageStart = "<c:out value='${pm.pageStart }' />";
		$('.ctgr_btn').click(function(){
			var ctgr = $(this).val();
				// alert(ctgr);
			$.ajax({
				url: "/ajax/ctgr",
				data: {"ctgr": $(this).val(), "pageStart":pageStart, "page":page},
				dataType: "JSON",
				type: "get",
				success: function(data){
						// alert('성공');
					
					$('tbody').html("");
					$('tbody').html(function(){
					$.each(data, function(index, item){
						var bno = item.bno;
						var b_title = item.b_title;
						var b_ctgr = item.b_ctgr;
						var nick = item.nick;
						var b_regdate = '';
						if(item.b_updatedate != null) {
							// updatedate가 null이 아니라면~ == 수정된 적 있으면~
							b_regdate = item.b_updatedate;
						} else {
							// 수정된 적 없으면~
							b_regdate = item.b_regdate;
						}
						var date = new Date(b_regdate);
						var regdate = date.getFullYear() +"년 " +(date.getMonth()+1)+"월 "+date.getDate()+"일 💜 "+date.getHours()+":"+date.getMinutes();
						var b_readcount = item.b_readcount;
						var b_cmtcount = item.b_cmtcount;
						$('tbody').append(
						'<tr>'
							+'<td>'+bno+'</td>'
							+'<td>'+b_ctgr+'</td>'
							+'<td><a href=/board/read?bno='+bno+'&page='+page+'>'+b_title+'</a>&nbsp; (' + b_cmtcount + ')</td>'
							+'<td>'+nick+'</td>'
							+'<td>'+regdate+'</td>'
							+'<td>'+b_readcount+'</td>'
						+'</tr>'		
						); // append
					}); //each
					}); // html
				}, //success
				error: function(){
					alert('실패');
						// location.href="/board/list?page="+page;
				}
			});// ajax
			
		}); // btn click
		
	});// jquery ready
</script>
<!-- ajax로 카테고리 호출 시 페이징 처리 대신 하는 메서드 끝 -->



<!-- table -->
<div class="row">
  <div class="col-12">
   <div class="d-sm-flex align-items-center mb-3">
	<div class="container">
		<button type="button" value="모두다BORA" class="ctgr_btn btn" id="btn_all"  style="background-color: #e3cffc; float: left; width: 160px; margin: 0px 10px 10px 0px; border-radius: 25px;"><span class="btn-inner--text" style="color: black;">모두다<b style="color:#5107B0;">BORA</b></span></button>
		<button type="button" value="골라줘BORA" class="ctgr_btn btn" id="btn_pick" style="background-color: #e3cffc; float: left; width: 160px; margin: 0px 10px 10px 0px; border-radius: 25px;"><span class="btn-inner--text" style="color: black;">골라줘<b style="color:#5107B0;">BORA</b></span></button>
		<button type="button" value="알려줘BORA" class="ctgr_btn btn" id="btn_tip"  style="background-color: #e3cffc; float: left; width: 160px; margin: 0px 10px 10px 0px; border-radius: 25px;"><span class="btn-inner--text" style="color: black;">알려줘<b style="color:#5107B0;">BORA</b></span></button>
		<button type="button" value="친해져BORA" class="ctgr_btn btn" id="btn_meet" style="background-color: #e3cffc; float: left; width: 160px; margin: 0px 10px 10px 0px; border-radius: 25px;"><span class="btn-inner--text" style="color: black;">친해져<b style="color:#5107B0;">BORA</b></span></button>
		<button type="button" value="글쓰기" onclick="location.href='/board/insert';" class="btn" id="" style="background-color: #5107B0; float: right; width: 120px; margin: 0px 10px 10px 0px;"><span class="btn-inner--text" style="color: white;">글쓰기</span></button>
			<input type="hidden" id="page" value="${pm.vo.page }"> 
	</div>
	</div>
	
<div class="card-body px-0 py-0" >
    <div class="container">
		<table  class="table table-hover" style="box-shadow: 7px 14px 90px 3px rgba(163, 174, 184, 0.7);">
			<thead class="bg-gray-100">
				<tr style="color:#5107B0; background-color: #e3cffc;" >
					<th class="text-xs font-weight-semibold opacity-7" style="width: 5%; ">번호</th>
					<th class="text-xs font-weight-semibold opacity-7" style="width: 10%; ">카테고리</th>
					<th class="text-xs font-weight-semibold opacity-7 ps-2" style="width: 40%; ">제목</th>
					<th class="text-xs font-weight-semibold opacity-7 ps-2" style="width: 10%; ">닉네임</th>
					<th class="text-xs font-weight-semibold opacity-7 ps-2" style="width: 20%; ">작성일</th>
					<th class="text-xs font-weight-semibold opacity-7 ps-2" style="width: 5%; ">조회수</th>
				</tr>
			</thead>
			<tbody>	
<%-- 			<c:forEach var="vo" items="${boardList }" varStatus="status"> --%>
				<c:forEach var="vo" items="${boardList }">
				
					<tr>
						<td><span class="text-sm font-weight-normal">${vo.bno}</span></td>
						<td><div class="my-auto"><h6 class="mb-0 text-sm">${vo.b_ctgr}</h6></div></td>
						<td><a href="/board/read?bno=${vo.bno }&page=${pm.vo.page}">${vo.b_title }</a><!-- </p> -->
							&nbsp; <span style="color: #5107B0; font-size: small;">[${vo.b_cmtcount }]</span> <%-- (${cmtList[status.index] })  --%>
						</td>
						<td><b>${vo.nick }</b></td>
						<td><span class="text-sm font-weight-normal">
							<c:choose>
								<c:when test="${vo.b_updatedate eq null }">
									<fmt:formatDate value="${vo.b_regdate }" pattern="YYYY년 MM월 dd일 💜  HH:mm" />
								</c:when>
								<c:otherwise>
									<fmt:formatDate value="${vo.b_updatedate }" pattern="YYYY년 MM월 dd일 💜  HH:mm" />
								</c:otherwise>
							</c:choose> 
							</span>
						</td>
						<td><span class="text-sm font-weight-normal">${vo.b_readcount }</span></td>
					</tr>
				
				</c:forEach>
			</tbody>
		</table>
	</div> <!-- container -->
	<br><br>
	<!-- ===================== 페이징 처리 구간 ========================== -->
	<div>
		<nav aria-label="Page navigation example">
		<ul type="none" id="pageUl"  class="pagination justify-content-center">
			
			<!-- 이전 버턴================ -->
			
			<c:if test="${pm.prev }"> 
					<!--      ㄴboolean 타입이니까 false면 걍 패스되는거~ 음 편하군  -->
				<li><a href="list?page=${pm.pageStart - 1 }" class="page-item" aria-label="Previous" style="color:#621fb7;">
						<span aria-hidden="true">&laquo;</span></a>
				</li>
			</c:if>
			
			<!-- 1 2 3 4 .... ================ -->
			<c:forEach var="index" begin="${pm.pageStart }" end="${pm.endPage }"> 
						<!-- 페이지 블럭에서 내가 선택한 현재 페이지만! active되도록 -->
				<%-- 
				<li <c:out value="${pm.vo.page == index? 'class=active' : '' }" />>   2.3버전 이하는 c:out 써야 함~ --%>
				<li ${pm.vo.page == index? 'class=active' : '' }  style="float: left;"  class="page-item">
					<a href="list?page=${index }" style="color:#621fb7;"  class="page-link" > ${index} </a>
				</li>
			</c:forEach>
			
			<!-- 다음 버턴================ -->
			<c:if test="${pm.next }">
				<li class="page-item"><a href="list?page=${pm.endPage + 1 }" class="page-link"  aria-label="Next" style="color:#621fb7;">
					<span aria-hidden="true">&raquo;</span></a></li>
			</c:if>
		</ul>
		</nav>
	</div>
	<!-- ===================== 페이징 처리 구간 끝 ========================== -->
</div>
</div> <!-- col-12 -->
</div> <!-- row -->

<script type="text/javascript">

	// success 버튼
	function success(result) {
	    Swal.fire(
	        result,
	        '',
	        'success' /*디자인 타입*/
	    )
	}//success 버튼
	
	
	// alert(${msg});
	let result = "${msg}";
	
	if(result == "OK") {
		success("글 작성이 완료되었습니다 🥰");
	}
	
	if(result == "MOD_OK"){
		success("수정이 완료되었습니다 🥰");
// 		alert("글 수정 완 🥰");
	}
	
	if(result == "DEL_OK"){
		success("삭제가 완료되었습니다 🥰");
	}
</script>

<%@ include file="../include/footer.jsp"%>