$(document).ready(function() {
	HM.pedidos.listarPedidoEntrega = function(){
		HM.pedidos.listarPedidoEntregue({
			success:function(data){
				console.log(data);
				var first = true;
				var html = "";
				var verfica;
				var background;
				for (var int = 0; int < data.length; int++) {
					if(first){
						verifica = data[int].codigoPedido;
					}
					for (var int2 = 0; int2 < data[int].list.length; int2++) {
						console.log(data[int].list[int2]);
					}
					
					verifica = data[int].codigoPedido;
					first = false;
				}
			},
			error:function(err){
				console.log(err.responseText);
			}
		})
	}
	HM.pedidos.listarPedidoEntrega();
});