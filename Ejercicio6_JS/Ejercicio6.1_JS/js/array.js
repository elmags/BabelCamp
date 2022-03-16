array = []

function añadirNumero() {
    let campo = numero.value
    if (campo != null && campo != "") {
        let num = parseInt(campo)
        array.push(num)

        document.getElementById('mostrarArray').type = "text"
        mostrarArray.value += num + " "
    }    
}

function numAleatorio() {
    numeroRandom.value = array[Math.floor(Math.random()*array.length)]
}

