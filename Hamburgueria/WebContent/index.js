function carregar(pagina) {
	$("#conteudo").load(pagina);
}
var base = "resources/uploads/";
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
