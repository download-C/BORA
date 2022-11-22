<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ include file="../include/header.jsp"%>
<!-- ${pageContext.request.contextPath} -->
<script src="https://code.jquery.com/jquery-3.6.0.js"></script>
<!-- Template Main CSS File -->
<link href=" ${pageContext.request.contextPath}/resources/css/writeForm.css" rel="stylesheet">
<link href="${pageContext.request.contextPath}/resources/css/style.css" rel="stylesheet">
<%
if(loginID==null) {%>
<!-- 세션값(로그인) 확인 -->
<script>
// 세션값 여부
	info("로그인 필요!", "로그인 페이지로 이동합니다.")
	
	$(document).ready(function() {
	    let message = "${msg}";
	    if (message != "") {
	        info(message);
	    }
	})

//info 버튼
function info(msg1, msg2) {
		Swal.fire({
		     title: msg1, 
		     text: msg2,
		     confirmButtonColor: '#7A1CF6',
		     icon: 'info' /*디자인 타입*/
		    }) 
    setTimeout('location.href="/main/login";', 1500);
}//info 버튼
</script>
<%} %>

<!-- 비밀번호 회원정보 수정 시 alert -->
<script>
$(document).ready(function() {
    let message = "${msg}";
    if (message != "") {
        alert(message);
    }
});
</script>

<script>
$(document).ready(function(){
			
	//preview image 
    var imgTarget = $('#fileBtn');
    
    imgTarget.on('change', function(){
        var thumbnail = $("#thumbnail");        
    
        thumbnail.children('#upload-display').remove();

        if(window.FileReader){
            //image 파일만
            if (!$(this)[0].files[0].type.match(/image\//)) return;
            
            var reader = new FileReader();
            reader.onload = function(e){
            var src = e.target.result;
            thumbnail.prepend('<div id="upload-display" class="wrap-input100 validate-input" style="width: 15%">'+
															'<div class="upload-thumb-wrap" style="max-width: 70px;  text-align: center;">'+
															'<img src="'+src+'"class="upload-thumb" style="max-width: 100%;">'+
															'</div></div>')
            }
            reader.readAsDataURL($(this)[0].files[0]);
        }

        else {
            $(this)[0].select();
            $(this)[0].blur();
            var imgSrc = document.selection.createRange().text;
            thumbnail.prepend('<div id="upload-display" class="wrap-input100 validate-input" style="width: 15%">'+
            									'<div class="upload-thumb-wrap" style="max-width: 70px;  text-align: center;">'+
            									'<img src="'+src+'"class="upload-thumb" style="max-width: 100%;">'+
            									'</div></div>')

            var img = $("#upload-display").find('img');
            img[0].style.filter = "progid:DXImageTransform.Microsoft.AlphaImageLoader(enable='true',sizingMethod='scale',src=\""+imgSrc+"\")";        
        }
    });	
    
	  var fileTarget = $('#fileBtn');

	  fileTarget.on('change', function(){  // 값이 변경되면
	    if(window.FileReader){  // modern browser
	      var filename = $(this)[0].files[0].name;
// 	    	alert(filename);
	    } 
	    else {  // old IE
	      var filename = $(this).val().split('/').pop().split('\\').pop();  // 파일명만 추출
	    }
	    
	    // 추출한 파일명 삽입
	    $('#upload-name').val(filename);
	  });
	});
	
</script>


<!-- form -->
  <div class="container-contact100">
    <div class="wrap-contact100">
			<form action="/notice/update" method="POST" enctype="multipart/form-data" class="contact100-form validate-form">
				<span class="contact100-form-title" style="text-align: center;">
	        <b>공지사항 수정</b>
	      </span>
	     <input type="hidden" value="${vo.nno }" name="nno">
      <div class="wrap-input100 validate-input">
				<input type="text" name="n_title" class="input100" placeholder="공지사항 제목" 
				value="${vo.n_title }" required>
				<span class="focus-input100"></span>
			</div>	
			<div class="wrap-input100 validate-input" >
				<textarea name="n_content" class="input100" required>${vo.n_content }</textarea>
				<span class="focus-input100"></span>
			</div>
			<div id="thumbnail" class="filebox" style="display: flex; justify-content: space-between; flex-flow: row nowrap;">
				<div id="upload-display" class="wrap-input100 validate-input" style="width: 15%">
					<div class="upload-thumb-wrap" style="max-width: 70px;  text-align: center;">
							<img src="${pageContext.request.contextPath}/resources/upload/${vo.n_file}"class="upload-thumb" style="max-width: 100%;">
					</div>
				</div>
				<div class="wrap-input100 validate-input" style="float: left; width: 60%;">
					<input class="input100" id="upload-name" name="uploadFile" value="${vo.n_file }" disabled="disabled">
				</div>
				<div class="btndiv" style="line-height: 100%;">					
					<label class="contact100-form-btn " for="fileBtn" style="min-width:20%; margin-top: 10px;">업로드</label>
					<input type="file" name="uploadFile" class="upload-hidden" id="fileBtn" style="display: none; float: clear;">
				</div>
			</div>
			<div class="container-contact100-form-btn" style="float: clear;">
        <button class="contact100-form-btn" type="submit">
          <b>수정하기</b> 
        </button>
      </div>
		</form>
	</div>
</div>


<!-- 태그 적는 곳 -->


<%@ include file="../include/footer.jsp"%>