import { Component, OnInit } from '@angular/core';
import { ReservasService } from 'src/app/services/reservas/reservas.service';
import { HeaderComponent } from '../header/header.component';

@Component({
  selector: 'app-reservas',
  templateUrl: './reservas.component.html',
  styleUrls: ['./reservas.component.css']
})
export class ReservasComponent implements OnInit {

  public classReference = HeaderComponent;
  reservas: any;
  reservasUsuario: any;
  reserva: any;
  usuario: any;

  constructor(
    public reservaService: ReservasService
  ) { }

  ngOnInit(): void {
    this.reservaService.getAllReservas().subscribe(resp => {
      this.reservas = resp;
    },
      error => { console.error(error) }
    )

    this.cargarReservas(this.classReference.usuarioRegistrado);
  }

  cargarReservas(user: any) {
    for (let reserva of this.reservas) {
      if(reserva.usuario == user) {
        this.reservasUsuario.push(reserva);
      }
    }
  }

  public eliminarReserva(reserva:any) {
    this.reservaService.deleteReserva(reserva.id).subscribe(resp=>{
      if (resp === true) {
        this.reservas.pop(reserva);
      }
    },
      error=>{ console.error(error) }
    )
  }

  public esApartamento(reserva: any) {
    if (reserva.apartamento != null) {
      return true;
    } else {
      return false;
    }
  }

}
