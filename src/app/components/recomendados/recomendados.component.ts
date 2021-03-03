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
    var ourense = new Alojamiento("Ourense", "Ourense, Galicia", "Alojamiento en el centro", 100, "../../../assets/img/destinos/ourense.jpg");
    var sanxenxo = new Alojamiento("Sanxenxo", "Pontevedra, Galicia", "Alojamiento a 1ª línea de playa", 200, "../../../assets/img/destinos/sanxenxo.jpg");
    var coruna = new Alojamiento("A Coruña", "A Coruña, Galicia", "Alojamiento en la ciudad", 100, "../../../assets/img/destinos/coruna.jpg");
    var santiago = new Alojamiento("Santiago de Compostela", "A Coruña, Galicia", "Alojamiento en la ciudad", 100, "../../../assets/img/destinos/santiago.jpg");

    this.recomendados.push(ourense);
    this.recomendados.push(sanxenxo);
    this.recomendados.push(coruna);
    this.recomendados.push(santiago);
  }

  constructor() { }

}
