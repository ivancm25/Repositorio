export class Usuario {
  id: string;
  nombre: string;
  email: string;
  password: string;

  constructor(id: string, nombre: string, email: string, password: string) {
    this.id = id;
    this.nombre = nombre;
    this.email = email;
    this.password = password;
  }

}
