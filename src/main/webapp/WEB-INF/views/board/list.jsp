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

/*  카테고리 버튼 클릭 시,, 배경 바뀌는 거 css 걸어보려고 했는데 안먹네
.ctgr_curr {
	background-color: #ffffff; 
	float: left; 
	width: 160px; 
	margin: 0px 10px 10px 0px; 
	border-radius: 25px;
}

.ctgr_wait {
	background-color: #e3cffc; 
	float: left; 
	width: 160px; 
	margin: 0px 10px 10px 0px; 
	border-radius: 25px;
} */

</style>


<!-- title -->
<div class="section-title">
  <h2><b>커뮤니티</b></h2>
  
</div>
<!-- End title -->

<%-- 		<p>EL{msg} : ${msg }</p> --%>
<%-- 		<p>EL{pm} : ${pm }</p> --%>
<%-- 		<p>EL{pm.vo.page}: ${pm.vo.page }</p> --%>
	
<script type="text/javascript">
	// 알림 모달창 호출 함수 --------------
	//warning 버튼
	function warning(result) {
	    Swal.fire(
	        result,
	        '',
	        'warning' /*디자인 타입*/
	    )
	}//warning 버튼
	// 알림 모달창 호출 함수 끝--------------

	// 카테고리 하면서 계속 쓸 놈들,, 멤변으로 선언
	var startNum = $("#listBody tr").length;
	var currNum;
	var ctgrCount;
	var ctgr;

	$(document).ready(function(){
	// 카테고리 시작 ======================================
		// 더보기 버튼 평소에는 숨기고 있다가
		$('#addBtn').hide();
		
		$('.ctgr_btn').click(function(){
			// 카테고리 버턴 클릭했을 때~
			ctgr = $(this).val();  // 카테고리 변수 채우고
			$('#ctgrHidden').val(ctgr); // input hidden에 클릭한 ctgr 값으로 채워놓기
			$('#pagingDiv').remove();   // 카테고리 클릭 시, 페이징 처리 div는 숨겨놓기
			
			// 클릭된 카테고리만 배경색 다르게
			if(ctgr=='골라줘BORA'){
				$('#btn_all').attr('style', 'background-color: #ffffff; float: left; width: 160px; margin: 0px 10px 10px 0px; border-radius: 25px;');
				$('#btn_pick').attr('style', 'background-color: #e3cffc; float: left; width: 160px; margin: 0px 10px 10px 0px; border-radius: 25px;');
				$('#btn_tip').attr('style', 'background-color: #ffffff; float: left; width: 160px; margin: 0px 10px 10px 0px; border-radius: 25px;');
				$('#btn_meet').attr('style', 'background-color: #ffffff; float: left; width: 160px; margin: 0px 10px 10px 0px; border-radius: 25px;');
			} else if (ctgr=='알려줘BORA'){
				$('#btn_all').attr('style', 'background-color: #ffffff; float: left; width: 160px; margin: 0px 10px 10px 0px; border-radius: 25px;');
				$('#btn_pick').attr('style', 'background-color: #ffffff; float: left; width: 160px; margin: 0px 10px 10px 0px; border-radius: 25px;');
				$('#btn_tip').attr('style', 'background-color: #e3cffc; float: left; width: 160px; margin: 0px 10px 10px 0px; border-radius: 25px;');
				$('#btn_meet').attr('style', 'background-color: #ffffff; float: left; width: 160px; margin: 0px 10px 10px 0px; border-radius: 25px;');
			} else if (ctgr=='친해져BORA'){
				$('#btn_all').attr('style', 'background-color: #ffffff; float: left; width: 160px; margin: 0px 10px 10px 0px; border-radius: 25px;');
				$('#btn_pick').attr('style', 'background-color: #ffffff; float: left; width: 160px; margin: 0px 10px 10px 0px; border-radius: 25px;');
				$('#btn_tip').attr('style', 'background-color: #ffffff; float: left; width: 160px; margin: 0px 10px 10px 0px; border-radius: 25px;');
				$('#btn_meet').attr('style', 'background-color: #e3cffc; float: left; width: 160px; margin: 0px 10px 10px 0px; border-radius: 25px;');
			}
			
			startNum = 0;

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
						var b_readcount = item.b_readcount;
						var b_cmtcount = item.b_cmtcount;
						var regdate = '';  // 날짜.. 포맷때메 조금 긺
						
							if(item.b_updatedate != null) {
								// updatedate가 null이 아니라면~ == 수정된 적 있으면~
								regdate = item.b_updatedate;
							} else {
								// 수정된 적 없으면~
								regdate = item.b_regdate;
							}
							
							var dateObj = new Date(regdate);
							var year = dateObj.getFullYear();
							var month = dateObj.getMonth()+1;
							var day = dateObj.getDate();
							var hh = dateObj.getHours();
							var mi = dateObj.getMinutes();
							var format = year+". " + (("00"+month.toString()).slice(-2)) + ". " + (("00"+day.toString()).slice(-2)) + ". 💜 " + (("00"+hh.toString()).slice(-2)) + ":" + (("00"+mi.toString()).slice(-2));
							  // console.log("format", format);
						
						$('tbody').append(
						'<tr style="text-align: center;">'
							+'<td>'+bno+'</td>'
							+'<td>'+b_ctgr+'</td>'
							+'<td style="text-align: left;"><a href=/board/read?bno='+bno+'&page=1>'+b_title+'</a>&nbsp; <span style="color: #5107B0; font-size: small;">[' + b_cmtcount + ']</span></td>'
							+'<td>'+nick+'</td>'
							+'<td>'+format+'</td>'
							+'<td>'+b_readcount+'</td>'
						+'</tr>'
						
						); // append
					  }); //each
					}); // html
					
				}, //success
				error: function(){
 					// alert('실팹니다~');
					location.href="/board/list";
				}
			});// ajax
			
			
			// + 해당 카테고리 글 총 개수 ctgrCount 변수에 넣기 & 더보기 버턴에 보여주기
			$.ajax({
				url: '/ajax/ctgr/count',
				type: 'get',
				data: {'ctgr':ctgr},
				dataType: 'json',
				success: function(rData){
					ctgrCount = rData;
					// currNum 업뎃해주고
					currNum = 5;
					// alert('currNum: ' + currNum);
					
					$('#addBtn').text('더보기  ' + currNum + ' / ' + ctgrCount );
				}
			}); // ajax
			
			$('#addBtn').show();   // 셋팅 다 하고 숨겨왔던,, 더보기 버튼 등장
			
		}); // btn click
	});// jquery ready

	
// 더보기 함수 시작 ==================================================
	function moreList() {
		startNum = $("#listBody tr").length; //마지막 리스트 번호를 알아내기 위해서 tr태그의 length를 구함.
		ctgr = $('#ctgrHidden').val();
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
				if (rData.length > 0) {
					$('tbody').append(function(){
						$.each(rData, function(index, item){
							var bno = item.bno;
							var b_title = item.b_title;
							var b_ctgr = item.b_ctgr;
							var nick = item.nick;
							var b_readcount = item.b_readcount;
							var b_cmtcount = item.b_cmtcount;
							var regdate = '';  // 날짜.. 포맷때메 조금 긺
							
								if(item.b_updatedate != null) {
									// updatedate가 null이 아니라면~ == 수정된 적 있으면~
									regdate = item.b_updatedate;
								} else {
									// 수정된 적 없으면~
									regdate = item.b_regdate;
								}
								
								var dateObj = new Date(regdate);
								var year = dateObj.getFullYear();
								var month = dateObj.getMonth()+1;
								var day = dateObj.getDate();
								var hh = dateObj.getHours();
								var mi = dateObj.getMinutes();
								var format = year+". " + (("00"+month.toString()).slice(-2)) + ". " + (("00"+day.toString()).slice(-2)) + ". 💜 " + (("00"+hh.toString()).slice(-2)) + ":" + (("00"+mi.toString()).slice(-2));
							
							// 갖다 붙이기 시작
							$('tbody').append(
							'<tr style="text-align: center;">'
								+'<td>'+bno+'</td>'
								+'<td>'+b_ctgr+'</td>'
								+'<td style="text-align: left;"><a href=/board/read?bno='+bno+'&page=1>'+b_title+'</a>&nbsp; <span style="color: #5107B0; font-size: small;">[' + b_cmtcount + ']</span></td>'
								+'<td>'+nick+'</td>'
								+'<td>'+format+'</td>'
								+'<td>'+b_readcount+'</td>'
							+'</tr>'
							
							); // append
						}); //each
					}); // append
					
					currNum = $("#listBody tr").length;
					
				} // if
				else {
					warning('더이상 게시글이 <br> 존재하지 않습니다~ 😅');
				} // else
			
				$('#addBtn').text('더보기  ' + currNum + ' / ' + ctgrCount );
				
			}, // success
			error : function(request, status, error) {
				warning('실팹니다~');
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
		<button type="button" value="모두다BORA" class="btn" id="btn_all" onclick="location.href='/board/list';" id="btn_all"  style="background-color: #e3cffc; float: left; width: 160px; margin: 0px 10px 10px 0px; border-radius: 25px;"><span class="btn-inner--text" style="color: black;">모두다<b style="color:#5107B0;">BORA</b></span></button>
		<button type="button" value="골라줘BORA" class="ctgr_btn btn" id="btn_pick" style="background-color: #ffffff; float: left; width: 160px; margin: 0px 10px 10px 0px; border-radius: 25px;"><span class="btn-inner--text" style="color: black;">골라줘<b style="color:#5107B0;">BORA</b></span></button>
		<button type="button" value="알려줘BORA" class="ctgr_btn btn" id="btn_tip"  style="background-color: #ffffff; float: left; width: 160px; margin: 0px 10px 10px 0px; border-radius: 25px;"><span class="btn-inner--text" style="color: black;">알려줘<b style="color:#5107B0;">BORA</b></span></button>
		<button type="button" value="친해져BORA" class="ctgr_btn btn" id="btn_meet" style="background-color: #ffffff; float: left; width: 160px; margin: 0px 10px 10px 0px; border-radius: 25px;"><span class="btn-inner--text" style="color: black;">친해져<b style="color:#5107B0;">BORA</b></span></button>
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
		<table  class="table table-hover" style="box-shadow: 7px 14px 90px 3px rgba(163, 174, 184, 0.7); margin-bottom: 1px;" >
			<thead class="bg-gray-100">
				<tr style="color:white; background-color: #5107B0; text-align: center;" >
					<th class="text-xs font-weight-semibold opacity-7" style="width: 5%; ">번호</th>
					<th class="text-xs font-weight-semibold opacity-7" style="width: 13%; ">카테고리</th>
					<th class="text-xs font-weight-semibold opacity-7 ps-2" style="width: 35%; ">제목</th>
					<th class="text-xs font-weight-semibold opacity-7 ps-2" style="width: 10%; ">닉네임</th>
					<th class="text-xs font-weight-semibold opacity-7 ps-2" style="width: 20%; ">작성일</th>
					<th class="text-xs font-weight-semibold opacity-7 ps-2" style="width: 7%; ">조회수</th>
				</tr>
			</thead>
			<tbody id="listBody">	
<%-- 			<c:forEach var="vo" items="${boardList }" varStatus="status"> --%>
				<c:forEach var="vo" items="${boardList }">
				
					<tr style="text-align: center;">
						<td><span class="text-sm font-weight-normal">${vo.bno}</span></td>
						<td><div class="my-auto"><h6 class="mb-0 text-sm">${vo.b_ctgr}</h6></div></td>
						<td style="text-align: left;"><a href="/board/read?bno=${vo.bno }&page=${pm.vo.page}">${vo.b_title }</a><!-- </p> -->
							&nbsp; <span style="color: #5107B0; font-size: small;">[${vo.b_cmtcount }]</span> <%-- (${cmtList[status.index] })  --%>
						</td>
						<td>${vo.nick }</td>
						<td><span class="text-sm font-weight-normal">
							<c:choose>
								<c:when test="${vo.b_updatedate eq null }">
									<fmt:formatDate value="${vo.b_regdate }" pattern="YYYY. MM. dd. 💜  HH:mm" />
								</c:when>
								<c:otherwise>
									<fmt:formatDate value="${vo.b_updatedate }" pattern="YYYY. MM. dd. 💜  HH:mm" />
								</c:otherwise>
							</c:choose> 
							</span>
						</td>
						<td><span class="text-sm font-weight-normal">${vo.b_readcount }</span></td>
					</tr>
				
				</c:forEach>
			</tbody>
		</table>
		<div> <button id="addBtn" onclick="moreList();" style="width: 100%; border:none;" >더보기 </button> </div>
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
	
// 	if(result == "MOD_OK"){
// 		success("수정이 완료되었습니다 🥰"); read.jsp 페이지로 옮김
// 	}
	
	if(result == "DEL_OK"){
// 		success("삭제가 완료되었습니다 🥰");
	}
</script>

<%@ include file="../include/footer.jsp"%>