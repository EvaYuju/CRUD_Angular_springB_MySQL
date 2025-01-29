import { Component } from '@angular/core';
import { CommonModule } from '@angular/common';  // Si usas directivas comunes como ngIf o ngFor
import { RouterModule } from '@angular/router';  // Importa RouterModule para poder usar router-outlet


@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  imports: [CommonModule, RouterModule],  // Asegúrate de incluir RouterModule aquí

  styleUrls: ['./app.component.css']  // Asegúrate de que esté correctamente escrito
  
})
export class AppComponent {
  title = 'crudFRONT';
}
