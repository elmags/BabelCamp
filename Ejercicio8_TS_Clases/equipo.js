class Jugador {
    constructor(_nombre, _edad, _pais, _historial, _idJ) {
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
    get idJ() {
        return this._idJ;
    }
    set idJ(_idJ) {
        this._idJ = _idJ;
    }
    get nombre() {
        return this._nombre;
    }
    set nombre(_nombre) {
        this._nombre = _nombre;
    }
    get edad() {
        return this._edad;
    }
    set edad(_edad) {
        this._edad = _edad;
    }
    get pais() {
        return this._pais;
    }
    set pais(_pais) {
        this._pais = _pais;
    }
    get historial() {
        return this._historial;
    }
    set historial(_historial) {
        this._historial = _historial;
    }
}
class Equipo {
    constructor(_idE, _nombre, _fecha_fundacion, _jugadores) {
        this._jugadores = new Array();
        this._idE = _idE;
        this._nombre = _nombre;
        this._fecha_fundacion = _fecha_fundacion;
        this._jugadores = _jugadores;
    }
    get idE() {
        return this._idE;
    }
    set idE(_idE) {
        this._idE = _idE;
    }
    get nombre() {
        return this._nombre;
    }
    set nombre(_nombre) {
        this._nombre = _nombre;
    }
    get fecha_fundacion() {
        return this._fecha_fundacion;
    }
    set fecha_fundacion(_fecha_fundacion) {
        this._fecha_fundacion = _fecha_fundacion;
    }
    get jugadores() {
        return this._jugadores;
    }
    set jugadores(_jugadores) {
        this._jugadores = _jugadores;
    }
}
class Historial {
    constructor(_goles_marcados, _tarj_amarillas, _tarj_rojas, _id) {
        this._goles_marcados = _goles_marcados;
        this._tarj_amarillas = _tarj_amarillas;
        this._tarj_rojas = _tarj_rojas;
        if (_id != null)
            this._idH = _id;
    }
    get idH() {
        return this._idH;
    }
    set idH(_idH) {
        this._idH = _idH;
    }
    get goles_marcados() {
        return this._goles_marcados;
    }
    set goles_marcados(_goles_marcados) {
        this._goles_marcados = _goles_marcados;
    }
    get tarj_amarillas() {
        return this._tarj_amarillas;
    }
    set tarj_amarillas(_tarj_amarillas) {
        this._tarj_amarillas = _tarj_amarillas;
    }
    get tarj_rojas() {
        return this._tarj_rojas;
    }
    set tarj_rojas(_tarj_rojas) {
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
let jugador1 = new Jugador("Hugo", 21, "España", historial1);
let jugador2 = new Jugador("Lucas", 24, "Argentina", historial2);
let jugador3 = new Jugador("Daniel", 23, "Alemania", historial3, 3);
let jugador4 = new Jugador("David", 28, "Francia", historial4);
let jugador5 = new Jugador("Mario", 29, "España", historial5, 5);
// Variables necesarias para crear el equipo
let _jugadores = [jugador1, jugador2, jugador3, jugador4, jugador5];
let _fecha = new Date("2022-03-16");
// Creación del equipo
let equipo = new Equipo(1, "Equipo1", _fecha, _jugadores);
// Mostrar el equipo en la consola
console.log("\n-------------- EQUIPO --------------");
console.log("ID:                 ", equipo.idE);
console.log("Nombre:             ", equipo.nombre);
console.log("Fecha de fundación: ", equipo.fecha_fundacion);
console.log("Jugadores:     ");
for (let i = 0; i < equipo.jugadores.length; i++) {
    console.log("          | ID:     ", equipo.jugadores[i].idJ);
    console.log("          | Nombre: ", equipo.jugadores[i].nombre);
    console.log("          | Edad:   ", equipo.jugadores[i].edad);
    console.log("          | País:   ", equipo.jugadores[i].pais);
    console.log("          | Historial: ");
    console.log("                      - ID:                           ", equipo.jugadores[i].historial.idH);
    console.log("                      - Número de goles:              ", equipo.jugadores[i].historial.goles_marcados);
    console.log("                      - Número de tarjetas amarillas: ", equipo.jugadores[i].historial.tarj_amarillas);
    console.log("                      - Número de tarjetas rojas:     ", equipo.jugadores[i].historial.tarj_rojas);
    console.log("\n");
}
