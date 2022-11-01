package com.bora.controller;

import java.io.File;
import java.io.IOException;
import java.rmi.server.UnicastRemoteObject;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.ibatis.javassist.util.proxy.ProxyFactory.UniqueName;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.multipart.MultipartRequest;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

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

	
//	// 0. 파일 업로드 메서드 (fileupload dependency 사용)
	
	public void fileUploadGET(MultipartFile file) {
		String fileRealName = file.getOriginalFilename(); //파일명을 얻어낼 수 있는 메서드!
		long size = file.getSize(); //파일 사이즈
		
		System.out.println("파일명 : "  + fileRealName);
		System.out.println("용량크기(byte) : " + size);
		//서버에 저장할 파일이름 fileextension으로 .jsp이런식의  확장자 명을 구함
		String fileExtension = fileRealName.substring(fileRealName.lastIndexOf("."),fileRealName.length());
		String uploadFolder = "C:\\Users\\USER\\git\\BORA\\src\\main\\webapp\\upload";

		/*
		  파일 업로드시 파일명이 동일한 파일이 이미 존재할 수도 있고 사용자가 
		  업로드 하는 파일명이 언어 이외의 언어로 되어있을 수 있습니다. 
		  타인어를 지원하지 않는 환경에서는 정산 동작이 되지 않습니다.(리눅스가 대표적인 예시)
		  고유한 랜던 문자를 통해 db와 서버에 저장할 파일명을 새롭게 만들어 준다.
		 */
		
		UUID uuid = UUID.randomUUID();
		System.out.println(uuid.toString());
		String[] uuids = uuid.toString().split("-");
		
		String uniqueName = uuids[0];
		System.out.println("생성된 고유문자열" + uniqueName);
		System.out.println("확장자명" + fileExtension);

		// File saveFile = new File(uploadFolder+"\\"+fileRealName); uuid 적용 전
		
		File saveFile = new File(uploadFolder+"\\"+uniqueName + fileExtension);  // 적용 후
		try {
			file.transferTo(saveFile); // 실제 파일 저장메서드(filewriter 작업을 손쉽게 한방에 처리해준다.)
		} catch (IllegalStateException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	
	// 파일 업로드 메서드 완성! 파일업로드 필요한 매핑 메서드에서 사용 후 return 값으로 들어오는 변환된 파일명으로 db에 저장하기!
//	@RequestMapping(value="/upload", method=RequestMethod.POST)
	public String uploadFilePOST(@RequestParam("n_file") MultipartFile file) {
		log.info("uploadFilePOST() 호출");
		String uploadFolder = "C:\\Users\\ITWILL\\Desktop\\upload";
		String fileRealName = file.getOriginalFilename();
		long size = file.getSize(); //파일 사이즈
		log.info("---------");
		log.info("파일명: "+fileRealName);
		log.info("파일 사이즈: "+size);
		// 기존의 파일명 그대로 저장하기
//		File saveFile = new File(uploadFolder, file.getOriginalFilename());
			
		// 파일 확장자명 구하기
		String fileExtension = fileRealName.substring(fileRealName.lastIndexOf("."),fileRealName.length());
		
		// 파일명이 겹칠 경우를 대비해서 고유 문자열 생성 후 파일 이름으로 지정
		UUID uuid = UUID.randomUUID();
		System.out.println(uuid.toString());
		String[] uuids = uuid.toString().split("-");
		String uniqueName = uuids[0];
		log.info("고유문자열 : "+uniqueName);
		
		String savingName = uniqueName + fileExtension;
		log.info("실제 저장되는 경로 및 이름: "+savingName);
		// 고유문자열로 만든 파일명으로 저장
		File saveFile = new File(uploadFolder+"\\"+savingName);  // 적용 후
		
		try {
			// 실제 파일 저장 메서드
			file.transferTo(saveFile);
		} catch (Exception e) {
			log.info(e+"");
		}
		
		return savingName;
//		return "/main/main";
	}
	
	// 1. 글쓰기 GET                       
	// http://localhost:8088/notice/write
	@RequestMapping (value = "/write", method = RequestMethod.GET)
	public String writeNoticeGET() throws Exception {
		log.info("(♥♥♥♥♥ writeNoticeGET) 호출됨");
		return "admin/noticeWrite";
	}
	// 1. 글쓰기 GET 끝

	
	// 1-2. 글쓰기 POST
	@RequestMapping (value="/write", method = RequestMethod.POST)
	public String writeNoticePOST(HttpServletRequest request, 
			NoticeVO vo, RedirectAttributes rttr, MultipartFile file) throws Exception {
		log.info("writeNoticePOST()호출");
		String n_title = request.getParameter("n_title");
		String n_content = request.getParameter("n_content");
		String savePath="C:\\\\Users\\\\ITWILL\\\\Desktop\\\\upload";
		 

		// 첨부파일이 있을 경우 업로드 후 고유파일명 삽입, 없을 경우 빈칸
		if(file==null) {
			vo.setN_file("");
		} else {
			String n_file = uploadFilePOST(file);
			vo.setN_file(n_file);
		}
		
		vo.setN_title(n_title);
		vo.setN_content(n_content);
		
		
		log.info("(♥♥♥♥♥ 1-2.writeNoticePOST) 호출됨");
		
		// 전달된 정보 저장
		log.info("(♥♥♥♥♥ 1-2.writeNoticePOST) 들어온 정보 NoticeVO: " + vo);
		
		// 컨트롤러 -> 서비스 호출 (글쓰기 동작,, 메서드,,)
		log.info("(♥♥♥♥♥ 1-2.writeNoticePOST) Service 호출할게요");
		service.writeNotice(vo);
		
		// 페이지 이동(글 목록으로)
		// 글쓰기 성공 알림 띄우기(일회성)
		rttr.addFlashAttribute("msg", "OK");  
		
		log.info("(♥♥♥♥♥ 1-2.registerPOST) redirect:/main/NoticeListPage 로 이동할거");
		return "redirect:/main/NoticeListPage"; // 주소줄 변화 O + 페이지 이동 O
	}
	// 1-2. 글쓰기 POST 끝
	
	

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
			rttr.addFlashAttribute("msg", "UPDATE_OK");
			
			// 수정 성공 시 --> NoticeListAll 페이지로 이동
			log.info("(♥♥♥♥♥ 4-1.updatePOST) 수정 성공^^ ㅊㅋㅊㅋ");
			log.info("(♥♥♥♥♥ 4-1.updatePOST) redirect:/main/NoticeListPage.jsp로 이동");
			return "redirect:/main/NoticeListPage"; // 주소줄 변화 O + 페이지 이동 O니까 redirect
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
			log.info("(♥♥♥♥♥ 5.deletePOST) redirect:/main/NoticeListPage.jsp로 이동");
			return "redirect:/main/NoticeListPage";
		} else {
			log.info("(♥♥♥♥♥ 5.deletePOST) 삭제 실패;;");
			return "redirect:/notice/delete";
		}
		
	}
}
