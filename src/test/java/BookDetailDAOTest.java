import static org.hamcrest.CoreMatchers.theInstance;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.bora.domain.report.ConsumeAllListVO;
import com.bora.domain.report.BookDetailVO;
import com.bora.persistence.report.BookDetailDAO;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(
		locations = {"file:src/main/webapp/WEB-INF/spring/root-context.xml"}
		)
public class BookDetailDAOTest {
	@Inject
	SqlSession session;
	
	@Inject
	BookDetailDAO dao;
	
	final static String NAMESPACE = "com.bora.mapper.BookDetailMapper";
	private static final Logger log = LoggerFactory.getLogger(BookDetailDAOTest.class);
	
//	@Test
	public void test() throws Exception {
		log.info("♡♡♡♡♡♡♡♡♡♡test");
		log.info(dao+"");
	}
	
//	@Test 
	// 가계부 디테일 넣기 완료
	public void writeBookDetail() throws Exception{
		log.info("♡♡♡♡♡♡♡♡♡♡writeDetail(detail) 호출");
		String id = "hiru";
		int bk_day = 5;
		String bk_iow = "출금";
		String bk_group = "체크카드";
		String bk_category = "쇼핑";
		int bk_money = 10000;
		String bk_memo = "스파오";
		BookDetailVO detail = new BookDetailVO();
		detail.setId(id);
		detail.setBk_category(bk_category);
		detail.setBk_day(bk_day);
		detail.setBk_iow(bk_iow);
		detail.setBk_group(bk_group);
		detail.setBk_memo(bk_memo);
		detail.setBk_money(bk_money);
		
		log.info("♡♡♡♡♡♡♡♡♡♡입력한 가계부 상세 정보");
		log.info("♡♡♡♡♡♡♡♡♡♡"+detail);
		
		session.insert(NAMESPACE+".writeBookDetail", detail);
	}
	
//	@Test 
	// 아이디로 디테일 정보 불러오기 완료
	public void getBookDetailList() throws Exception {
		String loginID = "admin";
		List<BookDetailVO> detailList = session.selectList(NAMESPACE+".getBookDetailList", loginID);
		log.info("♡♡♡♡♡♡♡♡♡♡ 불러온 정보: ");
		log.info("♡♡♡♡♡♡♡♡♡♡ "+detailList);
	}
	
	@Test 
	// 아이디와 디테일번호로 디테일 정보 불러오기 완료
	public void getBookDetailContent() throws Exception {
		String loginID = "admin";
		int bk_detail_num = 20;
		BookDetailVO vo = dao.getBookDetailContent(bk_detail_num, loginID);
		log.info("♡♡♡♡♡♡♡♡♡♡ 불러온 정보: "+vo);
		
	}
//	
//	@Test 
	// 관리자용 모든 정보 불러오기 완료
	public void getBookDetailAll() throws Exception {
		log.info("♡♡♡♡♡♡♡♡♡♡ 불러온 정보: ");
//		List<BookDetailVO> detailList = session.selectList(NAMESPACE+".getBookDetailAll");
		List<BookDetailVO> detailList = dao.getBookDetailAll();
		log.info("♡♡♡♡♡♡♡♡♡♡ "+detailList);
	}
	
//	@Test
	// 디테일 정보 수정 완료
	public void updateBookDetail() throws Exception{
		String loginID = "admin";
		int bk_detail_num = 19;
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("loginID",loginID);
		map.put("user_detail_num",bk_detail_num);
		
		BookDetailVO detail = dao.getBookDetailContent(bk_detail_num, loginID);
//		BookDetailVO detail = dao.getBookDetailContent(19,loginID);
		log.info("불러온 정보: "+detail);
		detail.setBk_day(10);
		detail.setBk_memo("고기 먹고 싶다 돼지고기");
		detail.setBk_category("문화");
		detail.setBk_money(2000);
		log.info("수정한 정보: "+detail);
		
		log.info("정보 업데이트");
		int result = dao.updateBookDetail(detail);
		if(result == 1) {
			log.info("성공");
			BookDetailVO detail2 = dao.getBookDetailContent(bk_detail_num,loginID);
			log.info("detail2: "+detail2);
		} else {
			log.info("실패");
		}
	}
	
//	@Test
	// 디테일 삭제 성공
	public void deleteTest() throws Exception{
		
//		int result = dao.deleteBookDetail(21);
//		if(result==1) log.info("성공"); 
	}
	
}
