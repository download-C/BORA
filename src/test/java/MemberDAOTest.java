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
	
//	@Test 완료
	public void 회원가입() throws Exception{
		log.info("♡♡♡♡♡♡♡회원가입()");
		MemberVO vo = new MemberVO();
		vo.setId("admin");
		vo.setPw("1234");
		vo.setName("최다운");
		vo.setNick("다우니");
		vo.setPhone("01012345678");
		vo.setEmail("email@naver.com");
		
		dao.joinMember(vo);
		
		log.info("vo: "+vo);
	} 
	
//	@Test 완료
	public void 로그인() throws Exception {
		log.info("♡♡♡♡♡♡♡로그인() 호출");
		MemberVO vo = new MemberVO();
		vo.setId("admin");
		vo.setPw("1234");
		MemberVO vo2 = dao.loginMember(vo);
		if(vo2 != null) log.info("♡♡♡♡♡♡♡로그인 성공: "+vo);
		else log.info("♡♡♡♡♡♡♡로그인 실패");
	}
	
//	@Test 완료
	public void login() throws Exception {
		log.info("♡♡♡♡♡♡♡login() 호출");
		MemberVO vo = dao.getMember("admin");
		log.info("♡♡♡♡♡♡♡"+vo.getId()+"의 개인정보 : "+vo);
	}
	
//	@Test 완료
	public void getMember() throws Exception {
		log.info("getMember() 호출");
		MemberVO vo = dao.getMember("admin");
		if(vo != null) log.info("♡♡♡♡♡♡♡개인정보 가져오기 성공 : "+vo);
		else log.info("♡♡♡♡♡♡♡개인정보 가져오기 실패");
	}
	
	
	
	

}
