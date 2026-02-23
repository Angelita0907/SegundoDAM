import { Routes } from '@angular/router';
import { LoginComponent } from './components/login/login.component';
import { MiPerfilComponent } from './components/mi-perfil/mi-perfil.component';
import { LecturaListComponent } from './components/lectura-list/lectura-list.component';
import { LecturaCreateComponent } from './components/lectura-create/lectura-create.component';
import { LecturaEditComponent } from './components/lectura-edit/lectura-edit.component';
import { UsuarioListComponent } from './components/usuario-list/usuario-list.component';
import { UsuarioCreateComponent } from './components/usuario-create/usuario-create.component';
import { UsuarioEditComponent } from './components/usuario-edit/usuario-edit.component';
import { authGuard, adminGuard } from './guards/auth.guard';

export const routes: Routes = [
  { path: '', redirectTo: '/login', pathMatch: 'full' },
  { path: 'login', component: LoginComponent },

  // Ruta para usuario normal (ver perfil y actividades)
  { path: 'mi-perfil', component: MiPerfilComponent, canActivate: [authGuard] },

  // Rutas solo admin
  { path: 'lecturas', component: LecturaListComponent, canActivate: [authGuard, adminGuard] },
  { path: 'lecturas/crear', component: LecturaCreateComponent, canActivate: [authGuard, adminGuard] },
  { path: 'lecturas/editar/:id', component: LecturaEditComponent, canActivate: [authGuard, adminGuard] },
  { path: 'usuarios', component: UsuarioListComponent, canActivate: [authGuard, adminGuard] },
  { path: 'usuarios/crear', component: UsuarioCreateComponent, canActivate: [authGuard, adminGuard] },
  { path: 'usuarios/editar/:id', component: UsuarioEditComponent, canActivate: [authGuard, adminGuard] },

  { path: '**', redirectTo: '/login' }
];
