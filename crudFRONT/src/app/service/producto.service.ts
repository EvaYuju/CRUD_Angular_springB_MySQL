import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Producto } from '../models/producto';

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

  // Métodos:
  /* Este método lista nos va a devolver un Observable<claseProducto[lista]
  que nos devuelva con el metodo get la lista de producto */
  public lista(): Observable<Producto[]> {
    return this.httpClient.get<Producto[]>(this.productoURL + 'lista');
  }

}
