import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class CasasRuralesService {

  private API_SERVER = "http://localhost:8080/casas-rurales/";

  constructor(private httpClient: HttpClient) { }

  public getAllCasasRurales(): Observable<any>{
    return this.httpClient.get(this.API_SERVER);
  }

  public saveCasaRural (casaRural:any): Observable<any>{
    return this.httpClient.post(this.API_SERVER, casaRural);
  }

  public deleteCasaRural(id:any): Observable<any>{
    return this.httpClient.delete(this.API_SERVER + "delete/" + id);
  }
}
