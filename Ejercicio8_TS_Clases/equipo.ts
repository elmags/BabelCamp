class Jugador {

    private _idJ: number;
    private _nombre: string;
    private _edad: number;
    private _pais: string;
    private _historial: Historial;

    constructor(_nombre: string, _edad: number, _pais: string, _historial: Historial, _idJ?: number) {
        this._nombre = _nombre;
        this._edad = _edad;
        this._pais = _pais;
        this._historial = _historial;

        if (_idJ != null) {
            this._idJ = _idJ;
            _historial.idH = _idJ;
        }
        else {
            this._idJ = _historial.idH;
        }
    }

    public get idJ(): number {
        return this._idJ;
    }
    public set idJ(_idJ: number) {
        this._idJ = _idJ;
    }

    public get nombre(): string {
        return this._nombre;
    }

    public set nombre(_nombre: string) {
        this._nombre = _nombre;
    }

    public get edad(): number {
        return this._edad;
    }

    public set edad(_edad: number) {
        this._edad = _edad;
    }

    public get pais(): string {
        return this._pais;
    }

    public set pais(_pais: string) {
        this._pais = _pais;
    }

    public get historial(): Historial {
        return this._historial;
    }

    public set historial(_historial: Historial) {
        this._historial = _historial;
    }
}

class Equipo {

    private _idE: number;
    private _nombre: string;
    private _fecha_fundacion: Date;
    private _jugadores: Array<Jugador> = new Array();

    constructor(_idE: number, _nombre: string, _fecha_fundacion: Date, _jugadores: Array<Jugador>) {
        this._idE = _idE;
        this._nombre = _nombre;
        this._fecha_fundacion = _fecha_fundacion;
        this._jugadores = _jugadores;
    }

    public get idE(): number {
        return this._idE;
    }

    public set idE(_idE: number) {
        this._idE = _idE;
    }

    public get nombre(): string {
        return this._nombre;
    }
    public set nombre(_nombre: string) {
        this._nombre = _nombre;
    }

    public get fecha_fundacion(): Date {
        return this._fecha_fundacion;
    }

    public set fecha_fundacion(_fecha_fundacion: Date) {
        this._fecha_fundacion = _fecha_fundacion;
    }

    public get jugadores(): Array<Jugador> {
        return this._jugadores;
    }
    public set jugadores(_jugadores: Array<Jugador>) {
        this._jugadores = _jugadores;
    }
}

class Historial  {

    private _idH: number;
    private _goles_marcados: number;
    private _tarj_amarillas: number;
    private _tarj_rojas: number;

    constructor(_goles_marcados: number, _tarj_amarillas: number, _tarj_rojas: number, _id?: number) {
        this._goles_marcados = _goles_marcados;
        this._tarj_amarillas = _tarj_amarillas;
        this._tarj_rojas = _tarj_rojas;
        if (_id != null) this._idH = _id;
    }

    public get idH(): number {
        return this._idH;
    }
    public set idH(_idH: number) {
        this._idH = _idH;
    }
    
    public get goles_marcados(): number {
        return this._goles_marcados;
    }
    public set goles_marcados(_goles_marcados: number) {
        this._goles_marcados = _goles_marcados;
    }

    public get tarj_amarillas(): number {
        return this._tarj_amarillas;
    }
    public set tarj_amarillas(_tarj_amarillas: number) {
        this._tarj_amarillas = _tarj_amarillas;
    }

    public get tarj_rojas(): number {
        return this._tarj_rojas;
    }
    public set tarj_rojas(_tarj_rojas: number) {
        this._tarj_rojas = _tarj_rojas;
    }
}

// Creación de los historiales de los jugadores
let historial1 = new Historial(5, 1, 1, 1);
let historial2 = new Historial(20, 3, 0, 2);
let historial3 = new Historial(2, 5, 0);
let historial4 = new Historial(4, 1, 0, 4);
let historial5 = new Historial(8, 0, 0);

// Creación de los jugadores
let jugador1: Jugador = new Jugador("Hugo", 21, "España", historial1);
let jugador2: Jugador = new Jugador("Lucas", 24, "Argentina", historial2);
let jugador3: Jugador = new Jugador("Daniel", 23, "Alemania", historial3, 3);
let jugador4: Jugador = new Jugador("David", 28, "Francia", historial4);
let jugador5: Jugador = new Jugador("Mario", 29, "España", historial5, 5);

// Variables necesarias para crear el equipo
let _jugadores: Array<Jugador> = [jugador1, jugador2, jugador3, jugador4, jugador5];
let _fecha: Date = new Date("2022-03-16");

// Creación del equipo
let equipo = new Equipo(1, "Equipo1", _fecha, _jugadores);

// Mostrar el equipo en la consola
console.log("\n-------------- EQUIPO --------------")
console.log("ID:                 ", equipo.idE)
console.log("Nombre:             ", equipo.nombre)
console.log("Fecha de fundación: ", equipo.fecha_fundacion)

console.log("Jugadores:     ")
for(let i = 0; i < equipo.jugadores.length; i++) {
    console.log("          | ID:     ", equipo.jugadores[i].idJ)
    console.log("          | Nombre: ", equipo.jugadores[i].nombre)
    console.log("          | Edad:   ", equipo.jugadores[i].edad)
    console.log("          | País:   ", equipo.jugadores[i].pais)

    console.log("          | Historial: ")
    console.log("                      - ID:                           ", equipo.jugadores[i].historial.idH)
    console.log("                      - Número de goles:              ", equipo.jugadores[i].historial.goles_marcados)
    console.log("                      - Número de tarjetas amarillas: ", equipo.jugadores[i].historial.tarj_amarillas)
    console.log("                      - Número de tarjetas rojas:     ", equipo.jugadores[i].historial.tarj_rojas)
    console.log("\n")
}