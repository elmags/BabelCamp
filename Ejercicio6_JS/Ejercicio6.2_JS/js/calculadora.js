let res = 0

function suma() {
    let num1 = parseInt(numero1.value)
    res = num1
    idRes.value = num1 + idSuma.value
}

function resta() {
    let num1 = parseInt(numero1.value)
    res = num1
    idRes.value = num1 + idResta.value
}

function multiplicacion() {
    let num1 = parseInt(numero1.value)
    res = num1
    idRes.value = num1 + idMult.value
}

function division() {
    let num1 = parseInt(numero1.value)
    res = num1
    idRes.value = num1 + idDivision.value
}

function allClear() {
    res = 0
    idRes.value = 0
}

function resultado() {
    let num2 = parseInt(numero2.value)
    if (idRes.value.includes(" + ")) {
        res += num2
        idRes.value += num2 + " = " + res
    }
    else if (idRes.value.includes(" - ")) {
        res -= num2
        idRes.value += num2 + " = " + res
    }
    else if (idRes.value.includes(" x ")) {
        res *= num2
        idRes.value += num2 + " = " + res
    }
    else if (idRes.value.includes(" / ")) {
        res /= num2
        idRes.value += num2 + " = " + res
    }
}