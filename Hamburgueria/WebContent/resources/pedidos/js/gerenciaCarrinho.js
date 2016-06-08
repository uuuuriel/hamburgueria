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
					+"<img src='imagem?caminho="+data[i].anexo+"' width='80px'>"
					+"<div class='valorDivGallery'><strong>R$ "+data[i].valor.toFixed(2)+"</strong></div>"
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
		if(HM.sessao('nome') == ""){
			bootbox.alert("Acesse sua conta antes de fazer um pedido, ou ligue para nossa tele entrega! :)");
			return false;
		}
		HM.pedidos.adicionar({
			data: cod,
			success:function(succ){
				$("#carrinhoCompra").show();
				$("#carrinhoCompraTag").show();
				$("#carrinhoCompraTag").text(HM.sessao("produto").split(",").length-1);
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
					message: "<img src='imagem?caminho="+resp.anexo+"' width='100%' style='margin:0 auto'/>" +
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
		HM.ajax.post({
			url: url,
			data: JSON.stringify(data),
			success:function(succ){
				$("#carrinhoCompraTag").text("");
				$("#carrinhoCompraTag").hide();
				$("#carrinhoCompra").hide();
				$('#alerts').fadeIn(function(){
					$("#alerts").html("Agradecemos por comprar conosco! :)");
				}).delay(2000).fadeOut(2000);
			},
			error:function(err){
				console.log(err);
			}
		});
	}
	HM.produto.exibeValor = function (){
		$("#retiradaBalcao").show();
		$("#teleEntrega").hide();
	}
	HM.produto.esconde = function(){
		$("#teleEntrega").show();
		$("#retiradaBalcao").hide();
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
	
	HM.usuario.valida = function(){
		if($("#cod").val() == "" || $("#cod").val() == null){
			$("#telefone").unmask();
			var fone = $("#telefone").val();
			$("#telefone").mask("(99)9999-9999");
			HM.usuario.validaFone({
				data:fone,
				success:function(data){
					if(data){
						bootbox.alert("Por favor, insira outro telefone, já existe um cadastro com o mesmo número.")
						$("#telefone").val("");
					}
				},
				error:function(err){
					bootbox.alert(err.responseText);
				}
			})
		}
	}
	
	HM.produto.somaTudo = function(vlr){
		var total = 0;
		HM.taxa.valorMinimo({
			success:function(valorMinimo){},
			error:function(err){}
		})
		$(".somaTudo").each(function(){
			if($(this).val() < 0){
				bootbox.alert("Não é premitido valor negativo");
				$(this).val("0");
				return false;
			}
			total = parseFloat(total) + ($(this).val() * parseFloat($(this).attr("valor")));
		})
//		if(total < valorMinimo.valor){
//			bootbox.alert("Valor mínimo de compra é de R$ "+valorMinimo.valor);
//			return false;
//		}
		var valor = 0;
		$("#retiradaBalcao").text(total.toFixed(2));
		$("#teleEntrega").text(total+ parseFloat($('#entrega1').attr("valor")));
	}
	
	HM.produto.finalizarPedido = function(){
		var produto = HM.sessao('produto');
		array = produto.split(",");
		var total = 0;
		var listaProduto = [];
		var first = true;
		
		for ( var i = 0; i < array.length; i++) {
			if(array[i] > 0){
				HM.produto.popular({
					data: array[i],
					success: function(resp){
						listaProduto.push(resp);
					},
					error:function(err){
						console.log(err.responseText);
					}
				});
			}
		}
		HM.usuario.maskcep = function(){
			$("#cep").mask("99999-999");
		}
		var groupedData = [];
		var arr = [];
		var x = 0;
		for (var it = 0; it < listaProduto.length; it++) {
			var item = listaProduto[it];
			if (!groupedData[item.cod]){
				groupedData[item.cod] = [];
				groupedData[item.cod].cod = item.cod;
				groupedData[item.cod].nome = item.nome;
				groupedData[item.cod].valor = item.valor;
				arr[x] = item.cod; 
				x += 1;
			}
			groupedData[item.cod].push(1);
		}
		var msg = "<table class='table'>";
		for (var i = 0; i < arr.length; i++) {
				msg += "<tr><td>" + groupedData[arr[i]].nome + "</td>"
					+ "<td><input type='number' id='"+ groupedData[arr[i]].cod +"' class='carrinhoNumber somaTudo'"
					+ " onchange='HM.produto.somaTudo();' valor='"+groupedData[arr[i]].valor+"' value='" + groupedData[arr[i]].length+ "'/>"
					+ "<td> R$ " + groupedData[arr[i]].valor +"</td></tr>";
				total = total + (groupedData[arr[i]].valor * groupedData[arr[i]].length);
		}
		HM.taxa.valorMinimo({
			success:function(valorMinimo){
				if(total > valorMinimo.valor){
					HM.taxa.entrega({
						success:function(entrega){
							var newData = {};
							msg += "</table><span><h1><strong>TOTAL  R$ <span  id='teleEntrega' style='display:none;'>"+ (total+entrega.valor).toFixed(2) +"</span> <span id='retiradaBalcao'>"+ total.toFixed(2) +"</span></strong></h1>";
							bootbox.dialog({
								message: "<div>" +msg+" </div>"
								+ "Retirada balcão <input type='radio'  id='entrega' name='entrega' value='2' checked onclick='HM.produto.exibeValor()'/><br/>"
								+ "Entrega delivery <input type='radio' valor='"+entrega.valor+"' value='0' id='entrega1' name='entrega' onclick='HM.produto.esconde()'/>",
								title: "Pedidos<hr>",
								size: 'medium',
								onEscape: function() {},
								buttons: {
									success: {
										label: "Continuar",
										className: "btn-success",
										callback: function() {
											var data = [];
											$(".somaTudo").each(function(){
												var add = {};
												add.cod = $(this).attr("id");
												add.qtde = $(this).val();
												data.push(add);
											})
											$(this).fadeOut();
											HM.pedidos.ajustaFinalizar({
												data:data,
												success:function(succ){
													newData.codtaxa = $('input[name="entrega"]:checked').val();
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
																				value: data[i].telefone,
																				label:data[i].telefone,
																				codigo: data[i].cod,
																				nome: data[i].nome,
																				cep: data[i].cep,
																				bairro: data[i].bairro,
																				rua: data[i].rua,
																				numero: data[i].numero,
																				cidade: data[i].cidade
																			}
																		);
																}
															    $( ".tags" ).autocomplete({
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
															    	  $("#nome").val(ui.item.nome);
															    	  $("#cep").val(ui.item.cep);
															    	  $("#rua").val(ui.item.rua);
															    	  $("#numero").val(ui.item.numero);
															        },
															        response: function( event, ui ) {
															        	$("#cidade").val("");
															        	$("#bairro").val("");
															        	$("#cod").val("");
																    	$("#nome").val("");
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
															message: '<div class="form-group"><input class="form-control tags" id="telefone" onfocusout="HM.usuario.valida()"  placeholder="Telefone"/></div>'
																		+'<div class="form-group"><input type="text" id="nome" class="disableds colorBlack form-control" placeholder="Nome"/></div>'
																		+"<div class='form-group'><select id='cidade' name='cidade' class='disableds form-control' onchange='HM.cidade.change()'></select></div>"
																		+'<div class="form-group"><select class="disableds form-control" id="bairro" name="bairro"></select></div>'
																		+'<div class="form-group"><input class="disableds form-control" id="rua" placeholder="Rua"/></div>'
																		+'<div class="form-group"><input class="disableds col-sm-4 colorBlack" id="numero" placeholder="Nº"/> '
																		+'<input class="disableds col-sm-8 colorBlack" id="cep" onfocusin="HM.usuario.maskcep();" placeholder="CEP"/></div>'
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
																			newData.nome = $("#nome").val();
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
												},
												error:function(err){
													console.log(err);
												}
											})
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
				}else{
					bootbox.alert("Valor mínimo de compra é de R$ "+valorMinimo.valor);
					return false;
				}
			}
		})
		
	}
})