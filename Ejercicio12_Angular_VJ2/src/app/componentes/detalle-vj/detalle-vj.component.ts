import { Component, Input, OnInit } from '@angular/core';
import { Videojuego } from 'src/app/datos/Videojuego';
import { ActivatedRoute } from '@angular/router';
import { Videojuegos } from 'src/app/datos/Videojuegos';

@Component({
  selector: 'app-detalle-vj',
  templateUrl: './detalle-vj.component.html',
  styleUrls: ['./detalle-vj.component.css']
})
export class DetalleVjComponent implements OnInit {

  videojuego: Videojuego;
  videojuegos: Videojuegos; 

  id: string | null;


  constructor(private router: ActivatedRoute) {
    this.videojuegos = new Videojuegos();
    this.id = this.router.snapshot.paramMap.get('id');

    for(let vj of this.videojuegos.videojuegos) {
      let idString: string = vj.id +"";
      if (idString == this.id) this.videojuego = vj;
    }
  }

  ngOnInit(): void {
  }

}
