$(document).ready(function() {
			HM.pedidos.listarProdutosEstagiosF = function(estagio){
				HM.pedidos.listarProdutosEstagio({
					data: estagio,
					async: false,
					success:function(data){
						estagio = estagio + 1;
						var html = "";
						for (var i = 0; i < data.length; i++) {
							html += "<tr id='"+data[i].codProduto+data[i].codPedido+"'><td>" + data[i].codPedido + "</td>"
									+ "<td>" + data[i].nomeProduto + " - " + data[i].descricaoProduto + "</td>"
									+ "<td>" + data[i].qtde + "</td>"
									+ "<td><input onchange='HM.pedidos.mudaEstagio("+data[i].codProduto+","+data[i].codPedido+","+estagio+")' class='checkboxChange' type='checkbox' name='my-checkbox' id='inputCheck'"
									+ "data-size='mini' checked />";
							if(estagio == 2){
								html += "<a href='#' onclick='HM.pedidos.cancelarPedido("+ data[i].codPedido + ")'>"
								+ "<i class='glyphicon glyphicon-remove-sign' aria-hidden='true'></i></a>";
							}
							html += "</td></tr>";
						}
						$("tbody").append(html);
						$.fn.bootstrapSwitch.defaults.onText = 'Go ->';
						$.fn.bootstrapSwitch.defaults.offText = 'Next step.';
						$.fn.bootstrapSwitch.defaults.onColor = 'danger';
						$("[name='my-checkbox']").bootstrapSwitch();
					},
					error:function(err){
						console.log(err.responseText);
					}
				})
			};
			 HM.pedidos.cancelarPedido = function(cod){
				bootbox.confirm({
					size : 'small',
					message : "Deseja cancelar o pedido?",
					callback : function(result) {
						if(result){
							HM.pedidos.deletarPedido({
								data:cod,
								error:function(err){
									console.log(err.responseText);
								}
							})
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
						console.log(data);
					},
					error:function(err){
						console.log(err.responseText);
					}						
				})
				$('#'+codproduto+codpedido+'').fadeOut(1000);
			};

		});
