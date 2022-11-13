<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ include file="../include/header.jsp"%>
<!-- ${pageContext.request.contextPath} -->
<script src="https://code.jquery.com/jquery-3.6.0.js"></script>

<div class="section-title">
  <h2><b>공지사항</b></h2>
  
</div>
<!-- End title -->
  
<!-- table -->
<div class="row">
  <div class="col-12">
    <div class="align-items-center mb-3">
      <div class="container">
				 <%if(loginID!=null){ if(loginID.equals("admin")) {%>
				 <button type="button" class="btn" style="background-color: #5107B0; float: right; width: 120px; margin: 0px 10px 10px 0px;"
									onclick="location.href='/notice/write';">
       	   <span class="btn-inner--text" style="color: white;">글쓰기</span>
         </button>
				 <%} }%>
			</div>
				 <div class="px-0 py-0" >
           <div class="container">
         	   <table class="table table-hover" style="box-shadow: 7px 14px 90px 3px rgba(163, 174, 184, 0.7);">
	             <thead>
	               <tr style="text-align: center; color:white; background-color: #5107B0;" >
									 <th class="text-xs font-weight-semibold opacity-7" style="font-weight: normal;">번호</th>
									 <th class="text-xs font-weight-semibold opacity-7" style="width: 50%; font-weight: normal;">제목</th>
									 <th class="text-xs font-weight-semibold opacity-7" style="font-weight: normal;">닉네임</th>
									 <th class="text-xs font-weight-semibold opacity-7" style="font-weight: normal;">작성일</th>
									 <th class="text-xs font-weight-semibold opacity-7" style="font-weight: normal;">조회수</th>
								 </tr>
							 </thead>
							 <tbody>
								 <c:forEach var="list" items="${noticeList }">
								 <tr style="text-align: center;">
									 <td><span class="text-sm font-weight-normal">${list.nno}</span></td>
									 <td> <p class="text-sm font-weight-normal mb-0"><a href="/main/noticeRead?nno=${list.nno }&page=1" style="color: black;	">
									 					${list.n_title }</a></p> </td>
									 <td><b>관리자</b></td>
									 <td> <span  class="text-sm font-weight-normal"></span><fmt:formatDate value="${list.n_regdate }" pattern="YYYY.MM.dd. HH:mm" /> </td>
									 <td><span  class="text-sm font-weight-normal">${list.n_readcount }</span></td>
								 </tr>
							 </c:forEach>
						 </tbody>
					 </table>
				 </div>
			 </div>
		 </div>
   </div>
</div>
<!-- End table -->
	<!-- ===================== 페이징 처리 구간 ========================== -->
	<nav aria-label="Page navigation example">
		<ul class="pagination justify-content-center" >
			<c:if test="${pm.prev }"> 
				<li class="page-item">
					<a class="page-link" aria-label="Previous" style="color:#621fb7;" 
						 href="/main/noticeList?page=${pm.pageStart - 1 }">
						 <span aria-hidden="true"> &laquo;</span>
					</a>
				</li>
			</c:if>
			<c:forEach var="index" begin="${pm.pageStart }" end="${pm.endPage }"> 
				<li class="page-item" ${pm.vo.page == index? 'class=active' : '' }  style="float: left;">
					<a class="page-link" aria-label="Next" style="color:#5107B0;" 
						 href="/main/noticeList?page=${index}"> 
						 <span aria-hidden="true">&nbsp;&nbsp; ${index} &nbsp;&nbsp;</span>
				  </a>
				</li>
			</c:forEach>
			<c:if test="${pm.next }">
				<li><a href="/main/noticeList?page=${pm.endPage + 1 }">&raquo;</a></li>
			</c:if>
		</ul>
	</nav>
	<!-- ===================== 페이징 처리 구간 끝 ========================== -->

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