import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.bora.domain.BoardVO;
import com.bora.domain.CommentVO;
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
	
	
	// 댓글 테스트 ===============================================
	@Test
	public void 댓글쓰기() throws Exception {
		log.info("댓글쓰기(●'◡'●) 호출됨");
		
		CommentVO vo = new CommentVO();
		
		int cno = cdao.countCno();
		
		vo.setCno(cno);
		vo.setId("ghgh");
		vo.setBno(1);
		vo.setC_content("첫번째,, 댓글~~~");
		cdao.insertCmt(vo);
		
		log.info("댓글쓰기(●'◡'●) vo: " + vo);
		
	}
	
	
	
	
	
} // class BoardDAOTest
