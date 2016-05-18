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
			window.location.assign("index.html");
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
			$(".funcionario").show();
			$(".usuario").show();
		}else if(HM.sessao('administrador') != 1 && HM.sessao('nome') != ""){
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
	
	function editar(){
		HM.sessao('cod');
	}
});
