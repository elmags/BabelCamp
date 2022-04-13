import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { HttpClientModule } from '@angular/common/http';
import { LoginComponent } from './componentes/login/login.component';
import { ListadoVJComponent } from './componentes/listado-vj/listado-vj.component';
import { InfUsComponent } from './componentes/inf-us/inf-us.component';
import { ContactoComponent } from './componentes/contacto/contacto.component';
import { DetalleVjComponent } from './componentes/detalle-vj/detalle-vj.component';
import { CabeceraComponent } from './componentes/cabecera/cabecera.component';
import { FormsModule } from '@angular/forms';

@NgModule({
  declarations: [
    AppComponent,
    LoginComponent,
    ListadoVJComponent,
    InfUsComponent,
    ContactoComponent,
    DetalleVjComponent,
    CabeceraComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    FormsModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
