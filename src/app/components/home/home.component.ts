import { Component, OnInit } from '@angular/core';
import { HeaderComponent } from '../header/header.component';
import { ApartamentosService } from 'src/app/services/apartamentos/apartamentos.service';
import { CasasRuralesService } from 'src/app/services/casas-rurales/casas-rurales.service';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent implements OnInit {

  apartamentos: any;
  casasRurales: any;
  public classReference = HeaderComponent;

  constructor(
    public apartamentoService: ApartamentosService,
    public casaRuralService: CasasRuralesService
  ) { }

  ngOnInit(): void {
    this.apartamentoService.getAllApartamentos().subscribe(resp => {
      this.apartamentos = resp;
    },
      error => { console.error(error) }
    );

    this.casaRuralService.getAllCasasRurales().subscribe(resp => {
      this.casasRurales = resp;
    },
      error => { console.error(error) }
    )
  }

}
