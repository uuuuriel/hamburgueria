$(document).ready(function() {
			HM.pedidos.listarProdutosEstagiosF = function(estagio){
				HM.pedidos.listarProdutosEstagio({
					data: estagio,
					async: false,
					success:function(data){
						estagio = estagio + 1;
						var html = "";
						var background = "";
						var a = 0;
						for (var i = 0; i < data.length; i++) {

							html += "<tr class='"+background+"' id='"+data[i].codProduto+data[i].codPedido+"'><td>" + data[i].codPedido + "</td>"
									+ "<td>" + data[i].nomeProduto + " - " + data[i].descricaoProduto + "</td>"
									+ "<td>" + data[i].qtde + "</td>"
									+ "<td><input onchange='HM.pedidos.mudaEstagio("+data[i].codProduto+","+data[i].codPedido+","+estagio+")' class='checkboxChange' type='checkbox' name='my-checkbox' id='inputCheck'"
									+ "data-size='mini' checked />";
							if(estagio == 2){
								html += "<a onclick='HM.pedidos.cancelarPedido("+ data[i].codPedido + ")'>"
								+ "<i class='glyphicon glyphicon-remove-sign' aria-hidden='true'></i></a>";
							}
							html += "</td></tr>";
						}
						$("tbody").html(html);
						$.fn.bootstrapSwitch.defaults.onText = 'Próximo';
						$.fn.bootstrapSwitch.defaults.offText = 'ok!';
						$.fn.bootstrapSwitch.defaults.onColor = 'danger';
						$("[name='my-checkbox']").bootstrapSwitch();
					},
					error:function(err){
						console.log(err.responseText);
					}
				})
			};
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
			HM.pedidos.mudaEstagio = function(codproduto, codpedido, estagio) {
				HM.pedidos.estagioPedido({
					estagio: estagio,
					codpe:codpedido,
					codpr:codproduto,
					success:function(data){
						
					},
					error:function(err){
						console.log(err.responseText);
					}						
				})
				$('#'+codproduto+codpedido+'').fadeOut(1000);
			};
		});
