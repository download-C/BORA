/**
 * 디데이 계산하는 곳^^
 */

const remainTime = document.querySelector("#remain-time");

function diffDay() {
	const goalTime = new Date("2022-11-23");
	const todayTime = new Date();
	const diff = goalTime - todayTime;
	
	console.log(goalTime);
	console.log(diff);
	
	// 밀리 세컨드 단위,, 1초 = 1*1000
	//  math.floor()는 주어진 수의 같거나 작은 정수 중 큰 수를 반환 
	//    == 소수 부분 버리고 정수만 나타냄
	const diffDay = Math.floor(diff / (1000 * 60 * 60 * 24));
	//                                  1초   1분  1시간  1일
	const diffHour = Math.floor( (diff / (1000 * 60 * 60)) % 24 ).padStart(2, "0"); 
	//                                      ㄴ 1시간
	const diffMin = Math.floor( (diff / (1000 * 60)) % 60 ).padStart(2, "0");
	//                                      ㄴ 1분
	const diffSec = Math.floor(diff / 1000 % 60 ).padStart(2, "0");
		// padStart: 
		//  ~~~.padStart(2, "0")
		//  ~~얘를       ㄴ두 자릿수로 만들건데,  
		//                    ㄴ두 자릿수가 아니라면 0으로 채운다~ 
		//   ex. 7시간  --> 07시간!!
	
	// innerText로 추가
	remainTime.innerText = '${diffDay}일 ${diffHour}시간 ${diffMin}분 ${diffSec}초';
	
} // diffDay()

// 위에 만든 diffDay() 호출,, 
//  왜 하나? 브라우저가 js 파일 호출했을 때, setInterval 실행 전의 딜레이 없애기 위해
diffDay();

// setInterval()을 사용해서 1초 간격으로 지속적으로 함수 호출하기
setInterval(diffDay, 1000);