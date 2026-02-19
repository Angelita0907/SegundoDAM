# 📚 CRUD Libros — Angular — Guía de referencia para el examen

## ⚡ INICIO RÁPIDO
```bash
# 1. Entra en la carpeta
cd crud-libros

# 2. Instala dependencias (solo la primera vez)
npm install

# 3. Levanta el servidor de desarrollo
ng serve

# 4. Abre en el navegador
# http://localhost:4200
```

---

## 🗂️ ESTRUCTURA DEL PROYECTO
```
src/app/
├── models/
│   └── libro.model.ts          ← Interfaz TypeScript (tipo de dato)
├── services/
│   └── libro.service.ts        ← Lógica CRUD centralizada
├── components/
│   ├── libro-list/             ← READ: lista todos los libros
│   ├── libro-create/           ← CREATE: formulario nuevo libro
│   └── libro-edit/             ← UPDATE + DELETE: formulario editar
├── app.routes.ts               ← Tabla de rutas de la app
├── app.config.ts               ← Configuración global (providers)
└── app.component.ts            ← Componente raíz (solo router-outlet)
```

---

## 🧠 CONCEPTOS CLAVE (por si te preguntan)

### 1. Interfaz TypeScript (modelo)
```typescript
export interface Libro {
  _id?: string;           // opcional con ?
  titulo: string;
  genero: 'Ficción' | 'No ficción';  // tipo literal + union (U3.2)
}
```

### 2. Servicio con @Injectable
```typescript
@Injectable({ providedIn: 'root' })  // Singleton en toda la app
export class LibroService {
  private datos: Libro[] = [];        // encapsulación con private
  
  getAll(): Libro[]                   { return [...this.datos]; }
  getById(id: string): Libro|undefined { return this.datos.find(l => l._id === id); }
  create(libro: Libro): Libro          { /* push + nextId++ */ }
  update(id: string, libro: Libro): boolean { /* findIndex + splice */ }
  delete(id: string): boolean          { /* findIndex + splice */ }
}
```

### 3. Componente con decorador @Component
```typescript
@Component({
  selector: 'app-libro-list',
  standalone: true,
  imports: [CommonModule, RouterModule],  // módulos necesarios para la plantilla
  templateUrl: './libro-list.component.html',
  styleUrls: ['./libro-list.component.css']
})
export class LibroListComponent implements OnInit {
  constructor(private libroService: LibroService) {}  // inyección de dependencias
  ngOnInit(): void { this.loadLibros(); }             // hook de ciclo de vida
}
```

### 4. Rutas (Routing)
```typescript
export const routes: Routes = [
  { path: '', redirectTo: '/libros', pathMatch: 'full' },
  { path: 'libros', component: LibroListComponent },
  { path: 'crear', component: LibroCreateComponent },
  { path: 'editar/:id', component: LibroEditComponent },  // :id = parámetro dinámico
  { path: '**', redirectTo: '/libros' }                   // wildcard = siempre al final
];
```

### 5. Data binding (los 4 tipos — U3.3 y U3.4)
```html
<!-- 1. INTERPOLACIÓN — componente → plantilla (mostrar datos) -->
{{ libro.titulo }}

<!-- 2. PROPERTY BINDING — pasar valor a atributo/directiva -->
[routerLink]="['/editar', libro._id]"

<!-- 3. EVENT BINDING — plantilla → componente (capturar eventos) -->
(click)="deleteLibro(libro._id)"
(ngSubmit)="onSubmit()"

<!-- 4. TWO-WAY BINDING — ambas direcciones (formularios) -->
[(ngModel)]="libro.titulo"   <!-- requiere FormsModule en imports -->
```

### 6. Directivas estructurales (U3.4)
```html
<!-- *ngFor: repite el elemento por cada item del array -->
<div *ngFor="let libro of libroList; let i = index">
  {{ i + 1 }} - {{ libro.titulo }}
</div>

<!-- *ngIf: muestra u oculta el elemento según la condición -->
<p *ngIf="libroList.length === 0">No hay libros</p>
<form *ngIf="!notFound">...</form>
```

### 7. Leer parámetros de ruta (ActivatedRoute) — U3.4
```typescript
constructor(private route: ActivatedRoute) {}

ngOnInit(): void {
  this.libroId = this.route.snapshot.params['id'];  // lee :id de la URL
}
```

### 8. Navegación programática
```typescript
constructor(private router: Router) {}

// En código TypeScript (equivalente a routerLink en HTML)
this.router.navigate(['/libros']);
this.router.navigate(['/editar', id]);
```

---

## 🔄 CÓMO ADAPTAR ESTE CRUD A OTRA ENTIDAD

1. **Cambia el modelo** en `models/libro.model.ts` → define las nuevas propiedades
2. **Cambia el servicio** en `services/libro.service.ts` → actualiza el array de datos y el nombre
3. **Cambia los componentes** → actualiza las propiedades, métodos y plantillas HTML
4. **Cambia las rutas** en `app.routes.ts` → actualiza los paths y los componentes
5. **Cambia los imports** en `app.routes.ts` → importa los nuevos componentes

### Ejemplo: cambiar a "Películas"
```typescript
// models/pelicula.model.ts
export interface Pelicula {
  _id?: string;
  titulo: string;
  director: string;
  anio: number;
}

// services/pelicula.service.ts → mismo patrón, cambia Libro por Pelicula
// components/ → copia los 3 componentes, busca y reemplaza "libro" por "pelicula"
// app.routes.ts → cambia 'libros' por 'peliculas', etc.
```

---

## ⚠️ ERRORES COMUNES EN EXAMEN

| Error | Causa | Solución |
|-------|-------|----------|
| `*ngFor` no funciona | Falta `CommonModule` en `imports: []` del componente | Añadir `CommonModule` |
| `[(ngModel)]` no funciona | Falta `FormsModule` en `imports: []` | Añadir `FormsModule` |
| `routerLink` no funciona | Falta `RouterModule` en `imports: []` | Añadir `RouterModule` |
| Ruta con parámetro no lee el ID | Falta inyectar `ActivatedRoute` | `private route: ActivatedRoute` en constructor |
| El array no se actualiza en pantalla | Se modifica el array del servicio directamente | Llamar a `loadLibros()` tras cada operación |
