import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { AppComponent } from './app.component';
import { RouterModule } from '@angular/router';
import { AppRoutingModule } from './app-routing.module';  // Importa el RouterModule

import { HttpClientModule, provideHttpClient, HttpClient } from '@angular/common/http';
import { withInterceptorsFromDi } from '@angular/common/http';

import { FormsModule } from '@angular/forms';
// External
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { ToastrModule } from 'ngx-toastr';

@NgModule({
  declarations: [
  ],
  imports: [
    AppRoutingModule,  
    FormsModule,
    CommonModule,
    RouterModule,  
    BrowserAnimationsModule, // required animations module
    ToastrModule.forRoot(),  // ToastrModule added
  ],
  providers: [
    provideHttpClient(withInterceptorsFromDi())

  ],
//bootstrap: [ AppComponent]    Componente principal para arrancar la app

})
export class AppModule { }
