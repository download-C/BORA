package com.bora.controller.report;

import java.util.List;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.bora.domain.board.PageMakerVO;
import com.bora.domain.board.PageVO;
import com.bora.domain.report.BookDetailVO;
import com.bora.domain.report.BookVO;
import com.bora.service.report.BookDetailService;
import com.bora.service.report.BookService;

@Controller
@RequestMapping("/book/*")
public class BookController {


	@Inject
	BookService service;
	
	@Inject
	BookDetailService dService;
	
	@Inject
	HttpSession session;
	
	String loginID;

	private static final Logger log = LoggerFactory.getLogger(BookController.class);
	

	// http://localhost:8088/book/write
	@RequestMapping(value="/write", method = RequestMethod.GET)
	public void writeBookGET() {
		log.info("writeBookGET() 호출");
	}
	
	// 1. 가계부 상세 내역 작성 메서드
	@RequestMapping(value="/write", method = RequestMethod.POST)
	public String wirteBookPOST(HttpServletRequest request,
			HttpSession session, RedirectAttributes rttr) throws Exception {
		String loginID = (String)session.getAttribute("loginID");
		int bk_year = Integer.parseInt(request.getParameter("bk_year"));
		int bk_month = Integer.parseInt(request.getParameter("bk_month"));
		int bk_day = Integer.parseInt(request.getParameter("bk_day"));
		String bk_iow = request.getParameter("bk_iow");
		String bk_group = request.getParameter("bk_group");
		String bk_category = request.getParameter("bk_category");
		int bk_money = Integer.parseInt(request.getParameter("bk_money"));
		String bk_memo = request.getParameter("bk_memo");
		
		// 가계부 상세정보 받아서 BookDetailVO에 저장
		BookDetailVO detail = new BookDetailVO();
		detail.setId(loginID);
		detail.setBk_day(bk_day);
		detail.setBk_iow(bk_iow);
		detail.setBk_group(bk_group);
		detail.setBk_category(bk_category);
		detail.setBk_money(bk_money);
		detail.setBk_memo(bk_memo);
		
		// 디테일 정보 DB 저장 후 해당 내용의 가계부 고유번호 가져오기
		dService.writeBookDetail(detail);
		int bk_detail_num = dService.getBookDetailMaxNum();
		
		// 디테일 번호 가져왔을 경우 BookVO 생성 후 DB 저장 -> 리스트로 이동
		if(bk_detail_num != 0) {
			log.info("bk_detail로 book 저장하기");
			BookVO book = new BookVO();
			book.setId(loginID);
			book.setBk_year(bk_year);
			book.setBk_month(bk_month);
			log.info("아이디 "+loginID+" "+bk_year+"년 "+bk_month+"월 가계부");
			
			service.writeBook(book, bk_detail_num);
			log.info("가계부 작성 성공! 리스트로 이동");
			rttr.addFlashAttribute("msg", "가계부 작성이 완료되었습니다.");
			return "redirect:/book/bookList";
		} else {
			log.info("가계부 작성 실패");
			rttr.addFlashAttribute("msg", "가계부 작성에 실패했습니다.");
			return "redirect:/book/write";
		}
		
	}
	
	@RequestMapping(value="/bookList", method=RequestMethod.GET)
	public String bookListPageGET(Integer bk_detail_num, Model model, PageVO vo) throws Exception {
		log.info("bookListPageGET()호출");
		log.info("(♥♥♥♥♥ 2-1.listPageGET) 호출됨");
		
		// 1. 북 테이블 부르기
		
		// 2. 북 테이블의 디테일넘과 같은 정보를 불러서setBookDetailVO에 삽입
		if(session!=null) loginID=(String)session.getAttribute("loginID");
		List<BookVO> bookList = service.getBookListAll(loginID);
		
		for(BookVO book : bookList) {
			log.info("bookList: "+book );
		}
		model.addAttribute("bookList", bookList);
//		List<BookDetailVO> detailList = dService.getBookDetailAll();
//	
//		
//		log.info("(♥♥♥♥♥ 2-1.listPageGET) Service 호출 + 모델 객체에 저장까지 완");
//		
//		// 페이징 처리 하단부 정보 저장
//		PageMakerVO pm = new PageMakerVO();
//		pm.setVo(vo);
//		int cnt = service.getBookCnt();
//    	log.info("글 개수 :"+cnt);
//		pm.setTotalCnt(cnt); // <<찐 글 개수 일단 넣은거고,, 서비스에 이 동작 추가해놓으면 되겠네~ 총 글 개수 불ㄹ러오는
//		
//		// 얘도 model에 담아서 보냅시다..
//		model.addAttribute("pm", pm);
//		log.info("(♥♥♥♥♥ 2-1.listPageGET) PageMakerVO도 모델 객체에 저장 완 + pm: " + pm);
//		
//		log.info("(♥♥♥♥♥ 2-1.listPageGET) 리턴타입 String --> /book/listAll.jsp로 이동할 거");
		return "/book/bookList";
	}
	

}
