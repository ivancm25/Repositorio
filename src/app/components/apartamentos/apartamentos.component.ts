import { Component, Input, OnInit, Output, EventEmitter } from '@angular/core';
import { FormBuilder, FormControl, FormGroup, Validators } from '@angular/forms';
import { ApartamentosService } from 'src/app/services/apartamentos/apartamentos.service';
import { ReservasService } from 'src/app/services/reservas/reservas.service';
import { HeaderComponent } from '../header/header.component';

@Component({
  selector: 'app-apartamentos',
  templateUrl: './apartamentos.component.html',
  styleUrls: ['./apartamentos.component.css']
})
export class ApartamentosComponent implements OnInit {
  public apartamentoForm: FormGroup;
  public reservaForm: FormGroup;
  public classReference = HeaderComponent;
  provinciaSeleccionada:any = "todas";
  apartamento: any;
  apartamentos: any;
  todosApartamentos: any;
  fechaEntrada: Date | null;
  fechaSalida: Date | null;
  reserva: any;
  reservas: any;
  verReserva: boolean = false;
  verFormulario: boolean = false;

  constructor(
    public fb: FormBuilder,
    public apartamentoService: ApartamentosService,
    public reservaService: ReservasService
  ) { }

  public ngOnInit() {

    this.apartamentoForm = this.fb.group({
      id : [''],
      nombre: ['', Validators.required],
      provincia: ['', Validators.required],
      direccion: ['', Validators.required],
      tlf: ['', Validators.required],
      precio: ['', Validators.required],
      huespedes: ['', Validators.required],
      mascotas: ['', Validators.required],
      fumadores: ['', Validators.required]
    });

    this.reservaForm = this.fb.group({
      id : [''],
      fechaEntrada: ['', Validators.required],
      fechaSalida: ['', Validators.required]
    });

    this.apartamentoService.getAllApartamentos().subscribe(resp => {
      this.apartamentos = resp;
      this.todosApartamentos = resp;
    },
      error => { console.error(error) }
    )
  }

  public guardarApartamento(): void {
    this.apartamentoService.saveApartamento(this.apartamentoForm.value).subscribe(resp=>{
      this.apartamentoForm.reset();
      this.apartamentos = this.apartamentos.filter((apartamento: { id: any; })=> resp.id != apartamento.id);
      this.apartamentos.push(resp);
    },
      error=>{ console.error(error) }
    )
  }

  public eliminar(apartamento:any) {
    this.apartamentoService.deleteApartamento(apartamento.id).subscribe(resp=>{
      if (resp === true) {
        this.apartamentos.pop(apartamento);
      }
      this.apartamentoForm.reset();
    },
      error=>{ console.error(error) }
    )
  }

  public editar(apartamento:any) {
    this.apartamentoForm.setValue({
      id : apartamento.id,
      nombre: apartamento.nombre,
      provincia: apartamento.provincia,
      direccion: apartamento.direccion,
      tlf: apartamento.tlf,
      precio: apartamento.precio,
      huespedes: apartamento.huespedes,
      mascotas: apartamento.mascotas,
      fumadores: apartamento.fumadores
    })
  }

  public estaLogeado() {
    return this.classReference.logeado;
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

  public seleccionarApartamento(apartamento:any) {
    this.apartamento = apartamento;
  }

  public reservarApartamento(apartamento:any, fecha1:any, fecha2:any) {
    let fechaActual: Date = new Date();
    console.log(this.classReference.usuarioRegistrado);
    console.log(apartamento);
    this.reserva.apartamento = apartamento;
    this.reserva.fechaRealizada = fechaActual;
    this.reserva.fechaReservaEntrada = fecha1;
    this.reserva.fechaReservaSalida = fecha2;
    this.reserva.usuario = this.classReference.usuarioRegistrado;
    console.log(this.reserva);
    this.reservaService.saveReserva(this.reserva).subscribe(resp=>{
      this.reservas = this.reservas.filter((reserva: { id: any; })=> resp.id != reserva.id);
      this.reservas.push(resp);
    },
      error=>{ console.error(error) }
    );
  }


  public actualizarApartamentos() {
    this.apartamentoService.getAllApartamentos().subscribe(resp => {
      this.todosApartamentos = resp;
    },
      error => { console.error(error) }
    );
    this.apartamentos = this.todosApartamentos;

    if (this.provinciaSeleccionada != "todas") {
      this.apartamentos = this.apartamentos.filter((apartamento:any) => {
        return apartamento.provincia == this.provinciaSeleccionada;
      })
    } else {
      this.apartamentoService.getAllApartamentos().subscribe(resp => {
        this.todosApartamentos = resp;
        this.apartamentos = resp;
      },
        error => { console.error(error) }
      )
    }
  }

  public removeFromArr ( arr:any, item:any ) {
    var i = arr.indexOf( item );
    arr.splice( i, 1 );
  }
}


export class Reserva {
  constructor(
      public usuario: any,
      public fechaRealizada: any,
      public fechaReservaEntrada: any,
      public fechaReservaSalida: any,
      public precio: any,
      public apartamento: any
  ) { }
}

