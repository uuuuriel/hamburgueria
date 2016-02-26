function carregar(pagina) {
	$("#conteudo").load(pagina);
}

$(document).ready(function() {
	$('#conteudoIndex').load('resources/ofertadia.html');
	$('#sugestaoCritica').load('resources/sugestaocritica.html');

	HM.login = function() {
		HM.ajax.post({
			url : "rest/LoginRest/login/",
			data : JSON.stringify({
				'email' : $("#email").val(),
				'senha' : $("#senha").val()
			}),
			success : function(succ) {
				if (succ == 'success') {
					$("#myModal").modal('toggle');
					$("#div-menu-login strong").text('Logout');
					$("#div-menu-login").removeAttr('href');
					$("#div-menu-login").attr('onclick', 'HM.logout();');
					$("#div-menu-login").css('cursor', 'pointer');
				} else {
					$("#senha").val('');
					bootbox.alert(succ);
				}
			},
			error : function(error) {
				console.log(error);
			}
		});
	};

	HM.hue = function(sessao) {
		HM.ajax.post({
			url : "/rest/Sessao/getSessao/" + sessao,
			success : function(succ) {
				console.log(succ);
			},
			error:function(err){
				console.log(err);
			}
		});
	};

});
