$(document).ready(function() {
	HM.pedidos.listarPedidoEntrega = function(){
		HM.pedidos.listarPedidoEntregue({
			success:function(suc){
				console.log(suc);
			},
			error:function(err){
				console.log(err.responseText);
			}
		})
	}
	HM.pedidos.listarPedidoEntrega();
});