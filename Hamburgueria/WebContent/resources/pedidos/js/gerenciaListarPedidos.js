$(document).ready(function(){
	HM.pedidos.listarPedidos = function(){
		HM.pedidos.exibir({
			dataini: $("#dataini").val(),
			datafim: $("#datafim").val(),
			busca: $("#search").val(),
			success:function(succ){
				if(succ){
					alert(succ);
				}
				console.log(succ);
			},error:function(err){
				console.log(err.responseText);
			}
		})
	}
})