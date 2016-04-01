$(document).ready(function() {
			HM.pedidos = new Object();
			HM.pedidos = {
				exibir : function(cfg) {
					var busca = cfg.busca;
					if (busca == "") {
						busca = "null";
					}
					var quebraini = cfg.dataini.split("/");
					cfg.dataini = quebraini[2] + "-" + quebraini[1] + "-" + quebraini[0];
					var quebrafim = cfg.datafim.split("/");
					cfg.datafim = quebrafim[2] + "-" + quebrafim[1] + "-" + quebrafim[0];
					HM.ajax.get({
						url : "rest/Pedido/listarPedidos/"+ busca +"/"+cfg.dataini+"/"+cfg.datafim,
						success : function(list) {
							if (cfg && cfg.success) {
								cfg.success(list);
							}
						},
						error : function(err) {
							if (cfg && cfg.err) {
								cfg.error(err);
							}
						}
					})
				},
				adicionar : function(cfg) {
					HM.ajax.post({
						url:"rest/Pedido/addProduto/"+ cfg.data,
						success:function(list){
							if (cfg && cfg.success) {
								cfg.success(list);
							}
						},
						error:function(err){
							if (cfg && cfg.err) {
								cfg.error(err);
							}
						}
					});
				}
			};
		});