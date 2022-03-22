export class Videojuego {
    private _id: number;
    private _titulo: string;
    private _compania: string;
    private _val_media: number;
    private _image: HTMLImageElement;

    // private _idInicial = 1;

    constructor(_titulo: string, _compania: string, _val_media: number, _image: HTMLImageElement) {
        this._id = 0;
        this._titulo = _titulo;
        this._compania = _compania;
        this._val_media = _val_media;
        this._image = _image;
    }

    public get id(): number {
        return this._id;
    }
    public set id(id: number) {
        this._id = id;
    }

    public get titulo(): string {
        return this._titulo;
    }
    public set titulo(titulo: string) {
        this._titulo = titulo;
    }

    public get compania(): string {
        return this._compania;
    }
   
    public set compania(compania: string) {
        this._compania = compania;
    }
   
    public get val_media(): number {
        return this._val_media;
    }
   
    public set val_media(val_media: number) {
        this._val_media = val_media;
    }
   
}