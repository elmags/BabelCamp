import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-cabecera',
  templateUrl: './cabecera.component.html',
  styleUrls: ['./cabecera.component.css']
})
export class CabeceraComponent implements OnInit {

  username: String | null;
  comp: number;
 
  constructor(private router: Router) {
    this.username = sessionStorage.getItem("username");
    if ((this.router.url).includes("contacto")) this.comp = 1;
    else if ((this.router.url).includes("inf")) this.comp = 2;
    else if ((this.router.url).includes("listado")) this.comp = 3;
    else if ((this.router.url).includes("detalle")) this.comp = 4;
  }

  ngOnInit(): void {
  }

  public atras() {
    this.router.navigate(['/listado-vj', this.username]);
  }

  public login() {
    sessionStorage.clear();
    this.router.navigate(['/login']);
  }
}
