package com.bora.domain.board;

public class PageVO {
	// 페이징 처리에 필요한 정보를 관리하는 객체
	
		// 멤변 =======================================================
		private int page;       // 페이지
		private int perPageNum; // 한번에 보여줄 페이지 수
		
		
		
		// 생성자 ==================================================
		public PageVO() {
			// 페이징 처리의 정보가 하나도!! 없을 때
			// 기본값 부여하기 위해서 == 초기화!!!!하기 위해서
			this.page = 1;
			this.perPageNum = 10;
		}
		
		// getter setter ==================================================
		public int getPage() {
			return page;
		}
		
		public void setPage(int page) {
			// 0보다 작은!! 페이지 정보를 호출할 때 로직 (미리 예외 상황 대처해놓기 위해)
//			if (page <= 0) { // -1 페이지 보여조 ㅋ
//				this.page = 1; // 그런거 없으니까;; 1페이지 보여주기
//			} else {
//				this.page = page;
//			} 근데 조건문 이렇게 두 번 쓸 필요 없음~~~~~ 조건문 많이 쓰지 말자,,,,,,,
			
			if (page <= 0) { // -1 페이지 보여조 ㅋ
				this.page = 1; // 그런거 없으니까;; 1페이지 보여주기
				return; // 리턴해서 이 경우는 여기서 끝내버리기
			}
				this.page = page;
		}
		
		public int getPerPageNum() {
			return perPageNum;
		}
		
		public void setPerPageNum(int perPageNum) {
			if (perPageNum < 10 || perPageNum > 100) {
				// 한 번에 보여줄 페이지 수가~~ 10보다 작거나 100보다 클 때
				this.perPageNum = 10;
				return;
			}
			
			this.perPageNum = perPageNum;
		}
		
		public int getPageStart() {
			// boardMapper.xml에 -> id="listPage3" 에 
			// -> limit #{ pageStart } << 얘를 위한 메서드임
			
			return (this.page -1 ) * perPageNum;
			// page = (page-1) * pageSize랑 같은 의미다..
		}
		// 얘 주석 처리하니까 에러나네??? mapper.xml에서 #{..} 읽어오는 게 결국은 getter 메서드 읽어오는 거라서
		// 내가 필요한 변수 #{..}로 지정해놓고 --> 그에 맞게 여기서 get메서드 만들어주면 삽가능
		
		
		
		// toString ==========================================================
		@Override
		public String toString() {
			return "PageVO [page=" + page + ", perPageNum=" + perPageNum + "]";
		}
		
} // class PageVO
