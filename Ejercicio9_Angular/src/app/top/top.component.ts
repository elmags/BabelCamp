import { Component, OnInit } from '@angular/core';
import { AppComponent } from '../app.component';

@Component({
  selector: 'app-top',
  templateUrl: './top.component.html',
  styleUrls: ['./top.component.css']
  
})
export class TopComponent extends AppComponent implements OnInit {

  img: string = "assets/cuadrado.png";

  nombre: string = "ELMA";
  apellido1: string = "GALLARDO";
  apellido2: string = "SOTOS";
  nombre_completo: string = this.nombre + " " + this.apellido1 + " " + this.apellido2;

  constructor() {
    super();
   }

  ngOnInit(): void {
  }
}
