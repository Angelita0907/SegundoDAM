// ============================================================
// COMPONENTE RAÍZ (App Component)
// Es el componente principal de la aplicación.
// Solo contiene el <router-outlet> que actúa como "hueco"
// donde Angular renderiza el componente de la ruta activa.
// Concepto U3.3: Componentes y renderizado de páginas.
// ============================================================

// Importamos Component (decorador) desde el núcleo de Angular
import { Component } from '@angular/core';

// RouterOutlet es la directiva que permite mostrar el componente
// de la ruta activa dentro de la plantilla
import { RouterOutlet } from '@angular/router';

// El decorador @Component configura los metadatos del componente
@Component({
  // selector: etiqueta HTML personalizada para insertar este componente
  // Aparece en src/index.html como <app-root></app-root>
  selector: 'app-root',

  // standalone: true indica que NO necesita ser declarado en un NgModule
  // (patrón moderno de Angular 17+, el mismo que usa el proyecto Pokémon)
  standalone: true,

  // imports: módulos/directivas que usa la PLANTILLA de este componente
  // RouterOutlet es necesario para que funcione <router-outlet>
  imports: [RouterOutlet],

  // templateUrl: ruta al archivo HTML de la plantilla
  templateUrl: './app.component.html',

  // styleUrls: estilos CSS propios de este componente
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  // El título de la aplicación — propiedad de la clase (U3.3: Clases)
  title = 'crud-libros';
}
