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
import { FormsModule } from '@angular/forms';
import { HeaderComponent } from './components/header/header.component';
import { FooterComponent } from './components/footer/footer.component';
import { HomeComponent } from './components/home/home.component';
import { AlojamientosComponent } from './components/alojamientos/alojamientos.component';
import { VuelosComponent } from './components/vuelos/vuelos.component';


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
    AlojamientosComponent,
    VuelosComponent
  ],
  imports: [
    BrowserModule,
    FormsModule,
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
