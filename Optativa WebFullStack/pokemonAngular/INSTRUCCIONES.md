# Migración de Node.js/Express a Angular - CRUD Pokemon

## 📋 Índice
1. [Modificaciones en el Backend](#1-modificaciones-en-el-backend)
2. [Crear la aplicación Angular](#2-crear-la-aplicación-angular)
3. [Estructura del proyecto Angular](#3-estructura-del-proyecto-angular)
4. [Ejecutar el proyecto](#4-ejecutar-el-proyecto)

---

## 1. Modificaciones en el Backend

### 1.1 Instalar CORS
Primero, necesitas instalar el paquete CORS en tu backend:

```bash
npm install cors
```

### 1.2 Modificar 01-express.js
Agrega CORS a tu archivo principal (01-express.js):

```javascript
const cors = require('cors');

// Después de crear la app
app.use(cors());
```

El archivo completo debería verse así (sin los conflictos de Git):

```javascript
const express = require('express')
const bodyParser = require('body-parser')
const cors = require('cors')
const app = express()

require('dotenv').config()

const port = process.env.PORT || 3000

// CORS para permitir peticiones desde Angular
app.use(cors())

// parsear la aplicacion
app.use(bodyParser.urlencoded({ extended: false}))

// parse de la app/json
app.use(bodyParser.json())

// motor de plantillas 
app.set('view engine', 'ejs');

// carpeta de las vistas
app.use('views', express.static(__dirname + '/views'));

// para poder usar la carpeta donde tengamos ficheros (middleworld)
app.use(express.static(__dirname + '/public'))

// llamamos al fichero de las rutas
app.use('/', require('./router/rutas'));
app.use('/pokemon', require('./router/pokemon'));

app.get('/pruebas', (req, res) => {
  res.render('pruebas', {titulo:'Título dinámico'})
})

//Conexión a base de datos
const mongoose = require('mongoose');
const uri = `mongodb+srv://${process.env.USER}:${process.env.PASSWORD}@clase.xq89gc1.mongodb.net/${process.env.DBNAME}?retryWrites=true&w=majority`;
mongoose.connect(uri)
  .then(() => console.log('Base de datos conectada'))
  .catch(e => console.log(e))

app.use((req, res) => {
  res.status(404).sendFile(__dirname + "/public/html/404.html")
})

app.listen(port, () => {
  console.log(`Example app listening on port ${port}`)
})
```

---

## 2. Crear la aplicación Angular

### 2.1 Instalar Angular CLI (si no lo tienes)
```bash
npm install -g @angular/cli
```

### 2.2 Crear nuevo proyecto Angular
```bash
ng new pokemon-angular
# Cuando pregunte:
# - Would you like to add Angular routing? → YES
# - Which stylesheet format would you like to use? → CSS
```

### 2.3 Navegar al proyecto
```bash
cd pokemon-angular
```

### 2.4 Instalar Bootstrap
```bash
npm install bootstrap
```

Agrega Bootstrap en `angular.json`:

Busca la sección `"styles"` en `projects > pokemon-angular > architect > build > options` y modifícala:

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

## 3. Estructura del proyecto Angular

La aplicación tendrá:
- **Servicio**: Para comunicarse con la API
- **Modelo**: Interface de Pokemon
- **Componentes**:
  - Lista de Pokemon (listado)
  - Crear Pokemon
  - Editar Pokemon

---

## 4. Ejecutar el proyecto

### Backend (Node.js/Express):
```bash
npm run dev
# O
node 01-express.js
```
Debería correr en: `http://localhost:3000`

### Frontend (Angular):
```bash
ng serve
# O para abrir automáticamente el navegador:
ng serve --open
```
Debería correr en: `http://localhost:4200`

---

## 📁 Archivos a crear en Angular

Los archivos están en la carpeta adjunta con la siguiente estructura:

```
pokemon-angular/
├── src/
│   ├── app/
│   │   ├── models/
│   │   │   └── pokemon.model.ts
│   │   ├── services/
│   │   │   └── pokemon.service.ts
│   │   ├── components/
│   │   │   ├── pokemon-list/
│   │   │   ├── pokemon-create/
│   │   │   └── pokemon-edit/
│   │   ├── app.component.ts
│   │   ├── app.component.html
│   │   ├── app.component.css
│   │   └── app.routes.ts
│   └── environments/
│       └── environment.ts
```

Los archivos individuales están adjuntos.
