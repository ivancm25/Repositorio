export class Alojamiento {
  id: string;
  titulo: string;
  provincia: string;
  descripcion: string;
  precio: number;
  rutaimg: string;

  constructor(id: string, ntitulo: string, nprovincia: string, ndescripcion: string, nprecio: number, ruta: string) {
    this.id = id;
    this.titulo = ntitulo;
    this.provincia = nprovincia;
    this.descripcion = ndescripcion;
    this.precio = nprecio;
    this.rutaimg = ruta;
  }

  array: Array<Alojamiento>;

}
