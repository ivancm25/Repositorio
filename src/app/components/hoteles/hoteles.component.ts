import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormControl, FormGroup, Validators } from '@angular/forms';
import { HotelesService } from 'src/app/services/hoteles/hoteles.service';
import { HeaderComponent } from '../header/header.component';

@Component({
  selector: 'app-hoteles',
  templateUrl: './hoteles.component.html',
  styleUrls: ['./hoteles.component.css']
})
export class HotelesComponent implements OnInit {
  public hotelForm: FormGroup;
  public classReference = HeaderComponent;
  hoteles: any;
  verFormulario: boolean = false;

  constructor(
    public fb: FormBuilder,
    public hotelService: HotelesService
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
}
