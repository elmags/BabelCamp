import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { LoginService } from 'src/app/servicios/login.service';
import { Usuarios } from '../../datos/Usuarios';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  usuarios: Usuarios;

  usuarioValidado: boolean = false;
  error: number | null;

  // variables para los errores posibles
  error1: boolean = false;
  error2: boolean = false;
  error3: boolean = false;
  error5: boolean = false;
  error6: boolean = false;

  // Datos que recogemos
  username = "";
  password = "";

  constructor(private router: Router, private _loginService : LoginService) {
    this.error = null;

    this._loginService = _loginService
    console.log("Path: ", window.location.href);
  }

  ngOnInit(): void { }

  /**
   * Comprueba que el usuario se encuentra en la base de datos.
   *    - Si el usuario está validado entra a la aplicación.
   */
  res : number = -1;
  public login() {
    this.mostrarError()
    if (this.error == 0) {
      this._loginService.get(this.username, this.password)
      // this._loginService.post(this.username, this.password)
        .subscribe((respuesta) => {
          if (respuesta.validado) {
            sessionStorage.setItem("username", this.username);
            this.router.navigate(['/listado-vj', this.username])
          }
        });
    }
  }

  public administrarErrores() {
    this.login();

    if (this.error == 1) this.error1 = true;
    if (this.error == 2) this.error2 = true;
    if (this.error == 3) this.error3 = true;
  }

  /**
   * Comprueba si algún campo o ambos están vacios al intentar iniciar sesión.
   * @returns 
   *          - Si el usuario ha rellenado tanto el nombre como la contraseña devuelve 0.
   *          - Si el usuario no ha introducido ni el nombre ni la contraseña devuelve 1.
   *          - Si el usuario no ha introducido el nombre, pero la contraseña sí, devuelve 2.
   *          - Si el usuario no ha introducido la contraseña, pero el nombre sí, devuelve 3. 
   */
   public mostrarError() {
    if (this.username == "" && this.password == "") this.error = 1;
    else if (this.username == "") this.error = 2;
    else if (this.password == "") this.error = 3;
    else this.error = 0;
  }
}
