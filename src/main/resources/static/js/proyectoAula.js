// Call the dataTables jQuery plugin
$(document).ready(function() {

  cargarUsuarios();
  $('#proyectoAula').DataTable();
});

async function cargarProyectoAula(){

  const request = await fetch('usuarios', {
    method: 'GET',
    headers: {
      'Accept': 'application/json',
      'Content-Type': 'application/json'
    }
    });

  const usuarios = await request.json();

let listadoHTML = '';
for(let usuario of usuarios){
    let usuarioHTML = '<tr><td>' + usuario.id + '</td><td>' + usuario.nombre + ' ' + usuario.apellido + '</td><td>'
                    + usuario.email + '</td><td><a href="#" class="btn btn-danger btn-circle btn-sm"><i class="fas fa-trash"></i></a></td></tr>'
    listadoHTML += usuarioHTML;
}

document.querySelector('#proyectoAula tbody').outerHTML = listadoHTML;
}
