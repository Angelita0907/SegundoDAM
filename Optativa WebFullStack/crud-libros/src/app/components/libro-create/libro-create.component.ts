// ============================================================
// COMPONENTE: CREAR LIBRO (CREATE)
// Muestra un formulario para crear un nuevo libro.
//
// Conceptos de Angular cubiertos:
//  - Componente standalone — U3.3
//  - Inyección de Router y servicio — U3.3
//  - Two-way binding con [(ngModel)] — U3.4
//  - Event binding (ngSubmit) — U3.4
//  - Navegación programática con Router — U3.4
// ============================================================

import { Component } from '@angular/core';
import { CommonModule } from '@angular/common';

// FormsModule es NECESARIO para poder usar [(ngModel)] en la plantilla
// Sin este import, el two-way binding no funcionará
import { FormsModule } from '@angular/forms';

// Router permite navegar a otras rutas DESDE el código TypeScript
// (navegación programática, a diferencia de routerLink que es declarativa)
import { Router } from '@angular/router';

import { LibroService } from '../../services/libro.service';
import { Libro } from '../../models/libro.model';

@Component({
  selector: 'app-libro-create',
  standalone: true,
  // FormsModule debe declararse aquí para que [(ngModel)] funcione en la plantilla
  imports: [CommonModule, FormsModule],
  templateUrl: './libro-create.component.html',
  styleUrls: ['./libro-create.component.css']
})
export class LibroCreateComponent {

  // Objeto libro con valores iniciales vacíos.
  // Este objeto está enlazado con el formulario mediante [(ngModel)].
  // Cuando el usuario escribe en un campo, esta propiedad se actualiza automáticamente.
  // Usamos el tipo Literal de TypeScript para el género (U3.2)
  libro: Libro = {
    titulo: '',
    autor: '',
    genero: 'Ficción',     // valor por defecto para el select
    anio: new Date().getFullYear(),
    descripcion: ''
  };

  // Constructor: inyectamos el servicio Y el Router
  // Angular resuelve ambas dependencias automáticamente
  constructor(
    private libroService: LibroService,
    private router: Router        // para navegar después de crear
  ) { }

  // onSubmit se llama cuando el usuario envía el formulario (ngSubmit)
  onSubmit(): void {
    // Validación manual antes de guardar — comprobamos que los campos obligatorios estén rellenos
    if (!this.libro.titulo || !this.libro.autor || !this.libro.descripcion) {
      alert('Los campos Título, Autor y Descripción son obligatorios');
      return;  // salimos sin guardar
    }

    // Llamamos al método create del servicio
    this.libroService.create(this.libro);

    alert('¡Libro creado exitosamente!');

    // Navegamos programáticamente de vuelta a la lista
    // this.router.navigate(['/libros']) es equivalente a routerLink="/libros"
    // pero desde el código TypeScript en lugar de la plantilla HTML
    this.router.navigate(['/libros']);
  }

  // onCancel cancela el formulario y vuelve al listado sin guardar
  onCancel(): void {
    this.router.navigate(['/libros']);
  }
}
