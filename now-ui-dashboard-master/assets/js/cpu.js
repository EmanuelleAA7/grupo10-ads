
//line
var ctxL = document.getElementById("lineChart").getContext('2d');
var myLineChart = new Chart(ctxL, {
	type: 'line',
	data: {
		labels: ["January", "February", "March", "April", "May", "June", "July","Agosto", "setembro", "out", "nov","dez"],
		datasets: [{
			label: "RAM",
			 data: [65, 59, 80, 81, 56, 55, 40,50,60,70,50,50],
			backgroundColor: [
				'rgba(105, 0, 132, .2)',
			],
			borderColor: [
				'rgba(200, 99, 132, .7)',
			],
			borderWidth: 2,
			// data:[50, 150, 100, 190, 130, 90, 150, 160, 120, 140, 190, 95]
		},
		{
			label: "CPU",
			data: [28, 48, 40, 19, 86, 27, 90,50,60,50,70,87],
			backgroundColor: [
				'rgba(0, 137, 132, .2)',
			],
			borderColor: [
				'rgba(0, 10, 130, .7)',
			],
			borderWidth: 2,
			 data:[50, 150, 100, 190, 130, 90, 150, 160, 120, 140, 190, 95]
		},
	
		]
	},
	options: {
		responsive: true
	}
});

