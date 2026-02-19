// ============================================================
// COMPONENTE: EDITAR LIBRO (UPDATE + DELETE)
// Lee el ID de la URL, carga el libro, permite modificarlo
// o eliminarlo.
//
// Conceptos de Angular ADICIONALES respecto al de Crear:
//  - ActivatedRoute: leer parámetros de la URL (:id) — U3.4
//  - OnInit: ciclo de vida para cargar datos al inicio — U3.3
// ============================================================

import { Component, OnInit } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';

// ActivatedRoute nos permite acceder a los parámetros de la URL actual.
// En este caso leerá el parámetro :id de la ruta 'editar/:id'
import { ActivatedRoute, Router } from '@angular/router';

import { LibroService } from '../../services/libro.service';
import { Libro } from '../../models/libro.model';

@Component({
  selector: 'app-libro-edit',
  standalone: true,
  imports: [CommonModule, FormsModule],
  templateUrl: './libro-edit.component.html',
  styleUrls: ['./libro-edit.component.css']
})
export class LibroEditComponent implements OnInit {

  // Objeto libro que se enlaza con el formulario de edición
  libro: Libro = {
    titulo: '',
    autor: '',
    genero: 'Ficción',
    anio: 2000,
    descripcion: ''
  };

  // ID del libro que vamos a editar (leído de la URL)
  libroId: string = '';

  // Si el libro no se encuentra, mostramos un mensaje de error
  notFound: boolean = false;

  // Constructor: inyectamos tres dependencias
  // - LibroService: para leer, actualizar y eliminar
  // - Router: para navegar programáticamente
  // - ActivatedRoute: para leer el parámetro :id de la URL
  constructor(
    private libroService: LibroService,
    private router: Router,
    private route: ActivatedRoute   // ← NOVEDAD respecto al componente Crear
  ) { }

  // ngOnInit: primer método que ejecuta Angular tras crear el componente
  ngOnInit(): void {
    // route.snapshot.params contiene los parámetros de la URL como objeto.
    // route.snapshot.params['id'] lee el valor del parámetro :id
    // Concepto U3.4: leer parámetros de ruta con ActivatedRoute
    this.libroId = this.route.snapshot.params['id'];

    // Cargamos los datos del libro con ese ID
    this.loadLibro();
  }

  // Carga el libro desde el servicio usando el ID leído de la URL
  loadLibro(): void {
    const found = this.libroService.getById(this.libroId);

    if (found) {
      // El spread operator {...found} crea una COPIA del objeto
      // para no modificar directamente el objeto del servicio
      this.libro = { ...found };
    } else {
      // Si no existe ese ID, activamos la bandera de "no encontrado"
      this.notFound = true;
    }
  }

  // onSubmit: guarda los cambios del formulario
  onSubmit(): void {
    if (!this.libro.titulo || !this.libro.autor || !this.libro.descripcion) {
      alert('Los campos Título, Autor y Descripción son obligatorios');
      return;
    }

    // Llamamos al método update del servicio pasando el ID y los nuevos datos
    const success = this.libroService.update(this.libroId, this.libro);

    if (success) {
      alert('¡Libro actualizado correctamente!');
      this.router.navigate(['/libros']);   // volvemos al listado
    } else {
      alert('Error al actualizar el libro');
    }
  }

  // deleteLibro: elimina el libro actual
  deleteLibro(): void {
    if (confirm('¿Estás seguro de que quieres eliminar este libro?')) {
      const success = this.libroService.delete(this.libroId);

      if (success) {
        alert('Libro eliminado correctamente');
        this.router.navigate(['/libros']);
      } else {
        alert('Error al eliminar el libro');
      }
    }
  }

  // onCancel: vuelve al listado sin guardar cambios
  onCancel(): void {
    this.router.navigate(['/libros']);
  }
}
