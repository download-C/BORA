package com.bora.controller.report;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import com.bora.domain.report.DateData;
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
	@RequestMapping(value = "/write", method = RequestMethod.GET)
	public void writeBookGET(Integer year, Integer month, Integer day, Model model) throws Exception {
		log.info("writeBookGET() 호출");
		String loginID = (String) session.getAttribute("loginID");
		BookVO book = service.getMonthBook(year, month, loginID);
		if (book == null) {
			log.info("해당 연 월의 가계부가 없습니다.");
		} else {
			log.info("해당 연 월의 가계부가 있습니다.");

		}

		model.addAttribute("year", year);
		model.addAttribute("month", month);
		model.addAttribute("day", day);
	}

	// 1. 가계부 상세 내역 작성 메서드
	@RequestMapping(value = "/write", method = RequestMethod.POST)
	public String wirteBookPOST(HttpServletRequest request, HttpSession session, RedirectAttributes rttr)
			throws Exception {
		log.info("입력한 가계부 정보 변수로 선언");

		int bk_num = 0;

		String loginID = (String) session.getAttribute("loginID");
		int bk_year = Integer.parseInt(request.getParameter("bk_year"));
		int bk_month = Integer.parseInt(request.getParameter("bk_month"));
		log.info("가계부 작성한 달: "+bk_month);
		int bk_day = Integer.parseInt(request.getParameter("bk_day"));
		String bk_iow = request.getParameter("bk_iow");
		String bk_group = request.getParameter("bk_group");
		String bk_category = request.getParameter("bk_category");
		int bk_money = Integer.parseInt(request.getParameter("bk_money"));
		String bk_memo = request.getParameter("bk_memo");

		BookVO book = service.getMonthBook(bk_year, bk_month, loginID);
		log.info("가져온 가계부 정보: " + book);
		BookDetailVO detail = new BookDetailVO();
		detail.setId(loginID);
		detail.setBk_day(bk_day);
		detail.setBk_iow(bk_iow);
		detail.setBk_group(bk_group);
		detail.setBk_category(bk_category);
		detail.setBk_money(bk_money);
		detail.setBk_memo(bk_memo);

		if (book == null) {
//			log.info("해당 연월의 가계부가 없으므로 book 새로 저장하기");
//			book = new BookVO();
//			book.setId(loginID);
//			book.setBk_year(bk_year);
//			book.setBk_month(bk_month);
//			book.setBk_budget(0);
//			log.info("아이디 "+loginID+" "+bk_year+"년 "+bk_month+"월 가계부 생성");
//			// 가계부 정보 DB 저장 후 해당 내용의 가계부 고유번호 가져오기
//			service.writeBook(book);
			bk_num = service.getBookMaxNum();

		} else {
			log.info("이미 작성된 연월이므로 기존의 내용 가져와서 그대로 작성");
			bk_num = book.getBk_num();
		}

		// 가계부 번호 가져왔을 경우 BookDetailVO 생성 후 DB 저장 -> 리스트로 이동
		if (bk_num != 0) {
			detail.setBk_num(bk_num);
			dService.writeBookDetail(detail);
			log.info("가계부 작성 성공! 리스트로 이동");
			rttr.addFlashAttribute("msg3", "가계부 작성이 완료되었습니다.");
			return "redirect:/book/list?year="+bk_year+"&month="+bk_month+"&day="+bk_day;
		} else {
			log.info("가계부 작성 실패");
			rttr.addFlashAttribute("msg4", "가계부 작성에 실패했습니다.");
			return "redirect:/book/write";
		}
	}

	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public String bookListPageGET(PageVO vo, Integer bk_detail_num, Model model, int year, int month, int day,
			RedirectAttributes rttr) throws Exception {
		log.info("bookListPageGET()호출");
		log.info("(♥♥♥♥♥ 2-1.listPageGET) 호출됨");
		log.info(year + "년 " + month + "월 가계부 불러오기");
		loginID = (String) session.getAttribute("loginID");
		double percent = 0;

		// 0. 로그인 여부 확인
		if (loginID == null) {
			rttr.addFlashAttribute("msg", "로그인 후 이용 가능합니다");
			return "redirect:/main/login";
		}

		PageMakerVO pm = new PageMakerVO();
		pm.setVo(vo);
		int cnt = dService.getMonthBookDetailCnt(loginID, year, month);
		pm.setTotalCnt(cnt);
		model.addAttribute("pm", pm);

		model.addAttribute("year", year);
		model.addAttribute("month", month);
		model.addAttribute("day", day);
		
		// 해당 연월의 가계부 불러오기
		log.info(loginID + "님의 " + year + "년 " + month + "월 가계부 불러오기");

		// 1-1. 해당 연월의 가계부가 있을 때
		if (service.getMonthBook(year, month, loginID) != null) {
			log.info(year + "년 " + month + "월 가계부가 있습니다.");

			List<BookDetailVO> detailList = new ArrayList<BookDetailVO>();
			detailList = dService.getMonthBookDetailList(year, month, loginID, pm);
			log.info("가져온 가계부 개수: " + detailList.size());

			// 2-1. 디테일이 있을 때
			if (detailList.size() != 0) {
				log.info(year+"년 "+month+"월 가계부 구체 내역 있음");
				model.addAttribute("detailList", detailList);
				int bk_budget = service.getMonthBudget(loginID, year, month);

				// 3-1. 디테일도 있고 예산도 있을 때
				if (bk_budget > 0) {
					log.info("예산 있음");
					log.info(month+"월 예산: " + bk_budget + "만원");
					model.addAttribute("bk_budget", bk_budget);

					// 해당 달의 지출 합계
					int sum = service.getMonthBookMoney(loginID, year, month);
					log.info(month+"월 지출: " + sum + "원");
					if (sum > 0) model.addAttribute("sum", sum);
					else model.addAttribute("sum", 0);

					// 해당 달의 남은 예산(예산이 만원 단위이기 때문에 계산하기 전 10000을 곱해줘야 함)
					int restedBudget = (bk_budget * 10000) - sum;
					log.info("한 달 예산 중 남은 금액: " + restedBudget + "원");
					int restedBudget1 = ((bk_budget * 10000) - sum) / 10000;
					int restedBudget2 = (bk_budget * 10000 - sum) - (restedBudget1 * 10000);
					log.info("남은 예산: " + restedBudget1 + "만");
					log.info(restedBudget2 + "원");

					// 해당 달의 예산 대비 지출 퍼센트
					double moneyPercent = ((sum / (double) (bk_budget * 10000)) * 100);
					percent = Math.round(moneyPercent * 1000) / 1000;
					log.info("한 달 예산 대비 지출 퍼센트 :" + percent + "%");
					model.addAttribute("percent", percent);

					// 가계부 지출이 예산의 70%가 넘을 때
					if (moneyPercent >= 70) {
						log.info("예산의 70% 이상 지출");
						model.addAttribute("restedBudget1", restedBudget1);
						model.addAttribute("restedBudget2", restedBudget2);
						model.addAttribute("percent", percent);
					} else {
						model.addAttribute("restedBudget1", restedBudget1);
						model.addAttribute("restedBudget2", restedBudget2);
						model.addAttribute("year", year);
						model.addAttribute("month", month);
						model.addAttribute("percent", percent);

					}
				// 3-2. 디테일은 있지만 예산이 없을 때
				} else {
					log.info("예산 설정 안 함");
					model.addAttribute("bk_budget", 0);
					rttr.addFlashAttribute("msg3", "Opps!😅😅😅");
					rttr.addFlashAttribute("msg4", "아직 이번 달 예산을 작성하지 않으셨네요!");
					log.info("FlashAttribute 보내기 성공");
					// 해당 달의 지출 합계
					int sum = service.getMonthBookMoney(loginID, year, month);
					log.info(month+"월 지출: " + sum + "원");
					if (sum > 0) model.addAttribute("sum", sum);
					else model.addAttribute("sum", 0);
				}
			// 2-2. 해당 연 월의 가계부 디테일이 없을 때
			} else {
				log.info("아직 작성한 가계부 디테일이 없습니다.");
				model.addAttribute("msg1", "Oops!😅😅😅");
				model.addAttribute("msg2", "아직 가계부를 작성하지 않으셨네요~!");
				model.addAttribute("bk_budget", service.getMonthBudget(loginID, year, month));

				int bk_budget = service.getMonthBudget(loginID, year, month);

				// 3-1. 가계부는 없지만 예산은 있을 때
				if (bk_budget > 0) {
					log.info("한달 예산: " + bk_budget + "만원");
					model.addAttribute("bk_budget", bk_budget);
					model.addAttribute("sum", 0);
					model.addAttribute("bk_budget", bk_budget);

				// 가계부도 없고 예산도 없을 때
				} else {
					log.info("아무것도 없음,,,");
					model.addAttribute("bk_budget", 0);
					rttr.addFlashAttribute("msg1", "Opps!😅😅😅");
					rttr.addFlashAttribute("msg2", "아직 가계부를 작성하지 않으셨네요!");
				}
			}
		// 1-2. 해당 연 월의 가계부가 없을 때
		} else {
			log.info(year + "년 " + month + "월 가계부가 없으므로 새로 생성합니다.");
			BookVO book = new BookVO();
			book.setId(loginID);
			book.setBk_year(year);
			book.setBk_month(month);
			book.setBk_budget(0);
			service.writeBook(book);
			model.addAttribute("bk_budget", 0);
			rttr.addFlashAttribute("msg1", "Opps!😅😅😅");
			rttr.addFlashAttribute("msg2", "아직 가계부를 작성하지 않으셨네요!");
		}
		
		log.info("해당 월의 3달 전 예산 및 지출 담기");
		
		// 1, 2, 3 개월 전 예산 및 지출 구해서 보내기
		for(int i=1; i<4; i++) {
			if(month-i >0 ) {
				BookVO book = service.getMonthBook(year, month-i, loginID);
				log.info(i+" 전 달의 정보: "+book);
				// 가계부 불러오려 했는데 없으면 예산 0으로 새로 생성!
				int bfbudget=0;
				int bfsum=0;
				if(book==null) {
					book = new BookVO();
					book.setBk_year(year);
					book.setBk_month(month-i);
					book.setBk_budget(0);
					book.setId(loginID);
					service.writeBook(book);
					log.info("CCCCCCCCCCC "+year+"년 "+(month-i)+"월 가계부 생성");
				}
				model.addAttribute("bfyear"+i, year);
				model.addAttribute("bfmonth"+i, month-i);
				bfbudget = service.getMonthBudget(loginID, year, month-i);
				model.addAttribute("bfbudget"+i, bfbudget);
				bfsum = service.getMonthBookMoney(loginID, year, month-i);
				log.info("year: "+year+", month:"+(month-i));
				log.info(i+"전 달 예산 및 지출: "+bfbudget+", "+bfsum);
				
				// i전 달의 예산이 있을 때
				if(bfbudget!=0) {
					// i전 달의 예산, 지출 모두 있을 때 
					if(bfsum!=0) {
						percent = (double)((bfsum/(bfbudget)))/100;
						model.addAttribute("bfpercent"+i, percent);
					// i전 달의 예산 지출 둘 다 없을 때
					} else {
						percent = 0;
					}
				// i전 달의 예산이 없을 때
				}else {
					percent = 0;
				}
			// 가계부에서 불러오려는 연 월이 지난 해일 경우!
			} else {
				BookVO book = service.getMonthBook(year-1,13-i, loginID);
				if(book==null) {
					book = new BookVO();
					book.setBk_year(year-1);
					book.setBk_month(13-i);
					book.setBk_budget(0);
					book.setId(loginID);
					service.writeBook(book);
					log.info("CCCCCCCCCCC "+year+"년 "+(month-i)+"월 가계부 생성");
				}
				model.addAttribute("bfyear"+i, year-1);
				model.addAttribute("bfmonth"+i, 13-i);
				int bfbudget = service.getMonthBudget(loginID, year-1, 13-i);
				model.addAttribute("bfbudget"+i, bfbudget);
				log.info("year: "+year+", month-"+i+": "+(month-i));
				int bfsum = service.getMonthBookMoney(loginID, year-1, 13-i);
				if(bfbudget!=0) {
					// i전 달의 예산, 지출 모두 있을 때 
					if(bfsum!=0) {
						percent = (double)((bfsum/(bfbudget*10000)))*100;
						model.addAttribute("bfpercent"+i, percent);
					// i전 달의 예산 지출 둘 다 없을 때
					} else {
						percent = 0;
					}
				// i전 달의 예산이 없을 때
				}else {
					percent = 0;
				}
			}
			model.addAttribute("bfpercent"+i, percent);
			log.info("CCCCCCCCCC bfmonth"+i+", bfyear"+i+", bfbudget"+i+", bfpercent"+i+"보내기 완료");
		}
		// 1, 2, 3 개월 전 예산 및 지출 구해서 보내기 끝 --------------------------
		return "/book/bookList";
	}

	// 3. 가계부 수정하기
	@RequestMapping(value = "/update", method = RequestMethod.GET)
	public void bookUpdateGET(String page, int bk_detail_num, Model model) throws Exception {
		log.info("bookUpdateGET() 호출");
		loginID = (String) session.getAttribute("loginID");
		BookDetailVO detail = dService.getBookDetail(bk_detail_num, loginID);
		log.info(bk_detail_num + "번 가계부: " + detail);
		model.addAttribute("detail", detail);
		model.addAttribute("page", page);
	}

	@RequestMapping(value = "/update", method = RequestMethod.POST)
	public String bookUpdatePOST(BookVO book, BookDetailVO detail, String page, RedirectAttributes rttr, Model model)
			throws Exception {
		Calendar cal = Calendar.getInstance();
		int year = cal.get(Calendar.YEAR);
		int month = cal.get(Calendar.MONTH) + 1;
		int day = cal.get(Calendar.DATE);
		log.info("bk_budget: "+book.getBk_budget());
		log.info("bookUpdatePOST() 호출");
		log.info("book: " + book);
		log.info("detail: " + detail);
		log.info("page: " + page);
		int result = service.updateBook(book);
//		int result = 0;
		if (result == 1) {
			int result2 = dService.updateBookDetail(detail);
			if (result2 == 1) {
				log.info("가계부 수정 완료");
				rttr.addFlashAttribute("msg4", "야호!😆😆😆");
				rttr.addFlashAttribute("msg4", "가계부 수정을 완료했어요!");
				return "redirect:/book/list?page="+page+ "&year="+year+ "&month="+month+"&day="+day;
			} else {
				log.info("가계부 수정 	실패");
				rttr.addFlashAttribute("msg", "가계부 수정에 실패했습니다.");
				return "redirect:/book/update?page=" + page + "&bk_num=" + book.getBk_num() + "&bk_detail_num="
						+ detail.getBk_detail_num();
			}
		} else {
			log.info("가계부 디테일 수정 실패");
			rttr.addFlashAttribute("msg", "가계부 수정에 실패했습니다.");
			return "redirect:/book/update?page=" + page + "&bk_num=" + book.getBk_num() + "&bk_detail_num="
					+ detail.getBk_detail_num();
		}
	}

	@RequestMapping(value = "/delete", method = RequestMethod.GET)
	public String bookDeleteGET(Integer bk_num, Integer bk_detail_num, RedirectAttributes rttr) throws Exception {
		log.info("bookDeleteGET() 호출");
		Calendar cal = Calendar.getInstance();
		int year = cal.get(Calendar.YEAR);
		int month = cal.get(Calendar.MONTH) + 1;
		int day = cal.get(Calendar.DATE);
	
		String loginID = (String) session.getAttribute("loginID");
		int result = dService.deleteBookDetail(bk_detail_num, loginID);
		if (result == 1) {
			log.info("가계부 삭제 성공");
			rttr.addFlashAttribute("msg", "가계부 삭제를 완료했습니다.");
			return "redirect:/book/list?page=1&year="+year+"&month="+month+"&day="+day;

		} else {
			log.info("가계부 삭제 실패");
			rttr.addFlashAttribute("msg", "가계부 삭제에 실패했습니다.");
			return "redirect:/book/list";
		}
	}

	public String category(String code) throws Exception {
		switch (code) {
		case "A1":
			return "가전/전자";
		case "B1":
			return "도서/문구";
		case "C1":
			return "패션/의류";
		case "D1":
			return "스포츠";
		case "E1":
			return "화장품";
		case "F1":
			return "아동/유아";
		case "G1":
			return "식품";
		case "H1":
			return "생활/가구";
		case "I1":
			return "여행/교통";
		case "J1":
			return "문화/레저";
		case "K1":
			return "음식";
		case "L1":
			return "e쿠폰/기타서비스";
		default:
			return "기타";
		}
	}
	
	
	// 카테고리!!!!!
	@RequestMapping(value = "/list/ctgr", method = RequestMethod.GET)
	public String bookListPageCtgrGET(PageVO vo, String ctgr, Integer bk_detail_num, Model model, int year, int month, int day,
			RedirectAttributes rttr) throws Exception {
		log.info("bookListPageCtgrGET()호출");
		log.info("(♥♥♥♥♥ bookListPageCtgrGET) 호출됨");
		log.info(year + "년 " + month + "월 가계부 불러오기");
		loginID = (String) session.getAttribute("loginID");
		double percent = 0;

		// 0. 로그인 여부 확인
		if (loginID == null) {
			rttr.addFlashAttribute("msg", "로그인 후 이용 가능합니다");
			return "redirect:/main/login";
		}

		PageMakerVO pm = new PageMakerVO();
		pm.setVo(vo);
		int cnt = dService.getMonthBookDetailCnt(loginID, year, month);
		pm.setTotalCnt(cnt);
		model.addAttribute("pm", pm);

		model.addAttribute("year", year);
		model.addAttribute("month", month);
		model.addAttribute("day", day);
		
		// 해당 연월의 가계부 불러오기
		log.info(loginID + "님의 " + year + "년 " + month + "월 가계부 불러오기");

		// 1-1. 해당 연월의 가계부가 있을 때
		if (service.getMonthBook(year, month, loginID) != null) {
			log.info(year + "년 " + month + "월 가계부가 있습니다.");

			List<BookDetailVO> detailList = new ArrayList<BookDetailVO>();
			detailList = dService.getMonthBookDetailListCtgr(year, month, loginID, pm, ctgr);
			log.info("가져온 가계부 개수: " + detailList.size());

			// 2-1. 디테일이 있을 때
			if (detailList.size() != 0) {
				log.info(year+"년 "+month+"월 가계부 구체 내역 있음");
				model.addAttribute("detailList", detailList);
				int bk_budget = service.getMonthBudget(loginID, year, month);

				// 3-1. 디테일도 있고 예산도 있을 때
				if (bk_budget > 0) {
					log.info("예산 있음");
					log.info(month+"월 예산: " + bk_budget + "만원");
					model.addAttribute("bk_budget", bk_budget);

					// 해당 달의 지출 합계
					int sum = service.getMonthBookMoney(loginID, year, month);
					log.info(month+"월 지출: " + sum + "원");
					if (sum > 0) model.addAttribute("sum", sum);
					else model.addAttribute("sum", 0);

					// 해당 달의 남은 예산(예산이 만원 단위이기 때문에 계산하기 전 10000을 곱해줘야 함)
					int restedBudget = (bk_budget * 10000) - sum;
					log.info("한 달 예산 중 남은 금액: " + restedBudget + "원");
					int restedBudget1 = ((bk_budget * 10000) - sum) / 10000;
					int restedBudget2 = (bk_budget * 10000 - sum) - (restedBudget1 * 10000);
					log.info("남은 예산: " + restedBudget1 + "만");
					log.info(restedBudget2 + "원");

					// 해당 달의 예산 대비 지출 퍼센트
					double moneyPercent = ((sum / (double) (bk_budget * 10000)) * 100);
					percent = Math.round(moneyPercent * 1000) / 1000;
					log.info("한 달 예산 대비 지출 퍼센트 :" + percent + "%");
					model.addAttribute("percent", percent);

					// 가계부 지출이 예산의 70%가 넘을 때
					if (moneyPercent >= 70) {
						log.info("예산의 70% 이상 지출");
						model.addAttribute("restedBudget1", restedBudget1);
						model.addAttribute("restedBudget2", restedBudget2);
						model.addAttribute("percent", percent);
					} else {
						model.addAttribute("restedBudget1", restedBudget1);
						model.addAttribute("restedBudget2", restedBudget2);
						model.addAttribute("year", year);
						model.addAttribute("month", month);
						model.addAttribute("percent", percent);

					}
				// 3-2. 디테일은 있지만 예산이 없을 때
				} else {
					log.info("예산 설정 안 함");
					model.addAttribute("bk_budget", 0);
					rttr.addFlashAttribute("msg3", "Opps!😅😅😅");
					rttr.addFlashAttribute("msg4", "아직 이번 달 예산을 작성하지 않으셨네요!");
					log.info("FlashAttribute 보내기 성공");
					// 해당 달의 지출 합계
					int sum = service.getMonthBookMoney(loginID, year, month);
					log.info(month+"월 지출: " + sum + "원");
					if (sum > 0) model.addAttribute("sum", sum);
					else model.addAttribute("sum", 0);
				}
			// 2-2. 해당 연 월의 가계부 디테일이 없을 때
			} else {
				log.info("아직 작성한 가계부 디테일이 없습니다.");
				model.addAttribute("msg1", "Oops!😅😅😅");
				model.addAttribute("msg2", "아직 가계부를 작성하지 않으셨네요~!");
				model.addAttribute("bk_budget", service.getMonthBudget(loginID, year, month));

				int bk_budget = service.getMonthBudget(loginID, year, month);

				// 3-1. 가계부는 없지만 예산은 있을 때
				if (bk_budget > 0) {
					log.info("한달 예산: " + bk_budget + "만원");
					model.addAttribute("bk_budget", bk_budget);
					model.addAttribute("sum", 0);
					model.addAttribute("bk_budget", bk_budget);

				// 가계부도 없고 예산도 없을 때
				} else {
					log.info("아무것도 없음,,,");
					model.addAttribute("bk_budget", 0);
					rttr.addFlashAttribute("msg1", "Opps!😅😅😅");
					rttr.addFlashAttribute("msg2", "아직 가계부를 작성하지 않으셨네요!");
				}
			}
		// 1-2. 해당 연 월의 가계부가 없을 때
		} else {
			log.info(year + "년 " + month + "월 가계부가 없으므로 새로 생성합니다.");
			BookVO book = new BookVO();
			book.setId(loginID);
			book.setBk_year(year);
			book.setBk_month(month);
			book.setBk_budget(0);
			service.writeBook(book);
			model.addAttribute("bk_budget", 0);
			rttr.addFlashAttribute("msg1", "Opps!😅😅😅");
			rttr.addFlashAttribute("msg2", "아직 가계부를 작성하지 않으셨네요!");
		}
		
		log.info("해당 월의 3달 전 예산 및 지출 담기");
		
		// 1, 2, 3 개월 전 예산 및 지출 구해서 보내기
		for(int i=1; i<4; i++) {
			if(month-i >0 ) {
				BookVO book = service.getMonthBook(year, month-i, loginID);
				log.info(i+" 전 달의 정보: "+book);
				// 가계부 불러오려 했는데 없으면 예산 0으로 새로 생성!
				if(book==null) {
					book = new BookVO();
					book.setBk_year(year);
					book.setBk_month(month-i);
					book.setBk_budget(0);
					book.setId(loginID);
					service.writeBook(book);
					log.info("CCCCCCCCCCC "+year+"년 "+(month-i)+"월 가계부 생성");
				}
				model.addAttribute("bfyear"+i, year);
				model.addAttribute("bfmonth"+i, month-i);
				int bfbudget = service.getMonthBudget(loginID, year, month-i);
				model.addAttribute("bfbudget"+i, bfbudget);
				int bfsum = service.getMonthBookMoney(loginID, year, month-i);
				log.info("year: "+year+", month:"+(month-i));
				log.info(i+"전 달 예산 및 지출: "+bfbudget+", "+bfsum);
				// i전 달의 예산이 있을 때
				if(bfbudget!=0) {
					// i전 달의 예산, 지출 모두 있을 때 
					if(bfsum!=0) {
						percent = (double)((bfsum/(bfbudget)))/100;
						model.addAttribute("bfpercent"+i, percent);
					// i전 달의 예산 지출 둘 다 없을 때
					} else {
						percent = 0;
					}
				// i전 달의 예산이 없을 때
				}else {
					percent = 0;
				}
			// 가계부에서 불러오려는 연 월이 지난 해일 경우!
			} else {
				model.addAttribute("bfyear"+i, year-1);
				model.addAttribute("bfmonth"+i, 13-i);
				int bfbudget = service.getMonthBudget(loginID, year-1, 13-i);
				model.addAttribute("bfbudget"+i, bfbudget);
				log.info("year: "+year+", month-"+i+": "+(month-i));
				int bfsum = service.getMonthBookMoney(loginID, year-1, 13-i);
				if(bfbudget!=0) {
					// i전 달의 예산, 지출 모두 있을 때 
					if(bfsum!=0) {
						percent = (double)((bfsum/(bfbudget*10000)))*100;
						model.addAttribute("bfpercent"+i, percent);
					// i전 달의 예산 지출 둘 다 없을 때
					} else {
						percent = 0;
					}
				// i전 달의 예산이 없을 때
				}else {
					percent = 0;
				}
			}
			model.addAttribute("bfpercent"+i, percent);
			log.info("CCCCCCCCCC bfmonth"+i+", bfyear"+i+", bfbudget"+i+", bfpercent"+i+"보내기 완료");
		}
		// 1, 2, 3 개월 전 예산 및 지출 구해서 보내기 끝 --------------------------
		return "/book/bookList";
	}
	
	
	
}
