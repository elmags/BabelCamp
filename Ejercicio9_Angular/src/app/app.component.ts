import { Component } from '@angular/core';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  title = 'Ejercicio9_Angular';
  
  universidad: string = "Univerdidad Politécnica de Madrid";
  carrera: string = "Ingeniería Informática";
}
