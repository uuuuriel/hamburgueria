$(document).ready(function() {
	$("#nmbrcpf").mask("999.999.999-99");
	$("#nmbrrg").mask("9.999.999");
	$("#nmbrfone").mask("(99)9999-9999");
	$("#cep").mask("99999-999");
	$("#nmbrdatanascimento").datepicker();
	HM.cidade
	.listar({
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
			$("#txtcidade").append(
					html);
		},
		error:function(err){
			console.log(err);
		}
	});
	HM.novofuncionario = new Object();
	HM.novofuncionario.funcValida = function(tp){
		var newData = new Object();
		var codfuncionario = $("#codfuncionario").val();
		var nome = $('#txtnome').val();
		var cpf = clean($('#nmbrcpf').val());
		var rg = clean($("#nmbrrg").val());
		var dataNascimento = $("#nmbrdatanascimento").val();
		var fone = clean($("#nmbrfone").val());
		var pass = $("#pass").val();
		var confirmPass = $("#confirmPass").val();
		var funcao = $("#txtfuncao").val();
		var cidade = $("#txtcidade").val();
		var bairro = $("#txtbairro").val();
		var rua = $("#txtrua").val();
		var nmrcasa = $("#nmbrcasa").val();
		var cep = clean($("#cep").val());
		var complemento = $("#txtcomplemento").val();
		var administrador;
		var ativo = $('input[name="ativo"]:checked').val();
		if ($("#administrador").is(":checked")) {
			administrador = 1;
		} else {
			administrador = 0;
		}
		var filtroEmail = /^([a-z0-9_\.-]+)@([\da-z\.-]+)\.([a-z\.]{2,6})$/;
		email = $("#txtemail").val();
		if(email == ""){
			bootbox.alert("* O campo Email é Obrigatório <br/>");
			return false;
		} else if (!filtroEmail.test(email)) {
			bootbox.alert("* Email inválido <br/>");
			return false;
		}
		if (tp == "att") {
			if (pass != "") {
				if (pass != confirmPass) {
					bootbox.alert("Senhas não conferem.");
					return false;
				}
				bootbox.alert("Campo senha obrigatório.");
				return false;
			}
		}
		if (tp == "new") {
			if(pass == "" || confirmPass == ""){
				bootbox.alert("Todos os campos são obrigatórios.");
				return false;
			}else if(pass != confirmPass){
				bootbox.alert("Senhas não conferem");
				return false;
			}
		}
		if ((nome == "") || (nome == null) || (rg == "") || (rg == null) || (cpf == "") || (cpf == null) || (dataNascimento == "")
				|| (dataNascimento == null) || (fone == "")	|| (fone == null) || (email == "")	|| (email == null) || (funcao == "")
				|| (funcao == null) || (cidade == "")|| (cidade == null) || (bairro == "")|| (bairro == null) || (rua == "")
				|| (rua == null) || (nmrcasa == "")	|| (nmrcasa == null) || (complemento == "")	|| (complemento == null)) {
			bootbox.alert("Todos os campos são obrigatórios.");
			return false;
		} else {
			newData.nomeFuncionario = nome;
			newData.cpf = cpf;
			newData.rg = rg;
			newData.dataNascimento = dataNascimento;
			newData.fone = fone;
			newData.email = email;
			newData.senha = pass;
			newData.funcao = funcao;
			newData.cidade = cidade;
			newData.bairro = bairro;
			newData.rua = rua;
			newData.numero = nmrcasa;
			newData.complemento = complemento;
			newData.administrador = administrador;
			newData.cep = cep;
			newData.codfuncionario = codfuncionario;
			newData.ativo = $("#ativo").val();
			return newData;
		}

	};

	function clean(crs) {
		var clean = crs.replace(/[^\d]+/g, '');
		return clean;
	}
	HM.novofuncionario.exibirEdicao = function() {
		var newData = HM.novofuncionario.funcValida("att");
		HM.novofuncionario
		.editar({
			data:newData,
			success : function(succ) {
				bootbox.alert(succ);
				loadUrl("funcionario");
			},
			error : function(err) {
				console.log(err);
				bootbox.alert("Erro ao editar funcionário:"	+ err);
			}
		});
	}
	HM.novofuncionario.cadastrar = function() {
		var newData = HM.novofuncionario.funcValida("new");
		HM.novofuncionario.adicionar({
			data: newData,
			success : function(data) {
				bootbox.alert(data);
				loadUrl("funcionario");
			},
			error : function(error) {
				console.log(error);
			}
		});
	};

	$("#txtcidade").on('change', function(){
		HM.bairro.listar({
			data: $('#txtcidade').val(),
			success:function(data){
				var html = "";
				for ( var i = 0; i < data.length; i++) {
					html += "<option value='"
						+ data[i].codBairro
						+ "'>"
						+ data[i].bairro
						+ "</option>";
				}
				$("#txtbairro").html(html);
			},
			error:function(err){
				console.log(err);
			}
		})
	})
});