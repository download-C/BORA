<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ include file="../include/header.jsp"%>
<!-- ${pageContext.request.contextPath} -->
<script src="https://code.jquery.com/jquery-3.6.0.js"></script>
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
<%@ include file="../about/map.jsp"%>




<%@ include file="../include/footer.jsp"%>