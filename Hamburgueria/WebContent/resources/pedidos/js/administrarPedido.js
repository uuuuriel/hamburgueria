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
												if(data != "success"){
													bootbox.alert("Seu pedido já está em produção, não é mais possível cancelar.");
												}else{
												HM.pedidos.listarProdutosEstagiosF(1);
												}
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
