$(document).ready(function(){
	var conta = HM.sessao("produto");
	if(conta && conta != null && conta != undefined && conta != ""){
		$("#carrinhoCompraTag").text(conta.split(",").length-1);
		$("#carrinhoCompra").show();
	}
	
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
					$("#carrinhoCompra").show();
					$("#carrinhoCompraTag").text(HM.sessao("produto").split(",").length-1);
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
	HM.produto.encerra = function(cod){
		if (cod == "" || cod == null) {
			cod = "";
		}
		HM.ajax.post({
			url:"rest/Pedido/finalizarPedidoFuncionario",
			success:function(succ){
				$("#carrinhoCompraTag").text("");
				$("#carrinhoCompraTag").hide();
			},
			error:function(err){
				console.log(err);
			}
		});
	}
	
	HM.produto.finalizarPedido = function(){
		var produto = HM.sessao('produto');
		var msg = "<table class='table'>";
		array = produto.split(",");
		for ( var i = 0; i < array.length; i++) {
			if(array[i] > 0){
				HM.produto.popular({
					data: array[i],
					success: function(resp){
						msg += "<tr><td>" + resp.cod + "</td><td>" + resp.nome + "</td><td>R$" + resp.valor +"<td></tr>";
					},
					error:function(err){
						console.log(err.responseText);
					}
				});
			}
		}
		msg += "</table>";
		bootbox.dialog({
			message: "<div>" +msg+" </div>"
			+ "Retirada balcão <input type='radio' id='entrega' name='entrega' value='1'/><br/>"
			+ "Entrega delivery <input type='radio' value='0' id='entrega' name='entrega'/>",
			title: "Pedidos<hr>",
			size: 'small',
			onEscape: function() {},
			buttons: {
				success: {
					label: "Continuar",
					className: "btn-success",
					callback: function() {
						$(this).fadeOut();
						if (HM.sessao('funcionario') == 1) {
							HM.usuario.exibir({
								data: "",
								success : function(data) {
									var availableTags = [];
									for (var i = 0; i < data.length; i++) {
										availableTags.push(data[i].nome);
									}
								    $( "#tags" ).autocomplete({
								      source: availableTags
								    });
								},
								error : function(error) {
									console.log(error);
								}
							});
							bootbox.dialog({
								message: '<input type="text" id="tags" class="col-sm-12 colorBlack"/>',
								title: "Selecione o cliente, ou cadastre um novo<hr>",
								size: 'small',
								onEscape: function() {},
								buttons: {
									success: {
										label: "Confirmar",
										className: "btn-success",
										callback: function() {
											HM.produto.encerra($("#codCliente").val());
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
						}else{
							HM.produto.encerra();
						}
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
	}
	HM.produto.listar();
});