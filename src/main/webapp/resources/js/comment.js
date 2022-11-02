/**
 * 댓글 기능 구현에 필요한 ,, js파일
 * JavaScript 모듈 패턴~~~ (관련 있는 함수들을 하나의 모듈처럼 묶음으로 구성)
 * >> AJAX 호출 << 담당하는 페이지임!!!!!!!!!!!!!
 */

console.log("============== (comment.js) Comment Module ===============");

var cmtService = (function(){
	
	// 1. 댓글 등록 함수 add
	function add(cmt, callback, error){
		console.log("(ﾉ◕ヮ◕)ﾉ*:･ﾟ✧1.add.............................");
		
		$.ajax({
			type: 'post',
			url: 'comments/new',
			data: JSON.stringify(cmt),
			contentType: "application/json; charset=UTF-8",
			success: function(result, status, xhr){
//				console.log("comments/new 갔다 왔심더");
				if(callback){
					callback(result);
				}
			},
			error: function(xhr, status, er){
				if(error){
					error(er);
				}
			}
		});// ajax
	} // 1. add()
	
	
	// 2. 특정 게시물 댓글 목록 출력 함수 getCmtList
	function getCmtList(param, callback, error){
		console.log("(ﾉ◕ヮ◕)ﾉ*:･ﾟ✧2.getCmtList.............................");
		
		// param 객체를 통해 필요한 파라메타 전달받아서 json 목록 호출
		var bno = param.bno;
		var page = param.page || 1;
		
		$.getJSON("/board/comments/list/"+bno+"/"+page+".json",
				function(rData){
					if(callback) {
						callback(rData);
					}
				}).fail(function(xhr, status, err){
					if(error){
						error();
					}
				});// fail()
	}// 2. getCmtList()
	
	
	// 3. 댓글 삭제 함수 deleteCmt
	function deleteCmt(cno, callback, error){
		console.log("(ﾉ◕ヮ◕)ﾉ*:･ﾟ✧3.deleteCmt.............................");
		$.ajax({
			type: 'delete', // get, post,, 가 아니고!!
			url: 'comments/'+cno,
				// 앞에 /붙이고 comments 하니까,, :8088/comments
				// 안 붙이고    comments 하니까,, :8088/board/comments
			success: function(deleteResult, status, xhr){
				if (callback) {
					callback(deleteResult);
				}
			},
			error: function(xhr, status, er){
				if (error) {
					error(er);
				}
			}
		});// ajax
	}// 3. deleteCmt()
	
	
	// 4. 댓글 수정 함수 updateCmt
	function updateCmt(cmtVO, callback, error){
		console.log("(ﾉ◕ヮ◕)ﾉ*:･ﾟ✧4.updateCmt.............................");
		console.log("cno: " + cmtVO.cno);
		
		$.ajax({
			type: 'put'/*, 'patch'*/,
			url: 'comments/'+cmtVO.cno,
			data: JSON.stringify(cmtVO), // 가져갈(=수정할) 데이터
			contentType: "application/json; charset=UTF-8",
			success: function(rData, status, xhr){
				if(callback){
					callback(rData);
				}
			},
			error: function(xhr, status, er){
				if(error){
					error(er);
				}
			}
		});// ajax
	}// 4. updateCmt()
	
	
	// 5. 특정 댓글 조회 함수 getCmtOne()
	function getCmtOne(cno, callback, error){
		console.log("(ﾉ◕ヮ◕)ﾉ*:･ﾟ✧5.getCmtOne.............................");
		$.get("/board/comments/"+cno+".json", function(rData){
			if(callback){
				callback(rData);
			}
		}).fail(function(xhr, status, err){
			if(error){
				error(); // error일 때는 er,,,  fail로 쓸 때는 err+인수 X   왜지??
			}
		})
	}// 5. getCmtOne()
	
	
	// 6. 시간 처리 함수 displayTime()
	//    24시간이 지난 댓글은 날짜만 표시 / 24시간 이내의 글은 시간으로 표시
	//   얘를 왜 인식을 못하지??????????????? 
	function displayTime(timeValue){
		console.log("(ﾉ◕ヮ◕)ﾉ*:･ﾟ✧6.displayTime.............................");
		alert('displayTime() 호출됨');
		
		var today = new Date();
		var gap = today.getTime() - timeValue;
		var dateObj = new Date(timeValue); // 작성일시 여기 담김
		var str = "";
		
		if(gap < (1000 * 60 * 60 * 24)) {
			// 오늘 시간 - 작성 일시 = gap이 24시간보다 작으면~ = 24시간 지나기 전이면~~ 
			var hh = dateObj.getHours();
			var mi = dateObj.getMinutes();
			var ss = dateObj.getSeconds();
			
			return [(hh > 9 ? '' : '0') + hh, ':',
					(mi > 9 ? '' : '0') + mi, ':',
					(ss > 9 ? '' : '0') + ss ].join('');
		} else {
			var yy = dateObj.getFullYear();
			var mm = dateObj.getMonth() + 1; // 0부터 시작이라
			var dd = dateObj.getDate();
			
			return [ yy, '/', 
					(mm > 9 ? '' : '0') + mm, '/',
					(dd > 9 ? '' : '0') + dd ].join('');
		} // if-else
	}// 6. displayTime()
	
	
	// ======================================================
	return {
		// 1
		add : add,
		
		// 2
		getCmtList : getCmtList,
		
		// 3
		deleteCmt : deleteCmt,
		
		// 4
		updateCmt : updateCmt,
		
		// 5
		getCmtOne : getCmtOne
		
	};// return
	
})();