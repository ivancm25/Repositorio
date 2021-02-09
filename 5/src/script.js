$(document).ready(function () {
    $("#opc").change(function () {
      var videoValue = $(this).val();
  
      if (videoValue == 1) {
        $("#vid").attr("src", "vid/video.mp4");
        $("#vid").attr("type", "video/mp4");
      } else if (videoValue == 2) {
        $("#vid").attr("src", "vid/video.ogv");
        $("#vid").attr("type", "video/ogv");
      } else {
        $("#vid").attr("src", "vid/video.webm");
        $("#vid").attr("type", "video/webm");
      }
    });
});

$(function () {
    var video = $("#vid")[0];

    $("#play").click(function () {
        video.play();
    } );

    $("#pausa").click(function () {
        video.pause();
    } );

    $("#mute").click(function () {
        video.volume = 0;
    } );

    $("#retrasar").click(function () {
        video.currentTime -= 3;
    } );

    $("#adelantar").click(function () {
        video.currentTime += 3;
    } );

    $("#vol-").click(function () {
        video.volume -= 0.1;
    } );

    $("#vol+").click(function () {
        video.volume += 0.1;
    } );
});
