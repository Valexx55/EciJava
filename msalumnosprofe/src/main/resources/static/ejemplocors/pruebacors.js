//desde aquí, es desde donde vamos a hacer petición al servidor
fetch("http://localhost:8081/alumno")
.then(respuesta => respuesta.json())
.then (lista_alumnos => {
	console.log ('Aquí la vuelta con JS Normal');
	lista_alumnos.forEach (alumno => {
		console.log (alumno.id + " " +alumno.nombre);
	});
})
.catch(function(error) {
  console.log ('Aquí la vuelta con JS Normal');
  console.log('Hubo un problema con la petición Fetch:' + error.message);
});

function mifuncion (cadena_json)
{
	console.log ('Aquí la repuesta con JSONP');
	console.log (cadena_json);//este sera el alumno
}