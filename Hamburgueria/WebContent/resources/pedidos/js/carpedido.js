$(document).ready(function(){
	HM.produto.listar = function(){
		HM.produto.exibir({
			data:"",
			success : function(data) {
				var html = "";
				for ( var i = 0; i < data.length; i++) {
					html += "<div class='divGallery col-sm-3'><div onclick='HM.produto.exibe("+data[i].cod+")'>"
							+"<img src='assets/imagem/imagem3.png' width='80px'>"
							+"<div class='valorDivGallery'><strong>"+data[i].valor+"</strong></div>"
							+"<div class='textoDivGallery'><p>"+data[i].descricao+"</p></div></div>"
							+"<div class='addProduto' onclick='HM.produto.adiciona("+data[i].cod+");' title='Adicionar esse produto!'>adicionar</div></div>"
				}
				$(".listaProdutos").html(html);
			},
			error : function(error) {
				console.log(error);
			}
		});
	};
	
	HM.produto.adiciona = function(cod){
	  	HM.ajax.post({
			url:"rest/Pedido/listaPedido/"+ cod,
			success:function(succ){
				if(succ){
					var conta = parseInt($("#cont").val());
					conta = conta + 1;
					$("#cont").val(conta);
					$("#carrinhoCompraTag").text(conta);
				}
			},
			error:function(err){
				console.log(err);
			}
	  	});
	}

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
							    	  HM.produto.adiciona(cod);
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
	HM.produto.finalizarPedido = function(){
		HM.ajax.post({
			url:"rest/Pedido/finalizar",
			success:function(succ){
				console.log(succ);
			},
			error:function(err){
				console.log(err);
			}
	  	});
	}
	HM.produto.listar();
});