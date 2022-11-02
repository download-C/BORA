package com.bora.controller;


import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.bora.domain.CommentVO;
import com.bora.domain.PageVO;
import com.bora.service.CommentService;

@RestController
//@Controller
@RequestMapping("/board/comments/*")
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
	//       produces??  Ajax의 success: function(result..) << 이 result로 전달할 데이터 타입!!!이 뭐냐~ 문자열이다~
	public ResponseEntity<String> insertCmt(@RequestBody CommentVO vo) throws Exception {
								// @RequestBody:  json 데이터를 --> CommentVO타입으로 변환하도록 지정
		log.info("(ﾉ◕ヮ◕)ﾉ*:･ﾟ✧1.insertCmt(vo)  호출됨");
		log.info("(ﾉ◕ヮ◕)ﾉ*:･ﾟ✧1.insertCmt(vo)  서비스 호출할게요");
		int inCount = service.insertCmt(vo);
		
		log.info("(ﾉ◕ヮ◕)ﾉ*:･ﾟ✧1.insertCmt(vo)  리턴받은 결과 "
				+ "insertCount: " + inCount + " / CommentVO: " + vo);
		
		// 삼항 연산자 처리
		//   insertCount가 1이면~ OK (댓글쓰기 성공) / 아니면~ 에러 (댓글쓰기 실패)
		return inCount == 1 ? new ResponseEntity<>("success", HttpStatus.OK) : 
							 new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
	}
	// 1. 댓글 쓰기 끝

	
	
	// 2. 특정 댓글 조회
	@GetMapping(value = "/{cno}", 
			produces = {MediaType.APPLICATION_XML_VALUE,  // 반환할 타입이 xml, json!!
						MediaType.APPLICATION_JSON_UTF8_VALUE})
	public ResponseEntity<CommentVO> getCmtOne(@PathVariable("cno") int cno) throws Exception {
		log.info("(ﾉ◕ヮ◕)ﾉ*:･ﾟ✧2.getCmtOne(cno)  호출됨");
		log.info("(ﾉ◕ヮ◕)ﾉ*:･ﾟ✧2.getCmtOne(cno)  cno: " + cno);
		
		return new ResponseEntity<>(service.getCmtOne(cno), HttpStatus.OK);
	}
	// 2. 특정 댓글 조회 끝
	
	
	
	// 3. 댓글 삭제
	@DeleteMapping(value = "/{cno}", produces = {MediaType.TEXT_PLAIN_VALUE})
	public ResponseEntity<String> deleteCmt(@PathVariable("cno") int cno) throws Exception {
		log.info("(ﾉ◕ヮ◕)ﾉ*:･ﾟ✧3.deleteCmt(cno)  호출됨");
		log.info("(ﾉ◕ヮ◕)ﾉ*:･ﾟ✧3.deleteCmt(cno)  cno: " + cno);
		
		int delCount = service.deleteCmt(cno);
		
		return delCount == 1 ? new ResponseEntity<>("success", HttpStatus.OK) :
								new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
	}
	// 3. 댓글 삭제 끝
	
	
	
	// 4. 댓글 수정
	@RequestMapping(method = {RequestMethod.PUT, RequestMethod.PATCH}, 
					value = "/{cno}",
					consumes = "application/json",
					produces = {MediaType.TEXT_PLAIN_VALUE})
	public ResponseEntity<String> updateCmt(@RequestBody CommentVO vo, @PathVariable("cno") int cno) throws Exception {
		// json 형태로 전달되는 데이터와 / 파라메타로 전달되는 댓글 번호 cno를 처리하기 위해..
		// 실제 수정되는 데이터는 json 포맷이므로 RequestBody를 이용한 것,, 
		//  (RequestBody로 처리되는 데이터는 일반 파라메타나 @PathVariable로 처리할 수 없어서... 바디니까!! 크니까!!1)
		log.info("(ﾉ◕ヮ◕)ﾉ*:･ﾟ✧4.updateCmt(vo, cno)  호출됨");
		log.info("(ﾉ◕ヮ◕)ﾉ*:･ﾟ✧4.updateCmt(vo, cno)  cno: " + cno);		
		vo.setCno(cno);
		log.info("(ﾉ◕ヮ◕)ﾉ*:･ﾟ✧4.updateCmt(vo, cno)  수정할 vo: " + vo);
		
		int upCount = service.updateCmt(vo);
		
		return upCount == 1? new ResponseEntity<>("success", HttpStatus.OK) :
							new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
	}
	// 4. 댓글 수정 끝
	
	
	
	// 5. 특정 게시물의 댓글 목록 확인
	//  Test   http://localhost:8088/board/comments/list/1/1
	//  Test   http://localhost:8088/board/comments/list/1/1.json
	@GetMapping(value = "/list/{bno}/{page}", 
				produces = {MediaType.APPLICATION_XML_VALUE,  // 반환할 타입이 xml, json!!
							MediaType.APPLICATION_JSON_UTF8_VALUE})
	public ResponseEntity<List<CommentVO>> getCmtList(
			@PathVariable("page") int page,
			@PathVariable("bno") int bno) throws Exception {
		log.info("(ﾉ◕ヮ◕)ﾉ*:･ﾟ✧5.getCmtList(page, bno)  호출됨");
		
		PageVO vo = new PageVO();
		vo.setPage(page);
		log.info("(ﾉ◕ヮ◕)ﾉ*:･ﾟ✧5.getCmtList(page, bno)  PageVO: " + vo + " / bno: " + bno);
		
		return new ResponseEntity<>(service.getCmtList(vo, bno), HttpStatus.OK);
	}
	// 5. 특정 게시물의 댓글 목록 확인 끝
	
	
	
	
} // class CommentController
