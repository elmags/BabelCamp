import { Component, OnInit } from '@angular/core';
import { of } from 'rxjs';
import { AppComponent } from '../app.component';

@Component({
  selector: 'app-bottom',
  templateUrl: './bottom.component.html',
  styleUrls: ['./bottom.component.css']
})
export class BottomComponent extends AppComponent implements OnInit {

  iconoTel: string  = "assets/tel.png";
  iconoLocacion: string  = "assets/locacion.png";
  iconoEmail: string  = "assets/email.png";
  iconoLinkedin: string  = "assets/linkedin.png";

  telefono: string = "Número teléfono";
  direccion: string = "Calle Velázquez, 26"+ "\n"+ "Madrid, España";
  email: string = "e.gallardo@alumnos.upm.es";
  linkedin: string = "LinkedIn: /elmags";

  lenguajes_prog: string = "Lenguajes de programación: Java, C," +
    "C++, VHDL, Python, Prolog, MATLAB, XML, JSON.";
  bbdd: string = "Administración de BBDD: SQL, MySQL.";
  redes: string = "Administración de redes: Putty, Packet Tracer.";
  metodologias: string = "Metodologías de desarrollo de software: SCRUM, devops.";
  ofimatica: string = "Conocimientos de ofimática.";

  // carrera y universidad lo hereda de AppComponent
  universidad_mayus: string = this.universidad.toUpperCase();
  carrera_mayus: string = this.carrera.toUpperCase();

  constructor() {
    super();
  }

  ngOnInit(): void {
  }

}
