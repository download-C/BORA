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
import org.springframework.web.bind.annotation.RequestParam;
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
			return "redirect:/book/list";
		} else {
			log.info("가계부 작성 실패");
			rttr.addFlashAttribute("msg", "가계부 작성에 실패했습니다.");
			return "redirect:/book/write";
		}
		
	}
	
	@RequestMapping(value="/list", method=RequestMethod.GET)
	public String bookListPageGET(PageVO vo, Integer bk_detail_num, Model model) throws Exception {
		log.info("bookListPageGET()호출");
		log.info("(♥♥♥♥♥ 2-1.listPageGET) 호출됨");
		
		String loginID = (String)session.getAttribute("loginID");
		// 1. 북 테이블 부르기
		PageMakerVO pm = new PageMakerVO();
		pm.setVo(vo);
		int cnt = service.getBookCnt(loginID);
		pm.setTotalCnt(cnt);
		model.addAttribute("pm", pm);
		
		// 2-1. 북 테이블의 디테일넘과 같은 정보를 불러서setBookDetailVO에 삽입
		List<BookVO> bookList = service.getBookListPage(loginID, pm);
				
		for(BookVO book : bookList) {
			log.info("bookList: "+book );
		}
		model.addAttribute("bookList", bookList);
		
		return "/book/bookList";
	}
	
	// 3. 가계부 수정하기
	@RequestMapping(value="/update", method = RequestMethod.GET)
	public void bookUpdateGET(String page, @RequestParam("bk_num") int bk_num,
			Model model) throws Exception {
		log.info("bookUpdateGET() 호출");
		BookVO book = service.getBook(bk_num, loginID);
		model.addAttribute("book", book);
	}
	
	@RequestMapping(value="/update", method = RequestMethod.POST)
	public String bookUpdatePOST(BookVO book, BookDetailVO detail, String page,
			RedirectAttributes rttr, Model model) throws Exception {
		log.info("bookUpdatePOST() 호출");
		log.info("book: "+book);
		log.info("detail: "+detail);
		int result = dService.updateBookDetail(detail);
		if(result == 1) {
			int result2 = service.updateBook(book);
			if(result2 ==1) {
				log.info("가계부 수정 완료");
				rttr.addFlashAttribute("msg", "가계부 수정을 완료했습니다.");
				model.addAttribute("book", book);
				return "redirect:/book/list";
			} else {
				log.info("가계부 수정 	실패");
				rttr.addFlashAttribute("msg", "가계부 수정에 실패했습니다.");
				return "redirect:/book/update?page="+page+"&bk_num="+book.getBk_num();
			}
		} else {
			log.info("가계부 디테일 수정 실패");
			rttr.addFlashAttribute("msg", "가계부 수정에 실패했습니다.");
			return "redirect:/book/update?page="+page+"&bk_num="+book.getBk_num();
		}
	}
	
	@RequestMapping(value="/delete", method = RequestMethod.GET)
	public String bookDeleteGET(Integer bk_num, Integer bk_detail_num,
			RedirectAttributes rttr) throws Exception {
		log.info("bookDeleteGET() 호출");
		String loginID = (String)session.getAttribute("loginID");
		int result = dService.deleteBookDetail(bk_detail_num, loginID);
		if(result==1) {
			int result2 = service.deleteBook(bk_num, loginID);
			if(result2==1) {
				log.info("가계부 삭제 성공");
				rttr.addFlashAttribute("msg", "가계부 삭제를 완료했습니다.");
				return "redirect:/book/list";
			} else {
				log.info("가계부 삭제 실패");
				rttr.addFlashAttribute("msg", "가계부 삭제에 실패했습니다.");
				return "redirect:/book/list";
			}
		} else {
			log.info("가계부 디테일 삭제 실패");
			return "redirect:/book/list";
		}
	}

}
