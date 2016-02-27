function carregar(pagina) {
	$("#conteudo").load(pagina);
}

$(document).ready(function() {
	$('#conteudoIndex').load('resources/ofertadia.html');
	$('#sugestaoCritica').load('resources/sugestaocritica.html');
});
