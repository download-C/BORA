import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.bora.domain.NoticeVO;
import com.bora.domain.PageVO;
import com.bora.persistence.NoticeDAO;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(
		locations = "file:src/main/webapp/WEB-INF/spring/root-context.xml")
public class NoticeDAOTest {
	
	private static final Logger log = LoggerFactory.getLogger(NoticeDAOTest.class);

	@Autowired
	private NoticeDAO dao;
	
//	@Test
	public void 테스트확인() {
		log.info("♡♡♡♡♡♡♡테스트 확인");
	}
	
//	@Test 완료
	public void 공지사항글쓰기() throws Exception{
		log.info("♡♡♡♡♡♡♡♡♡♡♡♡♡♡♡♡♡♡♡공지사항 글쓰기 테스트");
		NoticeVO vo = new NoticeVO();
//		
//		vo.setNno(1);
//		vo.setNSubject("테스트 제목");
//		vo.setNContent("테스트 내용");
//		vo.setNFile("테스트 파일");
		
		dao.writeNotice(vo);
	}
	
//	@Test 완료
	public void 공지사항업데이트() throws Exception {
		log.info("공지사항 업데이트 테스트");
		NoticeVO vo = new NoticeVO();
//		vo.setNNo(1);
//		vo.setNSubject("수정 제목");
//		vo.setNContent("수정 내용");
		
		dao.updateNotice(1);
	}
	
//	@Test 완료
	public void 공지사항목록() throws Exception {
		log.info("공지사항 목록 테스트");
		PageVO vo = new PageVO();
		vo.setPage(5);
		vo.setPerPageNum(10);
		List<NoticeVO> noticeList = dao.getNoticeList(vo);
		log.info(noticeList+"");
	}
	
//	@Test 완료
	public void 공지사항글가져오기() throws Exception{
		log.info("공지사항글가져오기 테스트");
		log.info(dao.getNotice(1)+"");
	}
	
//	@Test 완료
	public void 공지사항조회수업데이트() throws Exception {
		log.info("공지사항조회수업데이트 테스트");
		NoticeVO vo = dao.getNotice(1);
//		log.info("1번글 조회수 :"+vo.getNReadcount());
//		dao.updateNoticeReadcount(1);
//		NoticeVO vo2 = dao.getNotice(1);
//		log.info("1번글 조회수 업데이트 후 :"+vo2.getNReadcount());
				
	}
	
//	@Test 완료
	public void 공지사항삭제() throws Exception{
		log.info("♡♡♡♡♡♡♡♡♡♡♡♡♡♡♡♡♡♡공지사항삭제 테스트");
		dao.deleteNotice(1);
	}
	
}
