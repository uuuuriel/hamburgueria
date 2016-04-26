$(document).ready(function() {
	$("#datafim").datepicker({
		dateFormat: 'dd/mm/yy'
	});
	$("#dataini").datepicker({
		dateFormat: 'dd/mm/yy'
	});
	$("#dataini").datepicker('setDate', new Date());
	$("#datafim").datepicker('setDate', new Date());
	HM.pedidos.relatorioDeVenda = function(){
		HM.pedidos.relatorioVendas({
			dataini: $("#dataini").val(),
			datafim: $("#datafim").val(),
			busca: $("#busca").val(),
			success:function(data){
				var html = "";
				console.log(data);
				for (var i = 0; i < data.length; i++) {
					html += "<tr><td>"+data[i].codPedido+"</td>" +
							"<td>"+data[i].nomeCliente+"</td>" +
							"<td>"+data[i].nomefuncionario+"</td>" +
							"<td>"+(data[i].entrega == 0 ? "Delivery" : "Retirada no Balcão")+"</td>" +
							"<td>"+fromView(data[i].dataCompra)+"</td>" +
							"<td>"+data[i].qtde+"</td>" +
							"<td>R$ "+data[i].valorTotal.toFixed(2)+"</td></tr>";
				}
				$("tbody").html(html);
			},
			error:function(err){
				console.log(err.responseText);
			}
		})
	}
	HM.pedidos.relatorioDeVenda();
});