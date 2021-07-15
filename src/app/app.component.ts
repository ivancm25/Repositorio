import { Component, OnInit } from '@angular/core';
import { ApartamentosService } from './services/apartamentos/apartamentos.service';
import { CasasRuralesService } from './services/casas-rurales/casas-rurales.service';
import { HabitacionesService } from './services/habitaciones/habitaciones.service';
import { HotelesService } from './services/hoteles/hoteles.service';
import { ReservasService } from './services/reservas/reservas.service';
import { UsuariosService } from './services/usuarios/usuarios.service';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})

export class AppComponent implements OnInit {
  ngOnInit() {

  }

  title = 'TallerApp';

  constructor(
    public apartamentosService: ApartamentosService,
    public casasRuralesService: CasasRuralesService,
    public habitacionesService: HabitacionesService,
    public hotelesService: HotelesService,
    public reservasService: ReservasService,
    public usuariosService: UsuariosService,
  ) {

  }
}
