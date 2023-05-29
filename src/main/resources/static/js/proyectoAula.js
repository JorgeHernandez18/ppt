// Call the dataTables jQuery plugin
$(document).ready(function() {

  cargarProyectoAula();
  $('#proyectoAula').DataTable();
});

async function cargarProyectoAula(){

  const request = await fetch('api/proyectoaula', {
    method: 'GET',
    headers: {
      'Accept': 'application/json',
      'Content-Type': 'application/json'
    }
    });

  const proyectoAula = await request.json();

let listadoHTML = '';
for(let proyecto of proyectoAula){
    let proyectoHTML = '<tr><td>' + proyecto.id + '</td><td>' + proyecto.nombre + '</td><td>' + proyecto.id_eje_transversal + '</td><td>'
                    + proyecto.tipo_eje + '</td><td>' + proyecto.fecha_inicio + '</td><td>' + proyecto.fecha_fin + '</td><td>' + proyecto.docente_lider + '</td><td>' + proyecto.actividad_pa + '</td><td>'
                    + proyecto.grado +  '</td><td>' + proyecto.cierre + '</td><td><a href="#" class="btn btn-danger btn-circle btn-sm"><i class="fas fa-trash"></i></a></td></tr>'
    listadoHTML += proyectoHTML;
}

document.querySelector('#proyectoAula tbody').outerHTML = listadoHTML;
}