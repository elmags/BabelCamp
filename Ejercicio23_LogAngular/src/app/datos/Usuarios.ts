import { Usuario } from '../datos/Usuario';

export class Usuarios {
	
	private _usuarios: Array<Usuario>;

	constructor() {
		this._usuarios = [];
		
		let u1: Usuario = new Usuario("username1", "passwd1");
		this._usuarios.push(u1);

		u1 = new Usuario("username2", "passwd2");
		this._usuarios.push(u1);

		u1 = new Usuario("username3", "passwd3");
		this._usuarios.push(u1);
	}

	public get usuarios(): Array<Usuario> {
        return this._usuarios;
    }

    public set usuarios(usuarios: Array<Usuario>) {
        this._usuarios = usuarios;
    }	
}
