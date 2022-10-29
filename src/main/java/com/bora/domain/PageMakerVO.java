package com.bora.domain;

import com.bora.domain.PageVO;

public class PageMakerVO {
	// 개수 출력(PageVO) + 하단 페이징 블럭까지~~
	// 페이징 처리에 관한 모~~든 동작 관리
	
	
	// 멤버변수 =================================================================
	private PageVO vo;       // 현 페이지 번호, 한 페이지에 몇 개씩 나타낼지 크기

	private int totalCnt;    // 총 글 개수
	private int startPage;   // 페이지 블럭 시작 페이지
	private int endPage;     // 페이지 블럭 끝 페이지
	private boolean prev;    // 이전
	private boolean next;    // 다음
	
	private int displayPageNum = 10; // 페이지 블럭의 크기... 10개씩 보여주겠다~~

	
	
	// getter setter =================================================================
	public void setVo(PageVO vo) {
		// 이미 생성된 pageVO 객체 사용할 수 있음
		this.vo = vo;
	}

	public void setTotalCnt(int totalCnt) {
		// DB에서 계산된 값으로 초기화
		this.totalCnt = totalCnt;
		
		// 데이터 계산하는 메서드 호출
		calcData();
	}
	
			public void calcData() {
				System.out.println("(PageMakerVO_clacData) 페이징 처리에 필요한 값 계산해볼게용가리");
				
				// endPage  --------------------------------------------------------------------------
				endPage = (int) (Math.ceil(vo.getPage()/(double)displayPageNum) * displayPageNum);
					//              올림~~    현 페이지 / 출력할페이지블럭크기  *  출력할페이지블럭크기
					//  왜 에러나남?
					//    ㄴ정수 나누기 정수는? 정수니까.. 둘 중 하나를 double로 만들어서,, 실수로 만들어서,, 
					//        그걸 올림해서,,, 최종적으로 int로 다시 바꿈
				
				// startPage  --------------------------------------------------------------------------
				startPage = (endPage - displayPageNum) + 1;
						//   (페이징블럭끝페이지 - 출력할페이지블럭크기) + 1;
				// ex)  내가 21페이지 보고 있다? 
				//            (30    -     10)  +1 = 21
				//  ==>    21  22  23  24  ..  29  30 
				
				// endPage  --------------------------------------------------------------------------
				int tmpEndPage = (int) Math.ceil(totalCnt / (double)vo.getPerPageNum());
							// 총 글 개수 / 한 페이지에 글 몇 개씩 출력할지
				// DB에 들어있는 찐 글 개수랑 vs 글 몇 개씩 출력할지 비교해서
				//   ==> 총 필요한 페이지 수 계산
				
				// 기존에는 삼항연산자로,, 나누어 떨어지면 1 안 더하고, 나누어 떨어지지 않으면=나머지 있으면 1 더하는 로직 사용했고
				// 여기선 올림으로 처리,, 하 ^^ 뭐징??
				
				// ㄴ이렇게 구한 tmpEndPage가 만약에 6이다~~
				if(endPage > tmpEndPage) {
					endPage = tmpEndPage;    // 10 > 6 ? -->  6번이 endPage 되도록 설정
				}
				
				// 이전  --------------------------------------------------------------------------
				prev = (startPage == 1)? false : true;
				
				// 다음  --------------------------------------------------------------------------
				next = (endPage * vo.getPerPageNum() >= totalCnt)? false : true;
					//  페이징블럭끝 * 한 페이지에 글 몇 개씩 출력할지)  비교!!!! 전체 글 개수랑,,,
					// ?????
				// 
				System.out.println("(PageMakerVO_clacData) 페이징 처리에 필요한 값 계산 완,,");
				
			}// clacData()
	
	
	public PageVO getVo() {
		return vo;
	}


	public int getTotalCnt() {
		return totalCnt;
	}


	public int getStartPage() {
		return startPage;
	}

	public void setStartPage(int startPage) {
		this.startPage = startPage;
	}

	public int getEndPage() {
		return endPage;
	}

	public void setEndPage(int endPage) {
		this.endPage = endPage;
	}

	public boolean isPrev() {
		return prev;
	}

	public void setPrev(boolean prev) {
		this.prev = prev;
	}

	public boolean isNext() {
		return next;
	}

	public void setNext(boolean next) {
		this.next = next;
	}

	public int getDisplayPageNum() {
		return displayPageNum;
	}

	public void setDisplayPageNum(int displayPageNum) {
		this.displayPageNum = displayPageNum;
	}

	
	// toString ===============================================================
	@Override
	public String toString() {
		return "PageMakerVO [vo=" + vo + ", totalCnt=" + totalCnt + ", startPage=" + startPage + ", endPage=" + endPage
				+ ", prev=" + prev + ", next=" + next + ", displayPageNum=" + displayPageNum + "]";
	}
}
