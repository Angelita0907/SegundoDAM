import { Routes } from '@angular/router';
import { Inicio } from './components/inicio/inicio';
import { QuienesSomos } from './components/quienes-somos/quienes-somos';
import { Catalogo } from './components/catalogo/catalogo';
import { Contacto } from './components/contacto/contacto';

export const routes: Routes = [
  { path: '', redirectTo: '/inicio', pathMatch: 'full' },
  { path: 'inicio', component: Inicio },
  { path: 'quienes-somos', component: QuienesSomos },
  { path: 'catalogo', component: Catalogo },
  { path: 'contacto', component: Contacto },
  { path: '**', redirectTo: '/inicio' }
];