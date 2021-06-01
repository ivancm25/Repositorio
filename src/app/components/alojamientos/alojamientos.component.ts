import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormControl, FormGroup } from '@angular/forms';

@Component({
  selector: 'app-alojamientos',
  templateUrl: './alojamientos.component.html',
  styleUrls: ['./alojamientos.component.css']
})
export class AlojamientosComponent implements OnInit {
  public formulario: FormGroup;

  loading = true;

  constructor( private formBuilder: FormBuilder ) { }

  public ngOnInit() {
    this.buildForm();
    this.loading = false;
  }
  private buildForm(){
    this.formulario = this.formBuilder.group({
      habitaciones: 1,
      adultos: 1,
      ninos: 1
    });
  }
}
