$(document).ready(function(){
	$("#datafim").datepicker({
		dateFormat: 'dd/mm/yy'
	});
	$("#dataini").datepicker({
		dateFormat: 'dd/mm/yy'
	});
	$("#dataini").datepicker('setDate', new Date());
	$("#datafim").datepicker('setDate', new Date());
	HM.pedidos.listarPedidos = function(){
		HM.pedidos.exibir({
			dataini: $("#dataini").val(),
			datafim: $("#datafim").val(),
			busca: $("#search").val(),
			success:function(data){
				var html = "";
				if(data){
					var total = 0;
					for (var i = 0; i < data.length; i++) {
						html += "<tr><td>" + data[i].codPedido + "</td>"
							+ "<td>" + data[i].nomeCliente + "</td>"
							+ "<td>" + data[i].nomeProduto + "</td>"
							+ "<td>" + data[i].descricaoProduto + "</td>"
							+ "<td>" + data[i].dataCompra + "</td></tr>";
						total = total + data[i].valorProduto;
					}
					$("#tbodyPedido").html(html + "<tr><td>TOTAL : </td><td>R$ " + total.toFixed(2) + "</td></tr>");
				}
			},error:function(err){
				console.log(err.responseText);
			}
		})
	}
	HM.pedidos.listarPedidos();
})