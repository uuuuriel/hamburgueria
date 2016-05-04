$(document).ready(function(){
	$("#valor").mask('000.000.000.000.000,00', {reverse: true});
	HM.novoProduto = new Object();
	HM.novoProduto.valida = function(){
		if(($("#nome").val() == "") || ($("#descricao").val() == "") 
		|| ($("#valor").val() == "")){
			bootbox.alert("Todos os campos são obrigatórios.");
			return false;
		}else{
			return true;
		}
	};
	
	HM.novoProduto.cadastrar = function(){
		if(HM.novoProduto.valida()){
			var newData = new Object();
			newData = HM.novoProduto.getValor();
			newData.anexo = $("#imagem")[0].files[0].name;
			if(newData.anexo == ""){
				bootbox.alert("Coloque uma foto para o produto.");
				return false;
			}
			HM.novoProduto.adicionar({
				data: newData,
				success : function(data) {
					$("#tipoForm").val(data);
					upload();
					bootbox.alert("Produto cadastrado.");
					loadUrl('gerenciaProduto');
				},
				error : function(error) {
					console.log(error);
				}
			});
		};
	};
	
	HM.novoProduto.edite = function(){
		if(HM.novoProduto.valida()){
			var newData = new Object();
			newData = HM.novoProduto.getValor();
			newData.anexo = $("#imagem")[0].files[0].name;
			HM.produto.editar({
				data:newData,
				success : function(data) {
					$("#tipoForm").val(data);
					if(newData.anexo != ""){upload();};
					bootbox.alert("Edição concluida.");
					loadUrl('gerenciaProduto');
				},
				error : function(error) {
					console.log(error);
				}
			});
		}
	};
	
	HM.novoProduto.getValor = function(value){
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