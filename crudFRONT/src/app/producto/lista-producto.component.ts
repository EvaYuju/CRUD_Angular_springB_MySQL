import { Component } from '@angular/core';
import { Producto } from '../models/producto';
import { ProductoService } from '../service/producto.service';


@Component({
  selector: 'app-lista-producto',
  imports: [],
  templateUrl: './lista-producto.component.html',
  styleUrl: './lista-producto.component.css'
})
export class ListaProductoComponent {

  // Creamos un array de productos
  productos: Producto[] = [];

  constructor(private productoService: ProductoService) {}

  ngOnInit(): void {
    this.productoService.lista().subscribe(data => this.productos = data);  
  }

  cargarProductos(): void {
    this.productoService.lista().subscribe(
      data => {
        this.productos = data;
      },
      err => {
        console.log(err);
      },
    );
  }


}
