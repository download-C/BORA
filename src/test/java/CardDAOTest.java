import javax.inject.Inject;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.bora.persistence.CardDAO;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(
		locations = "file:src/main/webapp/WEB-INF/spring/root-context.xml")
public class CardDAOTest {
	@Inject
	CardDAO dao;
	
	private static final Logger log = LoggerFactory.getLogger(CardDAOTest.class);
	
//	@Test
	public void 테스트() throws Exception {
		log.info("테스트");
	}
	
	@Test
	public void getCard(Integer card_num) throws Exception{
		card_num = 1111;
		dao.getCard(card_num);
	}
	
	
}
