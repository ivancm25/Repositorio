import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class ApartamentosService {

  private API_SERVER = "http://localhost:8080/apartamentos/";

  constructor(private httpClient: HttpClient) { }

  public getAllApartamentos(): Observable<any>{
    return this.httpClient.get(this.API_SERVER);
  }

  public saveApartamento (apartamento:any): Observable<any>{
    return this.httpClient.post(this.API_SERVER, apartamento);
  }

  public deleteApartamento(id:any): Observable<any>{
    return this.httpClient.delete(this.API_SERVER + "delete/" + id);
  }

}
