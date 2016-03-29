$(document).ready(
		function() {
			HM.usuario = new Object();
			HM.usuario = {
				exibir : function(cfg) {
					var busca = cfg.data;
					if (busca == "") {
						busca = "null";
					}
					HM.ajax.get({
						url : "rest/UsuarioRest/buscarUsuariosPorNome/"
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
				}
			};
		});