<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<!-- header -->
<jsp:include page="../include/header.jsp" />
<!-- header -->

<!-- ##### Breadcrumb Area Start ##### -->
    <div class="breadcrumb-area">
        
        <div class="top-breadcrumb-area bg-img bg-overlay d-flex align-items-center justify-content-center" style="background-image: url(${pageContext.request.contextPath }/resources/img/bg-img/24.jpg);">
            <h2>COMMUNITY</h2>
        </div>
        <div class="container">
            <div class="row">
                <div class="col-12">
                    <nav aria-label="breadcrumb">
                        <ol class="breadcrumb">
                            <li class="breadcrumb-item"><a href="#"><i class="fa fa-home"></i> Home</a></li>
                            <li class="breadcrumb-item active" aria-current="page">Community</li>
                            <li class="breadcrumb-item active" aria-current="page">Content</li>
                        </ol>
                    </nav>
                </div>
            </div>
        </div>
    </div>
<!-- ##### Breadcrumb Area End ##### -->

			<!-- 글 시작@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@ --> 
 			<div class="col-12 col-lg-5">
                    <!-- Section Heading -->
                    <div class="section-heading">
                        <h2>글 상세 페이지</h2>
                        <p>보세용~.~</p>
                    </div> 
                    
                    <!-- 수정, 삭제 시 필요한 글번호 저장 -->
					<form role="form" method="post" id="boardContent">
						<input type="hidden" name="board_num" value="${vo.board_num }">
					</form>
                    
                    
                    <!-- Contact Form Area -->
                    <div class="contact-form-area mb-100">
                            <div class="row">
                            	<div class="col-12 col-md-6">
                                    <div class="form-group">
                                        <input type="text" class="form-control" name="board_num" id="contact-name" placeholder="글번호" value="${vo.board_num }" readonly>
                                    </div>
                                </div>
                                <div class="col-12 col-md-6">
                                    <div class="form-group">
                                        <input type="email" class="form-control" name="board_category" id="contact-email" placeholder="카테고리" value="${vo.board_category }" readonly>
                                    </div>
                                </div>
                                <div class="col-12">
                                    <div class="form-group">
                                        <input type="text" class="form-control" name="title" id="contact-subject" placeholder="Subject" value="${vo.title }" readonly>
                                    </div>
                                </div>
                                <div class="col-12 col-md-6">
                                    <div class="form-group">
                                        <input type="text" class="form-control" name="user_name" id="contact-name" placeholder="글쓴이" value="${vo.user_name }" readonly>
                                    </div>
                                </div>
                                <div class="col-12 col-md-6">
                                    <div class="form-group">
                                   		<fmt:formatDate pattern="yy-MM-dd HH:mm" value="${vo.write_date }"/> &nbsp;&nbsp;&nbsp; 조회수 ${vo.readcount }
                                        <%-- <input type="email" class="form-control" name="write_date" id="contact-email" placeholder="글쓴시간" value="${vo.write_date }"> --%>
                                    </div>
                                </div>
                                <div class="col-12">
                                    <div class="form-group">
                                        <textarea class="form-control" name="content" id="message" cols="30" rows="10" placeholder="글내용" readonly>${vo.content }</textarea>
                                    </div>
                                </div>
                                <div class="col-12">
                                    <button type="submit" class="btn alazea-btn mt-15" id="updateBoard">수정</button>
                                    <button type="submit" class="btn alazea-btn mt-15" id="deleteBoard">삭제</button>
                                    <button type="submit" class="btn alazea-btn mt-15" id="listAll">목록</button>
                                </div>
                                <br>
                                
                                
                                <!-- 댓글 쓰기 -->
                                <div class="col-12">
                                <div class="form-group">
                                <form action="/board/insertReply" method="post">
<%--                                <input type="hidden" name="user_id" value="${sessionScope.loginId }"> --%>
                                	<input type="hidden" name="user_id" value="hh@hhh">
                                	<input type="hidden" name="board_num" value="${vo.board_num }">
                                    <textarea class="form-control" name="reply_content" id="insertReplyContent" cols="30" rows="10" placeholder="댓글을 입력하세요"></textarea>
                               		<input type="submit" class="btn alazea-btn mt-15" id="insertReply" value="댓글쓰기">
                                </form>
                                </div>
                                </div>
                                <br>
                                <br>
                                <br>
                                <hr>
                                
                                <!-- 댓글 리스트 -->
                                <div class="col-12">
                                <div class="form-group" id="replyList">
                                <c:forEach var="replyVO" items="${replyVO }">
                                    <div id="edit_div${replyVO.reply_num }">
                               		<form role="form" method="post" id="boardReply${replyVO.reply_num }">
                                	
                                	<input type="hidden" name="board_num" value="${vo.board_num }">
                                    <input type="hidden" name="reply_num" value="${replyVO.reply_num }">
                                    ${replyVO.user_name } &nbsp;&nbsp;&nbsp; <fmt:formatDate pattern="yy-MM-dd HH:mm" value="${replyVO.reply_updatedate }"/>
                                    <textarea class="form-control" name="reply_content" id="edit_acontent" cols="30" rows="10" placeholder="글내용" readonly>${replyVO.reply_content }</textarea>
                               		</form>
                                    
                                    <button type="button" class="btn alazea-btn mt-15" id="deleteReply" onclick="deleteReply(${replyVO.reply_num })">삭제</button>
                                    <input type="button" class="btn alazea-btn mt-15" id="updateFormReply" onclick="updateReplyFun(${vo.board_num },${replyVO.reply_num },'${replyVO.reply_content }');" value="수정">
                                	</div>
                                </c:forEach>
                                
                                <nav aria-label="Page navigation">
                            		<ul class="pagination">
                            		<c:if test="${pm.prev }">
                                		<li class="page-item"><a class="page-link" href="boardRead?board_num=${vo.board_num }&page=${pm.startPage-1 }"><i class="fa fa-angle-left"></i></a></li>
                           			</c:if>
                            		<c:forEach var="idx" begin="${pm.startPage }" end="${pm.endPage }">
                                		<li class="page-item"><a class="page-link" href="boardRead?board_num=${vo.board_num }&page=${idx }">${idx }</a></li>
                                		<script type="text/javascript">
                                			var page = '<c:out value="${idx}"/>';
                                		</script>
									</c:forEach>
									<c:if test="${pm.next }">
                                		<li class="page-item"><a class="page-link" href="boardRead?board_num=${vo.board_num }&page=${pm.endPage+1 }"><i class="fa fa-angle-right"></i></a></li>
                            		</c:if>
                            		</ul>
                        		</nav>
                                
                                
                                </div>
                                </div>
                                
                                <!-- 로그인 정보가 없으면 수정 삭제 못보게... -->
 <%--                                <c:if test="${!(empty sessionScope.loginID) }">
									<input type="button" value="글쓰기" class="btn" onclick="location.href='${pageContext.request.contextPath}/board/write'">
									 <button type="submit" class="btn alazea-btn mt-15" id="updateBoard">수정</button>
                                    <button type="submit" class="btn alazea-btn mt-15" id="deleteBoard">삭제</button>
								</c:if> --%>
                                
                                
                            </div>
                    </div>
                </div>
			<!-- 글 끝@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@ --> 

 

<!-- <!-- jQuery-2.2.4 js -->
<!-- <script  src="http://code.jquery.com/jquery-3.6.0.min.js"></script> --> 
<script type="text/javascript">

	
	$("#insertReply").click(function(){
		if($('#insertReplyContent').val() == ""){
			alert('내용을 입력하세요!');
			return false;
		}
	});

	// 원본 --------------------------------
	function  (board_num,reply_num,reply_content){
		//alert("함수실행 "+ board_num+",,"+reply_num+",,"+reply_content);
		
 		 var commentsView = "";
 		// var buttonView = "";
		
 		 
 		commentsView += '<form action="/board/updateReply?page='+page+'" method="post" id="boardReply">';
 		 
		commentsView += '<input type="hidden" name="board_num" value="'+board_num+'">';
		commentsView += '<textarea class="form-control" name="reply_content" id="message'+reply_num+'" cols="30" rows="10" placeholder="글내용">';
		commentsView += reply_content;
		commentsView += '</textarea>';
		commentsView += '<input type="hidden" name="reply_num" value="'+reply_num+'">';
		
		
		commentsView += '<input type="submit" class="btn alazea-btn mt-15" id="updateReply" value="완료~">'
 		commentsView += '</form>';
 		
 		
// 		buttonView += '완료'
// 		buttonView += '</button>'
		
        
		
		$('#edit_div' + reply_num).replaceWith(commentsView);
		//$('#edit_button' + reply_num).replaceWith(buttonView);
		$('#message'+reply_num).focus();
	}
	
	
	// 수정 중 -----------------------------------
	function updateReplyFun(cno, c_content){
		//alert("함수실행 "+ board_num+",,"+reply_num+",,"+reply_content);
		
 		 var commentsView = "";
 		// var buttonView = "";
		
 		 
//  		commentsView += "<div id='cmt-body'><div id='cmt-header'><strong>"+list[i].id+"</strong>&nbsp;&nbsp;";
// 		commentsView += "<small>"+cmtService.displayTime(list[i].c_regdate)+"</small>";
// 		commentsView += '<textarea class="form-control" name="reply_content" id="message'+reply_num+'" cols="30" rows="10" placeholder="글내용">';
// 		 		if (list[i].id == loginID || list[i].id == 'admin') {
// 					// id가 admin이거나 본인일 때만 -> 답글, 수정, 삭제 버턴 나오게 제어
// 					commentsView += "<input type='button' value='답글' class='btn btn-primary' id='cmt_btn_re'>";
// 					commentsView += "<input type='button' value='수정' class='btn btn-primary' id='cmt_btn_mod'>";
// 					commentsView += "<input type='button' value='삭제' class='btn btn-primary' id='cmt_btn_del'>";
// 					commentsView += "<input type='hidden' value='"+cno+"' id='cnoValue'></div>";
// 				}
		commentsView += "<textarea name='content' id='c_content' cols='30' rows='5' class=''>c_content</textarea>";
		commentsView += "<div class='btn btn-primary'><input type='button' value='수정하기' class='btn btn-primary' id='mod_cmt_btn'";
		commentsView += "</div>";
        
		
		$('#cmt_p').replaceWith(commentsView);
// 		$('#message'+reply_num).focus();
	}
	
	
	function deleteReply(reply_num){
		var fr2 = $('#boardReply'+reply_num);
		//alert('삭제버튼 클릭');
		
		//fr 속성 바꾸기 action, method
		fr2.attr("action", "/board/deleteReply");
		fr2.attr("method", "get");
		fr2.submit();
	}

	
	$(document).ready(function(){
		//alert('제이쿼리 실행!!');
		
		//글번호 정보를 포함하는 폼태그
		//변수에 담기
		var fr = $('#boardContent');
		
		//수정하기
		$("#updateBoard").click(function(){
			//alert('수정버튼 클릭');
			
			//fr 속성 바꾸기 action, method
			fr.attr("action", "/board/boardModify");
			fr.attr("method", "get");
			//속성을 바꾸고 서브밋하겠다
			fr.submit();
			
		});
		
		//삭제하기
		$("#deleteBoard").click(function(){
			//alert('수정버튼 클릭');
			
			//fr 속성 바꾸기 action, method
			fr.attr("action", "/board/boardDelete");
			fr.attr("method", "get");
			//속성을 바꾸고 서브밋하겠다
			fr.submit();
			
		});
		
		//목록으로 이동하기
		$("#listAll").click(function(){
			location.href="/board/listBoardAll";
		});
		
		

		
	});
	
	
	
/* 	//alert(${msg});
	var result = "${msg}";
	
	
	if(result == "INSERTOK"){
		alert('댓글 쓰기 완료!');
	}
	if(result == "UPDATEOK"){
		alert('댓글 수정 완료!');
	}
	if(result == "DELETEOK"){
		alert('댓글 삭제 완료!');
	}
 */
	
	
	
	
	
</script>




<!-- 푸터들어가는 곳 -->
<jsp:include page="../include/footer.jsp" />
<!-- 푸터들어가는 곳 -->



