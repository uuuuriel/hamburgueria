$(document).ready(function(){
	HM.venda = new Object();
	HM.venda = {
		openGrafico : function(cfg){
			HM.ajax.get({
				url: "rest/Grafico/venda/"+fromBD(cfg.dataini)+"/"+fromBD(cfg.datafim),
				success:function(succ){
					if(cfg.success && cfg){
						cfg.success(succ);
					}
				},
				error:function(err){
					if(cfg && cfg.error){
						cfg.error(err);
					}
				}
			})
		}
	}
	
})