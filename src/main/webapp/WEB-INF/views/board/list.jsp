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
	
<script type="text/javascript">
// <!-- ajax로 카테고리 호출 시 페이징 처리 대신 하는 메서드 -->
	$(document).ready(function(){
		
		// 더보기 버튼 평소에는 숨기고 있다가
		$('#addBtn').hide();
		
		$('.ctgr_btn').click(function(){
			
			// 카테고리 버턴 클릭했을 때~
			// 더보기 버튼 등장
			$('#addBtn').show();
			
			var ctgr = $(this).val();
// 			alert(ctgr);
			$('#ctgrHidden').val(ctgr); // input hidden에 클릭한 ctgr 값으로 채워놓기
			$('#pagingDiv').remove();
			var startNum = 0;

			$.ajax({
				url: "/ajax/ctgr",
				data: {"ctgr": $(this).val(), "startNum":startNum},
				dataType: "JSON",
				type: "get",
				success: function(data){
					
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
							+'<td><a href=/board/read?bno='+bno+'&page=1>'+b_title+'</a>&nbsp; <span style="color: #5107B0; font-size: small;">[' + b_cmtcount + ']</span></td>'
							+'<td>'+nick+'</td>'
							+'<td>'+regdate+'</td>'
							+'<td>'+b_readcount+'</td>'
						+'</tr>'
						); // append
					}); //each
					}); // html
				}, //success
				error: function(){
					alert('실팹니다~');
					location.href="/board/list";
				}
			});// ajax
			
		}); // btn click
		
	});// jquery ready

	
// 더보기 구현 시작 ==========================================================
	function moreList() {
		//  	alert('더보기 함수 moreList 호출됨');
		var startNum = $("#listBody tr").length; //마지막 리스트 번호를 알아내기 위해서 tr태그의 length를 구함.
		var addListHtml = "";
		var ctgr = $('#ctgrHidden').val();
		console.log("startNum: " + startNum + " / ctgr:  " + ctgr); //콘솔로그로 startNum에 값이 들어오는지 확인

		$.ajax({
			url : "/ajax/ctgr/getMoreList",
			type : "get",
			data : {
				"startNum" : startNum,
				"ctgr" : ctgr
			},
			dataType : "json",

			success : function(rData) {
				var addListHtml = "";

				if (rData.length > 0) {
					
					$('tbody').append(function(){
						$.each(rData, function(index, item){
							
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
								+'<td><a href=/board/read?bno='+bno+'&page=1>'+b_title+'</a>&nbsp; <span style="color: #5107B0; font-size: small;">[' + b_cmtcount + ']</span></td>'
								+'<td>'+nick+'</td>'
								+'<td>'+regdate+'</td>'
								+'<td>'+b_readcount+'</td>'
							+'</tr>'		
							); // append
						}); //each
						}); // html
					
					
// 					for (var i = 0; i < rData.length; i++) {
// 						var idx = Number(startNum) + Number(i) + 1;
// 						// 글번호때문에 한 건가,,??? 나는 카테고리별로 들고 오는거니까 노상관
// 						//                     alert('idx: ' + idx + ' / rData.length: ' + rData.length);

// 						addListHtml += "<tr>";
// 						addListHtml += "<td>" + rData[i].bno + "</td>";
// 						addListHtml += "<td>" + rData[i].b_ctgr + "</td>";
// 						addListHtml += "<td>" + rData[i].b_title + "</td>";
// 						addListHtml += "<td>" + rData[i].nick + "</td>";
// 						addListHtml += "<td>" + rData[i].regdate + "</td>";
// 						addListHtml += "<td>" + rData[i].b_readcount + "</td>";
// 						addListHtml += "</tr>";
// 					} // for

// 					$("#listBody").append(addListHtml);
					
				} // if
				else {
					alert('더 들고 올 글 없음');
				} // else
			},
			error : function(request, status, error) {
				alert('실팹니다~');
				console.log("code: ", request.status)
				console.log("message: ", request.responseText)
				console.log("error: ", error);
			}
		}); // ajax

	} // moreList()
</script>




<!-- table -->
<div class="row">
  <div class="col-12">
   <div class="d-sm-flex align-items-center mb-3">
	<div class="container">
		<button type="button" value="모두다BORA" class="btn" onclick="location.href='/board/list';" id="btn_all"  style="background-color: #e3cffc; float: left; width: 160px; margin: 0px 10px 10px 0px; border-radius: 25px;"><span class="btn-inner--text" style="color: black;">모두다<b style="color:#5107B0;">BORA</b></span></button>
		<button type="button" value="골라줘BORA" class="ctgr_btn btn" id="btn_pick" style="background-color: #e3cffc; float: left; width: 160px; margin: 0px 10px 10px 0px; border-radius: 25px;"><span class="btn-inner--text" style="color: black;">골라줘<b style="color:#5107B0;">BORA</b></span></button>
		<button type="button" value="알려줘BORA" class="ctgr_btn btn" id="btn_tip"  style="background-color: #e3cffc; float: left; width: 160px; margin: 0px 10px 10px 0px; border-radius: 25px;"><span class="btn-inner--text" style="color: black;">알려줘<b style="color:#5107B0;">BORA</b></span></button>
		<button type="button" value="친해져BORA" class="ctgr_btn btn" id="btn_meet" style="background-color: #e3cffc; float: left; width: 160px; margin: 0px 10px 10px 0px; border-radius: 25px;"><span class="btn-inner--text" style="color: black;">친해져<b style="color:#5107B0;">BORA</b></span></button>
		<button type="button" value="글쓰기" onclick="location.href='/board/insert';" class="btn" id="" style="background-color: #5107B0; float: right; width: 120px; margin: 0px 10px 10px 0px;"><span class="btn-inner--text" style="color: white;">글쓰기</span></button>
		<input type="hidden" id="page" value="${pm.vo.page }"> 
<!-- 		<div class="radioCustom" style="display: flex; align-items: center; justify-content: center;"> -->
<!-- 		<input type="radio" id="radio1" value="골라줘BORA" required  class="ctgr_btn btn" id="btn_pick" style="background-color: #e3cffc; float: left; width: 160px; margin: 0px 10px 10px 0px; border-radius: 25px;">  <label for="radio1">골라줘BORA</label> -->
<!-- 		<input type="radio" id="radio2" value="알려줘BORA" required class="ctgr_btn btn" id="btn_tip" style="background-color: #e3cffc; float: left; width: 160px; margin: 0px 10px 10px 0px; border-radius: 25px;"> <label for="radio2">알려줘BORA</label> -->
<!-- 		<input type="radio" id="radio3" value="친해져BORA" required class="ctgr_btn btn" id="btn_meet" style="background-color: #e3cffc; float: left; width: 160px; margin: 0px 10px 10px 0px; border-radius: 25px;"> <label for="radio3">친해져BORA</label> -->
		<input type="hidden" id="ctgrHidden" value="" >
	</div>
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
			<tbody id="listBody">	
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
		<div> <button id="addBtn" onclick="moreList();"><span>더보기</span></button> </div>
	</div> <!-- container -->
	<br><br>
	<!-- ===================== 페이징 처리 구간 ========================== -->
	<div id="pagingDiv">
		<nav aria-label="Page navigation example">
		<ul type="none" id="pageUl"  class="pagination justify-content-center">
			<c:if test="${pm.prev }"> 
				<li><a href="list?page=${pm.pageStart - 1 }" class="page-item" aria-label="Previous" style="color:#621fb7;">
						<span aria-hidden="true">&laquo;</span></a>
				</li>
			</c:if>
			<c:forEach var="index" begin="${pm.pageStart }" end="${pm.endPage }"> 
				<li ${pm.vo.page == index? 'class=active' : '' }  style="float: left;"  class="page-item">
					<a href="list?page=${index }" style="color:#621fb7;"  class="page-link" > ${index} </a>
				</li>
			</c:forEach>
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
	    Swal.fire({
	        title: result,
	        text: '',
	        icon: 'success', /*디자인 타입*/
	        confirmButtonColor: '#7A1CF6'
	    });
	}//success 버튼
	
	
	// alert(${msg});
	let result = "${msg}";
	
	if(result == "OK") {
		success("글 작성이 완료되었습니다 🥰");
	}
	
	if(result == "MOD_OK"){
		success("수정이 완료되었습니다 🥰");
	}
	
	if(result == "DEL_OK"){
		success("삭제가 완료되었습니다 🥰");
	}
</script>

<%@ include file="../include/footer.jsp"%>