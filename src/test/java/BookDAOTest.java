import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.bora.domain.report.BookDetailVO;
import com.bora.domain.report.BookVO;
import com.bora.persistence.report.BookDAO;
import com.bora.service.report.BookServiceImpl;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(
		locations = {"file:src/main/webapp/WEB-INF/spring/root-context.xml"}
		)
public class BookDAOTest {

	@Inject
	BookDAO dao;
	
	@Inject
	SqlSession session;
	
	final static String NAMESPACE = "com.bora.mapper.BookMapper";
	
	private static final Logger log = LoggerFactory.getLogger(BookServiceImpl.class);
	
//	@Test
	public void 테스트() throws Exception {
		log.info("테스트 메서드");
	}
	
	@Test // 성공
	public void admin가계부목록가져오기() throws Exception {
		log.info("admin의 가계부목록가져오기() 호출");
		List<BookVO> bookList = dao.getBookListAll("admin");
		for(BookVO book:bookList) {
			log.info("admin의 가계부 리스트"+book);
		}
	}
	
//	@Test
	public void maxnum() throws Exception{
		log.info("제일 큰 수: "+dao.getBookMaxNum());
//		log.info("제일 큰 수: "+session.selectOne(NAMESPACE+".getBookMaxNum"));
	}
	
}
