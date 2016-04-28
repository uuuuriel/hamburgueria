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
			var newData = new Object();
			newData = HM.produto.getValor();
			newData.anexo = $(".imagemCaminho").val();
			console.log(newData.anexo);
			HM.produto.adicionar({
				data: newData,
				success : function(data) {
					bootbox.alert(data);
					//carregar('resources/produto/gerenciaProduto.html');
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
		$("#formCadastro input, form select").each(function(){
			if(this.name != "ativo"){
				newProduto[this.name]=this.value;
			}else{
				newProduto[this.name]=$('input[name="ativo"]:checked').val();
			}
		});
		newProduto.valor = newProduto.valor.replace(",", ".");
		return newProduto;
	};
});