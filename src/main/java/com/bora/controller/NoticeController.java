package com.bora.controller;

import java.io.File;
import java.io.IOException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.HashMap;
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

import com.bora.domain.board.NoticeVO;
import com.bora.domain.board.PageMakerVO;
import com.bora.domain.board.PageVO;
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

	
//	// 0. 파일 처리 메서드 (파일명 중 확장자를 제외한 부분을 바꿔서 따로 처리)
	public String fileProcess(MultipartHttpServletRequest multi) throws Exception{
		log.info("첨부파일 처리 시작");
		// 파일의 원제목을 담을 리스트
		List<String> fileList = new ArrayList<String>();
		String uploadedFileName ="";
		// 다음 정보가 있을 경우 차례대로 불러주기
		Iterator<String> fileNames = multi.getFileNames();
		while(fileNames.hasNext()) {
			// 파일의 파라미터명(name)
			String fileName = fileNames.next();
			log.info("파라미터명: "+fileName);
			// 업로드된 파일 정보 가져오기
			MultipartFile mfile = multi.getFile(fileName);
			// 업로드된 파일의 원래 이름 가져오기
			String ofileName = mfile.getOriginalFilename();
			// 파일 확장자
			String fileExtension = ofileName.substring(ofileName.lastIndexOf("."),ofileName.length());
			// 저장 위치
			String uploadFolder = "C:\\Users\\ITWILL\\git\\BORA\\src\\main\\webapp\\resources\\upload";
			
			log.info("원래 파일명: "+ofileName);
			// 업로드될 파일 이름들 저장
			fileList.add(ofileName);
			
			// 파일명이 중복되는 것을 방지하기 위해 바꿔주기
			UUID uuid = UUID.randomUUID();
			System.out.println(uuid.toString());
			String[] uuids = uuid.toString().split("-");
			String uniqueName = uuids[0];
			System.out.println("생성된 고유문자열" + uniqueName);
			System.out.println("확장자명" + fileExtension);
			
			// 저장소에 저장될 바뀔 파일명
			uploadedFileName = uniqueName+fileExtension;
			
			// 파일을 저장소에 저장하기 위한 파일 객체 생성 후 지정
			//			File file = new File("저장경로"+"\\"+"원래파일명");	
			// 지정된 위치에 파일 저장(위치\\바뀐이름.확장자)
			
			File file = new File(uploadFolder+"\\"+uploadedFileName);
			
			// 멀티파트로 가져온 파일의 사이즈가 0이 아닐 때 == 파일이 있을 때
			if(mfile.getSize() != 0) {
				// 첨부파일 업로드
				mfile.transferTo(file);
				log.info("파일 업로드 성공");
			}
		}// while	
		log.info("첨부파일 처리 끝");
		return uploadedFileName;
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
	public String noticeWritePOST(MultipartHttpServletRequest multi,
			HttpSession session) throws Exception {
		log.info("fileUploadPOST() 호출");
		log.info("multi: "+multi);
				
		// 파일 정보를 담을 객체 생성
		Map<String, String> map = new HashMap<>();
		// 뷰 파일의 파라미터와 값을 자동으로 불러줄 객체 생성
		Enumeration enu = multi.getParameterNames();
		while(enu.hasMoreElements()) {
			// 파라미터 이름 불러오기
			String name = (String)enu.nextElement();
			// 해당 이름의 파라미터 값 가져오기
			String value = multi.getParameter(name);
			// 가져온 파라미터의 이름과 값 넣기
			map.put(name, value);
		}
		log.info("들어온 파라미터: "+map);
		// 들어온 값 중 파일은 파일 프로세스로 처리하기
		String uploadedFileName = fileProcess(multi);
		log.info("fileName: "+uploadedFileName);
		NoticeVO vo = new NoticeVO();
		vo.setN_title(map.get("n_title"));
		vo.setN_content(map.get("n_content"));
		vo.setN_file(uploadedFileName);
		log.info("vo: "+vo);
		
		service.writeNotice(vo);
		
		return "redirect:/main/noticeList";
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
	public String modifyPOST(NoticeVO vo, RedirectAttributes rttr, 
			MultipartHttpServletRequest multi) throws Exception {

		
		log.info("(♥♥♥♥♥ 4-1.updatePOST) 호출됨");
		log.info("(♥♥♥♥♥ 4-1.updatePOST) 수정할 정보들 잘 넘어왔나? vo: " + vo);
		log.info("수정된 정보: "+vo);
		// 파일 정보를 담을 객체 생성
		Map<String, String> map = new HashMap<>();
		// 뷰 파일의 파라미터와 값을 자동으로 불러줄 객체 생성
		Enumeration enu = multi.getParameterNames();
		while(enu.hasMoreElements()) {
			// 파라미터 이름 불러오기
			String name = (String)enu.nextElement();
			// 해당 이름의 파라미터 값 가져오기
			String value = multi.getParameter(name);
			// 가져온 파라미터의 이름과 값 넣기
			map.put(name, value);
		} 
		log.info("들어온 파라미터: "+map);
		// 들어온 값 중 파일은 파일 프로세스로 처리하기
		
		vo.setN_title(map.get("n_title"));
		vo.setN_content(map.get("n_content"));
		// 전달해준 값 중에 파일이 들어있는지 확인
		List<MultipartFile> fileList = multi.getFiles("uploadFile");
		log.info("업로드한 파일의 크기 : "+fileList.size());
		if(fileList.size()!=0 
				&& !fileList.get(0).getOriginalFilename().equals("")){ // 파일 사이즈가 0이 아님 -> 파일이 들어옴
			log.info("파일이 바뀌었으므로 새로운 이름 넣기");
			String uploadedFileName = fileProcess(multi);
			log.info("fileName: "+uploadedFileName);
			vo.setN_file(uploadedFileName);
		}else {
			log.info("새로 들어온 첨부파일이 없으므로 있는 그대로의 파일명 가져가기");
		}
		log.info("vo: "+vo);
		
		service.updateNotice(vo);
		
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
	public String deletePOST(@RequestParam("nno") int nno,
			RedirectAttributes rttr) throws Exception {
		log.info("(♥♥♥♥♥ 5.deletePOST) 호출됨");
		
		// 전달 정보(nno) 저장하기..는 이미 완
		log.info("(♥♥♥♥♥ 5.deletePOST) 넘어온 nno: " + nno);
		
		// 서비스_글 삭제 메서드 호출
		int result = service.deleteNotice(nno);
		
		if(result == 1) {
			rttr.addAttribute("msg", nno+"번 공지사항이 삭제되었습니다.");
			log.info("(♥♥♥♥♥ 5.deletePOST) 삭제 성공");
			log.info("(♥♥♥♥♥ 5.deletePOST) redirect:/main/NoticeListPage.jsp로 이동");
			return "redirect:/main/NoticeListPage";
		} else {
			log.info("(♥♥♥♥♥ 5.deletePOST) 삭제 실패;;");
			return "redirect:/main/noticeRead?nno="+nno+"&page=1";
		}
		
	}
}
