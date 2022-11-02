import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.bora.domain.board.BoardVO;
import com.bora.domain.board.CommentVO;
import com.bora.persistence.BoardDAO;
import com.bora.persistence.CommentDAO;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(
		locations = {"file:src/main/webapp/WEB-INF/spring/root-context.xml"}
		)
public class BoardDAOTest {

	// 멤버변수 ===========================
	private static final Logger log = LoggerFactory.getLogger(BoardDAOTest.class);
	
	@Autowired
	private BoardDAO bdao;
	
	@Autowired
	private CommentDAO cdao;
	// 멤버변수 끝 ===========================
	
	
	
//	@Test  // ㅇㅋ
	public void 테서터확인() {
		log.info("테서터확인(●'◡'●) 호출됨");
	}
	
	
//	@Test  // ㅇㅋ
	public void 글쓰기() throws Exception {
		log.info("글쓰기(●'◡'●) 호출됨");
		
		BoardVO vo = new BoardVO();
		vo.setId("ghgh");
		vo.setB_ctgr("골라줘BORA");
		vo.setB_title("살까요 말까요");
		vo.setB_content("운동화,,, 살까요 말까요??? 흠냐뤼");
		
		bdao.insertBoard(vo);
		
		log.info("글쓰기(●'◡'●) vo: " + vo);
	}
	
	
	// 여기부터 댓글 테스트 ===============================================
//	@Test   // ㅇㅋ
	public void 댓글쓰기() throws Exception {
		log.info("댓글쓰기(●'◡'●) 호출됨");
		
		CommentVO vo = new CommentVO();
		
		int cno = cdao.countCno();
		
		vo.setCno(cno);
		vo.setId("ghgh");
		vo.setBno(2);
		vo.setC_content("안녕하세요???^_^");
		cdao.insertCmt(vo);
		
		log.info("댓글쓰기(●'◡'●) vo: " + vo);
	}
	
	
//	@Test  // ㅇㅋ
	public void 특정댓글읽기() throws Exception {
		log.info("특정댓글읽기(●'◡'●) 호출됨");
		
		CommentVO vo = new CommentVO();
		vo = cdao.getCmtOne(6);
		
		log.info("특정댓글읽기(●'◡'●) vo: " + vo);
	}
	
	
//	@Test  // ㅇㅋ
	public void 댓삭() throws Exception {
		log.info("댓삭(●'◡'●) 호출됨");
		
		CommentVO vo = new CommentVO();
		int result = cdao.deleteCmt(4);
		
		log.info("댓삭(●'◡'●) result: " + result);
		
	}
	
	
//	@Test  // ㅇㅋ
	public void 댓수정() throws Exception {
		log.info("댓수정(●'◡'●) 호출됨");
		
		CommentVO vo = new CommentVO();
		vo.setC_content("수정 수정 다섯번째 댓걸");
		vo.setCno(5);
		int result = cdao.updateCmt(vo);
		
		log.info("댓수정(●'◡'●) result: " + result);
	}
	
	
	@Test   // ㅇㅋ
	public void 댓목록() throws Exception {
		log.info("댓목록(●'◡'●) 호출됨");
		
		List<CommentVO> cmtList = cdao.getCmtList(null, 2);   // 1번 글 댓글 목록
		
		log.info("댓목록(●'◡'●) cmtList.size(): " + cmtList.size());
	}
	
	
	
	
	
} // class BoardDAOTest
