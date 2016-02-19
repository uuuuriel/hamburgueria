    function carregar(pagina){
        $("#conteudo").load(pagina);
    }

$(document).ready(function(){
   	$('#conteudoIndex').load('resources/ofertadia.html');
    $('#sugestaoCritica').load('resources/sugestaocritica.html');
});

function critica(){
	bootbox.dialog({
		message: "<input type='text' class='form-control' id='txtemailCS'/>",
	  	title: "hue<hr>",
	  	size: 'small',
	  	onEscape: function() {},
	  	buttons: {
	    	success: {
	      		label: "Adicionar ao Carrinho",
	      		className: "btn-success",
	      		callback: function() {
	      			var hue = $('txtemailCS').val();
	        		alert(hue);
	  	    			}
	    			},
	    		danger: {
		      	label: "Fechar",
		      	className: "btn-danger",
		      	callback: function() {
		       		$(this).fadeOut(1000);
		      		}
		    	}
			}
		});
};