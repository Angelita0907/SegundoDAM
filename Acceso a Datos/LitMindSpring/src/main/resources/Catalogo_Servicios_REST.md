# Catálogo de Servicios REST - LitMind Simplificado

---

## 📑 SERVICIOS DE ESTUDIANTES

### 1. Listar todos los estudiantes
**Ruta URL:** `localhost:8084/litmind/estudiantes`  
**Método:** GET  
**Entrada:** Ninguna  
**Modo de Acceso:** Navegador, Postman, enlace desde index  
**Formato Respuesta:** HTML (vista lista de estudiantes)  
**Código Respuesta:** 200 OK  
**Descripción:** Muestra una página HTML con la lista completa de estudiantes, incluyendo nombre, email, nivel, puntos XP y estadísticas de lecturas.

---

### 2. Crear nuevo estudiante
**Ruta URL:** `localhost:8084/litmind/estudiantes`  
**Método:** POST  
**Entrada:** 
- **Body (form-data o JSON):**
  - `nombreCompleto` (String, requerido)
  - `email` (String, requerido, único)
  - `edad` (Integer, requerido)
  - `rol` (String: ESTUDIANTE, DOCENTE, FAMILIA, opcional)
**Modo de Acceso:** Formulario HTML, Postman  
**Formato Respuesta:** Redirección HTML a lista de estudiantes  
**Código Respuesta:** 
- 201 Created (éxito)
- 400 Bad Request (datos inválidos)
- 409 Conflict (email duplicado)
**Descripción:** Crea un nuevo estudiante en el sistema. El estudiante comienza con 0 puntos XP y nivel 1.

---

### 3. Buscar estudiante por ID
**Ruta URL:** `localhost:8084/litmind/estudiantes/{id}`  
**Método:** GET  
**Entrada:** 
- **Path Parameter:** `id` (Long)
**Modo de Acceso:** Navegador, Postman, enlace desde lista  
**Formato Respuesta:** HTML (vista perfil del estudiante)  
**Código Respuesta:** 
- 200 OK (encontrado)
- 404 Not Found (no existe)
**Descripción:** Muestra el perfil completo del estudiante con: datos personales, nivel, XP, progreso hacia el siguiente nivel, lecturas completadas, pendientes, y calificación promedio.

---

### 4. Buscar estudiante por email (API)
**Ruta URL:** `localhost:8084/api/estudiantes/email/{email}`  
**Método:** GET  
**Entrada:** 
- **Path Parameter:** `email` (String)
**Modo de Acceso:** Postman, AJAX  
**Formato Respuesta:** JSON  
**Código Respuesta:** 
- 200 OK (encontrado)
- 404 Not Found (no existe)
**Descripción:** Busca un estudiante por su email y retorna un JSON con sus datos.

**Ejemplo respuesta:**
```json
{
  "id": 1,
  "nombreCompleto": "Ana García Pérez",
  "email": "ana.garcia@estudiante.com",
  "edad": 15,
  "puntosXP": 350,
  "nivelActual": 4,
  "rol": "ESTUDIANTE",
  "lecturasCompletadas": 3,
  "lecturasPendientes": 2,
  "promedioCalificaciones": 8.7
}
```

---

### 5. Ranking de estudiantes
**Ruta URL:** `localhost:8084/litmind/estudiantes/ranking`  
**Método:** GET  
**Entrada:** Ninguna  
**Modo de Acceso:** Navegador, enlace desde index  
**Formato Respuesta:** HTML (tabla de ranking)  
**Código Respuesta:** 200 OK  
**Descripción:** Muestra una tabla HTML con el ranking de estudiantes ordenados por puntos XP de mayor a menor, con sus niveles y estadísticas.

---

### 6. Filtrar estudiantes por nivel
**Ruta URL:** `localhost:8084/litmind/estudiantes/nivel/{nivel}`  
**Método:** GET  
**Entrada:** 
- **Path Parameter:** `nivel` (Integer)
**Modo de Acceso:** Navegador, Postman  
**Formato Respuesta:** HTML (lista filtrada)  
**Código Respuesta:** 200 OK  
**Descripción:** Muestra los estudiantes que tienen un nivel específico o superior.

---

### 7. Actualizar nivel de estudiante
**Ruta URL:** `localhost:8084/litmind/estudiantes/{id}/nivel`  
**Método:** PUT  
**Entrada:** 
- **Path Parameter:** `id` (Long)
- **Body (JSON):**
  ```json
  {
    "puntosXP": 500
  }
  ```
**Modo de Acceso:** Postman  
**Formato Respuesta:** CADENA  
**Código Respuesta:** 
- 200 OK (actualizado)
- 404 Not Found (estudiante no existe)
**Descripción:** Actualiza los puntos XP del estudiante y recalcula automáticamente su nivel (cada 100 puntos = 1 nivel).

**Ejemplo respuesta:**
```
Puntos actualizados. Ana García Pérez ahora tiene 500 XP y está en el nivel 6
```

---

### 8. Eliminar estudiante
**Ruta URL:** `localhost:8084/litmind/estudiantes/{id}`  
**Método:** DELETE  
**Entrada:** 
- **Path Parameter:** `id` (Long)
**Modo de Acceso:** Postman, botón eliminar en interfaz  
**Formato Respuesta:** Redirección HTML  
**Código Respuesta:** 
- 200 OK (eliminado)
- 404 Not Found (no existe)
**Descripción:** Elimina un estudiante del sistema. Todas sus asignaciones también serán eliminadas (cascade).

---

## 📑 SERVICIOS DE LECTURAS

### 9. Listar todas las lecturas
**Ruta URL:** `localhost:8084/litmind/lecturas`  
**Método:** GET  
**Entrada:** Ninguna  
**Modo de Acceso:** Navegador, enlace desde index  
**Formato Respuesta:** HTML (vista catálogo de lecturas)  
**Código Respuesta:** 200 OK  
**Descripción:** Muestra una página HTML con todas las lecturas disponibles, incluyendo título, autor, género, dificultad, puntos que otorga y estadísticas de asignación.

---

### 10. Crear nueva lectura
**Ruta URL:** `localhost:8084/litmind/lecturas`  
**Método:** POST  
**Entrada:** 
- **Body (form-data):**
  - `titulo` (String, requerido)
  - `autor` (String, requerido)
  - `genero` (String, requerido)
  - `numeroPaginas` (Integer, opcional)
  - `dificultad` (String, opcional)
  - `puntosOtorgados` (Integer, opcional, default: 50)
  - `descripcion` (String, opcional)
**Modo de Acceso:** Formulario HTML, Postman  
**Formato Respuesta:** Redirección HTML a lista de lecturas  
**Código Respuesta:** 
- 201 Created
- 400 Bad Request (datos inválidos)
**Descripción:** Crea una nueva lectura en el catálogo. Si no se especifican puntos, otorga 50 por defecto.

---

### 11. Buscar lectura por ID
**Ruta URL:** `localhost:8084/litmind/lecturas/{id}`  
**Método:** GET  
**Entrada:** 
- **Path Parameter:** `id` (Long)
**Modo de Acceso:** Navegador, Postman  
**Formato Respuesta:** HTML (vista detalle de lectura)  
**Código Respuesta:** 
- 200 OK
- 404 Not Found
**Descripción:** Muestra el detalle completo de una lectura, incluyendo todas sus asignaciones, tasa de completación y calificación promedio.

---

### 12. Buscar lecturas por título o autor (API)
**Ruta URL:** `localhost:8084/api/lecturas/buscar`  
**Método:** GET  
**Entrada:** 
- **Query Parameter:** `q` (String) - término de búsqueda
**Modo de Acceso:** Postman, AJAX para autocompletar  
**Formato Respuesta:** JSON (array de lecturas)  
**Código Respuesta:** 200 OK  
**Descripción:** Busca lecturas cuyo título o autor contenga el término de búsqueda.

**Ejemplo respuesta:**
```json
[
  {
    "id": 1,
    "titulo": "Cien años de soledad",
    "autor": "Gabriel García Márquez",
    "genero": "FICCION",
    "puntosOtorgados": 100
  }
]
```

---

### 13. Filtrar lecturas por género
**Ruta URL:** `localhost:8084/litmind/lecturas/genero/{genero}`  
**Método:** GET  
**Entrada:** 
- **Path Parameter:** `genero` (String: FICCION, FANTASIA, CIENCIA_FICCION, etc.)
**Modo de Acceso:** Navegador, Postman  
**Formato Respuesta:** HTML (lista filtrada)  
**Código Respuesta:** 200 OK  
**Descripción:** Muestra todas las lecturas de un género específico.

---

### 14. Filtrar lecturas por dificultad
**Ruta URL:** `localhost:8084/litmind/lecturas/dificultad/{dificultad}`  
**Método:** GET  
**Entrada:** 
- **Path Parameter:** `dificultad` (String: FACIL, MEDIO, DIFICIL, MUY_DIFICIL)
**Modo de Acceso:** Navegador, Postman  
**Formato Respuesta:** HTML (lista filtrada)  
**Código Respuesta:** 200 OK  
**Descripción:** Muestra todas las lecturas de una dificultad específica.

---

### 15. Actualizar puntos de una lectura
**Ruta URL:** `localhost:8084/litmind/lecturas/{id}/puntos`  
**Método:** PUT  
**Entrada:** 
- **Path Parameter:** `id` (Long)
- **Body (JSON):**
  ```json
  {
    "puntosOtorgados": 120
  }
  ```
**Modo de Acceso:** Postman  
**Formato Respuesta:** CADENA  
**Código Respuesta:** 
- 200 OK
- 404 Not Found
**Descripción:** Actualiza la cantidad de puntos XP que otorga una lectura al completarse.

**Ejemplo respuesta:**
```
Puntos actualizados. "Cien años de soledad" ahora otorga 120 puntos XP
```

---

### 16. Lecturas más populares (API)
**Ruta URL:** `localhost:8084/api/lecturas/populares`  
**Método:** GET  
**Entrada:** Ninguna  
**Modo de Acceso:** Postman, AJAX  
**Formato Respuesta:** JSON  
**Código Respuesta:** 200 OK  
**Descripción:** Retorna las 10 lecturas más asignadas con sus estadísticas.

**Ejemplo respuesta:**
```json
[
  {
    "id": 1,
    "titulo": "Cien años de soledad",
    "autor": "Gabriel García Márquez",
    "totalAsignaciones": 15,
    "totalCompletadas": 12,
    "calificacionPromedio": 9.1,
    "tasaCompletacion": 80.0
  }
]
```

---

### 17. Eliminar lectura
**Ruta URL:** `localhost:8084/litmind/lecturas/{id}`  
**Método:** DELETE  
**Entrada:** 
- **Path Parameter:** `id` (Long)
**Modo de Acceso:** Postman  
**Formato Respuesta:** Redirección HTML  
**Código Respuesta:** 
- 200 OK
- 404 Not Found
**Descripción:** Elimina una lectura del catálogo. Todas las asignaciones relacionadas también serán eliminadas.

---

## 📑 SERVICIOS DE ASIGNACIONES

### 18. Listar todas las asignaciones
**Ruta URL:** `localhost:8084/litmind/asignaciones`  
**Método:** GET  
**Entrada:** Ninguna  
**Modo de Acceso:** Navegador, enlace desde index  
**Formato Respuesta:** HTML (vista lista de asignaciones)  
**Código Respuesta:** 200 OK  
**Descripción:** Muestra una tabla HTML con todas las asignaciones, incluyendo estudiante, lectura, estado, progreso y docente.

---

### 19. Asignar lectura a estudiante
**Ruta URL:** `localhost:8084/litmind/asignaciones`  
**Método:** POST  
**Entrada:** 
- **Body (JSON):**
  ```json
  {
    "estudianteId": 1,
    "lecturaId": 5,
    "nombreDocente": "Prof. Martínez",
    "fechaLimite": "2024-04-30",
    "esObligatoria": true
  }
  ```
**Modo de Acceso:** Postman, formulario HTML  
**Formato Respuesta:** JSON  
**Código Respuesta:** 
- 201 Created
- 400 Bad Request (datos inválidos)
- 409 Conflict (asignación duplicada)
**Descripción:** Asigna una lectura a un estudiante. Verifica que no exista ya una asignación de esa lectura para ese estudiante.

**Ejemplo respuesta:**
```json
{
  "id": 42,
  "estudianteNombre": "Ana García Pérez",
  "lecturaTitulo": "El principito",
  "estado": "PENDIENTE",
  "fechaAsignacion": "2024-02-16",
  "mensaje": "Lectura asignada exitosamente"
}
```

---

### 20. Ver asignaciones de un estudiante
**Ruta URL:** `localhost:8084/litmind/asignaciones/estudiante/{estudianteId}`  
**Método:** GET  
**Entrada:** 
- **Path Parameter:** `estudianteId` (Long)
**Modo de Acceso:** Navegador, Postman  
**Formato Respuesta:** HTML (tabla de asignaciones)  
**Código Respuesta:** 
- 200 OK
- 404 Not Found (estudiante no existe)
**Descripción:** Muestra todas las asignaciones de un estudiante específico con sus estados y progresos.

---

### 21. Ver asignaciones de una lectura
**Ruta URL:** `localhost:8084/litmind/asignaciones/lectura/{lecturaId}`  
**Método:** GET  
**Entrada:** 
- **Path Parameter:** `lecturaId` (Long)
**Modo de Acceso:** Navegador, Postman  
**Formato Respuesta:** HTML (tabla de estudiantes)  
**Código Respuesta:** 
- 200 OK
- 404 Not Found (lectura no existe)
**Descripción:** Muestra todos los estudiantes que tienen asignada una lectura específica, con sus estados de progreso.

---

### 22. Actualizar progreso de lectura
**Ruta URL:** `localhost:8084/litmind/asignaciones/{id}/progreso`  
**Método:** PUT  
**Entrada:** 
- **Path Parameter:** `id` (Long)
- **Body (JSON):**
  ```json
  {
    "progreso": 75
  }
  ```
**Modo de Acceso:** Postman  
**Formato Respuesta:** CADENA  
**Código Respuesta:** 
- 200 OK
- 404 Not Found
- 400 Bad Request (progreso inválido)
**Descripción:** Actualiza el progreso de una asignación (0-100). El estado se actualiza automáticamente según el progreso.

**Ejemplo respuesta:**
```
Progreso actualizado a 75%. Estado: EN_PROGRESO
```

---

### 23. Completar lectura
**Ruta URL:** `localhost:8084/litmind/asignaciones/{id}/completar`  
**Método:** PUT  
**Entrada:** 
- **Path Parameter:** `id` (Long)
**Modo de Acceso:** Postman, botón en interfaz  
**Formato Respuesta:** JSON  
**Código Respuesta:** 
- 200 OK
- 404 Not Found
- 400 Bad Request (ya completada)
**Descripción:** Marca la lectura como completada, actualiza progreso a 100% y **otorga automáticamente los puntos XP al estudiante**.

**Ejemplo respuesta:**
```json
{
  "mensaje": "Lectura completada exitosamente",
  "puntosOtorgados": 100,
  "estudianteNombre": "Ana García Pérez",
  "nuevoPuntosXP": 450,
  "nuevoNivel": 5
}
```

---

### 24. Calificar asignación
**Ruta URL:** `localhost:8084/litmind/asignaciones/{id}/calificar`  
**Método:** PUT  
**Entrada:** 
- **Path Parameter:** `id` (Long)
- **Body (JSON):**
  ```json
  {
    "calificacion": 9.5,
    "comentarioDocente": "Excelente análisis de la obra"
  }
  ```
**Modo de Acceso:** Postman  
**Formato Respuesta:** CADENA  
**Código Respuesta:** 
- 200 OK
- 404 Not Found
- 400 Bad Request (calificación inválida)
**Descripción:** Asigna una calificación (0-10) y comentario del docente a una asignación completada.

**Ejemplo respuesta:**
```
Calificación registrada: 9.5/10. Comentario agregado.
```

---

### 25. Filtrar asignaciones por estado (API)
**Ruta URL:** `localhost:8084/api/asignaciones/estado/{estado}`  
**Método:** GET  
**Entrada:** 
- **Path Parameter:** `estado` (String: PENDIENTE, EN_PROGRESO, COMPLETADA, etc.)
**Modo de Acceso:** Postman, AJAX  
**Formato Respuesta:** JSON  
**Código Respuesta:** 200 OK  
**Descripción:** Retorna todas las asignaciones que tienen un estado específico.

**Ejemplo respuesta:**
```json
[
  {
    "id": 15,
    "estudianteNombre": "Ana García Pérez",
    "lecturaTitulo": "El Quijote",
    "estado": "EN_PROGRESO",
    "progreso": 60,
    "fechaLimite": "2024-04-16"
  }
]
```

---

### 26. Ver asignaciones vencidas
**Ruta URL:** `localhost:8084/litmind/asignaciones/vencidas`  
**Método:** GET  
**Entrada:** Ninguna  
**Modo de Acceso:** Navegador, Postman  
**Formato Respuesta:** HTML (tabla de advertencia)  
**Código Respuesta:** 200 OK  
**Descripción:** Muestra todas las asignaciones que han pasado su fecha límite y aún no están completadas.

---

### 27. Eliminar asignación
**Ruta URL:** `localhost:8084/litmind/asignaciones/{id}`  
**Método:** DELETE  
**Entrada:** 
- **Path Parameter:** `id` (Long)
**Modo de Acceso:** Postman  
**Formato Respuesta:** CADENA  
**Código Respuesta:** 
- 200 OK
- 404 Not Found
**Descripción:** Elimina una asignación del sistema.

---

## 📑 SERVICIOS GENERALES

### 28. Página principal (Home)
**Ruta URL:** `localhost:8084/litmind/`  
**Método:** GET  
**Entrada:** Ninguna  
**Modo de Acceso:** Navegador  
**Formato Respuesta:** HTML (dashboard)  
**Código Respuesta:** 200 OK  
**Descripción:** Dashboard principal con estadísticas generales: total de estudiantes, lecturas, asignaciones completadas, top 5 estudiantes, lecturas más populares, etc.

---

### 29. Estadísticas generales (API)
**Ruta URL:** `localhost:8084/api/estadisticas`  
**Método:** GET  
**Entrada:** Ninguna  
**Modo de Acceso:** Postman, AJAX  
**Formato Respuesta:** JSON  
**Código Respuesta:** 200 OK  
**Descripción:** Retorna estadísticas globales del sistema.

**Ejemplo respuesta:**
```json
{
  "totalEstudiantes": 50,
  "totalLecturas": 100,
  "totalAsignaciones": 320,
  "totalCompletadas": 215,
  "promedioCalificacionGlobal": 8.4,
  "estudianteNivel10": 5,
  "tasaCompletacionGlobal": 67.2
}
```

---

### 30. Página de error personalizada
**Ruta URL:** `localhost:8084/litmind/error`  
**Método:** GET  
**Entrada:** Query parameters opcionales  
**Modo de Acceso:** Redirección automática  
**Formato Respuesta:** HTML (página de error)  
**Código Respuesta:** Variable  
**Descripción:** Página de error personalizada sin información técnica.

---

## 🔐 RESUMEN DE CÓDIGOS HTTP

| Código | Significado | Uso en el proyecto |
|--------|-------------|-------------------|
| **200 OK** | Éxito | Consultas y actualizaciones exitosas |
| **201 Created** | Recurso creado | Estudiante, lectura o asignación creados |
| **400 Bad Request** | Solicitud incorrecta | Datos inválidos, validaciones fallidas |
| **404 Not Found** | Recurso no encontrado | ID no existe en la BD |
| **409 Conflict** | Conflicto | Email duplicado, asignación duplicada |
| **500 Internal Server Error** | Error del servidor | Errores inesperados |

---

## 🎯 NAVEGACIÓN DE LA APLICACIÓN

```
Dashboard (/)
├── Estudiantes (/estudiantes)
│   ├── Ver perfil (/estudiantes/{id})
│   ├── Crear nuevo (POST /estudiantes)
│   ├── Ranking (/estudiantes/ranking)
│   └── Filtrar por nivel (/estudiantes/nivel/{nivel})
│
├── Lecturas (/lecturas)
│   ├── Ver detalle (/lecturas/{id})
│   ├── Crear nueva (POST /lecturas)
│   ├── Filtrar por género (/lecturas/genero/{genero})
│   └── Filtrar por dificultad (/lecturas/dificultad/{dif})
│
└── Asignaciones (/asignaciones)
    ├── Asignar lectura (POST /asignaciones)
    ├── Por estudiante (/asignaciones/estudiante/{id})
    ├── Por lectura (/asignaciones/lectura/{id})
    ├── Actualizar progreso (PUT /asignaciones/{id}/progreso)
    ├── Completar (PUT /asignaciones/{id}/completar)
    ├── Calificar (PUT /asignaciones/{id}/calificar)
    └── Vencidas (/asignaciones/vencidas)
```

---

## 🛠️ EXCEPCIONES PERSONALIZADAS A GESTIONAR

1. **EstudianteNotFoundException** → 404 Not Found
2. **LecturaNotFoundException** → 404 Not Found
3. **AsignacionNotFoundException** → 404 Not Found
4. **EmailDuplicadoException** → 409 Conflict
5. **AsignacionDuplicadaException** → 409 Conflict
6. **DatoInvalidoException** → 400 Bad Request
7. **ProgresInvalidoException** → 400 Bad Request
8. **CalificacionInvalidaException** → 400 Bad Request
9. **AsignacionYaCompletadaException** → 400 Bad Request

---

## 📝 NOTAS IMPORTANTES

1. Al completar una lectura (servicio 23), se otorgan **automáticamente** los puntos XP al estudiante.
2. El nivel del estudiante se **recalcula automáticamente** al actualizar sus puntos XP (cada 100 puntos = 1 nivel).
3. El estado de la asignación se **actualiza automáticamente** al cambiar el progreso:
   - 0% → PENDIENTE
   - 1-99% → EN_PROGRESO
   - 100% → COMPLETADA
4. Las asignaciones con fecha límite pasada y no completadas se marcan como "vencidas" en la vista.
5. No es necesario una tabla de Logros; se calculan dinámicamente en base a XP y lecturas completadas.
