import { Routes } from '@angular/router';
import { authGuard } from '@core/guards/auth.guard';

export const routes: Routes = [
  {
    path: '',
    redirectTo: '/dashboard',
    pathMatch: 'full'
  },
  {
    path: 'auth',
    children: [
      {
        path: 'login',
        loadComponent: () => import('./features/auth/login/login.component')
          .then(m => m.LoginComponent)
      },
      {
        path: 'register',
        loadComponent: () => import('./features/auth/register/register.component')
          .then(m => m.RegisterComponent)
      }
    ]
  },
  {
    path: 'dashboard',
    canActivate: [authGuard],
    loadComponent: () => import('./features/statistics/statistics.component')
      .then(m => m.StatisticsComponent)
  },
  {
    path: 'admin',
    canActivate: [authGuard],
    children: [
      {
        path: 'readings',
        loadComponent: () => import('./features/admin/readings-list/readings-list.component')
          .then(m => m.ReadingsListComponent)
      },
      {
        path: 'readings/create',
        loadComponent: () => import('./features/admin/reading-create/reading-create.component')
          .then(m => m.ReadingCreateComponent)
      },
      {
        path: 'readings/edit/:id',
        loadComponent: () => import('./features/admin/reading-edit/reading-edit.component')
          .then(m => m.ReadingEditComponent)
      }
    ]
  },
  {
    path: '**',
    redirectTo: '/dashboard'
  }
];
