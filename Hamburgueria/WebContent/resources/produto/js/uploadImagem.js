function upload(receive){
    var tipoForm = document.getElementById("tipoForm").value;
    var imagem = document.getElementById("imagem").files[0];
    var formdata = new FormData();
    formdata.append("tipoForm", tipoForm);
    formdata.append("imagem", imagem);
    var xhr = new XMLHttpRequest();       
    xhr.open("POST","/Hamburgueria/upload", true);
    xhr.send(formdata);
    xhr.onload = function(e) {
        if (this.status == 200) {
        }
    };
    
	/*$.ajax({
		url : "/Hamburgueria/upload",
		type: "POST",
		processData: false,
		contentType: "multipart/form-data",
		data: formdata,
		success : function(dat) { console.log("ok ok"); },
		error: function(dat) { console.log("nao nao"); }
	});*/
}
