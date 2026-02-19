// ============================================================
// PUNTO DE ENTRADA DE LA APLICACIÓN
// Este archivo es el primero que ejecuta Angular.
// Arranca la aplicación usando la configuración de app.config.ts
// Concepto U3.3: Renderizado de una página en Angular
// ============================================================

// bootstrapApplication arranca la aplicación con un componente raíz
import { bootstrapApplication } from '@angular/platform-browser';

// Importamos la configuración (proveedores, rutas, etc.)
import { appConfig } from './app/app.config';

// Importamos el componente raíz de la aplicación
import { AppComponent } from './app/app.component';

// Iniciamos la aplicación: Angular renderizará AppComponent
// dentro del selector <app-root> del index.html
bootstrapApplication(AppComponent, appConfig)
  .catch((err) => console.error(err));
