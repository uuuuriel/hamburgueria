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
			newData.anexo = $("#imagem")[0].files[0].name ? $("#imagem")[0].files[0].name : "";
			if(newData.anexo == ""){
				bootbox.alert("Coloque uma foto para o produto.");
				return false;
			}
			HM.produto.adicionar({
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
	
	HM.produto.edite = function(){
		if(HM.produto.valida()){
			var newData = new Object();
			newData = HM.produto.getValor();
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