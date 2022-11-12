/**
 * 디데이 계산하는 곳^^
 */

// 계속 쓸 놈들.. 멤버변수로 선언해놓기
let goal_date = '';
let diffDate = '';
var gap = 0; // let하니까 안 되네.. let은 블럭 레벨 scope.. 라서,,,, 그 블럭 벗어나면 다시 이 0이 되네


// 연도 + 월 + 일 선택 다 하고 - 로 이어주기
$('#datetimepicker1').change(function() {
	let goal_year = $('#goal_year option:selected').val();
	let goal_month = $('#goal_month option:selected').val();
	let goal_day = $('#goal_day option:selected').val();

	if (goal_year == '') {
		console.log('연 없음')
		return false;
	} else if (goal_month == '') {
		console.log('월 없음')
		return false;
	} else if (goal_day == '') {
		console.log('일 없음')
		return false;
	}

	// 연, 월, 일 다 채워야 여까지 내려와서 goal_date 변수 완성
	goal_date = goal_year + '-' + goal_month + '-' + goal_day;
	console.log(goal_date);

	// 위에 만든 diffDay() 호출,,
	// 왜 하나? 브라우저가 js 파일 호출했을 때, setInterval 실행 전의 딜레이 없애기 위해
	diffDay();
	// setInterval()을 사용해서 1초 간격으로 지속적으로 함수 호출하기
	setInterval(diffDay, 1000);

});// change


// const remainTime = document.getElementById("#remain-time");

function diffDay() {
	// alert('돌아갑니다잉');
	// const goalTime = new Date("2022-11-23");
	const goalTime = new Date(goal_date);
	const todayTime = new Date();
	const diff = goalTime - todayTime;

	// 목표 기간 - 오늘이 0보다 작다? 이전 날짜 선택한거다~~
	if (diff < 0) {
		goal_date = '';
		$('#goal_month').val('').prop('selected', true);
		$('#goal_day').val('').prop('selected', true);
		alert('이전 날짜를 선택하실 수 없습니다😅 날짜를 다시 선택해주세요');
		return false;
	}

	// console.log(goalTime);
	// console.log(diff);

	// 밀리 세컨드 단위,, 1초 = 1*1000
	// math.floor()는 주어진 수의 같거나 작은 정수 중 큰 수를 반환
	// == 소수 부분 버리고 정수만 나타냄
	diffDate = Math.floor(diff / (1000 * 60 * 60 * 24));
	//                                   1초 1분 1시간 1일
	const diffHour = Math.floor((diff / (1000 * 60 * 60)) % 24);
	// const diffHour = Math.floor( (diff / (1000 * 60 * 60)) % 24 ).padStart(2, "0");
	//                                                    ㄴ 1시간
	const diffMin = Math.floor((diff / (1000 * 60)) % 60);
	// const diffMin = Math.floor( (diff / (1000 * 60)) % 60 ).padStart(2, "0");
	//                                             ㄴ 1분
	const diffSec = Math.floor(diff / 1000 % 60);
	// const diffSec = Math.floor(diff / 1000 % 60 ).padStart(2, "0");
	// padStart:
	// ~~~.padStart(2, "0")
	// ~~얘를 ㄴ두 자릿수로 만들건데,
	// ㄴ두 자릿수가 아니라면 0으로 채운다~
	// ex. 7시간 --> 07시간!!

	// innerText로 추가
	// remainTime.innerText = '${diffDay}일 ${diffHour}시간 ${diffMin}분
	// ${diffSec}초';
	// remainTime.innerText = diffDay + '일 ' + diffHour + '시간 ' + diffMin + '분 '
	// + diffSec + '초';
	$('#remain-time').html(
			diffDate + '일.. ' + diffHour + '시간.. ' + diffMin + '분.. ' + diffSec
					+ '초.. 남았습니다....⏳');

} // diffDay()



// 특정 구간만 새로고침 함수
function reloadDivArea() {
	$('#remain-time').load(location.href + ' #remain-time');
}


