<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ include file="../include/header.jsp"%>
<!-- ${pageContext.request.contextPath} -->
<script src="https://code.jquery.com/jquery-3.6.0.js"></script>

<!-- ////////////alert 커스텀//////////// -->
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/limonte-sweetalert2/7.2.0/sweetalert2.min.css">
<script src="https://cdnjs.cloudflare.com/ajax/libs/limonte-sweetalert2/7.2.0/sweetalert2.all.min.js"></script>

<script>
$(document).ready(function() {
    let message = "${msg}";
    if (message != "") {
        alert(message);
    }else {
    }
})

</script>



<!--  카카오지도 API (나중에 about페이지에 아래 코드 이동)  -->
<%-- <%@ include file="../about/map.jsp"%> --%>

<a href='/main/NoticeListPage'>공지사항 목록</a>
<h3><a href='/board/listAll'>커뮤니티 목록</a></h3>


<%@ include file="../include/footer.jsp"%>