// ============================================================
// ROUTING (Enrutamiento)
// Define las rutas URL de la aplicación y qué componente
// debe mostrarse para cada ruta.
// Concepto visto en U3.4: Configurando Router.
// ============================================================

// Importamos el tipo Routes desde el módulo de Router de Angular
import { Routes } from '@angular/router';

// Importamos los tres componentes que tendrán su propia ruta
import { LibroListComponent } from './components/libro-list/libro-list.component';
import { LibroCreateComponent } from './components/libro-create/libro-create.component';
import { LibroEditComponent } from './components/libro-edit/libro-edit.component';

// El array "routes" define la tabla de rutas de la aplicación.
// Cada objeto del array es una ruta con:
//   path: la URL (sin el /)
//   component: qué componente mostrar en esa URL
export const routes: Routes = [
  // Ruta vacía ('') redirige automáticamente a /libros
  // pathMatch: 'full' significa que la URL debe ser EXACTAMENTE ''
  { path: '', redirectTo: '/libros', pathMatch: 'full' },

  // Ruta principal: lista todos los libros
  { path: 'libros', component: LibroListComponent },

  // Ruta para crear un libro nuevo
  { path: 'crear', component: LibroCreateComponent },

  // Ruta para editar — el :id es un parámetro de ruta dinámico
  // El componente leerá este parámetro con ActivatedRoute (ver libro-edit)
  { path: 'editar/:id', component: LibroEditComponent },

  // Ruta comodín: cualquier URL no reconocida redirige a /libros
  // Debe ser SIEMPRE la última ruta del array
  { path: '**', redirectTo: '/libros' }
];
