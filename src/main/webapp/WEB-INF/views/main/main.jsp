<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ include file="../include/header.jsp"%>
<!-- ${pageContext.request.contextPath} -->
<script src="https://code.jquery.com/jquery-3.6.0.js"></script>


<!-- 모달창 script --> 
<script src="https://cdn.jsdelivr.net/npm/sweetalert2@9"></script>
<script src="https://cdn.jsdelivr.net/npm/promise-polyfill@7.1.0/dist/promise.min.js"></script>

<!-- 메세지 불러오고 모달창 띄우기 -->
<script>
$(document).ready(function() {
    let message = "${msg}";
    if(message!=""){
		login(message);
    }
})
</script>
<!-- 체크 모달 -->
<script>
function login(message) {
  	Swal.fire({
	  title: message,
	  text: '',
	  imageUrl: '${pageContext.request.contextPath}/resources/img/logo.png',
	  imageWidth: 200,
	  imageHeight: 50,
	  imageAlt: 'Custom image',
   	})
}
</script>






<!--  카카오지도 API (나중에 about페이지에 아래 코드 이동)  -->
<%-- <%@ include file="../about/map.jsp"%> --%>

<a href='/main/NoticeListPage'>공지사항 목록</a>


<%@ include file="../include/footer.jsp"%>