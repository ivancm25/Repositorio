import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormControl, FormGroup } from '@angular/forms';

@Component({
  selector: 'app-casas-rurales',
  templateUrl: './casas-rurales.component.html',
  styleUrls: ['./casas-rurales.component.css']
})
export class CasasRuralesComponent implements OnInit {

  public formulario: FormGroup;

  loading = true;

  constructor( private formBuilder: FormBuilder ) { }

  public ngOnInit() {
    this.buildForm();
  }
  private buildForm(){
    this.formulario = this.formBuilder.group({
      habitaciones: 1,
      adultos: 1,
      ninos: 1
    });
    this.loading = false;
  }
}
