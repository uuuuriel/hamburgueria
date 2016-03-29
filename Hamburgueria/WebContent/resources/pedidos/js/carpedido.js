$(document).ready(function(){
	var conta = HM.sessao("produto");
	if(conta && conta != null && conta != undefined && conta != ""){
		$("#carrinhoCompraTag").text(conta.split(",").length-1);
		$("#carrinhoCompra").show();
	}
	
	HM.produto.listar();
});