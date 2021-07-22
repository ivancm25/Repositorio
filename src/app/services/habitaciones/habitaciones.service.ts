import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class HabitacionesService {

  private API_SERVER = "http://localhost:8080/habitaciones/";

  constructor(private httpClient: HttpClient) { }

  public getAllHabitaciones(): Observable<any>{
    return this.httpClient.get(this.API_SERVER);
  }
}
