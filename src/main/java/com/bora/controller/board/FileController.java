package com.bora.controller.board;

import java.io.File;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;


@Controller
public class FileController {
	
	private static final Logger log = LoggerFactory.getLogger(FileController.class);
	
	// http://localhost:8088/notice/upload
	// 파일 업로드 테스트
	@RequestMapping(value="/notice/upload", method=RequestMethod.GET)
	public String fileUpload() {
		return "/admin/file";
	}
	
	@RequestMapping(value="/file/upload", method = RequestMethod.POST)
	public String fileUploadPOST(MultipartHttpServletRequest multi) throws Exception {
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
		fileProcess(multi);
		
		return "/main/main";
	}
	
	
	public List<String> fileProcess(MultipartHttpServletRequest multi) throws Exception{
		log.info("첨부파일 처리 시작");
		// 파일의 원제목을 담을 리스트
		List<String> fileList = new ArrayList<String>();
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
			String uploadFolder = "C:\\Users\\ITWILL\\Desktop\\upload";
			
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
			// 파일을 저장소에 저장하기 위한 파일 객체 생성 후 지정
			//			File file = new File("저장경로"+"\\"+"원래파일명");	
			// 지정된 위치에 파일 저장(위치\\바뀐이름.확장자)
			File file = new File(uploadFolder+"\\"+uniqueName+fileExtension);
			
			// 멀티파트로 가져온 파일의 사이즈가 0이 아닐 때 == 파일이 있을 때
			if(mfile.getSize() != 0) {
				// 첨부파일 업로드
				mfile.transferTo(file);
				log.info("파일 업로드 성공");
			}
		}// while	
		log.info("첨부파일 처리 끝");
		return fileList;
	}
}
