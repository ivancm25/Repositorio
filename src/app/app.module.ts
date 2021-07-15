import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

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
    HotelesComponent
  ],
  imports: [
    BrowserModule,
    FormsModule,
    ReactiveFormsModule,
    AppRoutingModule,
    MatNativeDateModule,
    BrowserAnimationsModule,
    MatDatepickerModule,
    MatFormFieldModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
