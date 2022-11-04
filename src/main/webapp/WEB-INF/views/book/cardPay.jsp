<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ include file="../include/header.jsp"%>
<c:set var="cpath" value ="${pageContext.request.contextPath}"/>
<!-- ${pageContext.request.contextPath} -->
<head>
<script src="https://code.jquery.com/jquery-3.6.0.js"></script>
<script type="text/javascript">
// -------------------체크박스 제어-----------------------------
	 $(document).ready(function() {
		$("#cbx_chkAll").click(function() {
			if ($("#cbx_chkAll").is(":checked"))
				$("input[name=chk]").prop("checked", true);
			else
				$("input[name=chk]").prop("checked", false);
		});

		$("input[name=chk]").click(function() {
			var total = $("input[name=chk]").length;
			var checked = $("input[name=chk]:checked").length;

			if (total != checked)
				$("#cbx_chkAll").prop("checked", false);
			else
				$("#cbx_chkAll").prop("checked", true);
		});
	}); 
	
 /* ---------------AJAX 버전인데 아직 미완성, 필요할 때 살림 -------------- */
	/* function loadJson(){
  		$.ajax({
  			url:"${cpath}/bookCardListAjax",
  			type:"get",
  			dataType:"json",
  			success: ajaxHtml,
  			error:function(){alert("error");}
  		});
  	}
  	
  	function ajaxHtml(data){
  		var html="<table class='table'>";
  		html+="<tr>";
  		html+="<td>안녕</td>";
  		html+="<td>몰라</td>";
  		html+="<td>그냥</td>";
  		html+="<td>나오는지</td>";
  		html+="<td>보고싶은데</td>";
  		html+="<td>될까?</td>";  		
  		html+="</tr>";
  		
  		$.each(data, function(index, obj){ 
  			html+="<tr>";
  	  		html+="<td>"+obj.cpay_date+"</td>";
  	  		html+="<td>"+obj.cardnum+"</td>";
  	  		html+="<td>"+obj.cpay_money+"</td>";
  	  		html+="<td>"+obj.cpay_type+"</td>";
  	  		html+="<td>"+obj.cpay_code+"</td>";
  	  		html+="<td>"+obj.cpay_store+"</td>";
  	  		html+="</tr>";
  		})
  		html+="</table>";
  		
  		$("#bookCardListAjax").html(html);
  	} */
  
</script>
<!---------------------- 로그인 제어 ----------------------->
<%
if(loginID==null) {%>
<script>
	alert("로그인 후 이용 가능한 서비스입니다. 로그인 페이지로 이동합니다.");
	location.href="/main/login";
</script>
<%} %>

</head>
<body>
	<h3>카드내역 불러오기</h3>

	<div class="panel panel-default">
    <div class="panel-heading"><%=loginID %>님의 이번 달 카드내역</div>
    <div class="panel-body">
    	<table class ="table table-hover table-bordered">
    	  <tr>
    	    <td><input type="checkbox" id="cbx_chkAll" /> 전체 선택</td>
    	    <td>카드번호</td>
    	    <td>결제금액</td>
    	    <td>결제내용</td>
    	    <td>소비분류코드</td>
    	    <td>업장명</td>
    	  </tr>

    	  <c:forEach var="vo" items="${list}">
    	  <tr>
    	    <td><input type="checkbox" name="chk"></td>    	 
    	    <td>${vo.card_num}</td>
    	    <td>${vo.cpay_money}</td>
    	    <td>${vo.cpay_type}</td>
    	    <td>${vo.cpay_code}</td>
    	    <td>${vo.cpay_store}</td>
    	  </tr>    	  
    	  </c:forEach>
    	 
    	</table>
    </div>


</body>
</html>

<%@ include file="../include/footer.jsp"%>