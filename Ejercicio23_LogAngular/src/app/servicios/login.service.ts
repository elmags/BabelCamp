import { Injectable } from '@angular/core';
import { HttpClient, HttpErrorResponse, HttpHeaders } from '@angular/common/http';
import { Observable, catchError, throwError } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class LoginService {

  readonly address = 'http://localhost:8080';

  constructor(private _httpClient : HttpClient) { }

  /**
   * Metodo que valida un usuario del servicio rest a partir de un nombre y una contraseña
   * @param username : Nombre de usuario
   * @param password : Contraseña del usuario
   * @returns un objeto JSON que indica si el usuario está validado (true o false)
   */
  public get(username : String, password : String) : Observable<any> {
    return this._httpClient.get<any>(`${this.address}/Ejercicio21_WebLogin/usuarios/login?username=${username}&password=${password}`).pipe(catchError(this.manejarError));
  }

  /**
   * Metodo que maneja los posibles errores de las llamadas al servicio rest
   * @param error 
   * @returns 
   */
   private manejarError(e: HttpErrorResponse){
    let mensajeError = ''
    if (e.error instanceof ErrorEvent) {
      mensajeError = 'A ocurrido un error:' + e.error
    } else {
      mensajeError = `El servicio Rest retorno: Status: ${e.status}, ` +
            `Body: ${e.error}`
    }
    console.error(mensajeError)
    return throwError(() => new Error(mensajeError));
  }
}
