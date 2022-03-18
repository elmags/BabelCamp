import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-calculadora',
  templateUrl: './calculadora.component.html',
  styleUrls: ['./calculadora.component.css']
})
export class CalculadoraComponent implements OnInit {

  res: number = 0;
  mostrar: string = "";
  op: string;
  finCalc: boolean = false;

  // Datos que recogemos
  numero1: string = "";
  numero2: string = "" ;

  constructor() {
    enum operacion {
      Sin_asignar = "",
      Suma = "+",
      Resta = "-",
      Multiplicacion = "x",
      Division = "/",
    };
    this.op = operacion.Sin_asignar;
  }

  ngOnInit(): void {
  }

  public suma() {
    this.op = "+";
    this.res = parseInt(this.numero1);
    this.mostrar = this.numero1 + "+";
}

  public resta() {
    this.op = "-";
    this.res = parseInt(this.numero1);
    this.mostrar = this.numero1 + "-";
}

  public multiplicacion() {
    this.op = "x";
    this.res = parseInt(this.numero1);
    this.mostrar = this.numero1 + "x";
}

  public division() {
    this.op = "/";
    this.res = parseInt(this.numero1);
    this.mostrar = this.numero1 + "/";
}

  public allClear() {
    this.op = "";
    this.res = 0;
    this.numero1 = "";
    this.numero2 = "";
    this.mostrar = "";
    this.finCalc = false;
}

  public resultado() {
    this.finCalc = true;
    if (this.op == "+") {
      this.res += parseInt(this.numero2);
      this.mostrar += this.numero2 + "=" + this.res;
    }
    else if (this.op == "-") {
      this.res -= parseInt(this.numero2);
    }
    else if (this.op == "x") {
      this.res *= parseInt(this.numero2);
    }
    else if (this.op == "/") {
      this.res /= parseInt(this.numero2);
    }
  }
}
