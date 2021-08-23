import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormControl, FormGroup, Validators } from '@angular/forms';
import { CasasRuralesService } from 'src/app/services/casas-rurales/casas-rurales.service';
import { HeaderComponent } from '../header/header.component';
import { ReservasService } from 'src/app/services/reservas/reservas.service';

@Component({
  selector: 'app-casas-rurales',
  templateUrl: './casas-rurales.component.html',
  styleUrls: ['./casas-rurales.component.css']
})
export class CasasRuralesComponent implements OnInit {

  public casaRuralForm: FormGroup;
  public classReference = HeaderComponent;
  public reservaForm: FormGroup;
  casasRurales: any;
  casaRural: any;
  todasCasas: any;
  verFormulario: boolean = false;
  provinciaSeleccionada:any = "todas";
  reserva: Reserva;
  reservas: any;
  verReserva: boolean = false;
  fechaEntrada: Date | null;
  fechaSalida: Date | null;

  constructor(
    public fb: FormBuilder,
    public casaRuralService: CasasRuralesService,
    public reservaService: ReservasService
  ) { }

  public ngOnInit() {

    this.casaRuralForm = this.fb.group({
      id : [''],
      nombre: ['', Validators.required],
      provincia: ['', Validators.required],
      direccion: ['', Validators.required],
      tlf: ['', Validators.required],
      precio: ['', Validators.required],
      huespedes: ['', Validators.required],
      piscina: ['', Validators.required],
      mascotas: ['', Validators.required],
      fumadores: ['', Validators.required]
    });

    this.reservaForm = this.fb.group({
      id : [''],
      fechaEntrada: ['', Validators.required],
      fechaSalida: ['', Validators.required]
    });

    this.casaRuralService.getAllCasasRurales().subscribe(resp => {
      this.casasRurales = resp;
      this.todasCasas = resp;
    },
      error => { console.error(error) }
    )
  }

  public guardarCasaRural(): void {
    this.casaRuralService.saveCasaRural(this.casaRuralForm.value).subscribe(resp=>{
      this.casaRuralForm.reset();
      this.casasRurales = this.casasRurales.filter((casaRural: { id: any; })=> resp.id != casaRural.id);
      this.casasRurales.push(resp);
    },
      error=>{ console.error(error) }
    )
  }

  public eliminar(casaRural:any) {
    this.casaRuralService.deleteCasaRural(casaRural.id).subscribe(resp=>{
      if (resp === true) {
        this.casasRurales.pop(casaRural);
      }
      this.casaRuralForm.reset();
    },
      error=>{ console.error(error) }
    )
  }

  public editar(casaRural:any) {
    this.casaRuralForm.setValue({
      id : casaRural.id,
      nombre: casaRural.nombre,
      provincia: casaRural.provincia,
      direccion: casaRural.direccion,
      tlf: casaRural.tlf,
      precio: casaRural.precio,
      huespedes: casaRural.huespedes,
      piscina: casaRural.piscina,
      mascotas: casaRural.mascotas,
      fumadores: casaRural.fumadores
    })
  }


  public actualizarCasas() {
    this.casaRuralService.getAllCasasRurales().subscribe(resp => {
      this.todasCasas = resp;
    },
      error => { console.error(error) }
    );
    this.casasRurales = this.todasCasas;

    if (this.provinciaSeleccionada != "todas") {
      this.casasRurales = this.casasRurales.filter((casa:any) => {
        return casa.provincia == this.provinciaSeleccionada;
      })
    } else {
      this.casaRuralService.getAllCasasRurales().subscribe(resp => {
        this.casasRurales = resp;
        this.todasCasas = resp;
      },
        error => { console.error(error) }
      )
    }
  }

  public removeFromArr ( arr:any, item:any ) {
    var i = arr.indexOf( item );
    arr.splice( i, 1 );
  }


  public contarDias(fecha1:any, fecha2:any) {
    var timestamp1 = new Date(fecha1).getTime();
    var timestamp2 = new Date(fecha2).getTime();
    var diff = timestamp2 - timestamp1;

    var seconds = diff / 1000;
    var minutes = seconds / 60;
    var hours = minutes / 60;
    var days = hours / 24;

    return days;
  }

  public comprobarFechas(fecha1:any, fecha2:any) {
    var timestamp1 = new Date(fecha1).getTime();
    var timestamp2 = new Date(fecha2).getTime();
    var diff = timestamp2 - timestamp1;

    if (diff > 0) {
      return true;
    } else {
      return false;
    }
  }

  public seleccionarCasa(apartamento:any) {
    this.casaRural = apartamento;
  }

  public reservarCasa(casa:any, fecha1:any, fecha2:any) {
    var options = { year: 'numeric', month: 'long', day: 'numeric' };
    let fechaActual: Date = new Date();
    let precio = this.contarDias(fecha1, fecha2) * casa.precio;
    fecha1 = fecha1.toLocaleDateString("es-ES", options);
    fecha2 = fecha2.toLocaleDateString("es-ES", options);
    this.reserva = new Reserva(this.classReference.usuarioRegistrado, fechaActual, fecha1, fecha2,
      precio, casa);
    this.reservaService.saveReserva(this.reserva).subscribe(
      error=>{ console.error(error) }
    );
  }
}

export class Reserva {
  constructor(
      public usuario: any,
      public fechaRealizada: any,
      public fechaReservaEntrada: any,
      public fechaReservaSalida: any,
      public precio: any,
      public casaRural: any
  ) {
    this.usuario = usuario;
    this.fechaRealizada = fechaRealizada;
    this.fechaReservaEntrada = fechaReservaEntrada;
    this.fechaReservaSalida = fechaReservaSalida;
    this.precio = precio;
    this.casaRural = casaRural;
   }
}
