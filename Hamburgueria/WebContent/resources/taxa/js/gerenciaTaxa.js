$(document).ready(function(){
	HM.taxa.busca = function(){
		var ok = $("#search").val();
		if (ok == "") {
			ok = "null";
		}
		HM.taxa.buscar({
			data: ok,
			success:function(resp){
				console.log(resp);
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