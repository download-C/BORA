package com.bora.persistence.board;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.bora.domain.board.BoardVO;
import com.bora.domain.board.PageMakerVO;
import com.bora.domain.board.PageVO;


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
		log.info("(♥♥♥♥♥ 1.insertBoard) 호출됨(●'◡'●)");
		log.info("(♥♥♥♥♥ 1.insertBoard) insert.jsp -> Controller -> Service 거치면서 받아온 vo:  " + vo);
		
		log.info("(♥♥♥♥♥ 1.insertBoard) boardMapper.xml 로 고고");
		int result = sqlSession.insert(NAMESPACE+".insertBoard", vo);
		
		if (result > 0) {
			log.info("(♥♥♥♥♥ 1.insertBoard)(●'◡'●) 글쓰기 DB 작업 완 -> 서비스로 ㄱㄱ");
		}
		
	}
	// 1. 글쓰기 insertBoard 끝
	
	
	
	// 2. 전체 글 목록 조회
//	@Override
//	public List<BoardVO> getBoardListAll() throws Exception {
//		log.info("(♥♥♥♥♥ 2.getBoardListAll) Service가 호출함");
//		
//		// DB가서 글 목록 모든 정보 가져오기
//		log.info("(♥♥♥♥♥ 2.getBoardListAll) mapper 갈 거");
//		List<BoardVO> boardList = sqlSession.selectList(NAMESPACE+".getBoardListAll");
//		
//		log.info("(♥♥♥♥♥ 2.getBoardListAll) mapper 가서 DB 처리 하고 왔고요~~ -> Service로 리턴할 거");
//		log.info("(♥♥♥♥♥ 2.getBoardListAll) 받아온 boardList.size: " + boardList.size());
//		
//		return boardList;
//	}
	// 2. 전체 글 목록 조회 끝
	
	
	/*
	// 2-1. 페이징 처리한 글 목록 조회 page
	@Override
	public List<BoardVO> getBoardListPage(Integer page) throws Exception {
		log.info("(♥♥♥♥♥ 2-1.getBoardList) Service가 호출함");

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
		
		log.info("(♥♥♥♥♥ 2-1.getBoardList) mapper.xml 갈 거,, 가서 DB처리 하고 -> 바로 Service로 리턴할 거");
		
		return sqlSession.selectList(NAMESPACE+".listPage2", pageObj);
	}
	// 2-1. 페이징 처리한 글 목록 조회 page 끝
	*/
	
	
	
	// 2-1. 페이징 처리한 글 목록 조회 VO
	@Override
	public List<BoardVO> getBoardListPage(PageVO vo) throws Exception {
		log.info("(♥♥♥♥♥ 2.getBoardList) Service가 호출함");
		log.info("(♥♥♥♥♥ 2.getBoardList) mapper.xml 갈 거,, 가서 DB처리 하고 -> 바로 Service로 리턴할 거");
		
		return sqlSession.selectList(NAMESPACE+".getBoardListPage", vo);
	}
	// 2-1. 페이징 처리한 글 목록 조회 VO 끝
	
	
	
			// 2-2. 카테고리 글 목록 조회
			@Override
			public List<BoardVO> getBoardListCtgr(String ctgr, Integer startNum) throws Exception {
				log.info("(♥♥♥♥♥ 2-2.getBoardList) Service가 호출함");
				log.info("(♥♥♥♥♥ 2-2.getBoardList) mapper.xml 갈 거,, 가서 DB처리 하고 -> 바로 Service로 리턴할 거");
				log.info("(♥♥♥♥♥ 2-2.getBoardList) ctgr: " + ctgr);
				
				Map<String, Object> map = new HashMap<String, Object>();
				
				map.put("startNum", startNum);
				map.put("b_ctgr", ctgr);
				map.put("cnt", 5); // 글 5개씩 추가되도록
				return sqlSession.selectList(NAMESPACE+".getBoardList_ctgr", map);
			}
			// 2-2. 카테고리 글 목록 조회 끝
	
			
					// 글 개수 count 
					@Override
					public Integer getBoardCnt() throws Exception {
						log.info("getBoardCnt() 호출");
						log.info(sqlSession.selectOne(NAMESPACE+".getBoardCnt")+"");
						return sqlSession.selectOne(NAMESPACE+".getBoardCnt");
					}
					
					@Override
					public Integer getBoardCntCTGR(String b_ctgr) throws Exception {
						log.info("getBoardCntCTGR() 호출");
						return sqlSession.selectOne(NAMESPACE+".getBoardCntCTGR", b_ctgr);
					}
	
	
	
	// 3. 글 1개 정보 가져오기 
	@Override
	public BoardVO getBoard(Integer bno) throws Exception {
		log.info("(♥♥♥♥♥ 3.getBoard) Service가 호출함");
//		BoardVO vo = sqlSession.selectOne(NAMESPACE+".read", bno);
							// selectOne? 리턴값은? 매핑된 object다~~ 
							// 뭐가 매핑됐는데? xml 파일에서 resultType에 적어놓은 거~~
							// 그게 뭔데? BoardVO ^^
		log.info("(♥♥♥♥♥ 3.getBoard) mapper 가서 DB 처리 + 동시에~~ Service로 리턴할 거");
		return sqlSession.selectOne(NAMESPACE+".getBoard", bno); 
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
	public Integer updateBoard(BoardVO vo/* , String id */) throws Exception {
		log.info("(♥♥♥♥♥ 4-1.updateBoard) Service가 호출함");
		
		log.info("(♥♥♥♥♥ 4-1.updateBoard) mapper 가서 DB 처리하러..");
		int cnt = sqlSession.update(NAMESPACE + ".updateBoard", vo/* , id */);
		
		log.info("(♥♥♥♥♥ 4-1.updateBoard) mapper 갔다 왔고 --> Service로 간다^^  cnt: " + cnt);
		return cnt;
	}
	// 4-1. 글 수정하기 끝
	
	
	
	// 5. 글 삭제하기
	@Override
	public Integer deleteBoard(Integer bno/* , String id */) throws Exception {
		log.info("(♥♥♥♥♥ 5.removeBoard) Service가 호출함");
		
		log.info("(♥♥♥♥♥ 5.removeBoard) mapper 가서 DB 처리하러..");
		int cnt = sqlSession.delete(NAMESPACE + ".deleteBoard", bno/* , id */);
		// int로 받으면 되겠넴~~
		
		log.info("(♥♥♥♥♥ 5.removeBoard) mapper 갔다 왔고 --> Service로 간다^^  cnt: " + cnt);
		return cnt;
	}
	// 5. 글 삭제하기 끝

	
	
	// 6. id -> 닉네임 끌고 오기
	@Override
	public String getNick(String id) throws Exception {
		log.info("(♥♥♥♥♥ 6.getNick) 호출됨 / 전달받은 id: " + id);
		
		log.info("(♥♥♥♥♥ 6.getNick) mapper 갔다가 -> service로 바로 리턴");
		
		return sqlSession.selectOne(NAMESPACE+".getNick", id);
	}
	// 6. id -> 닉네임 끌고 오기 끝
	
	
	
	// 7. main에 띄울 최신글 5개 목록 불러오기
	@Override
	public List<BoardVO> getList5() throws Exception {
		log.info("(♥♥♥♥♥ 7.getList5) 호출됨");
		return sqlSession.selectList(NAMESPACE+".getList5");
	}
	// 7. main에 띄울 최신글 5개 목록 불러오기 끝
	
	
	
	
} // class BoardDAOImpl
