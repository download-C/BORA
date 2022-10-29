<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ include file="../include/header.jsp"%>
<!-- ${pageContext.request.contextPath} -->
<script src="https://code.jquery.com/jquery-3.6.0.js"></script>
<h1>
	board/ <span
		style="color: white; background-color: pink; font-size: 2em">
		💐💐list😎😎 </span>.jsp
</h1>
<div class="box">
	<div class="with-border">
		<h3>EL{msg} : ${msg }</h3>
		<h3>페이징 처리 하단부 계산할 때 필요한 애들 가지고 있는 객체 PageMaker.. ↓  </h3>
				<h4>${pm }</h4>
		<h3><a href="/board/insert">여기를 눌러서 편하게 글쓰기 하십시오 ^^💘💘 </a></h3>
<%-- 		<h3>EL{boardList} : ${boardList }</h3> --%>
	</div>

	<div class="box-body">
		<table class="table table-bordered">
			<tbody>
				<tr>
					<th style="width: 45px">번호</th>
					<th>제목</th>
					<th>작성자</th>
					<th>작성일</th>
					<th style="width: 60px">조회수</th>
				</tr>
				
				
				<c:forEach var="vo" items="${boardList }">
				
					<tr>
						<td><span class="badge bg-blue">${vo.bno}</span></td>
						<%-- <td> <span style="font-weight: bold;">제목: </span> ${vo.title} 
							🐱🐱  
							<span style="font-weight: bold;"> 내용: </span> ${vo.content }  </td>  --%>
						<td> <a href="/board/read?bno=${vo.bno }">${vo.title }</a> </td>
						<td>${vo.writer }</td>
						<td> <fmt:formatDate value="${vo.regdate }" pattern="YYYY년 MM월 dd일 🌈  HH:mm" /> </td>
						<td>${vo.viewcnt }</td>
					</tr>
				
				</c:forEach>
				
			</tbody>
		</table>
	</div>

	<!-- ===================== 페이징 처리 구간 ========================== -->
	<div class="box-footer clearfix">
		<ul class="pagination pagination-sm no-margin pull-right">
			
			<!-- 이전 버턴================ -->
			<c:if test="${pm.prev }"> 
					<!--      ㄴboolean 타입이니까 false면 걍 패스되는거~ 음 편하군  -->
				<li><a href="listPage?page=${pm.startPage - 1 }">&laquo;</a></li>
			</c:if>
			
			<!-- 1 2 3 4 .... ================ -->
			<c:forEach var="index" begin="${pm.startPage }" end="${pm.endPage }"> 
						<!-- 페이지 블럭에서 내가 선택한 현재 페이지만! active되도록 -->
				<%-- 
				<li <c:out value="${pm.vo.page == index? 'class=active' : '' }" />>   2.3버전 이하는 c:out 써야 함~ --%>
				<li ${pm.vo.page == index? 'class=active' : '' } >
					<a href="listPage?page=${index }">${index}</a>
				</li>
			</c:forEach>
			
			<!-- 다음 버턴================ -->
			<c:if test="${pm.next }">
				<li><a href="listPage?page=${pm.endPage + 1 }">&raquo;</a></li>
			</c:if>
		</ul>
	</div>
	<!-- ===================== 페이징 처리 구간 ========================== -->
</div>


<script type="text/javascript">
	// alert(${msg});
	var result = "${msg}";
	
	if(result == "OK") {
		alert("글쓰기 완료^^ 감사합ㄴ디ㅏ 🥰🥰");
	}
	
	if(result == "MOD_OK"){
		alert("글 수정 완 🥰");
	}
	
	if(result == "DEL_OK"){
		alert("글 삭제 완 🥰");
	}
</script>


<%@ include file="../include/footer.jsp"%>