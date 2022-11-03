import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.bora.domain.report.BookDetailVO;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(
		locations = {"file:src/main/webapp/WEB-INF/spring/root-context.xml"}
		)
public class BookDetailDAOTest {
	@Inject
	SqlSession session;
	
	final static String NAMESPACE = "com.bora.mapper.BookDetailMapper";
	private static final Logger log = LoggerFactory.getLogger(BookDetailDAOTest.class);
	
//	@Test
	public void test() throws Exception {
		log.info("♡♡♡♡♡♡♡♡♡♡test");
	}
	
//	@Test 가계부 디테일 넣기 완료
	public void writeBookDetail() throws Exception{
		log.info("♡♡♡♡♡♡♡♡♡♡writeDetail(detail) 호출");
		String id = "admin";
		int bk_day = 3;
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
	
//	@Test 아이디와 디테일번호로 정보 불러오기 완료
	public void getBookDetail() throws Exception {
		BookDetailVO detail = new BookDetailVO();
		detail.setId("admin");
		detail.setBk_detail_num(19);
		BookDetailVO detail2 =  session.selectOne(NAMESPACE+".getBookDetail", detail);
		log.info("♡♡♡♡♡♡♡♡♡♡ 불러온 정보: ");
		log.info("♡♡♡♡♡♡♡♡♡♡"+detail2);
	}

}
