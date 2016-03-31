$(document).ready(function(){
	HM.produto.mask = function(){
    	$("#telefone").mask("(99)9999-9999");
		$("#cep").mask("99999-999");
		$("#numero").mask("999999");
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
		HM.pedidos.adicionar({
			data: cod,
			success:function(succ){
				if(succ){
					$("#carrinhoCompra").show();
					$("#carrinhoCompraTag").text(HM.sessao("produto").split(",").length-1);
				}
			},
			error:function(err){
				console.log(err.responseText);
			}
		})
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
	HM.produto.encerra = function(data, url){
		console.log(data);
		HM.ajax.post({
			url: url,
			data: JSON.stringify(data),
			success:function(succ){
				console.log(succ);
				$("#carrinhoCompraTag").text("");
				$("#carrinhoCompraTag").hide();
			},
			error:function(err){
				console.log(err);
			}
		});
	}
	HM.produto.exibeValor = function (){
		$("#valueTotal").hide();
	}
	HM.produto.esconde = function(){
		$("#valueTotal").fadeIn(3000);
	}
	
	HM.cidade.change = function(){
		HM.bairro.listar({
			data: $('#cidade').val(),
			success:function(data){
				var html = "";
				for ( var i = 0; i < data.length; i++) {
					html += "<option value='"+ data[i].codBairro+ "'>"+ data[i].bairro+ "</option>";
				}
				$("#bairro").html(html);
			},
			error:function(err){
				bootbox.alert(err.responseText);
			}
		});
	};	
	
	
	HM.produto.finalizarPedido = function(){
		var produto = HM.sessao('produto');
		var msg = "<table class='table'>";
		array = produto.split(",");
		var total = 0;
		for ( var i = 0; i < array.length; i++) {
			if(array[i] > 0){
				HM.produto.popular({
					data: array[i],
					success: function(resp){
						msg += "<tr><td>" + resp.cod + "</td><td>" + resp.nome + "</td><td>R$ " + resp.valor +"<td></tr>";
						total = resp.valor + total;
					},
					error:function(err){
						console.log(err.responseText);
					}
				});
			}
		}
		var newData = {};
		msg += "</table><span id='valueTotal'  style='display:none'><h1><strong>TOTAL  R$ "+ total.toFixed(2) +" </strong></h1>";
		bootbox.dialog({
			message: "<div>" +msg+" </div>"
			+ "Retirada balcão <input type='radio' id='entrega' name='entrega' value='2' checked onchange='HM.produto.exibeValor()'/><br/>"
			+ "Entrega delivery <input type='radio' value='0' id='entrega' name='entrega' onchange='HM.produto.esconde()'/>",
			title: "Pedidos<hr>",
			size: 'small',
			onEscape: function() {},
			buttons: {
				success: {
					label: "Continuar",
					className: "btn-success",
					callback: function() {
						newData.codtaxa = $('input[name="entrega"]:checked').val();
						$(this).fadeOut();
						if (HM.sessao('funcionario') == 1) {
							HM.cidade.listar({
								async : false,
								success : function(data) {
										var html = "";
										for ( var i = 0; i < data.length; i++) {
											html += "<option value='"+ data[i].cod+ "'>"+ data[i].cidade+ "</option>";
										}
										$("#cidade").html(html);
									},
									error:function(err){
										bootbox.alert(err.responseText);
									}
								});
							HM.usuario.exibir({
								data: "",
								success : function(data) {
									var availableTags = [];
									for (var i = 0; i < data.length; i++) {
										availableTags.push(
												{
													value: data[i].nome,
													label:data[i].nome,
													codigo: data[i].cod,
													telefone: data[i].telefone,
													cep: data[i].cep,
													bairro: data[i].bairro,
													rua: data[i].rua,
													numero: data[i].numero,
													cidade: data[i].cidade
												}
											);
									}
								    $( "#tags" ).autocomplete({
								      source: availableTags,								      
								      select: function(event, ui) {
								    	  $("#cidade").val(ui.item.cidade);
								    	  HM.bairro.listar({
								  			data: $('#cidade').val(),
								  			success:function(data){
									  				var html = "";
									  				for ( var i = 0; i < data.length; i++) {
									  					html += "<option value='"+ data[i].codBairro+ "'>"+ data[i].bairro+ "</option>";
									  				}
									  				$("#bairro").html(html);
									  				$("#bairro").val(ui.item.bairro);
									  			},
									  			error:function(err){
									  				bootbox.alert(err.responseText);
									  			}
								  			});
								    	  $(".disableds").attr("disabled","disabled");
								    	  $("#cod").val(ui.item.codigo);
								    	  $("#telefone").val(ui.item.telefone);
								    	  $("#cep").val(ui.item.cep);
								    	  $("#rua").val(ui.item.rua);
								    	  $("#numero").val(ui.item.numero);
								        },
								        response: function( event, ui ) {
								        	$("#cidade").val("");
								        	$("#bairro").val("");
								        	$("#cod").val("");
									    	$("#telefone").val("");
									    	$("#cep").val("");
									    	$("#rua").val("");
									    	$("#numero").val("");
									    	$(".disableds").prop("disabled", false); 
								        }
								    });
								},
								error : function(error) {
									console.log(error);
								}
							});
							
							bootbox.dialog({
								message: '<div class="form-group"><input type="text" id="tags" class="colorBlack form-control" placeholder="Nome"/></div>'
											+'<div class="form-group"><input class="form-control disableds" onKeyPress="HM.produto.mask()" id="telefone" placeholder="Telefone"/></div>'
											+"<div class='form-group'><select id='cidade' name='cidade' class='disableds form-control' onchange='HM.cidade.change()'></select></div>"
											+'<div class="form-group"><select class="disableds form-control" id="bairro" name="bairro"></select></div>'
											+'<div class="form-group"><input class="disableds form-control" id="rua" placeholder="Rua"/></div>'
											+'<div class="form-group"><input class="disableds col-sm-4 colorBlack" id="numero" placeholder="Nº"/> '
											+'<input class="disableds col-sm-8 colorBlack" id="cep" placeholder="CEP"/></div>'
											+'<input type="hidden" id="cod" />',
								title: "Formulário de Entrega<hr>",
								size: 'small',
								onEscape: function() {},
								buttons: {
									success: {
										label: "Confirmar",
										className: "btn-success",
										callback: function() {
											var cod = $("#cod").val();
											var url = "";
											$("#telefone").unmask();
											$("#cep").unmask();
											$("#numero").unmask();
											if (cod == "" || cod == null) {
												newData.nome = $("#tags").val();
												newData.telefone = $("#telefone").val();
												newData.cidade = $("#cidade").val();
												newData.bairro = $("#bairro").val();
												newData.rua = $("#rua").val();
												newData.numero = $("#numero").val();
												newData.cep = $("#cep").val();
												url = "rest/Pedido/finalizarPedidoFuncionarioNovo";
											}else{
												url = "rest/Pedido/finalizarPedidoFuncionario/";
												newData.codcliente = cod;
											}
											HM.produto.encerra(newData, url);
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
							HM.produto.encerra(newData, "rest/Pedido/finalizar");
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
})