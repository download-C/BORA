package com.bora.controller.report;

import java.util.List;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.bora.domain.report.ConsumeAllListVO;
import com.bora.domain.report.ConsumeLastMonListVO;
import com.bora.domain.report.ConsumeThisMonListVO;
import com.bora.service.report.ConsumeAllListService;

@Controller
@RequestMapping("/consume/*")
public class ConsumeController {
	
	@Inject
	ConsumeAllListService cService;

	private static final Logger log = LoggerFactory.getLogger(BookController.class);
	
	
	// 1. 저번달 소비 리스트
	@RequestMapping(value = "/consumeLastMonList", method = RequestMethod.GET)
	public void getConsumeLastMonList(Model model) throws Exception {
		// 전달된 정보 저장
		log.info("consumeLastMonList 호출됨");

		// 컨트롤러 -> 서비스 호출 (동작 메서드,,)
		log.info("consumeLastMonList -----> Service 호출됨");
			
		List<ConsumeLastMonListVO> consumeLastMonList = cService.getConsumeLastMonList("admin");

		model.addAttribute("consumeLastMonlist", consumeLastMonList);
	}
		
	// 2. 이번달 소비 리스트
	@RequestMapping(value = "/consumeThisMonList", method = RequestMethod.GET)
	public void getConsumeThisMonList(Model model) throws Exception {
		// 전달된 정보 저장
		log.info("consumeThisMonList 호출됨");

		// 컨트롤러 -> 서비스 호출 (동작 메서드,,)
		log.info("consumeThisMonList -----> Service 호출됨");

		List<ConsumeThisMonListVO> consumeThisMonList = cService.getConsumeThisMonList("admin");

		model.addAttribute("consumeThisMonlist", consumeThisMonList);
    }
		
	// 3. 소비 리스트 메서드
	@RequestMapping(value = "/consumeAllList", method = RequestMethod.GET)
	public void getConsumeAllList(Model model) throws Exception {
		// 전달된 정보 저장
		log.info("consumeAllList 호출됨");

		// 컨트롤러 -> 서비스 호출 (동작 메서드,,)
		log.info("consumeAllList -----> Service 호출됨");
	        
		// 서비스 - 
		List<ConsumeAllListVO> consumeAllList = cService.getConsumeAllList("admin");

		model.addAttribute("consumeAlllist", consumeAllList);

	}

}
