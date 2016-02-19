$(document).ready(function(){
	HM.taxa.busca = function(){
		var ok = $("#search").val();
		if (ok == "") {
			ok = "null";
		}
		HM.taxa.buscar({
			data: ok,
			success:function(resp){
				for ( var i = 0; i < resp.length; i++) {
					$("#cod"+(i+1)).text(resp[i].cod);
					$("#nome"+(i+1)).text(resp[i].nome);
					$("#descricao"+(i+1)).text(resp[i].descricao);
					$("#valor"+(i+1)).val(resp[i].valor);
				}
			},
			error:function(err){
				console.log(err.responseText());
			}
		})
	}

	$('#buttonSearch').on('click', function(){
		HM.taxa.busca();
	})

	HM.taxa.busca();
})