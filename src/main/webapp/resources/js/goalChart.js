/**
 * goal.jsp 페이지에서 차트 부분만 쏙
 */

// localStorage에 저장되어 있는 계좌잔액 배열 balArr 끄집어내서 
// --> 중복 키,값들 걸러내고 --> for문 돌려서 계좌 잔액 총계 구하기
// 선언 안해줘도 쌉가능하네,,
balArr = JSON.parse(localStorage.getItem('balArr') || '[]'); // [] 이건 왜 하는거? ㄱ- 
console.log(balArr);

// 중복 제거 작업 위해,, 
// 맵 생성해서 중복값들 빼고 balArrUnique 에 담기 
let balMap = new Map();
for(let name of balArr){
	balMap.set(JSON.stringify(name), name); // name, bal이 모두 같은 객체 요소를 제외한 맵 생성
}
let balArrUnique = [...balMap.values()];
console.log(balArrUnique);

let balSum = 0;
for (let i = 0; i < balArrUnique.length; i++){
	balSum += balArrUnique[i].bal / 10000;
}
console.log('(ﾉ◕ヮ◕)ﾉ*:･ﾟ✧ balSum: ' + balSum);

// jquery 시작
$(document).ready(function() {
	let goal = 3000; // 기본 목푯값은 3000으로
	let curr = balSum; // 현재 내 자산 총액
//	let gap;
	getMyChart(goal, curr);

	// 목표 금액 라디오 버튼 change될 때마다
	$('input[name="bk_iow"]').change(function() {
		goal = $(':radio[name="bk_iow"]:checked').val();
		console.log("(ﾉ◕ヮ◕)ﾉ*:･ﾟ✧ 클릭된 goal: " + goal);
		
		gap = goal - curr; // 목표금액 - 현재 자산 간의 gap
		$('#gapMoneySpan').html(gap);
		console.log('(ﾉ◕ヮ◕)ﾉ*:･ﾟ✧ gap: ' + gap);
		
		getMyChart(goal, curr); // 차트 생성 함수 호출
	
	});// change
}); // jquery ready

// 차트 생성하는 함수
function getMyChart(goal, curr) {
//	alert('차트 생성 함수 getMyChart 호출됨  goal: ' + goal);

	// 만약 기존에 차트가 있다면,, 파괴하고
	let myChartStatus = Chart.getChart("myChart");
	console.log(myChartStatus);
	if (myChartStatus != undefined) {
		myChartStatus.destroy();
	}

	// 새로운 차트 생성
	let ctx = document.getElementById('myChart').getContext('2d');
	let myChart = new Chart(ctx, {
		type : 'bar',
		data : {
			labels : [ '내 목표 값', '내 자산' ],
			datasets : [ {
				label : '자산관리',
				data : [ goal, curr ],
				backgroundColor : [ 'rgb(255, 99, 132)', 'rgb(54, 162, 235)' ]
			} ]
		},
		options : {
			maintainAspectRatio : false,
			responsive : false
		}
	}); // new Chart
} // getMyChart()
// 특정 구간만 새로고침 함수
function reloadDivArea() {
	$('#container').load(location.href + ' #container');
}
