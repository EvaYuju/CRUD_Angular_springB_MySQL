import { Component, OnInit } from '@angular/core';
import { Producto } from '../models/producto';
import { ProductoService } from '../service/producto.service';
import { CommonModule } from '@angular/common';  // Importa CommonModule
//import { NgModule } from '@angular/core';
import { RouterModule } from '@angular/router';  // Importa RouterModule para poder usar router-outlet
import { take, tap } from 'rxjs/operators';



@Component({
  selector: 'app-lista-producto', 
  standalone: true, // *standalone component
  imports: [CommonModule, RouterModule],
  templateUrl: './lista-producto.component.html',
  styleUrls: ['./lista-producto.component.css']
})
export class ListaProductoComponent {

  // Creamos un array de productos de tipo Producto
  productos: Producto[] = [];

  constructor(private productoService: ProductoService) {}

  ngOnInit() {
    this.cargarProductos();
    //this.productoService.lista().subscribe(data => this.productos = data);  
  }
  cargarProductos(): void {
    this.productoService.lista()
      .pipe(
        take(1), // ✅ Corta la suscripción después de la primera emisión
        tap(() => console.log('Productos cargados correctamente')) // ✅ Depuración sin usar complete
      )
      .subscribe({
        next: (data) => (this.productos = data),
        error: (err) => console.error('Error al cargar productos:', err)
      });
  }


/*
  cargarProductos(): void {
    // Llamamos al método lista() de nuestro servicio
    this.productoService.lista().subscribe(
      data => {
        this.productos = data;
      },
      err => {
        console.log(err);
      },
    );
  }*/


}
