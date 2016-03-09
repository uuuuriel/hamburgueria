$(document).ready(function(){
	$("#cpf").mask("999.999.999-99");
	$("#rg").mask("9.999.999");
	$("#telefone").mask("(99)9999-9999");
	$("#cep").mask("99999-999");
	$("#data_nascimento").mask("99/99/9999");
	$("#numero").mask("99999");
	HM.usuario.cadastrar = function(){
		if(($("#nome").val() == "") || ($("#cpf").val() == "") || ($("#rg").val() == "")
				|| ($("#data_nascimento").val() == "") ||($("#telefone").val() == "")
				|| ($("#email").val() == "") || ($("#senha").val() == "") || ($("#confirmaSenha").val() == "") || ($("#cep").val() == "") 
				|| ($("#cidade").val() == "") || ($("#bairro").val() == "") || ($("#rua").val() == "")
				|| ($("#numero").val() == "")){
			bootbox.alert("Campos obrigatórios.");
			return false;
		}else if($("#senha").val() != $("#confirmaSenha").val()){
			bootbox.alert("Senhas não conferem.");
			return false;
		}else{
			HM.usuario.adicionar({
				data:HM.usuario.getValor(),
				success : function(data) {
					bootbox.alert(data);
					carregar('resources/usuario/gerenciaUsuario.html');
				},
				error : function(error) {
					bootbox.alert(error.responseText);
				}
			});
		}
	};
	HM.usuario.edit = function(){
		HM.usuario.editar({
			data:HM.usuario.getValor(),
			success : function(data) {
				bootbox.alert(data);
				carregar('resources/usuario/gerenciaUsuario.html');
			},
			error : function(error) {
				bootbox.alert(error.responseText);
			}
		});
	};
	HM.usuario.getValor = function(value){
		$("#cpf").unmask();
		$("#rg").unmask();
		$("#telefone").unmask();
		$("#cep").unmask();
		$("#data_nascimento").unmask();
		var newUsuario = new Object();
		$("form div input, form div select").each(function(){
			newUsuario[this.name]=this.value;
			});
		return newUsuario;
	};
		$("#cidade").on('focus',function(){
				HM.cidade.listar({
				async : false,
				success : function(data) {
					var html = "";
					for ( var i = 0; i < data.length; i++) {
						html += "<option value='"
								+ data[i].cod
								+ "'>"
								+ data[i].cidade
								+ "</option>";
					}
					$("#cidade").append(html);
				},
				error:function(err){
					bootbox.alert(err.responseText);
				}
			});
		});
		$("#cidade").on('change', function(){
			HM.bairro.listar({
				data: $('#cidade').val(),
				success:function(data){
					var html = "";
					for ( var i = 0; i < data.length; i++) {
						html += "<option value='"
								+ data[i].codBairro
								+ "'>"
								+ data[i].bairro
								+ "</option>";
					}
					$("#bairro").html(html);
				},
				error:function(err){
					bootbox.alert(err.responseText);
				}
			});
		});
});