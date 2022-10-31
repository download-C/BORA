package com.bora.controller;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bora.domain.CommentVO;
import com.bora.service.CommentService;

@RestController
@RequestMapping("/comments/*")
public class CommentController {
	// 멤버변수 ================================== 
	private static final Logger log = LoggerFactory.getLogger(CommentController.class);
	
	@Autowired
	CommentService service;
	// 멤버변수 끝 ================================== 
	
	
	
	// 1. 댓글 쓰기
	//  http://localhost:8088/comments/new
	@PostMapping(value = "/new", consumes = "application/json", produces = { MediaType.TEXT_PLAIN_VALUE })
	//   post 방식으로만 동작하도록    ㄴjson 방식의 데이터만 처리하도록        ㄴ문자열 반환하도록
	public ResponseEntity<String> insertCmt(@RequestBody CommentVO vo) throws Exception {
								// @RequestBody:  json 데이터를 --> CommentVO타입으로 변환하도록 지정
		log.info("(ﾉ◕ヮ◕)ﾉ*:･ﾟ✧1.insertCmt(vo)  호출됨");
		
		log.info("(ﾉ◕ヮ◕)ﾉ*:･ﾟ✧1.insertCmt(vo)  서비스 호출할게요");
		int inCount = service.insertCmt(vo);
		log.info("(ﾉ◕ヮ◕)ﾉ*:･ﾟ✧1.insertCmt(vo)  리턴받은 결과 insertCount: " + inCount + " / CommentVO: " + vo);
		
		// 삼항 연산자 처리
		//   insertCount가 1이면~ OK (댓글쓰기 성공) / 아니면~ 에러 (댓글쓰기 실패)
		return inCount == 1 ? new ResponseEntity<>("success", HttpStatus.OK) : 
							 new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
	}
	// 1. 댓글 쓰기 끝
	
	
	
	
	
	// 2. 특정 댓글 읽기
	
	
	// 3. 댓글 삭제
	
	
	// 4. 댓글 수정
	
	
	// 5. 댓글 목록 +페이징 처리
	
	
} // class CommentController
