export class Oferta {
  nombreCiudad: string;
  provincia: string;
  descripcion: string;
  precio: number;
  rutaimg: string;

  constructor(nuevoNombre: string, nprovincia: string, ndescripcion: string, nprecio: number, ruta: string) {
    this.nombreCiudad = nuevoNombre;
    this.provincia = nprovincia;
    this.descripcion = ndescripcion;
    this.precio = nprecio;
    this.rutaimg = ruta;
  }

}
