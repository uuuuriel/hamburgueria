function fromBD(data){
	var quebraini = data.split("/");
	data = quebraini[2] + "-" + quebraini[1] + "-" + quebraini[0];
	return data;
}
function fromView(data){
	var quebraini = data.split("-");
	data = quebraini[2] + "/" + quebraini[1] + "/" + quebraini[0];
	return data;
}
