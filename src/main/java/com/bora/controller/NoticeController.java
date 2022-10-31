package com.bora.controller;

import java.io.File;
import java.io.IOException;
import java.rmi.server.UnicastRemoteObject;
import java.util.List;
import java.util.UUID;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import org.apache.ibatis.javassist.util.proxy.ProxyFactory.UniqueName;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.bora.domain.FileVO;
import com.bora.domain.NoticeVO;
import com.bora.domain.PageMakerVO;
import com.bora.domain.PageVO;
//import com.bora.service.NoticeService;
import com.bora.service.NoticeService;

@Controller
@RequestMapping("/notice/*")
public class NoticeController {
	// 멤버변수 ============================================
	private static final Logger log = LoggerFactory.getLogger(NoticeController.class);
	
   // 서비스 객체 필요~ root-context.xml 마트에 있는 거 주입하기
	@Inject
	private NoticeService service;
	
	// 멤버변수 끝 ============================================
	
//	// 0. 파일 업로드 메서드
//	public void upload(MultipartFile file) {
//		String fileRealName = file.getOriginalFilename(); //파일명을 얻어낼 수 있는 메서드!
//		long size = file.getSize(); //파일 사이즈
//		
//		System.out.println("파일명 : "  + fileRealName);
//		System.out.println("용량크기(byte) : " + size);
//		//서버에 저장할 파일이름 fileextension으로 .jsp이런식의  확장자 명을 구함
//		String fileExtension = fileRealName.substring(fileRealName.lastIndexOf("."),fileRealName.length());
//		String uploadFolder = "C:\\Users\\USER\\git\\BORA\\src\\main\\webapp\\upload";
//
//		/*
//		  파일 업로드시 파일명이 동일한 파일이 이미 존재할 수도 있고 사용자가 
//		  업로드 하는 파일명이 언어 이외의 언어로 되어있을 수 있습니다. 
//		  타인어를 지원하지 않는 환경에서는 정산 동작이 되지 않습니다.(리눅스가 대표적인 예시)
//		  고유한 랜던 문자를 통해 db와 서버에 저장할 파일명을 새롭게 만들어 준다.
//		 */
//		
//		UUID uuid = UUID.randomUUID();
//		System.out.println(uuid.toString());
//		String[] uuids = uuid.toString().split("-");
//		
//		String uniqueName = uuids[0];
//		System.out.println("생성된 고유문자열" + uniqueName);
//		System.out.println("확장자명" + fileExtension);
//
//		// File saveFile = new File(uploadFolder+"\\"+fileRealName); uuid 적용 전
//		
//		File saveFile = new File(uploadFolder+"\\"+uniqueName + fileExtension);  // 적용 후
//		try {
//			file.transferTo(saveFile); // 실제 파일 저장메서드(filewriter 작업을 손쉽게 한방에 처리해준다.)
//		} catch (IllegalStateException e) {
//			e.printStackTrace();
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
//	}
	// 파일 업로드 테스트 메서드
	@RequestMapping(value="/upload", method=RequestMethod.GET)
	public String uploadFileGET() {
		log.info("uploadFileGET() 호출");
		return "/admin/file";
	}
	
	
	// 파일 업로드 테스트 메서드
	@RequestMapping(value="/upload", method=RequestMethod.POST)
	public String uploadFilePOST(@RequestParam("n_file") MultipartFile[] uploadFile, Model model) {
		log.info("uploadFilePOST() 호출");
		String uploadFolder = "C:\\Users\\USER\\Desktop\\upload";
		for(MultipartFile file:uploadFile) {
			log.info("---------");
			log.info("파일명: "+file.getOriginalFilename());
			log.info("파일 사이즈: "+file.getSize());
			File saveFile = new File(uploadFolder, file.getOriginalFilename());
			try {
				file.transferTo(saveFile);
			} catch (Exception e) {
				log.info(e+"");
			}
		}
		return "/main/main";
	}
	
	// 1. 글쓰기 GET                       
	// http://localhost:8088/notice/write
	@RequestMapping (value = "/write", method = RequestMethod.GET)
	public String writeNoticeGET() throws Exception {
		log.info("(♥♥♥♥♥ writeNoticeGET) 호출됨");
		log.info("(♥♥♥♥♥ writeNoticeGET) 리턴타입 void라서 들어온 주소 /notice/write.jsp 로 이동할게요");
		return "admin/noticeWrite";
	}
	// 1. 글쓰기 GET 끝

	
	// 1-2. 글쓰기 POST
	@RequestMapping (value="/write", method = RequestMethod.POST)
	public String writeNoticePOST(MultipartFile[] file, 
			NoticeVO vo, RedirectAttributes rttr) throws Exception {
		
//		if(file!=null) {
//			uploadFile(file);
//		}
		
		log.info("(♥♥♥♥♥ 1-2.writeNoticePOST) 호출됨");
		
		// 전달된 정보 저장
		log.info("(♥♥♥♥♥ 1-2.writeNoticePOST) 들어온 정보 NoticeVO: " + vo);
		
		// 컨트롤러 -> 서비스 호출 (글쓰기 동작,, 메서드,,)
		log.info("(♥♥♥♥♥ 1-2.writeNoticePOST) Service 호출할게요");
		service.writeNotice(vo);
		
		// 페이지 이동(글 목록으로)
		// 글쓰기 성공 알림 띄우기(일회성)
		rttr.addFlashAttribute("msg", "OK");  
		
		log.info("(♥♥♥♥♥ 1-2.registerPOST) redirect:/notice/list 로 이동할거");
		return "redirect:/notice/listPage"; // 주소줄 변화 O + 페이지 이동 O
	}
	// 1-2. 글쓰기 POST 끝
	
	
	
	// 2. 게시판 리스트 조회 GET                  
//	 http://localhost:8088/notice/listAll
	@RequestMapping (value = "/listAll", method = RequestMethod.GET)
	public void getNoticeListAll(@ModelAttribute("msg") String msg, Model model, HttpSession session) throws Exception {
		log.info("(♥♥♥♥♥ 2.listAllGET) 호출됨");
		
		// 리스트로 가는 경우의 수
		// 1. 글쓰고 나서 -> 리스트로 이동하는 경우
			log.info("(♥♥♥♥♥ 2.listAllGET) msg: " + msg);
			// 연결된 view 페이지로 저기서(1-2.registerPOST) 넘어온 정보 전달해보기
			// 이거 안 해도 넘어가는딩?
			model.addAttribute("msg", msg);
		
		// 2. 걍 바로 리스트로 이동하는 경우
		
		log.info("(♥♥♥♥♥ 2.listAllGET) Service 호출할게욘");
		List<NoticeVO> noticeList = service.getNoticeListAll();
		
		log.info("(♥♥♥♥♥ 2.listAllGET) Service로부터 정보 받아옴^^ noticeList.size: " + noticeList.size());
		
		model.addAttribute("noticeList", noticeList);
		log.info("(♥♥♥♥♥ 2.listAllGET) 모델 객체에 저장 완");
		
		// 세션에 객체 isUpdate 하나  만들어놓기~~~ 
		//    3()으로 정보 전달을 위해..
		session.setAttribute("isUpdate", false);
		
		log.info("(♥♥♥♥♥ 2.listAllGET) 리턴타입 void.. /notice/listAll 입력받았으니 --> /notice/listAll.jsp로 이동할 거");
	}
	// 2. 게시판 리스트 조회 GET 끝
	
	
	
	// 2-1. 페이징 처리 적용한 게시판 리스트 조회 GET        
	// http://localhost:8088/notice/list
	@RequestMapping (value = "/listPage", method = RequestMethod.GET)
	public String getNoticeListGET(PageVO vo, Model model, HttpSession session) throws Exception {
		log.info("(♥♥♥♥♥ 2-1.getNoticeListGET) 호출됨");
		
		vo = new PageVO();
		
		log.info("(♥♥♥♥♥ 2-1.getNoticeListGET) Service 호출할게욘");
		model.addAttribute("noticeList", service.getNoticeListPage(vo));
		log.info("(♥♥♥♥♥ 2-1.getNoticeListGET)   + 모델 객체에 저장까지 완");
		
		// 페이징 처리 하단부 정보 저장 + 모델 객체(pm)에 저장
		PageMakerVO pm = new PageMakerVO();
		pm.setVo(vo);
		pm.setTotalCnt(100); 
		model.addAttribute("pm", pm);
		log.info("(♥♥♥♥♥ 2-1.getNoticeListGET) PageMakerVO도 모델 객체에 저장 완 + pm: " + pm);
		
		
		// 세션에 객체 isUpdate 하나  만들어놓기~~~ 
		//    3()으로 정보 전달을 위해..
		session.setAttribute("isUpdate", false);
		
		log.info("(♥♥♥♥♥ 2-1.getNoticeListGET) 리턴타입 void라서 들어온 주소 /notice/list.jsp로 이동할 거");
		
		return "/notice/listAll";
	}
	
	// 3. 글 본문 보기 GET                  
	// http://localhost:8088/notice/content
	@RequestMapping (value = "/content", method = RequestMethod.GET)
	public void contentGET(HttpSession session, 
						@RequestParam("nno") int nno, 
						@RequestParam("page") int page, 
						Model model) throws Exception{ 
		log.info("(♥♥♥♥♥ 3.contentGET) 호출됨");
		
		log.info("(♥♥♥♥♥ 3.contentGET) 넘어온 nno: " + nno);

		log.info("(♥♥♥♥♥ 3.contentGET) isUpdate: " + session.getAttribute("isUpdate"));
		boolean isUpdate = (boolean)session.getAttribute("isUpdate");
		
		if(!isUpdate) { 
			service.updateNoticeReadcount(nno);
			log.info("(♥♥♥♥♥ 3.contentGET) " + nno + "번 글 조회수 1 증가 완");
			session.setAttribute("isUpdate", true);
		}
		
		log.info("(♥♥♥♥♥ 3.contentGET) Service 호출 -> NoticeVO타입 리턴받고 -> 바로 model에 저장");
		model.addAttribute("vo", service.getNotice(nno));
		
		log.info("(♥♥♥♥♥ 3.contentGET) 리턴타입 void니까 들어온 주소  /notice/content.jsp로 이동할 거");
	}
	
	
	
	// 4. 글 수정하기 GET (기존 정보 조회 + 뉴 정보 입력받기)    
	// http://localhost:8088/notice/update
	@RequestMapping (value = "/update", method = RequestMethod.GET)
	public String updateGET(@RequestParam("nno") int nno, Model model) throws Exception {
		log.info("(♥♥♥♥♥ 4.updateGET) 호출됨");
		
		log.info("(♥♥♥♥♥ 4.updateGET) nno: " + nno);
		
		// nno에 해당하는 글 정보 가져오기 (service 사용해서),, 밑에 바아로 넣기!!
		// 연결된 뷰에 정보 전달 (用 Model 객체)
		model.addAttribute("vo", service.getNotice(nno));
		
		// 페이지 이동(기존 nno번 글 정보 출력)  -> /notice/update
		log.info("(♥♥♥♥♥ 4.updateGET) 리턴타입 void니까 들어온 주소 /notice/update.jsp로 이동");
		return "/admin/noticeUpdate";
	}
	
	// 4-1. 글 수정하기 POST  (수정할 new 데이터 처리)
	@RequestMapping(value = "/update", method = RequestMethod.POST)
	public String modifyPOST(NoticeVO vo, RedirectAttributes rttr) throws Exception {
		log.info("(♥♥♥♥♥ 4-1.updatePOST) 호출됨");
		log.info("(♥♥♥♥♥ 4-1.updatePOST) 수정할 정보들 잘 넘어왔나? vo: " + vo);
		
		// service_글 수정 메서드 호출
		int cnt = service.updateNotice(vo);
		
		if(cnt == 1) {
			rttr.addFlashAttribute("msg", "MOD_OK");
			
			// 수정 성공 시 --> listAll 페이지로 이동
			log.info("(♥♥♥♥♥ 4-1.updatePOST) 수정 성공^^ ㅊㅋㅊㅋ");
			log.info("(♥♥♥♥♥ 4-1.updatePOST) redirect:/notice/list.jsp로 이동");
			return "redirect:/notice/listPage"; // 주소줄 변화 O + 페이지 이동 O니까 redirect
		} else {
			log.info("(♥♥♥♥♥ 4-1.updatePOST) 수정 실패;;  /update?nno=" + vo.getNno()+ ".jsp로 이동");
			return "/admin/noticeUpdate?nno="+vo.getNno();
		}
		
	}

	// 5. 글삭 POST
	@RequestMapping (value = "/delete", method = RequestMethod.POST)
	public String removePOST(@RequestParam("nno") int nno, RedirectAttributes rttr) throws Exception {
		log.info("(♥♥♥♥♥ 5.deletePOST) 호출됨");
		
		// 전달 정보(nno) 저장하기..는 이미 완
		log.info("(♥♥♥♥♥ 5.deletePOST) 넘어온 nno: " + nno);
		
		// 서비스_글 삭제 메서드 호출
		int result = service.deleteNotice(nno);
		
		if(result == 1) {
			rttr.addAttribute("msg", "DEL_OK");
			log.info("(♥♥♥♥♥ 5.deletePOST) 삭제 성공");
			log.info("(♥♥♥♥♥ 5.deletePOST) redirect:/notice/list.jsp로 이동");
			return "redirect:/notice/list";
		} else {
			log.info("(♥♥♥♥♥ 5.deletePOST) 삭제 실패;;");
			return "redirect:/notice/delete";
		}
		
	}
}
