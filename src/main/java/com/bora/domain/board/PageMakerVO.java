package com.bora.domain.board;

import com.bora.domain.board.PageVO;

import lombok.Data;

@Data
public class PageMakerVO {
	// 페이징 처리에 관한 모든 동작 관리( 개수 출력 + 하단 페이징 블럭)
	
	private int totalCnt;	// 총 글의 수
	private int pageStart;  // 페이지 블럭 시작페이지
	private int endPage;	// 페이지 블럭 끝 페이지
	private boolean prev;		// 이전
	private boolean next;		// 다음

	
//	private int perPageNum;
	private PageVO vo;		// 페이지 번호, 페이지의 크기
	
	private int displayPageNum = 10;   // 페이지 블럭의 크기 

	public void setTotalCnt(int totalCnt) {
		this.totalCnt = totalCnt;  //DB에서 계산된 값으로 초기화
		
		calcData();
	}

	public int getStartRow() {
		return (vo.getPage()-1)*vo.getPerPageNum();
	}
	
	public void calcData() {
		System.out.println(" 페이징 처리 필요값 계산 하기 ");
		
		endPage
		= ((int)Math.ceil(vo.getPage()/(double)displayPageNum)*displayPageNum);
		
		pageStart
		= (endPage - displayPageNum)+1;
		
		// 모든글 개수/페이지사이즈 => 총 필요한 페이지 수
		int tmpEndPage
		  = (int)Math.ceil(totalCnt / (double)vo.getPerPageNum());
		
		if(endPage > tmpEndPage) {
			endPage = tmpEndPage;
		}
		// 이전
		prev = (pageStart == 1)? false:true;
		
		// 다음
		next = (endPage * vo.getPerPageNum() >= totalCnt)? false:true;
		
		System.out.println(" 페이징 처리 필요값 계산 하기 완료");
		
	}//calcData()

	
	
	

}