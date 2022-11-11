/**
 * goal.jsp 페이지에서 차트 부분만 쏙
 */

$(document).ready(function() {
	let goal = 3000; // 기본 목푯값은 3000으로
	getMyChart(goal);

	// 목표 금액 라디오 버튼 change될 때마다
	$('input[name="bk_iow"]').change(function() {
		goal = $(':radio[name="bk_iow"]:checked').val();
		console.log("@@@@@@@@@@클릭된 goal " + goal);
		getMyChart(goal); // 차트 생성 함수 호출
	});// change

}); // jquery ready



// 차트 생성하는 함수
function getMyChart(goal) {
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
				data : [ goal, 1000 ],
				backgroundColor : [ 'rgb(255, 99, 132)', 'rgb(54, 162, 235)' ]
			} ]
		},
		options : {
			responsive : false
		}
	}); // new Chart

} // getMyChart()



// 특정 구간만 새로고침 함수
function reloadDivArea() {
	$('#container').load(location.href + ' #container');
}
