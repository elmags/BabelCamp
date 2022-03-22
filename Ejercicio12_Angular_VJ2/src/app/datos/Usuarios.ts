import { Usuario } from '../datos/Usuario';

export class Usuarios {
	
	private _usuarios: Array<Usuario>;

	constructor() {
		let u1: Usuario = new Usuario("username1", "passwd1");
		let u2: Usuario = new Usuario("username2", "passwd2");
		let u3: Usuario = new Usuario("username3", "passwd3");
		
		this._usuarios = [];
		this._usuarios.push(u1, u2, u3);
	}

	public get usuarios(): Array<Usuario> {
        return this._usuarios;
    }

    public set usuarios(usuarios: Array<Usuario>) {
        this._usuarios = usuarios;
    }	
}
