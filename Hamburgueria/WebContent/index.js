$(document).ready(function(){
	window.onpopstate = function(event) {
		$('#conteudo').load(event.state.url);
	 }
	var mapHref = {"/delivery":"resources/pedidos/delivery.html",
				"/pedido":"resources/pedidos/administrarPedido.html",
				"/contato": "resources/contato.html",
				"/cadastro": "resources/usuario/cadastroUsuario.html",
				"/producao": "resources/pedidos/administrarPedido.html",
				"/pedido":"resources/pedidos/listarPedidoUsuario.html",
				"/funcionario":"resources/funcionario/gerenciaFuncionario.html",
				"/taxas":"resources/taxa/gerenciaTaxa.html",
				"/usuarios":"resources/usuario/gerenciaUsuario.html",
				"/gerenciaProduto":"resources/produto/gerenciaProduto.html",
				"/controleVendas":"resources/vendas/controleVendas.html",
				"/cadastroFuncionario":"resources/funcionario/cadastroFuncionario.html",
				"/cadastroProduto": "resources/produto/formularioProduto.html",
				"/pedidoUsuario": "resources/pedidos/pedidoUsuario.html",
				"/index":"resources/ofertadia.html"};
	
	loadContentByPath = function() {
		for ( var i in mapHref ) {
			if ( window.location.pathname.endsWith(i) ) {
				$("#conteudo").load(mapHref[i]);
				break;
			} 
		}
	}
	loadContentByPath();
	
	loadCarregarFunction = function(clazz) {
		$(clazz).on("click",function(e){
			var href = mapHref["/"+$(this).attr("action")];
			$("#conteudo").load(href);
			window.history.pushState({url:href}, $(this).attr("action"), $(this).attr("action"));
		});
	};
	loadCarregarFunction(".carregar");
	
	loadUrl = function(path) {
		var href = mapHref["/"+path];
		if(path == "index"){
			window.location.assign("index");
		}else{
			$("#conteudo").load(href);
		}
		window.history.pushState({url:href}, path, path);
	};
	
	HM.sessao = function(data, back){
		HM.ajax.post({
			async: false,
			url:"rest/Sessao/getSessao/"+ data,
			success:function(succ){
				back = succ.sessao;
			},
			error:function(err){
				console.log(err);
			}
		});
		return back;
	};
	
	function restricao(){
		if(HM.sessao('administrador') == 1 && HM.sessao('nome') != null){
			$(".administrador").show();
		}
		if(HM.sessao('funcionario') == 1 && HM.sessao('nome') != null){
			$(".funcionario").show();
		}if(HM.sessao('nome') != "" && HM.sessao('nome') != null){
			$(".usuario").show();
		} 
		if(HM.sessao('nome') != null && HM.sessao('nome') != ""){
			$(".logins").hide();
			$("#logout").show();
		}else{
			$(".logins").show();
			$("#logout").hide();
		}
	}
	restricao();
	
	$('#conteudoIndex').load('resources/ofertadia.html');
	$('#sugestaoCritica').load('resources/sugestaocritica.html');
	
	HM.editar = function(){
		var cod = HM.sessao('cod');
		if(HM.sessao('funcionario')!=1){
			$("#conteudo").append('<script type="text/javascript" src="resources/usuario/js/serviceUsuario.js"></script>'
					+ '<script type="text/javascript" src="resources/usuario/js/gerenciaUsuario.js"></script>');
			HM.usuario.edit(cod);
		}else{
			$("#conteudo").append('<script type="text/javascript" src="resources/funcionario/js/serviceFunc.js"></script>');
			$.ajax({
				url : "resources/funcionario/cadastroFuncionario.html",
				async : false,
				success : function(dat) {
					$("#conteudo").html(dat);
					HM.cidade.listar({
						async : false,
						success : function(data) {
							var html = "";
							for (var i = 0; i < data.length; i++) {
								html += "<option value='"+ data[i].cod+ "'>"
								+ data[i].cidade + "</option>";
							}
							$("#txtcidade").append(html);
							HM.funcionario.popular({
								data : cod,
								success : function(func) {
										HM.bairro.listar({
											data:func.cidade,
											success:function(data){
												html="";
												for (var i = 0; i < data.length; i++) {
													html += "<option value='"+ data[i].codBairro+ "'>"+ data[i].bairro+ "</option>";
												}
												$("#txtbairro").append(html);
												$('#txtnome').val(func.nome);
												$('#nmbrcpf').val(func.cpf);
												$("#nmbrrg").val(func.rg);
												$("#nmbrdatanascimento").val(fromView(func.data_nascimento));
												$("#nmbrfone").val(func.telefone);
												$("#txtemail").val(func.email);
												$("#txtfuncao").val(func.funcao);
												$("#txtcidade").val(func.cidade);
												$("#txtrua").val(func.rua);
												$("#nmbrcasa").val(func.numero);
												$("#cep").val(func.cep);
												$("#txtcomplemento").val(func.complemento);
												$("#codfuncionario").val(func.cod);
												$("#buttonConfirmar").attr("onclick","HM.funcionario.exibirEdicao();");
												$("#txtbairro").val(func.bairro);
												if (func.administrador == 1) {
													$("#administrador").prop("checked","true")
												} else {
													$("#administrador").prop("unchecked")
												}
												$("input[name=ativo][value=" + func.ativo + "]").prop('checked', 'true');
											}
										})
									},
								error : function(err) {
									console.log(err);
									bootbox.alert("Erro ao Editar Funcionario.");
								}
							});
						}
					});
				},
				error : function(err) {
					console.log(err);
				}
			})
		}
	}
});
