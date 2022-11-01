package com.bora.controller;

import java.io.File;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

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
	
	
	@RequestMapping(value="/notice/upload", method = RequestMethod.POST)
	public List<String> uploadProcess(MultipartHttpServletRequest multi) throws Exception{
		log.info("fileUploadPOST() 호출");
		log.info("multi: "+multi);
		Enumeration enu = multi.getParameterNames();
		log.info("enu: "+enu);
		Map<String, String> map = new HashMap<>();
		map.put("id", multi.getParameter("id"));
		map.put("email",multi.getParameter("email"));
		// 파일의 원제목을 담을 리스트
		List<String> fileList = new ArrayList<String>();
		Iterator<String> fileNames = multi.getFileNames();
		while(fileNames.hasNext()) {
			String fileName = fileNames.next();
			log.info("파일명: "+fileName);
			MultipartFile mfile = multi.getFile(fileName);
			String ofileName = mfile.getOriginalFilename();
			log.info("원래 파일명: "+ofileName);
			fileList.add(ofileName);
			
			// 파일을 저장소에 저장하기 위한 파일 객체 생성 후 지정
//			File file = new File("저장경로"+"\\"+"원래파일명");
			File file = new File("C:\\user\\ITWILL\\upload"+"\\"+ofileName);
			
			// 멀티파트로 가져온 파일의 사이즈가 0이 아닐 때 == 파일이 있을 때
			if(mfile.getSize() != 0) {
				file.createNewFile();
				log.info("파일 업로드 성공");
			}
		}// while	
		log.info("첨부파일 처리 끝");
		return fileList;
	}
}
