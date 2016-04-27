$(document).ready(function(){
	HM.venda.exibeGrafico = function(){
		$("#graficoVenda").show();
		$("#relatorioVenda").hide();
		HM.venda.openGrafico({
			dataini:$("#dataini").val(),
			datafim:$("#datafim").val(),
			success:function(data){
				var valor = [];
				var label = [];
				for (var i = 0; i < data.length; i++) {
					valor[i] = data[i].valor.toFixed(2);
					label[i] = fromView(data[i].data);
				}
				var ctx = document.getElementById("myChart");
				var data = {
					    labels: label,
					    datasets: [
					        {
					            label: "Total",
					            fill: false,
					            lineTension: 0.1,
					            backgroundColor: "rgba(75,192,192,0.4)",
					            borderColor: "rgba(75,192,192,1)",
					            borderCapStyle: 'butt',
					            borderDash: [],
					            borderDashOffset: 0.0,
					            borderJoinStyle: 'miter',
					            pointBorderColor: "rgba(75,192,192,1)",
					            pointBackgroundColor: "#000",
					            pointBorderWidth: 1,
					            pointHoverRadius: 5,
					            pointHoverBackgroundColor: "rgba(75,192,192,1)",
					            pointHoverBorderColor: "rgba(220,220,220,1)",
					            pointHoverBorderWidth: 2,
					            pointRadius: 1,
					            pointHitRadius: 10,
					            data: valor,
					            yAxisID: "y-axis-0",
					        }
					    ]
					};
				var myLineChart  = new Chart.Line(ctx, {
				    type: 'bar',
				    data: data,
				    responsive: false,
				    maintainAspectRatio: true
				});
				
			},
			error:function(err){
				console.log(err);
			}
		});
	};
	HM.venda.back = function(){
		$("#graficoVenda").hide();
		$("#relatorioVenda").show();
	}
});