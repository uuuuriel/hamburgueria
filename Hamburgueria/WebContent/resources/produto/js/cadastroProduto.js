$(document).ready(function(){
	HM.produto.cadastrar = function(){
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
	HM.produto.edit = function(){
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
	};
	HM.produto.getValor = function(value){
		var newProduto = new Object();
		$("form div input, form div select").each(function(){
			newProduto[this.name]=this.value;
			});
		return newProduto;
	};
});