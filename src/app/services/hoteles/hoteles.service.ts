import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class HotelesService {

  private API_SERVER = "http://localhost:8080/hoteles/";

  constructor(private httpClient: HttpClient) { }

  public getAllHoteles(): Observable<any>{
    return this.httpClient.get(this.API_SERVER);
  }
}
