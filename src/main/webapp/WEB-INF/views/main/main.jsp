<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ include file="../include/header.jsp"%>
<!-- ${pageContext.request.contextPath} -->
<script src="https://code.jquery.com/jquery-3.6.0.js"></script>

<script src="https://cdn.jsdelivr.net/npm/sweetalert2@9"></script>
<script src="https://cdn.jsdelivr.net/npm/promise-polyfill@7.1.0/dist/promise.min.js"></script>

<!-- 메세지 불러오고 모달 창 띄우기 -->
<script>
$(document).ready(function() {
    let message = "${msg}";
    if(message!=""){
		success(message);
    }

})
</script>
<!-- 체크 모달 -->
<script>
 function success(message) {
     Swal.fire(
         message,
         '',
         'success' /*디자인 타입*/
     )
 }//success 버튼
</script>


<!--  카카오지도 API (나중에 about페이지에 아래 코드 이동)  -->
<%-- <%@ include file="../about/map.jsp"%> --%>

<a href='/main/NoticeListPage'>공지사항 목록</a>


<%@ include file="../include/footer.jsp"%>