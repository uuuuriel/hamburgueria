$(".deletProduto").on("click", function() {
	bootbox.confirm({
		size : 'small',
		message : "Deseja deletar o produto?",
		callback : function(result) {
		}
	})
});