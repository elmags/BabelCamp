import { Videojuego } from '../datos/Videojuego';

export class Videojuegos {
	
	private _videojuegos: Array<Videojuego>;

	constructor() {
        this._videojuegos = [];
        let id_aux: number = this._videojuegos.length;

		let v1: Videojuego = new Videojuego("Mario Kart", "Nintendo", 8, "assets/mk.webp");
		v1.id = id_aux;
        this._videojuegos.push(v1);
        
        v1 = new Videojuego("Fornite", "Epic Games", 7, "assets/fortnite.jpg");
		v1.id = ++id_aux;
        this._videojuegos.push(v1);
        
        v1 = new Videojuego("GTA", "Rockstar Games", 7, "assets/gta.png");
		v1.id = ++id_aux;
        this._videojuegos.push(v1);
	}

	public get videojuegos(): Array<Videojuego> {
        return this._videojuegos;
    }

    public set videojuegos(_videojuegos: Array<Videojuego>) {
        this._videojuegos = _videojuegos;
    }	
}
