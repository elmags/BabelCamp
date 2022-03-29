import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Usuario } from '../../datos/Usuario';
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

  constructor(private router: Router) {
    this.error = null;

    this.usuarios = new Usuarios();
    console.log("Path: ", window.location.href);
  }

  ngOnInit(): void {
  }

  /**
   * Comprueba que el nombre de usuario y la contraseña estén en la lista de usuarios válidos.
   * @returns 
   *          - Si el nombre y la contraseña coinciden con un usuario de la lista devuelve 4.
   *          - Si el usuario ha introducido la contraseña mal devuelve 5.
   *          - Si el nombre no existe en la lista devuelve 6.
   *          - Si no se cumple ninguna de las anteriores devuelve el valor de mostrarError().
   */
  public login(): number | any {
    let res: number = this.mostrarError()
    if (res == 0) 
      for (let user of this.usuarios.usuarios) {
        if (user.username == this.username && user.password == this.password) {
          this.usuarioValidado = true;
          sessionStorage.setItem("username", this.username);
          return 4;
        }
        else if (user.username == this.username) return 5;
        else if (user.password == this.password) return 6;
      }
    return res;
  }

  public administrarErrores() {
    this.error = this.login();

    if (this.error == 1) this.error1 = true;
    if (this.error == 2) this.error2 = true;
    if (this.error == 3) this.error3 = true;
    if (this.error == 4) this.router.navigate(['/listado-vj', this.username])
    if (this.error == 5) this.error5 = true;
    if (this.error == 6) this.error6 = true;
  }

  /**
   * Comprueba si algún campo o ambos están vacios al intentar iniciar sesión.
   * @returns 
   *          - Si el usuario ha rellenado tanto el nombre como la contraseña devuelve 0.
   *          - Si el usuario no ha introducido ni el nombre ni la contraseña devuelve 1.
   *          - Si el usuario no ha introducido el nombre, pero la contraseña sí, devuelve 2.
   *          - Si el usuario no ha introducido la contraseña, pero el nombre sí, devuelve 3. 
   */
   public mostrarError(): number {
    if (this.username == "" && this.password == "") return 1;
    else if (this.username == "") return 2;
    else if (this.password == "") return 3;

    return 0;
  }
}
