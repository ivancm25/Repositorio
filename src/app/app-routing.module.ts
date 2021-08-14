import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { ApartamentosComponent } from './components/apartamentos/apartamentos.component';
import { HomeComponent } from './components/home/home.component';
import { CasasRuralesComponent } from './components/casas-rurales/casas-rurales.component';
import { ReactiveFormsModule, FormsModule } from '@angular/forms';
import { HttpClientModule} from '@angular/common/http'
import { AlojamientoDetalleComponent } from './components/alojamiento-detalle/alojamiento-detalle.component';
import { HotelesComponent } from './components/hoteles/hoteles.component';
import { HabitacionesComponent } from './components/habitaciones/habitaciones.component';

const routes: Routes = [
  { path: '', redirectTo: 'home', pathMatch: 'full'},
  { path: 'home', component: HomeComponent },
  { path: 'apartamentos', component: ApartamentosComponent, children: [
    { path: '', component: ApartamentosComponent },
    { path: 'apartamento', component: AlojamientoDetalleComponent },
  ] },
  { path: 'casas-rurales', component: CasasRuralesComponent },
  { path: 'hoteles', component: HotelesComponent },
  { path: 'habitaciones', component: HabitacionesComponent },
  { path: '**', redirectTo: 'home', pathMatch: 'full'}
];

@NgModule({
  imports: [RouterModule.forRoot(routes), ReactiveFormsModule, FormsModule],
  exports: [RouterModule]
})
export class AppRoutingModule { }
