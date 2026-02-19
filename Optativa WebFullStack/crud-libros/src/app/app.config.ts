// ============================================================
// CONFIGURACIÓN DE LA APLICACIÓN
// Define los providers (proveedores) globales de la aplicación.
// Es el equivalente moderno al AppModule en Angular antiguo.
// ============================================================

import { ApplicationConfig, provideZoneChangeDetection } from '@angular/core';
// provideRouter registra el sistema de rutas en la aplicación
import { provideRouter } from '@angular/router';
// Importamos nuestras rutas definidas en app.routes.ts
import { routes } from './app.routes';

export const appConfig: ApplicationConfig = {
  providers: [
    // Optimización de detección de cambios con zone.js
    provideZoneChangeDetection({ eventCoalescing: true }),
    // Registra el Router con nuestras rutas — imprescindible para la navegación
    provideRouter(routes)
  ]
};
