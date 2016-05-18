HM.login = function() {
	var email = document.getElementById("email").value;
	var senha = document.getElementById("senha").value;
	$.ajax({
        type: "POST",           
        data: 'email='+encodeURIComponent(email)+'&senha='+encodeURIComponent(senha),
        url: "/Hamburgueria/login",
        success:function(content){
        	if(content == "true"){
	        	$('.loginInvalido').fadeIn(function(){
	 				$(".loginInvalido").html("Email e senha não conferem.");
	 			}).delay(2000).fadeOut(2000);
        	}else{
        		window.history.pushState({url:"index"}, "index", "index");
        		window.location.href="index";
        	}
        	
        }           
    });
};
function enter(evt){
	if( evt.keyCode==13 ) {
    	HM.login();
    }
 }
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