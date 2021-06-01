import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { AlojamientosComponent } from './components/alojamientos/alojamientos.component';
import { HomeComponent } from './components/home/home.component';
import { VuelosComponent } from './components/vuelos/vuelos.component';
import { ReactiveFormsModule, FormsModule } from '@angular/forms';
import { HttpClientModule} from '@angular/common/http'

const routes: Routes = [
  { path: '', redirectTo: 'home', pathMatch: 'full'},
  { path: 'home', component: HomeComponent },
  { path: 'alojamientos', component: AlojamientosComponent, children: [
    { path: '', component: AlojamientosComponent },
    //{ path: 'alojamiento', component: AlojamientoDetalleComponent },
  ] },
  { path: 'vuelos', component: VuelosComponent },
  { path: '**', redirectTo: 'home', pathMatch: 'full'}
];

@NgModule({
  imports: [RouterModule.forRoot(routes), ReactiveFormsModule, FormsModule],
  exports: [RouterModule]
})
export class AppRoutingModule { }
