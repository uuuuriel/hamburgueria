$(document).ready(function(){
	$("#buttonSugescri").on('click',function(){
		if($("#email").val() == ""){
			bootbox.alert("Email obrigatório.");
			return false;
		}else if($("#mensagem").val() == ""){
			bootbox.alert("Escreva alguma mensagem.");
			return false;
		}else{
			HM.sugescri.adicionar({
				data:{'email':$("#email").val(), 'nome':$("#nome").val(),
					'telefone':$("#telefone").val(), 'mensagem':$("#mensagem").val()},
				success:function(data){
					bootbox.alert(data);
					$("#myModal2").modal('toggle');
				},
				error:function(error){
					console.log(error);
				}
			});
		}
	});
});