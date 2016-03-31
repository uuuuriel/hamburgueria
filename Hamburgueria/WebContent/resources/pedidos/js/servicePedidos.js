$(document).ready(function() {
			HM.pedidos = new Object();
			HM.pedidos = {
				exibir : function(cfg) {
					var busca = cfg.busca;
					if (busca == "") {
						busca = "null";
					}
					/*var quebraini = split("/",cfg.dataini);
					cfg.dataini = quebraini[2] + "-" + quebra[1] + "-" + quebra[0];
					var quebrafim = split("/",cfg.datafim);
					cfg.datafim = quebrafim[2] + "-" + quebra[1] + "-" + quebra[0];*/
					busca = "null";
					cfg.dataini = "2015-10-10";
					cfg.datafim = "2016-10-10";
					HM.ajax.get({
						url : "rest/Pedido/listarPedidos/"+ busca +"/"+cfg.dataini+"/"+cfg.datafim,
						success : function(list) {
							if (cfg && cfg.success) {
								cfg.success(list);
								console.log(list);
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