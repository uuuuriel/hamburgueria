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
				},
				estagioPedido : function(cfg){
					HM.ajax.put({
						url: "rest/Pedido/atualizarEstagioPedido/"+cfg.estagio+"/"+cfg.codpe+"/"+cfg.codpr,
						success:function(succ){
							if(cfg && cfg.success){
								cfg.success(succ);
							}
						},
						error:function(err){
							if(cfg && cf.error){
								cfg.error(err);
							}
						}
					})
				},
				deletarPedido : function(cfg){
					console.log(cfg);
					HM.ajax.DELETE({
						url: "rest/Pedido/cancelarPedido/"+cfg.data+"/"+cfg.cancelado,
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
				},
				listarProdutosEstagio : function(cfg){
					HM.ajax.post({
						url : "rest/Pedido/listarProdutosEstagio/"+cfg.data,
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
				},
				pedidoEntregue : function (cfg){
					HM.ajax.post({
						url : "rest/Pedido/pedidoEntrega/"+cfg.data,
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
				},
				listarPedidoEntregue : function (cfg){
					HM.ajax.get({
						url:"rest/Pedido/listarPedidoEntrega",
						success:function(succ){
							if(cfg && cfg.success){
								cfg.success(succ);
							}
						},
						error:function(err){
							if(cfg & cfg.error){
								cfg.error(err);
							}
						}
					})
				}
			};
		});