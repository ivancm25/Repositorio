var sil = ["mon", "ca", "ja", "te", "sa", "la"];
var contador = 0;
var contadorTotal = 0;

function establecerSil() {
    for (let i = 0; i < sil.length; i++) {
        $("#silabas").append(
            "<p id='" + i + "'><strong>" + sil[i] + "</strong></p>"
        );
        $("#" + i).draggable({
            start: function () {
                contadorTotal++;
            }
        });
    }
}

$(function () {
    establecerSil();

    $(".divSil").droppable({
        accept: "#0, #1, #2, #3, #4, #5, #6",
        
        drop: function (event, ui) {
            $( this ).addClass( "divCompleto" );
            if (contadorTotal == sil.length) {
                alert("Ya has completado las palabras!");
            }
        },
    });
});
