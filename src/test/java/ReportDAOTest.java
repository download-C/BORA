import javax.inject.Inject;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.bora.domain.ReportVO;
import com.bora.persistence.ReportDAO;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(
		locations = "file:src/main/webapp/WEB-INF/spring/root-context.xml")
public class ReportDAOTest {
	
	@Inject
	ReportDAO dao;
	
	private static final Logger log = LoggerFactory.getLogger(ReportDAOTest.class);
	
//	@Test
	public void 제이유닛테스트() {
		log.info("제이유닛 테스트()실행");
	}

	@Test
	public void insertReport() throws Exception{
		log.info("insertReport() 실행");
		ReportVO vo = new ReportVO();
		vo.setId("hihi");
		vo.setRp_date("2022-11-02");
		vo.setRp_money(5000);
		vo.setRp_detail("밥값");
		vo.setCategory("food_ex");
		
		dao.insertReport2(vo);
	}
}
