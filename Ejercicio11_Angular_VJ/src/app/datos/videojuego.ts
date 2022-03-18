export class Videojuego {
    private _id: number;
    private _titulo: string;
    private _compañia: string;
    private _val_media: number;

    // private _idInicial = 1;

    constructor(_titulo: string, _compañia: string, _val_media: number) {
        this._id = 0;
        this._titulo = _titulo;
        this._compañia = _compañia;
        this._val_media = _val_media;
    }
}