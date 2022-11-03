<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ include file="../include/header.jsp"%>
<!-- ${pageContext.request.contextPath} -->
<script src="https://code.jquery.com/jquery-3.6.0.js"></script>

<!-- 모달 스타일 ============================== -->
<meta name="viewport" content="width=device-width, initial-scale=1" />
<style>
/* 화면 전체를 어둡게 만들어주는 배경 */
.background {
	position: fixed;
	top: 0;
	left: 0;
	width: 100%;
	height: 100vh;
	background-color: rgba(0, 0, 0, 0.3);
	z-index: 1000;
	/* 숨기기 */
	z-index: -1;
	opacity: 0;
}

.show {
	opacity: 1;
	z-index: 1000;
	transition: all 0.5s;
}

/* 모달 팝업을 감싸주는 창 */
.modal-window {
	position: relative;
	width: 100%;
	height: 100%;
}

/* 모달 팝업의 내용을 나타내는 팝업 */
.modal-content {
	position: absolute;
	top: 50%;
	left: 50%;
	transform: translate(-50%, -50%);
	background-color: #ffffff;
	box-shadow: 0 2px 7px rgba(0, 0, 0, 0.3);
	width: 500px;
	height: 500px;
	/* 초기에 약간 아래에 배치 */
	transform: translate(-50%, -40%);
}

.show .modal-content {
	transform: translate(-50%, -50%);
	transition: all 0.5s;
}
</style>
<!-- 모달 스타일 끝 ============================== -->


<h1>board/read.jsp</h1>

<%-- 
<%
	if (loginID == null) {
%>
<script>
	alert("세션값이 만료되어 로그인 페이지로 이동합니다.");
	location.href = "/member/login";
</script>
<%
	}
%>
 --%>

<!-- ======== for 썸머노트 ============== -->
<script src="https://cdn.jsdelivr.net/npm/jquery@3.6.1/dist/jquery.min.js"></script>
<script type="text/javascript">
	$(document).ready(function() {
		$('#summernote').summernote({
			height : 300, // 에디터 높이
			width : 1000,
			minHeight : null, // 최소 높이
			maxHeight : null, // 최대 높이
			focus : true, // 에디터 로딩후 포커스를 맞출지 여부
			lang : "ko-KR", // 한글 설정
			placeholder : '최대 2048자까지 쓸 수 있습니다' //placeholder 설정
		});
	});
</script>
<script src="${pageContext.request.contextPath}/resources/js/summernote/summernote-lite.js"></script>
<script src="${pageContext.request.contextPath}/resources/js/summernote/lang/summernote-ko-KR.js"></script>
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/summernote/summernote-lite.css">
<!-- ======== for 썸머노트 끝 ============== -->



<!-- ======= for 댓글,, comment.js 파일 추가 및 ajax, jquery 작업 ======= -->
<script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/comment.js"></script>
<script type="text/javascript">
$(document).ready(function(){
	// 계속 쓸 놈들 ---------------------
	var loginID = '<c:out value="${loginID}"/>';
	var bnoValue = '<c:out value="${vo.bno}"/>';
	
	
	// 댓글 목록 출력 ----------------------------
	var cmtUL = $('#cmtUL');

	showCmtList(1);
	
	function showCmtList(page){
// 		alert("showCmtList 작동 성공");

		// 댓글 목록 출력 함수 2.getCmtList
		cmtService.getCmtList({bno:bnoValue, page:page||1}, function(list){
			var str="";
			
			if( list == null || list.length == 0 ) {
				cmtUL.html("");
				return;
			}
			
			// 반복문 돌면서 댓글 list 채우기
			for (var i = 0, len = list.length||0; i < len; i++) {
				str += "<li id='cmtLI' data-cno='"+list[i].cno+"'>";
				str += "<div id='cmt-body'><div id='cmt-header'><strong>"+list[i].id+"</strong>&nbsp;&nbsp;";
				str += "<small>"+cmtService.displayTime(list[i].c_regdate)+"</small>";
					if (list[i].id == loginID || list[i].id == 'admin') {
						// id가 admin이거나 본인일 때만 -> 답글, 수정, 삭제 버턴 나오게 제어
						str += "<input type='button' value='답글' class='btn btn-primary' id='cmt_btn_re'>";
						str += "<input type='button' value='수정' class='btn btn-primary' id='cmt_btn_mod'>";
						str += "<input type='button' value='삭제' class='btn btn-primary' id='cmt_btn_del'>";
						str += "<input type='text' value='"+list[i].cno+"' id='cnoValue'></div>";
					}
				str += "<p id='cmt_p'>"+list[i].c_content+"</p>";
				str += "</div></li>";
				
			} // for
			
			cmtUL.html(str);
			
		}); // 2.getCmtList()
	}// showCmtList()
	// 댓글 목록 출력 끝 ----------------------------
	
	
 	// 모달 띄우기 (새 댓글 등록 버튼 누르면 입력에 필요없는 항목들은 안 보이게 처리)
// 	var modal = $(".modal");
	var modalInputReply = $('#modal_cmt').val();
	var modalInputReplyer = $('#modal_id').val();
	var modalInputReplyDate = $('#modal_regdate').val();
	
	var modalModBtn = $("#modalModBtn");
	var modalRemoveBtn = $("#modalRemoveBtn");
	var modalRegisterBtn = $("#modalRegisterBtn");
	
// 	$("#modal-show").on("click", function(e){
// 		alert("되나~~");
// 		modal.find("input").val("");
// 		modalInputReplyDate.closest("div").hide();
// 		modal.find("button[id !='modalCloseBtn']").hide();
		
// 		modalRegisterBtn.show();
		
// 		$(".modal").modal("show");
// 	});
	// 모달 띄우기 끝 -------------------------------
	
	
	// 댓글 작성 -------------------------------
	var cmtRegisterBtn = $("#add_cmt_btn");
	
	cmtRegisterBtn.on("click", function(e){
		
		if($('#c_content').val() == null || $('#c_content').val() == ''){
			alert("댓글 내용을 작성해주세요");
			$('#c_content').focus();
			return false;
		}
		
		var cmt = {
			c_content: $('#c_content').val(),
			id: loginID,
			bno: bnoValue
		};
		
		
		// 댓글 등록 함수 1.add(cmt, callback, error) 호출
		cmtService.add(
				// cmt
				cmt, 
				// callback
				function(addResult){
					console.log("addResult: " + addResult);
					
					if(addResult === "success") {
						alert("댓글이 등록되었습니다 👍 ");
					}
					
					$('#c_content').focus();
					$('#c_content').val = ''; // remove? ㅠ
					
					showCmtList(1);
					
					// 작성 후에 빈칸으로
// 					document.getElementById("#c_content").value=''; 
					// 얘 하니까 밑에도 안 먹고,, 거 참
					
		}); // 1.add()
		
// 		} else {
// 			alert("댓글 내용을 작성해주세요");
// 			$('#c_content').focus();
// 			return false;
// 		} // if-else
			
	});// cmtRegisterBtn on click
	// 댓글 작성 끝 -------------------------------
	
	
	// 댓글 삭제 -------------------------------
// 	cmtDelBtn.on("click", function(e){ // 버턴이 먹지를 않노 ㄱ-
	$(document).on("click", "#cmt_btn_del", function(){
// 		alert("삭제 버턴 클릭됨");
		// cno는?  삭제 버턴(this) -> 다음 요소의 value값.. 이게 최선?ㅠ
		var cnoValue = $(this).next().val();
		console.log("삭제할 cnoValue: " + cnoValue);
		
		// 삭제 버튼 클릭했을 때~ 
		// 댓글 삭제 함수 3. deleteCmt(cno, callback, error) 호출
		cmtService.deleteCmt(
			// cno
			cnoValue,
			// callback
			function(deleteResult){
				console.log("deleteResult: " + deleteResult);
		
				if(deleteResult === "success") {
					alert("댓글이 삭제되었습니다 👍 ");
				}
				
				showCmtList(1);
			}, 
			// error
			function(error){
				alert("삭제 실패...... ");
			}
		);// 3.deleteCmt()
	}); // cmtDelBtn on click
	// 댓글 삭제 끝 -------------------------------
	
	
	// 댓글 수정 -------------------------------
	function updateCmtForm(cnoValue, c_content){
		alert("updateCmtForm 함수 실행됨 cno: " + cnoValue + " / c_content: " + c_content);
		
// 		var cmtPcno = $('"#cmt_p"+cnoValue+');
		
		var commentsView = "";
		
		commentsView += "<textarea name='content' id='c_content'"+cnoValue+" cols='30' rows='5' class=''>"+c_content+"</textarea>";
		commentsView += "<div><input type='button' value='수정하기' class='btn' id='real_mod_btn'";
		commentsView += "</div>";
        
		
		$('#cmt_p').replaceWith(commentsView);
// 		cmtPcno.replaceWith(commentsView);
		
	}// updateCmtForm()
	
	
	$(document).on("click", "#cmt_btn_mod", function(){
		alert("수정 버턴 클릭");
		var cnoValue = $(this).next().next().val();
		var c_content = $('#cmt_p').text();
// 		var c_content = $(this).next().next().next().val();
		alert("cnoValue: " + cnoValue + " / c_content: " + c_content);
		
		// 함수 호출
		updateCmtForm(cnoValue, c_content);
		
		// 수정 버튼 클릭 -> div li data-cno [i] 에 해당하는 div가 -> 입력할 수 있는 form으로 replace됨
		// 그 입력폼에서 수정 내용 적고 수정 버튼 또 클릭 -> cno, bno, 수정 내용 받아감
		// -> DB 가서 수정 반영하고, 목록 갱신 함 해서 수정한 내용으로 보이도록..
		
		$('#real_mod_btn').click(function(){
			alert("찐 수정버턴 클릭됨");
			alert("cnoValue: " + cnoValue + " / bnoValue: " + bnoValue + " / c_content: " +  $('#c_content').val());
			//4. updateCmt(cmtVO, callback, error)
			cmtService.updateCmt(
					// cmtVO
					{ cno : cnoValue,
					  bno : bnoValue,
					  c_content : $('#c_content').val()},
					  	// 이모티콘은 안 되네 ㄱ- 
					
					// callback
					function(rData){
						alert("댓글 수정 완");
						
						showCmtList(1);
					}
			);// updateCmt()
			
			
		});// 찐 수정버튼 click
		
	});// on click
	// 댓글 수정 끝 -------------------------------
	
	
	// 모달로 댓글 하나 조회 ----------------------------
	//   ul  -> li로 위임
// 	$('#cmt').on("click", "li", function(e){
// 		var cno = $(this).data("cno");
// 		alert(cno);
		
// 		cmtService.getCmtOne(cno, function(rData){
// 			modalInputReply.val(rData.c_content);
// 			modalInputReplyer.val(rData.id);
// 			modalInputReplyDate.val(rData.c_regdate);
// 			modal.attr("readonly", "readonly");
// 			document.querySelector("#modal-show").addEventListener("click", modalShow);
// 		});

// 	}); // on 
	// 모달로 댓글 하나 조회 끝 ----------------------------
	
	
}); // jquery ready

</script>
<!-- ======= for 댓글,, comment.js 파일 추가 및 ajax, jquery 작업 끝 ======= -->




<h1>${vo.bno }번 글 🐱🐶 상세 보기 🐱🐶 </h1>

		<!-- 수정, 삭제 시 필요한 글 번호(bno) 저장하는 폼태그 =====================-->
		<form role="bno_form" method="post">
			<input type="hidden" name="bno" value="${vo.bno }">
		</form>
		<!-- 수정, 삭제 시 필요한 글 번호(bno) 저장하는 폼태그 껏 =====================-->

	<div>
		<div>
			아이디
			<div>  <!-- hidden으로 바꾸기!!!  -->
				<input type="text" name="id" value="${vo.id}" readonly>
			</div>
		</div>
		<br>
		<div>
			닉네임
			<div>
				<input type="text" value="${nick }" readonly>
			</div>
			<!-- 		닉네임,, 아이디 -> 닉네임 끌어오는 메서드를 만들어야 하남? DB에 넣을 필욘 없고 걍 보여주기만 -->
		</div>
		<br>
		<div>
			카테고리
			<div>
				<input type="text" value="${vo.b_ctgr }" readonly></span>
			</div>
		</div>
		<br>
		<div>
			제목
			<div>
				<input type="text" name="b_title" value="${vo.b_title }" readonly>
			</div>
		</div>
		<br>
		<div>
			내용
			<textarea id="summernote" name="b_content" readonly> ${vo.b_content }</textarea>
		</div>
		<br>
		<div>
			파일
			<div>
				<input type="text" name="b_file" value="${vo.b_file }" readonly>
			</div>
		</div>
		<br>
		<div>
			<input type="button" value="수정" class="btn_mod">
			<input type="button" value="삭제" class="btn_del">
			<input type="button" value="목록" class="btn_list">
		</div>
	</div>
	
	
	<!-- ----------------------- 댓글 리스트 구간 --------------------------------- -->
	<div style="border: 1px solid black">
		<div>
			<h3>댓글</h3>
		</div>
		<ul id="cmtUL">
			<li data-cno="">
				<div id="cmt-body">
					<div id="cmt-header">
						<strong> id,, 말고 nick </strong> <small> c_regdate </small>
						<input type="button" value="답글" class="btn" id="cmt_btn_re">
						<input type="button" value="수정" class="btn" id="cmt_btn_mod">
						<input type="button" value="삭제" class="btn" id="cmt_btn_del">
						<input type="hidden" value="" id="cnoValue">
					</div>
					<p>c_content</p>
				</div>
			</li>
		</ul>
	</div>
	<!-- ----------------------- 댓글 리스트 구간 끝^^ --------------------------------- -->

<!-- ----------------------- 댓글 작성 구간^^ --------------------------------- -->
<div style="border: 1px solid black;">
	<h3>댓글을 남겨주세요 👇👇</h3>
	<div class="form-group">
		<label for="message">내용</label>
		<textarea name="content" id="c_content" cols="30" rows="5" class=""></textarea>
	</div>
	<div class="btn btn-primary">
		<input type="button" value="댓글 달기😘" class="btn btn-primary"
			id="add_cmt_btn">
	</div>
</div>

<!-- ----------------------- 댓글 작성 구간 끝^^ --------------------------------- -->
<!--  모달로 댓글 쓸라고 했는ㄷㅔ^^ ㄷ안되네 -->
<hr>
<h3>모달 도전</h3>
<div class="panel-heading">
<!-- 	<button id='addReplyBtn' class='btn btn-primary'> (가짜임)댓글 쓰기</button> -->
</div>

<!-- 모달 자스 ============================== -->
<button id="modal-show" class='btn btn-primary'>모달로 댓글 쓰기!!!!!</button>

<div class="background" id="myModal">
	<div class="modal-window">
		<div class="modal-content">
			<!--           <button id="close">팝업닫기</button> -->
			<div class="modal-header">
				<!-- 				<button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button> -->
				<h4 class="modal-title" id="myModalLabel">REPLY M0DAL</h4>
			</div>

			<div class="modal-body">
				<div class="form-group">
					<label>닉네임</label> <input class="form-control" name="id"
						value="${loginID}" id="modal_id">
				</div>
				<div class="form-group">
					<label>내용</label> <input class="form-control" name="c_content"
						value="NewReply!!!!" id="modal_cmt">
				</div>
				<div class="form-group">
					<label>작성일시</label> <input class="form-control" name="c_regdate"
						value="" id="modal_regdate">
				</div>
			</div>
			<!-- /.modal-body -->

			<div class="modal-footer">
				<button id="modalModBtn" type="button" class="btn btn-warning"> 수정</button>
				<button id="modalRemoveBtn" type="button" class="btn btn-danger"> 삭제 </button>
				<button id="modalCloseBtn" type="button" class="btn btn-default"
					data-dismiss="modal">닫기</button>
			</div>
			<!-- /.modal-footer -->

		</div>
		<!-- /.modal-content -->

	</div>
	<!-- /.modal-window -->
</div>
<!-- /.background -->


<script>
	function modalShow() {
		document.querySelector(".background").className = "background show";
	}

	function modalClose() {
		document.querySelector(".background").className = "background";
	}

	document.querySelector("#modal-show").addEventListener("click", modalShow);
	document.querySelector("#modalCloseBtn").addEventListener("click", modalClose);
</script>

<!-- 모달 자스 끝 ============================== -->





<script type="text/javascript">
	// jQuery 구간 시작~ =================================================
	$(document).ready(function() {
		// 	  alert('jQuery 실행🎊🎊');
		// 버턴들 제어할 거!!!!!!!!!!!!

		// 글번호 정보를 포함하는 폼태그에 접근
		var fr = $('form[role="bno_form"]'); // role이 form인 폼태그에 접근해서 그걸 fr 변수에 담기

		$(".btn_mod").click(function() {
			// 		  alert('정상 동작 중');
			// bno폼태그 속성 바꿀 거!!
			fr.attr("action", "/board/update");
			fr.attr("method", "get"); // get방식으로 바꿔서 전달 
			fr.submit(); // 클릭하면? 속성 바꾸고 -> submit 되게~~
		});// 수정 버턴 click

		$(".btn_list").click(function() {
			// 목록 버턴 클릭했을 때
			history.back();
		});// 목록 버턴 click

		$(".btn_del").click(function() {
			// 삭제 버턴 클릭했을 때~~
			alert('삭제 버턴 클릭됨');
			fr.attr("action", "/board/delete");
			fr.submit(); // 클릭하면? 속성 바꾸고 -> submit 되게~~
		});// 삭제 버튼 click

	});// jQuery ready
</script>

<%@ include file="../include/footer.jsp"%>