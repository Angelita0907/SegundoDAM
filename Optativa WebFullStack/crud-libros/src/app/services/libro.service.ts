// ============================================================
// SERVICIO (Service)
// Un servicio centraliza la lógica de negocio y los datos.
// Los componentes NO deben manejar datos directamente —
// delegan esa responsabilidad al servicio.
//
// Concepto visto en U3.3: Servicios como inyección de dependencias.
// El decorador @Injectable hace que Angular pueda inyectar
// este servicio automáticamente en cualquier componente.
// ============================================================

// Importamos el decorador Injectable desde el núcleo de Angular
import { Injectable } from '@angular/core';

// Importamos nuestra interfaz Libro para tipar los datos correctamente
// Concepto U3.2: tipado con interfaces propias
import { Libro } from '../models/libro.model';

// El decorador @Injectable convierte esta clase en un servicio de Angular.
// providedIn: 'root' significa que Angular crea UNA SOLA instancia
// compartida por toda la aplicación (patrón Singleton)
@Injectable({
  providedIn: 'root'
})
export class LibroService {

  // -------------------------------------------------------
  // DATOS INICIALES (simulan una base de datos en memoria)
  // El prefijo "private" significa que solo este servicio
  // puede acceder a esta variable — encapsulación (POO).
  // Tipo: array de objetos que cumplen la interfaz Libro.
  // -------------------------------------------------------
  private libroList: Libro[] = [
    {
      _id: '1',
      titulo: 'Don Quijote de la Mancha',
      autor: 'Miguel de Cervantes',
      genero: 'Ficción',
      anio: 1605,
      descripcion: 'Las aventuras del ingenioso hidalgo Don Quijote.'
    },
    {
      _id: '2',
      titulo: 'Cien años de soledad',
      autor: 'Gabriel García Márquez',
      genero: 'Ficción',
      anio: 1967,
      descripcion: 'La historia de la familia Buendía en Macondo.'
    },
    {
      _id: '3',
      titulo: 'Dune',
      autor: 'Frank Herbert',
      genero: 'Ciencia ficción',
      anio: 1965,
      descripcion: 'Épica space opera en el planeta desértico Arrakis.'
    },
    {
      _id: '4',
      titulo: 'Sapiens',
      autor: 'Yuval Noah Harari',
      genero: 'No ficción',
      anio: 2011,
      descripcion: 'Historia breve de la humanidad desde el homo sapiens.'
    }
  ];

  // Contador para generar IDs únicos automáticamente al crear nuevos libros
  private nextId = 5;

  // El constructor está vacío porque este servicio no depende de otros servicios.
  // (En el proyecto Pokémon también está vacío — mismo patrón)
  constructor() { }

  // -------------------------------------------------------
  // MÉTODO PRIVADO: guarda en localStorage para persistencia
  // (aunque en examen puede omitirse, se incluye por ser igual
  //  al patrón del proyecto Pokémon)
  // -------------------------------------------------------
  private saveToLocalStorage(): void {
    // JSON.stringify convierte el array a texto para guardarlo
    localStorage.setItem('libroList', JSON.stringify(this.libroList));
  }

  // ============================================================
  // CRUD - READ (Leer todos)
  // Devuelve una COPIA del array con el operador spread [...array]
  // Así los componentes no pueden modificar el array original
  // directamente — buena práctica de encapsulación.
  // ============================================================
  getAll(): Libro[] {
    return [...this.libroList];
  }

  // ============================================================
  // CRUD - READ (Leer uno por ID)
  // Array.find() busca el primer elemento que cumple la condición.
  // Devuelve el objeto encontrado o UNDEFINED si no existe.
  // El tipo de retorno "Libro | undefined" es un tipo union (U3.2)
  // ============================================================
  getById(id: string): Libro | undefined {
    // p => p._id === id  es una arrow function de TypeScript (U3.1)
    return this.libroList.find(p => p._id === id);
  }

  // ============================================================
  // CRUD - CREATE (Crear)
  // Recibe un objeto Libro SIN _id (lo asigna aquí).
  // El operador spread {...libro} crea una copia del objeto
  // y le añade/_sobreescribe la propiedad _id.
  // ============================================================
  create(libro: Libro): Libro {
    const nuevoLibro: Libro = {
      ...libro,                          // copia todas las propiedades del objeto recibido
      _id: this.nextId.toString()        // asigna un ID único como string
    };

    this.libroList.push(nuevoLibro);     // añade al array
    this.nextId++;                        // incrementa el contador para el próximo ID
    this.saveToLocalStorage();            // persiste los cambios

    return nuevoLibro;                    // devuelve el libro creado (con su nuevo _id)
  }

  // ============================================================
  // CRUD - UPDATE (Actualizar)
  // findIndex() devuelve la posición del elemento en el array,
  // o -1 si no existe. Devuelve boolean para indicar éxito/fallo.
  // ============================================================
  update(id: string, libro: Libro): boolean {
    const index = this.libroList.findIndex(p => p._id === id);

    if (index !== -1) {
      // Reemplaza el elemento en esa posición con los nuevos datos
      // El spread {...libro, _id: id} asegura que el _id no cambia
      this.libroList[index] = { ...libro, _id: id };
      this.saveToLocalStorage();
      return true;   // éxito
    }
    return false;    // no se encontró el libro con ese ID
  }

  // ============================================================
  // CRUD - DELETE (Eliminar)
  // splice(index, 1) elimina 1 elemento a partir de la posición indicada.
  // Devuelve boolean para indicar éxito/fallo.
  // ============================================================
  delete(id: string): boolean {
    const index = this.libroList.findIndex(p => p._id === id);

    if (index !== -1) {
      this.libroList.splice(index, 1);  // elimina el elemento del array
      this.saveToLocalStorage();
      return true;
    }
    return false;
  }
}
