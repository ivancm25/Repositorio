import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class UsuariosService {

  private API_SERVER = "http://localhost:8080/usuarios/";

  constructor(private httpClient: HttpClient) { }

  public getAllUsuarios(): Observable<any>{
    return this.httpClient.get(this.API_SERVER);
  }

  public saveUsuario (usuario:any): Observable<any>{
    return this.httpClient.post(this.API_SERVER, usuario);
  }

  public deleteUsuario(id:any): Observable<any>{
    return this.httpClient.delete(this.API_SERVER + "delete/" + id);
  }
}
