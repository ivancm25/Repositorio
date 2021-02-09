
var inicio = new Date;

function tiempo_carga(){
    var fin = new Date;
    var segundos = (fin-inicio)/1000;
    var salida = "La pagina ha sido cargada en "+segundos +" segundos";
    document.getElementById("tiempoCarga").innerHTML = salida;
}

onload=function() {tiempo_carga();}

