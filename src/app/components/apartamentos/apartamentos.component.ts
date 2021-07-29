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

    this.apartamentoForm = this.fb.group({
      id : [''],
      nombre: ['', Validators.required],
      provincia: ['', Validators.required],
      direccion: ['', Validators.required],
      tlf: ['', Validators.required],
      precio: ['', Validators.required],
      huespedes: ['', Validators.required]
    });

    this.apartamentoService.getAllApartamentos().subscribe(resp => {
      this.apartamentos = resp;
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
      huespedes: apartamento.huespedes
    })
  }
}
