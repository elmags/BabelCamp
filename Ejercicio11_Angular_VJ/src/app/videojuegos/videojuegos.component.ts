import { Component, OnInit } from '@angular/core';
import { Videojuego } from '../datos/videojuego';

@Component({
  selector: 'app-videojuegos',
  templateUrl: './videojuegos.component.html',
  styleUrls: ['./videojuegos.component.css']
})
export class VideojuegosComponent implements OnInit {

  videojuegos: Videojuego[] = [];

  constructor() {
    let videojuego1: Videojuego = new Videojuego("Mario Kart", "Nintendo", 8);
    let videojuego2: Videojuego = new Videojuego("Fornite", "Epic Games", 7);
    this.videojuegos.push(videojuego1);
    this.videojuegos.push(videojuego2);
   }

  ngOnInit(): void {
  }

  public alta() {

  }

  public allClear() {

  }
}
