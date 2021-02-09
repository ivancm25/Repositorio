var catalogoPrinc = [];

class Articulo {
  constructor(nombre, tipo, img1, img2, img3, descripcion) {
    this.nombre = nombre;
    this.tipo = tipo;
    this.img1 = img1;
    this.img2 = img2;
    this.img3 = img3;
    this.descripcion = descripcion;
  };
}

// Aquí añado los artículos por defecto
catalogoPrinc.push(new Articulo("Dragon Ball", "juego", "img/articulos/juegos/dragon-ball-1.png", "img/articulos/juegos/dragon-ball-2.png", "img/articulos/juegos/dragon-ball-3.png", "Juego del anime Dragon Ball"));
catalogoPrinc.push(new Articulo("Spider-Man", "juego", "img/articulos/juegos/spiderman.png", "img/articulos/juegos/spiderman-2.png", "img/articulos/juegos/spiderman-3.png", "Juego sobre la película de Spider-Man"));
catalogoPrinc.push(new Articulo("Origen", "pelicula", "img/articulos/peliculas/origen-1.png", "img/articulos/peliculas/origen-2.png", "img/articulos/peliculas/origen-3.png", "Película dirigida por Christopher Nolan"));
catalogoPrinc.push(new Articulo("Como conocí a vuestra madre", "serie", "img/articulos/series/ccavm-1.png", "img/articulos/series/ccavm-2.png", "img/articulos/series/ccavm-3.png", "Sitcom americana estrenada en 2005"));
catalogoPrinc.push(new Articulo("Brooklyn Nine-Nine", "serie", "img/articulos/series/brooklyn99-1.png", "img/articulos/series/brooklyn99-2.png", "img/articulos/series/brooklyn99-3.png", "Serie de comedia policiaca"));
catalogoPrinc.push(new Articulo("Goodfellas", "pelicula", "img/articulos/peliculas/goodfellas.png", "img/articulos/peliculas/goodfellas-2.png", "img/articulos/peliculas/goodfellas-3.png", "Película de mafia de Martin Scorsese"));
catalogoPrinc.push(new Articulo("Scarface", "pelicula", "img/articulos/peliculas/scarface.png", "img/articulos/peliculas/scarface-2.png", "img/articulos/peliculas/scarface-3.png", "Película de mafia protagonizada por Al Pacino"));
catalogoPrinc.push(new Articulo("Los Simpson", "serie", "img/articulos/series/simpson.png", "img/articulos/series/simpson-2.png", "img/articulos/series/simpson-3.png", "Serie de dibujos americana"));
catalogoPrinc.push(new Articulo("Padre de familia", "serie", "img/articulos/series/familyguy.png", "img/articulos/series/familyguy-2.png", "img/articulos/series/familyguy-3.png", "Serie de dibujos de humor americana"));
catalogoPrinc.push(new Articulo("Cyberpunk 2077", "juego", "img/articulos/juegos/cyberpunk.png", "img/articulos/juegos/cyberpunk-2.png", "img/articulos/juegos/cyberpunk-3.png", "Videojuego ambientado en un futuro"));
catalogoPrinc.push(new Articulo("El desorden que dejas", "serie", "img/articulos/series/desorden.png", "img/articulos/series/desorden-2.png", "img/articulos/series/desorden-3.png", "Serie sobre la obra de Carlos Montero"));
catalogoPrinc.push(new Articulo("Joker", "pelicula", "img/articulos/peliculas/joker.png", "img/articulos/peliculas/joker-2.png", "img/articulos/peliculas/joker-3.png", "Película sobre el famoso villano de DC"));
catalogoPrinc.push(new Articulo("Avengers: Endgame", "pelicula", "img/articulos/peliculas/endgame.png", "img/articulos/peliculas/endgame-2.png", "img/articulos/peliculas/endgame-3.png", "Película de superhéroes de Marvel"));
catalogoPrinc.push(new Articulo("Prison Break", "serie", "img/articulos/series/prisonbreak.png", "img/articulos/series/prisonbreak-2.png", "img/articulos/series/prisonbreak-3.png", "Serie de acción y suspense"));


$(function () {
  catalogoPrinc = catalogoPrinc.sort(function() {return Math.random() - 0.5});  // Los desordeno para que no aparezcan siempre en el mismo orden


  // Evento para controlar las coordenadas del ratón
  $(document).mousemove(function(event){
    $("#coord").html(event.pageX + ", " + event.pageY);   
  });


  // Bucle para ir añadiendo los artículos a la página
  for (let i = 0; i < catalogoPrinc.length; i++) {
    $("#catalogo-princ").append(
      "<div class='articulo'>" +
      "<a href='" + catalogoPrinc[i]['img3'] + "' data-lightbox='" + catalogoPrinc[i]['nombre'] + "' data-title='" + catalogoPrinc[i]['nombre'] + "'>" +
      "<a href='" + catalogoPrinc[i]['img2'] + "' data-lightbox='" + catalogoPrinc[i]['nombre'] + "' data-title='" + catalogoPrinc[i]['nombre'] + "'>" +  // Se va creando la galería de
      "<a href='" + catalogoPrinc[i]['img1'] + "' data-lightbox='" + catalogoPrinc[i]['nombre'] + "' data-title='" + catalogoPrinc[i]['nombre'] + "'>" +  // cada artículo
      "<div class='over'><img src='" + catalogoPrinc[i]['img1'] + "' class='img'/>" +
      "<span>" + catalogoPrinc[i]['descripcion'] + "</span></div></a></a></a>" +            // La descripción del artículo
      "<strong>" + catalogoPrinc[i]['nombre'] + "</strong> <br>" +
      "<p>" + catalogoPrinc[i]['tipo'] + "</p>" +
      "</div>"
    );
  }


  // Función para abrir y cerrar el menú deslizante
  $('#menuBarra li > .sub-menu').parent().hover(function () {
    var submenu = $(this).children('.sub-menu');
    if ($(submenu).is(':hidden')) {
      $(submenu).slideDown(200);
    } else {
      $(submenu).slideUp(200);
    }
  });

});