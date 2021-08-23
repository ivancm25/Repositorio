import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { HttpClientModule } from '@angular/common/http';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { DatepickerComponent } from './components/datepicker/datepicker.component';

import {MatFormFieldModule} from '@angular/material/form-field';

import { MatNativeDateModule } from '@angular/material/core';
import {MatDatepickerModule} from '@angular/material/datepicker';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { SubmenuComponent } from './components/submenu/submenu.component';
import { OfertasComponent } from './components/ofertas/ofertas.component';
import { RecomendadosComponent } from './components/recomendados/recomendados.component';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { HeaderComponent } from './components/header/header.component';
import { FooterComponent } from './components/footer/footer.component';
import { HomeComponent } from './components/home/home.component';
import { ApartamentosComponent } from './components/apartamentos/apartamentos.component';
import { CasasRuralesComponent } from './components/casas-rurales/casas-rurales.component';
import { AlojamientoDetalleComponent } from './components/alojamiento-detalle/alojamiento-detalle.component';
import { HotelesComponent } from './components/hoteles/hoteles.component';
import { HabitacionesComponent } from './components/habitaciones/habitaciones.component';
import { PanelAdminComponent } from './components/panel-admin/panel-admin.component';
import {MatCardModule} from '@angular/material/card';
import { AcercaDeComponent } from './components/acerca-de/acerca-de.component';
import { ReservasComponent } from './components/reservas/reservas.component';


@NgModule({
  declarations: [
    AppComponent,
    DatepickerComponent,
    SubmenuComponent,
    OfertasComponent,
    RecomendadosComponent,
    HeaderComponent,
    FooterComponent,
    HomeComponent,
    ApartamentosComponent,
    CasasRuralesComponent,
    AlojamientoDetalleComponent,
    HotelesComponent,
    HabitacionesComponent,
    PanelAdminComponent,
    AcercaDeComponent,
    ReservasComponent
  ],
  imports: [
    BrowserModule,
    FormsModule,
    ReactiveFormsModule,
    AppRoutingModule,
    MatNativeDateModule,
    BrowserAnimationsModule,
    MatDatepickerModule,
    MatFormFieldModule,
    HttpClientModule,
    MatCardModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
