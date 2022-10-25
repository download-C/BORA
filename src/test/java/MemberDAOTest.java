import javax.inject.Inject;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.bora.domain.MemberVO;
import com.bora.persistence.MemberDAO;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(
		locations = "file:src/main/webapp/WEB-INF/spring/root-context.xml")
public class MemberDAOTest {

	private static final Logger log = LoggerFactory.getLogger(MemberDAOTest.class);
	
	@Inject
	private MemberDAO dao;
	
//	@Test
	public void 테스트확인() {
		log.info("♡♡♡♡♡♡♡테스트 확인");
	}
	
//	@Test
	public void 회원가입() throws Exception{
		log.info("♡♡♡♡♡♡♡회원가입()");
		MemberVO vo = new MemberVO();
		vo.setId("admin");
		vo.setPw("1234");
		vo.setName("최다운");
		
		dao.joinMember(vo);
	}
	

}
