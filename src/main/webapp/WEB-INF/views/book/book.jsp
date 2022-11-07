<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ include file="../include/header.jsp"%>
<!-- ${pageContext.request.contextPath} -->
<script src="https://code.jquery.com/jquery-3.6.0.js"></script>
<script src="https://cdn.jsdelivr.net/npm/sweetalert2@9"></script>
<script src="https://cdn.jsdelivr.net/npm/promise-polyfill@7.1.0/dist/promise.min.js"></script>
<%
if(session!=null){
	String loginid = (String)session.getAttribute("loginID");
}

%>
<script type="text/javascript">


$(document).ready(function() {
	
	function month(){
	 var date = new Date();
	 var month = date.getMonth()+1;//월
	 
	 return month;
	};
 

$('#btn1').click(function(){
    	  alert("버튼1"); -확인
// 		$.ajax({
// 			url:'3개월 평균 지출 페이지.jsp',
// 			success: function(rdata){
// 				$('#div1').html(rdata);
// 			}
// 		});  
    });
    
$('#btn2').click(function(){
	  alert("버튼2"); -확인
//	$.ajax({
//		url:'지난달 지출 총 합계 페이지.jsp',
//		success: function(rdata){
//			$('#div2').html(rdata);
//		}
//	});
});

$('#red').click(function(){
	  alert("버튼2");
	  $('#detail').html("전체 내역");
//	$.ajax({
//		url:'지난달 지출 총 합계 페이지.jsp',
//		success: function(rdata){
//			$('#div2').html(rdata);
//		}
//	});
});



      
      $('#month').append(function(){
    	 return  month();
      });
      
      
      
});

</script>



<h1>한 달 예산⏰ </h1>
<%=loginID %>님의 <b><spand id="month"></spand>월</b> 예산💷💶💵💴<br>
<h5> 원💰</h5><br>

이번달 예산의 %만큼 지출했어요 💸<br>

전체 내역🔻<br>


최근 3개월 평균 지출 <input type="button" value="확인하기" id="btn1"><div id="div1"></div> 
지난 달 지출  <input type="button" value="확인하기" id="btn2"> <div id="div2"></div>






<%@ include file="../include/footer.jsp"%>