import { Routes } from '@angular/router';
import { PokemonListComponent } from './components/pokemon-list/pokemon-list.component';
import { PokemonCreateComponent } from './components/pokemon-create/pokemon-create.component';
import { PokemonEditComponent } from './components/pokemon-edit/pokemon-edit.component';

export const routes: Routes = [
  { path: '', redirectTo: '/pokemon', pathMatch: 'full' },
  { path: 'pokemon', component: PokemonListComponent },
  { path: 'crear', component: PokemonCreateComponent },
  { path: 'editar/:id', component: PokemonEditComponent },
  { path: '**', redirectTo: '/pokemon' }
];
