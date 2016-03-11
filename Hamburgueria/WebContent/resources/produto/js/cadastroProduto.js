$(document).ready(function(){
	$("#valor").mask('000.000.000.000.000,00', {reverse: true});
	
	HM.produto.valida = function(){
		if(($("#nome").val() == "") || ($("#descricao").val() == "") 
		|| ($("#valor").val() == "")){
			bootbox.alert("Todos os campos são obrigatórios.");
			return false;
		}else{
			return true;
		}
	};
	
	HM.produto.cadastrar = function(){
		if(HM.produto.valida()){
			HM.produto.adicionar({
				data: HM.produto.getValor(),
				success : function(data) {
					console.log(data);
					bootbox.alert(data);
					carregar('resources/produto/gerenciaProduto.html');
				},
				error : function(error) {
					console.log(error);
				}
			});
		};
	};
	
	HM.produto.edite = function(){
		if(HM.produto.valida()){
			HM.produto.editar({
				data:HM.produto.getValor(),
				success : function(data) {
					bootbox.alert(data);
					carregar('resources/produto/gerenciaProduto.html');
				},
				error : function(error) {
					console.log(error);
				}
			});
		}
	};
	
	HM.produto.getValor = function(value){
		var newProduto = new Object();
		$("form input, form select").each(function(){
			newProduto[this.name]=this.value;
			});
		newProduto.valor = newProduto.valor.replace(",", ".");
		console.log(newProduto.valor);
		return newProduto;
	};
});