package com.bora.controller.report;

import java.util.List;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.bora.domain.report.ConsumeAllListVO;
import com.bora.domain.report.ConsumeLastThisListVO;
import com.bora.domain.report.ConsumePageVO;
import com.bora.service.report.ConsumeAllListService;

@Controller
@RequestMapping("/consume/*")
public class ConsumeController {
	
	@Inject
	ConsumeAllListService cService;

	private static final Logger log = LoggerFactory.getLogger(BookController.class);
		
	// 소비 리스트 메서드
	@RequestMapping(value = "/consumeAllList", method = RequestMethod.GET)
	public String getConsumeAllList(Model model, ConsumeLastThisListVO consumeLastThis 
			,ConsumeAllListVO consumeAllList, 
			HttpServletRequest request) throws Exception {
		// 목록 데이터
		String consumePageNum = request.getParameter("consumePageNum");
		if(consumePageNum == null) {
			consumePageNum = "1";
		}
		int consumePageSize = 3;
		int consumeCurrentPage = Integer.parseInt(consumePageNum);
		// ConsumePageVO에 페이징 관련 정보를 담아서 감
		ConsumePageVO vo = new ConsumePageVO();
		vo.setConsumePageNum(consumePageNum);
		vo.setConsumePageSize(consumePageSize);
		vo.setConsumeCurrentPage(consumeCurrentPage);
		
		// 1. 저번, 이번 달 소비 리스트
		// 전달된 정보 저장
		log.info("consumeLastThisList 호출됨");

		// 컨트롤러 -> 서비스 호출 (동작 메서드,,)
		log.info("consumeLastThisList -----> Service 호출됨");

		List<ConsumeLastThisListVO> consumeLastThisList = cService.getConsumeLastThisList(vo);

		
		// 3. 이번 소비 비교 리스트
		// 전달된 정보 저장
		log.info("consumeAllList 호출됨");

		// 컨트롤러 -> 서비스 호출 (동작 메서드,,)
		log.info("consumeAllList -----> Service 호출됨");
	        
		// 서비스 - 
		List<ConsumeAllListVO> consumeList = cService.getConsumeAllList(vo);
		
		// 전체 글 개수
		int consumeCnt = cService.getConsumeCount();
		// 페이지 처리
		int consumePageCount = consumeCnt/consumePageSize + 
				(consumeCnt%consumePageSize == 0? 0:1);
		int consumePageBlock = 3;
		int consumeStartPage = ((consumeCurrentPage-1)/consumePageBlock)*consumePageBlock+1;
		int consumeEndPage = consumeStartPage + consumePageBlock - 1;
		if(consumeEndPage > consumePageCount) {
			consumeEndPage = consumePageCount;
		}
		vo.setConsumeCnt(consumeCnt);
		vo.setConsumePageCount(consumePageCount);
		vo.setConsumePageBlock(consumePageBlock);
		vo.setConsumeStartPage(consumeStartPage);
		vo.setConsumeEndPage(consumeEndPage);
        
		int bk_lastmon_total = Integer.parseInt(request.getParameter("bk_lastmon_total"));
		int bk_thismon_total = Integer.parseInt(request.getParameter("bk_thismon_total"));
		int bk_total_consume = (bk_thismon_total - bk_lastmon_total);
		int bk_consume_compare = ((bk_thismon_total - bk_lastmon_total)/ bk_lastmon_total) * 100;
		
		consumeLastThis.setBk_lastmon_total(bk_lastmon_total);
		consumeLastThis.setBk_thismon_total(bk_thismon_total);
		consumeAllList.setBk_total_consume(bk_total_consume);
		consumeAllList.setBk_consume_compare(bk_consume_compare);
		
		model.addAttribute("consumeLastThisList", consumeLastThisList);
		model.addAttribute("consumeList", consumeList);
		model.addAttribute("vo", vo);
		
		return "book/consumeAllList";
	}

	
}
