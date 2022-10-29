package com.bora.persistence;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.bora.domain.BoardVO;


@Repository
public class BoardDAOImpl implements BoardDAO {
	// 멤버변수 ====================================
	private static final Logger log = LoggerFactory.getLogger(BoardDAOImpl.class);
	
	@Autowired
	private SqlSession sqlSession;
	
	private static final String NAMESPACE = "com.bora.mapper.BoardMapper";
	// 멤버변수 끝 ====================================
	
	
	
	// 1. 글쓰기 insertBoard
	@Override
	public void insertBoard(BoardVO vo) throws Exception {
		log.info("insertBoard(●'◡'●)");
//		log.info("(♥♥♥♥♥ 1.insertBoard) jsp -> Controller -> Service 거치면서 vo 잘 받아왔나? :  " + vo);
		
//		log.info("(♥♥♥♥♥ 1.insertBoard) MyBatis.. boardMapper.xml 로 고고링");
		// SQL 실행 객체 == SqlSession 객체~~ 주입 
		//   올인원임~~ (디비 연결 + myBatis + 매퍼 + 자원 해제)
		int result = sqlSession.insert(NAMESPACE+".insertBoard", vo);
		
		if (result > 0) {
			log.info("insertBoard(●'◡'●) 글쓰기 DB 작업 완");
//			log.info("(♥♥♥♥♥ 1.insertBoard) 글쓰기 DB 작업 완^^ 다시 서비스로 가욘");
		}
		
	}
	// 1. 글쓰기 insertBoard 끝
	
	
	
	// 2. 전체 글 목록 조회
	@Override
	public List<BoardVO> getListAll() throws Exception {
		log.info("(♥♥♥♥♥ 2.listAll) Service가 호출함");
		
		// DB가서 글 목록 모든 정보 가져오기
		log.info("(♥♥♥♥♥ 2.listAll) mapper 갈 거");
		List<BoardVO> boardList = sqlSession.selectList(NAMESPACE+".listAll");
		
		log.info("(♥♥♥♥♥ 2.listAll) mapper 가서 DB 처리 하고 왔고요~~ -> Service로 리턴할 거");
		log.info("(♥♥♥♥♥ 2.listAll) 받아온 boardList.size: " + boardList.size());
		
		return boardList;
	}
	// 2. 전체 글 목록 조회 끝
	
	
	/*
	// 2-1. 페이징 처리한 글 목록 조회 page
	@Override
	public List<BoardVO> getListPage(Integer page) throws Exception {
		log.info("(♥♥♥♥♥ 2-1.listPage) Service가 호출함");

		if ( page <= 0 ) {
			page = 1;
		}
		
//		page = (page - 1) * 10; // 한 페이지에 10개씩 보여줄거니까~
		// 1페이지? => 0~9
		// 2페이지 => 10~19
		// 3페이지 => 20~29
		// 4페이지 => 30~39
		
		int pageSize = 30;  // 한 페이지에 30개씩 보여줄거니까~
		page = (page - 1) * pageSize; 
		
		// 근데~~ page랑,, pageSize랑,, 둘 다 가져가야 되는데~ 어떡하쥐
		// map 객체에 담아서!!! 가져가자!!!!
		Map<String, Object> pageObj = new HashMap<String, Object>();
		pageObj.put("page", page);
		pageObj.put("pageSize", pageSize);
		
		
		log.info("(♥♥♥♥♥ 2-1.listPage) mapper.xml 갈 거,, 가서 DB처리 하고 -> 바로 Service로 리턴할 거");
		
//		return sqlSession.selectList(NAMESPACE+".listPage", page);
		return sqlSession.selectList(NAMESPACE+".listPage2", pageObj);
	}
	// 2-1. 페이징 처리한 글 목록 조회 page 끝
	*/
	
	
	/*
	// 2-2. 페이징 처리한 글 목록 조회 VO
	@Override
	public List<BoardVO> getListPage(PageVO vo) throws Exception {
		log.info("(♥♥♥♥♥ 2-2.listPage(vo)) Service가 호출함");
		log.info("(♥♥♥♥♥ 2-2.listPage(vo)) mapper.xml 갈 거,, 가서 DB처리 하고 -> 바로 Service로 리턴할 거");
		return sqlSession.selectList(NAMESPACE+".listPage3", vo);
	}
	// 2-2. 페이징 처리한 글 목록 조회 VO 끝
	*/
	
	
	
	// 3. 글 1개 정보 가져오기 
	@Override
	public BoardVO getBoard(Integer bno) throws Exception {
		log.info("(♥♥♥♥♥ 3.getBoard) Service가 호출함");
//		BoardVO vo = sqlSession.selectOne(NAMESPACE+".read", bno);
							// selectOne? 리턴값은? 매핑된 object다~~ 
							// 뭐가 매핑됐는데? xml 파일에서 resultType에 적어놓은 거~~
							// 그게 뭔데? BoardVO ^^
		log.info("(♥♥♥♥♥ 3.getBoard) mapper 가서 DB 처리 + 동시에~~ Service로 리턴할 거");
		return sqlSession.selectOne(NAMESPACE+".read", bno); 
	}
	// 3. 글 1개 정보 가져오기 끝
	

	
	// 3-1. 조회수 1 증가
	@Override
	public void updateReadCount(Integer bno) throws Exception {
		log.info("(♥♥♥♥♥ 3-1.updateReadCount) Service가 호출함");
		
		log.info("(♥♥♥♥♥ 3-1.updateReadCount) mapper 가서 DB 처리하러..");
		// bno값 받아가서 updateReadCnt라는 쿼리 실행해라~~
		sqlSession.update(NAMESPACE+".updateReadCount", bno);
		
		log.info("(♥♥♥♥♥ 3-1.updateReadCount) mapper 갔다 왔고 --> Service로 간다^^");
	}
	// 3-1. 조회수 1 증가 끝
	
	
	
	// 4-1. 글 수정하기
	@Override
	public Integer updateBoard(BoardVO vo) throws Exception {
		// 초반에는 TEST!!!랑 연결시켜야 함,, 
		// test 존재 목적: 내가 짰던 게 정상적으로 동작하나?
		// 왜 필요? 우리는 서버 환경 상, 로컬에서 동작하니까 데이터가 금방 눈에 잘 보이지만,,
		// 실제 상용 서버는 서버 올리고 내리는 시간에 부담이 있덛라~ 리스크가 있떠라~~ 그니까 테스트 먼저 하는 것
		// 설계만 잘 만들어 놓으면, 아예 따로 작업해도 된다,,!! 기존 MVC는 따로 작업한다 해도, 한 명이 view, DB,, 다 해야 했지만
		// 테스트 사용하면,, 다 조각조각내서 기능 구현해놓고, 기다리다가~~~ 그에 해당하는 뷰 만들어지면 걍 연결만 해주믄 됨,,, 흠~~~???
		log.info("(♥♥♥♥♥ 4-1.updateBoard) Service가 호출함");
		
		log.info("(♥♥♥♥♥ 4-1.updateBoard) mapper 가서 DB 처리하러..");
		int cnt = sqlSession.update(NAMESPACE+".updateBoard", vo);
		// Returns:  int  << The number of rows affected by the update.
		// int로 받으면 되겠넴~~
		
		log.info("(♥♥♥♥♥ 4-1.updateBoard) mapper 갔다 왔고 --> Service로 간다^^  cnt: " + cnt);
		return cnt;
	}
	// 4-1. 글 수정하기 끝
	
	
	
	// 5. 글 삭제하기
	@Override
	public int deleteBoard(int bno) throws Exception {
		log.info("(♥♥♥♥♥ 5.removeBoard) Service가 호출함");
		
		log.info("(♥♥♥♥♥ 5.removeBoard) mapper 가서 DB 처리하러..");
		int cnt = sqlSession.delete(NAMESPACE+".deleteBoard", bno);
		// int로 받으면 되겠넴~~
		
		log.info("(♥♥♥♥♥ 5.removeBoard) mapper 갔다 왔고 --> Service로 간다^^  cnt: " + cnt);
		return cnt;
	}
	// 5. 글 삭제하기 끝
	
	
} // class BoardDAOImpl
