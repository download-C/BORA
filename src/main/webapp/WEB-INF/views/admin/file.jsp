<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ include file="../include/header.jsp"%>
<!-- ${pageContext.request.contextPath} -->
<script src="https://code.jquery.com/jquery-3.6.0.js"></script>
<script src="https://cdn.jsdelivr.net/npm/jquery@3.6.1/dist/jquery.min.js" ></script>
<script type="text/javascript">
var cnt = 1;
function addFile(){
	// 버튼 클릭 시 input file 태그 추가
// 	alert("addFile() 호출");
	$("#filediv").append("<input type='file' name='n_file"+cnt+"'><br>");
	cnt++;
}

$(document).ready(function(){
// 	alert("jQuery 준비 완료");
});
</script>
<!-- 비밀번호 회원정보 수정 시 alert -->
<script>
$(document).ready(function() {
    let message = "${msg}";
    if (message != "") {
        alert(message);
// 		mupdate(message);
    }
});
</script>

<script>
// function mupdate(message) {
//   	Swal.fire({
// 	  title: message,
// 	  text: '',
// 	  padding: '3em',
// 	  confirmButtonColor: '#7A1CF6'
//    	})
// }
</script>


<!-- 태그 적는 곳 -->



<fieldset>
	<form action="/file/upload" method="POST" enctype="multipart/form-data">
		<input type="text" name="id" placeholder="아이디">
		<input type="text" name="email" placeholder="이메일"> <br>
		<input type="file" name="n_file" > <br>
	<hr>
		
		<div id="filediv"></div>
		<input type="submit" value="업로드">
	</form>
	<button onclick="addFile()">파일 업로드 추가</button>
</fieldset>

<!-- 태그 적는 곳 -->


<%@ include file="../include/footer.jsp"%>