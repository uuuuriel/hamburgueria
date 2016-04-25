$(document).ready(function() {
	HM.pedidos.listarPedidoEntrega = function(){
		HM.pedidos.listarPedidoEntregue({
			success:function(data){
				var html = "";
				for (var i = 0; i < data.length; i++) {
					html += "<span id='"+data[i].codigoPedido+"'><br/><table class='table backgroundDiferenciado col-sm-12'><thead><tr><th class='col-sm-1'>"+data[i].codigoPedido+"</th>" +
							"<th class='col-sm-3'>"+data[i].nomeCliente+"</th><th class='col-sm-3'></th>" +
									"<th class='col-sm-1'>"+data[i].qtdeTotal+"</th>" +
									"<th class='col-sm-1'>"+data[i].valorTotal.toFixed(2)+"</th>" +
									"<th class='col-sm-2'><input  class='checkboxChange' type='checkbox' " +
									" onchange='HM.pedidos.pedidoFoiEntregue("+data[i].codigoPedido+");' name='my-checkbox' id='inputCheck' data-size='mini' checked/></tr></thead><tbody>";
					for (var e = 0; e < data[i].list.length; e++) {
						html += "<tr class='removeZebra'><td class='col-sm-1'></td><td class='col-sm-3'></td><td class='col-sm-3'>"+data[i].list[e].nomeProduto+"</td>"
								+ "<td class='col-sm-1'>"+data[i].list[e].qtde+"</td>"
								+ "<td class='col-sm-1'>"+data[i].list[e].valorProduto+"</td>"
								+ "<td class='col-sm-2'></td></tr>";
					}
					html += "</tbody></table></span>";
				}
				$("#anotherTables").html(html);
				$.fn.bootstrapSwitch.defaults.onText = 'Entregue';
				$.fn.bootstrapSwitch.defaults.offText = 'Finalizado';
				$.fn.bootstrapSwitch.defaults.onColor = 'danger';
				$("[name='my-checkbox']").bootstrapSwitch();
			},
			error:function(err){
				console.log(err.responseText);
			}
		})
	}
	HM.pedidos.pedidoFoiEntregue = function(cod){
		HM.pedidos.pedidoEntregue({
			data: cod,
			success:function(data){
				$("#"+cod).remove();
				bootbox.alert(data);
			}
		})
	}
	HM.pedidos.listarPedidoEntrega();
});