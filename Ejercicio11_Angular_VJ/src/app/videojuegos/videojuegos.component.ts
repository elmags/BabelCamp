import { NUMBER_TYPE } from '@angular/compiler/src/output/output_ast';
import { Component, OnInit } from '@angular/core';
import { Videojuego } from '../datos/videojuego';

@Component({
  selector: 'app-videojuegos',
  templateUrl: './videojuegos.component.html',
  styleUrls: ['./videojuegos.component.css']
})
export class VideojuegosComponent implements OnInit {

  videojuego: Videojuego | null;
  videojuegos: Videojuego[] = [];

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

  constructor() {
    let id_aux: number = this.videojuegos.length;
    let videojuego1: Videojuego = new Videojuego("Mario Kart", "Nintendo", 8);
    let videojuego2: Videojuego = new Videojuego("Fornite", "Epic Games", 7);
    
    videojuego1.id = id_aux;
    videojuego2.id = ++id_aux;

    this.videojuegos.push(videojuego1);
    this.videojuegos.push(videojuego2);

    this.videojuego = null;
  }

  ngOnInit(): void {
  }

  public alta() {
    if(!this.mostrarError()) {
      let id_aux: number = this.videojuegos.length;
      this.videojuego = new Videojuego(this.titulo, this.compania, this.val_media);
      this.videojuego.id = id_aux;
      this.videojuegos.push(this.videojuego);
      this.allClear();
    }
  }

  public modificar_aux() {
    this._modificar = true;
  }

  public modificar(vj: Videojuego) {
    this._guardar = true;

    this.id = vj.id;
    this.titulo = vj.titulo;
    this.compania = vj.compania;
    this.val_media = vj.val_media;
  }

  public guardar() {
    let encontrado: boolean = false;
    if(!this.mostrarError()) {
      for (let i = 0; i < this.videojuegos.length && !encontrado; i++) {
        if (this.videojuegos[i].id == this.id) {
          this.videojuegos[i].titulo = this.titulo;
          this.videojuegos[i].compania = this.compania;
          this.videojuegos[i].val_media = this.val_media;
          encontrado = true;
        }
      }
    }
    this.allClear();
  }

  public baja(vj: Videojuego) {
    let eliminado: boolean = false;
    for (let i = 0; i < this.videojuegos.length && !eliminado; i++) {
      if (this.videojuegos[i].id == vj.id) {
        this.videojuegos.splice(i, 1);
        eliminado = true;
      }
    }
    this.allClear();
    console.log(document.getElementById("iconoEliminar"))
  }

  public allClear() {
    this.id = 0;
    this.titulo = "";
    this.compania = "";
    this.val_media = 0;
    
    this.errorTitulo = false;
    this.errorCompania = false;
    this.errorVal = false;

    this._modificar = false;
    this._guardar = false;
  }

  public mostrarError(): boolean {
    let res: boolean = false;
    if (this.titulo == "") {
      this.errorTitulo = true;
      res = true; 
    }
    if (this.compania == "") {
      this.errorCompania = true;
      res = true;
    }
    return res;
  }
}
