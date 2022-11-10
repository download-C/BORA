import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.bora.domain.report.BookDetailVO;
import com.bora.persistence.ConsumeDAO;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(
		locations = {"file:src/main/webapp/WEB-INF/spring/root-context.xml"}
		)
public class ConsumeDAOTest {
	
	@Inject
	SqlSession session;
	
	@Inject
	ConsumeDAO dao;
	
	final static String NAMESPACE = "com.bora.mapper.ConsumeMapper";
	private static final Logger log = LoggerFactory.getLogger(ConsumeDAOTest.class);
	
//	@Test
	public void test() throws Exception {
		log.info("♡♡♡♡♡♡♡♡♡♡test");
		log.info(dao+"");
	}
	
	// 저번달 소비 비교 리스트
		public void getConsumeLastMonList() throws Exception{
			String loginID = "admin";
			List<BookDetailVO> consumeLastMonList = 
					session.selectList(NAMESPACE+".getConsumeLastMonList", loginID);
			log.info("♡♡♡♡♡♡♡♡♡♡ 불러온 정보: ");
			log.info("♡♡♡♡♡♡♡♡♡♡ "+consumeLastMonList);
		}
		
		// 이번달 소비 비교 리스트
		public void getConsumeThisMonList() throws Exception{
			String loginID = "admin";
			List<BookDetailVO> consumeThisMonList = 
					session.selectList(NAMESPACE+".getConsumeThisMonList", loginID);
			log.info("♡♡♡♡♡♡♡♡♡♡ 불러온 정보: ");
			log.info("♡♡♡♡♡♡♡♡♡♡ "+consumeThisMonList);
		}
		
		// 저번달 소비 비교 리스트
		public void getConsumeAllList() throws Exception{
			String loginID = "admin";
			List<BookDetailVO> consumeList = 
					session.selectList(NAMESPACE+".getConsumeAllList", loginID);
			log.info("♡♡♡♡♡♡♡♡♡♡ 불러온 정보: ");
			log.info("♡♡♡♡♡♡♡♡♡♡ "+consumeList);
		}

		
}
