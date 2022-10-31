package com.bora.controller;

import java.util.List;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.bora.domain.BoardVO;
import com.bora.domain.PageMakerVO;
import com.bora.domain.PageVO;
import com.bora.service.BoardService;

@Controller
@RequestMapping("/board/*")
public class BoardController {
	// 멤버변수 ============================================
	private static final Logger log = LoggerFactory.getLogger(BoardController.class);
	
	   // 서비스 객체 필요~ root-context.xml 마트에 있는 거 주입하기
	@Inject
	private BoardService service;
	
	// 멤버변수 끝 ============================================
	
	
	
	// 1. 글쓰기 GET                       http://localhost:8088/board/insert
	@RequestMapping (value = "/insert", method = RequestMethod.GET)
	public void insertBoardGET() throws Exception {
		log.info("(♥♥♥♥♥ insertBoardGET) 호출됨");
		log.info("(♥♥♥♥♥ insertBoardGET) 리턴타입 void라서 들어온 주소 /board/insert.jsp 로 이동할게요");
	}
	// 1. 글쓰기 GET 끝
	
	
	
	// 1-2. 글쓰기 POST
	@RequestMapping (value="/insert", method = RequestMethod.POST)
	public String insertBoardPOST(BoardVO vo, RedirectAttributes rttr) throws Exception {
		log.info("(♥♥♥♥♥ 1-2.insertBoardPOST) 호출됨");
		
		// 전달된 정보 저장
		log.info("(♥♥♥♥♥ 1-2.insertBoardPOST) 들어온 정보 BoardVO: " + vo);
		
		// 컨트롤러 -> 서비스 호출 (글쓰기 동작,, 메서드,,)
		log.info("(♥♥♥♥♥ 1-2.insertBoardPOST) Service 호출할게요");
		service.insertBoard(vo);
		
		// 페이지 이동(글 목록으로)
			// 글쓰기 성공 알림 띄우기(일회성)
		rttr.addFlashAttribute("msg", "OK");  
		
		log.info("(♥♥♥♥♥ 1-2.registerPOST) redirect:/board/list 로 이동할거");
		return "redirect:/board/list"; // 주소줄 변화 O + 페이지 이동 O
	}
	// 1-2. 글쓰기 POST 끝
	
	
	
//	// 2. 게시판 리스트 조회 GET                  http://localhost:8088/board/list
//	@RequestMapping (value = "/list", method = RequestMethod.GET)
//	public void listAllGET(@ModelAttribute("msg") String msg, Model model, HttpSession session) throws Exception {
//		log.info("(♥♥♥♥♥ 2.listAllGET) 호출됨");
//		
//		// 리스트로 가는 경우의 수
//		// 1. 글쓰고 나서 -> 리스트로 이동하는 경우
//			log.info("(♥♥♥♥♥ 2.listAllGET) msg: " + msg);
//			// 연결된 view 페이지로 저기서(1-2.registerPOST) 넘어온 정보 전달해보기
//			// 이거 안 해도 넘어가는딩?
//			model.addAttribute("msg", msg);
//		
//		// 2. 걍 바로 리스트로 이동하는 경우
//		
//		log.info("(♥♥♥♥♥ 2.listAllGET) Service 호출할게욘");
//		List<BoardVO> boardList = service.getBoardListAll();
//		
//		log.info("(♥♥♥♥♥ 2.listAllGET) Service로부터 정보 받아옴^^ boardList.size: " + boardList.size());
//		
//		model.addAttribute("boardList", boardList);
//		log.info("(♥♥♥♥♥ 2.listAllGET) 모델 객체에 저장 완");
//		
//		// 세션에 객체 isUpdate 하나  만들어놓기~~~ 
//		//    3()으로 정보 전달을 위해..
//		session.setAttribute("isUpdate", false);
//		
//		log.info("(♥♥♥♥♥ 2.listAllGET) 리턴타입 void.. /board/listAll 입력받았으니 --> /board/listAll.jsp로 이동할 거");
//	}
	// 2. 게시판 리스트 조회 GET 끝
	
	
	
	// 2-1. 페이징 처리 적용한 게시판 리스트 조회 GET        http://localhost:8088/board/list
	@RequestMapping (value = "/list", method = RequestMethod.GET)
	public void getBoardListGET(PageVO vo, Model model, HttpSession session) throws Exception {
		log.info("(♥♥♥♥♥ 2-1.getBoardListGET) 호출됨");
		
		vo = new PageVO();
//		vo.setPage(1);
//		vo.setPerPageNum(30); // 글 30개씩 불러오고 싶다~ ㅋ
		// 근데 여기서 이렇게 페이지 설정하지 말고!! 파라메타로 해버리자
		// 자동으로 파라메타 수집해주니까,,,,,,,,,,
		// ㄴ   http://localhost:8088/board/listPage?page=2
		//      http://localhost:8088/board/listPage?page=2&perPageNum=30
		
		log.info("(♥♥♥♥♥ 2-1.getBoardListGET) Service 호출할게욘");
		model.addAttribute("boardList", service.getBoardList(vo));
		log.info("(♥♥♥♥♥ 2-1.getBoardListGET)   + 모델 객체에 저장까지 완");
		
		// 페이징 처리 하단부 정보 저장 + 모델 객체(pm)에 저장
		PageMakerVO pm = new PageMakerVO();
		pm.setVo(vo);
		pm.setTotalCnt(100); // <<찐 글 개수 임의로 일단 넣은거고,, 서비스에 이 동작 추가해놓으면 되겠네~ 총 글 개수 불ㄹ러오는
		model.addAttribute("pm", pm);
		log.info("(♥♥♥♥♥ 2-1.getBoardListGET) PageMakerVO도 모델 객체에 저장 완 + pm: " + pm);
		
		
		// 세션에 객체 isUpdate 하나  만들어놓기~~~ 
		//    3()으로 정보 전달을 위해..
		session.setAttribute("isUpdate", false);
		
		log.info("(♥♥♥♥♥ 2-1.getBoardListGET) 리턴타입 void라서 들어온 주소 /board/list.jsp로 이동할 거");
	}
	// 2-1. 페이징 처리 적용한 게시판 리스트 조회 GET
	
	
	
	// 3. 글 본문 보기 GET                  http://localhost:8088/board/read
	@RequestMapping (value = "/read", method = RequestMethod.GET)
	public void readGET(HttpSession session, 
						@RequestParam("bno") int bno, 
						@RequestParam("page") int page, 
						Model model) throws Exception{ 
		log.info("(♥♥♥♥♥ 3.readGET) 호출됨");
		
		// 직전 페이지(list.jsp)에서 전달된 정보(bno) 저장
		log.info("(♥♥♥♥♥ 3.readGET) 넘어온 bno: " + bno);
		
		// 한 번 이 글 본 사람은 더이상 조회수 안 올라가게~~~ 
		// boolean isUpdate 이용,, 2()에서 세션에 저장해놓은 거 여기서 넘겨받음
		log.info("(♥♥♥♥♥ 3.readGET) isUpdate: " + session.getAttribute("isUpdate"));
		boolean isUpdate = (boolean)session.getAttribute("isUpdate");
		
		if(!isUpdate) { 
			// 세션에 isUpdate 정보가 없을 때~~
			// 조회수 계산하는 3-1 updateReadCount !!! 
			service.updateReadCount(bno);
			log.info("(♥♥♥♥♥ 3.readGET) " + bno + "번 글 조회수 1 증가 완");
			session.setAttribute("isUpdate", true);
		}
		
		log.info("(♥♥♥♥♥ 3.readGET) Service 호출 -> BoardVO타입 리턴받고 -> 바로 model에 저장");
		model.addAttribute("vo", service.getBoard(bno));
		
		log.info("(♥♥♥♥♥ 3.readGET) 리턴타입 void니까 들어온 주소  /board/read.jsp로 이동할 거");
	}
	// 3. 글 본문 보기 GET 끝
	
	
	
	// 4. 글 수정하기 GET (기존 정보 조회 + 뉴 정보 입력받기)    http://localhost:8088/board/update
	@RequestMapping (value = "/update", method = RequestMethod.GET)
	public void updateGET(@RequestParam("bno") int bno, Model model) throws Exception {
		log.info("(♥♥♥♥♥ 4.updateGET) 호출됨");
		
		log.info("(♥♥♥♥♥ 4.updateGET) bno: " + bno);
		
		// bno에 해당하는 글 정보 가져오기 (service 사용해서),, 밑에 바아로 넣기!!
		// 연결된 뷰에 정보 전달 (用 Model 객체)
		model.addAttribute("vo", service.getBoard(bno));
		
		// 페이지 이동(기존 bno번 글 정보 출력)  -> /board/update
		log.info("(♥♥♥♥♥ 4.updateGET) 리턴타입 void니까 들어온 주소 /board/update.jsp로 이동");
	}
	// 4. 글 수정하기 GET (기존 정보 조회 + 뉴 정보 입력받기) 끝
	
	
	
	// 4-1. 글 수정하기 POST  (수정할 new 데이터 처리)
	@RequestMapping(value = "/update", method = RequestMethod.POST)
	public String modifyPOST(BoardVO vo, RedirectAttributes rttr) throws Exception {
		log.info("(♥♥♥♥♥ 4-1.updatePOST) 호출됨");
		log.info("(♥♥♥♥♥ 4-1.updatePOST) 수정할 정보들 잘 넘어왔나? vo: " + vo);
		
		// service_글 수정 메서드 호출
		int cnt = service.updateBoard(vo);
		
		if(cnt == 1) {
			rttr.addFlashAttribute("msg", "MOD_OK");
			
			// 수정 성공 시 --> listAll 페이지로 이동
			log.info("(♥♥♥♥♥ 4-1.updatePOST) 수정 성공^^ ㅊㅋㅊㅋ");
			log.info("(♥♥♥♥♥ 4-1.updatePOST) redirect:/board/list.jsp로 이동");
			return "redirect:/board/list"; // 주소줄 변화 O + 페이지 이동 O니까 redirect
		} else {
			log.info("(♥♥♥♥♥ 4-1.updatePOST) 수정 실패;;  /update?bno=" + vo.getBno()+ ".jsp로 이동");
			return "/board/update?bno="+vo.getBno();
		}
		
	}
	// 4-1. 글 수정하기 POST  (수정할 new 데이터 처리) 끝
	
	
	
	// 5. 글삭 POST
	@RequestMapping (value = "/delete", method = RequestMethod.POST)
	public String removePOST(@RequestParam("bno") int bno, RedirectAttributes rttr) throws Exception {
		log.info("(♥♥♥♥♥ 5.deletePOST) 호출됨");
		
		// 전달 정보(bno) 저장하기..는 이미 완
		log.info("(♥♥♥♥♥ 5.deletePOST) 넘어온 bno: " + bno);
		
		// 서비스_글 삭제 메서드 호출
		int result = service.deleteBoard(bno);
		
		if(result == 1) {
			rttr.addAttribute("msg", "DEL_OK");
			log.info("(♥♥♥♥♥ 5.deletePOST) 삭제 성공");
			log.info("(♥♥♥♥♥ 5.deletePOST) redirect:/board/list.jsp로 이동");
			return "redirect:/board/list";
		} else {
			log.info("(♥♥♥♥♥ 5.deletePOST) 삭제 실패;;");
			return "redirect:/board/list";
		}
		
	}
	// 5. 글삭 POST 끝
}
