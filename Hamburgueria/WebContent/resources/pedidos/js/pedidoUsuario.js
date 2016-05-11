$(document).ready(function(){
	HM.pedidosUsuario.listarPedidos = function(){
		HM.pedidosUsuario.exibir({
			success:function(data){
				var html = "";
				if(data){
					var total = 0;
					for (var i = 0; i < data.length; i++) {
						html += "<tr><td>" + data[i].codPedido + "</td>"
							+ "<td>" + data[i].nomeCliente + "</td>"
							+ "<td>" + data[i].nomeProduto + "</td>"
							+ "<td>" + data[i].descricaoProduto + "</td>"
							+ "<td>" + fromView(data[i].dataCompra) + "</td>"
							+ "<td><a onclick='HM.pedidos.cancelarPedido("+ data[i].codPedido + ")'>"
							+ "<i class='glyphicon glyphicon-remove-sign' aria-hidden='true'></i></a></td></tr>"
					}
					$("#tbodyPedido").html(html);
				}
			},error:function(err){
				console.log(err.responseText);
			}
		})
	}
	HM.pedidosUsuario.listarPedidos();
	
	HM.pedidos.cancelarPedido = function(cod){
		HM.pedidos.verificaDeletarPedido({
			data:cod,
			success:function(data){
				if(data){
					bootbox.dialog({
						message: "<input type='text' name='cancel' id='cancel' class='form-control'/>",
						title: "Motivo pelo cancelamento: <hr>",
						size: 'small',
						onEscape: function() {},
						buttons: {
							success: {
								label: "Cancelar pedido",
								className: "btn-success",
								callback: function() {
									 HM.pedidos.deletarPedido({
											data:cod,
											cancelado: $("#cancel").val(),
												success:function(data){
													HM.pedidos.listarProdutosEstagiosF(1);
													$('#alerts').fadeIn(function(){
														$("#alerts").html("O pedido foi cancelado.");
													}).delay(2000).fadeOut(2000);
												},
												error:function(err){
													console.log(err.responseText);
												}
											})
									
									}
								},
								danger: {
									label: "Fechar",
									className: "btn-danger",
									callback: function() {
										$(this).fadeOut(1000);
									}
								}
							}
						});
				}else{
					$('#alerts').fadeIn(function(){
						$("#alerts").html("Seu pedido está em produção não é mais possível cancelar! :)");
					}).delay(2000).fadeOut(2000);
				}
			},
			error:function(err){
				console.log(err.responseText);
			}
		})
		
	};
})