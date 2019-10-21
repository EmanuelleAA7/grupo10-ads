
//line
var ctxL = document.getElementById("lineChart").getContext('2d');
var myLineChart = new Chart(ctxL, {
	type: 'line',
	data: {
		labels: ["Janeiro", "Fevereiro", "Março", "Abril", "Maio", "Junho", "Julho","Agosto", "Setembro", "Outubro", "Novembro","Dezembro"],
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
			data:[55, 50, 80, 90, 40, 75, 51, 60, 44, 55, 80, 95]
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
			 data:[58, 50, 70, 90, 35, 92, 56, 60, 74, 60, 80, 95]
		},
		{
			label: "Disco",
			data: [48, 48, 40, 19, 56, 37, 50,50,70,50,78,57],
			backgroundColor: [
				'rgba(0, 192, 96, 1)',
			],
			borderColor: [
				'rgba(0, 124, 48, 1)',
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

