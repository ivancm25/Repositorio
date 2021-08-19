import { Component, OnInit } from '@angular/core';
import { HeaderComponent } from '../header/header.component';
import { ApartamentosService } from 'src/app/services/apartamentos/apartamentos.service';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent implements OnInit {

  apartamentos: any;
  public classReference = HeaderComponent;

  constructor(
    public apartamentoService: ApartamentosService
  ) { }

  ngOnInit(): void {
    this.apartamentoService.getAllApartamentos().subscribe(resp => {
      this.apartamentos = resp;
    },
      error => { console.error(error) }
    )
  }

}
