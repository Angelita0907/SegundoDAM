// ============================================================
// COMPONENTE: LISTA DE LIBROS (READ - Leer todos)
// Muestra todos los libros en tarjetas y permite eliminarlos.
// 
// Conceptos de Angular cubiertos:
//  - Componente con OnInit (ciclo de vida) — U3.3
//  - Inyección de dependencias (servicio) — U3.3
//  - Data binding: interpolación y event binding — U3.4
//  - Directivas *ngFor y *ngIf — U3.4
// ============================================================

// Importamos los módulos necesarios de Angular
import { Component, OnInit } from '@angular/core';

// CommonModule incluye las directivas *ngFor, *ngIf, etc.
// Sin este import NO funcionarán las directivas en la plantilla
import { CommonModule } from '@angular/common';

// RouterModule incluye routerLink para navegación declarativa en HTML
import { RouterModule } from '@angular/router';

// Importamos nuestro servicio y modelo
import { LibroService } from '../../services/libro.service';
import { Libro } from '../../models/libro.model';

@Component({
  selector: 'app-libro-list',
  standalone: true,
  // Declaramos los módulos que usa la PLANTILLA de este componente
  imports: [CommonModule, RouterModule],
  templateUrl: './libro-list.component.html',
  styleUrls: ['./libro-list.component.css']
})
// "implements OnInit" obliga a implementar el método ngOnInit()
// Es una INTERFAZ de TypeScript (concepto U3.2) que Angular usa
// para el ciclo de vida del componente (U3.3)
export class LibroListComponent implements OnInit {

  // Propiedad pública para almacenar la lista de libros.
  // La plantilla HTML accede a ella directamente.
  // Tipo: array de objetos Libro (tipado con nuestra interfaz)
  libroList: Libro[] = [];

  // INYECCIÓN DE DEPENDENCIAS (U3.3)
  // Al declarar "private libroService: LibroService" en el constructor,
  // Angular crea automáticamente una instancia del servicio y la inyecta.
  // No necesitamos hacer "new LibroService()" manualmente.
  constructor(private libroService: LibroService) { }

  // ngOnInit se ejecuta UNA VEZ cuando el componente termina de inicializarse.
  // Es el lugar correcto para cargar datos (no el constructor).
  // Concepto U3.3: Hooks del ciclo de vida del componente.
  ngOnInit(): void {
    this.loadLibros();  // cargamos los libros al iniciar el componente
  }

  // Método para cargar/recargar la lista desde el servicio
  loadLibros(): void {
    // Llamamos al servicio para obtener todos los libros
    // y los guardamos en la propiedad del componente
    this.libroList = this.libroService.getAll();
  }

  // Método para eliminar un libro — llamado desde la plantilla con (click)
  // El parámetro puede ser undefined porque _id es opcional en la interfaz
  deleteLibro(id: string | undefined): void {
    // Guardián: si no hay id, salimos sin hacer nada
    if (!id) return;

    // confirm() muestra un diálogo de confirmación nativo del navegador
    // Devuelve true si el usuario pulsa "Aceptar"
    if (confirm('¿Estás seguro de que quieres eliminar este libro?')) {
      const success = this.libroService.delete(id);

      if (success) {
        alert('Libro eliminado correctamente');
        this.loadLibros();  // recargamos la lista para reflejar el cambio
      } else {
        alert('Error al eliminar el libro');
      }
    }
  }
}
