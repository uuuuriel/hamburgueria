$(document).ready(function(){
	/*window.onpopstate = function(event) {
		$('#conteudo').load(event.state.url);
	 }
	$(".carregar").on("click",function(e){
		e.preventDefault();
//		var url = window.location.pathname.indexOf("/h/") > 0 ? "" : "h/";
//		url += $(this).attr("title");
		$("#conteudo").load($(this).attr("href"));
		$(this).attr("href");
		window.history.pushState({url:$(this).attr("href")}, $(this).attr("action"), $(this).attr("action"));
	})
	
	*/
	function carregar(url){
		$("#conteudo").load(url);
	}
	
	function loadContent(url){
		$('#conteudo').load(url);
	};
	
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
				"/cadastroFuncionario":"resources/funcionario/cadastroFuncionario.html"};
	
	loadContentByPath = function() {
		for ( var i in mapHref ) {
			if ( window.location.pathname.endsWith(i) ) {
				loadContent(mapHref[i]);
				break;
			} 
		}
	}
	loadContentByPath();
	
	loadCarregarFunction = function() {
		$(".carregar").on("click",function(e){
			var href = mapHref["/"+$(this).attr("action")];
			$("#conteudo").load(href);
			window.history.pushState({url:href}, $(this).attr("action"), $(this).attr("action"));
		});
	};
	loadCarregarFunction();
	
	loadUrl = function(path) {
		var href = mapHref["/"+path];
		$("#conteudo").load(href);
		window.history.pushState({url:href}, path, path);
	};
	
	
	
	
	
	/*window.onpopstate = function(event) {
	$('#conteudo').load(event.state.url);
 }
$(".carregar").on("click",function(e){
	e.preventDefault();
//	var url = window.location.pathname.indexOf("/h/") > 0 ? "" : "h/";
//	url += $(this).attr("title");
	$("#conteudo").load($(this).attr("href"));
	$(this).attr("href");
	window.history.pushState({url:$(this).attr("href")}, $(this).attr("action"), $(this).attr("action"));
})

*/
	
	
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
	$(document).ready(function() {
		$('#conteudoIndex').load('resources/ofertadia.html');
		$('#sugestaoCritica').load('resources/sugestaocritica.html');
	});
});
