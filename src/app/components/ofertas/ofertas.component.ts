import { Component, OnInit } from '@angular/core';
import { Oferta } from '../../models/oferta';

@Component({
  selector: 'app-ofertas',
  templateUrl: './ofertas.component.html',
  styleUrls: ['./ofertas.component.css']
})

export class OfertasComponent implements OnInit {
  catalogoOfer: Array<Oferta> = new Array<Oferta>();

  ngOnInit(): void {
    var ourense = new Oferta("Ourense", "Ourense, Galicia", "Alojamiento en el centro", 100, "../../../assets/img/destinos/ourense.jpg");
    var sanxenxo = new Oferta("Sanxenxo", "Pontevedra, Galicia", "Alojamiento a 1ª línea de playa", 200, "../../../assets/img/destinos/sanxenxo.jpg");
    var coruna = new Oferta("A Coruña", "A Coruña, Galicia", "Alojamiento en la ciudad", 100, "../../../assets/img/destinos/coruna.jpg");
    var santiago = new Oferta("Santiago de Compostela", "A Coruña, Galicia", "Alojamiento en la ciudad", 100, "../../../assets/img/destinos/santiago.jpg");

    this.catalogoOfer.push(ourense);
    this.catalogoOfer.push(sanxenxo);
    this.catalogoOfer.push(coruna);
    this.catalogoOfer.push(santiago);
  }

  constructor() { }
}


