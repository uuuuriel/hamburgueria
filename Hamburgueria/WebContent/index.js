$(document).ready(function(){
	window.onpopstate = function(event) {
		console.dir(event);
		$('#conteudo').load(event.state.url);
	 }
	$(".carregar").on("click",function(e){
		e.preventDefault();
//		var url = window.location.pathname.indexOf("/h/") > 0 ? "" : "h/";
//		url += $(this).attr("title");
		$("#conteudo").load($(this).attr("href"));
		window.history.pushState({url:$(this).attr("href")}, $(this).attr("title"), $(this).attr("title"));
	})
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
