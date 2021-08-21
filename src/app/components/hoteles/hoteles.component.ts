import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormControl, FormGroup, Validators } from '@angular/forms';
import { HotelesService } from 'src/app/services/hoteles/hoteles.service';
import { HabitacionesService } from 'src/app/services/habitaciones/habitaciones.service';
import { HeaderComponent } from '../header/header.component';
import { analyzeAndValidateNgModules } from '@angular/compiler';

@Component({
  selector: 'app-hoteles',
  templateUrl: './hoteles.component.html',
  styleUrls: ['./hoteles.component.css']
})
export class HotelesComponent implements OnInit {
  public hotelForm: FormGroup;
  public classReference = HeaderComponent;
  hoteles: any;
  todosHoteles: any;
  habitaciones: any;
  habitacionesMostrando: any;
  verFormulario: boolean = false;
  verHabitaciones: boolean = false;
  provinciaSeleccionada:any = "todas";

  constructor(
    public fb: FormBuilder,
    public hotelService: HotelesService,
    public habitacionService: HabitacionesService
  ) { }

  public ngOnInit() {

    this.hotelForm = this.fb.group({
      id : [''],
      nombre: ['', Validators.required],
      provincia: ['', Validators.required],
      direccion: ['', Validators.required],
      tlf: ['', Validators.required],
      habitaciones: ['', Validators.required],
      piscina: ['', Validators.required],
      fumadores: ['', Validators.required]
    });

    this.hotelService.getAllHoteles().subscribe(resp => {
      this.hoteles = resp;
      this.todosHoteles = resp;
    },
      error => { console.error(error) }
    )

    this.habitacionService.getAllHabitaciones().subscribe(resp => {
      this.habitaciones = resp;
    },
      error => { console.error(error) }
    )
  }

  public guardarHotel(): void {
    this.hotelService.saveHotel(this.hotelForm.value).subscribe(resp=>{
      this.hotelForm.reset();
      this.hoteles = this.hoteles.filter((hotel: { id: any; })=> resp.id != hotel.id);
      this.hoteles.push(resp);
    },
      error=>{ console.error(error) }
    )
  }

  public eliminar(hotel:any) {
    this.hotelService.deleteHotel(hotel.id).subscribe(resp=>{
      if (resp === true) {
        this.hoteles.pop(hotel);
      }
      this.hotelForm.reset();
    },
      error=>{ console.error(error) }
    )
  }

  public editar(hotel:any) {
    this.hotelForm.setValue({
      id : hotel.id,
      nombre: hotel.nombre,
      provincia: hotel.provincia,
      direccion: hotel.direccion,
      tlf: hotel.tlf,
      habitaciones: hotel.habitaciones,
      piscina: hotel.piscina,
      fumadores: hotel.fumadores
    })
  }

  public cargarHabitaciones(hotel:any) {
    this.verHabitaciones = true;
    console.log(this.habitaciones);
    for(let habitacion of this.habitaciones) {
      console.log(habitacion.hotel);
      if (habitacion.hotel == hotel) {
        this.habitacionesMostrando.push(habitacion);
      }
    }
    console.log(this.habitacionesMostrando);
  }


  public actualizarHoteles() {
    this.hotelService.getAllHoteles().subscribe(resp => {
      this.todosHoteles = resp;
    },
      error => { console.error(error) }
    );
    this.hoteles = this.todosHoteles;

    if (this.provinciaSeleccionada != "todas") {
      this.hoteles = this.hoteles.filter((hotel1:any) => {
        return hotel1.provincia == this.provinciaSeleccionada;
      })
    } else {
      this.hotelService.getAllHoteles().subscribe(resp => {
        this.hoteles = resp;
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
