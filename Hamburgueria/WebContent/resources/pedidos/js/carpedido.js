$(document).ready(function(){
	HM.produto.listar = function(){
		HM.produto.exibir({
			data:"",
			success : function(data) {
				var html = "";
				for ( var i = 0; i < data.length; i++) {
					html += "<div class='divGallery col-sm-3' onclick='HM.produto.exibe("+data[i].cod+")'>"
							+"<img src='assets/imagem/imagem3.png' width='80px'>" 
							+"<div class='valorDivGallery'><strong>"+data[i].valor+"</strong></div>"
							+"<div class='textoDivGallery'><p>"+data[i].descricao+"</p></div></div>";
				}
				$(".listaProdutos").html(html);
			},
			error : function(error) {
				console.log(error);
			}
		});
	};

	HM.produto.exibe = function(cod){
		HM.produto.popular({
					data: cod,
					success: function(resp){
						bootbox.dialog({
							  message: "<img src='assets/imagem/imagem3.png' width='100%' style='margin:0 auto'/>" +
							  		"<div class='descricaoProduto'>" + resp.descricao +"</div>",
							  title: ""+resp.nomeproduto +"<hr>",
							  size: 'small',
							  onEscape: function() {},
							  buttons: {
							    success: {
							      label: "Adicionar ao Carrinho",
							      className: "btn-success",
							      callback: function() {
							    	  	HM.ajax.post({
							    			url:"rest/Pedido/listaPedido/"+ cod,
							    			success:function(succ){
							    				console.log(succ);
							    			},
							    			error:function(err){
							    				console.log(err);
							    			}
							    	  	});
							      	}
							    	},
							    	danger: {
								      label: "Fechar",
								      className: "btn-danger",
								      callback: function() {
								       		$(this).fadeOut(1000);
								      	}
								    }
								}
							});
					},
					error: function(err){
						console.log(err);
					}
				});
	};
	HM.produto.listar();
});