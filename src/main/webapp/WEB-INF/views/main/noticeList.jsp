<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ include file="../include/header.jsp"%>
<!-- ${pageContext.request.contextPath} -->
<script src="https://code.jquery.com/jquery-3.6.0.js"></script>

<script>
$(document).ready(function() {
    let message = "${msg}";
    if (message != "") {
        alert(message);
    }
});
</script>
<h1>
	 <span
		style="color: white; background-color: orange; font-size: 1.5em">
		💐💐list😎😎 </span>.jsp
</h1>
<div>
	<div>
<%-- 		<h5>${pm.pageVO.page }</h5> --%>
		<%if(loginID!=null){ if(loginID.equals("admin")) {%>
		<h3><a href="/notice/write">여기를 눌러서 편하게 글쓰기 하십시오 ^^💘💘 </a></h3>
		<%} }%>
	</div>

	<div>
		<table class="table table-bordered">
			<tbody>
				<tr>
					<th>번호</th>
					<th>제목</th>
					<th>닉네임</th>
					<th>작성일</th>
					<th>조회수</th>
				</tr>
				
				
				<c:forEach var="vo" items="${noticeList }">
				
					<tr>
						<td>${vo.nno}</td>
						<td> <a href="/main/noticeRead?nno=${vo.nno }&page=1">${vo.n_title }</a> </td>
						<td>관리자</td>
						<td> <fmt:formatDate value="${vo.n_regdate }" pattern="YYYY년 MM월 dd일 🌈  HH:mm" /> </td>
						<td>${vo.n_readcount }</td>
					</tr>
				
				</c:forEach>
				
			</tbody>
		</table>
	</div>

	<!-- ===================== 페이징 처리 구간 ========================== -->
	<div>
		<ul type="none">
			
			<!-- 이전 버턴================ -->
			<c:if test="${pm.prev }"> 
					<!--      ㄴboolean 타입이니까 false면 걍 패스되는거~ 음 편하군  -->
				<li><a href="/notice/listPage?page=${pm.startPage - 1 }">&laquo;</a></li>
			</c:if>
			
			<!-- 1 2 3 4 .... ================ -->
			<c:forEach var="index" begin="${pm.startPage }" end="${pm.endPage }"> 
						<!-- 페이지 블럭에서 내가 선택한 현재 페이지만! active되도록 -->
				<%-- 
				<li <c:out value="${pm.vo.page == index? 'class=active' : '' }" />>   2.3버전 이하는 c:out 써야 함~ --%>
				<li ${pm.vo.page == index? 'class=active' : '' }  style="float: left;">
					<a href="/notice/listPage?page=${index+1 }"> &nbsp;&nbsp; ${index+1} &nbsp;&nbsp; </a>
				</li>
			</c:forEach>
			
			<!-- 다음 버턴================ -->
			<c:if test="${pm.next }">
				<li><a href="/notice/listPage?page=${pm.endPage + 1 }">&raquo;</a></li>
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