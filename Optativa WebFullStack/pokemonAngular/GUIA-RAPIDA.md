# 🚀 GUÍA RÁPIDA DE INICIO

## Paso 1: Preparar el Backend

### 1.1 Instalar CORS en tu proyecto Node.js actual
```bash
cd tu-proyecto-node
npm install cors
```

### 1.2 Actualizar 01-express.js
Agrega estas dos líneas al inicio de tu archivo (después de los requires):
```javascript
const cors = require('cors')
// ...
app.use(cors())
```

### 1.3 Ejecutar el backend
```bash
npm run dev
```
Debe estar corriendo en: http://localhost:3000

---

## Paso 2: Crear el Proyecto Angular

### 2.1 Instalar Angular CLI (solo si no lo tienes)
```bash
npm install -g @angular/cli
```

### 2.2 Crear el proyecto
```bash
ng new pokemon-angular
```
Responde:
- ¿Routing? → **YES**
- ¿Stylesheet? → **CSS**

### 2.3 Entrar al proyecto
```bash
cd pokemon-angular
```

### 2.4 Instalar Bootstrap
```bash
npm install bootstrap
```

---

## Paso 3: Copiar los Archivos de Angular

### 3.1 Estructura de carpetas
Crea esta estructura dentro de `pokemon-angular/src/app/`:

```
src/
├── app/
│   ├── models/
│   │   └── pokemon.model.ts
│   ├── services/
│   │   └── pokemon.service.ts
│   ├── components/
│   │   ├── pokemon-list/
│   │   │   ├── pokemon-list.component.ts
│   │   │   ├── pokemon-list.component.html
│   │   │   └── pokemon-list.component.css
│   │   ├── pokemon-create/
│   │   │   ├── pokemon-create.component.ts
│   │   │   ├── pokemon-create.component.html
│   │   │   └── pokemon-create.component.css
│   │   └── pokemon-edit/
│   │       ├── pokemon-edit.component.ts
│   │       ├── pokemon-edit.component.html
│   │       └── pokemon-edit.component.css
│   ├── app.component.ts
│   ├── app.component.html
│   ├── app.component.css
│   ├── app.config.ts
│   └── app.routes.ts
├── environments/
│   └── environment.ts
├── main.ts
├── styles.css
└── index.html
```

### 3.2 Copiar archivos
Copia todos los archivos que te he proporcionado a sus respectivas ubicaciones.

### 3.3 Actualizar angular.json
En el archivo `angular.json`, busca la sección de "styles" y "scripts" y agrégalas así:

```json
"styles": [
  "node_modules/bootstrap/dist/css/bootstrap.min.css",
  "src/styles.css"
],
"scripts": [
  "node_modules/bootstrap/dist/js/bootstrap.bundle.min.js"
]
```

---

## Paso 4: Ejecutar Angular

```bash
ng serve
```

O para abrir automáticamente el navegador:
```bash
ng serve --open
```

La aplicación estará en: http://localhost:4200

---

## 🎯 Verificación

Si todo está correcto:
1. ✅ Backend corre en http://localhost:3000
2. ✅ Frontend corre en http://localhost:4200
3. ✅ Puedes ver la lista de Pokemon
4. ✅ Puedes crear, editar y eliminar Pokemon

---

## 🐛 Solución de Problemas

### Error de CORS
- Asegúrate de que `cors` está instalado en el backend
- Verifica que `app.use(cors())` está en 01-express.js

### Error "Cannot GET /pokemon"
- Verifica que el backend esté corriendo
- Verifica que la URL en `environment.ts` sea correcta

### Errores de compilación en Angular
```bash
# Limpia e instala de nuevo
rm -rf node_modules
npm install
ng serve
```

### Base de datos no conecta
- Verifica tus variables de entorno en `.env`
- Asegúrate de que MongoDB Atlas está accesible

---

## 📝 Notas Importantes

1. **El backend y frontend corren en puertos diferentes**
   - Backend: 3000
   - Frontend: 4200

2. **No es necesario EJS en Angular**
   - Angular reemplaza completamente las vistas EJS
   - Usa componentes de Angular en su lugar

3. **Las peticiones van a través de HttpClient**
   - Angular usa servicios para comunicarse con la API
   - Todo está tipado con TypeScript

4. **Puedes usar ambas aplicaciones**
   - La app Node.js/EJS sigue funcionando
   - La app Angular es independiente
   - Ambas consumen la misma API
