$(document).ready(function() {	
	HM.taxa = {
		buscar : function(cfg){
			HM.ajax.get({
				url: "rest/TaxaRest/buscar/"+cfg.data,
				success:function(list){
					if (cfg && cfg.success){
						cfg.success(list);
					}
				},
				error: function(err){
					cfg.error(err);
				}
			})
		},
		
		atualizar : function(cfg){
			HM.ajax.put({
				url: "rest/TaxaRest/atualizar/",
				data: cfg.data,
				success:function(cod){
					if(cfg && cfg.success){
						cfg.success(cod);
					}
				},
				error: function(err){
					cfg.error(err);
				}				
			})
		},
		entrega : function(cfg){
			HM.ajax.get({
				url: "rest/TaxaRest/entrega",
				success:function(succ){
					if(cfg && cfg.success){
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
	
});