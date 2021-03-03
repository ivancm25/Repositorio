export class Alojamiento {
  titulo: string;
  provincia: string;
  descripcion: string;
  precio: number;
  rutaimg: string;

  constructor(ntitulo: string, nprovincia: string, ndescripcion: string, nprecio: number, ruta: string) {
    this.titulo = ntitulo;
    this.provincia = nprovincia;
    this.descripcion = ndescripcion;
    this.precio = nprecio;
    this.rutaimg = ruta;
  }

}
