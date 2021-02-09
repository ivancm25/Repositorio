$(function () {
  $(".imgFruta, .imgVerdura, .imgCarne").draggable();
  $(".cFruta").droppable({
    accept: ".imgFruta",
    drop: function (event, ui) {
      $(this).find("p").html("<strong>Correcto!</strong>");
    }
  });

  $(".cCarne").droppable({
    accept: ".imgCarne",
    drop: function (event, ui) {
      $(this).find("p").html("<strong>Correcto!</strong>");
    }
  });

  $(".cVerdura").droppable({
    accept: ".imgVerdura",
    drop: function (event, ui) {
      $(this).find("p").html("<strong>Correcto!</strong>");
    }
  });
});

