$(document).ready(function() {
			$.fn.bootstrapSwitch.defaults.onText = 'Pago';
			$.fn.bootstrapSwitch.defaults.offText = 'Produção';
			$.fn.bootstrapSwitch.defaults.onColor = 'danger';
			$("[name='my-checkbox']").bootstrapSwitch();
			$(".cancelConfirm").on("click", function() {
				bootbox.confirm({
					size : 'small',
					message : "Deseja cancelar o pedido?",
					callback : function(result) {
						console.log(result);
					}
				});
			});

			$('input[name="my-checkbox"]').on('switchChange.bootstrapSwitch', function(event, state) {
				var cod = $(this).parents().parent('tr').find("td:first-child").text();
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
			});
		});
