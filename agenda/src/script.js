var agendaContactos = [];
var nuevoContacto;

class Contacto {
  constructor(nombre, num) {
    this.nombre = nombre;
    this.num = num;
  };
}

agendaContactos.push(new Contacto("Iván", 612345678));
agendaContactos.push(new Contacto("Juan", 611223344));
agendaContactos.push(new Contacto("Aarón", 698765432));
agendaContactos.push(new Contacto("Pablo", 697531678));
agendaContactos.push(new Contacto("Ana", 654987321));
agendaContactos.push(new Contacto("María", 639258147));

function crearTabla() {
    for (let i = 0; i < agendaContactos.length; i++) {
        $("#agenda").append( 
        "<tr>" + 
            "<td>" + agendaContactos[i]['nombre'] + "</td>" +
            "<td>" + agendaContactos[i]['num'] + "</td>" +
        "</tr>");
    }
}

function anadirContactoTabla() {
    $("#agenda").append( 
        "<tr>" + 
            "<td>" + agendaContactos[agendaContactos.length - 1]['nombre'] + "</td>" +
            "<td>" + agendaContactos[agendaContactos.length - 1]['num'] + "</td>" +
        "</tr>");
}

$(function () {
    crearTabla();

    $("#ordenarNombre").click(function () {
        agendaContactos.sort(function(a, b) {
            if (a.nombre > b.nombre) {
                return 1;
              }
            if (a.nombre < b.nombre) {
                return -1;
            }
            return 0;
        });

        $("#agenda").html(
            "<tr>" +
                "<th>Nombre</th>" +
                "<th>Número móvil</th>" +
            "</tr>");

        for (let i = 0; i < agendaContactos.length; i++) {
            $("#agenda").append( 
            "<tr>" + 
                "<td>" + agendaContactos[i]['nombre'] + "</td>" +
                "<td>" + agendaContactos[i]['num'] + "</td>" +
            "</tr>");
        }
    });

    $("#anadir").click(function () {
        nuevoContacto = new Contacto( $("#nombre").val(), $("#num").val() );
        agendaContactos.push(nuevoContacto);
        anadirContactoTabla();
        $("#reset").click();
    });     
});
