import { Component, Input, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Videojuegos } from 'src/app/datos/Videojuegos';
import { Videojuego } from '../../datos/Videojuego';

@Component({
  selector: 'app-listado-vj',
  templateUrl: './listado-vj.component.html',
  styleUrls: ['./listado-vj.component.css']
})
export class ListadoVJComponent implements OnInit {

  videojuego: Videojuego | null;
  videojuegos: Videojuegos;

  errorTitulo: boolean = false;
  errorCompania: boolean = false;
  errorVal: boolean = false;
  errorValNum: boolean = false;

  _modificar: boolean = false;
  _guardar: boolean = false;

  // Datos del formulario
  id: number = 0;
  titulo: string = "";
  compania: string = "";
  val_media: number = 0;
  imageSRC: string = "";

  constructor(private router: Router) {
    this.videojuego = null;
    this.videojuegos = new Videojuegos();
  }

  ngOnInit(): void {
  }

  public detalles(videojuego: Videojuego): void {
    this.router.navigate(['/detalle-vj', videojuego.id])
  }
}
