import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
/* Consume un APIRest-el service se conecta directamente y obtiene todo */
@Injectable({
  providedIn: 'root'
})
export class ProductoService {
  /* En el BackEnd se consume el API Rest para obtener los datos de la BD
   y mostrarlos en la pantalla del FrontEnd  */

  /* BackEnd -> ProductoController en el @RequestMapping la url es "/producto"*/
  productoURL = 'http://localhost:8080/producto/';

  /* En el constructor vamos a inyectar el HttpClient pero como tengo provideHttpClient en el app.module no sería necesario */
  constructor(private httpClient: HttpClient) { }
}
