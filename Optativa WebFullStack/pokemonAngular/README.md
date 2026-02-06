# 🎮 Proyecto Pokemon CRUD - Node.js + Angular

Este proyecto contiene una aplicación CRUD completa de Pokémon con dos partes:

1. **Backend (Node.js/Express/MongoDB)** - API REST
2. **Frontend (Angular)** - Interfaz de usuario moderna

---

## 📦 Contenido

```
📁 proyecto-pokemon/
├── 📁 angular-app/              # Aplicación frontend de Angular
│   ├── 📁 src/
│   │   ├── 📁 app/
│   │   │   ├── 📁 models/
│   │   │   ├── 📁 services/
│   │   │   ├── 📁 components/
│   │   │   └── ...
│   │   └── 📁 environments/
│   ├── angular.json
│   ├── package.json
│   └── tsconfig.json
│
├── 📁 backend-actualizado/      # Backend actualizado con CORS
│   └── 01-express.js
│
├── 📄 INSTRUCCIONES.md          # Instrucciones detalladas
├── 📄 GUIA-RAPIDA.md           # Guía rápida de inicio
└── 📄 README.md                # Este archivo
```

---

## 🚀 Inicio Rápido

### 1️⃣ Backend (Ya lo tienes)
```bash
# En tu proyecto Node.js actual
npm install cors
# Actualiza 01-express.js con el contenido de backend-actualizado/
npm run dev
```

### 2️⃣ Frontend (Nuevo)
```bash
# Crear proyecto Angular
ng new pokemon-angular

# Entrar al proyecto
cd pokemon-angular

# Copiar los archivos de angular-app/ a pokemon-angular/

# Instalar dependencias
npm install bootstrap

# Ejecutar
ng serve --open
```

---

## 📚 Documentación

- **GUIA-RAPIDA.md** → Pasos rápidos para empezar
- **INSTRUCCIONES.md** → Guía completa paso a paso

---

## 🔧 Tecnologías Utilizadas

### Backend
- Node.js
- Express.js
- MongoDB + Mongoose
- Body Parser
- CORS
- dotenv

### Frontend
- Angular 18
- TypeScript
- Bootstrap 5
- RxJS
- HttpClient

---

## ✨ Características

- ✅ **CRUD completo** (Create, Read, Update, Delete)
- ✅ **Diseño responsive** con Bootstrap
- ✅ **Validación de formularios**
- ✅ **Manejo de errores**
- ✅ **Loading states**
- ✅ **Confirmaciones de eliminación**
- ✅ **Navegación intuitiva**
- ✅ **Separación de responsabilidades** (Modelo-Vista-Servicio)

---

## 🎯 Endpoints de la API

| Método | Endpoint | Descripción |
|--------|----------|-------------|
| GET | `/pokemon` | Obtener todos los pokemon |
| GET | `/pokemon/:id` | Obtener un pokemon por ID |
| POST | `/pokemon` | Crear un nuevo pokemon |
| PUT | `/pokemon/:id` | Actualizar un pokemon |
| DELETE | `/pokemon/:id` | Eliminar un pokemon |

---

## 🌐 URLs

- **Backend API**: http://localhost:3000
- **Frontend Angular**: http://localhost:4200

---

## 📸 Capturas

La aplicación incluye:
- 📋 Lista de Pokemon con tabla
- ➕ Formulario para crear Pokemon
- ✏️ Formulario para editar Pokemon
- 🗑️ Botón para eliminar con confirmación

---

## 🆘 Soporte

Si tienes problemas:
1. Lee **GUIA-RAPIDA.md** → Sección de Solución de Problemas
2. Lee **INSTRUCCIONES.md** → Documentación completa
3. Verifica que:
   - Node.js y npm están instalados
   - Angular CLI está instalado (`npm install -g @angular/cli`)
   - MongoDB está corriendo
   - Puertos 3000 y 4200 están libres

---

## 📝 Notas

- Este proyecto es la migración de tu aplicación EJS a Angular
- El backend sigue siendo el mismo (con CORS agregado)
- Puedes tener ambas aplicaciones corriendo simultáneamente
- La aplicación Angular consume la misma API REST

---

## 🎓 Aprendizaje

Este proyecto demuestra:
- Arquitectura cliente-servidor
- API REST
- Single Page Application (SPA)
- Comunicación HTTP asíncrona
- Programación reactiva con RxJS
- Componentes standalone de Angular
- TypeScript
- Routing en Angular

---

**¡Buena suerte con tu proyecto! 🚀**
