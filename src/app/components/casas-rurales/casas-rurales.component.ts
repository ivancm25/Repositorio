import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormControl, FormGroup, Validators } from '@angular/forms';
import { CasasRuralesService } from 'src/app/services/casas-rurales/casas-rurales.service';
import { HeaderComponent } from '../header/header.component';

@Component({
  selector: 'app-casas-rurales',
  templateUrl: './casas-rurales.component.html',
  styleUrls: ['./casas-rurales.component.css']
})
export class CasasRuralesComponent implements OnInit {

  public casaRuralForm: FormGroup;
  public classReference = HeaderComponent;
  casasRurales: any;
  todasCasas: any;
  verFormulario: boolean = false;
  provinciaSeleccionada:any = "todas";

  constructor(
    public fb: FormBuilder,
    public casaRuralService: CasasRuralesService
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
}
