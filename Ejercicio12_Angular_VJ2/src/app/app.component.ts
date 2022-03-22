import { Component } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  title = 'Ejercicio12_Angular_VJ2';
  
  constructor(private router: ActivatedRoute) {
    console.log(this.router.snapshot)
  }
}
