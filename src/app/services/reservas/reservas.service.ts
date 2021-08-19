import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class ReservasService {

  private API_SERVER = "http://localhost:8080/reservas/";

  constructor(private httpClient: HttpClient) { }

  public getAllReservas(): Observable<any>{
    return this.httpClient.get(this.API_SERVER);
  }

  public saveReserva (reserva:any): Observable<any>{
    return this.httpClient.post(this.API_SERVER, reserva);
  }

  public deleteReserva(id:any): Observable<any>{
    return this.httpClient.delete(this.API_SERVER + "delete/" + id);
  }
}
