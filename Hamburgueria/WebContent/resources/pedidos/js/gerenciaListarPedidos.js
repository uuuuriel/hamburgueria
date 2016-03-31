$(document).ready(function(){
	HM.pedidos.listarPedidos = function(){
		HM.pedidos.exibir({
			dataini: $("#dataini").val(),
			datafim: $("#datafim").val(),
			busca: $("#search").val(),
			success:function(data){
				var html = "";
				if(data){
					for (var i = 0; i < data.length; i++) {
						html += "<tr><td>" + data[i].codPedido + "</td>"
							+ "<td>" + data[i].nomeUsuario + "</td>"
							+ "<td>" + data[i].nomeProduto + "</td>"
							+ "<td>" + data[i].descricaoProduto + "</td>"
							+ "<td>" + data[i].valorProduto + "</td>"
							+ "<td>" + data[i].dataCompra + "</td></tr>";
					}
					$("tbody").html(html);
				}
			},error:function(err){
				console.log(err.responseText);
			}
		})
	}
	HM.pedidos.listarPedidos();
})