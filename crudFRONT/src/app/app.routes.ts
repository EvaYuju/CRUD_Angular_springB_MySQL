import { Routes } from '@angular/router';
import { ListaProductoComponent } from './producto/lista-producto.component';
import { DetalleProductoComponent } from './producto/detalle-producto.component';
import { EditarProductoComponent } from './producto/editar-producto.component';
import { NuevoProductoComponent } from './producto/nuevo-producto.component';

export const routes: Routes = [
    /* { path: '', redirectTo: '/home', pathMatch: 'full' } // Ejemplo - Redirige a la ruta 'home'
       { path: 'home', component: SomeComponent } // Aquí debería estar tu componente */

    // Vamos a definir las rutas de nuestra aplicación:
    {path: '', component: ListaProductoComponent}, // Ruta por defecto
    {path: 'detalle/:id', component: DetalleProductoComponent}, // Ruta para ver el detalle de un producto
    {path: 'editar/:id', component: EditarProductoComponent}, // Ruta para editar un producto   
    {path: 'nuevo', component: NuevoProductoComponent}, // Ruta para crear un nuevo producto,
    {path: '**', redirectTo: '', pathMatch: 'full'} // Ruta redirige si no se encuentra la ruta



];
