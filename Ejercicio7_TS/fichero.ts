// Función auxiliar para el calculo de la calificación
function promedio_parciales(...parciales: number[]): number {
    let res: number = 0;
    for(let i in parciales) {
        res += parciales[i];
    }
    return res / arguments.length;
}

function calificacion(promedio: number, ex_final: number, tr_final: number): number {
    return 0.55*promedio + 0.30*ex_final + 0.15*tr_final;
}

// Pruebas función calificacion
console.log("----- CALIFICACIÓN -----")
console.log("Prueba1:   ", calificacion(promedio_parciales(5,7,8), 7, 9))
console.log("Prueba2:   ", calificacion(promedio_parciales(5,5,5), 8, 6))
console.log("")

function mostrarVideojuegos(videojuegos: string[]): string | string[] {
    let res: string | string[] = "";
    for(let i in videojuegos) {
        let videojuego = videojuegos[i];
        if(!videojuego.includes("mario")) {
            res += videojuego + " ";
        }
    }
    return res;
}

let videojuegos1: string[] = ["GTA", "super mario 3D", "fifa", "mario kart", "super mario galaxy", "fortnite", "call of duty"]
let videojuegos2: string[] = [ "super mario 3D", "GTA", "mario kart", "super mario galaxy"];
// Pruebas función mostrarVideojuegos
console.log("----- MOSTRAR VIDEOJUEGOS -----")
console.log("Prueba1:   ", mostrarVideojuegos(videojuegos1))
console.log("Prueba2:   ", mostrarVideojuegos(videojuegos2))
console.log("")

function factorial(numero: number): number {
    let res: number = 1;
    while(numero != 0) {
        res *= numero;
        numero--;
    }
    return res;
}

// Pruebas función factorial
console.log("----- FACTORIAL -----")
console.log("Prueba1:   ", factorial(5))
console.log("Prueba2:   ", factorial(10))
