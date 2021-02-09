var contador = 0;

function comprobar() {
    if(contador == 9) {
        alert("Felicidades, has completado el puzzle");
    }
}

$(function () {
    $("#img0, #img1, #img2, #img3, #img4, #img5, #img6, #img7, #img8").draggable( {
        revert: "invalid"
    });

    $("#div0").droppable({
        accept: "#img0",
        
        drop: function (event, ui) {
            contador++;
            comprobar();
        },
    });

    $("#div1").droppable({
        accept: "#img1",

        drop: function (event, ui) {
            contador++;
            comprobar();
        },
    });

    $("#div2").droppable({
        accept: "#img2",

        drop: function (event, ui) {
            contador++;
            comprobar();
        },
    });

    $("#div3").droppable({
        accept: "#img3",

        drop: function (event, ui) {
            contador++;
            comprobar();
        },
    });

    $("#div4").droppable({
        accept: "#img4",

        drop: function (event, ui) {
            contador++;
            comprobar();
        },
    });

    $("#div5").droppable({
        accept: "#img5",

        drop: function (event, ui) {
            contador++;
            comprobar();
        },
    });

    $("#div6").droppable({
        accept: "#img6",

        drop: function (event, ui) {
            contador++;
            comprobar();
        },
    });

    $("#div7").droppable({
        accept: "#img7",

        drop: function (event, ui) {
            contador++;
            comprobar();
        },
    });

    $("#div8").droppable({
        accept: "#img8",

        drop: function (event, ui) {
            contador++;
            comprobar();
        },
    });
});