$(".deletTaxa").on("click", function() {
	bootbox.confirm({
		size : 'small',
		message : "Deseja deletar a taxa?",
		callback : function(result) {
		}
	})
});