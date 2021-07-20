import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormControl, FormGroup, Validators } from '@angular/forms';
import { ApartamentosService } from 'src/app/services/apartamentos/apartamentos.service';

@Component({
  selector: 'app-apartamentos',
  templateUrl: './apartamentos.component.html',
  styleUrls: ['./apartamentos.component.css']
})
export class ApartamentosComponent implements OnInit {
  public apartamentoForm: FormGroup;

  apartamentos: any;

  constructor(
    public fb: FormBuilder,
    public apartamentoService: ApartamentosService
  ) { }

  public ngOnInit() {
    this.buildForm();

    this.apartamentoService.getAllApartamentos().subscribe(resp=>{
      this.apartamentos = resp;
      console.log(resp);
    },
      error => { console.error(error) }
    )
  }

  private buildForm(){
    this.apartamentoForm = this.fb.group({
      provincia : ['', Validators.required],
      huespedes : ['', Validators.required],
      precio : ['', Validators.required],
      mascotas : ['', Validators.required],
      fumadores : ['', Validators.required]
    });
  }

  guardar():void {

  }
}
