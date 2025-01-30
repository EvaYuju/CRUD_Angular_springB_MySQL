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

  /* nuestra url -> ProductoController en el @RequestMapping la url es "/producto"*/
  productoURL = 'http://localhost:8080/producto/';

  /* En el constructor vamos a inyectar el HttpClient pero como tengo provideHttpClient en el app.module no sería necesario */
  constructor(private httpClient: HttpClient) { }

  // Métodos:
  /* Este método lista nos va a devolver un Observable<claseProducto[lista]
  que nos devuelva con el metodo .get la lista de producto */
  public lista(): Observable<Producto[]> {
    return this.httpClient.get<Producto[]>(this.productoURL + 'lista');
  }

  /* Este método detalle nos va a devolver un Observable<claseProducto[detalle]
  que nos devuelva con el metodo .get el detalle de producto */
  public detail(id: number): Observable<Producto> {       
    // Se le pasa el id del producto
    return this.httpClient.get<Producto>(this.productoURL + `detail/${id}`); // Se usa el acento grave para concatenar ``
  }

  /* Metodo para buscar un producto por su nombre */
  public detailName(nombre: string): Observable<Producto> {
    /* Se le pasa el nombre del producto y se le dice que es de tipo Producto */
    return this.httpClient.get<Producto>(this.productoURL + `detailName/${nombre}`);
  }

  /* Metodo para crear un producto */
  public create(producto: Producto): Observable<any> {
    /* Se le dice que es de tipo any; se le pasa el objeto producto porque post tiene requestBody */
    return this.httpClient.post<any>(this.productoURL + 'create', producto);
  }

  /* Metodo para editar un producto */
  public update(id: number, producto: Producto): Observable<any> {
    /* Se le pasa el id del producto y el objeto producto porque PUT tiene requestBody */
    return this.httpClient.put<any>(this.productoURL + `update/${id}`, producto);
  }

  /* Metodo para borrar un producto */  
  public delete(id: number): Observable<any> {
    /* Se le pasa el id del producto, método delete */
    return this.httpClient.delete<any>(this.productoURL + `delete/${id}`);
  }   




}
