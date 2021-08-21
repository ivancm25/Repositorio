import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormControl, FormGroup, Validators } from '@angular/forms';
import { HabitacionesService } from 'src/app/services/habitaciones/habitaciones.service';
import { HotelesService } from 'src/app/services/hoteles/hoteles.service';

@Component({
  selector: 'app-habitaciones',
  templateUrl: './habitaciones.component.html',
  styleUrls: ['./habitaciones.component.css']
})
export class HabitacionesComponent implements OnInit {

  habitacionForm: FormGroup;
  habitaciones: any;
  hoteles: any;

  constructor(
    public fb: FormBuilder,
    public habitacionService: HabitacionesService,
    public hotelService: HotelesService
  ) { }

  public ngOnInit() {

    this.habitacionForm = this.fb.group({
      id : [''],
      nombre: ['', Validators.required],
      hotel: ['', Validators.required],
      precio: ['', Validators.required],
      huespedes: ['', Validators.required]
    });

    this.hotelService.getAllHoteles().subscribe(resp => {
      this.hoteles = resp;
    },
      error => { console.error(error) }
    )

    this.habitacionService.getAllHabitaciones().subscribe(resp => {
      this.habitaciones = resp;
    },
      error => { console.error(error) }
    )
  }

  guardarHabitacion(): void {
    console.log(this.habitacionForm.value);
    this.habitacionService.saveHabitacion(this.habitacionForm.value).subscribe(resp=>{
      this.habitacionForm.reset();
      this.habitaciones = this.habitaciones.filter((habitacion: { id: any; })=> resp.id != habitacion.id);
      this.habitaciones.push(resp);
    },
      error=>{ console.error(error) }
    )
  }

  public eliminar(habitacion:any) {
    this.habitacionService.deleteHabitacion(habitacion.id).subscribe(resp=>{
      if (resp === true) {
        this.habitaciones.pop(habitacion);
      }
      this.habitacionForm.reset();
    },
      error=>{ console.error(error) }
    )
  }

  public editar(habitacion:any) {
    this.habitacionForm.setValue({
      id : habitacion.id,
      nombre: habitacion.nombre,
      hotel: habitacion.hotel,
      precio: habitacion.precio,
      huespedes: habitacion.huespedes
    })
  }

}
