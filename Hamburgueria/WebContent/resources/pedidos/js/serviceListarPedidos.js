$(document).ready(
		function() {
			HM.pedidos = new Object();
			HM.pedidos = {
				exibir : function(cfg) {
					var busca = cfg.data;
					if (busca == "") {
						busca = "null";
					}
					HM.ajax.get({
						url : "rest/Pedido/"
								+ busca,
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