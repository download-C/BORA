<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ include file="../include/header.jsp"%>
<!-- ${pageContext.request.contextPath} -->
<script src="https://code.jquery.com/jquery-3.6.0.js"></script>
<h1> </h1>



<!-- alert 대신 사용할 모달 버튼 script 소스 (필수) -->
<script src="https://cdn.jsdelivr.net/npm/sweetalert2@9"></script>
<script src="https://cdn.jsdelivr.net/npm/promise-polyfill@7.1.0/dist/promise.min.js"></script>

    <script>
		//기본 메시지 출력
        function basic() {
            Swal.fire('기본 메세지 출력')
        }//기본 메시지 출력
		
		//error 버튼
        function error() {
            Swal.fire({
                title: 'Error!', /*상단 타이틀*/
                text: '다시 확인해주세요', /*내용*/
                icon: 'error', /*아이콘 타입*/
                confirmButtonText: '닫기' /*확인버튼 클가*/
            });
        }//error 버튼
		
        //question 버튼
        function question() {
            Swal.fire(
                '게시글 수정',
                '게시글을 수정하시겠습니까?',
                'question' /*디자인 타입*/
            )
        }//question 버튼
        
    	//info 버튼
    	function info() {
            Swal.fire(
                '확인',
                '입력하신게 맞습니까?',
                'info' /*디자인 타입*/
            )
        }//info 버튼
    	
        //success 버튼
        function success() {
        	let message = "${msg}";
            Swal.fire(
                message,
                '수정되었습니다?',
                'success' /*디자인 타입*/
            )
        }//success 버튼
        
        //warning 버튼
		function warning() {
            Swal.fire(
                '경고',
                '정말 하시겠습니까?',
                'warning' /*디자인 타입*/
            )
        }//warning 버튼
        
 		//confirm(예, 아니오 확인) 버튼
        function confirm() {
            Swal.fire({
                title: '타이틀 메시지',
                text: "회원 탈퇴를 하시겠습니까?",
                icon: 'question',
                showCancelButton: true, //cancel 버튼 보이기
                confirmButtonColor: '#3085d6', //confirm 버튼 색깔
                cancelButtonColor: '#d33', //cancel 버튼 색깔
                confirmButtonText: '예',
                cancelButtonText: '아니요',
                reverseButtons: false //버튼 순서 거꾸로 
            }).then((result) => {
                if (result.isConfirmed) {
                    Swal.fire(
                        '회원 탈퇴 완료',
                        '회원 탈퇴가 완료되었습니다.',
                        'success'
                    )
                } else if (result.isDismissed) {
                    Swal.fire(
                        '회원 탈퇴 취소',
                        '회원 탈퇴가 취소되었습니다.',
                        'info'
                    )
                }
            })
        }//confirm(예, 아니오 확인) 버튼
		
		//버튼 배경색 입히는 버튼
        function bora() {
        	Swal.fire({
        		  title: '버튼 외 바탕의 색을 변경하는 버튼',
	        	  width: 600,
    	    	  padding: '3em',
        		  background: '#fff',
        		  backdrop: 'rgba(122, 28, 246, 0.2)' //#7A1CF6에 투명도
       	 });
        }//버튼 배경색 입히는 버튼	

        //이미지 넣기 버튼
        function imgbtn() {
        	Swal.fire({
        		  title: '타이틀',
        		  text: '작은 글씨',
        		  imageUrl: '${pageContext.request.contextPath}/resources/img/coin(turning).gif',
        		  imageWidth: 400,
        		  imageHeight: 200,
        		  imageAlt: 'Custom image',
        		})
        }//버튼 배경색 입히는 버튼	

//         //텍스트를 입력하고 확인하는 버튼 -> 비밀번호 입력 시 사용
        function textbtn() {
        	(async () => {
        		const { value: password } = await Swal.fire({
        		  title: '비밀번호를 입력하시오',
        		  input: 'password',
        		  inputLabel: 'Password',
        		  inputPlaceholder: '비밀번호',
        		  inputAttributes: {
        		    maxlength: 10,
        		    autocapitalize: 'off',
        		    autocorrect: 'off'
        		  }
        		})

        		if (password) {
        		  Swal.fire(`비밀번호 확인 완료 ${password}`)
        		}
//         		else() {
//         			Swal.fire(`비밀번호 불일치`)
//         		}
        		})()
        }//텍스트를 입력하고 확인하는 버튼
// 	//VO에 값 불러와서 비교해야
        
        
        //텍스트를 입력하고 확인하는 버튼2 -> 여러 텍스트 입력, JSON으로 출력
        function textbtn2() {
        	(async () => {
        		const { value: formValues } = await Swal.fire({
        		  title: '다중입력 타이틀',
        		  html:
        		    '<input id="swal-input1" class="swal2-input">' +
        		    '<input id="swal-input2" class="swal2-input">',
        		  focusConfirm: false,
        		  preConfirm: () => {
        		    return [
        		      document.getElementById('swal-input1').value,
        		      document.getElementById('swal-input2').value
        		    ]
        		  }
        		})

        		if (formValues) {
        		  Swal.fire(JSON.stringify(formValues))
        		}

        		})()
        }//텍스트를 입력하고 확인하는 버튼
        
        
        
        </script>

	
<!-- 모달창에서 OK 버튼의 text를 수정하고 싶으면 error 버튼을 참고
	 error 버튼 코드 빼고 다른 버튼의 기본 코드 양식은 동일 -->

    <button onclick="basic()">기본메세지 버튼</button><br>
    <button onclick="error()">error 버튼</button><br>
    <button onclick="question()">question 버튼</button><br>
	<button onclick="info()">info(느낌표) 확인 버튼</button><br>
    <button onclick="success()">success 버튼</button><br>
    <button onclick="warning()">warning 버튼</button><br>
    <button onclick="confirm()">confirm 버튼(예, 아니오 선택)</button><br>
    <button onclick="bora()">bora 버튼</button><br>
    <button onclick="imgbtn()">imgbtn 버튼</button><br>
    <button onclick="textbtn()">textbtn 버튼</button><br>
    <button onclick="textbtn2()">textbtn2 버튼</button><br>


<%@ include file="../include/footer.jsp"%>