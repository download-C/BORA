package com.bora.controller.report;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import com.bora.domain.board.PageMakerVO;
import com.bora.domain.board.PageVO;
import com.bora.domain.report.BookDetailVO;
import com.bora.domain.report.BookVO;
import com.bora.service.report.ConsumeAllListService;
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
	
	// 가계부 메인 페이지
   @RequestMapping(value="/dashboard", method = RequestMethod.GET)
	   public String bookMainGET(Model model, RedirectAttributes rttr, int year, int month) throws Exception {
	   log.info("reportMainGET() 호출");
	   loginID = (String)session.getAttribute("loginID");
	   
	   // 로그인 안 한 경우 로그인 페이지로 이동
	   if(loginID == null) {
		   rttr.addFlashAttribute("msg", "로그인 후 이용 가능한 페이지입니다.");
		   return "redirect:/main/login";
	   } else {
	   
		   // 현재 연과 월을 기본으로 보여줌
			Calendar cal = Calendar.getInstance();
			year = cal.get(Calendar.YEAR);
			month = cal.get(Calendar.MONTH)+1;
			model.addAttribute("year", year);
			model.addAttribute("month", month);
			log.info("입력된 날짜 :"+year+"년 "+month+"월");
			List<BookDetailVO> detailList = dService.getDashboardBookDetail(loginID, year, month);
			if(detailList.size()!=0) {
				log.info("가계부 목록 가져오기 성공");
				model.addAttribute("detailList", detailList);
				int bk_budget = service.getMonthBudget(loginID, year, month); 
				if(bk_budget!=0) model.addAttribute("bk_budget", bk_budget);
			} else {
				log.info("가계부 없음");
				rttr.addFlashAttribute("msg", "아직 가계부를 입력하지 않으셨네요!");
				rttr.addFlashAttribute("message","아직 가계부를 입력하지 않으셨네요!");
				log.info("플래시 메세지 입력 완료");
			}
	   }
		return "/book/dashboard";
   }

	
	// 1. 가계부 상세 내역 작성 메서드
	@RequestMapping(value="/write", method = RequestMethod.POST)
	public String wirteBookPOST(HttpServletRequest request,
			HttpSession session, RedirectAttributes rttr) throws Exception {
		log.info("입력한 가계부 정보 변수로 선언");
		
		int bk_num=0;
		
		String loginID = (String)session.getAttribute("loginID");
		int bk_year = Integer.parseInt(request.getParameter("bk_year"));
		int bk_month = Integer.parseInt(request.getParameter("bk_month"));
		int bk_day = Integer.parseInt(request.getParameter("bk_day"));
		String bk_iow = request.getParameter("bk_iow");
		String bk_group = request.getParameter("bk_group");
		String bk_category = request.getParameter("bk_category");
		int bk_money = Integer.parseInt(request.getParameter("bk_money"));
		String bk_memo = request.getParameter("bk_memo");
		
		BookVO book = service.getMonthBook(bk_year, bk_month, loginID);
		
		BookDetailVO detail = new BookDetailVO();
		detail.setId(loginID);
		detail.setBk_day(bk_day);
		detail.setBk_iow(bk_iow);
		detail.setBk_group(bk_group);
		detail.setBk_category(bk_category);
		detail.setBk_money(bk_money);
		detail.setBk_memo(bk_memo);

		if(book == null) {
			log.info("해당 연월의 가계부가 없으므로 book 새로 저장하기");
			book = new BookVO();
			book.setId(loginID);
			book.setBk_year(bk_year);
			book.setBk_month(bk_month);
			book.setBk_budget(0);
			log.info("아이디 "+loginID+" "+bk_year+"년 "+bk_month+"월 가계부");
			// 가계부 정보 DB 저장 후 해당 내용의 가계부 고유번호 가져오기
			service.writeBook(book);
			bk_num = service.getBookMaxNum();
			
		} else {
			log.info("이미 작성된 연월이므로 기존의 내용 가져와서 그대로 작성");
			bk_num = book.getBk_num();
		}

		// 가계부 번호 가져왔을 경우 BookDetailVO 생성 후 DB 저장 -> 리스트로 이동		
		if(bk_num != 0) {
			detail.setBk_num(bk_num);
			dService.writeBookDetail(detail);
			log.info("가계부 작성 성공! 리스트로 이동");
			rttr.addFlashAttribute("msg", "가계부 작성이 완료되었습니다.");
			return "redirect:/book/list?year="+bk_year+"&month="+bk_month;
		} else {
			log.info("가계부 작성 실패");
			rttr.addFlashAttribute("msg", "가계부 작성에 실패했습니다.");
			return "redirect:/book/write";
		}
		
	}
	
	
	@RequestMapping(value="/list", method=RequestMethod.GET)
	public String bookListPageGET(PageVO vo, Integer bk_detail_num, Model model, 
			int year, int month, RedirectAttributes rttr) throws Exception {
		log.info("bookListPageGET()호출");
		log.info("(♥♥♥♥♥ 2-1.listPageGET) 호출됨");
		log.info(year+"년 "+month+"월 가계부 불러오기");
		loginID = (String)session.getAttribute("loginID");
		
		// 이번 달 찾기
		Calendar cal = Calendar.getInstance();
		if(year == 0) year = cal.get(Calendar.YEAR);
		if(month == 0) month = cal.get(Calendar.MONTH)+1;
		
		PageMakerVO pm = new PageMakerVO();
		pm.setVo(vo);
		int cnt = dService.getMonthBookDetailCnt(loginID, year, month);
		pm.setTotalCnt(cnt);
		model.addAttribute("pm", pm);
		
		// 해당 연월의 예산 가져오기
		
		
		log.info(year+"년 "+month+"달 가계부 불러오기");
		List<BookDetailVO> detailList = new ArrayList<BookDetailVO>();
		detailList = dService.getMonthBookDetailList(year, month, loginID, pm);
		log.info("가져온 가계부 개수: "+detailList.size());
		if(detailList.size() != 0) {
			model.addAttribute("detailList", detailList);
			model.addAttribute("year", year);
			model.addAttribute("month", month);
			int bk_budget = service.getMonthBudget(loginID, year, month); 
			model.addAttribute("bk_budget", bk_budget);
			rttr.addFlashAttribute("msg", year+"년 "+month+"월 가계부를 불러옵니다.");
			return "/book/bookList";
		} else {
			model.addAttribute("year", year);
			model.addAttribute("month", month);
			rttr.addFlashAttribute("msg", year+"년 "+month+"월 가계부가 없습니다.");
			return "/book/bookList";
		}
	}
	
	// 3. 가계부 수정하기
	@RequestMapping(value="/update", method = RequestMethod.GET)
	public void bookUpdateGET(String page, int bk_detail_num,
			Model model) throws Exception {
		log.info("bookUpdateGET() 호출");
		loginID = (String)session.getAttribute("loginID");
		BookDetailVO detail = dService.getBookDetail(bk_detail_num, loginID);
		log.info(bk_detail_num+"번 가계부: "+detail);
		model.addAttribute("detail", detail);
		model.addAttribute("page",page);
	}
	
	@RequestMapping(value="/update", method = RequestMethod.POST)
	public String bookUpdatePOST(BookVO book, BookDetailVO detail, String page,
			RedirectAttributes rttr, Model model) throws Exception {
		log.info("bookUpdatePOST() 호출");
		log.info("book: "+book);
		log.info("detail: "+detail);
		log.info("page: "+page);
		int result = service.updateBook(book);
		if(result == 1) {
			int result2 = dService.updateBookDetail(detail);
			if(result2 ==1) {
				log.info("가계부 수정 완료");
				rttr.addFlashAttribute("msg", "가계부 수정을 완료했습니다.");
				return "redirect:/book/list?page="+page+"&year="+book.getBk_year()+"&month="+book.getBk_month();
			} else {
				log.info("가계부 수정 	실패");
				rttr.addFlashAttribute("msg", "가계부 수정에 실패했습니다.");
				return "redirect:/book/update?page="+page+"&bk_num="+book.getBk_num()+"&bk_detail_num="+detail.getBk_detail_num();
			}
		} else {
			log.info("가계부 디테일 수정 실패");
			rttr.addFlashAttribute("msg", "가계부 수정에 실패했습니다.");
			return "redirect:/book/update?page="+page+"&bk_num="+book.getBk_num()+"&bk_detail_num="+detail.getBk_detail_num();
		}
	}
	
	@RequestMapping(value="/delete", method = RequestMethod.GET)
	public String bookDeleteGET(Integer bk_num, Integer bk_detail_num,
			RedirectAttributes rttr) throws Exception {
		log.info("bookDeleteGET() 호출");
		int year=0;
		int month=0;
		// 이번 달 찾기
		Calendar cal = Calendar.getInstance();
		if(year == 0) year = cal.get(Calendar.YEAR);
		if(month == 0) month = cal.get(Calendar.MONTH)+1;
		
		String loginID = (String)session.getAttribute("loginID");
		int result = dService.deleteBookDetail(bk_detail_num, loginID);
		if(result==1) {
				log.info("가계부 삭제 성공");
				rttr.addFlashAttribute("msg", "가계부 삭제를 완료했습니다.");
				return "redirect:/book/list?page=1&year="+year+"&month="+month;
			
		} else {
			log.info("가계부 삭제 실패");
			rttr.addFlashAttribute("msg", "가계부 삭제에 실패했습니다.");
			return "redirect:/book/list";
		}
	}
	
	public String category(String code) throws Exception{
	 switch (code) {
		case "A1": return "가전/전자";	
		case "B1": return "도서/문구";	
		case "C1": return "패션/의류";	
		case "D1": return "스포츠";	
		case "E1": return "화장품";	
		case "F1": return "아동/유아";	
		case "G1": return "식품";	
		case "H1": return "생활/가구";	
		case "I1": return "여행/교통";	
		case "J1": return "문화/레저";	
		case "K1": return "음식";	
		case "L1": return "e쿠폰/기타서비스";	
		default: return "기타";
		}
	 }
}
