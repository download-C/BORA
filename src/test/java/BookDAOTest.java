import java.util.List;

import javax.inject.Inject;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.bora.domain.report.BookVO;
import com.bora.persistence.BookDAO;
import com.bora.service.report.BookServiceImpl;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(
		locations = {"file:src/main/webapp/WEB-INF/spring/root-context.xml"}
		)
public class BookDAOTest {

	@Inject
	BookDAO dao;
	
	private static final Logger log = LoggerFactory.getLogger(BookServiceImpl.class);
	
//	@Test
	public void 테스트() throws Exception {
		log.info("테스트 메서드");
	}
	
//	@Test // 성공
	public void admin가계부목록가져오기() throws Exception {
		log.info("admin의 가계부목록가져오기() 호출");
		List<BookVO> bookList = dao.getBookListAll("admin"); 
		for(BookVO book:bookList) {
		log.info("admin의 가계부 리스트"+book);
		}
	}
	
}
