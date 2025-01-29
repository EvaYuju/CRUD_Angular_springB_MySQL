import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { RouterModule } from '@angular/router';
import { AppRoutingModule } from './app-routing.module';  // Importa el RouterModule
// External
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { ToastrModule } from 'ngx-toastr';

@NgModule({
  declarations: [],
  imports: [
    AppRoutingModule,  // Agrega AppRoutingModule en los imports
    CommonModule,
    RouterModule,  // Asegúrate de agregarlo en los imports
    BrowserAnimationsModule, // required animations module
    ToastrModule.forRoot(), AppRoutingModule, // ToastrModule added
  ],
  providers: []
 // bootstrap: []   Componente principal para arrancar la app

})
export class AppModule { }
