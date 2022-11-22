/**
 * goal.jsp 페이지에서 차트 부분만 쏙
 */


// jquery 시작
$(document).ready(function() {
	//페이지 시작 시 자동 실행 되도록 설정
	window.onload = function() {
		var goal = 3000; // 기본 목푯값은 3000으로
		var curr = Number(total); // 현재 내 자산 총액
		console.log('curr: ' + curr);
		var gap;
		getMyChart(goal, curr);
	
		// 목표 금액 라디오 버튼 change될 때마다
		$('input[name="bk_iow"]').change(function() {
			goal = $(':radio[name="bk_iow"]:checked').val();
			const goalC = goal.toString().replace(/\B(?<!\.\d*)(?=(\d{3})+(?!\d))/g, ",");
			console.log("(ﾉ◕ヮ◕)ﾉ*:･ﾟ✧ 클릭된 goal: " + goal);
			console.log("(ﾉ◕ヮ◕)ﾉ*:･ﾟ✧ 클릭된 goalC: " + goalC);
			$('#goalSpan').html(goalC);
			
			gap = goal - (curr/10000); // 목표금액 - 현재 자산 간의 gap
			const gapC = gap.toString().replace(/\B(?<!\.\d*)(?=(\d{3})+(?!\d))/g, ",");
	//		console.log('(ﾉ◕ヮ◕)ﾉ*:･ﾟ✧ gapC: ' + gapC);
			$('#gapMoneySpan').html(gapC);
			
			getMyChart(goal, (curr/10000)); // 차트 생성 함수 호출
		
		});// change
	} // window.onload
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
			labels : [ '내 목표', '내 자산' ],
			datasets : [ {
				data : [ goal, curr ],
				backgroundColor : [ '#5107b0', '#e3cffc' ]
			}, ]
		},
		options : {
			plugins:{
                legend: {
                    display: false
                },
            },
			maintainAspectRatio : false,
			responsive : false,
			scales: {
				yAxes: [{
	                display: true,
	                ticks: {
	                	min: 0, // 최소값 0
	                },
	                scaleLabel: {
	                	display: true,
	                	labelString: '만원'
	                }
	            }]
			}, // scales
		}// options
	}); // new Chart
} // getMyChart()
// 특정 구간만 새로고침 함수
function reloadDivArea() {
	$('#container').load(location.href + ' #container');
}
