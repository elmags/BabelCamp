import { Component, NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { InicioComponent } from './componentes/inicio/inicio.component';
import { ListadoVJComponent } from './componentes/listado-vj/listado-vj.component';
import { LoginComponent } from './componentes/login/login.component';

const routes: Routes = [
  {
    path : '',
    component : LoginComponent
  },
  {
    path : 'inicio',
    component : InicioComponent
  },
  {path : 'login', component : LoginComponent},
  {path : 'inicio/:username', component : InicioComponent},
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
