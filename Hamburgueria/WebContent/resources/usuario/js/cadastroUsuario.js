$(document).ready(function(){
	function clean(crs) {
		var clean = crs.replace(/[^\d]+/g, '');
		return clean;
	}
	$("#cpf").mask("999.999.999-99");
	$("#rg").mask("9.999.999");
	$("#telefone").mask("(99)9999-9999");
	$("#cep").mask("99999-999");
	$("#data_nascimento").mask("99/99/9999");
	$("#numero").mask("99999");
	$("#data_nascimento").datepicker({
		dateFormat: "dd/mm/yy"
	});
	
	$("#telefone").blur(function(){
		$("#telefone").unmask();
		var fone = $("#telefone").val();
		$("#telefone").mask("(99)9999-9999");
		console.log(fone);
		HM.usuario.validaFone({
			data:fone,
			success:function(data){
				console.log(data);
				if(!data){
					$("#telefone").val("");
					$("#telefone").css({'border':'red'});
				}else{
					alert("oi");
				}
			},
			error:function(err){
				console.log(err.responseText);
			}
		})
	})
	
	HM.usuario.valida = function(acao){
		//var filtroTelefone = new RegExp('^[1-9]{2}\-[2-9][0-9]{7,8}$');
		//var filtroNome = /^[a-z]{1,45}$/i;
		var filtroEmail = /^([a-z0-9_\.-]+)@([\da-z\.-]+)\.([a-z\.]{2,6})$/;
		var email = $("#email").val();
		if(($("#nome").val() == "") || ($("#cpf").val() == "") || ($("#rg").val() == "")
				|| ($("#data_nascimento").val() == "") ||($("#telefone").val() == "")
				|| ($("#cep").val() == "") 
				|| ($("#cidade").val() == "") || ($("#bairro").val() == "") || ($("#rua").val() == "")
				|| ($("#numero").val() == "")){
			bootbox.alert("Campos obrigatórios.");
			return false;
		}else if(email == ""){
			bootbox.alert("* O campo Email é Obrigatório <br/>");
			return false;
		} else if (!filtroEmail.test(email)) {
			bootbox.alert("* Email inválido <br/>");
			return false;
		}else if(acao == 'new'){
			if(($("#senha").val() == "") || ($("#confirmaSenha").val() == "")){
				bootbox.alert("Preencha o campo senha");
				return false;
			}else if($("#senha").val() != $("#confirmaSenha").val()){
				bootbox.alert("Senhas não conferem");
				return false;
			}else{
				return true;
			}
		}else if(acao == 'edit'){
			if($("#senha").val() != ""){
				if($("#senha").val() != $("#confirmaSenha").val()){
					bootbox.alert("Senhas não conferem");
					return false;
				}
			}
			return true;
		}
	};
	
	HM.usuario.cadastrar = function(){
		if(HM.usuario.valida('new')){
			HM.usuario.adicionar({
				data:HM.usuario.getValor(),
				success : function(data) {
					bootbox.alert(data);
					if(HM.sessao("administrador") == 1){
						loadUrl('usuarios');
					}else{
						loadUrl('index');
					}
				},
				error : function(error) {
					bootbox.alert(error.responseText);
				}
			});
		}
	};
	
	HM.usuario.edit = function(){
		if(HM.usuario.valida('edit')){
			HM.usuario.editar({
				data:HM.usuario.getValor(),
				success : function(data) {
					bootbox.alert(data);
					if(HM.sessao('funcionario') != 1){
						loadUrl('index');
					}else{
						loadUrl('usuarios');
					}
				},
				error : function(error) {
					bootbox.alert(error.responseText);
				}
			});
		}
	};
	
	HM.usuario.getValor = function(value){
		clean($("#cpf").val());
		$("#rg").unmask();
		$("#telefone").unmask();
		$("#cep").unmask();
		var newUsuario = new Object();
		$("form div input, form div select").each(function(){
			if(this.name != "ativo"){
				newUsuario[this.name]=this.value;
			}else{
				newUsuario['ativo']=$('input[name="ativo"]:checked').val();
			}
		});
		newUsuario['data_nascimento'] = fromBD($("#data_nascimento").val());
		console.log(newUsuario);
		return newUsuario;
	};
	
		$("#cidade").on('focus',function(){
				HM.cidade.listar({
				async : false,
				success : function(data) {
						var html = "";
						for ( var i = 0; i < data.length; i++) {
							html += "<option value='"+ data[i].cod+ "'>"+ data[i].cidade+ "</option>";
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
						html += "<option value='"+ data[i].codBairro+ "'>"+ data[i].bairro+ "</option>";
					}
					$("#bairro").html(html);
				},
				error:function(err){
					bootbox.alert(err.responseText);
				}
			});
		});
		
});