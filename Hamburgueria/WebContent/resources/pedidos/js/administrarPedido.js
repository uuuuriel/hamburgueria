$(document).ready(function() {
			HM.pedidos.listarProdutosEstagiosF = function(){
				HM.pedidos.listarProdutosEstagio({
					data: 1,
					async: false,
					success:function(data){
						var html = "";
						for (var i = 0; i < data.length; i++) {
							html += "<tr><td>" + data[i].codPedido + "</td>"
									+ "<td>" + data[i].nomeProduto + " - " + data[i].descricaoProduto + "</td>"
									+ "<td>" + data[i].qtde + "</td>"
									+ "<td><input onchange='HM.pedidos.mudaEstagio("+data[i].codProduto+")' class='checkboxChange' type='checkbox' name='my-checkbox' id='inputCheck'"
									+ "data-size='mini' checked /> <a href='#' onclick='HM.pedidos.cancelarPedido("+ data[i].codPedido + ")'>"
									+ "<i class='glyphicon glyphicon-remove-sign' aria-hidden='true'></i></a></tr>";
						}
						$("tbody").append(html);
						$.fn.bootstrapSwitch.defaults.onText = 'Pago';
						$.fn.bootstrapSwitch.defaults.offText = 'Produção';
						$.fn.bootstrapSwitch.defaults.onColor = 'danger';
						$("[name='my-checkbox']").bootstrapSwitch();
					},
					error:function(err){
						console.log(err.responseText);
					}
				})
			}
			HM.pedidos.listarProdutosEstagiosF();
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
			HM.pedidos.mudaEstagio = function(cod) {
				alert("ae?");
				HM.pedidos.estagioPedido({
					estagio: '2',
					cod: cod,
					success:function(data){
						console.log(data);
					},
					error:function(err){
						console.log(err.responseText);
					}						
				})
				$(this).closest('tr').fadeOut(1000);
			};

		});
