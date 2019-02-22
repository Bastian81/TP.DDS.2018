/*var jcontent = {
	"firstName": "john",
	"lastName": "watson"
}

var output = document.getElementById('output');
output.innerHTML = jcontent.firstName + ' ' + jcontent.lastName;*/

//json

/*var text = '{ "name":"John", "city":"New York"}';*/

var clientes = JSON.parse("clientes");

function loguearUsuario() {
	alert(clientes);
}

//btn-logusuario