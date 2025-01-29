import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { RouterModule } from '@angular/router'; // RouterModule necesario
import { routes } from './app.routes';  // Importa las rutas definidas
import { AppComponent } from './app.component';

@NgModule({
  declarations: [],
  imports: [
    CommonModule,
    AppComponent,
    RouterModule.forRoot(routes)
  ],  // Utiliza forRoot() para definir las rutas principales
  exports: [RouterModule]  // Exporta RouterModule para que puedas usarlo en tu aplicación
  
})
export class AppRoutingModule { }
