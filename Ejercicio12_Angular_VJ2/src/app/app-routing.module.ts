import { Component, NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { ContactoComponent } from './componentes/contacto/contacto.component';
import { DetalleVjComponent } from './componentes/detalle-vj/detalle-vj.component';
import { InfUsComponent } from './componentes/inf-us/inf-us.component';
import { ListadoVJComponent } from './componentes/listado-vj/listado-vj.component';
import { LoginComponent } from './componentes/login/login.component';

const routes: Routes = [
  {path : 'login', component : LoginComponent},
  {path : 'listado-vj/:username', component : ListadoVJComponent},
  {path : 'infUs', component : InfUsComponent},
  {path : 'contacto', component : ContactoComponent},
  {path : 'detalle-vj/:id', component : DetalleVjComponent},
  {path : '', redirectTo : '/login', pathMatch : 'full'},
];

@NgModule({
  imports: [RouterModule.forRoot(routes, {onSameUrlNavigation: 'reload'})],
  exports: [RouterModule]
})
export class AppRoutingModule { }
