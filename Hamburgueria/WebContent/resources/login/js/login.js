HM.login = function() {
	var email = document.getElementById("email").value;
	var senha = document.getElementById("senha").value;
	$.ajax({
        type: "POST",           
        data: 'email='+encodeURIComponent(email)+'&senha='+encodeURIComponent(senha),
        url: "/Hamburgueria/login",
        success:function(content){
            restricao();         
        }           
    });
};
HM.logout = function(){
	var toma = 'destroi';
	$.ajax({
		url: "logout/DestroiSessao",
		data: toma,
		success:function(succ){
			console.log(succ);
		},
		error:function(error){
			console.log(error);
		}
	});
};