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
}
