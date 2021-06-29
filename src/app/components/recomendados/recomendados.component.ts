import { Component, OnInit } from '@angular/core';
import { Alojamiento } from '../../models/alojamiento';

@Component({
  selector: 'app-recomendados',
  templateUrl: './recomendados.component.html',
  styleUrls: ['./recomendados.component.css']
})
export class RecomendadosComponent implements OnInit {

  recomendados: Array<Alojamiento> = new Array<Alojamiento>();

  ngOnInit(): void {
    var ourense = new Alojamiento("000000001", "Ourense", "Ourense, Galicia", "Alojamiento en el centro", 100, "../../../assets/img/destinos/ourense.jpg");
    var sanxenxo = new Alojamiento("000000002", "Sanxenxo", "Pontevedra, Galicia", "Alojamiento a 1ª línea de playa", 200, "../../../assets/img/destinos/sanxenxo.jpg");
    var coruna = new Alojamiento("000000003", "A Coruña", "A Coruña, Galicia", "Alojamiento en la ciudad", 100, "../../../assets/img/destinos/coruna.jpg");
    var santiago = new Alojamiento("000000004", "Santiago de Compostela", "A Coruña, Galicia", "Alojamiento en la ciudad", 100, "../../../assets/img/destinos/santiago.jpg");

    this.recomendados.push(ourense);
    this.recomendados.push(sanxenxo);
    this.recomendados.push(coruna);
    this.recomendados.push(santiago);
  }

  constructor() { }

}
